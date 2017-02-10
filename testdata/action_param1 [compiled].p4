control c() {
  bit<32> arg_0/arg
  action a_0/a() {
    arg_0/arg = 15;
    x = 15; }
  table tbl_a() {
    actions = { a_0(); }
    const default_action = a_0/a(); }
  tbl_a.apply(); }
control proto<>(inout bit<32> arg);
package top<>( proto p);
top main(c())
