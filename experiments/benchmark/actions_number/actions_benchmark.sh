cd action_tests

count=2
for filename in `ls *.c | sort -V`; do
    llvm-gcc -I ../../include -emit-llvm -c -g -O3 "$filename"
    STARTTIME=$(date +%s)
    klee --search=dfs --warnings-only-to-file --no-output $(basename "$filename" .c).o
    ENDTIME=$(date +%s)
    ELAPSED_TIME=$(($ENDTIME - $STARTTIME))
    echo "$count" $ELAPSED_TIME >> ../actions.txt
    (( count++ ))
done

cd ..
