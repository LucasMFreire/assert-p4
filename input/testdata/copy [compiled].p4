struct S {
  bit<32> x; }
control c() {
  S s1
  S s2
  action a_0/a() {
    s2.x = 0;
    s1.x = s2.x;
    s2.x = s1.x;
    b = s2.x; }
  table tbl_a() {
    actions = { a_0(); }
    const default_action = a_0/a(); }
  tbl_a.apply(); }
control proto<>(inout bit<32> _b);
package top<>( proto _p);
top main(c())
