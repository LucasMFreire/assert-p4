now=$(date +"%T")
mkdir $now
cd $now
p4benchmark --feature pipeline --tables $1 --table-size 32

STARTTIME=$(date +%s)

/home/$USER/p4c/build/p4test --pp out.p4 --p4-14 output/main.p4
/home/$USER/p4c/build/p4c-bm2-ss out.p4 --toJSON file.json
python ../../src/P4_to_C.py file.json > benchmark_model.c
llvm-gcc -I ../../include -emit-llvm -c -g benchmark_model.c
klee --search=dfs --warnings-only-to-file --no-output benchmark_model.o

ENDTIME=$(date +%s)
ELAPSED_TIME=$(($ENDTIME - $STARTTIME))

cd ..
echo $1 $ELAPSED_TIME >> result_tables.txt

