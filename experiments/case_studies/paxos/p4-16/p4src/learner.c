#define BITSLICE(x, a, b) ((x) >> (b)) & ((1 << ((a)-(b)+1)) - 1)
#include<stdio.h>
#include<stdint.h>
#include<stdlib.h>

int action_run;


void handle_2b_0_167621();
void handle_new_value_0_167739();
void NoAction_0_165463();
void place_holder_table_165473();
void transport_tbl_165310();
void parse_udp();
void reset_consensus_instance_165240();
void accept();
void start();
void parse_paxos();
void learner_tbl_165134();
void _drop_0_164995();
void reject();
void forward_0_165283();
void parse_ipv4();
void read_round_0_165011();
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
	printf("Packet dropped\n");
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
	printf("Packet dropped");
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
		read_round_0_165011();
	if(hdr.paxos.rnd > meta.paxos_metadata.round) {
	reset_consensus_instance_165240();
} else {
	if((hdr.paxos.rnd == meta.paxos_metadata.round)) {
	learner_tbl_165134();
}
}
	if((meta.paxos_metadata.ack_acceptors == 6) || (meta.paxos_metadata.ack_acceptors == 5) || (meta.paxos_metadata.ack_acceptors == 3)) {
	transport_tbl_165310();
}

}
}
}

// Action
void _drop_0_164995() {
	action_run = 164995;
		mark_to_drop();

}


// Action
void read_round_0_165011() {
	action_run = 165011;
	uint32_t tmp_round;
	klee_make_symbolic(&tmp_round, sizeof(tmp_round), "tmp_round");
	meta.paxos_metadata.round = tmp_round;

	meta.paxos_metadata.set_drop = 1;
	uint8_t tmp_ack_acceptors;
	klee_make_symbolic(&tmp_ack_acceptors, sizeof(tmp_ack_acceptors), "tmp_ack_acceptors");
	meta.paxos_metadata.ack_acceptors = tmp_ack_acceptors;

}


// Action
void handle_2b_0_167621() {
	action_run = 167621;
	meta.paxos_metadata.ack_acceptors = meta.paxos_metadata.ack_acceptors | 1 << (uint8_t) hdr.paxos.acptid;
}


// Action
void handle_new_value_0_167739() {
	action_run = 167739;
	
}


// Action
void forward_0_165283() {
	action_run = 165283;
	PortId port;
	klee_make_symbolic(&port, sizeof(port), "port");
uint32_t learnerPort;
	klee_make_symbolic(&learnerPort, sizeof(learnerPort), "learnerPort");
	standard_metadata.egress_spec = port;
	hdr.udp.dstPort = learnerPort;

}


//Table
void learner_tbl_165134() {
	// keys: hdr.paxos.msgtype:exact
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		default: handle_2b_0_167621(); break;
	}
	// size 1
	// default_action handle_2b_0();

}


//Table
void reset_consensus_instance_165240() {
	// keys: hdr.paxos.msgtype:exact
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		default: handle_new_value_0_167739(); break;
	}
	// size 1
	// default_action handle_new_value_0();

}


//Table
void transport_tbl_165310() {
	// keys: meta.paxos_metadata.set_drop:exact
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: _drop_0_164995(); break;
		default: forward_0_165283(); break;
	}
	// size 2
	// default_action _drop_0();

}



//Control

void egress() {
	place_holder_table_165473();
}

// Action
void NoAction_0_165463() {
	action_run = 165463;
	
}


//Table
void place_holder_table_165473() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		default: NoAction_0_165463(); break;
	}
	// size 2
	// default_action NoAction_0();

}

void end_assertions(){
}


int main() {
	TopParser();
	ingress();
	egress();
	TopDeparser();
	end_assertions();
	return 0;
}
