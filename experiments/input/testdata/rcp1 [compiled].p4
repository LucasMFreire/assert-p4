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
extern ConditionalAccumulator<T> {
  <null> ConditionalAccumulator<>( bit<32> size);
  void read<>(out T value);
  void write<>(in T value, in bool condition); }
<Type_Enum>(145)
extern Counter<T> {
  <null> Counter<>( CounterType type);
  void count<>(); }
control proto<P, M>(inout P packet, in M meta);
package top<P, M>( proto<P, M> _p);
header H {
  bit<32> rtt; }
struct Metadata {
  bit<32> pkt_len; }
control ingress() {
  bool tmp_1
  bool tmp_2
  @name("input_traffic_bytes") Counter<bit<32>> input_traffic_bytes(<TypeNameExpression>(21296)CounterType.packets_and_bytes)
  @name("sum_rtt_Tr") ConditionalAccumulator<bit<32>> sum_rtt_Tr(1)
  @name("num_pkts_with_rtt") ConditionalAccumulator<bit<32>> num_pkts_with_rtt(1)
  action act() {
    input_traffic_bytes.count();
    tmp_1 = pkt_hdr.rtt < 2500;
    sum_rtt_Tr.write(pkt_hdr.rtt, tmp_1);
    tmp_2 = pkt_hdr.rtt < 2500;
    num_pkts_with_rtt.write(1, tmp_2); }
  table tbl_act() {
    actions = { act(); }
    const default_action = act(); }
  { tbl_act.apply(); } }
top<H, Metadata> main(ingress())
