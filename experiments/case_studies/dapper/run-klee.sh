STARTTIME=$(date +%s)

llvm-gcc -I ../../include -emit-llvm -c -g $1.c
klee --search=dfs --no-output $1.o

ENDTIME=$(date +%s)
ELAPSED_TIME=$(($ENDTIME - $STARTTIME))

echo $1 $ELAPSED_TIME >> stats.txt
