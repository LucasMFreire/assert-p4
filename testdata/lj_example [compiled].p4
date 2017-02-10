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
<Type_Typedef>(110)
struct InControl {
  PortId inputPort; }
struct OutControl {
  PortId outputPort; }
parser Parser<H>( packet_in b, out H parsedHeaders);
control Pipe<H>(inout H headers, in error parseError, in InControl inCtrl, out OutControl outCtrl);
control Deparser<H>(inout H outputHeaders,  packet_out b);
package VSS<H>( Parser<H> p,  Pipe<H> map,  Deparser<H> d);
extern Ck16<> {
  <null> Ck16<>();
  void clear<>();
  void update<T>(in T data);
  bit<16> get<>(); }
header ARPA_hdr {
  bit<48> src;
  bit<48> dest;
  bit<16> etype; }
struct Parsed_rep {
  ARPA_hdr arpa_pak; }
parser LJparse() {
  state start {
    b.extract<ARPA_hdr>(p.arpa_pak);
    accept; }
  state accept { }
  state reject { } }
control LjPipe() {
  PortId port_0/port
  action Drop_action_0/Drop_action() {
    port_0/port = 15;
    outCtrl.outputPort = 15; }
  action Drop/Drop_0() {
    outCtrl.outputPort = 15; }
  action Forward_0/Forward( PortId outPort) {
    outCtrl.outputPort = outPort; }
  table Enet_lkup() @name("Enet_lkup") {
    key = { p.arpa_pak.dest: exact; }
    actions = { Drop_action_0/Drop_action();
      Drop/Drop_0();
      Forward_0/Forward(); }
    default_action = Drop/Drop_0(); }
  action act() {
    outCtrl.outputPort = 15; }
  table tbl_act() {
    actions = { act(); }
    const default_action = act(); }
  tbl_act.apply();
  if (p.arpa_pak.isValid()) {
    Enet_lkup.apply(); } }
control LJdeparse() {
  b.emit<ARPA_hdr>(p.arpa_pak); }
VSS<Parsed_rep> main(LJparse(), LjPipe(), LJdeparse())
