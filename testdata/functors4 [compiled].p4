parser p() {
  bit<1> z1/z1_0
  state start {
    z1/z1_0 = 0;
    z = z1/z1_0;
    accept; }
  state accept { }
  state reject { } }
parser simple<>(out bit<1> z);
package m<>( simple n);
m main(p())
