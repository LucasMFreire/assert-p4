lazy val start = InstructionBlock(
	//Extract p.ethernet
	Assign("p.ethernet.isValid", ConstantValue(1)),
	Assign("p.ethernet.dstAddr", SymbolicBitVector(48)),
	Assign("p.ethernet.srcAddr", SymbolicBitVector(48)),
	Assign("p.ethernet.etherType", SymbolicBitVector(16)),
	If(Constrain("p.ethernet.etherType", :==:(ConstantValue(2048))), parse_ipv4)
)


lazy val parse_ipv4 = InstructionBlock(
	//Extract p.ip
	Assign("p.ip.isValid", ConstantValue(1)),
	Assign("p.ip.version", SymbolicBitVector(4)),
	Assign("p.ip.ihl", SymbolicBitVector(4)),
	Assign("p.ip.diffserv", SymbolicBitVector(8)),
	Assign("p.ip.totalLen", SymbolicBitVector(16)),
	Assign("p.ip.identification", SymbolicBitVector(16)),
	Assign("p.ip.flags", SymbolicBitVector(3)),
	Assign("p.ip.fragOffset", SymbolicBitVector(13)),
	Assign("p.ip.ttl", SymbolicBitVector(8)),
	Assign("p.ip.protocol", SymbolicBitVector(8)),
	Assign("p.ip.hdrChecksum", SymbolicBitVector(16)),
	Assign("p.ip.srcAddr", SymbolicBitVector(32)),
	Assign("p.ip.dstAddr", SymbolicBitVector(32)),
	If(Constrain("p.ip.version", :==:(ConstantBitVector(4, 4))), Assign("tmp_10", ConstantValue(1)), Assign("tmp_10", ConstantValue(0))),
	If(Constrain("tmp_10", :==:(ConstantValue(0))), Fail("IPv4IncorrectVersion")),
	If(Constrain("p.ip.ihl", :==:(ConstantBitVector(5, 4))), Assign("tmp_11", ConstantValue(1)), Assign("tmp_11", ConstantValue(0))),
	If(Constrain("tmp_11", :==:(ConstantValue(0))), Fail("IPv4OptionsNotSupported")),
	//Extern: ck.clear,
	//Extern: ck.update,
	Assign("tmp_12", SymbolicValue()),
	If(Constrain("tmp_12", :==:(ConstantBitVector(0, 16))), Assign("tmp_13", ConstantValue(1)), Assign("tmp_13", ConstantValue(0))),
	Assign("tmp_14", :@("tmp_13")),
	If(Constrain("tmp_14", :==:(ConstantValue(0))), Fail("IPv4ChecksumError")),
	accept
)


lazy val accept = InstructionBlock(
	
)


lazy val reject = InstructionBlock(
	Fail("Packet dropped")
)


lazy val TopParser = InstructionBlock(
	Allocate("tmp_10"),
	Allocate("tmp_11"),
	Allocate("tmp_12"),
	Allocate("tmp_13"),
	Allocate("tmp_14"),
	
	//Allocate p
	Allocate("p.ethernet.isValid"),
	Assign("p.ethernet.isValid", ConstantValue(0)),
	Allocate("p.ethernet.dstAddr"),
	Allocate("p.ethernet.srcAddr"),
	Allocate("p.ethernet.etherType"),
	Allocate("p.ip.isValid"),
	Assign("p.ip.isValid", ConstantValue(0)),
	Allocate("p.ip.version"),
	Allocate("p.ip.ihl"),
	Allocate("p.ip.diffserv"),
	Allocate("p.ip.totalLen"),
	Allocate("p.ip.identification"),
	Allocate("p.ip.flags"),
	Allocate("p.ip.fragOffset"),
	Allocate("p.ip.ttl"),
	Allocate("p.ip.protocol"),
	Allocate("p.ip.hdrChecksum"),
	Allocate("p.ip.srcAddr"),
	Allocate("p.ip.dstAddr"),

	start
)

//Control
lazy val TopPipe = InstructionBlock(
	Allocate("tmp_15"),
	Allocate("tmp_16"),
	Allocate("tmp_17"),
	Allocate("tmp_18"),
	Allocate("tmp_19"),
	Allocate("hasReturned_0"),
	tbl_act_101773,
	If(Constrain("tmp_16", :==:(ConstantValue(1))), 
		InstructionBlock(
			tbl_Drop_action_101809,
			tbl_act_0_101840
		)),
	If(Constrain("hasReturned_0", :==:(ConstantValue(0))), 
		InstructionBlock(
			ipv4_match_92978,
			tbl_act_1_101900,
			If(Constrain("tmp_17", :==:(ConstantValue(1))), tbl_act_2_101934)
		)),
	If(Constrain("hasReturned_0", :==:(ConstantValue(0))), 
		InstructionBlock(
			check_ttl_93039,
			tbl_act_3_101994,
			If(Constrain("tmp_18", :==:(ConstantValue(1))), tbl_act_4_102028)
		)),
	If(Constrain("hasReturned_0", :==:(ConstantValue(0))), 
		InstructionBlock(
			tbl_act_5_102065,
			dmac_1_93101,
			tbl_act_6_102119,
			If(Constrain("tmp_19", :==:(ConstantValue(1))), tbl_act_7_102153)
		)),
	If(Constrain("hasReturned_0", :==:(ConstantValue(0))), smac_1_93165)
)

// Action
lazy val NoAction_0_92881 = InstructionBlock(
	Assign("action_run", ConstantValue(92881)), 
	
)


// Action
lazy val Drop_action_0_92891 = InstructionBlock(
	Assign("action_run", ConstantValue(92891)), 
	
		InstructionBlock(
			Assign("outCtrl.outputPort", ConstantBitVector(15, 4))
		)
)


// Action
lazy val Drop_action_4_92906 = InstructionBlock(
	Assign("action_run", ConstantValue(92906)), 
	
		InstructionBlock(
			Assign("outCtrl.outputPort", ConstantBitVector(15, 4))
		)
)


// Action
lazy val Drop_action_5_92913 = InstructionBlock(
	Assign("action_run", ConstantValue(92913)), 
	
		InstructionBlock(
			Assign("outCtrl.outputPort", ConstantBitVector(15, 4))
		)
)


// Action
lazy val Drop_action_6_92920 = InstructionBlock(
	Assign("action_run", ConstantValue(92920)), 
	
		InstructionBlock(
			Assign("outCtrl.outputPort", ConstantBitVector(15, 4))
		)
)


// Action
lazy val Set_nhop_0_94278 = InstructionBlock(
	Assign("action_run", ConstantValue(94278)), 
	Assign("ipv4_dest", SymbolicValue()),
	Assign("port", SymbolicValue()),
	
		InstructionBlock(
			Assign("nextHop_0", :@("ipv4_dest")),
			Assign("tmp_15", :+:(:@("headers.ip.ttl"), ConstantBitVector(255, 8))),
			Assign("headers.ip.ttl", :+:(:@("headers.ip.ttl"), ConstantBitVector(255, 8))),
			Assign("outCtrl.outputPort", :@("port")),
			Assign("nextHop_2", :@("ipv4_dest"))
		)
)


// Action
lazy val Send_to_cpu_0_93024 = InstructionBlock(
	Assign("action_run", ConstantValue(93024)), 
	
		InstructionBlock(
			Assign("outCtrl.outputPort", ConstantBitVector(14, 4))
		)
)


// Action
lazy val Set_dmac_0_93081 = InstructionBlock(
	Assign("action_run", ConstantValue(93081)), 
	Assign("dmac", SymbolicValue()),
	
		InstructionBlock(
			Assign("headers.ethernet.dstAddr", :@("dmac"))
		)
)


// Action
lazy val Set_smac_0_93145 = InstructionBlock(
	Assign("action_run", ConstantValue(93145)), 
	Assign("smac", SymbolicValue()),
	
		InstructionBlock(
			Assign("headers.ethernet.srcAddr", :@("smac"))
		)
)


// Action
lazy val act_99936 = InstructionBlock(
	Assign("action_run", ConstantValue(99936)), 
	
		InstructionBlock(
			Assign("hasReturned_0", ConstantValue(1))
		)
)


// Action
lazy val act_0_99948 = InstructionBlock(
	Assign("action_run", ConstantValue(99948)), 
	
		InstructionBlock(
			Assign("hasReturned_0", ConstantValue(0)),
			Assign("tmp_16", "parseError", :~:(:==:(.NoError)))
		)
)


// Action
lazy val act_1_99987 = InstructionBlock(
	Assign("action_run", ConstantValue(99987)), 
	
		InstructionBlock(
			Assign("hasReturned_0", ConstantValue(1))
		)
)


// Action
lazy val act_2_100003 = InstructionBlock(
	Assign("action_run", ConstantValue(100003)), 
	
		InstructionBlock(
			Assign("nextHop_1", :@("nextHop_2")),
			If(Constrain("outCtrl.outputPort", :==:(ConstantBitVector(15, 4))), Assign("tmp_17", ConstantValue(1)), Assign("tmp_17", ConstantValue(0)))
		)
)


// Action
lazy val act_3_100044 = InstructionBlock(
	Assign("action_run", ConstantValue(100044)), 
	
		InstructionBlock(
			Assign("hasReturned_0", ConstantValue(1))
		)
)


// Action
lazy val act_4_100060 = InstructionBlock(
	Assign("action_run", ConstantValue(100060)), 
	
		InstructionBlock(
			If(Constrain("outCtrl.outputPort", :==:(ConstantBitVector(14, 4))), Assign("tmp_18", ConstantValue(1)), Assign("tmp_18", ConstantValue(0)))
		)
)


// Action
lazy val act_5_100096 = InstructionBlock(
	Assign("action_run", ConstantValue(100096)), 
	
		InstructionBlock(
			Assign("nextHop_3", :@("nextHop_1"))
		)
)


// Action
lazy val act_6_100112 = InstructionBlock(
	Assign("action_run", ConstantValue(100112)), 
	
		InstructionBlock(
			Assign("hasReturned_0", ConstantValue(1))
		)
)


// Action
lazy val act_7_100128 = InstructionBlock(
	Assign("action_run", ConstantValue(100128)), 
	
		InstructionBlock(
			If(Constrain("outCtrl.outputPort", :==:(ConstantBitVector(15, 4))), Assign("tmp_19", ConstantValue(1)), Assign("tmp_19", ConstantValue(0)))
		)
)


//Table
lazy val ipv4_match_92978 = InstructionBlock(
	Fork(Drop_action_0_92891, Set_nhop_0_94278)
	// size ConstantValue(1024)
	// default_action Drop_action_0
)


//Table
lazy val check_ttl_93039 = InstructionBlock(
	Fork(Send_to_cpu_0_93024, NoAction_0_92881)
	// default_action NoAction_0
)


//Table
lazy val dmac_1_93101 = InstructionBlock(
	Fork(Drop_action_4_92906, Set_dmac_0_93081)
	// size ConstantValue(1024)
	// default_action Drop_action_4
)


//Table
lazy val smac_1_93165 = InstructionBlock(
	Fork(Drop_action_5_92913, Set_smac_0_93145)
	// size ConstantValue(16)
	// default_action Drop_action_5
)


//Table
lazy val tbl_act_101773 = InstructionBlock(
	Fork(act_0_99948)
	// default_action act_0
)


//Table
lazy val tbl_Drop_action_101809 = InstructionBlock(
	Fork(Drop_action_6_92920)
	// default_action Drop_action_6
)


//Table
lazy val tbl_act_0_101840 = InstructionBlock(
	Fork(act_99936)
	// default_action act
)


//Table
lazy val tbl_act_1_101900 = InstructionBlock(
	Fork(act_2_100003)
	// default_action act_2
)


//Table
lazy val tbl_act_2_101934 = InstructionBlock(
	Fork(act_1_99987)
	// default_action act_1
)


//Table
lazy val tbl_act_3_101994 = InstructionBlock(
	Fork(act_4_100060)
	// default_action act_4
)


//Table
lazy val tbl_act_4_102028 = InstructionBlock(
	Fork(act_3_100044)
	// default_action act_3
)


//Table
lazy val tbl_act_5_102065 = InstructionBlock(
	Fork(act_5_100096)
	// default_action act_5
)


//Table
lazy val tbl_act_6_102119 = InstructionBlock(
	Fork(act_7_100128)
	// default_action act_7
)


//Table
lazy val tbl_act_7_102153 = InstructionBlock(
	Fork(act_6_100112)
	// default_action act_6
)



//Control
lazy val TopDeparser = InstructionBlock(
	Allocate("tmp_20"),
	//Emit p.ethernet
	CreateTag("p.ethernet.dstAddr", 0),
	Allocate(Tag("p.ethernet.dstAddr"), 48),
	Assign(Tag("p.ethernet.dstAddr"), :@("p.ethernet.dstAddr")),
	CreateTag("p.ethernet.srcAddr", 48),
	Allocate(Tag("p.ethernet.srcAddr"), 48),
	Assign(Tag("p.ethernet.srcAddr"), :@("p.ethernet.srcAddr")),
	CreateTag("p.ethernet.etherType", 96),
	Allocate(Tag("p.ethernet.etherType"), 16),
	Assign(Tag("p.ethernet.etherType"), :@("p.ethernet.etherType")),
	If(Constrain("p.ip.isValid", :==:(ConstantValue(1))), 
		InstructionBlock(
			tbl_act_8_102306
		)),
	//Emit p.ip
	CreateTag("p.ip.version", 112),
	Allocate(Tag("p.ip.version"), 4),
	Assign(Tag("p.ip.version"), :@("p.ip.version")),
	CreateTag("p.ip.ihl", 116),
	Allocate(Tag("p.ip.ihl"), 4),
	Assign(Tag("p.ip.ihl"), :@("p.ip.ihl")),
	CreateTag("p.ip.diffserv", 120),
	Allocate(Tag("p.ip.diffserv"), 8),
	Assign(Tag("p.ip.diffserv"), :@("p.ip.diffserv")),
	CreateTag("p.ip.totalLen", 128),
	Allocate(Tag("p.ip.totalLen"), 16),
	Assign(Tag("p.ip.totalLen"), :@("p.ip.totalLen")),
	CreateTag("p.ip.identification", 144),
	Allocate(Tag("p.ip.identification"), 16),
	Assign(Tag("p.ip.identification"), :@("p.ip.identification")),
	CreateTag("p.ip.flags", 160),
	Allocate(Tag("p.ip.flags"), 3),
	Assign(Tag("p.ip.flags"), :@("p.ip.flags")),
	CreateTag("p.ip.fragOffset", 163),
	Allocate(Tag("p.ip.fragOffset"), 13),
	Assign(Tag("p.ip.fragOffset"), :@("p.ip.fragOffset")),
	CreateTag("p.ip.ttl", 176),
	Allocate(Tag("p.ip.ttl"), 8),
	Assign(Tag("p.ip.ttl"), :@("p.ip.ttl")),
	CreateTag("p.ip.protocol", 184),
	Allocate(Tag("p.ip.protocol"), 8),
	Assign(Tag("p.ip.protocol"), :@("p.ip.protocol")),
	CreateTag("p.ip.hdrChecksum", 192),
	Allocate(Tag("p.ip.hdrChecksum"), 16),
	Assign(Tag("p.ip.hdrChecksum"), :@("p.ip.hdrChecksum")),
	CreateTag("p.ip.srcAddr", 208),
	Allocate(Tag("p.ip.srcAddr"), 32),
	Assign(Tag("p.ip.srcAddr"), :@("p.ip.srcAddr")),
	CreateTag("p.ip.dstAddr", 240),
	Allocate(Tag("p.ip.dstAddr"), 32),
	Assign(Tag("p.ip.dstAddr"), :@("p.ip.dstAddr"))
)

// Action
lazy val act_8_100296 = InstructionBlock(
	Assign("action_run", ConstantValue(100296)), 
	
		InstructionBlock(
			//Extern: ck_2.clear,
			Assign("p.ip.hdrChecksum", ConstantBitVector(0, 16)),
			//Extern: ck_2.update,
			Assign("tmp_20", SymbolicValue()),
			Assign("p.ip.hdrChecksum", :@("tmp_20"))
		)
)


//Table
lazy val tbl_act_8_102306 = InstructionBlock(
	Fork(act_8_100296)
	// default_action act_8
)



lazy val main = InstructionBlock(TopParser, Allocate("action_run"), TopPipe, TopDeparser)


