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
control c() {
  bit<32> tmp_0
  bit<32> x_0/x
  action a_0/a() { }
  action b_0/b() { }
  table t() @name("t") {
    key = { x_0/x: exact; }
    actions = { a_0/a();
      b_0/b(); }
    default_action = a_0/a(); }
  action act() {
    arg = x_0/x;
    x_0/x = arg; }
  action act_0() {
    arg = x_0/x; }
  action act_1() {
    arg = x_0/x;
    tmp_0 = arg + 1;
    arg = tmp_0; }
  action act_2() {
    arg = x_0/x; }
  action act_3() {
    x_0/x = arg; }
  table tbl_act() {
    actions = { act_3(); }
    const default_action = act_3(); }
  table tbl_act_0() {
    actions = { act(); }
    const default_action = act(); }
  table tbl_act_1() {
    actions = { act_0(); }
    const default_action = act_0(); }
  table tbl_act_2() {
    actions = { act_1(); }
    const default_action = act_1(); }
  table tbl_act_3() {
    actions = { act_2(); }
    const default_action = act_2(); }
  tbl_act.apply();
  <SwitchStatement>(18476) }
control proto<>(inout bit<32> arg);
package top<>( proto p);
top main(c())
