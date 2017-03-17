error { NoError, PacketTooShort, NoMatch, EmptyStack, FullStack, OverwritingHeader, HeaderTooShort, ParserTimeout, IPv4OptionsNotSupported, IPv4IncorrectVersion, IPv4ChecksumError }

extern packet_in<> {
  void extract<T>(out T hdr);
  void extract<T>(out T variableSizeHeader, in bit<32> variableFieldSizeInBits);
  T lookahead<T>();
  void advance<>(in bit<32> sizeInBits);
  bit<32> length<>(); 
}

extern packet_out<> {
  void emit<T>(in T hdr); 
}

void verify<>(in bool check, in error toSignal)

match_kind { exact, ternary, lpm }

<Type_Typedef>(110)

struct InControl {
  PortId inputPort; 
}

struct OutControl {
  PortId outputPort; 
}

parser Parser<H>( packet_in b, out H parsedHeaders);

control Pipe<H>(inout H headers, in error parseError, in InControl inCtrl, out OutControl outCtrl);

control Deparser<H>(inout H outputHeaders,  packet_out b);

package VSS<H>( Parser<H> p,  Pipe<H> map,  Deparser<H> d);

extern Ck16<> {
  <null> Ck16<>();
  void clear<>();
  void update<T>(in T data);
  bit<16> get<>(); 
}

<Type_Typedef>(258)

<Type_Typedef>(261)

header Ethernet_h {
  EthernetAddress dstAddr;
  EthernetAddress srcAddr;
  bit<16> etherType; 
}

header Ipv4_h {
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

struct Parsed_packet {
  Ethernet_h ethernet;
  Ipv4_h ip; 
}

parser TopParser() {
  bool tmp_10
  bool tmp_11
  bit<16> tmp_12
  bool tmp_13
  bool tmp_14
  @name("ck") Ck16 ck()

  state start {
    b.extract<Ethernet_h>(p.ethernet);
    select{p.ethernet.etherType} {
      2048: parse_ipv4 
    } 
  }

  state parse_ipv4 {
    b.extract<Ipv4_h>(p.ip);
    tmp_10 = p.ip.version == 4;
    verify(tmp_10, <TypeNameExpression>(92763)error.IPv4IncorrectVersion);
    tmp_11 = p.ip.ihl == 5;
    verify(tmp_11, <TypeNameExpression>(92784)error.IPv4OptionsNotSupported);
    ck.clear();
    ck.update<Ipv4_h>(p.ip);
    tmp_12 = ck.get();
    tmp_13 = tmp_12 == 0;
    tmp_14 = tmp_13;
    verify(tmp_14, <TypeNameExpression>(92836)error.IPv4ChecksumError);
    accept; 
  }

  state accept { }

  state reject { } 
}


control TopPipe() {
  IPv4Address nextHop_1/nextHop
  bit<8> tmp_15
  bool tmp_16
  bool tmp_17
  bool tmp_18
  bool tmp_19
  IPv4Address nextHop_2/nextHop
  IPv4Address nextHop_3/nextHop
  bool hasReturned_0
  IPv4Address nextHop_0/nextHop
  action NoAction_0/NoAction_1() { }

  action Drop_action_0/Drop_action() {
    outCtrl.outputPort = 15; 
  }

  action Drop_action_4/Drop_action_1() {
    outCtrl.outputPort = 15; 
  }

  action Drop_action_5/Drop_action_2() {
    outCtrl.outputPort = 15; 
  }

  action Drop_action_6/Drop_action_3() {
    outCtrl.outputPort = 15; 
  }

  action Set_nhop_0/Set_nhop( IPv4Address ipv4_dest,  PortId port) {
    nextHop_0/nextHop = ipv4_dest;
    tmp_15 = headers.ip.ttl + 255;
    headers.ip.ttl = headers.ip.ttl + 255;
    outCtrl.outputPort = port;
    nextHop_2/nextHop = ipv4_dest; 
  }

  table ipv4_match() @name("ipv4_match") {
    key = { headers.ip.dstAddr: lpm; }

    actions = { Drop_action_0/Drop_action();
      Set_nhop_0/Set_nhop(); 
    }

    size = 1024
    default_action = Drop_action_0/Drop_action(); 
  }

  action Send_to_cpu_0/Send_to_cpu() {
    outCtrl.outputPort = 14; 
  }

  table check_ttl() @name("check_ttl") {
    key = { headers.ip.ttl: exact; }

    actions = { Send_to_cpu_0/Send_to_cpu();
      NoAction_0/NoAction_1(); 
    }

    const default_action = NoAction_0/NoAction_1(); 
  }

  action Set_dmac_0/Set_dmac( EthernetAddress dmac) {
    headers.ethernet.dstAddr = dmac; 
  }

  table dmac_1/dmac() @name("dmac") {
    key = { nextHop_3/nextHop: exact; }

    actions = { Drop_action_4/Drop_action_1();
      Set_dmac_0/Set_dmac(); 
    }

    size = 1024
    default_action = Drop_action_4/Drop_action_1(); 
  }

  action Set_smac_0/Set_smac( EthernetAddress smac) {
    headers.ethernet.srcAddr = smac; 
  }

  table smac_1/smac() @name("smac") {
    key = { outCtrl.outputPort: exact; }

    actions = { Drop_action_5/Drop_action_2();
      Set_smac_0/Set_smac(); 
    }

    size = 16
    default_action = Drop_action_5/Drop_action_2(); 
  }

  action act() {
    hasReturned_0 = 1; 
  }

  action act_0() {
    hasReturned_0 = 0;
    tmp_16 = parseError != <TypeNameExpression>(93223)error.NoError; 
  }

  action act_1() {
    hasReturned_0 = 1; 
  }

  action act_2() {
    nextHop_1/nextHop = nextHop_2/nextHop;
    tmp_17 = outCtrl.outputPort == 15; 
  }

  action act_3() {
    hasReturned_0 = 1; 
  }

  action act_4() {
    tmp_18 = outCtrl.outputPort == 14; 
  }

  action act_5() {
    nextHop_3/nextHop = nextHop_1/nextHop; 
  }

  action act_6() {
    hasReturned_0 = 1; 
  }

  action act_7() {
    tmp_19 = outCtrl.outputPort == 15; 
  }

  table tbl_act() {
    actions = { act_0(); }
    const default_action = act_0(); 
  }

  table tbl_Drop_action() {
    actions = { Drop_action_6(); }
    const default_action = Drop_action_6/Drop_action_3(); 
  }

  table tbl_act_0() {
    actions = { act(); }
    const default_action = act(); 
  }

  table tbl_act_1() {
    actions = { act_2(); }
    const default_action = act_2(); 
  }

  table tbl_act_2() {
    actions = { act_1(); }
    const default_action = act_1(); 
  }

  table tbl_act_3() {
    actions = { act_4(); }
    const default_action = act_4(); 
  }

  table tbl_act_4() {
    actions = { act_3(); }
    const default_action = act_3(); 
  }

  table tbl_act_5() {
    actions = { act_5(); }
    const default_action = act_5(); 
  }

  table tbl_act_6() {
    actions = { act_7(); }
    const default_action = act_7(); 
  }

  table tbl_act_7() {
    actions = { act_6(); }
    const default_action = act_6(); 
  }

  tbl_act.apply();

  if (tmp_16) {
    { tbl_Drop_action.apply();
      tbl_act_0.apply(); } 
  }
  if (!hasReturned_0) {
    { ipv4_match.apply();
      tbl_act_1.apply();
      if (tmp_17) {
        tbl_act_2.apply(); 
      }} 
  }
  if (!hasReturned_0) {
    { check_ttl.apply();
      tbl_act_3.apply();
      if (tmp_18) {
        tbl_act_4.apply(); 
      }} 
  }
  if (!hasReturned_0) {
    { tbl_act_5.apply();
      dmac_1/dmac.apply();
      tbl_act_6.apply();
      if (tmp_19) {
        tbl_act_7.apply(); } } 
  }
  if (!hasReturned_0) {
    smac_1/smac.apply(); 
  } 
}

control TopDeparser() {
  bit<16> tmp_20
  @name("ck") Ck16 ck_2/ck()

  action act_8() {
    ck_2/ck.clear();
    p.ip.hdrChecksum = 0;
    ck_2/ck.update<Ipv4_h>(p.ip);
    tmp_20 = ck_2/ck.get();
    p.ip.hdrChecksum = tmp_20; 
  }

  table tbl_act_8() {
    actions = { act_8(); }
    const default_action = act_8(); 
  }

  b.emit<Ethernet_h>(p.ethernet);

  if (p.ip.isValid()) {
    { tbl_act_8.apply(); } 
  }

  b.emit<Ipv4_h>(p.ip); 
}

VSS<Parsed_packet> main(TopParser(), TopPipe(), TopDeparser())