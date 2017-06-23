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
parser p() {
  bit<32> tmp_0
  state start {
    tmp_0 = f(2);
    select{tmp_0} {
      0: accept
      default: reject } }
  state accept { }
  state reject { } }
parser simple<>();
package top<>( simple e);
top main(p())
