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
header Header {
  bit<32> data1;
  bit<32> data2;
  bit<32> data3; }
void func<>(in Header h)
bit<32> g<>(inout bit<32> v, in bit<32> w)
parser p1() {
  Header[2] stack
  bool c_1/c
  bool d
  bit<32> tmp_11
  bit<32> tmp_12
  bit<32> tmp_13
  bit<32> tmp_14
  bit<32> tmp_15
  bit<32> tmp_16
  state start {
    h.data1 = 0;
    func(h);
    tmp_11 = h.data2;
    tmp_12 = h.data2;
    tmp_13 = h.data2;
    tmp_14 = g(tmp_12, tmp_13);
    tmp_15 = tmp_14;
    g(tmp_11, tmp_15);
    tmp_16 = h.data3 + 1;
    h.data2 = tmp_16;
    stack[1].isValid();
    select{h.isValid()} {
      1: next1
      0: next2 } }
  state next1 {
    d = 0;
    next3; }
  state next2 {
    c_1/c = 1;
    d = c_1/c;
    next3; }
  state next3 {
    accept; }
  state accept { }
  state reject { } }
control c() {
  bit<32> b
  bit<32> d_2/d
  bit<32> setByAction
  bit<32> e
  bool touched
  bit<32> tmp_17
  bit<32> tmp_18
  bool tmp_19
  bit<32> tmp_20
  bool tmp_21
  bit<32> tmp_22
  action a1_0/a1() {
    setByAction = 1; }
  action a1_2/a1_1() {
    setByAction = 1; }
  action a2_0/a2() {
    setByAction = 1; }
  table t() @name("t") {
    actions = { a1_0/a1();
      a2_0/a2(); }
    default_action = a1_0/a1(); }
  action act() {
    e = 1; }
  action act_0() {
    d_2/d = 1;
    tmp_17 = b + 1;
    tmp_18 = d_2/d + 1;
    tmp_19 = e > 0; }
  action act_1() {
    touched = 1; }
  action act_2() {
    tmp_20 = e + 1;
    e = tmp_20; }
  action act_3() {
    tmp_21 = e > 0; }
  action act_4() {
    tmp_22 = setByAction + 1; }
  table tbl_act() {
    actions = { act_0(); }
    const default_action = act_0(); }
  table tbl_act_0() {
    actions = { act(); }
    const default_action = act(); }
  table tbl_act_1() {
    actions = { act_2(); }
    const default_action = act_2(); }
  table tbl_act_2() {
    actions = { act_1(); }
    const default_action = act_1(); }
  table tbl_act_3() {
    actions = { act_3(); }
    const default_action = act_3(); }
  table tbl_a1() {
    actions = { a1_2(); }
    const default_action = a1_2/a1_1(); }
  table tbl_act_4() {
    actions = { act_4(); }
    const default_action = act_4(); }
  tbl_act.apply();
  if (tmp_19) {
    tbl_act_0.apply();
  } else {
     }
  tbl_act_1.apply();
  <SwitchStatement>(42400)
  tbl_act_3.apply();
  if (tmp_21) {
    t.apply();
  } else {
    tbl_a1.apply(); }
  tbl_act_4.apply(); }
parser proto<>( packet_in p, out Header h);
control cproto<>(out bit<32> v);
package top<>( proto _p,  cproto _c);
top main(p1(), c())
