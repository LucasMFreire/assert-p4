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
<Type_Typedef>(613)
header hash_t {
  bit<16> hash; }
header ipv4_t {
  bit<32> lkp_ipv4_sa; }
struct M {
  hash_t hash;
  ipv4_t ipv4; }
struct H { }
parser ParserI() {
  state start {
    accept; }
  state accept { }
  state reject { } }
control VerifyChecksumI() { }
control ComputeChecksumI() { }
struct tuple_0 {
  bit<32> field; }
control IngressI() {
  bit<16> tmp_1
  tuple_0 tmp_2
  action a_0/a() {
    tmp_2.field = meta.ipv4.lkp_ipv4_sa;
    hash<bit<16>, bit<16>, tuple_0, bit<32>>(tmp_1, <TypeNameExpression>(66567)HashAlgorithm.crc16, 0, tmp_2, 65536);
    meta.hash.hash = tmp_1; }
  table tbl_a() {
    actions = { a_0(); }
    const default_action = a_0/a(); }
  tbl_a.apply(); }
control EgressI() { }
control DeparserI() { }
V1Switch<H, M> main(ParserI(), VerifyChecksumI(), IngressI(), EgressI(), ComputeChecksumI(), DeparserI())
