
STARTTIME=$(date +%s)

llvm-gcc -I ../../include -emit-llvm -c -g VSS_case_study.c
klee --search=dfs --warnings-only-to-file --no-output VSS_case_study.o

ENDTIME=$(date +%s)
ELAPSED_TIME=$(($ENDTIME - $STARTTIME))

echo $1 $ELAPSED_TIME >> stats.txt
