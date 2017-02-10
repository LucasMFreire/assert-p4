extern Generic<T> {
  <null> Generic<>( T sz);
  R get<R>();
  R get1<R, S>(in S value, in R data); }
void f<T>(in T arg)
control caller() {
  bit<32> b
  bit<32> tmp_1
  bit<5> tmp_2
  @name("cinst.x") Generic<bit<8>> cinst_x_0/cinst_x(9)
  action act() {
    tmp_1/tmp = cinst_x_0/cinst_x.get<bit<32>>();
    tmp_2/tmp_0 = cinst_x_0/cinst_x.get1<bit<5>, bit<10>>(0, 0);
    b/b_0 = (bit<32>)tmp_2/tmp_0;
    f<bit<32>>(b/b_0); }
  table tbl_act() {
    actions = { act(); }
    const default_action = act(); }
  tbl_act.apply(); }
control s<>();
package p<>( s parg);
p main(caller())
