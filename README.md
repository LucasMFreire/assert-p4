# assert-p4

To translate a P4 program to a C model to be executed by [klee](https://github.com/klee/klee) from its *json* file:

`python src/P4_to_C.py <filename>.json`

The json representations are obtained from the bmv2 backend of the [p4c](https://github.com/p4lang/p4c) compiler. To generate a json file, you need to build p4c and run:

`p4c/build/p4c-bm2-ss <input-filename>.p4 --toJSON <output-filename>.json`

## Experiments

The experiments folder is organized into a benchmark and a case\_studies folder.

There are 4 different benchmarks: Tables, Actions, Rules, and Assertions. Each one is contained in its own subfolder, which has the appropriate scripts to generate the programs, execute the experiment, and create gnuplot graphs. The gen\_parallel.py script is used to create submodels for parallelization. The parallel\_benchmark.py script can be used to execute all benchmarks with and without optimizations.

Each case study folder contains the used C models and scripts to execute them. You can also find C models with constraint optimizations, submodels for parallelization, and their combination. The run\_klee.sh scripts are used to execute the single threaded models, and the parallel\_klee.sh scripts are used to run the submodels concurrently. 

