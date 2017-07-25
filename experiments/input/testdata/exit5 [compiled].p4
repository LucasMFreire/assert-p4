control ctrl() {
  bool hasExited
  action e_0/e() {
    hasExited = 1; }
  action f_0/f() { }
  table t() @name("t") {
    actions = { e_0/e();
      f_0/f(); }
    default_action = e_0/e(); }
  action act() {
    hasExited = 0; }
  table tbl_act() {
    actions = { act(); }
    const default_action = act(); }
  tbl_act.apply();
  <SwitchStatement>(13220) }
control noop<>();
package p<>( noop _n);
p main(ctrl())
