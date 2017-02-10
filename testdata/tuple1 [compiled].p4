void f<T>(in T data)
control proto<>();
package top<>( proto _p);
struct tuple_0 {
  bit<32> field;
  bool field_0; }
control c() {
  tuple_0 x
  action act() {
    x.field = 10;
    x.field_0 = 0;
    f<tuple_0>(x); }
  table tbl_act() {
    actions = { act(); }
    const default_action = act(); }
  tbl_act.apply(); }
top main(c())
