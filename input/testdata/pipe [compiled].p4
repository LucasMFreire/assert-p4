match_kind { ternary, exact }
<Type_Typedef>(14)
struct TArg1 {
  bit<9> field1;
  bool drop; }
struct TArg2 {
  int<32> field2; }
struct PArg1 {
  bit<32> f0;
  bool drop; }
struct QArg1 {
  bit<32> f1; }
struct QArg2 {
  bit<32> f2; }
extern bs<> { }
struct Packet_data { }
control Q_pipe() {
  struct TArg1 {
    bit<9> field1;
    bool drop; } tmp_5
  struct TArg2 {
    int<32> field2; } tmp_6
  struct TArg1 {
    bit<9> field1;
    bool drop; } tmp_7
  struct TArg2 {
    int<32> field2; } tmp_8
  struct TArg1 {
    bit<9> field1;
    bool drop; } tmp_9
  struct TArg2 {
    int<32> field2; } tmp_10
  TArg1 tArg1_0/tArg1
  TArg2 aArg2_0/aArg2
  bit<9> barg_0/barg
  action NoAction_0/NoAction_1() { }
  action p1_B_action/p1_B_action_0( BParamType bData) {
    barg_0/barg = (bit<9>)bData;
    tArg1_0/tArg1.field1 = (bit<9>)bData; }
  action p1_C_action/p1_C_action_0( bit<9> cData) {
    tmp_5.field1 = cData; }
  table p1_T_0/p1_T() @name("p1.T") {
    key = { tArg1_0/tArg1.field1: ternary;
      aArg2_0/aArg2.field2: exact; }
    actions = { p1_B_action/p1_B_action_0();
      p1_C_action/p1_C_action_0(); }
    size = 5
    const default_action = p1_C_action/p1_C_action_0(5); }
  action p1_Drop/p1_Drop_0() {
    tmp_5.drop = 1; }
  table p1_Tinner_0/p1_Tinner() @name("p1.Tinner") {
    key = { tmp_5.field1: ternary; }
    actions = { p1_Drop/p1_Drop_0();
      NoAction_0/NoAction_1(); }
    const default_action = NoAction_0/NoAction_1(); }
  action act() {
    tmp_5.field1 = qArg1.field1;
    tmp_5.drop = qArg1.drop;
    tmp_6.field2 = qArg2.field2;
    tmp_7/tmp.field1 = tmp_5.field1;
    tmp_7/tmp.drop = tmp_5.drop;
    tmp_8/tmp_0.field2 = tmp_6.field2;
    tArg1_0/tArg1.field1 = tmp_7/tmp.field1;
    tArg1_0/tArg1.drop = tmp_7/tmp.drop;
    aArg2_0/aArg2.field2 = tmp_8/tmp_0.field2; }
  action act_0() {
    tmp_7/tmp.field1 = tArg1_0/tArg1.field1;
    tmp_7/tmp.drop = tArg1_0/tArg1.drop;
    tmp_5.field1 = tmp_7/tmp.field1;
    tmp_5.drop = tmp_7/tmp.drop;
    tmp_9/tmp_1.field1 = tmp_5.field1;
    tmp_9/tmp_1.drop = tmp_5.drop;
    tmp_10/tmp_2.field2 = tmp_6.field2;
    tArg1_0/tArg1.field1 = tmp_9/tmp_1.field1;
    tArg1_0/tArg1.drop = tmp_9/tmp_1.drop;
    aArg2_0/aArg2.field2 = tmp_10/tmp_2.field2; }
  action act_1() {
    tmp_9/tmp_1.field1 = tArg1_0/tArg1.field1;
    tmp_9/tmp_1.drop = tArg1_0/tArg1.drop;
    tmp_5.field1 = tmp_9/tmp_1.field1;
    tmp_5.drop = tmp_9/tmp_1.drop; }
  action act_2() {
    qArg1.field1 = tmp_5.field1;
    qArg1.drop = tmp_5.drop;
    qArg2.field2 = tmp_6.field2; }
  table tbl_act() {
    actions = { act(); }
    const default_action = act(); }
  table tbl_act_0() {
    actions = { act_0(); }
    const default_action = act_0(); }
  table tbl_act_1() {
    actions = { act_1(); }
    const default_action = act_1(); }
  table tbl_act_2() {
    actions = { act_2(); }
    const default_action = act_2(); }
  tbl_act.apply();
  p1_T_0/p1_T.apply();
  tbl_act_0.apply();
  p1_T_0/p1_T.apply();
  tbl_act_1.apply();
  p1_Tinner_0/p1_Tinner.apply();
  tbl_act_2.apply(); }
parser prs<>( bs b, out Packet_data p);
control pp<>(inout TArg1 arg1, inout TArg2 arg2);
package myswitch<>( prs prser,  pp pipe);
parser my_parser() {
  state start {
    accept; }
  state accept { }
  state reject { } }
myswitch main(my_parser(), Q_pipe())
