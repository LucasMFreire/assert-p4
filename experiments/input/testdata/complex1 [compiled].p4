bit<32> f<>(in bit<32> x, in bit<32> y)
control c() {
  bit<32> tmp_6
  bit<32> tmp_7
  bit<32> tmp_8
  bit<32> tmp_9
  bit<32> tmp_10
  bit<32> tmp_11
  bit<32> tmp_12
  action act() {
    tmp_6 = f(5, 2);
    tmp_7 = tmp_6;
    tmp_8 = f(2, 3);
    tmp_9 = tmp_8;
    tmp_10 = f(6, tmp_9);
    tmp_11 = tmp_10;
    tmp_12 = f(tmp_7, tmp_11);
    r = tmp_12; }
  table tbl_act() {
    actions = { act(); }
    const default_action = act(); }
  tbl_act.apply(); }
control simple<>(inout bit<32> r);
package top<>( simple e);
top main(c())
