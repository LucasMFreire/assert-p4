#STARTTIME=$(date +%s)

llvm-gcc -I ../../include -emit-llvm -c -O3 -g $1.c
klee --search=dfs --no-output --warnings-only-to-file --optimize  $1.o

#clang -I ../../include -emit-llvm -g $1.c
#opt -O3 -o opt.bc $1.bc
#/home/osboxes/klee-3.4/klee_build_dir/bin/klee --search=dfs --no-output --warnings-only-to-file --optimize opt.bc

#ENDTIME=$(date +%s)
#ELAPSED_TIME=$(($ENDTIME - $STARTTIME))

#echo $1 $ELAPSED_TIME
