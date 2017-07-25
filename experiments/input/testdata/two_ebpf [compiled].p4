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
extern CounterArray<> {
  <null> CounterArray<>( bit<32> max_index,  bool sparse);
  void increment<>(in bit<32> index); }
extern array_table<> {
  <null> array_table<>( bit<32> size); }
extern hash_table<> {
  <null> hash_table<>( bit<32> size); }
parser parse<H>( packet_in packet, out H headers);
control filter<H>(inout H headers, out bool accept);
package ebpfFilter<H>( parse<H> prs,  filter<H> filt);
<Type_Typedef>(210)
<Type_Typedef>(219)
header Ethernet_h {
  EthernetAddress dstAddr;
  EthernetAddress srcAddr;
  bit<16> etherType; }
header IPv4_h {
  bit<4> version;
  bit<4> ihl;
  bit<8> diffserv;
  bit<16> totalLen;
  bit<16> identification;
  bit<3> flags;
  bit<13> fragOffset;
  bit<8> ttl;
  bit<8> protocol;
  bit<16> hdrChecksum;
  IPv4Address srcAddr;
  IPv4Address dstAddr; }
struct Headers_t {
  Ethernet_h ethernet;
  IPv4_h ipv4; }
parser prs() {
  state start {
    p.extract<Ethernet_h>(headers.ethernet);
    select{headers.ethernet.etherType} {
      2048: ip
      default: reject } }
  state ip {
    p.extract<IPv4_h>(headers.ipv4);
    accept; }
  state accept { }
  state reject { } }
control pipe() {
  IPv4Address address_0/address
  bool hasReturned_0
  action NoAction_0/NoAction_1() { }
  action Reject_0/Reject() {
    pass = 0; }
  table Check_ip() @name("Check_ip") {
    key = { address_0/address: exact; }
    actions = { Reject_0/Reject();
      NoAction_0/NoAction_1(); }
    implementation = hash_table(1024);
    const default_action = NoAction_0/NoAction_1(); }
  action act() {
    pass = 0;
    hasReturned_0 = 1; }
  action act_0() {
    hasReturned_0 = 0;
    pass = 1; }
  action act_1() {
    address_0/address = headers.ipv4.srcAddr; }
  action act_2() {
    address_0/address = headers.ipv4.dstAddr; }
  table tbl_act() {
    actions = { act_0(); }
    const default_action = act_0(); }
  table tbl_act_0() {
    actions = { act(); }
    const default_action = act(); }
  table tbl_act_1() {
    actions = { act_1(); }
    const default_action = act_1(); }
  table tbl_act_2() {
    actions = { act_2(); }
    const default_action = act_2(); }
  tbl_act.apply();
  if (!headers.ipv4.isValid()) {
    { tbl_act_0.apply(); } }
  if (!hasReturned_0) {
    { tbl_act_1.apply();
      Check_ip.apply();
      tbl_act_2.apply();
      Check_ip.apply(); } } }
ebpfFilter<Headers_t> main(prs(), pipe())
