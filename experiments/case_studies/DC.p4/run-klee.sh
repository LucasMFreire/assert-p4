STARTTIME=$(date +%s)

llvm-gcc -I ../../include -emit-llvm -c -g dcp4.c
klee --search=dfs --warnings-only-to-file --no-output dcp4.o

ENDTIME=$(date +%s)
ELAPSED_TIME=$(($ENDTIME - $STARTTIME))

echo $1 $ELAPSED_TIME >> stats.txt
