set terminal png enhanced font "Helvetica" 26
set output 'nassert.png'
set logscale y
#set yrange [0:102426];
set xrange [10:24];
set xlabel 'Assertion number'
#set ylabel 'Tempo de execução (s)'
#set label 11 center at graph 0.5,char 1 "(b)"
set bmargin 5
plot 'symbolic_equality.txt' using 1:2 notitle with linespoints linewidth 3
