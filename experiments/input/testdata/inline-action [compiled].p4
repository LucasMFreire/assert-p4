control p() {
  bit<1> tmp_0
  bit<1> y0/y0_0
  bit<1> y0_2/y0_1
  action b_0/b() {
    y0/y0_0 = bt;
    tmp_0 = bt | 1;
    y0/y0_0 = bt | 1;
    bt = bt | 1;
    y0_2/y0_1 = bt | 1;
    tmp_0 = bt | 1 | 1;
    y0_2/y0_1 = bt | 1 | 1;
    bt = bt | 1 | 1; }
  table t() @name("t") {
    actions = { b_0/b(); }
    default_action = b_0/b(); }
  t.apply(); }
control simple<T>(inout T arg);
package m<T>( simple<T> pipe);
m<bit<1>> main(p())
