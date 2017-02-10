control c() {
  bit<32> x
  bit<32> arg_0/arg
  action a_0/a() {
    arg_0/arg = x;
    y = (bit<16>)x; }
  action act() {
    x = 2; }
  table tbl_act() {
    actions = { act(); }
    const default_action = act(); }
  table tbl_a() {
    actions = { a_0(); }
    const default_action = a_0/a(); }
  tbl_act.apply();
  tbl_a.apply(); }
control proto<>(inout bit<16> y);
package top<>( proto _p);
top main(c())
