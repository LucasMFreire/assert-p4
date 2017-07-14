set terminal png enhanced font "Helvetica" 26

set output 'output.png'
set logscale y
set yrange [0.9:33888];
set xrange [1:24];
set xlabel 'Nro. de tabelas'
#set xlabel 'Nro. de asserções'
#set xlabel 'Nro. de ações por tabela'
set ylabel 'Tempo de execução (s)'
plot 'result_tables.txt' using 1:2 notitle with linespoints linewidth 3
