# assert-p4

Translate a P4 program to [SEFL](https://github.com/nets-cs-pub-ro/Symnet) from its *json* file:

`python src/P4_to_SEFL.py <filename>.json`

Translate a P4 program to a C model to be executed by [klee](https://github.com/klee/klee) from its *json* file:

`python src/P4_to_C.py <filename>.json`

The json representations are obtained from the bmv2 backend of the [p4c](https://github.com/p4lang/p4c) compiler. To generate a json file, you need to build p4c and run:

`p4c/build/p4c-bm2-ss <input-filename>.p4 --toJSON <output-filename>.json`