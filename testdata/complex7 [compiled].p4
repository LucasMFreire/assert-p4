error { NoError, PacketTooShort, NoMatch, EmptyStack, FullStack, OverwritingHeader, HeaderTooShort, ParserTimeout }
extern packet_in<> {
  void extract<T>(out T hdr);
  void extract<T>(out T variableSizeHeader, in bit<32> variableFieldSizeInBits);
  T lookahead<T>();
  void advance<>(in bit<32> sizeInBits);
  bit<32> length<>(); }
extern packet_out<> {
  void emit<T>(in T hdr); }
match_kind { exact, ternary, lpm }
bit<32> f<>(in bit<32> x)
control c() {
  bit<32> tmp_2
  bool tmp_3
  bit<32> tmp_4
  bit<32> r_0/r
  action a_0/a() { }
  action b_0/b() { }
  table t() @name("t") {
    key = { r_0/r: ternary; }
    actions = { a_0/a();
      b_0/b(); }
    default_action = a_0/a(); }
  action act() {
    r = 1; }
  action act_0() {
    r = 3; }
  action act_1() {
    tmp_2 = f(2);
    tmp_3 = tmp_2 < 2; }
  action act_2() {
    tmp_4 = f(2);
    r_0/r = tmp_4; }
  table tbl_act() {
    actions = { act_2(); }
    const default_action = act_2(); }
  table tbl_act_0() {
    actions = { act_1(); }
    const default_action = act_1(); }
  table tbl_act_1() {
    actions = { act(); }
    const default_action = act(); }
  table tbl_act_2() {
    actions = { act_0(); }
    const default_action = act_0(); }
  tbl_act.apply();
  <SwitchStatement>(18789) }
control simple<>(inout bit<32> r);
package top<>( simple e);
top main(c())
