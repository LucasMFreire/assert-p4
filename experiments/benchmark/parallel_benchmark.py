import subprocess
import gen_parallel
import getpass
from multiprocessing import Pool
import time
import os
import re
import shutil
import zipfile
import tinyurl

def removeExtensionNames(submodels):
    returnArray = []
    for submodel in submodels:
        returnArray.append(submodel.split(".")[0])
    return returnArray

def zipdir(path, ziph):
    # ziph is zipfile handle
    for root, dirs, files in os.walk(path):
        for file in files:
            ziph.write(os.path.join(root, file))

def tryint(s):
    try:
        return int(s)
    except:
        return s

def alphanum_key(s):
    """ Turn a string into a list of string and number chunks.
        "z23a" -> ["z", 23, "a"]
    """
    return [ tryint(c) for c in re.split('([0-9]+)', s) ]


def run_klee(filename):
    subprocess.check_call(['clang -I ../../include -emit-llvm -g -c %s.c' % filename], shell = True)
    subprocess.check_call(['/home/osboxes/klee-3.4/klee_build_dir/bin/klee --search=dfs --warnings-only-to-file --no-output %s.bc' % filename.split(".")[0]], shell = True)

def run_opt_klee(filename):
    subprocess.check_call(['clang -I ../../include -emit-llvm -c -g -O3 %s.c' % filename], shell = True)
    subprocess.check_call(['/home/osboxes/klee-3.4/klee_build_dir/bin/klee --search=dfs --warnings-only-to-file --no-output %s.bc' % filename.split(".")[0]], shell = True)


def tables_benchmark(opt=False):
    for ntables in range(1, 24):
        dir_name = time.asctime()
        os.makedirs(dir_name)
        os.chdir(dir_name)
        subprocess.check_call(['p4benchmark --feature pipeline --tables %s --table-size 32' % ntables], shell = True)
        subprocess.check_call(['p4test --pp out.p4 --p4-14 output/main.p4'], shell = True)
        subprocess.check_call(['p4c-bm2-ss out.p4 --toJSON file.json'], shell = True)
        username = getpass.getuser()
        subprocess.check_call(['python /home/%s/Desktop/assert-p4/src/P4_to_C.py file.json > benchmark_model.c' % username], shell = True)
        start = time.time()
        if opt:
            run_opt_klee("benchmark_model")
        else:                
            run_klee("benchmark_model")
        end = time.time()
        elapsed = end - start
        os.chdir("..")
        dirtype = "bench_opt" if opt else "bench_unopt"
        with open("script_output/" + dirtype + "/result_tables.txt", "a") as myfile:
            myfile.write(str(ntables) + " " + str(int(elapsed)) + "\n")


def parallel_tables_benchmark():
    for ntables in range(1, 24):
        dir_name = time.asctime()
        os.makedirs(dir_name)
        os.chdir(dir_name)
        subprocess.check_call(['p4benchmark --feature pipeline --tables %s --table-size 32' % ntables], shell = True)
        subprocess.check_call(['p4test --pp out.p4 --p4-14 output/main.p4'], shell = True)
        subprocess.check_call(['p4c-bm2-ss out.p4 --toJSON file.json'], shell = True)
        username = getpass.getuser()
        subprocess.check_call(['python /home/%s/Desktop/assert-p4/src/P4_to_C.py file.json > benchmark_model.c' % username], shell = True)
        submodels = removeExtensionNames(gen_parallel.gen_parallel('benchmark_model.c', False,
 False))
        pool = Pool()  
        start = time.time()                 
        pool.map(run_klee, submodels)
        pool.close()
        pool.join()
        end = time.time()
        elapsed = end - start
        os.chdir("..")
        with open("script_output/bench_parallel/result_tables.txt", "a") as myfile:
            myfile.write(str(ntables) + " " + str(int(elapsed)) + "\n")


def actions_benchmark(opt=False):
    os.chdir("actions_number/action_tests")
    files = os.listdir('.')
    files.sort(key=alphanum_key)
    count = 2
    for filename in files:
        if ".c" in filename:
            start = time.time()                 
            if opt:
                run_opt_klee(filename.split(".")[0])
            else:                
                run_klee(filename.split(".")[0])
            end = time.time()
            elapsed = end - start
            dirtype = "bench_opt" if opt else "bench_unopt"
            with open("../../script_output/" + dirtype + "/actions.txt", "a") as myfile:
                myfile.write(str(count) + " " + str(int(elapsed)) + "\n")
            count += 1
    os.chdir("../..")


def parallel_actions_benchmark():
    os.chdir("actions_number/parallel")
    files = os.listdir('../action_tests')
    files.sort(key=alphanum_key)
    count = 2
    for filename in files:
        if ".c" in filename:
            submodels = removeExtensionNames(gen_parallel.gen_parallel('../action_tests/' + filename, True, False))
            pool = Pool()  
            start = time.time()                 
            pool.map(run_klee, submodels)
            pool.close()
            pool.join()
            end = time.time()
            elapsed = end - start
            os.chdir("..")
            shutil.rmtree("parallel")
            os.mkdir("parallel")
            os.chdir("parallel")
            with open("../../script_output/bench_parallel/actions.txt", "a") as myfile:
                myfile.write(str(count) + " " + str(int(elapsed)) + "\n")
            count += 1
    os.chdir("../..")

def assertions_benchmark(opt=False):
    os.chdir("assertion_number/symbolic_equality_tests")
    for nassertions in range(1, 25):
        start = time.time()                 
        if opt:
            run_opt_klee('main_model_fake_vars%s' % nassertions)
        else:                
            run_klee('main_model_fake_vars%s' % nassertions)
        end = time.time()
        elapsed = end - start
        dirtype = "bench_opt" if opt else "bench_unopt"
        with open("../../script_output/" + dirtype + "/symbolic_equality.txt", "a") as myfile:
            myfile.write(str(nassertions) + " " + str(int(elapsed)) + "\n")
    os.chdir("../..")

def parallel_assertions_benchmark():
    os.chdir("assertion_number/parallel")
    for nassertions in range(1, 25):
        submodels = removeExtensionNames(gen_parallel.gen_parallel('../symbolic_equality_tests/main_model_fake_vars%s.c' % nassertions, True, False))
        pool = Pool()  
        start = time.time()                 
        pool.map(run_klee, submodels)
        pool.close()
        pool.join()
        end = time.time()
        elapsed = end - start
        os.chdir("..")
        shutil.rmtree("parallel")
        os.mkdir("parallel")
        os.chdir("parallel")
        with open("../../script_output/bench_parallel/symbolic_equality.txt", "a") as myfile:
            myfile.write(str(nassertions) + " " + str(int(elapsed)) + "\n")
    os.chdir("../..")


def rules_benchmark(opt=False):
    os.chdir("rules/2-table/unopt")
    for nrules in range(1, 401):
        dir_name = time.asctime() + " " + str(nrules)
        os.makedirs(dir_name)
        os.chdir(dir_name)
        os.makedirs("commands")
        subprocess.check_call(['python ../../generate_rules.py %s' % nrules], shell = True)
        rules="commands/commands_%s.txt" % nrules
        username = getpass.getuser()
        command_string = 'python /home/'+ username + '/Desktop/assert-p4/src/P4_to_C.py ../../file.json '+ rules + ' > benchmark_model.c'
        subprocess.check_call([command_string], shell = True)
        start = time.time()
        if opt:
            run_opt_klee("benchmark_model")
        else:                       
            run_klee("benchmark_model")
        end = time.time()
        elapsed = end - start
        os.chdir("..")
        shutil.rmtree(dir_name)
        dirtype = "bench_opt" if opt else "bench_unopt"
        with open("../../../script_output/" + dirtype + "/result_rules.txt", "a") as myfile:
            myfile.write(str(nrules) + " " + str(int(elapsed)) + "\n")
    os.chdir("../../..")

def parallel_rules_benchmark():
    os.chdir("rules/2-table/parallel")
    for nrules in range(1, 401):
        dir_name = time.asctime() + " " + str(nrules)
        os.makedirs(dir_name)
        os.chdir(dir_name)
        os.makedirs("commands")
        subprocess.check_call(['python ../../generate_rules.py %s' % nrules], shell = True)
        rules="commands/commands_%s.txt" % nrules
        username = getpass.getuser()
        command_string = 'python /home/'+ username + '/Desktop/assert-p4/src/P4_to_C.py ../../file.json '+ rules + ' > benchmark_model.c'
        subprocess.check_call([command_string], shell = True)
        submodels = removeExtensionNames(gen_parallel.gen_parallel('benchmark_model.c', False, True))
        pool = Pool()  
        start = time.time()                 
        pool.map(run_klee, submodels)
        end = time.time()
        elapsed = end - start
        os.chdir("..")
        shutil.rmtree(dir_name)
        with open("../../../script_output/bench_parallel/result_rules.txt", "a") as myfile:
            myfile.write(str(nrules) + " " + str(int(elapsed)) + "\n")
    os.chdir("../../..")

#actions_benchmark()
actions_benchmark(True)
#parallel_actions_benchmark()

#rules_benchmark()
rules_benchmark(True)
#parallel_rules_benchmark()

#tables_benchmark()
tables_benchmark(True)
#parallel_tables_benchmark()

#assertions_benchmark()
assertions_benchmark(True)
#parallel_assertions_benchmark()

zipf = zipfile.ZipFile('results.zip', 'w', zipfile.ZIP_DEFLATED)
zipdir('script_output/', zipf)
zipf.close()
