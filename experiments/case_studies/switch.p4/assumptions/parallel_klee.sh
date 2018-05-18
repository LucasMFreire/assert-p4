STARTTIME=$(date +%s)

bash run-klee.sh 11 &
bash run-klee.sh 12 &
bash run-klee.sh 13 &
bash run-klee.sh 14 &
bash run-klee.sh 21 &
bash run-klee.sh 22 &
bash run-klee.sh 23 &
bash run-klee.sh 24 &

wait 

ENDTIME=$(date +%s)
ELAPSED_TIME=$(($ENDTIME - $STARTTIME))

echo $1 $ELAPSED_TIME
