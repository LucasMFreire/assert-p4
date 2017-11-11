STARTTIME=$(date +%s)

llvm-gcc -I ../../include -emit-llvm -c -g dapper-assert.c
klee --search=dfs --no-output dapper-assert.o

ENDTIME=$(date +%s)
ELAPSED_TIME=$(($ENDTIME - $STARTTIME))

echo $1 $ELAPSED_TIME >> stats.txt
