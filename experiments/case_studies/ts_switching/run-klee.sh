STARTTIME=$(date +%s%N)

#frama-c -slice-calls klee_print_once $1.c  -then-on 'Slicing export' -print -ocode sliced.c > /dev/null

clang -I ../../include -emit-llvm -g -c $1.c
/home/osboxes/klee-3.4/klee_build_dir/bin/klee --search=dfs --no-output --warnings-only-to-file --optimize $1.bc


ENDTIME=$(date +%s%N)
ELAPSED_TIME=$((($ENDTIME - $STARTTIME)/1000000))

echo $1 $ELAPSED_TIME
