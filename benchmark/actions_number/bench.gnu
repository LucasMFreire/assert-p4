set terminal png enhanced font "Helvetica" 26
set output 'nactions.png'
set ytics 5
#set logscale y
#set yrange [0.9:33888];
set xrange [0:150];
set xlabel 'Nro. de ações por tabela'
#set ylabel 'Tempo de execução (s)'
plot 'actions.txt' using 1:2 notitle with linespoints linewidth 3
