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
header data_h {
  bit<32> f1;
  bit<32> f2;
  bit<16> h1;
  bit<8> b1;
  bit<8> b2; }
header extra_h {
  bit<16> h;
  bit<8> b1;
  bit<8> b2; }
struct packet_t {
  data_h data;
  extra_h[4] extra; }
struct Meta { }
parser p() {
  state start {
    b.extract<data_h>(hdrs.data);
    extra; }
  state extra {
    b.extract<extra_h>(hdrs.extra.next);
    select{hdrs.extra.last.b2} {
      128 &&& 128: extra
      default: accept } }
  state accept { }
  state reject { } }
control vrfy() { }
control update() { }
control ingress() {
  bit<8> reg_0/reg
  bit<8> reg_1/reg
  bit<8> reg_2/reg
  bit<8> reg_3/reg
  action setb1_0/setb1( bit<9> port,  bit<8> val) {
    hdrs.data.b1 = val;
    meta.egress_spec = port; }
  action noop_0/noop() { }
  action noop_5/noop_1() { }
  action noop_6/noop_2() { }
  action noop_7/noop_3() { }
  action noop_8/noop_4() { }
  action setbyte_0/setbyte( bit<8> val) {
    reg_0/reg = val;
    hdrs.extra[0].b1 = val; }
  action setbyte_4/setbyte_1( bit<8> val) {
    reg_1/reg = val;
    hdrs.data.b2 = val; }
  action setbyte_5/setbyte_2( bit<8> val) {
    reg_2/reg = val;
    hdrs.extra[1].b1 = val; }
  action setbyte_6/setbyte_3( bit<8> val) {
    reg_3/reg = val;
    hdrs.extra[2].b2 = val; }
  action act1_0/act1( bit<8> val) {
    hdrs.extra[0].b1 = val; }
  action act2_0/act2( bit<8> val) {
    hdrs.extra[0].b1 = val; }
  action act3_0/act3( bit<8> val) {
    hdrs.extra[0].b1 = val; }
  table test1() @name("test1") {
    key = { hdrs.data.f1: ternary; }
    actions = { setb1_0/setb1();
      noop_0/noop(); }
    default_action = noop_0/noop(); }
  table ex1() @name("ex1") {
    key = { hdrs.extra[0].h: ternary; }
    actions = { setbyte_0/setbyte();
      act1_0/act1();
      act2_0/act2();
      act3_0/act3();
      noop_5/noop_1(); }
    default_action = noop_5/noop_1(); }
  table tbl1() @name("tbl1") {
    key = { hdrs.data.f2: ternary; }
    actions = { setbyte_4/setbyte_1();
      noop_6/noop_2(); }
    default_action = noop_6/noop_2(); }
  table tbl2() @name("tbl2") {
    key = { hdrs.data.f2: ternary; }
    actions = { setbyte_5/setbyte_2();
      noop_7/noop_3(); }
    default_action = noop_7/noop_3(); }
  table tbl3() @name("tbl3") {
    key = { hdrs.data.f2: ternary; }
    actions = { setbyte_6/setbyte_3();
      noop_8/noop_4(); }
    default_action = noop_8/noop_4(); }
  test1.apply();
  <SwitchStatement>(94489) }
control egress() { }
control deparser() {
  b.emit<data_h>(hdrs.data);
  b.emit<extra_h[4]>(hdrs.extra); }
V1Switch<packet_t, Meta> main(p(), vrfy(), ingress(), egress(), update(), deparser())
