import os
import sys
import errno
from concurrent import futures
import time

def make_sure_path_exists(path):
    try:
        os.makedirs(path)
    except OSError as exception:
        if exception.errno != errno.EEXIST:
            raise

def run_klee_34(filename):
    os.system("clang -I ../../include -emit-llvm -O3 -g " + filename + " > /dev/null")
    # -optimize -output-stats=off -warnings-only-to-file 
    os.system("/home/osboxes/klee-3.4/klee_build_dir/bin/klee --search=dfs --no-output " + filename[:-1] + "o > " + filename[:-1] + "-results.txt")

def run_klee(filename):
    os.system("llvm-gcc -I ../../include -emit-llvm -c -g " + filename + " > /dev/null")
    # -optimize -output-stats=off -warnings-only-to-file 
    os.system("klee --search=dfs --no-output -optimize -solver-optimize-divides -use-forked-solver -use-cache -use-cex-cache  -use-independent-solver " + filename[:-1] + "o > " + filename[:-1] + "-results.txt")

def slice_model(filename):
    sliced_file_name = filename[:-2] + "-sliced.c"
    frama_c = "frama-c -slice-calls assert_error " + filename + " -then-on 'Slicing export' -print -ocode " + sliced_file_name + " > /dev/null"
    os.system(frama_c)
    return sliced_file_name

def verify_assertion(assertion, lines, filename):
    new_model = lines[:]
    new_model[assertion] = "\t" + new_model[assertion][3:]
    new_file_name = filename[:-2] + "_" + str(assertion + 1) + ".c"
    new_model_file = open(new_file_name, 'w')
    for line in new_model:
        new_model_file.write("%s" % line)
    new_model_file.close()
    sliced_file_name = slice_model(new_file_name)
    with open(sliced_file_name) as slicedfile:
        processed_file_name = sliced_file_name[:-2] + "-processed.c"
        processed_file = open(processed_file_name, 'w')
        for line in slicedfile:
            processed_file.write("%s" % line)
            if "end_assertions_slice_1();" in line:
                processed_file.write("\texit(0);\n")
            elif "void assert_error_slice_1(void)" in line:
                processed_file.write("{\n\tprintf(" + new_model[assertion].split("assert_error(")[1][:-3] + ");\n\tklee_abort();")
                slicedfile.next()
                continue
        processed_file.close()
        run_klee_34(processed_file_name)

def parallel_checking(filename):
    with open(filename) as f:
        assertion_line_numbers = []
        lines = []
        for num, line in enumerate(f):
            if "\t//if(!" in line:
                assertion_line_numbers.append(num)
            lines.append(line)
        make_sure_path_exists("single-assertion-models")
        os.chdir("single-assertion-models")
        executor = futures.ProcessPoolExecutor(len(assertion_line_numbers))
        ft = [executor.submit(verify_assertion, assertion, lines, filename) for assertion in assertion_line_numbers]
        futures.wait(ft)

def check_model(filename):
    with open(filename) as f:
        make_sure_path_exists("multi-assertion-model")
        os.chdir("multi-assertion-model")
        new_file_name = filename[:-2] + "_assertions.c"
        new_model_file = open(new_file_name, 'w')
        for line in f:
            if "\t//if(!" in line:
                line = "\t" + line[3:]
            new_model_file.write("%s" % line)
        new_model_file.close()
        sliced_file_name = slice_model(new_file_name)
        with open(sliced_file_name) as slicedfile:
            processed_file_name = sliced_file_name[:-2] + "-processed.c"
            processed_file = open(processed_file_name, 'w')
            for line in slicedfile:
                processed_file.write("%s" % line)
                if "end_assertions_slice_1();" in line:
                    processed_file.write("\texit(0);\n")
                #TODO: fix assertion messages
                elif "void assert_error_slice_1(void)" in line:
                    processed_file.write("{\n\tprintf(\"assertion error\");")
                    slicedfile.next()
                    continue
            processed_file.close()
            run_klee_34(processed_file_name)
        
def no_slice(filename):
    with open(filename) as f:
        new_file_name = filename[:-2] + "_assertions.c"
        new_model_file = open(new_file_name, 'w')
        for line in f:
            if "\t//if(!" in line:
                line = "\t" + line[3:]
            new_model_file.write("%s" % line)
        new_model_file.close()
        run_klee_34(new_file_name)

def reduction(total, optimized):
    return " reduction: " + str((total - optimized) * 100 / total) + "%"
        

start = time.time()
#parallel_checking(sys.argv[1])
end = time.time()
parallel_time = end - start

os.chdir("..")
start = time.time()
check_model(sys.argv[1])
end = time.time()
nonparallel_time = end - start

os.chdir("..")
start = time.time()
no_slice(sys.argv[1])
end = time.time()
noslice_time = end - start

print "\n\nNoslice: " + str(noslice_time)
print "Nonparallel: " + str(nonparallel_time) + reduction(noslice_time, nonparallel_time)
print "Parallel: " + str(parallel_time) + reduction(noslice_time, parallel_time)