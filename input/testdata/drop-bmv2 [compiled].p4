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
struct H { }
struct M { }
parser ParserI() {
  state start {
    accept; }
  state accept { }
  state reject { } }
control IngressI() {
  standard_metadata_t smeta_0/smeta
  action drop_0/drop_1() {
    smeta_0/smeta.drop = 1;
    smeta.ingress_port = smeta_0/smeta.ingress_port;
    smeta.egress_spec = smeta_0/smeta.egress_spec;
    smeta.egress_port = smeta_0/smeta.egress_port;
    smeta.clone_spec = smeta_0/smeta.clone_spec;
    smeta.instance_type = smeta_0/smeta.instance_type;
    smeta.drop = smeta_0/smeta.drop;
    smeta.recirculate_port = smeta_0/smeta.recirculate_port;
    smeta.packet_length = smeta_0/smeta.packet_length; }
  table forward() @name("forward") {
    key = { }
    actions = { drop_0/drop_1(); }
    const default_action = drop_0/drop_1(); }
  forward.apply(); }
control EgressI() { }
control DeparserI() { }
control VerifyChecksumI() { }
control ComputeChecksumI() { }
V1Switch<H, M> main(ParserI(), VerifyChecksumI(), IngressI(), EgressI(), ComputeChecksumI(), DeparserI())
