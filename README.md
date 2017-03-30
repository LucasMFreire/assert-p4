# PHI: Packet Header Integrity Verifier

**Translate** a P4 program to [SEFL](https://github.com/nets-cs-pub-ro/Symnet) from its *json* file:

`python src/P4_to_SEFL.py <filename>.json`

The folder *testdata* contains sample P4 programs with their json files. To translate *testdata/action_param.p4* execute:

`python src/P4_to_SEFL.py testdata/action_param.json`

The json representations are obtained from the *p4test* backend of the [p4c](https://github.com/p4lang/p4c) compiler. They include some compiler optimizations. You can check the optimized P4 code of the sample programs in their corresponding *testdata/filename [compiled].p4* files.
