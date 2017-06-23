control c<>(out bit<32> x);
package top<>( c _c);
control my() {
  action act() {
    x = 2; }
  table tbl_act() {
    actions = { act(); }
    const default_action = act(); }
  tbl_act.apply(); }
top main(my())
