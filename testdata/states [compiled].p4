extern packet_in<> {
  void extract<T>(out T hdr); }
parser parse<H>( packet_in packet, out H headers);
package ebpfFilter<H>( parse<H> prs);
header Ethernet_h {
  bit<64> dstAddr;
  bit<64> srcAddr;
  bit<16> etherType; }
struct Headers_t {
  Ethernet_h ethernet; }
parser prs() {
  state start {
    p.extract<Ethernet_h>(headers.ethernet);
    select{headers.ethernet.etherType} {
      2048: ip
      default: reject } }
  state ip {
    accept; }
  state accept { }
  state reject { } }
ebpfFilter<Headers_t> main(prs())
