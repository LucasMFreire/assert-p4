control proto<>(out bit<32> x);
package top<>( proto _c);
control c() {
  bit<8> a
  bit<16> b
  bit<24> tmp_4
  bit<32> tmp_5
  bit<16> tmp_6
  bit<32> tmp_7
  bit<32> tmp_8
  action act() {
    a = 15;
    b = 15;
    tmp_4 = a ++ b;
    tmp_5 = tmp_4 ++ a;
    tmp_6 = a ++ a;
    tmp_7 = b ++ tmp_6;
    tmp_8 = tmp_5 + tmp_7;
    x = tmp_8; }
  table tbl_act() {
    actions = { act(); }
    const default_action = act(); }
  tbl_act.apply(); }
top main(c())
