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
header ethernet_h {
  bit<48> dst;
  bit<48> src;
  bit<16> type; }
struct headers_t {
  ethernet_h ethernet; }
parser Parser() {
  state start {
    pkt_in.extract<ethernet_h>(hdr.ethernet);
    reject; }
  state accept { }
  state reject { } }
control Deparser() {
  pkt_out.emit<ethernet_h>(hdr.ethernet); }
parser P<H>( packet_in pkt, out H hdr);
control D<H>(in H hdr,  packet_out pkt);
package S<H>( P<H> p,  D<H> d);
S<headers_t> main(Parser(), Deparser())
