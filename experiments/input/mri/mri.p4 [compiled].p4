error { NoError, PacketTooShort, NoMatch, StackOutOfBounds, HeaderTooShort, ParserTimeout, IPHeaderTooShort }
extern packet_in<> {
  void extract<T>(out T hdr);
  void extract<T>(out T variableSizeHeader, in bit<32> variableFieldSizeInBits);
  T lookahead<T>();
  void advance<>(in bit<32> sizeInBits);
  bit<32> length<>(); }
extern packet_out<> {
  void emit<T>(in T hdr); }
void verify<>(in bool check, in error toSignal)
match_kind { exact, ternary, lpm }
match_kind { range, selector }
struct standard_metadata @metadata @name("standard_metadata") {
  bit<9> ingress_port;
  bit<9> egress_spec;
  bit<9> egress_port;
  bit<32> clone_spec;
  bit<32> instance_type;
  bit<1> drop;
  bit<16> recirculate_port;
  bit<32> packet_length;
  @alias("queueing_metadata.enq_timestamp") bit<32> enq_timestamp;
  @alias("queueing_metadata.enq_qdepth") bit<19> enq_qdepth;
  @alias("queueing_metadata.deq_timedelta") bit<32> deq_timedelta;
  @alias("queueing_metadata.deq_qdepth") bit<19> deq_qdepth;
  @alias("intrinsic_metadata.ingress_global_timestamp") bit<48> ingress_global_timestamp;
  @alias("intrinsic_metadata.lf_field_list") bit<32> lf_field_list;
  @alias("intrinsic_metadata.mcast_grp") bit<16> mcast_grp;
  @alias("intrinsic_metadata.resubmit_flag") bit<1> resubmit_flag;
  @alias("intrinsic_metadata.egress_rid") bit<16> egress_rid; }
extern Checksum16<> {
  <null> Checksum16<>();
  bit<16> get<D>(in D data); }
<Type_Enum>(296)
<Type_Enum>(300)
extern counter<> {
  <null> counter<>( bit<32> size,  CounterType type);
  void count<>(in bit<32> index); }
extern direct_counter<> {
  <null> direct_counter<>( CounterType type);
  void count<>(); }
extern meter<> {
  <null> meter<>( bit<32> size,  MeterType type);
  void execute_meter<T>(in bit<32> index, out T result); }
extern direct_meter<T> {
  <null> direct_meter<>( MeterType type);
  void read<>(out T result); }
extern register<T> {
  <null> register<>( bit<32> size);
  void read<>(out T result, in bit<32> index);
  void write<>(in bit<32> index, in T value); }
extern action_profile<> {
  <null> action_profile<>( bit<32> size); }
<Type_Enum>(489)
void mark_to_drop<>()
extern action_selector<> {
  <null> action_selector<>( HashAlgorithm algorithm,  bit<32> size,  bit<32> outputWidth); }
parser Parser<H, M>( packet_in b, out H parsedHdr, inout M meta, inout standard_metadata_t standard_metadata);
control VerifyChecksum<H, M>(in H hdr, inout M meta);
control Ingress<H, M>(inout H hdr, inout M meta, inout standard_metadata_t standard_metadata)@pipeline ;
control Egress<H, M>(inout H hdr, inout M meta, inout standard_metadata_t standard_metadata)@pipeline ;
control ComputeChecksum<H, M>(inout H hdr, inout M meta);
control Deparser<H>( packet_out b, in H hdr)@deparser ;
package V1Switch<H, M>( Parser<H, M> p,  VerifyChecksum<H, M> vr,  Ingress<H, M> ig,  Egress<H, M> eg,  ComputeChecksum<H, M> ck,  Deparser<H> dep);
<Type_Typedef>(787)
<Type_Typedef>(790)
<Type_Typedef>(793)
<Type_Typedef>(796)
header ethernet_t {
  macAddr_t dstAddr;
  macAddr_t srcAddr;
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
  ip4Addr_t srcAddr;
  ip4Addr_t dstAddr; }
header ipv4_option_t {
  bit<1> copyFlag;
  bit<2> optClass;
  bit<5> option;
  bit<8> optionLength; }
header mri_t {
  bit<16> count; }
header switch_t {
  switchID_t swid; }
struct ingress_metadata_t {
  bit<16> count; }
struct parser_metadata_t {
  bit<16> remaining; }
struct metadata {
  ingress_metadata_t ingress_metadata;
  parser_metadata_t parser_metadata; }
struct headers {
  ethernet_t ethernet;
  ipv4_t ipv4;
  ipv4_option_t ipv4_option;
  mri_t mri;
  switch_t[9] swids; }
parser ParserImpl() {
  bool tmp_7
  bit<16> tmp_8
  state start {
    packet.extract<ethernet_t>(hdr.ethernet);
    select{hdr.ethernet.etherType} {
      2048: parse_ipv4
      default: accept } }
  state parse_ipv4 {
    packet.extract<ipv4_t>(hdr.ipv4);
    tmp_7 = hdr.ipv4.ihl >= 5;
    verify(tmp_7, <TypeNameExpression>(139454)error.IPHeaderTooShort);
    select{hdr.ipv4.ihl} {
      5: accept
      default: parse_ipv4_option } }
  state parse_ipv4_option {
    packet.extract<ipv4_option_t>(hdr.ipv4_option);
    select{hdr.ipv4_option.option} {
      31: parse_mri
      default: accept } }
  state parse_mri {
    packet.extract<mri_t>(hdr.mri);
    meta.parser_metadata.remaining = hdr.mri.count;
    select{meta.parser_metadata.remaining} {
      0: accept
      default: parse_swid } }
  state parse_swid {
    packet.extract<switch_t>(hdr.swids.next);
    tmp_8 = meta.parser_metadata.remaining + 65535;
    meta.parser_metadata.remaining = tmp_8;
    select{meta.parser_metadata.remaining} {
      0: accept
      default: parse_swid } }
  state accept { }
  state reject { } }
control verifyChecksum() { }
control ingress() {
  bit<4> tmp_9
  bit<16> tmp_10
  bit<4> tmp_11
  bit<8> tmp_12
  bit<8> tmp_13
  action NoAction_0/NoAction_1() { }
  action NoAction_3/NoAction_2() { }
  action drop_0/drop_1() {
    mark_to_drop(); }
  action add_mri_option_0/add_mri_option() {
    hdr.ipv4_option.setValid();
    hdr.ipv4_option.copyFlag = 1;
    hdr.ipv4_option.optClass = 2;
    hdr.ipv4_option.option = 31;
    hdr.ipv4_option.optionLength = 4;
    hdr.mri.setValid();
    hdr.mri.count = 0;
    tmp_9 = hdr.ipv4.ihl + 1;
    hdr.ipv4.ihl = hdr.ipv4.ihl + 1; }
  action add_swid_0/add_swid( switchID_t id) {
    tmp_10 = hdr.mri.count + 1;
    hdr.mri.count = hdr.mri.count + 1;
    hdr.swids.push_front(1);
    hdr.swids[0].swid = id;
    tmp_11 = hdr.ipv4.ihl + 1;
    hdr.ipv4.ihl = hdr.ipv4.ihl + 1;
    tmp_12 = hdr.ipv4_option.optionLength + 4;
    hdr.ipv4_option.optionLength = hdr.ipv4_option.optionLength + 4; }
  action ipv4_forward_0/ipv4_forward( macAddr_t dstAddr,  egressSpec_t port) {
    standard_metadata.egress_spec = port;
    hdr.ethernet.srcAddr = hdr.ethernet.dstAddr;
    hdr.ethernet.dstAddr = dstAddr;
    tmp_13 = hdr.ipv4.ttl + 255;
    hdr.ipv4.ttl = hdr.ipv4.ttl + 255; }
  table swid_1/swid() @name("swid") {
    actions = { add_swid_0/add_swid();
      NoAction_0/NoAction_1(); }
    default_action = NoAction_0/NoAction_1(); }
  table ipv4_lpm() @name("ipv4_lpm") {
    key = { hdr.ipv4.dstAddr: lpm; }
    actions = { ipv4_forward_0/ipv4_forward();
      drop_0/drop_1();
      NoAction_3/NoAction_2(); }
    size = 1024
    default_action = NoAction_3/NoAction_2(); }
  table tbl_add_mri_option() {
    actions = { add_mri_option_0(); }
    const default_action = add_mri_option_0/add_mri_option(); }
  if (hdr.ipv4.isValid()) {
    { ipv4_lpm.apply();
      if (!hdr.mri.isValid()) {
        tbl_add_mri_option.apply(); }
      swid_1/swid.apply(); } } }
control egress() { }
struct tuple_0 {
  bit<4> field;
  bit<4> field_0;
  bit<8> field_1;
  bit<16> field_2;
  bit<16> field_3;
  bit<3> field_4;
  bit<13> field_5;
  bit<8> field_6;
  bit<8> field_7;
  bit<32> field_8;
  bit<32> field_9; }
control computeChecksum() {
  bit<16> tmp_14
  @name("ipv4_checksum") Checksum16 ipv4_checksum()
  action act() {
    hdr.ipv4.hdrChecksum = tmp_14; }
  table tbl_act() {
    actions = { act(); }
    const default_action = act(); }
  if (hdr.ipv4.isValid()) {
    { tmp_14 = ipv4_checksum.get<tuple_0>({hdr.ipv4.version, hdr.ipv4.ihl, hdr.ipv4.diffserv, hdr.ipv4.totalLen, hdr.ipv4.identification, hdr.ipv4.flags, hdr.ipv4.fragOffset, hdr.ipv4.ttl, hdr.ipv4.protocol, hdr.ipv4.srcAddr, hdr.ipv4.dstAddr});
      tbl_act.apply(); } } }
control DeparserImpl() {
  packet.emit<ethernet_t>(hdr.ethernet);
  packet.emit<ipv4_t>(hdr.ipv4);
  packet.emit<ipv4_option_t>(hdr.ipv4_option);
  packet.emit<mri_t>(hdr.mri);
  packet.emit<switch_t[9]>(hdr.swids); }
V1Switch<headers, metadata> main(ParserImpl(), verifyChecksum(), ingress(), egress(), computeChecksum(), DeparserImpl())
