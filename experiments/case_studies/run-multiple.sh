
ELAPSED_TIME=0

for i in {0..10..1}
  do
    if [ "$2" = "opt" ]; then
      STARTTIME=$(date +%s%N)

      clang -I ../../include -emit-llvm -g -c $1.c
      /home/osboxes/klee-3.4/klee_build_dir/bin/klee --search=dfs --no-output --warnings-only-to-file --optimize $1.bc

      ENDTIME=$(date +%s%N)
      ELAPSED_TIME=$(($ELAPSED_TIME+$((($ENDTIME - $STARTTIME)/1000000))))
    elif [ "$2" = "o3" ]; then
      STARTTIME=$(date +%s%N)

      clang -I ../../include -emit-llvm -g -c -O3 $1.c
      /home/osboxes/klee-3.4/klee_build_dir/bin/klee --search=dfs --no-output --warnings-only-to-file $1.bc

      ENDTIME=$(date +%s%N)
      ELAPSED_TIME=$(($ELAPSED_TIME+$((($ENDTIME - $STARTTIME)/1000000))))
    elif [ "$2" = "slice" ]; then
      STARTTIME=$(date +%s%N)
      frama-c -slice-calls printf $1.c  -then-on 'Slicing export' -print -ocode sliced.c > /dev/null
      clang -I ../../include -emit-llvm -g -c sliced.c
      /home/osboxes/klee-3.4/klee_build_dir/bin/klee --search=dfs --no-output --warnings-only-to-file sliced.bc

      ENDTIME=$(date +%s%N)
      ELAPSED_TIME=$(($ELAPSED_TIME+$((($ENDTIME - $STARTTIME)/1000000))))
    else
      STARTTIME=$(date +%s%N)

      clang -I ../../include -emit-llvm -g -c $1.c
      /home/osboxes/klee-3.4/klee_build_dir/bin/klee --search=dfs --no-output --warnings-only-to-file $1.bc
 
      ENDTIME=$(date +%s%N)
      ELAPSED_TIME=$(($ELAPSED_TIME+$((($ENDTIME - $STARTTIME)/1000000))))
    fi
  done

echo $(($ELAPSED_TIME/10))
sudo rm -r klee-*

