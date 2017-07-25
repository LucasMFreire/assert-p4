extern Virtual<> {
  <null> Virtual<>();
  abstract bit<16> f<>(in bit<16> ix); }
control c() {
  bit<16> tmp_1
  @name("cntr") Virtual cntr() {{ <Function>(6493) } }
  action act() {
    tmp_1 = cntr.f(6);
    p = tmp_1; }
  table tbl_act() {
    actions = { act(); }
    const default_action = act(); }
  tbl_act.apply(); }
control ctr<>(inout bit<16> x);
package top<>( ctr ctrl);
top main(c())
