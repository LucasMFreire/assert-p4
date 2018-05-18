#include<stdio.h>
#include<stdint.h>
#include<stdlib.h>

void parse_swid();
void parse_mri();
void parse_ipv4();
void parse_ipv4_option();
void accept();
void ipv4_lpm_141857();
void tbl_add_mri_option_150190();
void swid_1_141825();
void tbl_act_150375();
void reject();

int action_run;
int added_switch_id = 0;
int extract_id[9] = {0};
int push_fronts = 0;

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
	exit(0);
}


typedef uint32_t egressSpec_t;

typedef uint64_t macAddr_t;

typedef uint32_t ip4Addr_t;

typedef uint32_t switchID_t;

switchID_t id_const;

typedef struct {
	uint8_t isValid : 1;
	macAddr_t dstAddr: 48;
	macAddr_t srcAddr: 48;
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
	ip4Addr_t srcAddr: 32;
	ip4Addr_t dstAddr: 32;
} ipv4_t;

typedef struct {
	uint8_t isValid : 1;
	uint8_t copyFlag : 1;
	uint8_t optClass : 2;
	uint8_t option : 5;
	uint8_t optionLength : 8;
} ipv4_option_t;

typedef struct {
	uint8_t isValid : 1;
	uint32_t count : 16;
} mri_t;

typedef struct {
	uint8_t isValid : 1;
	switchID_t swid: 32;
} switch_t;

typedef struct {
	uint32_t count : 16;
} ingress_metadata_t;

typedef struct {
	uint32_t remaining : 16;
} parser_metadata_t;

typedef struct {
	ingress_metadata_t ingress_metadata;
	parser_metadata_t parser_metadata;
} metadata;

typedef struct {
	ethernet_t ethernet;
	ipv4_t ipv4;
	ipv4_option_t ipv4_option;
	mri_t mri;
	int swids_index;
	switch_t swids[9];
} headers;

headers hdr;
metadata meta;
standard_metadata_t standard_metadata;

uint8_t tmp_7;
uint32_t tmp_8;

void start() {
	hdr.ethernet.isValid = 1;
	switch(hdr.ethernet.etherType){
		case 2048:	parse_ipv4(); break;
		default:	accept(); break;
	}
}


void parse_ipv4() {
	tmp_7 = hdr.ipv4.ihl >= 5;
	klee_assume(tmp_7);
   switch(hdr.ipv4.ihl){
		case 5:	accept(); break;
		default:	parse_ipv4_option(); break;
	}
}


void parse_ipv4_option() {
	hdr.ipv4_option.isValid = 1;
	switch(hdr.ipv4_option.option){
		case 31:	parse_mri(); break;
		default:	accept(); break;
	}
}


void parse_mri() {
	hdr.mri.isValid = 1;
	meta.parser_metadata.remaining = hdr.mri.count;
	switch(meta.parser_metadata.remaining){
		case 0:	accept(); break;
		default:	parse_swid(); break;
	}
}


void reject() {
	exit(0);
}

void parse_swid() {
  if (hdr.swids_index >= 9){
  	 reject();
  }
	hdr.swids[hdr.swids_index].isValid = 1;
	extract_id[hdr.swids_index] = 1;
	hdr.swids_index++;
	tmp_8 = meta.parser_metadata.remaining + 65535;
	meta.parser_metadata.remaining = tmp_8;
	switch(meta.parser_metadata.remaining){
		case 0:	accept(); break;
		default:	parse_swid(); break;
	}
}


void accept() {
	
}

void ParserImpl() {
	klee_make_symbolic(&hdr, sizeof(hdr), "hdr");
	klee_make_symbolic(&meta, sizeof(meta), "meta");
	klee_make_symbolic(&standard_metadata, sizeof(standard_metadata), "standard_metadata");

    hdr.swids_index = 0;
	start();
}

//Control

void verifyChecksum() {
	
}


//Control
uint8_t tmp_9;
uint32_t tmp_10;
uint8_t tmp_11;
uint8_t tmp_12;
uint8_t tmp_13;

void ingress() {
	if(hdr.ipv4.isValid) {
		ipv4_lpm_141857();
	if(!hdr.mri.isValid) {
	tbl_add_mri_option_150190();
}
	swid_1_141825();

}
}

// Action
void NoAction_0_141591() {
	action_run = 141591;
	
}


// Action
void NoAction_3_141601() {
	action_run = 141601;
	
}


// Action
void drop_0_141602() {
	action_run = 141602;
		mark_to_drop();

}


// Action
void add_mri_option_0_143531() {
	action_run = 143531;
	hdr.ipv4_option.isValid = 1;
	hdr.ipv4_option.copyFlag = 1;
	hdr.ipv4_option.optClass = 2;
	hdr.ipv4_option.option = 31;
	hdr.ipv4_option.optionLength = 4;
	hdr.mri.isValid = 1;
	hdr.mri.count = 0;
	tmp_9 = hdr.ipv4.ihl + 1;
	hdr.ipv4.ihl = hdr.ipv4.ihl + 1;

}

void push_front(int count) {
    int i;
    for (i = 8; i >= 0; i -= 1) {
        if (i >= count) {
            hdr.swids[i] = hdr.swids[i-count];
        } else {
            hdr.swids[i].isValid = 0;
        }
    }
    hdr.swids_index = hdr.swids_index + count;
    push_fronts += count;
    if (hdr.swids_index > 8) hdr.swids_index = 8;
    // Note: this.last, this.next, and this.lastIndex adjust with this.nextIndex
}

// Action
void add_swid_0_143681() {
	action_run = 143681;
	switchID_t id;
	klee_make_symbolic(&id, sizeof(id), "id");
	tmp_10 = hdr.mri.count + 1;
	hdr.mri.count = hdr.mri.count + 1;
	push_front(1);
	hdr.swids[0].swid = id;
	id_const = id;
	added_switch_id = 1;
	tmp_11 = hdr.ipv4.ihl + 1;
	hdr.ipv4.ihl = hdr.ipv4.ihl + 1;
	tmp_12 = hdr.ipv4_option.optionLength + 4;
	hdr.ipv4_option.optionLength = hdr.ipv4_option.optionLength + 4;

}

// Action
void ipv4_forward_0_143838() {
	action_run = 143838;
	macAddr_t dstAddr;
	klee_make_symbolic(&dstAddr, sizeof(dstAddr), "dstAddr");
egressSpec_t port;
	klee_make_symbolic(&port, sizeof(port), "port");
	standard_metadata.egress_spec = port;
	hdr.ethernet.srcAddr = hdr.ethernet.dstAddr;
	hdr.ethernet.dstAddr = dstAddr;
	tmp_13 = hdr.ipv4.ttl + 255;
	hdr.ipv4.ttl = hdr.ipv4.ttl + 255;

}


//Table
void swid_1_141825() {
	 NoAction_0_141591();
}


//Table
void ipv4_lpm_141857() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: ipv4_forward_0_143838(); break;
		case 1: drop_0_141602(); break;
		default: NoAction_3_141601(); break;
	}
	// size 1024
	// default_action NoAction_3();
}


//Table
void tbl_add_mri_option_150190() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		default: add_mri_option_0_143531(); break;
	}
	// default_action add_mri_option_0();
}



//Control

void egress() {
	
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
uint32_t tmp_14;

void computeChecksum() {
	if(hdr.ipv4.isValid) {
	klee_make_symbolic(&tmp_14, sizeof(tmp_14), "tmp_14");

	tbl_act_150375();

}
}

// Action
void act_148943() {
	action_run = 148943;
		hdr.ipv4.hdrChecksum = tmp_14;

}


//Table
void tbl_act_150375() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		default: act_148943(); break;
	}
	// default_action act();
}



//Control

void DeparserImpl() {
 
	//Emit hdr.ethernet
	
	//Emit hdr.ipv4
	
	//Emit hdr.ipv4_option
	
	//Emit hdr.mri
	
	//Emit hdr.swids
	if(added_switch_id && id_const != hdr.swids[0].swid){
		klee_print_once(0, "Assert error: const(switchid)");
	}

	int i;
	for(i = 0; i < 9; i++){
	  if(extract_id[i] == 1 && !(hdr.swids[i+push_fronts].isValid == 1)){
		klee_print_once(1, "switch id removed");
	 }
	}
	
}

int main() {
	ParserImpl();
	ingress();
	egress();
	DeparserImpl();
	return 0;
}


