#define BITSLICE(x, a, b) ((x) >> (b)) & ((1 << ((a)-(b)+1)) - 1)
#include<stdio.h>
#include<stdint.h>
#include<stdlib.h>

int traverse_handle_1a = 0;
int traverse_handle_2a = 0;
int assert_forward = 1;
int action_run;


void round_tbl_201896();
void accept();
void parse_paxos();
void NoAction_1_201477();
void parse_ethernet();
void drop_tbl_201391();
void read_round_0_201746();
void parse_arp();
void start();
void _drop_0_201365();
void NoAction_7_201479();
void NoAction_6_201478();
void _drop_4_201722();
void reject();
void parse_ipv6();
void parse_ipv4();
void handle_2a_0_201619();
void forward_0_201729();
void NoAction_0_201355();
void handle_1a_0_201532();
void parse_udp();
void _drop_1_201706();
void acceptor_tbl_201777();
void _nop_0_201381();
void forward_tbl_201838();

void end_assertions(){
	if(traverse_handle_1a == 1 && assert_forward == 0){
		klee_print_once(0, "Assert error: handle 1a packet not forward");
	}

	if(traverse_handle_2a == 1 && assert_forward == 0){
		klee_print_once(1, "Assert error: handle 2a packet not forward");
	}
}

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
	uint8_t checksum_error : 1;
} standard_metadata_t;

void mark_to_drop() {
	assert_forward = 0;
	end_assertions();
	exit(0);
}

typedef struct {
	uint32_t round : 16;
	uint8_t set_drop : 1;
} ingress_metadata_t;

typedef struct {
	uint8_t isValid : 1;
	uint32_t hrd : 16;
	uint32_t pro : 16;
	uint8_t hln : 8;
	uint8_t pln : 8;
	uint32_t op : 16;
	uint64_t sha : 48;
	uint32_t spa : 32;
	uint64_t tha : 48;
	uint32_t tpa : 32;
	uint8_t $valid$ : 1;
} arp_t;

typedef struct {
	uint8_t isValid : 1;
	uint64_t dstAddr : 48;
	uint64_t srcAddr : 48;
	uint32_t etherType : 16;
	uint8_t $valid$ : 1;
} ethernet_t;

typedef struct {
	uint8_t isValid : 1;
	uint8_t msgtype : 8;
	uint8_t max_resp : 8;
	uint32_t checksum : 16;
	uint32_t grp_addr : 32;
	uint8_t $valid$ : 1;
} igmp_t;

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
	uint8_t $valid$ : 1;
} ipv4_t;

typedef struct {
	uint8_t isValid : 1;
	uint8_t version : 4;
	uint8_t trafficClass : 8;
	uint32_t flowLabel : 20;
	uint32_t payloadLen : 16;
	uint8_t nextHdr : 8;
	uint8_t hopLimit : 8;
	uint64_t srcAddr : 64;
	uint64_t dstAddr : 64;
	uint8_t $valid$ : 1;
} ipv6_t;

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
	uint8_t isValid : 1;
	uint32_t srcPort : 16;
	uint32_t dstPort : 16;
	uint32_t length_ : 16;
	uint32_t checksum : 16;
	uint8_t $valid$ : 1;
} udp_t;

typedef struct {
	ingress_metadata_t local_metadata;
} metadata;

typedef struct {
	arp_t arp;
	ethernet_t ethernet;
	igmp_t igmp;
	ipv4_t ipv4;
	ipv6_t ipv6;
	paxos_t paxos;
	udp_t udp;
} headers;

headers hdr;
metadata meta;
standard_metadata_t standard_metadata;


void parse_arp() {
	//Extract hdr.arp
	hdr.arp.isValid = 1;
	accept();
}


void parse_ethernet() {
	//Extract hdr.ethernet
	hdr.ethernet.isValid = 1;
 	klee_assume(hdr.ethernet.etherType == 2048);
	parse_ipv4();
}


void parse_ipv4() {
	//Extract hdr.ipv4
	hdr.ipv4.isValid = 1;
	klee_assume(hdr.ipv4.protocol == 17);
	parse_udp();
}


void parse_ipv6() {
	//Extract hdr.ipv6
	hdr.ipv6.isValid = 1;
	accept();
}


void parse_paxos() {
	//Extract hdr.paxos
	hdr.paxos.isValid = 1;
	accept();
}


void parse_udp() {
	//Extract hdr.udp
	hdr.udp.isValid = 1;
	klee_assume(hdr.udp.dstPort == 34952);
	parse_paxos();
}


void start() {
	parse_ethernet();
}


void accept() {
	
}


void reject() {
	assert_forward = 0;
	end_assertions();
	exit(0);
}


void ParserImpl() {
	klee_make_symbolic(&hdr, sizeof(hdr), "hdr");
	klee_make_symbolic(&meta, sizeof(meta), "meta");
	klee_make_symbolic(&standard_metadata, sizeof(standard_metadata), "standard_metadata");

	start();
}

//Control

void egress() {
	drop_tbl_201391();
}

// Action
void NoAction_0_201355() {
	action_run = 201355;
	
}


// Action
void _drop_0_201365() {
	action_run = 201365;
		mark_to_drop();

}


// Action
void _nop_0_201381() {
	action_run = 201381;
	
}


//Table
void drop_tbl_201391() {
	klee_assume(meta.local_metadata.set_drop != 1);
		_nop_0_201381();
}



//Control

void ingress() {
	if((hdr.ipv4.$valid$ == 1)) {
	forward_tbl_201838();
}
	if((hdr.paxos.$valid$ == 1)) {
		round_tbl_201896();
	if(meta.local_metadata.round <= hdr.paxos.rnd) {
	acceptor_tbl_201777();
}

}
}

// Action
void NoAction_1_201477() {
	action_run = 201477;
	
}


// Action
void NoAction_6_201478() {
	action_run = 201478;
	
}


// Action
void NoAction_7_201479() {
	action_run = 201479;
	
}


// Action
void handle_1a_0_201532(uint32_t learner_port) {
	traverse_handle_1a = 1;
	action_run = 201532;
		hdr.paxos.msgtype = 1;
		uint64_t tmp_symbolic;
	klee_make_symbolic(&tmp_symbolic, sizeof(tmp_symbolic), "tmp_symbolic");
	hdr.paxos.vrnd = tmp_symbolic;

		uint64_t tmp_symbolic2;
	klee_make_symbolic(&tmp_symbolic2, sizeof(tmp_symbolic2), "tmp_symbolic2");
	hdr.paxos.paxosval = tmp_symbolic2;

		uint64_t tmp_symbolic3;
	klee_make_symbolic(&tmp_symbolic3, sizeof(tmp_symbolic3), "tmp_symbolic3");
	hdr.paxos.acptid = tmp_symbolic3;

	hdr.udp.dstPort = learner_port;
	hdr.udp.checksum = 0;

}


// Action
void handle_2a_0_201619(uint32_t learner_port) {
	traverse_handle_2a = 1;
	action_run = 201619;
		hdr.paxos.msgtype = 3;
		uint64_t tmp_symbolic;
	klee_make_symbolic(&tmp_symbolic, sizeof(tmp_symbolic), "tmp_symbolic");
	hdr.paxos.acptid = tmp_symbolic;

	hdr.udp.dstPort = learner_port;
	hdr.udp.checksum = 0;

}


// Action
void _drop_1_201706() {
	action_run = 201706;
		mark_to_drop();

}


// Action
void _drop_4_201722() {
	action_run = 201722;
		mark_to_drop();

}


// Action
void forward_0_201729(uint32_t port) {
	action_run = 201729;
		standard_metadata.egress_spec = port;

}


// Action
void read_round_0_201746() {
	action_run = 201746;
			uint64_t tmp_symbolic;
	klee_make_symbolic(&tmp_symbolic, sizeof(tmp_symbolic), "tmp_symbolic");
	meta.local_metadata.round = tmp_symbolic;

	meta.local_metadata.set_drop = 1;

}


//Table
void acceptor_tbl_201777() {
	if(hdr.paxos.msgtype == 0){
		handle_1a_0_201532(2);
	} else	if(hdr.paxos.msgtype == 2){
		handle_2a_0_201619(2);
	} else {
		_drop_4_201722();
	}
}


//Table
void forward_tbl_201838() {
	if(standard_metadata.ingress_port == 1){
		forward_0_201729(2);
	} else	if(standard_metadata.ingress_port == 2){
		forward_0_201729(1);
	}
}


//Table
void round_tbl_201896() {
	read_round_0_201746();
}



//Control

void DeparserImpl() {
	//Emit hdr.ethernet
	
	//Emit hdr.ipv6
	
	//Emit hdr.ipv4
	
	//Emit hdr.udp
	
	//Emit hdr.paxos
	
	//Emit hdr.arp
	
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

void verifyChecksum() {
	verify_checksum();
}


//Control

void computeChecksum() {
	update_checksum();
}


int main() {
	ParserImpl();
	ingress();
	egress();
	DeparserImpl();
	end_assertions();
	return 0;
}



