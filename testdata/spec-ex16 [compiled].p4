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
parser Prs<T>( packet_in b, out T result);
control Map<T>(in T d);
package Switch<T>( Prs<T> prs,  Map<T> map);
parser P() {
  state start {
    accept; }
  state accept { }
  state reject { } }
control Map1() { }
Switch<bit<32>> main(P(), Map1())
