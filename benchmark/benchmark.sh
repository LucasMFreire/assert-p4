now=$(date +"%T")
mkdir $now
cd $now
p4benchmark --feature "$@"
/home/$USER/p4c/build/p4test --pp out.p4 --p4-14 output/main.p4
/home/$USER/p4c/build/p4c-bm2-ss out.p4 --toJSON file.json
python ../../src/P4_to_C.py file.json > benchmark_model.c
cd ..