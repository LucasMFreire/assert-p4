error { NoError, PacketTooShort, NoMatch, EmptyStack, FullStack, OverwritingHeader, HeaderTooShort, ParserTimeout }
extern packet_in<> {
  void extract<T>(out T hdr);
  void extract<T>(out T variableSizeHeader, in bit<32> variableFieldSizeInBits);
  T lookahead<T>();
  void advance<>(in bit<32> sizeInBits);
  bit<32> length<>(); }
extern packet_out<> {
  void emit<T>(in T hdr); }
void verify<>(in bool check, in error toSignal)
action NoAction() { }
match_kind { exact, ternary, lpm }
header Header {
  bit<32> data1;
  bit<32> data2;
  bit<32> data3; }
void func<>(in Header h)
bit<32> g<>(inout bit<32> v, in bit<32> w)
parser p1() {
  Header[2] stack
  bool b
  bool c
  bool d
  state start {
    h.data1 = 0;
    func(h);
    g(h.data2, g(h.data2, h.data2));
    next; }
  state next {
    h.data2 = h.data3 + 1;
    stack[0] = stack[1];
    b = stack[1].isValid();
    select{h.isValid()} {
      1: next1
      0: next2 } }
  state next1 {
    d = 0;
    next3; }
  state next2 {
    c = 1;
    d = c;
    next3; }
  state next3 {
    c = !c;
    d = !d;
    accept; } }
control c() {
  bit<32> b
  bit<32> d = 1
  bit<32> setByAction
  action a1() {
    setByAction = 1; }
  action a2() {
    setByAction = 1; }
  table t() {
    actions = { a1;
      a2; }
    default_action = a1(); }
  b = b + 1;
  d = d + 1;
  bit<32> e
  bit<32> f
  if (e > 0) {
    { e = 1;
      f = 2; }
  } else {
    { f = 3; } }
  { e = e + 1; }
  bool touched
  <SwitchStatement>(450)
  touched = !touched;
  if (e > 0) {
    t.apply();
  } else {
    a1(); }
  setByAction = setByAction + 1; }
parser proto<>( packet_in p, out Header h);
control cproto<>(out bit<32> v);
package top<>( proto _p,  cproto _c);
top main(p1(), c())
