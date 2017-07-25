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
parser p1() {
  header Header {
    bit<32> data; } tmp_1
  header Header {
    bit<32> data; } tmp_2
  Header h_1/h_0
  state start {
    h_1/h_0.setInvalid();
    p.extract<Header>(h_1/h_0);
    tmp_1 = h_1/h_0;
    h[0] = tmp_1;
    h_1/h_0.setInvalid();
    p.extract<Header>(h_1/h_0);
    tmp_2 = h_1/h_0;
    h[1] = tmp_2;
    accept; }
  state accept { }
  state reject { } }
parser proto<>( packet_in p, out Header[2] h);
package top<>( proto _p);
top main(p1())
