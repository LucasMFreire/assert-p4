import os
import sys
import errno

def make_sure_path_exists(path):
    try:
        os.makedirs(path)
    except OSError as exception:
        if exception.errno != errno.EEXIST:
            raise

filename = sys.argv[1]

with open(filename) as f:
    assertion_line_numbers = []
    lines = []
    for num, line in enumerate(f):
        if "\t//if(!" in line:
            assertion_line_numbers.append(num)
        lines.append(line)

    make_sure_path_exists("single-assertion-models")
    for assertion in assertion_line_numbers:
        new_model = lines[:]
        new_model[assertion] = "\t" + new_model[assertion][3:]
        new_file_name = "single-assertion-models/" + filename[:-2] + "_" + str(assertion + 1) + ".c"
        new_model_file = open(new_file_name, 'w')
        for line in new_model:
            new_model_file.write("%s" % line)
        new_model_file.close()
        sliced_file_name = new_file_name[:-2] + "-sliced.c"
        frama_c = "frama-c -slice-calls assert_error " + new_file_name + " -then-on 'Slicing export' -print -ocode " + sliced_file_name + " > /dev/null"
        os.system(frama_c) 
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
            os.system("llvm-gcc -I ../../include -emit-llvm -c -g " + processed_file_name)
            os.system("klee --search=dfs --no-output " + processed_file_name[:-1] + "o")
