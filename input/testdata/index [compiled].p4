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
header H {
  bit<32> field; }
parser P() {
  bit<32> x
  H tmp_2/tmp
  bit<32> tmp_3
  bit<32> tmp_4
  state start {
    p.extract<H>(tmp_2/tmp);
    select{tmp_2/tmp.field} {
      0: n1
      default: n2 } }
  state n1 {
    x = 1;
    n3; }
  state n2 {
    x = 2;
    n3; }
  state n3 {
    tmp_3 = x + 4294967295;
    x = tmp_3;
    tmp_4 = x;
    p.extract<H>(h[tmp_4]);
    accept; }
  state accept { }
  state reject { } }
parser Simple<T>( packet_in p, out T t);
package top<T>( Simple<T> prs);
top<H[2]> main(P())
