STARTTIME=$(date +%s)

llvm-gcc -I ../../include -emit-llvm -c -g dapper.c
klee --search=dfs --warnings-only-to-file --no-output dapper.o

ENDTIME=$(date +%s)
ELAPSED_TIME=$(($ENDTIME - $STARTTIME))

echo $1 $ELAPSED_TIME >> stats.txt
