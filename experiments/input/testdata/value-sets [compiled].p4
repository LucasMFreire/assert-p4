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
header Ethernet_h {
  bit<48> dstAddr;
  bit<48> srcAddr;
  bit<16> etherType; }
struct Parsed_packet {
  Ethernet_h ethernet; }
extern ValueSet<> {
  <null> ValueSet<>( bit<32> size);
  bit<8> index<>(in bit<16> proto); }
parser TopParser() {
  bit<8> setIndex
  bit<8> tmp_0
  @name("ethtype_kinds") ValueSet ethtype_kinds(5)
  state start {
    b.extract<Ethernet_h>(p.ethernet);
    select{p.ethernet.etherType} {
      2048: parse_ipv4
      2054: parse_arp
      34525: parse_ipv6
      default: dispatch_value_sets } }
  state dispatch_value_sets {
    tmp_0 = ethtype_kinds.index(p.ethernet.etherType);
    setIndex = tmp_0;
    select{setIndex} {
      1: parse_trill
      2: parse_vlan_tag } }
  state parse_ipv4 {
    accept; }
  state parse_arp {
    accept; }
  state parse_ipv6 {
    accept; }
  state parse_trill {
    accept; }
  state parse_vlan_tag {
    accept; }
  state accept { }
  state reject { } }
parser proto<T>( packet_in p, out T h);
package top<T>( proto<T> _p);
top<Parsed_packet> main(TopParser())
