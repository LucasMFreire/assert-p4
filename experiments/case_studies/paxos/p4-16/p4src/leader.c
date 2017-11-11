#define BITSLICE(x, a, b) ((x) >> (b)) & ((1 << ((a)-(b)+1)) - 1)
#include<stdio.h>
#include<stdint.h>
#include<stdlib.h>

int action_run;

int traverse_increase_instance = 0;
int mesg_type_2a = -1;
int forward = 1;


void forward_0_144407();
void _drop_2_144269();
void NoAction_0_144533();
void parse_udp();
void reset_instance_0_144327();
void _drop_0_144253();
void increase_instance_0_144276();
void accept();
void start();
void parse_paxos();
void reject();
void transport_tbl_144434();
void place_holder_table_144543();
void parse_ipv4();
void leader_tbl_144352();
typedef struct {
	uint32_t ingress_port : 9;
	uint32_t egress_spec : 9;
	uint32_t egress_port : 9;
	uint32_t clone_spec : 32;
	uint32_t instance_type : 32;
	uint8_t drop : 1;
	uint32_t recirculate_port : 16;
	uint32_t packet_length : 32;
	uint32_t enq_timestamp : 32;
	uint32_t enq_qdepth : 19;
	uint32_t deq_timedelta : 32;
	uint32_t deq_qdepth : 19;
	uint64_t ingress_global_timestamp : 48;
	uint32_t lf_field_list : 32;
	uint32_t mcast_grp : 16;
	uint8_t resubmit_flag : 1;
	uint32_t egress_rid : 16;
} standard_metadata_t;

void mark_to_drop() {
	//printf("Packet dropped\n");
	forward = 0;
	end_assertions();
	exit(0);
}

typedef uint64_t EthernetAddress;

typedef uint32_t IPv4Address;

typedef uint32_t PortId;

typedef struct {
	uint8_t isValid : 1;
	EthernetAddress dstAddr: 48;
	EthernetAddress srcAddr: 48;
	uint32_t etherType : 16;
	uint8_t $valid$ : 1;
} ethernet_t;

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
	uint8_t $valid$ : 1;
} ipv4_t;

typedef struct {
	uint8_t isValid : 1;
	uint32_t srcPort : 16;
	uint32_t dstPort : 16;
	uint32_t length_ : 16;
	uint32_t checksum : 16;
	uint8_t $valid$ : 1;
} udp_t;

typedef struct {
	uint8_t isValid : 1;
	uint32_t msgtype : 16;
	uint32_t inst : 32;
	uint32_t rnd : 16;
	uint32_t vrnd : 16;
	uint32_t acptid : 16;
	uint32_t paxoslen : 32;
	uint64_t paxosval : 64;
	uint8_t $valid$ : 1;
} paxos_t;

typedef struct {
	ethernet_t ethernet;
	ipv4_t ipv4;
	udp_t udp;
	paxos_t paxos;
} headers;

typedef struct {
	uint32_t round : 16;
	uint8_t set_drop : 1;
	uint8_t ack_count : 8;
	uint8_t ack_acceptors : 8;
} paxos_metadata_t;

typedef struct {
	paxos_metadata_t paxos_metadata;
} metadata;

headers hdr;
metadata meta;
standard_metadata_t standard_metadata;


void start() {
	hdr.ethernet.isValid = 1;
	switch(hdr.ethernet.etherType){
		case 2048:	parse_ipv4(); break;
	}
}


void parse_ipv4() {
	hdr.ipv4.isValid = 1;
	switch(hdr.ipv4.protocol){
		case 17:	parse_udp(); break;
		default:	accept(); break;
	}
}


void parse_udp() {
	hdr.udp.isValid = 1;
	switch(hdr.udp.dstPort){
		case 34952:	parse_paxos(); break;
		default:	accept(); break;
	}
}


void parse_paxos() {
	hdr.paxos.isValid = 1;
	accept();
}


void accept() {
	
}


void reject() {
	//printf("Packet dropped");
	forward = 0;
	end_assertions();
	exit(0);
}


void TopParser() {
	klee_make_symbolic(&hdr, sizeof(hdr), "hdr");
	klee_make_symbolic(&meta, sizeof(meta), "meta");
	klee_make_symbolic(&standard_metadata, sizeof(standard_metadata), "standard_metadata");

	start();
}

//Control

void TopDeparser() {
	//Emit hdr.ethernet
	
	//Emit hdr.ipv4
	
	//Emit hdr.udp
	
	//Emit hdr.paxos
	
}


typedef struct {
	uint8_t field : 4;
	uint8_t field_0 : 4;
	uint8_t field_1 : 8;
	uint32_t field_2 : 16;
	uint32_t field_3 : 16;
	uint8_t field_4 : 3;
	uint32_t field_5 : 13;
	uint8_t field_6 : 8;
	uint8_t field_7 : 8;
	uint32_t field_8 : 32;
	uint32_t field_9 : 32;
} tuple_0;

//Control
uint32_t tmp_2;

void verifyChecksum() {
		klee_make_symbolic(&tmp_2, sizeof(tmp_2), "tmp_2");

	if((hdr.ipv4.hdrChecksum == tmp_2)) {
	mark_to_drop();
}
}


//Control
uint32_t tmp_4;

void computeChecksum() {
		klee_make_symbolic(&tmp_4, sizeof(tmp_4), "tmp_4");

	hdr.ipv4.hdrChecksum = tmp_4;
}


//Control

void ingress() {
	if((hdr.ipv4.$valid$ == 1)) {
	if((hdr.paxos.$valid$ == 1)) {
		leader_tbl_144352();
	transport_tbl_144434();

}
}
}

// Action
void _drop_0_144253() {
	action_run = 144253;
		mark_to_drop();

}


// Action
void _drop_2_144269() {
	action_run = 144269;
		mark_to_drop();

}


// Action
void increase_instance_0_144276() {
	traverse_increase_instance = 1;
	mesg_type_2a = (hdr.paxos.msgtype == 2);

	action_run = 144276;
	uint32_t tmp_inst;
	klee_make_symbolic(&tmp_inst, sizeof(tmp_inst), "tmp_inst");
	hdr.paxos.inst = tmp_inst;

	hdr.paxos.inst = hdr.paxos.inst + 1;
	meta.paxos_metadata.set_drop = 0;

}


// Action
void reset_instance_0_144327() {
	action_run = 144327;
		meta.paxos_metadata.set_drop = 1;

}


// Action
void forward_0_144407() {
	action_run = 144407;
	PortId port;
	klee_make_symbolic(&port, sizeof(port), "port");
uint32_t acceptorPort;
	klee_make_symbolic(&acceptorPort, sizeof(acceptorPort), "acceptorPort");
	standard_metadata.egress_spec = port;
	hdr.udp.dstPort = acceptorPort;

}


//Table
void leader_tbl_144352() {
	// keys: hdr.paxos.msgtype:exact
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: increase_instance_0_144276(); break;
		case 1: reset_instance_0_144327(); break;
		default: _drop_0_144253(); break;
	}
	// size 4
	// default_action _drop_0();

}


//Table
void transport_tbl_144434() {
	// keys: meta.paxos_metadata.set_drop:exact
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: _drop_2_144269(); break;
		default: forward_0_144407(); break;
	}
	// size 2
	// default_action _drop_2();

}



//Control

void egress() {
	place_holder_table_144543();
}

// Action
void NoAction_0_144533() {
	action_run = 144533;
	
}


//Table
void place_holder_table_144543() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		default: NoAction_0_144533(); break;
	}
	// size 2
	// default_action NoAction_0();

}

void end_assertions(){
	if(traverse_increase_instance && !mesg_type_2a && (mesg_type_2a != -1)){
		klee_warning("increase_instance called without msg type 2a");
		klee_assert(0);
	}

	if(traverse_increase_instance && !forward){
		klee_warning("increase_instance called but packet dropped");
		klee_assert(0);
	}
}

int main() {
	TopParser();
	ingress();
	egress();
	TopDeparser();
	end_assertions();
	return 0;
}


