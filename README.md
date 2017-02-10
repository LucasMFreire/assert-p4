#PHI: Packet Header Integrity Verifier

**Translate** a P4 program to [SEFL](https://github.com/nets-cs-pub-ro/Symnet) from its *json* file:

`python src/P4_to_SEFL.py <filename>.json`

The folder *testdata* contains sample P4 programs with their json files. To translate *testdata/action_param.p4* execute:

`python src/P4_to_SEFL.py testdata/action_param.json`

Each P4 program in *testdata* also has its representation after the [p4c](https://github.com/p4lang/p4c) compiler frontend and midend passes from *p4test* in the form of *testdata/filename [compiled].p4*