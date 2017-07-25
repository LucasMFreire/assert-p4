#include<stdio.h>
#include<stdint.h>
#include<stdlib.h>

int action_run;

void table_1_102750();
void forward1_0_102681();
void parse_tcp();
void forward_table_102698();
void parse_udp();
void accept();
void start();
void forward_0_102648();
void reject();
void NoAction_0_102637();
void parse_ipv4();
void NoAction_3_102647();
void parse_ethernet();

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

typedef struct {
	uint8_t isValid : 1;
	uint64_t dstAddr : 48;
	uint64_t srcAddr : 48;
	uint32_t etherType : 16;
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
	uint32_t srcAddr : 32;
	uint32_t dstAddr : 32;
} ipv4_t;

typedef struct {
	uint8_t isValid : 1;
	uint32_t srcPort : 16;
	uint32_t dstPort : 16;
	uint32_t seqNo : 32;
	uint32_t ackNo : 32;
	uint8_t dataOffset : 4;
	uint8_t res : 3;
	uint8_t ecn : 3;
	uint8_t ctrl : 6;
	uint32_t window : 16;
	uint32_t checksum : 16;
	uint32_t urgentPtr : 16;
} tcp_t;

typedef struct {
	uint8_t isValid : 1;
	uint32_t srcPort : 16;
	uint32_t dstPort : 16;
	uint32_t length_ : 16;
	uint32_t checksum : 16;
} udp_t;

typedef struct {
} metadata;

typedef struct {
	ethernet_t ethernet;
	ipv4_t ipv4;
	tcp_t tcp;
	udp_t udp;
} headers;

headers hdr;
metadata meta;
standard_metadata_t standard_metadata;


void parse_ethernet() {
	hdr.ethernet.isValid = 1;
	switch(hdr.ethernet.etherType){
		case 2048:	parse_ipv4(); break;
		default:	accept(); break;
	}
}


void parse_ipv4() {
	hdr.ipv4.isValid = 1;
	switch(hdr.ipv4.protocol){
		case 6:	parse_tcp(); break;
		case 17:	parse_udp(); break;
		default:	accept(); break;
	}
}


void parse_tcp() {
	hdr.tcp.isValid = 1;
	accept();
}


void parse_udp() {
	hdr.udp.isValid = 1;
	switch(hdr.udp.dstPort){
		default:	accept(); break;
	}
}


void start() {
	parse_ethernet();
}


void accept() {
	
}


void reject() {
	printf("Packet dropped");
	exit(0);
}


void ParserImpl() {
	klee_make_symbolic(&hdr, sizeof(hdr), "hdr");
	klee_make_symbolic(&meta, sizeof(meta), "meta");
	klee_make_symbolic(&standard_metadata, sizeof(standard_metadata), "standard_metadata");

	start();
}

//Control

void ingress() {
	forward_table_102698();
	table_1_102750();
}

// Action
void NoAction_0_102637() {
	action_run = 102637;
	
}


// Action
void NoAction_3_102647() {
	action_run = 102647;
	
}


// Action
void forward_0_102648() {
	action_run = 102648;
	uint32_t port;
	klee_make_symbolic(&port, sizeof(port), "port");
	standard_metadata.egress_spec = port;

}


// Action
void forward1_0_102681() {
	action_run = 102681;
	uint32_t _port;
	klee_make_symbolic(&_port, sizeof(_port), "_port");
	standard_metadata.egress_spec = _port;

}


//Table
void forward_table_102698() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: forward_0_102648(); break;
		default: NoAction_0_102637(); break;
	}
	// size 4
	// default_action NoAction_0();
}


//Table
void table_1_102750() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: forward1_0_102681(); break;
		default: NoAction_3_102647(); break;
	}
	// size 32
	// default_action NoAction_3();
}



//Control

void egress() {
	
}


//Control

void DeparserImpl() {
	//Emit hdr.ethernet
	
	//Emit hdr.ipv4
	
	//Emit hdr.udp
	
	//Emit hdr.tcp
	
}


//Control

void verifyChecksum() {
	
}


//Control

void computeChecksum() {
	
}


int main() {
	ParserImpl();
	ingress();
	egress();
	DeparserImpl();
	return 0;
}

