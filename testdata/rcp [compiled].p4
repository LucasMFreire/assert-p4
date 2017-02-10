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
extern Register<T> {
  <null> Register<>( bit<32> size);
  void read<>(in bit<32> index, out T value);
  void write<>(in bit<32> index, in T value); }
control proto<P, M>(inout P packet, in M meta);
package top<P, M>( proto<P, M> _p);
header H {
  bit<32> rtt; }
struct Metadata {
  bit<32> pkt_len; }
control ingress() {
  bit<32> input_traffic_bytes_tmp
  bit<32> sum_rtt_Tr_tmp
  bit<32> num_pkts_with_rtt_tmp
  bit<32> tmp_6
  bit<32> tmp_7
  bit<32> tmp_8
  bit<32> tmp_9
  bit<32> tmp_10
  bit<32> tmp_11
  bool tmp_12
  @name("input_traffic_bytes") Register<bit<32>> input_traffic_bytes(1)
  @name("sum_rtt_Tr") Register<bit<32>> sum_rtt_Tr(1)
  @name("num_pkts_with_rtt") Register<bit<32>> num_pkts_with_rtt(1)
  action act() {
    sum_rtt_Tr.read(0, tmp_8);
    sum_rtt_Tr_tmp = tmp_8;
    tmp_9 = sum_rtt_Tr_tmp + pkt_hdr.rtt;
    sum_rtt_Tr_tmp = tmp_9;
    sum_rtt_Tr.write(sum_rtt_Tr_tmp, 0);
    num_pkts_with_rtt.read(0, tmp_10);
    num_pkts_with_rtt_tmp = tmp_10;
    tmp_11 = num_pkts_with_rtt_tmp + 1;
    num_pkts_with_rtt_tmp = tmp_11;
    num_pkts_with_rtt.write(num_pkts_with_rtt_tmp, 0); }
  action act_0() {
    input_traffic_bytes.read(0, tmp_6);
    input_traffic_bytes_tmp = tmp_6;
    tmp_7 = input_traffic_bytes_tmp + metadata.pkt_len;
    input_traffic_bytes_tmp = tmp_7;
    input_traffic_bytes.write(input_traffic_bytes_tmp, 0);
    tmp_12 = pkt_hdr.rtt < 2500; }
  table tbl_act() {
    actions = { act_0(); }
    const default_action = act_0(); }
  table tbl_act_0() {
    actions = { act(); }
    const default_action = act(); }
  { tbl_act.apply();
    if (tmp_12) {
      { tbl_act_0.apply(); } } } }
top<H, Metadata> main(ingress())
