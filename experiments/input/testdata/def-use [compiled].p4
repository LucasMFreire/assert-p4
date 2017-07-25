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
extern action_selector<> {
  <null> action_selector<>( HashAlgorithm algorithm,  bit<32> size,  bit<32> outputWidth); }
parser Parser<H, M>( packet_in b, out H parsedHdr, inout M meta, inout standard_metadata_t standard_metadata);
control VerifyChecksum<H, M>(in H hdr, inout M meta);
control Ingress<H, M>(inout H hdr, inout M meta, inout standard_metadata_t standard_metadata);
control Egress<H, M>(inout H hdr, inout M meta, inout standard_metadata_t standard_metadata);
control ComputeChecksum<H, M>(inout H hdr, inout M meta);
control Deparser<H>( packet_out b, in H hdr);
package V1Switch<H, M>( Parser<H, M> p,  VerifyChecksum<H, M> vr,  Ingress<H, M> ig,  Egress<H, M> eg,  ComputeChecksum<H, M> ck,  Deparser<H> dep);
<Type_Typedef>(613)
struct H { }
struct M { }
parser ParserI() {
  state start {
    accept; }
  state accept { }
  state reject { } }
control IngressI() { }
control EgressI() {
  struct standard_metadata_t {
    bit<9> ingress_port;
    bit<9> egress_spec;
    bit<9> egress_port;
    bit<32> clone_spec;
    bit<32> instance_type;
    bit<1> drop;
    bit<16> recirculate_port;
    bit<32> packet_length; } tmp
  bool hasReturned_0
  action a_0/a() { }
  table t() @name("t") {
    key = { }
    actions = { a_0/a(); }
    default_action = a_0/a(); }
  action act() {
    hasReturned_0 = 1; }
  action act_0() {
    tmp.ingress_port = std_meta.ingress_port;
    tmp.egress_spec = std_meta.egress_spec;
    tmp.egress_port = std_meta.egress_port;
    tmp.clone_spec = std_meta.clone_spec;
    tmp.instance_type = std_meta.instance_type;
    tmp.drop = std_meta.drop;
    tmp.recirculate_port = std_meta.recirculate_port;
    tmp.packet_length = std_meta.packet_length;
    std_meta.ingress_port = tmp.ingress_port;
    std_meta.egress_spec = tmp.egress_spec;
    std_meta.egress_port = tmp.egress_port;
    std_meta.clone_spec = tmp.clone_spec;
    std_meta.instance_type = tmp.instance_type;
    std_meta.drop = tmp.drop;
    std_meta.recirculate_port = tmp.recirculate_port;
    std_meta.packet_length = tmp.packet_length; }
  action act_1() {
    hasReturned_0 = 0; }
  table tbl_act() {
    actions = { act_1(); }
    const default_action = act_1(); }
  table tbl_act_0() {
    actions = { act(); }
    const default_action = act(); }
  table tbl_act_1() {
    actions = { act_0(); }
    const default_action = act_0(); }
  tbl_act.apply();
  <SwitchStatement>(73529) }
control VerifyChecksumI() { }
control ComputeChecksumI() { }
control DeparserI() { }
V1Switch<H, M> main(ParserI(), VerifyChecksumI(), IngressI(), EgressI(), ComputeChecksumI(), DeparserI())
