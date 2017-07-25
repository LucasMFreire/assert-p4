bit<32> f<>(in bit<32> x)
control c() {
  bit<32> tmp_3
  bool tmp_4
  bit<32> tmp_5
  bool tmp_6
  action act() {
    r = 1; }
  action act_0() {
    r = 3; }
  action act_1() {
    tmp_3 = f(2);
    tmp_4 = tmp_3 < 2; }
  action act_2() {
    r = 2; }
  action act_3() {
    tmp_5 = f(2);
    tmp_6 = tmp_5 > 0; }
  table tbl_act() {
    actions = { act_3(); }
    const default_action = act_3(); }
  table tbl_act_0() {
    actions = { act_1(); }
    const default_action = act_1(); }
  table tbl_act_1() {
    actions = { act(); }
    const default_action = act(); }
  table tbl_act_2() {
    actions = { act_0(); }
    const default_action = act_0(); }
  table tbl_act_3() {
    actions = { act_2(); }
    const default_action = act_2(); }
  tbl_act.apply();
  if (tmp_6) {
    { tbl_act_0.apply();
      if (tmp_4) {
        tbl_act_1.apply();
      } else {
        tbl_act_2.apply(); } }
  } else {
    tbl_act_3.apply(); } }
control simple<>(inout bit<32> r);
package top<>( simple e);
top main(c())
