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
match_kind { range, selector }
struct standard_metadata_t {
  bit<9> ingress_port;
  bit<9> egress_spec;
  bit<9> egress_port;
  bit<32> clone_spec;
  bit<32> instance_type;
  bit<1> drop;
  bit<16> recirculate_port;
  bit<32> packet_length; }
extern Checksum16<> {
  <null> Checksum16<>();
  bit<16> get<D>(in D data); }
<Type_Enum>(167)
extern counter<> {
  <null> counter<>( bit<32> size,  CounterType type);
  void count<>(in bit<32> index); }
extern direct_counter<> {
  <null> direct_counter<>( CounterType type); }
extern meter<> {
  <null> meter<>( bit<32> size,  CounterType type);
  void execute_meter<T>(in bit<32> index, out T result); }
extern direct_meter<T> {
  <null> direct_meter<>( CounterType type);
  void read<>(out T result); }
extern register<T> {
  <null> register<>( bit<32> size);
  void read<>(out T result, in bit<32> index);
  void write<>(in bit<32> index, in T value); }
extern action_profile<> {
  <null> action_profile<>( bit<32> size); }
<Type_Enum>(350)
void mark_to_drop<>()
void hash<O, T, D, M>(out O result, in HashAlgorithm algo, in T base, in D data, in M max)
extern action_selector<> {
  <null> action_selector<>( HashAlgorithm algorithm,  bit<32> size,  bit<32> outputWidth); }
parser Parser<H, M>( packet_in b, out H parsedHdr, inout M meta, inout standard_metadata_t standard_metadata);
control VerifyChecksum<H, M>(in H hdr, inout M meta);
control Ingress<H, M>(inout H hdr, inout M meta, inout standard_metadata_t standard_metadata);
control Egress<H, M>(inout H hdr, inout M meta, inout standard_metadata_t standard_metadata);
control ComputeChecksum<H, M>(inout H hdr, inout M meta);
control Deparser<H>( packet_out b, in H hdr);
package V1Switch<H, M>( Parser<H, M> p,  VerifyChecksum<H, M> vr,  Ingress<H, M> ig,  Egress<H, M> eg,  ComputeChecksum<H, M> ck,  Deparser<H> dep);
struct ingress_metadata_t {
  bit<32> flow_ipg;
  bit<13> flowlet_map_index;
  bit<16> flowlet_id;
  bit<32> flowlet_lasttime;
  bit<14> ecmp_offset;
  bit<32> nhop_ipv4; }
struct intrinsic_metadata_t {
  bit<48> ingress_global_timestamp;
  bit<32> lf_field_list;
  bit<16> mcast_grp;
  bit<16> egress_rid; }
header ethernet_t {
  bit<48> dstAddr;
  bit<48> srcAddr;
  bit<16> etherType; }
header ipv4_t {
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
  bit<32> srcAddr;
  bit<32> dstAddr; }
header tcp_t {
  bit<16> srcPort;
  bit<16> dstPort;
  bit<32> seqNo;
  bit<32> ackNo;
  bit<4> dataOffset;
  bit<3> res;
  bit<3> ecn;
  bit<6> ctrl;
  bit<16> window;
  bit<16> checksum;
  bit<16> urgentPtr; }
struct metadata {
  @name("ingress_metadata") ingress_metadata_t ingress_metadata;
  @name("intrinsic_metadata") intrinsic_metadata_t intrinsic_metadata; }
struct headers {
  @name("ethernet") ethernet_t ethernet;
  @name("ipv4") ipv4_t ipv4;
  @name("tcp") tcp_t tcp; }
parser ParserImpl() {
  state parse_ethernet @name("parse_ethernet") {
    packet.extract<ethernet_t>(hdr.ethernet);
    select{hdr.ethernet.etherType} {
      2048: parse_ipv4
      default: accept } }
  state parse_ipv4 @name("parse_ipv4") {
    packet.extract<ipv4_t>(hdr.ipv4);
    select{hdr.ipv4.protocol} {
      6: parse_tcp
      default: accept } }
  state parse_tcp @name("parse_tcp") {
    packet.extract<tcp_t>(hdr.tcp);
    accept; }
  state start @name("start") {
    parse_ethernet; }
  state accept { }
  state reject { } }
control egress() {
  action NoAction_0/NoAction_2() { }
  action rewrite_mac_0/rewrite_mac( bit<48> smac) {
    hdr.ethernet.srcAddr = smac; }
  action _drop_0/_drop() {
    mark_to_drop(); }
  table send_frame() @name("send_frame") {
    actions = { rewrite_mac_0/rewrite_mac();
      _drop_0/_drop();
      NoAction_0/NoAction_2(); }
    key = { standard_metadata.egress_port: exact; }
    size = 256
    default_action = NoAction_0/NoAction_2(); }
  send_frame.apply(); }
struct tuple_0 {
  bit<32> field;
  bit<32> field_0;
  bit<8> field_1;
  bit<16> field_2;
  bit<16> field_3;
  bit<16> field_4; }
struct tuple_1 {
  bit<32> field_5;
  bit<32> field_6;
  bit<8> field_7;
  bit<16> field_8;
  bit<16> field_9; }
control ingress() {
  bit<14> tmp_14
  tuple_0 tmp_15
  bit<8> tmp_16
  bit<13> tmp_17
  tuple_1 tmp_18
  bit<16> tmp_19
  bit<32> tmp_20
  bit<32> tmp_21
  bit<32> tmp_22
  bit<32> tmp_23
  bit<16> tmp_24
  bool tmp_25
  action NoAction_1/NoAction_3() { }
  action NoAction_8/NoAction_4() { }
  action NoAction_9/NoAction_5() { }
  action NoAction_10/NoAction_6() { }
  action NoAction_11/NoAction_7() { }
  @name("flowlet_id") register<bit<16>> flowlet_id_1/flowlet_id(8192)
  @name("flowlet_lasttime") register<bit<32>> flowlet_lasttime_1/flowlet_lasttime(8192)
  action _drop_1/_drop_2() {
    mark_to_drop(); }
  action _drop_5/_drop_3() {
    mark_to_drop(); }
  action _drop_6/_drop_4() {
    mark_to_drop(); }
  action set_ecmp_select_0/set_ecmp_select( bit<8> ecmp_base,  bit<8> ecmp_count) {
    tmp_15.field = hdr.ipv4.srcAddr;
    tmp_15.field_0 = hdr.ipv4.dstAddr;
    tmp_15.field_1 = hdr.ipv4.protocol;
    tmp_15.field_2 = hdr.tcp.srcPort;
    tmp_15.field_3 = hdr.tcp.dstPort;
    tmp_15.field_4 = meta.ingress_metadata.flowlet_id;
    hash<bit<14>, bit<10>, tuple_0, bit<20>>(tmp_14, <TypeNameExpression>(164084)HashAlgorithm.crc16, (bit<10>)ecmp_base, tmp_15, (bit<20>)ecmp_count);
    meta.ingress_metadata.ecmp_offset = tmp_14; }
  action set_nhop_0/set_nhop( bit<32> nhop_ipv4,  bit<9> port) {
    meta.ingress_metadata.nhop_ipv4 = nhop_ipv4;
    standard_metadata.egress_spec = port;
    tmp_16 = hdr.ipv4.ttl + 255;
    hdr.ipv4.ttl = hdr.ipv4.ttl + 255; }
  action lookup_flowlet_map_0/lookup_flowlet_map() {
    tmp_18.field_5 = hdr.ipv4.srcAddr;
    tmp_18.field_6 = hdr.ipv4.dstAddr;
    tmp_18.field_7 = hdr.ipv4.protocol;
    tmp_18.field_8 = hdr.tcp.srcPort;
    tmp_18.field_9 = hdr.tcp.dstPort;
    hash<bit<13>, bit<13>, tuple_1, bit<26>>(tmp_17, <TypeNameExpression>(164195)HashAlgorithm.crc16, 0, tmp_18, 13);
    meta.ingress_metadata.flowlet_map_index = tmp_17;
    tmp_20 = (bit<32>)meta.ingress_metadata.flowlet_map_index;
    flowlet_id_1/flowlet_id.read(tmp_19, (bit<32>)meta.ingress_metadata.flowlet_map_index);
    meta.ingress_metadata.flowlet_id = tmp_19;
    meta.ingress_metadata.flow_ipg = (bit<32>)meta.intrinsic_metadata.ingress_global_timestamp;
    tmp_22 = (bit<32>)meta.ingress_metadata.flowlet_map_index;
    flowlet_lasttime_1/flowlet_lasttime.read(tmp_21, (bit<32>)meta.ingress_metadata.flowlet_map_index);
    meta.ingress_metadata.flowlet_lasttime = tmp_21;
    tmp_23 = meta.ingress_metadata.flow_ipg - meta.ingress_metadata.flowlet_lasttime;
    meta.ingress_metadata.flow_ipg = meta.ingress_metadata.flow_ipg - meta.ingress_metadata.flowlet_lasttime;
    flowlet_lasttime_1/flowlet_lasttime.write((bit<32>)meta.ingress_metadata.flowlet_map_index, (bit<32>)meta.intrinsic_metadata.ingress_global_timestamp); }
  action set_dmac_0/set_dmac( bit<48> dmac) {
    hdr.ethernet.dstAddr = dmac; }
  action update_flowlet_id_0/update_flowlet_id() {
    tmp_24 = meta.ingress_metadata.flowlet_id + 1;
    meta.ingress_metadata.flowlet_id = meta.ingress_metadata.flowlet_id + 1;
    flowlet_id_1/flowlet_id.write((bit<32>)meta.ingress_metadata.flowlet_map_index, (bit<16>)meta.ingress_metadata.flowlet_id); }
  table ecmp_group() @name("ecmp_group") {
    actions = { _drop_1/_drop_2();
      set_ecmp_select_0/set_ecmp_select();
      NoAction_1/NoAction_3(); }
    key = { hdr.ipv4.dstAddr: lpm; }
    size = 1024
    default_action = NoAction_1/NoAction_3(); }
  table ecmp_nhop() @name("ecmp_nhop") {
    actions = { _drop_5/_drop_3();
      set_nhop_0/set_nhop();
      NoAction_8/NoAction_4(); }
    key = { meta.ingress_metadata.ecmp_offset: exact; }
    size = 16384
    default_action = NoAction_8/NoAction_4(); }
  table flowlet() @name("flowlet") {
    actions = { lookup_flowlet_map_0/lookup_flowlet_map();
      NoAction_9/NoAction_5(); }
    default_action = NoAction_9/NoAction_5(); }
  table forward() @name("forward") {
    actions = { set_dmac_0/set_dmac();
      _drop_6/_drop_4();
      NoAction_10/NoAction_6(); }
    key = { meta.ingress_metadata.nhop_ipv4: exact; }
    size = 512
    default_action = NoAction_10/NoAction_6(); }
  table new_flowlet() @name("new_flowlet") {
    actions = { update_flowlet_id_0/update_flowlet_id();
      NoAction_11/NoAction_7(); }
    default_action = NoAction_11/NoAction_7(); }
  action act() {
    tmp_25 = meta.ingress_metadata.flow_ipg > 50000; }
  table tbl_act() {
    actions = { act(); }
    const default_action = act(); }
  { flowlet.apply();
    tbl_act.apply();
    if (tmp_25) {
      new_flowlet.apply(); } }
  ecmp_group.apply();
  ecmp_nhop.apply();
  forward.apply(); }
control DeparserImpl() {
  packet.emit<ethernet_t>(hdr.ethernet);
  packet.emit<ipv4_t>(hdr.ipv4);
  packet.emit<tcp_t>(hdr.tcp); }
struct tuple_2 {
  bit<4> field_10;
  bit<4> field_11;
  bit<8> field_12;
  bit<16> field_13;
  bit<16> field_14;
  bit<3> field_15;
  bit<13> field_16;
  bit<8> field_17;
  bit<8> field_18;
  bit<32> field_19;
  bit<32> field_20; }
control verifyChecksum() {
  bit<16> tmp_26
  bool tmp_27
  @name("ipv4_checksum") Checksum16 ipv4_checksum()
  action act_0() {
    mark_to_drop(); }
  action act_1() {
    tmp_27 = hdr.ipv4.hdrChecksum == tmp_26; }
  table tbl_act_0() {
    actions = { act_1(); }
    const default_action = act_1(); }
  table tbl_act_1() {
    actions = { act_0(); }
    const default_action = act_0(); }
  tmp_26 = ipv4_checksum.get<tuple_2>({hdr.ipv4.version, hdr.ipv4.ihl, hdr.ipv4.diffserv, hdr.ipv4.totalLen, hdr.ipv4.identification, hdr.ipv4.flags, hdr.ipv4.fragOffset, hdr.ipv4.ttl, hdr.ipv4.protocol, hdr.ipv4.srcAddr, hdr.ipv4.dstAddr});
  tbl_act_0.apply();
  if (tmp_27) {
    tbl_act_1.apply(); } }
control computeChecksum() {
  bit<16> tmp_28
  @name("ipv4_checksum") Checksum16 ipv4_checksum_2/ipv4_checksum()
  action act_2() {
    hdr.ipv4.hdrChecksum = tmp_28; }
  table tbl_act_2() {
    actions = { act_2(); }
    const default_action = act_2(); }
  tmp_28 = ipv4_checksum_2/ipv4_checksum.get<tuple_2>({hdr.ipv4.version, hdr.ipv4.ihl, hdr.ipv4.diffserv, hdr.ipv4.totalLen, hdr.ipv4.identification, hdr.ipv4.flags, hdr.ipv4.fragOffset, hdr.ipv4.ttl, hdr.ipv4.protocol, hdr.ipv4.srcAddr, hdr.ipv4.dstAddr});
  tbl_act_2.apply(); }
V1Switch<headers, metadata> main(ParserImpl(), verifyChecksum(), ingress(), egress(), computeChecksum(), DeparserImpl())
