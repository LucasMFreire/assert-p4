error { NoError, PacketTooShort, NoMatch, EmptyStack, FullStack, OverwritingHeader, HeaderTooShort, ParserTimeout }

extern packet_in<> {
  void extract<T>(out T hdr);
  void extract<T>(out T variableSizeHeader, in bit<32> variableFieldSizeInBits);
  T lookahead<T>();
  void advance<>(in bit<32> sizeInBits);
  bit<32> length<>(); }

extern packet_out<> {
  void emit<T>(in T hdr); }
action NoAction() { }

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

extern action_selector<> {
  <null> action_selector<>( HashAlgorithm algorithm,  bit<32> size,  bit<32> outputWidth); }
parser Parser<H, M>( packet_in b, out H parsedHdr, inout M meta, inout standard_metadata_t standard_metadata);
control VerifyChecksum<H, M>(in H hdr, inout M meta);
control Ingress<H, M>(inout H hdr, inout M meta, inout standard_metadata_t standard_metadata);
control Egress<H, M>(inout H hdr, inout M meta, inout standard_metadata_t standard_metadata);
control ComputeChecksum<H, M>(inout H hdr, inout M meta);
control Deparser<H>( packet_out b, in H hdr);
package V1Switch<H, M>( Parser<H, M> p,  VerifyChecksum<H, M> vr,  Ingress<H, M> ig,  Egress<H, M> eg,  ComputeChecksum<H, M> ck,  Deparser<H> dep);
<Type_Typedef>(614)
<Type_Typedef>(617)
<Type_Typedef>(621)

header ethernet_t {
  EthernetAddress dstAddr;
  EthernetAddress srcAddr;
  bit<16> etherType; 
}

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
  IPv4Address srcAddr;
  IPv4Address dstAddr; 
}

header udp_t {
  bit<16> srcPort;
  bit<16> dstPort;
  bit<16> length_;
  bit<16> checksum; 
}

header paxos_t {
  bit<16> msgtype;
  bit<32> inst;
  bit<16> rnd;
  bit<16> vrnd;
  bit<16> acptid;
  bit<32> paxoslen;
  bit<256> paxosval;
}

struct headers {
  ethernet_t ethernet;
  ipv4_t ipv4;
  udp_t udp;
  paxos_t paxos; 
}

struct paxos_metadata_t {
  bit<16> round;
  bit<1> set_drop;
  bit<8> ack_count;
  bit<8> ack_acceptors; 
}

struct metadata {
  paxos_metadata_t paxos_metadata; 
}

parser TopParser() {
  state start {
    b.extract<ethernet_t>(p.ethernet);
    select{p.ethernet.etherType} {
      2048: parse_ipv4 } }
  state parse_ipv4 {
    b.extract<ipv4_t>(p.ipv4);
    select{p.ipv4.protocol} {
      17: parse_udp
      default: accept } 
  }
  state parse_udp {
    b.extract<udp_t>(p.udp);
    select{p.udp.dstPort} {
      34952: parse_paxos
      default: accept } 
  }
  state parse_paxos {
    b.extract<paxos_t>(p.paxos);
    accept; 
  }
  state accept { }
  state reject { } 
}

control TopDeparser() {
  packet.emit<ethernet_t>(hdr.ethernet);
  packet.emit<ipv4_t>(hdr.ipv4);
  packet.emit<udp_t>(hdr.udp);
  packet.emit<paxos_t>(hdr.paxos); 
}

control verifyChecksum() {
  bit<16> tmp
  bool tmp_0
  @name("ipv4_checksum") Checksum16 ipv4_checksum_0/ipv4_checksum()
  tmp = ipv4_checksum_0/ipv4_checksum.get<tuple<bit<4>, bit<4>, bit<8>, bit<16>, bit<16>, bit<3>, bit<13>, bit<8>, bit<8>, bit<32>, bit<32>>>({hdr.ipv4.version, hdr.ipv4.ihl, hdr.ipv4.diffserv, hdr.ipv4.totalLen, hdr.ipv4.identification, hdr.ipv4.flags, hdr.ipv4.fragOffset, hdr.ipv4.ttl, hdr.ipv4.protocol, hdr.ipv4.srcAddr, hdr.ipv4.dstAddr});
  tmp_0 = hdr.ipv4.hdrChecksum == tmp;
  if (tmp_0) {
    mark_to_drop(); 
  } 
}

control computeChecksum() {
  bit<16> tmp_1
  @name("ipv4_checksum") Checksum16 ipv4_checksum_1/ipv4_checksum()
  tmp_1 = ipv4_checksum_1/ipv4_checksum.get<tuple<bit<4>, bit<4>, bit<8>, bit<16>, bit<16>, bit<3>, bit<13>, bit<8>, bit<8>, bit<32>, bit<32>>>({hdr.ipv4.version, hdr.ipv4.ihl, hdr.ipv4.diffserv, hdr.ipv4.totalLen, hdr.ipv4.identification, hdr.ipv4.flags, hdr.ipv4.fragOffset, hdr.ipv4.ttl, hdr.ipv4.protocol, hdr.ipv4.srcAddr, hdr.ipv4.dstAddr});
  hdr.ipv4.hdrChecksum = tmp_1; }

control ingress() {
  bit<16> tmp_2
  bit<32> tmp_3
  bit<16> tmp_4
  bit<32> tmp_5
  bit<256> tmp_6
  bit<32> tmp_7
  bit<16> tmp_8
  bit<16> tmp_9
  bool tmp_10
  @name("registerAcceptorID") register<bit<16>> registerAcceptorID_0/registerAcceptorID(1)
  @name("registerRound") register<bit<16>> registerRound_0/registerRound(65536)
  @name("registerVRound") register<bit<16>> registerVRound_0/registerVRound(65536)
  @name("registerValue") register<bit<256>> registerValue_0/registerValue(65536)

  action _drop_0/_drop() {
    mark_to_drop(); }

  action read_round_0/read_round() {
    tmp_3 = hdr.paxos.inst;
    registerRound_0/registerRound.read(tmp_2, tmp_3);
    meta.paxos_metadata.round = tmp_2;
    meta.paxos_metadata.set_drop = 1; }

  action handle_1a_0/handle_1a() {
    hdr.paxos.msgtype = 1;
    tmp_5 = hdr.paxos.inst;
    registerVRound_0/registerVRound.read(tmp_4, tmp_5);
    hdr.paxos.vrnd = tmp_4;
    tmp_7 = hdr.paxos.inst;
    registerValue_0/registerValue.read(tmp_6, tmp_7);
    hdr.paxos.paxosval = tmp_6;
    registerAcceptorID_0/registerAcceptorID.read(tmp_8, 0);
    hdr.paxos.acptid = tmp_8;
    registerRound_0/registerRound.write(hdr.paxos.inst, hdr.paxos.rnd);
    meta.paxos_metadata.set_drop = 0; }

  action handle_2a_0/handle_2a() {
    hdr.paxos.msgtype = 3;
    registerAcceptorID_0/registerAcceptorID.read(tmp_9, 0);
    hdr.paxos.acptid = tmp_9;
    registerRound_0/registerRound.write(hdr.paxos.inst, hdr.paxos.rnd);
    registerVRound_0/registerVRound.write(hdr.paxos.inst, hdr.paxos.rnd);
    registerValue_0/registerValue.write(hdr.paxos.inst, hdr.paxos.paxosval);
    meta.paxos_metadata.set_drop = 0; }

  table acceptor_tbl_0/acceptor_tbl() @name("acceptor_tbl") {
    key = { hdr.paxos.msgtype: exact; }
    actions = { handle_1a_0/handle_1a();
      handle_2a_0/handle_2a();
      _drop_0/_drop(); }
    size = 4
    default_action = _drop_0/_drop(); }

  action forward_0/forward( PortId port,  bit<16> learnerPort) {
    standard_metadata.egress_spec = (bit<9>)port;
    hdr.udp.dstPort = learnerPort; }

  table transport_tbl_0/transport_tbl() @name("transport_tbl") {
    key = { meta.paxos_metadata.set_drop: exact; }
    actions = { _drop_0/_drop();
      forward_0/forward(); }
    size = 2
    default_action = _drop_0/_drop(); }

  if (hdr.ipv4.isValid()) {
    if (hdr.paxos.isValid()) {
      { read_round_0/read_round();
        tmp_10 = hdr.paxos.rnd >= meta.paxos_metadata.round;
        if (tmp_10) {
          { acceptor_tbl_0/acceptor_tbl.apply();
            transport_tbl_0/transport_tbl.apply(); }
          }
      } 
    } 
  } 
}

control egress() {
  table place_holder_table_0/place_holder_table() @name("place_holder_table") {
    actions = { NoAction(); }
    size = 2
    default_action = NoAction(); }

  place_holder_table_0/place_holder_table.apply(); 
}

V1Switch<headers, metadata> main(TopParser(), verifyChecksum(), ingress(), egress(), computeChecksum(), TopDeparser())
