parser simple<>(out bit<1> z);
package m<>( simple n);
parser p_0() {
  bit<1> tmp_1
  bit<1> tmp_2
  bit<1> z1/z1_0
  state start {
    z1/z1_0 = 0;
    z = z1/z1_0;
    tmp_1 = 0;
    tmp_2 = tmp_1 & 1;
    z = tmp_2;
    accept; }
  state accept { }
  state reject { } }
m main(p_0())
