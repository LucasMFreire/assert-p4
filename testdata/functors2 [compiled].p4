parser simple<>(out bit<2> z);
package m<>( simple n);
parser p2_0() {
  bit<2> x1
  bit<2> x2
  bit<2> x3
  bit<2> tmp_3
  bit<2> tmp_4
  bit<2> tmp_5
  bit<2> tmp_6
  bit<2> z1/z1_0
  bit<2> z1_3/z1_1
  bit<2> z1_4/z1_2
  state start {
    z1/z1_0 = 0;
    x1 = z1/z1_0;
    z1_3/z1_1 = 1;
    x2 = z1_3/z1_1;
    z1_4/z1_2 = 2;
    x3 = z1_4/z1_2;
    tmp_3 = 3;
    tmp_4 = tmp_3 | x1;
    tmp_5 = tmp_4 | x2;
    tmp_6 = tmp_5 | x3;
    z2 = tmp_6;
    accept; }
  state accept { }
  state reject { } }
m main(p2_0())
