control ctrl() {
  bool hasExited
  bit<32> a
  bool tmp_0
  action e_0/e() {
    hasExited = 1; }
  table t() @name("t") {
    actions = { e_0/e(); }
    default_action = e_0/e(); }
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
  table tbl_act_0() {
    actions = { act_0(); }
    const default_action = act_0(); }
  tbl_act.apply();
  if (tmp_0) {
    t.apply();
  } else {
    t.apply(); }
  if (!hasExited) {
    tbl_act_0.apply(); } }
control noop<>(out bit<32> c);
package p<>( noop _n);
p main(ctrl())
