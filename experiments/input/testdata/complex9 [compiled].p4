bit<32> f<>(in bit<32> x)
control c() {
  bit<32> tmp_4
  bool tmp_5
  bool tmp_6
  bit<32> tmp_7
  bool tmp_8
  action act() {
    tmp_6 = 0; }
  action act_0() {
    tmp_7 = f(3);
    tmp_8 = tmp_7 < 0;
    tmp_6 = tmp_8; }
  action act_1() {
    tmp_4 = f(2);
    tmp_5 = tmp_4 > 0; }
  action act_2() {
    r = 1; }
  action act_3() {
    r = 2; }
  table tbl_act() {
    actions = { act_1(); }
    const default_action = act_1(); }
  table tbl_act_0() {
    actions = { act(); }
    const default_action = act(); }
  table tbl_act_1() {
    actions = { act_0(); }
    const default_action = act_0(); }
  table tbl_act_2() {
    actions = { act_2(); }
    const default_action = act_2(); }
  table tbl_act_3() {
    actions = { act_3(); }
    const default_action = act_3(); }
  tbl_act.apply();
  if (!tmp_5) {
    tbl_act_0.apply();
  } else {
    { tbl_act_1.apply(); } }
  if (tmp_6) {
    tbl_act_2.apply();
  } else {
    tbl_act_3.apply(); } }
control simple<>(inout bit<32> r);
package top<>( simple e);
top main(c())