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
struct Headers_t { }
parser prs() {
  state start {
    accept; }
  state accept { }
  state reject { } }
control pipe() {
  bool x
  bool rej
  action Reject_0/Reject() {
    rej = x;
    pass = x; }
  action act() {
    x = 1; }
  table tbl_act() {
    actions = { act(); }
    const default_action = act(); }
  table tbl_Reject() {
    actions = { Reject_0(); }
    const default_action = Reject_0/Reject(); }
  tbl_act.apply();
  tbl_Reject.apply(); }
ebpfFilter<Headers_t> main(prs(), pipe())
