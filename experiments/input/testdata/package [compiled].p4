control proto<>(out bit<32> o);
package top<>( proto _c,  bool parameter);
control c() {
  action act() {
    o = 0; }
  table tbl_act() {
    actions = { act(); }
    const default_action = act(); }
  tbl_act.apply(); }
top main(c(), 1)
