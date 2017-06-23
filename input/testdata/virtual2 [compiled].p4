extern Virtual<> {
  <null> Virtual<>();
  abstract bit<16> f<>(in bit<16> ix);
  void run<>(in bit<16> ix); }
extern State<> {
  <null> State<>( int<16> size);
  bit<16> get<>(in bit<16> index); }
control c() {
  @name("cntr") Virtual cntr() {{ @name("state") State state_1/state(1024)
      <Function>(8736) } }
  action act() {
    cntr.run(6); }
  table tbl_act() {
    actions = { act(); }
    const default_action = act(); }
  tbl_act.apply(); }
control ctr<>(inout bit<16> x);
package top<>( ctr ctrl);
top main(c())
