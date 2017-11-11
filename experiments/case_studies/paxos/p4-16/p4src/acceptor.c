#define BITSLICE(x, a, b) ((x) >> (b)) & ((1 << ((a)-(b)+1)) - 1)
#include<stdio.h>
#include<stdint.h>
#include<stdlib.h>

int action_run;
int traverse_handle_1a = 0;
int handle_1a_msg_type = -1;
int traverse_handle_2a = 0;
int handle_2a_msg_type = -1;
int forward = 1;
uint32_t constant_acptid;



void _drop_2_163187();
void _drop_0_163171();
void transport_tbl_163485();
void acceptor_tbl_163403();
void NoAction_0_163602();
void parse_udp();
void handle_1a_0_165781();
void handle_2a_0_163324();
void accept();
void start();
void parse_paxos();
void place_holder_table_163612();
void reject();
void parse_ipv4();
void read_round_0_163194();
void forward_0_163458();
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
		default: reject();
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
	constant_acptid = hdr.paxos.acptid;
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
uint32_t tmp_6;

void verifyChecksum() {
		klee_make_symbolic(&tmp_6, sizeof(tmp_6), "tmp_6");

	if((hdr.ipv4.hdrChecksum == tmp_6)) {
	mark_to_drop();
}
}


//Control
uint32_t tmp_8;

void computeChecksum() {
		klee_make_symbolic(&tmp_8, sizeof(tmp_8), "tmp_8");

	hdr.ipv4.hdrChecksum = tmp_8;
}


//Control
uint32_t tmp_9;
uint64_t tmp_11;

void ingress() {
	if((hdr.ipv4.$valid$ == 1)) {
	if((hdr.paxos.$valid$ == 1)) {
		read_round_0_163194();
	if(hdr.paxos.rnd >= meta.paxos_metadata.round) {
		acceptor_tbl_163403();
	transport_tbl_163485();

}

}
}
}

// Action
void _drop_0_163171() {
	action_run = 163171;
		mark_to_drop();

}


// Action
void _drop_2_163187() {
	action_run = 163187;
		mark_to_drop();

}


// Action
void read_round_0_163194() {
	action_run = 163194;
	uint32_t tmp_round;
	klee_make_symbolic(&tmp_round, sizeof(tmp_round), "tmp_round");
	meta.paxos_metadata.round = tmp_round;

	meta.paxos_metadata.set_drop = 1;

}


// Action
void handle_1a_0_165781() {
	traverse_handle_1a = 1;
	handle_1a_msg_type = (hdr.paxos.msgtype == 0);
	action_run = 165781;
		hdr.paxos.msgtype = 1;
		klee_make_symbolic(&tmp_9, sizeof(tmp_9), "tmp_9");

	hdr.paxos.vrnd = tmp_9;
		klee_make_symbolic(&tmp_11, sizeof(tmp_11), "tmp_11");

	hdr.paxos.paxosval = tmp_11;
	uint32_t tmp_acptid;
	klee_make_symbolic(&tmp_acptid, sizeof(tmp_acptid), "tmp_acptid");
	hdr.paxos.acptid = tmp_acptid;

	meta.paxos_metadata.set_drop = 0;

}


// Action
void handle_2a_0_163324() {
	traverse_handle_2a = 1;
	handle_2a_msg_type = (hdr.paxos.msgtype == 2);
	action_run = 163324;
		hdr.paxos.msgtype = 3;
	uint32_t tmp_acptid;
	klee_make_symbolic(&tmp_acptid, sizeof(tmp_acptid), "tmp_acptid");
	hdr.paxos.acptid = tmp_acptid;

	meta.paxos_metadata.set_drop = 0;

}


// Action
void forward_0_163458() {
	action_run = 163458;
	PortId port;
	klee_make_symbolic(&port, sizeof(port), "port");
uint32_t learnerPort;
	klee_make_symbolic(&learnerPort, sizeof(learnerPort), "learnerPort");
	standard_metadata.egress_spec = port;
	hdr.udp.dstPort = learnerPort;

}


//Table
void acceptor_tbl_163403() {
	// keys: hdr.paxos.msgtype:exact
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: handle_1a_0_165781(); break;
		case 1: handle_2a_0_163324(); break;
		default: _drop_0_163171(); break;
	}
	// size 4
	// default_action _drop_0();

}


//Table
void transport_tbl_163485() {
	// keys: meta.paxos_metadata.set_drop:exact
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: _drop_2_163187(); break;
		default: forward_0_163458(); break;
	}
	// size 2
	// default_action _drop_2();

}



//Control

void egress() {
	place_holder_table_163612();
}

// Action
void NoAction_0_163602() {
	action_run = 163602;
	
}


//Table
void place_holder_table_163612() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		default: NoAction_0_163602(); break;
	}
	// size 2
	// default_action NoAction_0();

}

void end_assertions(){

	if(traverse_handle_1a && !handle_1a_msg_type && (handle_1a_msg_type != -1)){
		klee_warning_once("handle_1a executed with msgtype different that 1A");
		klee_assert(0);
	}

	if(traverse_handle_2a && !handle_2a_msg_type && (handle_2a_msg_type != -1)){
		klee_warning_once("handle_2a executed with msgtype different that 2A");
		klee_assert(0);
	}

	if(forward && (constant_acptid == hdr.paxos.acptid)){
		klee_warning_once("packet forwarded and swid not updated");
		klee_assert(0);
	}

	if(forward && !(traverse_handle_1a || traverse_handle_2a)){
		klee_warning("WTH???");
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


