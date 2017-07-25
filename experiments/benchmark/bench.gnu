set terminal png enhanced font "Helvetica" 26
set output 'ntables.png'
set logscale y
set yrange [0.9:24387];
set xrange [10:24];
set xlabel 'Tables number'
#set xlabel 'Nro. de asserções'
#set xlabel 'Nro. de ações por tabela'
set ylabel 'Verification time (s)' offset 0,-0.7,0
#set label 11 center at graph 0.5,char 1 "(a)"
set bmargin 5
plot 'result_tables.txt' using 1:2 notitle with linespoints linewidth 3
