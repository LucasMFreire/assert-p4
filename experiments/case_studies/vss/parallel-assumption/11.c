#include<stdio.h>
#include<stdint.h>
#include<stdlib.h>

int a1 = 0;
int required_to_forward1 = 0;
int required_to_forward2 = 0;

void parse_ipv4();
void accept();
void tbl_act_101773();
void tbl_act_0_101840();
void ipv4_match_92978();
void tbl_act_1_101900();
void tbl_act_2_101934();
void check_ttl_93039();
void tbl_act_3_101994();
void tbl_act_4_102028();
void tbl_act_5_102065();
void dmac_1_93101();
void tbl_act_6_102119();
void tbl_act_7_102153();
void tbl_Drop_action_101809();
void smac_1_93165();
void tbl_act_8_102306();
void reject();

int action_run;  

typedef uint8_t PortId;

typedef struct {
	uint8_t outputPort;
} OutCtrl;

typedef struct {
	PortId inputPort;
} InControl;

typedef struct {
	PortId outputPort;
} OutControl;


typedef uint64_t EthernetAddress;

typedef uint32_t IPv4Address;

typedef struct {
	uint8_t isValid : 1;
	EthernetAddress dstAddr: 48;
	EthernetAddress srcAddr: 48;
	uint32_t etherType : 16;
} Ethernet_h;

typedef struct {
	uint8_t isValid : 1;
	uint8_t version : 4;
	uint8_t ihl : 4;
	uint8_t diffserv : 8;
	uint32_t totalLen : 16;
	uint32_t identification : 16;
	uint8_t flags : 3;
	uint32_t fragOffset : 13;
	uint8_t ttl : 8;
	uint8_t protocol : 8;
	uint32_t hdrChecksum : 16;
	IPv4Address srcAddr: 32;
	IPv4Address dstAddr: 32;
} Ipv4_h;

typedef struct {
	Ethernet_h ethernet;
	Ipv4_h ip;
} Parsed_packet;

OutCtrl outCtrl;
Parsed_packet p;

uint8_t tmp_10;
uint8_t tmp_11;
uint32_t tmp_12;
uint8_t tmp_13;
uint8_t tmp_14;


uint8_t version_const;
uint8_t ihl_const;
uint8_t diffserv_const;
uint32_t totalLen_const;
uint32_t identification_const;
uint8_t flags_const;
uint32_t fragOffset_const;
uint8_t protocol_const;
IPv4Address srcAddr_const;
IPv4Address dstAddr_const;


void start() {
	p.ethernet.isValid = 1;
        klee_assume(p.ethernet.etherType == 2048);
	parse_ipv4();
}


void parse_ipv4() {
	p.ip.isValid = 1;
	tmp_10 = (p.ip.version == 4);
	klee_assume(tmp_10 != 0);
	tmp_11 = (p.ip.ihl == 5);
	klee_assume(tmp_11 != 0);
	//Extern: ck.clear
	//Extern: ck.update
		klee_make_symbolic(&tmp_12, sizeof(tmp_12), "tmp_12");

	tmp_13 = (tmp_12 == 0);
	tmp_14 = tmp_13;
	klee_assume(tmp_14 != 0);
	accept();
}


void accept() {
	
}


void reject() {
	exit(0);
}


void TopParser() {
	klee_make_symbolic(&p, sizeof(p), "p");
    
    version_const= p.ip.version;
    ihl_const= p.ip.ihl;
    diffserv_const= p.ip.diffserv;
    totalLen_const= p.ip.totalLen;
    identification_const= p.ip.identification;
    flags_const= p.ip.flags;
    fragOffset_const= p.ip.fragOffset;
    protocol_const= p.ip.protocol;
    srcAddr_const= p.ip.srcAddr;
    dstAddr_const= p.ip.dstAddr;
    
	start();
}

//Control
IPv4Address nextHop_1;
uint8_t tmp_15;
uint8_t tmp_17;
uint8_t tmp_18;
uint8_t tmp_19;
IPv4Address nextHop_2;
IPv4Address nextHop_3;
uint8_t hasReturned_0;
IPv4Address nextHop_0;

void TopPipe() {
	tbl_act_101773();
  
	if(!hasReturned_0) {
		ipv4_match_92978();
	tbl_act_1_101900();
	if(tmp_17) {
	tbl_act_2_101934();
}

}
	if(!hasReturned_0) {
		check_ttl_93039();
	tbl_act_3_101994();
	if(tmp_18) {
	tbl_act_4_102028();
}

}
	if(!hasReturned_0) {
		tbl_act_5_102065();
	dmac_1_93101();
	tbl_act_6_102119();
	if(tmp_19) {
	tbl_act_7_102153();
}

}
	if(!hasReturned_0) {
	smac_1_93165();
}
}

// Action
void NoAction_0_92881() {
	action_run = 92881;
	
}


// Action
void Drop_action_0_92891() {
	action_run = 92891;
	outCtrl.outputPort = 15;
    a1 = 1;

}


// Action
void Drop_action_4_92906() {
	action_run = 92906;
		outCtrl.outputPort = 15;
    a1 = 1;
}


// Action
void Drop_action_5_92913() {
	action_run = 92913;
		outCtrl.outputPort = 15;
    a1 = 1;
}


// Action
void Drop_action_6_92920() {
	action_run = 92920;
		outCtrl.outputPort = 15;
    a1 = 1;
}


// Action
void Set_nhop_0_94278() {
	action_run = 94278;
	IPv4Address ipv4_dest;
	klee_make_symbolic(&ipv4_dest, sizeof(ipv4_dest), "ipv4_dest");
PortId port;
	klee_make_symbolic(&port, sizeof(port), "port");
	nextHop_0 = ipv4_dest;
	tmp_15 = p.ip.ttl + 255;
	p.ip.ttl = p.ip.ttl + 255;
	outCtrl.outputPort = port;
	nextHop_2 = ipv4_dest;

}


// Action
void Send_to_cpu_0_93024() {
	action_run = 93024;
		outCtrl.outputPort = 14;

}


// Action
void Set_dmac_0_93081() {
	action_run = 93081;
	EthernetAddress dmac;
	klee_make_symbolic(&dmac, sizeof(dmac), "dmac");
	p.ethernet.dstAddr = dmac;
  required_to_forward2 = 1;

}


// Action
void Set_smac_0_93145() {
	action_run = 93145;
	EthernetAddress smac;
	klee_make_symbolic(&smac, sizeof(smac), "smac");
	p.ethernet.srcAddr = smac;
    required_to_forward1 = 1;
}


// Action
void act_99936() {
	action_run = 99936;
		hasReturned_0 = 1;

}


// Action
void act_0_99948() {
	action_run = 99948;
		hasReturned_0 = 0;
}


// Action
void act_1_99987() {
	action_run = 99987;
		hasReturned_0 = 1;

}


// Action
void act_2_100003() {
	action_run = 100003;
		nextHop_1 = nextHop_2;
	tmp_17 = (outCtrl.outputPort == 15);

}


// Action
void act_3_100044() {
	action_run = 100044;
		hasReturned_0 = 1;

}


// Action
void act_4_100060() {
	action_run = 100060;
		tmp_18 = (outCtrl.outputPort == 14);

}


// Action
void act_5_100096() {
	action_run = 100096;
		nextHop_3 = nextHop_1;

}


// Action
void act_6_100112() {
	action_run = 100112;
		hasReturned_0 = 1;

}


// Action
void act_7_100128() {
	action_run = 100128;
		tmp_19 = (outCtrl.outputPort == 15);

}


//Table
void ipv4_match_92978() {
		Drop_action_0_92891();
	//	default: Set_nhop_0_94278(); break;
	// size 1024
	// default_action Drop_action_0();
}


//Table
void check_ttl_93039() {
		Send_to_cpu_0_93024();
//		default: NoAction_0_92881(); break;
}


//Table
void dmac_1_93101() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: Drop_action_4_92906(); break;
		default: Set_dmac_0_93081(); break;
	}
	// size 1024
	// default_action Drop_action_4();
}


//Table
void smac_1_93165() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: Drop_action_5_92913(); break;
		default: Set_smac_0_93145(); break;
	}
	// size 16
	// default_action Drop_action_5();
}


//Table
void tbl_act_101773() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		default: act_0_99948(); break;
	}
	// default_action act_0();
}


//Table
void tbl_Drop_action_101809() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		default: Drop_action_6_92920(); break;
	}
	// default_action Drop_action_6();
}


//Table
void tbl_act_0_101840() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		default: act_99936(); break;
	}
	// default_action act();
}


//Table
void tbl_act_1_101900() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		default: act_2_100003(); break;
	}
	// default_action act_2();
}


//Table
void tbl_act_2_101934() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		default: act_1_99987(); break;
	}
	// default_action act_1();
}


//Table
void tbl_act_3_101994() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		default: act_4_100060(); break;
	}
	// default_action act_4();
}


//Table
void tbl_act_4_102028() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		default: act_3_100044(); break;
	}
	// default_action act_3();
}


//Table
void tbl_act_5_102065() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		default: act_5_100096(); break;
	}
	// default_action act_5();
}


//Table
void tbl_act_6_102119() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		default: act_7_100128(); break;
	}
	// default_action act_7();
}


//Table
void tbl_act_7_102153() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		default: act_6_100112(); break;
	}
	// default_action act_6();
}



//Control
uint32_t tmp_20;

void TopDeparser() {
	//Emit p.ethernet
	
	if(p.ip.isValid) {
		tbl_act_8_102306();

    }
    
	//Emit p.ip

  if(a1 && outCtrl.outputPort != 15){
   	klee_print_once(0, ":: INCORRECT FORWARD, PACKET SHOULD HAVE DROPPED");
  }
  
  if(p.ip.ttl == 0 && outCtrl.outputPort != 15){
   	klee_print_once(1, "Assert error:: forwad -> p.ip.ttl == 0\n");
  }
  
  if(version_const != p.ip.version){
    klee_print_once(2, "Assert error:: version_const");
  }
  if(ihl_const != p.ip.ihl){
    klee_print_once(3, "Assert error:: ihl_const");
  }
  if(diffserv_const != p.ip.diffserv){
    klee_print_once(4, "Assert error:: diffserv_const");
  }
  if(totalLen_const != p.ip.totalLen){
    klee_print_once(5, "Assert error:: totalLen_const");
  }
  if(identification_const != p.ip.identification){
    klee_print_once(6, "Assert error:: identification_const");
  }
  if(flags_const != p.ip.flags){
    klee_print_once(7, "Assert error:: flags_const");
  }
  if(fragOffset_const != p.ip.fragOffset){
    klee_print_once(8, "Assert error:: fragOffset_const");
  }
  if(protocol_const != p.ip.protocol){
    klee_print_once(9, "Assert error:: protocol_const");
  }
  if(srcAddr_const != p.ip.srcAddr){
    klee_print_once(10, "Assert error:: srcAddr_const");
  }
  if(dstAddr_const != p.ip.dstAddr){
    klee_print_once(11, "Assert error:: dstAddr_const");
  }
  
}


// Action
void act_8_100296() {
	action_run = 100296;
		//Extern: ck_2.clear
	p.ip.hdrChecksum = 0;
	//Extern: ck_2.update
		klee_make_symbolic(&tmp_20, sizeof(tmp_20), "tmp_20");

	p.ip.hdrChecksum = tmp_20;

}


//Table
void tbl_act_8_102306() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		default: act_8_100296(); break;
	}
	// default_action act_8();
}



int main() {
	TopParser();
	TopPipe();
	TopDeparser();
	return 0;
}
