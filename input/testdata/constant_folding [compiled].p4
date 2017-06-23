control proto<>(out bit<32> x);
package top<>( proto _c);
control c() {
  action act() {
    x = 17; }
  table tbl_act() {
    actions = { act(); }
    const default_action = act(); }
  tbl_act.apply(); }
top main(c())
