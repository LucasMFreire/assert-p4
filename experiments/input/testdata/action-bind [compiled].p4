control c() {
  bit<32> b_0/b
  action a_0/a( bit<32> d) {
    b_0/b = x;
    b_0/b = d;
    x = d; }
  table t() @name("t") {
    actions = { a_0/a(); }
    default_action = a_0/a(0); }
  t.apply(); }
control proto<>(inout bit<32> x);
package top<>( proto p);
top main(c())
