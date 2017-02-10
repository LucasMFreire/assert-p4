control d() {
  bool hasReturned_0
  action cinst_a1/cinst_a1_0() { }
  action cinst_a2/cinst_a2_0() { }
  table cinst_t_0/cinst_t() @name("cinst.t") {
    actions = { cinst_a1/cinst_a1_0();
      cinst_a2/cinst_a2_0(); }
    default_action = cinst_a1/cinst_a1_0(); }
  action act() {
    hasReturned_0/hasReturned = 1; }
  action act_0() {
    hasReturned_0/hasReturned = 1; }
  action act_1() {
    hasReturned_0 = 0; }
  table tbl_act() {
    actions = { act_1(); }
    const default_action = act_1(); }
  table tbl_act_0() {
    actions = { act(); }
    const default_action = act(); }
  table tbl_act_1() {
    actions = { act_0(); }
    const default_action = act_0(); }
  tbl_act.apply();
  <SwitchStatement>(12628) }
control dproto<>(out bit<32> x);
package top<>( dproto _d);
top main(d())
