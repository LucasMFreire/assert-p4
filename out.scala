val block30603 = InstructionBlock(

)

val block92899 = InstructionBlock(
	Assign('outCtrl.outputPort', ConstantValue(15))
)

val block92907 = InstructionBlock(
	Assign('outCtrl.outputPort', ConstantValue(15))
)

val block92914 = InstructionBlock(
	Assign('outCtrl.outputPort', ConstantValue(15))
)

val block92921 = InstructionBlock(
	Assign('outCtrl.outputPort', ConstantValue(15))
)

val block94296 = InstructionBlock(
	Assign('nextHop_0', :@('ipv4_dest')),
	Assign('tmp_15', :+:(:@('headers.ip.ttl'), ConstantValue(255))),
	Assign('headers.ip.ttl', :+:(:@('headers.ip.ttl'), ConstantValue(255))),
	Assign('outCtrl.outputPort', :@('port')),
	Assign('nextHop_2', :@('ipv4_dest'))
)

val block93032 = InstructionBlock(
	Assign('outCtrl.outputPort', ConstantValue(14))
)

val block93092 = InstructionBlock(
	Assign('headers.ethernet.dstAddr', :@('dmac'))
)

val block93156 = InstructionBlock(
	Assign('headers.ethernet.srcAddr', :@('smac'))
)

val block99933 = InstructionBlock(
	Assign('hasReturned_0', ConstantValue(0))
)

val block99945 = InstructionBlock(
	Assign('hasReturned_0', ConstantValue(0)),
	Assign('tmp_16', <Neq>93219
)
)

val block99984 = InstructionBlock(
	Assign('hasReturned_0', ConstantValue(0))
)

val block100000 = InstructionBlock(
	Assign('nextHop_1', :@('nextHop_2')),
	If(Constrain('outCtrl.outputPort', :==:(ConstantValue(15))), Assign('tmp_17', ConstantValue(1)), Assign('tmp_17', ConstantValue(0)))
)

val block100041 = InstructionBlock(
	Assign('hasReturned_0', ConstantValue(0))
)

val block100057 = InstructionBlock(
	If(Constrain('outCtrl.outputPort', :==:(ConstantValue(14))), Assign('tmp_18', ConstantValue(1)), Assign('tmp_18', ConstantValue(0)))
)

val block100093 = InstructionBlock(
	Assign('nextHop_3', :@('nextHop_1'))
)

val block100109 = InstructionBlock(
	Assign('hasReturned_0', ConstantValue(0))
)

val block100125 = InstructionBlock(
	If(Constrain('outCtrl.outputPort', :==:(ConstantValue(15))), Assign('tmp_19', ConstantValue(1)), Assign('tmp_19', ConstantValue(0)))
)

val block101784 = InstructionBlock(
	tbl_Drop_action,
	tbl_act_0
)

val block101852 = InstructionBlock(
	ipv4_match,
	tbl_act_1,
	If(Constrain(:@('tmp_17'), :==:(ConstantValue(1))), tbl_act_2)
)

val block101946 = InstructionBlock(
	check_ttl,
	tbl_act_3,
	If(Constrain(:@('tmp_18'), :==:(ConstantValue(1))), tbl_act_4)
)

val block102040 = InstructionBlock(
	tbl_act_5,
	dmac_1,
	tbl_act_6,
	If(Constrain(:@('tmp_19'), :==:(ConstantValue(1))), tbl_act_7)
)

val block101748 = InstructionBlock(
	tbl_act,
	If(Constrain(:@('tmp_16'), :==:(ConstantValue(1))), block101784),
	If(Constrain(:@('hasReturned_0'), :==:(ConstantValue(0))), block101852),
	If(Constrain(:@('hasReturned_0'), :==:(ConstantValue(0))), block101946),
	If(Constrain(:@('hasReturned_0'), :==:(ConstantValue(0))), block102040),
	If(Constrain(:@('hasReturned_0'), :==:(ConstantValue(0))), smac_1)
)

val block100293 = InstructionBlock(
	//Extern: ck_2.clear,
	Assign('p.ip.hdrChecksum', ConstantValue(0)),
	//Extern: ck_2.update,
	Assign('tmp_20', SymbolicValue()),
	Assign('p.ip.hdrChecksum', :@('tmp_20'))
)

val block102281 = InstructionBlock(
	tbl_act_8
)

val block102217 = InstructionBlock(
	//Extern: b.emit,
	If(Constrain(p.ip.isValid), block102281),
	//Extern: b.emit
)

<Type_Error>16

<Type_Extern>69

<Type_Extern>84

<Type_Method>95

<Declaration_MatchKind>106

<Type_Typedef>110

<Type_Struct>119

<Type_Struct>134

<Type_Parser>161

<Type_Control>179

<Type_Control>191

<Type_Package>218

<Type_Extern>253

<Type_Typedef>258

<Type_Typedef>261



<Type_Struct>327


Allocate('tmp_10')
Allocate('tmp_11')
Allocate('tmp_12')
Allocate('tmp_13')
Allocate('tmp_14')
<Declaration_Instance>92694

val start = InstructionBlock(
	,
	If(etherType_p.ethernet == 2048, parse_ipv4,
	
)


val parse_ipv4 = InstructionBlock(
	,
	If(Constrain('p.ip.version', :==:(ConstantValue(4))), Assign('tmp_10', ConstantValue(1)), Assign('tmp_10', ConstantValue(0))),
	verify,
	If(Constrain('p.ip.ihl', :==:(ConstantValue(5))), Assign('tmp_11', ConstantValue(1)), Assign('tmp_11', ConstantValue(0))),
	verify,
	//Extern: ck.clear,
	//Extern: ck.update,
	Assign('tmp_12', SymbolicValue()),
	If(Constrain('tmp_12', :==:(ConstantValue(0))), Assign('tmp_13', ConstantValue(1)), Assign('tmp_13', ConstantValue(0))),
	Assign('tmp_14', :@('tmp_13')),
	verify,
	accept
)


val accept = InstructionBlock(
	
)


val reject = InstructionBlock(
	
)



Allocate('headers')
Allocate('parseError')
Allocate('inCtrl')
Allocate('outCtrl')

Allocate('tmp_15')
Allocate('tmp_16')
Allocate('tmp_17')
Allocate('tmp_18')
Allocate('tmp_19')


Allocate('hasReturned_0')

// Action
val NoAction_0 = InstructionBlock(
	block30603
)


// Action
val Drop_action_0 = InstructionBlock(
	block92899
)


// Action
val Drop_action_4 = InstructionBlock(
	block92907
)


// Action
val Drop_action_5 = InstructionBlock(
	block92914
)


// Action
val Drop_action_6 = InstructionBlock(
	block92921
)


// Action
val Set_nhop_0 = InstructionBlock(
	Assign('ipv4_dest', SymbolicValue()),
	Assign('port', SymbolicValue()),
	block94296
)


//Table
val ipv4_match = InstructionBlock(
	// keys: headers.ip.dstAddr
	Fork(Drop_action_0, Set_nhop_0)
	// size ConstantValue(1024)
	// default_action Drop_action_0
)


// Action
val Send_to_cpu_0 = InstructionBlock(
	block93032
)


//Table
val check_ttl = InstructionBlock(
	// keys: headers.ip.ttl
	Fork(Send_to_cpu_0, NoAction_0)
	// default_action NoAction_0
)


// Action
val Set_dmac_0 = InstructionBlock(
	Assign('dmac', SymbolicValue()),
	block93092
)


//Table
val dmac_1 = InstructionBlock(
	// keys: nextHop_3
	Fork(Drop_action_4, Set_dmac_0)
	// size ConstantValue(1024)
	// default_action Drop_action_4
)


// Action
val Set_smac_0 = InstructionBlock(
	Assign('smac', SymbolicValue()),
	block93156
)


//Table
val smac_1 = InstructionBlock(
	// keys: outCtrl.outputPort
	Fork(Drop_action_5, Set_smac_0)
	// size ConstantValue(16)
	// default_action Drop_action_5
)


// Action
val act = InstructionBlock(
	block99933
)


// Action
val act_0 = InstructionBlock(
	block99945
)


// Action
val act_1 = InstructionBlock(
	block99984
)


// Action
val act_2 = InstructionBlock(
	block100000
)


// Action
val act_3 = InstructionBlock(
	block100041
)


// Action
val act_4 = InstructionBlock(
	block100057
)


// Action
val act_5 = InstructionBlock(
	block100093
)


// Action
val act_6 = InstructionBlock(
	block100109
)


// Action
val act_7 = InstructionBlock(
	block100125
)


//Table
val tbl_act = InstructionBlock(
	Fork(act_0)
	// default_action act_0
)


//Table
val tbl_Drop_action = InstructionBlock(
	Fork(Drop_action_6)
	// default_action Drop_action_6
)


//Table
val tbl_act_0 = InstructionBlock(
	Fork(act)
	// default_action act
)


//Table
val tbl_act_1 = InstructionBlock(
	Fork(act_2)
	// default_action act_2
)


//Table
val tbl_act_2 = InstructionBlock(
	Fork(act_1)
	// default_action act_1
)


//Table
val tbl_act_3 = InstructionBlock(
	Fork(act_4)
	// default_action act_4
)


//Table
val tbl_act_4 = InstructionBlock(
	Fork(act_3)
	// default_action act_3
)


//Table
val tbl_act_5 = InstructionBlock(
	Fork(act_5)
	// default_action act_5
)


//Table
val tbl_act_6 = InstructionBlock(
	Fork(act_7)
	// default_action act_7
)


//Table
val tbl_act_7 = InstructionBlock(
	Fork(act_6)
	// default_action act_6
)


block101748
Allocate('p')
Allocate('b')
Allocate('tmp_20')
<Declaration_Instance>93366

// Action
val act_8 = InstructionBlock(
	block100293
)


//Table
val tbl_act_8 = InstructionBlock(
	Fork(act_8)
	// default_action act_8
)


block102217
<Declaration_Instance>93453


