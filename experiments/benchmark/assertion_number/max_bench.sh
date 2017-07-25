llvm-gcc -I ../../include -emit-llvm -c -g symbolic_equality_tests/main_model_fake_vars199.c
STARTTIME=$(date +%s)
klee --search=dfs --warnings-only-to-file --no-output main_model_fake_vars199.o
ENDTIME=$(date +%s)
ELAPSED_TIME=$(($ENDTIME - $STARTTIME))
echo resultado --- $ELAPSED_TIME