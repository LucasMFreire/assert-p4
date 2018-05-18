cd traverse_tests

count=1
for filename in `ls *.c | sort -V`; do
    llvm-gcc -I ../../include -emit-llvm -c -g -O3 "$filename"
    STARTTIME=$(date +%s)
    klee --search=dfs --warnings-only-to-file --no-output $(basename "$filename" .c).o
    ENDTIME=$(date +%s)
    ELAPSED_TIME=$(($ENDTIME - $STARTTIME))
    echo "$count" $ELAPSED_TIME >> ../traverse.txt
    (( count++ ))
done

cd ..

cd equality_tests

count=1
for filename in `ls *.c | sort -V`; do
    llvm-gcc -I ../../include -emit-llvm -c -g -O3 "$filename"
    STARTTIME=$(date +%s)
    klee --search=dfs --warnings-only-to-file --no-output $(basename "$filename" .c).o
    ENDTIME=$(date +%s)
    ELAPSED_TIME=$(($ENDTIME - $STARTTIME))
    echo "$count" $ELAPSED_TIME >> ../equality.txt
    (( count++ ))
done

cd ..

cd symbolic_equality_tests

count=1
for filename in `ls *.c | sort -V`; do
    llvm-gcc -I ../../include -emit-llvm -c -g -O3 "$filename"
    STARTTIME=$(date +%s)
    klee --search=dfs --warnings-only-to-file --no-output $(basename "$filename" .c).o
    ENDTIME=$(date +%s)
    ELAPSED_TIME=$(($ENDTIME - $STARTTIME))
    echo "$count" $ELAPSED_TIME >> ../symbolic_equality.txt
    (( count++ ))
done

cd ..
