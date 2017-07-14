set terminal png enhanced font "Helvetica" 26
set output 'nassert.png'
set logscale y
#set yrange [0.9:33888];
set xrange [10:20];
set xlabel 'Nro. de asserções'
#set ylabel 'Tempo de execução (s)'
plot 'symbolic_equality.txt' using 1:2 notitle with linespoints linewidth 3
