bit<32> f<>(in bit<32> x)
control c() {
  bit<32> tmp_1
  bool tmp_2
  action act() {
    r = 1; }
  action act_0() {
    r = 2; }
  action act_1() {
    tmp_1 = f(2);
    tmp_2 = tmp_1 > 0; }
  table tbl_act() {
    actions = { act_1(); }
    const default_action = act_1(); }
  table tbl_act_0() {
    actions = { act(); }
    const default_action = act(); }
  table tbl_act_1() {
    actions = { act_0(); }
    const default_action = act_0(); }
  tbl_act.apply();
  if (tmp_2) {
    tbl_act_0.apply();
  } else {
    tbl_act_1.apply(); } }
control simple<>(inout bit<32> r);
package top<>( simple e);
top main(c())
