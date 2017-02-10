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
  bool tmp_2
  bool tmp_3
  bool tmp_4
  action NoAction_0/NoAction_1() { }
  action NoAction_3/NoAction_2() { }
  table t1() @name("t1") {
    key = { x: exact; }
    actions = { NoAction_0/NoAction_1(); }
    default_action = NoAction_0/NoAction_1(); }
  table t2() @name("t2") {
    key = { x: exact; }
    actions = { NoAction_3/NoAction_2(); }
    default_action = NoAction_3/NoAction_2(); }
  action act() {
    tmp_2 = 1; }
  action act_0() {
    tmp_2 = 0; }
  action act_1() {
    x = 1; }
  action act_2() {
    tmp_3 = 0; }
  action act_3() {
    tmp_4 = 1; }
  action act_4() {
    tmp_4 = 0; }
  action act_5() {
    tmp_3 = tmp_4; }
  action act_6() {
    x = 0; }
  table tbl_act() {
    actions = { act_1(); }
    const default_action = act_1(); }
  table tbl_act_0() {
    actions = { act(); }
    const default_action = act(); }
  table tbl_act_1() {
    actions = { act_0(); }
    const default_action = act_0(); }
  table tbl_act_2() {
    actions = { act_2(); }
    const default_action = act_2(); }
  table tbl_act_3() {
    actions = { act_3(); }
    const default_action = act_3(); }
  table tbl_act_4() {
    actions = { act_4(); }
    const default_action = act_4(); }
  table tbl_act_5() {
    actions = { act_5(); }
    const default_action = act_5(); }
  table tbl_act_6() {
    actions = { act_6(); }
    const default_action = act_6(); }
  tbl_act.apply();
  if (t1.apply().hit) {
    tbl_act_0.apply();
  } else {
    tbl_act_1.apply(); }
  if (!tmp_2) {
    tbl_act_2.apply();
  } else {
    { if (t2.apply().hit) {
        tbl_act_3.apply();
      } else {
        tbl_act_4.apply(); }
      tbl_act_5.apply(); } }
  if (tmp_3) {
    tbl_act_6.apply(); } }
control proto<>(out bool x);
package top<>( proto p);
top main(c())
