header H {
  bit<32> a;
  bit<32> b; }
struct S {
  H h1;
  H h2;
  bit<32> c; }
parser p() {
  H s_h1
  H s_h2
  bit<32> s_c
  state start {
    s_h1.setInvalid();
    s_h2.setInvalid();
    accept; }
  state accept { }
  state reject { } }
parser empty<>();
package top<>( empty e);
top main(p())
