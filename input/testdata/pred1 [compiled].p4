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
control empty<>();
package top<>( empty e);
control Ing() {
  bool b
  bit<32> a
  bool tmp_1
  bool tmp_2
  bool cond
  action cond_0/cond() {
    b = 1;
    cond = 1;
    a = 1 ? 5 : a;
    cond = !1;
    cond = !1;
    tmp_1 = !1 && !1 ? 0 : tmp_1;
    cond = !!1;
    tmp_2 = !1 && !!1 ? (1 ? 5 : a) == 5 : tmp_2;
    tmp_1 = !1 && !!1 ? !1 && !!1 ? (1 ? 5 : a) == 5 : tmp_2 : !1 && !1 ? 0 : tmp_1;
    cond = !1 && !!1 ? !1 && !!1 ? (1 ? 5 : a) == 5 : tmp_2 : !1 && !1 ? 0 : tmp_1;
    a = !1 && (!1 && !!1 ? !1 && !!1 ? (1 ? 5 : a) == 5 : tmp_2 : !1 && !1 ? 0 : tmp_1) ? 10 : 1 ? 5 : a;
    cond = !cond;
    a = !1 && !cond ? 20 : !1 && (!1 && !!1 ? !1 && !!1 ? (1 ? 5 : a) == 5 : tmp_2 : !1 && !1 ? 0 : tmp_1) ? 10 : 1 ? 5 : a; }
  table tbl_cond() {
    actions = { cond_0(); }
    const default_action = cond_0/cond(); }
  tbl_cond.apply(); }
top main(Ing())
