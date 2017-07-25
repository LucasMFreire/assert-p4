control ctrl() {
  bool hasExited
  action e_0/e() {
    hasExited = 1; }
  table t() @name("t") {
    actions = { e_0/e(); }
    default_action = e_0/e(); }
  action act() {
    hasExited = 0; }
  table tbl_act() {
    actions = { act(); }
    const default_action = act(); }
  tbl_act.apply();
  if (t.apply().hit) {
    if (!hasExited) {
      t.apply(); }
  } else {
    if (!hasExited) {
      t.apply(); } } }
control noop<>();
package p<>( noop _n);
p main(ctrl())
