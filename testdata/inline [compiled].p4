control p() {
  bit<1> x_2/x
  bit<1> z
  bit<1> x_3/x
  bit<1> tmp_7
  bit<1> tmp_8
  bit<1> tmp_9
  bit<1> tmp_10
  bit<1> tmp_11
  bit<1> tmp_12
  bit<1> tmp_13
  bit<1> tmp_14
  bit<1> x0/x0_0
  bit<1> y0/y0_0
  bit<1> x0_2/x0_1
  bit<1> y0_2/y0_1
  bit<1> x_0/x
  bit<1> y_0/y
  action b_0/b() {
    x_0/x = tmp_13;
    tmp_8 = tmp_13;
    x0/x0_0 = tmp_13;
    x_2/x = tmp_13;
    tmp_7 = tmp_13 & tmp_13;
    y0/y0_0 = tmp_13 & tmp_13;
    tmp_9 = tmp_13 & tmp_13;
    z = tmp_13 & tmp_13;
    tmp_10 = tmp_13 & tmp_13 & (tmp_13 & tmp_13);
    tmp_11 = tmp_13 & tmp_13 & (tmp_13 & tmp_13);
    x0_2/x0_1 = tmp_13 & tmp_13 & (tmp_13 & tmp_13);
    x_2/x = tmp_13 & tmp_13 & (tmp_13 & tmp_13);
    tmp_7 = tmp_13 & tmp_13 & (tmp_13 & tmp_13) & (tmp_13 & tmp_13 & (tmp_13 & tmp_13));
    y0_2/y0_1 = tmp_13 & tmp_13 & (tmp_13 & tmp_13) & (tmp_13 & tmp_13 & (tmp_13 & tmp_13));
    tmp_12 = tmp_13 & tmp_13 & (tmp_13 & tmp_13) & (tmp_13 & tmp_13 & (tmp_13 & tmp_13));
    y_0/y = tmp_13 & tmp_13 & (tmp_13 & tmp_13) & (tmp_13 & tmp_13 & (tmp_13 & tmp_13));
    tmp_14 = tmp_13 & tmp_13 & (tmp_13 & tmp_13) & (tmp_13 & tmp_13 & (tmp_13 & tmp_13)); }
  action act() {
    x_3/x = 1;
    tmp_13 = x_3/x; }
  action act_0() {
    y = tmp_14; }
  table tbl_act() {
    actions = { act(); }
    const default_action = act(); }
  table tbl_b() {
    actions = { b_0(); }
    const default_action = b_0/b(); }
  table tbl_act_0() {
    actions = { act_0(); }
    const default_action = act_0(); }
  tbl_act.apply();
  tbl_b.apply();
  tbl_act_0.apply(); }
control simple<>(out bit<1> y);
package m<>( simple pipe);
m main(p())
