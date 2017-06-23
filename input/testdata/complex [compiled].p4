bit<32> f<>(in bit<32> x)
control c() {
  bit<32> tmp_1
  bit<32> tmp_2
  action act() {
    tmp_1 = f(5);
    tmp_2 = f(tmp_1);
    r = tmp_2; }
  table tbl_act() {
    actions = { act(); }
    const default_action = act(); }
  tbl_act.apply(); }
control simple<>(inout bit<32> r);
package top<>( simple e);
top main(c())
