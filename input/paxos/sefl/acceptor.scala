val block154499 = InstructionBlock(
	mark_to_drop
)

val block154515 = InstructionBlock(
	If(Constrain('hdr.ipv4.hdrChecksum', :==:(:@('tmp_11'))), Assign('tmp_12', ConstantValue(1)), Assign('tmp_12', ConstantValue(0)))
)

val block154601 = InstructionBlock(
	Assign('hdr.ipv4.hdrChecksum', :@('tmp_13'))
)

val block147276 = InstructionBlock(
	acceptor_tbl,
	transport_tbl
)

val block156910 = InstructionBlock(
	tbl_read_round,
	tbl_act_2,
	If(Constrain(:@('tmp_22'), :==:(ConstantValue(1))), block147276)
)

val block146865 = InstructionBlock(
	mark_to_drop
)

val block146874 = InstructionBlock(
	mark_to_drop
)

val block148914 = InstructionBlock(
	Assign('tmp_15', :@('hdr.paxos.inst')),
	Assign('tmp_14', SymbolicValue()),
	Assign('meta.paxos_metadata.round', :@('tmp_14')),
	Assign('meta.paxos_metadata.set_drop', ConstantValue(1))
)

val block148992 = InstructionBlock(
	Assign('hdr.paxos.msgtype', ConstantValue(1)),
	Assign('tmp_17', :@('hdr.paxos.inst')),
	Assign('tmp_16', SymbolicValue()),
	Assign('hdr.paxos.vrnd', :@('tmp_16')),
	Assign('tmp_19', :@('hdr.paxos.inst')),
	Assign('tmp_18', SymbolicValue()),
	Assign('hdr.paxos.paxosval', :@('tmp_18')),
	Assign('tmp_20', SymbolicValue()),
	Assign('hdr.paxos.acptid', :@('tmp_20')),
	Assign('meta.paxos_metadata.set_drop', ConstantValue(0))
)

val block147033 = InstructionBlock(
	Assign('hdr.paxos.msgtype', ConstantValue(3)),
	Assign('tmp_21', SymbolicValue()),
	Assign('hdr.paxos.acptid', :@('tmp_21')),
	Assign('meta.paxos_metadata.set_drop', ConstantValue(0))
)

val block147173 = InstructionBlock(
	Assign('standard_metadata.egress_spec', :@('port')),
	Assign('hdr.udp.dstPort', :@('learnerPort'))
)

val block154858 = InstructionBlock(
	If(Constrain('hdr.paxos.rnd', :>=:(:@('meta.paxos_metadata.round'))), Assign('tmp_22', ConstantValue(1)), Assign('tmp_22', ConstantValue(0)))
)

val block51143 = InstructionBlock(

)

<Type_Error>16
<Declaration_MatchKind>106
<Declaration_MatchKind>110
<Type_Enum>167
<Type_Enum>350
val mark_to_drop = Fail('Packet dropped')

<Type_Parser>481
<Type_Control>494
<Type_Control>510
<Type_Control>526
<Type_Control>539
<Type_Control>551
<Type_Package>610
val start = InstructionBlock(
	//Extract p.ethernet
	Assign('p.ethernet.isValid', ConstantValue(1)),
	Assign('p.ethernet.dstAddr', SymbolicValue()),
	Assign('p.ethernet.srcAddr', SymbolicValue()),
	Assign('p.ethernet.etherType', SymbolicValue()),
	If(Constrain('p.ethernet.etherType', :==:(ConstantValue(2048))), parse_ipv4)
)


val parse_ipv4 = InstructionBlock(
	//Extract p.ipv4
	Assign('p.ipv4.isValid', ConstantValue(1)),
	Assign('p.ipv4.version', SymbolicValue()),
	Assign('p.ipv4.ihl', SymbolicValue()),
	Assign('p.ipv4.diffserv', SymbolicValue()),
	Assign('p.ipv4.totalLen', SymbolicValue()),
	Assign('p.ipv4.identification', SymbolicValue()),
	Assign('p.ipv4.flags', SymbolicValue()),
	Assign('p.ipv4.fragOffset', SymbolicValue()),
	Assign('p.ipv4.ttl', SymbolicValue()),
	Assign('p.ipv4.protocol', SymbolicValue()),
	Assign('p.ipv4.hdrChecksum', SymbolicValue()),
	Assign('p.ipv4.srcAddr', SymbolicValue()),
	Assign('p.ipv4.dstAddr', SymbolicValue()),
	If(Constrain('p.ipv4.protocol', :==:(ConstantValue(17))), parse_udp,
	accept)
)


val parse_udp = InstructionBlock(
	//Extract p.udp
	Assign('p.udp.isValid', ConstantValue(1)),
	Assign('p.udp.srcPort', SymbolicValue()),
	Assign('p.udp.dstPort', SymbolicValue()),
	Assign('p.udp.length_', SymbolicValue()),
	Assign('p.udp.checksum', SymbolicValue()),
	If(Constrain('p.udp.dstPort', :==:(ConstantValue(34952))), parse_paxos,
	accept)
)


val parse_paxos = InstructionBlock(
	//Extract p.paxos
	Assign('p.paxos.isValid', ConstantValue(1)),
	Assign('p.paxos.msgtype', SymbolicValue()),
	Assign('p.paxos.inst', SymbolicValue()),
	Assign('p.paxos.rnd', SymbolicValue()),
	Assign('p.paxos.vrnd', SymbolicValue()),
	Assign('p.paxos.acptid', SymbolicValue()),
	Assign('p.paxos.paxoslen', SymbolicValue()),
	Assign('p.paxos.paxosval', SymbolicValue()),
	accept
)


val accept = InstructionBlock(
	
)


val reject = InstructionBlock(
	Fail('Packet dropped')
)


val TopParser = InstructionBlock(

	//Allocate p
	Allocate('p.ethernet.isValid'),
	Assign('p.ethernet.isValid', ConstantValue(0)),
	Allocate('p.ethernet.dstAddr'),
	Allocate('p.ethernet.srcAddr'),
	Allocate('p.ethernet.etherType'),
	Allocate('p.ipv4.isValid'),
	Assign('p.ipv4.isValid', ConstantValue(0)),
	Allocate('p.ipv4.version'),
	Allocate('p.ipv4.ihl'),
	Allocate('p.ipv4.diffserv'),
	Allocate('p.ipv4.totalLen'),
	Allocate('p.ipv4.identification'),
	Allocate('p.ipv4.flags'),
	Allocate('p.ipv4.fragOffset'),
	Allocate('p.ipv4.ttl'),
	Allocate('p.ipv4.protocol'),
	Allocate('p.ipv4.hdrChecksum'),
	Allocate('p.ipv4.srcAddr'),
	Allocate('p.ipv4.dstAddr'),
	Allocate('p.udp.isValid'),
	Assign('p.udp.isValid', ConstantValue(0)),
	Allocate('p.udp.srcPort'),
	Allocate('p.udp.dstPort'),
	Allocate('p.udp.length_'),
	Allocate('p.udp.checksum'),
	Allocate('p.paxos.isValid'),
	Assign('p.paxos.isValid', ConstantValue(0)),
	Allocate('p.paxos.msgtype'),
	Allocate('p.paxos.inst'),
	Allocate('p.paxos.rnd'),
	Allocate('p.paxos.vrnd'),
	Allocate('p.paxos.acptid'),
	Allocate('p.paxos.paxoslen'),
	Allocate('p.paxos.paxosval'),

	//Allocate meta
	Allocate('meta.paxos_metadata.round'),
	Allocate('meta.paxos_metadata.set_drop'),
	Allocate('meta.paxos_metadata.ack_count'),
	Allocate('meta.paxos_metadata.ack_acceptors'),

	//Allocate standard_metadata
	Allocate('standard_metadata.ingress_port'),
	Assign('standard_metadata.ingress_port', SymbolicValue()),
	Allocate('standard_metadata.egress_spec'),
	Assign('standard_metadata.egress_spec', SymbolicValue()),
	Allocate('standard_metadata.egress_port'),
	Assign('standard_metadata.egress_port', SymbolicValue()),
	Allocate('standard_metadata.clone_spec'),
	Assign('standard_metadata.clone_spec', SymbolicValue()),
	Allocate('standard_metadata.instance_type'),
	Assign('standard_metadata.instance_type', SymbolicValue()),
	Allocate('standard_metadata.drop'),
	Assign('standard_metadata.drop', SymbolicValue()),
	Allocate('standard_metadata.recirculate_port'),
	Assign('standard_metadata.recirculate_port', SymbolicValue()),
	Allocate('standard_metadata.packet_length'),
	Assign('standard_metadata.packet_length', SymbolicValue()),

	start
)

//Control
val TopDeparser = InstructionBlock(
	//Emit hdr.ethernet
	CreateTag('hdr.ethernet.dstAddr', 0),
	Allocate(Tag('hdr.ethernet.dstAddr'), 48),
	Assign(Tag('hdr.ethernet.dstAddr'), :@('hdr.ethernet.dstAddr')),
	CreateTag('hdr.ethernet.srcAddr', 48),
	Allocate(Tag('hdr.ethernet.srcAddr'), 48),
	Assign(Tag('hdr.ethernet.srcAddr'), :@('hdr.ethernet.srcAddr')),
	CreateTag('hdr.ethernet.etherType', 96),
	Allocate(Tag('hdr.ethernet.etherType'), 16),
	Assign(Tag('hdr.ethernet.etherType'), :@('hdr.ethernet.etherType')),
	//Emit hdr.ipv4
	CreateTag('hdr.ipv4.version', 112),
	Allocate(Tag('hdr.ipv4.version'), 4),
	Assign(Tag('hdr.ipv4.version'), :@('hdr.ipv4.version')),
	CreateTag('hdr.ipv4.ihl', 116),
	Allocate(Tag('hdr.ipv4.ihl'), 4),
	Assign(Tag('hdr.ipv4.ihl'), :@('hdr.ipv4.ihl')),
	CreateTag('hdr.ipv4.diffserv', 120),
	Allocate(Tag('hdr.ipv4.diffserv'), 8),
	Assign(Tag('hdr.ipv4.diffserv'), :@('hdr.ipv4.diffserv')),
	CreateTag('hdr.ipv4.totalLen', 128),
	Allocate(Tag('hdr.ipv4.totalLen'), 16),
	Assign(Tag('hdr.ipv4.totalLen'), :@('hdr.ipv4.totalLen')),
	CreateTag('hdr.ipv4.identification', 144),
	Allocate(Tag('hdr.ipv4.identification'), 16),
	Assign(Tag('hdr.ipv4.identification'), :@('hdr.ipv4.identification')),
	CreateTag('hdr.ipv4.flags', 160),
	Allocate(Tag('hdr.ipv4.flags'), 3),
	Assign(Tag('hdr.ipv4.flags'), :@('hdr.ipv4.flags')),
	CreateTag('hdr.ipv4.fragOffset', 163),
	Allocate(Tag('hdr.ipv4.fragOffset'), 13),
	Assign(Tag('hdr.ipv4.fragOffset'), :@('hdr.ipv4.fragOffset')),
	CreateTag('hdr.ipv4.ttl', 176),
	Allocate(Tag('hdr.ipv4.ttl'), 8),
	Assign(Tag('hdr.ipv4.ttl'), :@('hdr.ipv4.ttl')),
	CreateTag('hdr.ipv4.protocol', 184),
	Allocate(Tag('hdr.ipv4.protocol'), 8),
	Assign(Tag('hdr.ipv4.protocol'), :@('hdr.ipv4.protocol')),
	CreateTag('hdr.ipv4.hdrChecksum', 192),
	Allocate(Tag('hdr.ipv4.hdrChecksum'), 16),
	Assign(Tag('hdr.ipv4.hdrChecksum'), :@('hdr.ipv4.hdrChecksum')),
	CreateTag('hdr.ipv4.srcAddr', 208),
	Allocate(Tag('hdr.ipv4.srcAddr'), 32),
	Assign(Tag('hdr.ipv4.srcAddr'), :@('hdr.ipv4.srcAddr')),
	CreateTag('hdr.ipv4.dstAddr', 240),
	Allocate(Tag('hdr.ipv4.dstAddr'), 32),
	Assign(Tag('hdr.ipv4.dstAddr'), :@('hdr.ipv4.dstAddr')),
	//Emit hdr.udp
	CreateTag('hdr.udp.srcPort', 272),
	Allocate(Tag('hdr.udp.srcPort'), 16),
	Assign(Tag('hdr.udp.srcPort'), :@('hdr.udp.srcPort')),
	CreateTag('hdr.udp.dstPort', 288),
	Allocate(Tag('hdr.udp.dstPort'), 16),
	Assign(Tag('hdr.udp.dstPort'), :@('hdr.udp.dstPort')),
	CreateTag('hdr.udp.length_', 304),
	Allocate(Tag('hdr.udp.length_'), 16),
	Assign(Tag('hdr.udp.length_'), :@('hdr.udp.length_')),
	CreateTag('hdr.udp.checksum', 320),
	Allocate(Tag('hdr.udp.checksum'), 16),
	Assign(Tag('hdr.udp.checksum'), :@('hdr.udp.checksum')),
	//Emit hdr.paxos
	CreateTag('hdr.paxos.msgtype', 336),
	Allocate(Tag('hdr.paxos.msgtype'), 16),
	Assign(Tag('hdr.paxos.msgtype'), :@('hdr.paxos.msgtype')),
	CreateTag('hdr.paxos.inst', 352),
	Allocate(Tag('hdr.paxos.inst'), 32),
	Assign(Tag('hdr.paxos.inst'), :@('hdr.paxos.inst')),
	CreateTag('hdr.paxos.rnd', 384),
	Allocate(Tag('hdr.paxos.rnd'), 16),
	Assign(Tag('hdr.paxos.rnd'), :@('hdr.paxos.rnd')),
	CreateTag('hdr.paxos.vrnd', 400),
	Allocate(Tag('hdr.paxos.vrnd'), 16),
	Assign(Tag('hdr.paxos.vrnd'), :@('hdr.paxos.vrnd')),
	CreateTag('hdr.paxos.acptid', 416),
	Allocate(Tag('hdr.paxos.acptid'), 16),
	Assign(Tag('hdr.paxos.acptid'), :@('hdr.paxos.acptid')),
	CreateTag('hdr.paxos.paxoslen', 432),
	Allocate(Tag('hdr.paxos.paxoslen'), 32),
	Assign(Tag('hdr.paxos.paxoslen'), :@('hdr.paxos.paxoslen')),
	CreateTag('hdr.paxos.paxosval', 464),
	Allocate(Tag('hdr.paxos.paxosval'), 256),
	Assign(Tag('hdr.paxos.paxosval'), :@('hdr.paxos.paxosval'))
)


//Control
val verifyChecksum = InstructionBlock(
	Allocate('tmp_11'),
	Allocate('tmp_12'),
	Assign('tmp_11', SymbolicValue()),
	tbl_act,
	If(Constrain(:@('tmp_12'), :==:(ConstantValue(1))), tbl_act_0)
)

// Action
val act = InstructionBlock(
	block154499
)


// Action
val act_0 = InstructionBlock(
	block154515
)


//Table
val tbl_act = InstructionBlock(
	Fork(act_0)
	// default_action act_0
)


//Table
val tbl_act_0 = InstructionBlock(
	Fork(act)
	// default_action act
)



//Control
val computeChecksum = InstructionBlock(
	Allocate('tmp_13'),
	Assign('tmp_13', SymbolicValue()),
	tbl_act_1
)

// Action
val act_1 = InstructionBlock(
	block154601
)


//Table
val tbl_act_1 = InstructionBlock(
	Fork(act_1)
	// default_action act_1
)



//Control
val ingress = InstructionBlock(
	Allocate('tmp_14'),
	Allocate('tmp_15'),
	Allocate('tmp_16'),
	Allocate('tmp_17'),
	Allocate('tmp_18'),
	Allocate('tmp_19'),
	Allocate('tmp_20'),
	Allocate('tmp_21'),
	Allocate('tmp_22'),
	If(Constrain('hdr.ipv4.isValid', :==:(ConstantValue(1))), If(Constrain('hdr.paxos.isValid', :==:(ConstantValue(1))), block156910))
)

// Action
val _drop_0 = InstructionBlock(
	block146865
)


// Action
val _drop_2 = InstructionBlock(
	block146874
)


// Action
val read_round_0 = InstructionBlock(
	block148914
)


// Action
val handle_1a_0 = InstructionBlock(
	block148992
)


// Action
val handle_2a_0 = InstructionBlock(
	block147033
)


//Table
val acceptor_tbl = InstructionBlock(
	// keys: hdr.paxos.msgtype
	Fork(handle_1a_0, handle_2a_0, _drop_0)
	// size ConstantValue(4)
	// default_action _drop_0
)


// Action
val forward_0 = InstructionBlock(
	Assign('port', SymbolicValue()),
	Assign('learnerPort', SymbolicValue()),
	block147173
)


//Table
val transport_tbl = InstructionBlock(
	// keys: meta.paxos_metadata.set_drop
	Fork(_drop_2, forward_0)
	// size ConstantValue(2)
	// default_action _drop_2
)


// Action
val act_2 = InstructionBlock(
	block154858
)


//Table
val tbl_read_round = InstructionBlock(
	Fork(read_round_0)
	// default_action read_round_0
)


//Table
val tbl_act_2 = InstructionBlock(
	Fork(act_2)
	// default_action act_2
)



//Control
val egress = InstructionBlock(
	place_holder_table
)

// Action
val NoAction_0 = InstructionBlock(
	block51143
)


//Table
val place_holder_table = InstructionBlock(
	Fork(NoAction_0)
	// size ConstantValue(2)
	// default_action NoAction_0
)



val main = InstructionBlock(TopParser, ingress, egress, TopDeparser)


