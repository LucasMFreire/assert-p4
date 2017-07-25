parser simple<>(out bit<2> w);
package m<>( simple n);
parser p2_0() {
  bit<2> w_1/w_0
  state start {
    w_1/w_0 = 2;
    w = w_1/w_0;
    accept; }
  state accept { }
  state reject { } }
m main(p2_0())
