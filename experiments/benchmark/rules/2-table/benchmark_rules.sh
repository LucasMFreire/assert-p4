cwd=$(pwd)
now=$(date +"%T")
mkdir $now
cd $now

mkdir -p commands
python ../generate_rules.py $1 
rules="commands/commands_$1.txt"

python /home/$USER/Desktop/assert-p4/src/P4_to_C.py ../file.json $rules > benchmark_model.c

STARTTIME=$(date +%s)
llvm-gcc -I ../../include -emit-llvm -c -g -O3 benchmark_model.c
klee --search=dfs --warnings-only-to-file --no-output benchmark_model.o
ENDTIME=$(date +%s)

ELAPSED_TIME=$(($ENDTIME - $STARTTIME))

cd $cwd

echo $1 $ELAPSED_TIME >> result_rules.txt
