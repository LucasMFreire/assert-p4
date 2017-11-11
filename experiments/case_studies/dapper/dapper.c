#define BITSLICE(x, a, b) ((x) >> (b)) & ((1 << ((a)-(b)+1)) - 1)
#include<stdio.h>
#include<stdint.h>
#include<stdlib.h>

int action_run;

void first_rtt_sample_456584();
void NoAction_31_454654();
void set_nhop_0_456119();
void NoAction_22_454645();
void update_flow_retx_3dupack_0_464483();
void update_flow_dupack_0_464299();
void sample_rtt_rcvd_457042();
void flow_sent_456754();
void accept();
void flow_retx_3dupack_456686();
void get_sender_IP_0_464021();
void NoAction_29_454652();
void set_dmac_0_455955();
void update_flow_sent_0_464722();
void update_flow_retx_timeout_0_464622();
void NoAction_23_454646();
void NoAction_30_454653();
void parse_ethernet();
void parse_sack();
void use_sample_rtt_0_465264();
void direction_456550();
void parse_tcp();
void debug_456516();
void NoAction_21_454644();
void lookup_flow_map_0_456155();
void NoAction_32_454655();
void record_IP_0_465009();
void increase_mincwnd_0_455996();
void start();
void flow_rcvd_456652();
void NoAction_1_454641();
void reject();
void rewrite_mac_0_454473();
void NoAction_19_454642();
void NoAction_26_454649();
void flow_dupack_456618();
void parse_mss();
void parse_ts();
void sample_rtt_sent_457076();
void save_source_IP_0_454943();
void increase_cwnd_456847();
void parse_end();
void sample_new_rtt_0_456473();
void NoAction_25_454648();
void forward_456788();
void NoAction_0_454463();
void ipv4_lpm_456915();
void send_frame_454507();
void parse_ipv4();
void NoAction_27_454650();
void lookup_reverse_457008();
void lookup_456974();
void NoAction_28_454651();
void NoAction_24_454647();
void lookup_flow_map_reverse_0_456217();
void update_flow_rcvd_0_464360();
void _drop_1_455973();
void use_sample_rtt_first_0_464199();
void _drop_0_454491();
void parse_tcp_options();
void parse_nop();
void parse_wscale();
void _drop_4_455989();
void NoAction_33_454656();
void init_456881();
void NoAction_20_454643();
void flow_retx_timeout_456720();

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
	uint64_t ingress_global_timestamp : 48;
	uint32_t lf_field_list : 32;
	uint32_t mcast_grp : 16;
	uint32_t egress_rid : 16;
} intrinsic_metadata_t;

typedef struct {
	uint8_t parse_tcp_options_counter : 8;
} my_metadata_t;

typedef struct {
	uint32_t nhop_ipv4 : 32;
} routing_metadata_t;

typedef struct {
	uint32_t dummy : 32;
	uint32_t dummy2 : 32;
	uint8_t flow_map_index : 2;
	uint32_t senderIP : 32;
	uint32_t seqNo : 32;
	uint32_t ackNo : 32;
	uint32_t sample_rtt_seq : 32;
	uint32_t rtt_samples : 32;
	uint32_t mincwnd : 32;
	uint32_t dupack : 32;
} stats_metadata_t;

typedef struct {
	uint8_t isValid : 1;
	uint64_t dstAddr : 48;
	uint64_t srcAddr : 48;
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
	uint32_t srcAddr : 32;
	uint32_t dstAddr : 32;
	uint8_t $valid$ : 1;
} ipv4_t;

typedef struct {
	uint8_t isValid : 1;
	uint8_t kind : 8;
	uint8_t $valid$ : 1;
} options_end_t;

typedef struct {
	uint8_t isValid : 1;
	uint8_t kind : 8;
	uint8_t len : 8;
	uint32_t MSS : 16;
	uint8_t $valid$ : 1;
} options_mss_t;

typedef struct {
	uint8_t isValid : 1;
	uint8_t kind : 8;
	uint8_t len : 8;
	uint8_t $valid$ : 1;
} options_sack_t;

typedef struct {
	uint8_t isValid : 1;
	uint8_t kind : 8;
	uint8_t len : 8;
	uint64_t ttee : 64;
	uint8_t $valid$ : 1;
} options_ts_t;

typedef struct {
	uint8_t isValid : 1;
	uint8_t kind : 8;
	uint8_t len : 8;
	uint8_t wscale : 8;
	uint8_t $valid$ : 1;
} options_wscale_t;

typedef struct {
	uint8_t isValid : 1;
	uint32_t srcPort : 16;
	uint32_t dstPort : 16;
	uint32_t seqNo : 32;
	uint32_t ackNo : 32;
	uint8_t dataOffset : 4;
	uint8_t res : 3;
	uint8_t ecn : 3;
	uint8_t urg : 1;
	uint8_t ack : 1;
	uint8_t push : 1;
	uint8_t rst : 1;
	uint8_t syn : 1;
	uint8_t fin : 1;
	uint32_t window : 16;
	uint32_t checksum : 16;
	uint32_t urgentPtr : 16;
	uint8_t $valid$ : 1;
} tcp_t;

typedef struct {
	uint8_t isValid : 1;
	uint8_t kind : 8;
	uint8_t $valid$ : 1;
} options_nop_t;

typedef struct {
	intrinsic_metadata_t intrinsic_metadata;
	my_metadata_t my_metadata;
	routing_metadata_t routing_metadata;
	stats_metadata_t stats_metadata;
} metadata;

typedef struct {
	ethernet_t ethernet;
	ipv4_t ipv4;
	options_end_t options_end;
	options_mss_t options_mss;
	options_sack_t options_sack;
	options_ts_t options_ts;
	options_wscale_t options_wscale;
	tcp_t tcp;
	int options_nop_index;
	options_nop_t options_nop[3];
} headers;

headers hdr;
metadata meta;
standard_metadata_t standard_metadata;

uint8_t tmp_45;

void parse_end() {
	hdr.options_end.isValid = 1;
	meta.my_metadata.parse_tcp_options_counter = meta.my_metadata.parse_tcp_options_counter + 255;
	parse_tcp_options();
}


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
		default:	accept(); break;
	}
}


void parse_mss() {
	hdr.options_mss.isValid = 1;
	meta.my_metadata.parse_tcp_options_counter = meta.my_metadata.parse_tcp_options_counter + 252;
	parse_tcp_options();
}


void parse_nop() {
	hdr.options_nop[hdr.options_nop_index].isValid = 1;
	hdr.options_nop_index++;
	meta.my_metadata.parse_tcp_options_counter = meta.my_metadata.parse_tcp_options_counter + 255;
	parse_tcp_options();
}


void parse_sack() {
	hdr.options_sack.isValid = 1;
	meta.my_metadata.parse_tcp_options_counter = meta.my_metadata.parse_tcp_options_counter + 254;
	parse_tcp_options();
}


void parse_tcp() {
	hdr.tcp.isValid = 1;
	meta.my_metadata.parse_tcp_options_counter = (uint8_t) hdr.tcp.dataOffset << 2 + 12;
	switch(hdr.tcp.syn){
		case 1:	parse_tcp_options(); break;
		default:	accept(); break;
	}
}


void parse_tcp_options() {
		klee_make_symbolic(&tmp_45, sizeof(tmp_45), "tmp_45");

	if(((meta.my_metadata.parse_tcp_options_counter & 255) == (0 & 255)) && ((BITSLICE(tmp_45, 7, 0) & 0) == (0 & 0))) {
		accept();
	} else if(((meta.my_metadata.parse_tcp_options_counter & 0) == (0 & 0)) && ((BITSLICE(tmp_45, 7, 0) & 255) == (0 & 255))) {
		parse_end();
	} else if(((meta.my_metadata.parse_tcp_options_counter & 0) == (0 & 0)) && ((BITSLICE(tmp_45, 7, 0) & 255) == (1 & 255))) {
		parse_nop();
	} else if(((meta.my_metadata.parse_tcp_options_counter & 0) == (0 & 0)) && ((BITSLICE(tmp_45, 7, 0) & 255) == (2 & 255))) {
		parse_mss();
	} else if(((meta.my_metadata.parse_tcp_options_counter & 0) == (0 & 0)) && ((BITSLICE(tmp_45, 7, 0) & 255) == (3 & 255))) {
		parse_wscale();
	} else if(((meta.my_metadata.parse_tcp_options_counter & 0) == (0 & 0)) && ((BITSLICE(tmp_45, 7, 0) & 255) == (4 & 255))) {
		parse_sack();
	} else if(((meta.my_metadata.parse_tcp_options_counter & 0) == (0 & 0)) && ((BITSLICE(tmp_45, 7, 0) & 255) == (8 & 255))) {
		parse_ts();
	}
}


void parse_ts() {
	hdr.options_ts.isValid = 1;
	meta.my_metadata.parse_tcp_options_counter = meta.my_metadata.parse_tcp_options_counter + 246;
	parse_tcp_options();
}


void parse_wscale() {
	hdr.options_wscale.isValid = 1;
	meta.my_metadata.parse_tcp_options_counter = meta.my_metadata.parse_tcp_options_counter + 253;
	parse_tcp_options();
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

void egress() {
	send_frame_454507();
}

// Action
void NoAction_0_454463() {
	action_run = 454463;
	
}


// Action
void rewrite_mac_0_454473() {
	action_run = 454473;
	uint64_t smac;
	klee_make_symbolic(&smac, sizeof(smac), "smac");
	hdr.ethernet.srcAddr = smac;

}


// Action
void _drop_0_454491() {
	action_run = 454491;
		mark_to_drop();

}


//Table
void send_frame_454507() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: rewrite_mac_0_454473(); break;
		case 1: _drop_0_454491(); break;
		default: NoAction_0_454463(); break;
	}
	// keys: standard_metadata.egress_port:exact
	// size 256
	// default_action NoAction_0();

}



typedef struct {
	uint32_t field : 32;
	uint32_t field_0 : 32;
	uint8_t field_1 : 8;
	uint32_t field_2 : 16;
	uint32_t field_3 : 16;
} tuple_0;

//Control
uint32_t tmp_46;
uint32_t tmp_48;
uint32_t tmp_50;
uint32_t tmp_52;
uint32_t tmp_54;
uint32_t tmp_56;
uint32_t tmp_58;
uint32_t tmp_60;
uint32_t tmp_62;
uint32_t tmp_64;
uint32_t tmp_66;
uint32_t tmp_68;
uint32_t tmp_70;
uint32_t tmp_72;
uint32_t tmp_74;
uint32_t tmp_76;
uint32_t tmp_78;
uint32_t tmp_80;
uint32_t tmp_82;
uint32_t tmp_84;
uint32_t tmp_86;

void ingress() {
	if((hdr.ipv4.protocol == 6)) {
		if(hdr.ipv4.srcAddr > hdr.ipv4.dstAddr) {
	lookup_456974();
} else {
	lookup_reverse_457008();
}
	if((hdr.tcp.syn == 1) && (hdr.tcp.ack == 0)) {
	init_456881();
} else {
	direction_456550();
}
	if((hdr.ipv4.srcAddr == meta.stats_metadata.senderIP)) {
	if(hdr.tcp.seqNo > meta.stats_metadata.seqNo) {
		flow_sent_456754();
	if((meta.stats_metadata.sample_rtt_seq == 0)) {
	sample_rtt_sent_457076();
}
	if(meta.stats_metadata.dummy > meta.stats_metadata.mincwnd) {
	increase_cwnd_456847();
}

} else {
	if((meta.stats_metadata.dupack == 3)) {
	flow_retx_3dupack_456686();
} else {
	flow_retx_timeout_456720();
}
}
} else {
	if((hdr.ipv4.dstAddr == meta.stats_metadata.senderIP)) {
	if(hdr.tcp.ackNo > meta.stats_metadata.ackNo) {
		flow_rcvd_456652();
	if(hdr.tcp.ackNo >= meta.stats_metadata.sample_rtt_seq && meta.stats_metadata.sample_rtt_seq > 0) {
	if((meta.stats_metadata.rtt_samples == 0)) {
	first_rtt_sample_456584();
} else {
	sample_rtt_rcvd_457042();
}
}

} else {
	flow_dupack_456618();
}
} else {
	debug_456516();
}
}

}
	ipv4_lpm_456915();
	forward_456788();
}

// Action
void NoAction_1_454641() {
	action_run = 454641;
	
}


// Action
void NoAction_19_454642() {
	action_run = 454642;
	
}


// Action
void NoAction_20_454643() {
	action_run = 454643;
	
}


// Action
void NoAction_21_454644() {
	action_run = 454644;
	
}


// Action
void NoAction_22_454645() {
	action_run = 454645;
	
}


// Action
void NoAction_23_454646() {
	action_run = 454646;
	
}


// Action
void NoAction_24_454647() {
	action_run = 454647;
	
}


// Action
void NoAction_25_454648() {
	action_run = 454648;
	
}


// Action
void NoAction_26_454649() {
	action_run = 454649;
	
}


// Action
void NoAction_27_454650() {
	action_run = 454650;
	
}


// Action
void NoAction_28_454651() {
	action_run = 454651;
	
}


// Action
void NoAction_29_454652() {
	action_run = 454652;
	
}


// Action
void NoAction_30_454653() {
	action_run = 454653;
	
}


// Action
void NoAction_31_454654() {
	action_run = 454654;
	
}


// Action
void NoAction_32_454655() {
	action_run = 454655;
	
}


// Action
void NoAction_33_454656() {
	action_run = 454656;
	
}


// Action
void save_source_IP_0_454943() {
	action_run = 454943;
	
}


// Action
void get_sender_IP_0_464021() {
	action_run = 464021;
			klee_make_symbolic(&tmp_46, sizeof(tmp_46), "tmp_46");

	meta.stats_metadata.senderIP = tmp_46;
		klee_make_symbolic(&tmp_48, sizeof(tmp_48), "tmp_48");

	meta.stats_metadata.seqNo = tmp_48;
		klee_make_symbolic(&tmp_50, sizeof(tmp_50), "tmp_50");

	meta.stats_metadata.ackNo = tmp_50;
		klee_make_symbolic(&tmp_52, sizeof(tmp_52), "tmp_52");

	meta.stats_metadata.sample_rtt_seq = tmp_52;
		klee_make_symbolic(&tmp_54, sizeof(tmp_54), "tmp_54");

	meta.stats_metadata.rtt_samples = tmp_54;
		klee_make_symbolic(&tmp_56, sizeof(tmp_56), "tmp_56");

	meta.stats_metadata.mincwnd = tmp_56;
		klee_make_symbolic(&tmp_58, sizeof(tmp_58), "tmp_58");

	meta.stats_metadata.dupack = tmp_58;

}


// Action
void use_sample_rtt_first_0_464199() {
	action_run = 464199;
			klee_make_symbolic(&tmp_60, sizeof(tmp_60), "tmp_60");

	meta.stats_metadata.dummy = tmp_60;
	meta.stats_metadata.dummy2 = (uint32_t) meta.intrinsic_metadata.ingress_global_timestamp;
	meta.stats_metadata.dummy2 = meta.stats_metadata.dummy2 - meta.stats_metadata.dummy;

}


// Action
void update_flow_dupack_0_464299() {
	action_run = 464299;
			klee_make_symbolic(&tmp_62, sizeof(tmp_62), "tmp_62");

	meta.stats_metadata.dummy = tmp_62;
	meta.stats_metadata.dummy = meta.stats_metadata.dummy + 1;
}


// Action
void update_flow_rcvd_0_464360() {
	action_run = 464360;
			klee_make_symbolic(&tmp_64, sizeof(tmp_64), "tmp_64");

	meta.stats_metadata.dummy = tmp_64;
	meta.stats_metadata.dummy = meta.stats_metadata.dummy + 1;

}


// Action
void update_flow_retx_3dupack_0_464483() {
	action_run = 464483;
			klee_make_symbolic(&tmp_66, sizeof(tmp_66), "tmp_66");

	meta.stats_metadata.dummy = tmp_66;
	meta.stats_metadata.dummy = meta.stats_metadata.dummy + 1;
		klee_make_symbolic(&tmp_68, sizeof(tmp_68), "tmp_68");

	meta.stats_metadata.dummy = tmp_68;
	meta.stats_metadata.dummy = meta.stats_metadata.dummy >> 1;

}


// Action
void update_flow_retx_timeout_0_464622() {
	action_run = 464622;
			klee_make_symbolic(&tmp_70, sizeof(tmp_70), "tmp_70");

	meta.stats_metadata.dummy = tmp_70;
	meta.stats_metadata.dummy = meta.stats_metadata.dummy + 1;

}


// Action
void update_flow_sent_0_464722() {
	action_run = 464722;
			klee_make_symbolic(&tmp_72, sizeof(tmp_72), "tmp_72");

	meta.stats_metadata.dummy = tmp_72;
	meta.stats_metadata.dummy = meta.stats_metadata.dummy + 1;
	meta.stats_metadata.dummy = (uint32_t) meta.intrinsic_metadata.ingress_global_timestamp;
		klee_make_symbolic(&tmp_74, sizeof(tmp_74), "tmp_74");

	meta.stats_metadata.dummy2 = tmp_74;
	meta.stats_metadata.dummy = meta.stats_metadata.dummy - meta.stats_metadata.dummy2;
		klee_make_symbolic(&tmp_76, sizeof(tmp_76), "tmp_76");

	meta.stats_metadata.dummy = tmp_76;
		klee_make_symbolic(&tmp_78, sizeof(tmp_78), "tmp_78");

	meta.stats_metadata.dummy2 = tmp_78;
	meta.stats_metadata.dummy = meta.stats_metadata.dummy - meta.stats_metadata.dummy2;

}


// Action
void set_dmac_0_455955() {
	action_run = 455955;
	uint64_t dmac;
	klee_make_symbolic(&dmac, sizeof(dmac), "dmac");
	hdr.ethernet.dstAddr = dmac;

}


// Action
void _drop_1_455973() {
	action_run = 455973;
		mark_to_drop();

}


// Action
void _drop_4_455989() {
	action_run = 455989;
		mark_to_drop();

}


// Action
void increase_mincwnd_0_455996() {
	action_run = 455996;
	
}


// Action
void record_IP_0_465009() {
	action_run = 465009;
			klee_make_symbolic(&tmp_80, sizeof(tmp_80), "tmp_80");

	meta.stats_metadata.senderIP = tmp_80;

}


// Action
void set_nhop_0_456119() {
	action_run = 456119;
	uint32_t nhop_ipv4;
	klee_make_symbolic(&nhop_ipv4, sizeof(nhop_ipv4), "nhop_ipv4");
uint32_t port;
	klee_make_symbolic(&port, sizeof(port), "port");
	meta.routing_metadata.nhop_ipv4 = nhop_ipv4;
	standard_metadata.egress_spec = port;
	hdr.ipv4.ttl = hdr.ipv4.ttl + 255;

}


// Action
void lookup_flow_map_0_456155() {
	action_run = 456155;

}


// Action
void lookup_flow_map_reverse_0_456217() {
	action_run = 456217;
}


// Action
void use_sample_rtt_0_465264() {
	action_run = 465264;
			klee_make_symbolic(&tmp_82, sizeof(tmp_82), "tmp_82");

	meta.stats_metadata.dummy = tmp_82;
	meta.stats_metadata.dummy2 = (uint32_t) meta.intrinsic_metadata.ingress_global_timestamp;
	meta.stats_metadata.dummy2 = meta.stats_metadata.dummy2 - meta.stats_metadata.dummy;
		klee_make_symbolic(&tmp_84, sizeof(tmp_84), "tmp_84");

	meta.stats_metadata.dummy = tmp_84;
	meta.stats_metadata.dummy = 7 * meta.stats_metadata.dummy + meta.stats_metadata.dummy2;
	meta.stats_metadata.dummy = meta.stats_metadata.dummy >> 3;
		klee_make_symbolic(&tmp_86, sizeof(tmp_86), "tmp_86");

	meta.stats_metadata.dummy = tmp_86;
	meta.stats_metadata.dummy = meta.stats_metadata.dummy + 1;

}


// Action
void sample_new_rtt_0_456473() {
	action_run = 456473;
	
}


//Table
void debug_456516() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: save_source_IP_0_454943(); break;
		default: NoAction_1_454641(); break;
	}
	// default_action NoAction_1();

}


//Table
void direction_456550() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: get_sender_IP_0_464021(); break;
		default: NoAction_19_454642(); break;
	}
	// default_action NoAction_19();

}


//Table
void first_rtt_sample_456584() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: use_sample_rtt_first_0_464199(); break;
		default: NoAction_20_454643(); break;
	}
	// default_action NoAction_20();

}


//Table
void flow_dupack_456618() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: update_flow_dupack_0_464299(); break;
		default: NoAction_21_454644(); break;
	}
	// default_action NoAction_21();

}


//Table
void flow_rcvd_456652() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: update_flow_rcvd_0_464360(); break;
		default: NoAction_22_454645(); break;
	}
	// default_action NoAction_22();

}


//Table
void flow_retx_3dupack_456686() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: update_flow_retx_3dupack_0_464483(); break;
		default: NoAction_23_454646(); break;
	}
	// default_action NoAction_23();

}


//Table
void flow_retx_timeout_456720() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: update_flow_retx_timeout_0_464622(); break;
		default: NoAction_24_454647(); break;
	}
	// default_action NoAction_24();

}


//Table
void flow_sent_456754() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: update_flow_sent_0_464722(); break;
		default: NoAction_25_454648(); break;
	}
	// default_action NoAction_25();

}


//Table
void forward_456788() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: set_dmac_0_455955(); break;
		case 1: _drop_1_455973(); break;
		default: NoAction_26_454649(); break;
	}
	// keys: meta.routing_metadata.nhop_ipv4:exact
	// size 512
	// default_action NoAction_26();

}


//Table
void increase_cwnd_456847() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: increase_mincwnd_0_455996(); break;
		default: NoAction_27_454650(); break;
	}
	// default_action NoAction_27();

}


//Table
void init_456881() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: record_IP_0_465009(); break;
		default: NoAction_28_454651(); break;
	}
	// default_action NoAction_28();

}


//Table
void ipv4_lpm_456915() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: set_nhop_0_456119(); break;
		case 1: _drop_4_455989(); break;
		default: NoAction_29_454652(); break;
	}
	// keys: hdr.ipv4.dstAddr:lpm
	// size 1024
	// default_action NoAction_29();

}


//Table
void lookup_456974() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: lookup_flow_map_0_456155(); break;
		default: NoAction_30_454653(); break;
	}
	// default_action NoAction_30();

}


//Table
void lookup_reverse_457008() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: lookup_flow_map_reverse_0_456217(); break;
		default: NoAction_31_454654(); break;
	}
	// default_action NoAction_31();

}


//Table
void sample_rtt_rcvd_457042() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: use_sample_rtt_0_465264(); break;
		default: NoAction_32_454655(); break;
	}
	// default_action NoAction_32();

}


//Table
void sample_rtt_sent_457076() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: sample_new_rtt_0_456473(); break;
		default: NoAction_33_454656(); break;
	}
	// default_action NoAction_33();

}



//Control

void DeparserImpl() {
	//Emit hdr.ethernet
	
	//Emit hdr.ipv4
	
	//Emit hdr.tcp
	
	//Emit hdr.options_end
	
	//Emit hdr.options_nop_0
	
	//Emit hdr.options_nop_1
	
	//Emit hdr.options_nop_2
	
	//Emit hdr.options_mss
	
	//Emit hdr.options_wscale
	
	//Emit hdr.options_sack
	
	//Emit hdr.options_ts
	
}


typedef struct {
	uint8_t field_4 : 4;
	uint8_t field_5 : 4;
	uint8_t field_6 : 8;
	uint32_t field_7 : 16;
	uint32_t field_8 : 16;
	uint8_t field_9 : 3;
	uint32_t field_10 : 13;
	uint8_t field_11 : 8;
	uint8_t field_12 : 8;
	uint32_t field_13 : 32;
	uint32_t field_14 : 32;
} tuple_1;

//Control
uint32_t tmp_88;

void verifyChecksum() {
		klee_make_symbolic(&tmp_88, sizeof(tmp_88), "tmp_88");

	if((hdr.ipv4.hdrChecksum == tmp_88)) {
	mark_to_drop();
}
}


//Control
uint32_t tmp_90;

void computeChecksum() {
		klee_make_symbolic(&tmp_90, sizeof(tmp_90), "tmp_90");

	hdr.ipv4.hdrChecksum = tmp_90;
}


int main() {
	ParserImpl();
	ingress();
	egress();
	DeparserImpl();
	return 0;
}


