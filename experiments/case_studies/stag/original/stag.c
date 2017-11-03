#define BITSLICE(x, a, b) ((x) >> (b)) & ((1 << ((a)-(b)+1)) - 1)
#include<stdio.h>
#include<stdint.h>
#include<stdlib.h>

int assert_forward = 1;
int traverse_color_check = 0;
int action_run;


void accept();
void color_check_147424();
void drop_3_147068();
void local2core_0_147277();
void core2core_0_147353();
void NoAction_0_147040();
void start();
void ipv4_lpm_147124();
void reject();
void stag_forward_147369();
void ipv4_forward_0_147075();
void parse_ipv4_option();
void NoAction_6_147051();
void parse_ipv4();
void set_source_color_0_147179();
void place_holder_table_147555();
void get_source_color_147197();
void NoAction_7_147554();
void NoAction_1_147050();
void drop_0_147052();
void core2local_0_147245();
void parse_stag();

void end_assertions(){
	if(traverse_color_check == 1 && hdr.ipv4.dstAddr == 1 && hdr.ipv4.srcAddr == 0 && assert_forward == 1){
		printf("Assert error: src 0 sending packets to dst 1\n");
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

typedef uint32_t egressSpec_t;

typedef uint64_t macAddr_t;

typedef uint32_t ip4Addr_t;

typedef struct {
	uint8_t isValid : 1;
	macAddr_t dstAddr: 48;
	macAddr_t srcAddr: 48;
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
	ip4Addr_t srcAddr: 32;
	ip4Addr_t dstAddr: 32;
	uint8_t $valid$ : 1;
} ipv4_t;

typedef struct {
	uint8_t isValid : 1;
	uint8_t copyFlag : 1;
	uint8_t optClass : 2;
	uint8_t option : 5;
	uint8_t optionLength : 8;
	uint8_t $valid$ : 1;
} ipv4_option_t;

typedef struct {
	uint8_t isValid : 1;
	uint8_t source_color : 8;
	uint8_t $valid$ : 1;
} stag_t;

typedef struct {
	uint8_t isValid : 1;
	uint8_t src_port_color : 8;
	uint8_t dst_port_color : 8;
	uint8_t toLocal : 1;
	uint8_t $valid$ : 1;
} local_md_t;

typedef struct {
	local_md_t local_md;
} metadata;

typedef struct {
	ethernet_t ethernet;
	ipv4_t ipv4;
	ipv4_option_t ipv4_option;
	stag_t stag;
} headers;

headers hdr;
metadata meta;
standard_metadata_t standard_metadata;


void start() {
	//Extract hdr.ethernet
	hdr.ethernet.isValid = 1;
	if((hdr.ethernet.etherType == 2048)){
		parse_ipv4();
	} else {
		accept();
	}
}


void parse_ipv4() {
	//Extract hdr.ipv4
	hdr.ipv4.isValid = 1;
	if(hdr.ipv4.ihl >= 5) { mark_to_drop(); }
	if((hdr.ipv4.ihl == 5)){
		accept();
	} else {
		parse_ipv4_option();
	}
}


void parse_ipv4_option() {
	//Extract hdr.ipv4_option
	hdr.ipv4_option.isValid = 1;
	if((hdr.ipv4_option.option == 31)){
		parse_stag();
	} else {
		accept();
	}
}


void parse_stag() {
	//Extract hdr.stag
	hdr.stag.isValid = 1;
	meta.local_md.src_port_color = hdr.stag.source_color;
	accept();
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

void ingress() {
	if((hdr.stag.$valid$ != 1)) {
	get_source_color_147197();
}
	stag_forward_147369();
	if((meta.local_md.toLocal == 1)) {
	color_check_147424();
}
	if((hdr.ipv4.$valid$ == 1)) {
	ipv4_lpm_147124();
}
}

// Action
void NoAction_0_147040() {
	action_run = 147040;
	
}


// Action
void NoAction_1_147050() {
	action_run = 147050;
	
}


// Action
void NoAction_6_147051() {
	action_run = 147051;
	if(meta.local_md.dst_port_color != meta.local_md.src_port_color){
		printf("Assert error: ports of different colors communicating\n");
	}
}


// Action
void drop_0_147052() {
	action_run = 147052;
		mark_to_drop();

}


// Action
void drop_3_147068() {
	action_run = 147068;
	mark_to_drop();

}


// Action
void ipv4_forward_0_147075() {
	action_run = 147075;
	macAddr_t dstAddr;
	klee_make_symbolic(&dstAddr, sizeof(dstAddr), "dstAddr");
egressSpec_t port;
	klee_make_symbolic(&port, sizeof(port), "port");
	standard_metadata.egress_spec = port;
	hdr.ethernet.srcAddr = hdr.ethernet.dstAddr;
	hdr.ethernet.dstAddr = dstAddr;
	hdr.ipv4.ttl = hdr.ipv4.ttl + 255;

}


// Action
void set_source_color_0_147179() {
	action_run = 147179;
	uint8_t color;
	klee_make_symbolic(&color, sizeof(color), "color");
	meta.local_md.src_port_color = color;

}


// Action
void core2local_0_147245() {
	action_run = 147245;
	uint8_t color;
	klee_make_symbolic(&color, sizeof(color), "color");
	meta.local_md.dst_port_color = color;
	meta.local_md.toLocal = 1;
	hdr.stag.isValid = 0;

}


// Action
void local2core_0_147277() {
	action_run = 147277;
		hdr.ipv4_option.isValid = 1;
	hdr.ipv4_option.copyFlag = 1;
	hdr.ipv4_option.optClass = 2;
	hdr.ipv4_option.option = 31;
	hdr.ipv4_option.optionLength = 4;
	hdr.ipv4.ihl = hdr.ipv4.ihl + 1;
	hdr.stag.isValid = 1;
	hdr.stag.source_color = meta.local_md.src_port_color;
	meta.local_md.toLocal = 0;

}


// Action
void core2core_0_147353() {
	action_run = 147353;
		meta.local_md.toLocal = 0;

}


//Table
void ipv4_lpm_147124() {
	// keys: hdr.ipv4.dstAddr:lpm
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: ipv4_forward_0_147075(); break;
		case 1: drop_0_147052(); break;
		default: NoAction_0_147040(); break;
	}
	// size 1024
	// default_action NoAction_0();

}


//Table
void get_source_color_147197() {
	// keys: standard_metadata.ingress_port:exact
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: set_source_color_0_147179(); break;
		default: NoAction_1_147050(); break;
	}
	// default_action NoAction_1();

}


//Table
void stag_forward_147369() {
	// keys: hdr.ipv4.dstAddr:ternary
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: core2local_0_147245(); break;
		case 1: local2core_0_147277(); break;
		default: core2core_0_147353(); break;
	}
	// size 1024
	// default_action core2core_0();

}


//Table
void color_check_147424() {
	traverse_color_check = 1;
	// keys: meta.local_md.dst_port_color:exact, meta.local_md.src_port_color:exact
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: drop_3_147068(); break;
		default: NoAction_6_147051(); break;
	}
	// size 1024
	// default_action drop_3();

}



//Control

void egress() {
	place_holder_table_147555();
}

// Action
void NoAction_7_147554() {
	action_run = 147554;
	
}


//Table
void place_holder_table_147555() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		default: NoAction_7_147554(); break;
	}
	// size 2
	// default_action NoAction_7();

}



//Control

void computeChecksum() {
	
}


//Control

void verifyChecksum() {
	
}


//Control

void DeparserImpl() {
	//Emit hdr.ethernet
	
	//Emit hdr.ipv4
	
	//Emit hdr.ipv4_option
	
	//Emit hdr.stag
	
}


int main() {
	ParserImpl();
	ingress();
	egress();
	DeparserImpl();
	end_assertions();
	return 0;
}



