parser simple<>(in bit<2> a);
package m<>( simple n);
parser p1_0() {
  state start {
    accept; }
  state accept { }
  state reject { } }
m main(p1_0())
