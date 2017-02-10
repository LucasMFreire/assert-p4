struct S {
  bit<32> f; }
control caller() {
  S data
  action act() {
    data.f = 0;
    data.f = 0; }
  table tbl_act() {
    actions = { act(); }
    const default_action = act(); }
  tbl_act.apply(); }
control none<>();
package top<>( none n);
top main(caller())
