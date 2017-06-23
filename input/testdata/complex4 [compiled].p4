extern E<> {
  <null> E<>();
  bit<32> f<>(in bit<32> x); }
control c() {
  bit<32> tmp_2
  bit<32> tmp_3
  bit<32> tmp_4
  @name("e") E e_1/e()
  action act() {
    tmp_2 = e_1/e.f(4);
    tmp_3 = e_1/e.f(5);
    tmp_4 = tmp_2 + tmp_3;
    r = tmp_4; }
  table tbl_act() {
    actions = { act(); }
    const default_action = act(); }
  tbl_act.apply(); }
control simple<>(inout bit<32> r);
package top<>( simple e);
top main(c())
