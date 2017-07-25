control ctrl() {
  bool hasExited
  bit<32> a
  bool tmp_0
  action act() {
    hasExited = 1; }
  action act_0() {
    hasExited = 1; }
  action act_1() {
    hasExited = 0;
    a = 0;
    tmp_0 = a == 0; }
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
  if (tmp_0) {
    tbl_act_0.apply();
  } else {
    tbl_act_1.apply(); } }
control noop<>();
package p<>( noop _n);
p main(ctrl())
