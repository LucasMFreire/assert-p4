set terminal png enhanced font "Helvetica" 26
set output 'nactions.png'
set ytics 2
#set logscale y
set yrange [0:10];
set xrange [2:150];
set xlabel 'Actions per table number'
#set ylabel 'Tempo de execução (s)'
#set label 11 center at graph 0.5,char 1 "(c)"
set bmargin 5
plot 'actions.txt' using 1:2 notitle with linespoints linewidth 3
