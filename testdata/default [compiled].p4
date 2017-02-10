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
  bit<32> data; }
parser p0() {
  bool b
  state start {
    b = 1;
    p.extract<Header>(h);
    select{h.data, b} {
      {default, 1}: next
      {default, default}: reject } }
  state next {
    p.extract<Header>(h);
    select{h.data, b} {
      {default, 1}: accept
      {default, default}: reject
      default: reject } }
  state accept { }
  state reject { } }
parser proto<>( packet_in p, out Header h);
package top<>( proto _p);
top main(p0())
