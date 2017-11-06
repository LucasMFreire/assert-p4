set terminal png enhanced font "Helvetica" 26
set output 'nrules.png'
set xlabel 'Forwarding rules number'
set xtics 0,10,100
set ylabel 'Verification time (s)' offset 0,-0.7,0
set bmargin 5
plot 'result_rules.txt' using 1:2 notitle with linespoints linewidth 3
