control ctrl() {
  bool hasExited
  bit<32> x
  bit<32> a
  bool tmp_0
  action e_0/e() {
    hasExited = 1; }
  action e_2/e_1() {
    hasExited = 1; }
  action act() {
    hasExited = 0;
    a = 0;
    c = 2;
    tmp_0 = a == 0; }
  action act_0() {
    c = 5; }
  table tbl_act() {
    actions = { act(); }
    const default_action = act(); }
  table tbl_e() {
    actions = { e_0(); }
    const default_action = e_0/e(); }
  table tbl_e_0() {
    actions = { e_2(); }
    const default_action = e_2/e_1(); }
  table tbl_act_0() {
    actions = { act_0(); }
    const default_action = act_0(); }
  tbl_act.apply();
  if (tmp_0) {
    tbl_e.apply();
  } else {
    tbl_e_0.apply(); }
  if (!hasExited) {
    tbl_act_0.apply(); } }
control noop<>(out bit<32> c);
package p<>( noop _n);
p main(ctrl())
