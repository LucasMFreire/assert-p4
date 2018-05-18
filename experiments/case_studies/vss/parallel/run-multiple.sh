
ELAPSED_TIME=0

for i in {0..10..1}
  do

    STARTTIME=$(date +%s%N)

    bash parallel_klee.sh

    ENDTIME=$(date +%s%N)
    ELAPSED_TIME=$(($ELAPSED_TIME+$((($ENDTIME - $STARTTIME)/1000000))))
  done

echo $(($ELAPSED_TIME/10))
sudo rm -r klee-*
