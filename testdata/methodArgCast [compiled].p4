extern E<> {
  <null> E<>();
  void setValue<>(in bit<32> arg); }
control c() {
  @name("e") E e()
  action act() {
    e.setValue(10); }
  table tbl_act() {
    actions = { act(); }
    const default_action = act(); }
  tbl_act.apply(); }
control proto<>();
package top<>( proto p);
top main(c())
