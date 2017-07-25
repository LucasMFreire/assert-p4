#include<stdio.h>
#include<stdint.h>
#include<stdlib.h>

int traverse_egress_acl = 0;
int traverse_mirror_acl = 0;
int traverse_mac_acl = 0;
int traverse_ip_acl = 0;
int traverse_ip_racl = 0;
int traverse_system_acl = 0;

int action_run;

void mac_acl_1210156();
void egress_bd_map_1206069();
void parse_inner_icmpv6();
void set_acl_redirect_action_0_1207453();
void cpu_rewrite_1205994();
void redirect_to_cpu_0_1208153();
void nop_33_1207216();
void set_malformed_packet_0_1208656();
void set_src_vtep_miss_flag_0_1207838();
void NoAction_45_1203156();
void racl_log_0_1207625();
void nop_38_1207221();
void fib_hit_ecmp_0_1207778();
void port_vlan_mapping_1210606();
void nop_39_1207222();
void parse_inner_udp();
void NoAction_40_1203151();
void parse_ethernet();
void nop_34_1207217();
void NoAction_46_1203157();
void dmac_miss_0_1207281();
void parse_tcp();
void set_ipv4_erspan_v2_rewrite_0_1203672();
void dmac_redirect_nexthop_0_1207300();
void nop_37_1207220();
void parse_nsh();
void ip_acl_1209208();
void rmac_1210731();
void validate_outer_ethernet_1211283();
void parse_roce_v2();
void decapsulate_nvgre_packet_inner_ipv4_udp_0_1204110();
void nexthop_1210418();
void on_miss_4_1207735();
void drop_packet_0_1208195();
void set_ecmp_nexthop_details_0_1207348();
void fib_hit_ecmp_2_1207802();
void tunnel_rewrite_1206730();
void set_l2_multicast_0_1208624();
void bd_1_1208666();
void terminate_tunnel_inner_ipv4_0_1208217();
void tunnel_src_rewrite_1206861();
void set_cpu_tx_rewrite_0_1203177();
void replica_from_rid_0_1203734();
void learn_notify_1210073();
void NoAction_43_1203154();
void validate_packet_1211455();
void set_outer_rmac_hit_flag_0_1207979();
void ipv4_fib_lpm_1209753();
void outer_rmac_1210483();
void set_valid_outer_ipv4_packet_0_1208544();
void nop_25_1203173();
void NoAction_49_1203160();
void parse_erspan_v1();
void decapsulate_vxlan_packet_inner_ipv4_udp_0_1203758();
void NoAction_65_1207096();
void rewrite_unicast_mac_0_1203347();
void NoAction_59_1207090();
void ipv4_genv_inner_ipv4_tcp_rewrite_0_1205078();
void on_miss_1_1207725();
void nop_30_1207213();
void rewrite_tunnel_ipv4_dst_0_1204294();
void set_egress_packet_vlan_untagged_0_1203326();
void egress_drop_0_1203268();
void smac_hit_0_1228079();
void set_rmac_hit_flag_0_1208071();
void rewrite_tunnel_ipv4_src_0_1205976();
void on_miss_0_1203258();
void rid_1206499();
void rewrite_multicast_mac_0_1298178();
void ipv4_erspan_v2_inner_ipv4_udp_rewrite_0_1205664();
void set_valid_outer_broadcast_packet_0_1208501();
void acl_deny_2_1209106();
void validate_outer_ipv4_packet_1211348();
void outer_mac_1206333();
void set_l2_rewrite_0_1203429();
void NoAction_55_1207086();
void dmac_hit_0_1207227();
void set_l2_redirect_action_0_1207416();
void NoAction_75_1207106();
void rewrite_1206410();
void ipv4_dest_vtep_1209581();
void set_egress_bd_properties_0_1203240();
void parse_cpu_header();
void decapsulate_vxlan_packet_inner_ipv4_tcp_0_1203838();
void nop_41_1207224();
void set_stp_state_0_1208135();
void nop_36_1207219();
void nop_42_1207225();
void ipv4_nvgre_inner_ipv4_udp_rewrite_0_1205332();
void racl_redirect_nexthop_0_1207661();
void egress_vlan_xlate_1206257();
void nop_31_1207214();
void set_racl_redirect_action_0_1207481();
void set_malformed_outer_ipv4_packet_0_1208614();
void nop_28_1203176();
void set_fib_redirect_action_0_1207535();
void NoAction_74_1207105();
void parse_ipv6();
void parse_ipv4();
void egress_system_acl_1206198();
void parse_inner_icmp();
void NoAction_73_1207104();
void parse_inner_tcp();
void parse_udp();
void NoAction_69_1207100();
void NoAction_60_1207091();
void NoAction_47_1203158();
void decapsulate_geneve_packet_inner_ipv4_tcp_0_1204014();
void NoAction_44_1203155();
void racl_deny_0_1207635();
void dmac_multicast_hit_0_1207254();
void nop_35_1207218();
void NoAction_67_1207098();
void set_ecmp_nexthop_details_for_post_routed_flood_0_1207382();
void NoAction_68_1207099();
void set_ipv4_geneve_rewrite_0_1203548();
void lag_group_1209901();
void set_ipv4_unicast_rewrite_0_1203445();
void set_valid_outer_multicast_packet_0_1208458();
void NoAction_62_1207093();
void system_acl_1210944();
void nop_32_1207215();
void set_bd_0_1208021();
void NoAction_64_1207095();
void acl_log_2_1209089();
void parse_snap_header();
void acl_redirect_nexthop_1209146();
void nop_40_1207223();
void set_tunnel_termination_flag_0_1207709();
void parse_roce();
void nop_29_1207203();
void acl_permit_1_1207615();
void mirror_acl_1210275();
void set_cpu_rx_rewrite_0_1203204();
void fwd_result_1208959();
void nop_2_1203171();
void nop_26_1203174();
void NoAction_1_1203150();
void ipv4_vxlan_inner_ipv4_tcp_rewrite_0_1204571();
void start();
void NoAction_51_1207082();
void tunnel_1211206();
void NoAction_72_1207103();
void ipv4_erspan_v2_inner_ipv4_tcp_rewrite_0_1205823();
void ip_racl_1209438();
void nop_1_1203161();
void fib_hit_nexthop_0_1207736();
void set_tunnel_lif_0_1207820();
void NoAction_48_1203159();
void tunnel_decap_1206558();
void parse_vxlan();
void ipv4_nvgre_inner_ipv4_tcp_rewrite_0_1205502();
void parse_inner_ethernet();
void generate_learn_notify_0_1207871();
void parse_gre();
void acl_deny_1_1207599();
void copy_to_cpu_0_1208174();
void set_lag_port_0_1207854();
void nop_27_1203175();
void set_ipv4_nvgre_rewrite_0_1203610();
void set_egress_packet_vlan_tagged_0_1203294();
void NoAction_54_1207085();
void parse_vlan();
void ipv4_src_vtep_1209824();
void acl_permit_2_1209129();
void parse_geneve();
void parse_erspan_v2();
void NoAction_58_1207089();
void set_ipv4_vxlan_rewrite_0_1203486();
void acl_redirect_ecmp_1209177();
void parse_nvgre();
void parse_genv_inner();
void parse_icmp();
void parse_arp_rarp_ipv4();
void NoAction_56_1207087();
void ipv4_genv_inner_ipv4_udp_rewrite_0_1204809();
void tunnel_dst_rewrite_1206677();
void nop_43_1207226();
void egress_redirect_to_cpu_0_1203284();
void acl_log_1_1207589();
void accept();
void NoAction_41_1203152();
void nop_44_1209072();
void racl_permit_0_1207651();
void NoAction_52_1207083();
void set_nexthop_details_0_1207927();
void parse_icmpv6();
void NoAction_50_1207081();
void decapsulate_geneve_packet_inner_ipv4_udp_0_1203934();
void dmac_redirect_ecmp_0_1207324();
void set_valid_outer_unicast_packet_0_1208415();
void parse_fcoe();
void NoAction_53_1207084();
void NoAction_42_1203153();
void dmac_1_1208719();
void reject();
void parse_inner_ipv6();
void parse_inner_ipv4();
void racl_redirect_ecmp_0_1207685();
void set_ifindex_0_1207995();
void ipv4_fib_1209676();
void fib_hit_nexthop_2_1207760();
void ecmp_group_1208817();
void egress_block_1206128();
void NoAction_70_1207101();
void nop_3_1203172();
void set_src_is_link_local_0_1208640();
void NoAction_57_1207088();
void decapsulate_nvgre_packet_inner_ipv4_tcp_0_1204198();
void NoAction_61_1207092();
void NoAction_66_1207097();
void ipv4_vxlan_inner_ipv4_udp_rewrite_0_1204312();
void set_mirror_id_0_1207904();
void set_nexthop_details_for_post_routed_flood_0_1207953();
void NoAction_63_1207094();
void port_mapping_1210554();
void smac_miss_0_1208087();
void set_bd_info_0_1207121();
void NoAction_0_1203140();
void NoAction_71_1207102();
void spanning_tree_1210879();
void parse_arp_rarp();
void smac_1_1210802();
void endAssertions();
void clone();
void ingress();

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
	endAssertions();
}

typedef struct {
	uint32_t smac_idx : 9;
	uint32_t bd : 16;
	uint8_t replica : 1;
	uint32_t vnid : 24;
	uint64_t mac_da : 48;
	uint8_t routed : 1;
	uint8_t mtu_check_fail : 1;
	uint8_t tunnel_type : 4;
	uint32_t tunnel_src_index : 9;
	uint32_t tunnel_dst_index : 14;
	uint8_t drop_reason : 8;
	uint8_t egress_bypass : 1;
} egress_metadata_t;

typedef struct {
	uint8_t lkp_pkt_type : 3;
	uint64_t lkp_mac_sa : 48;
	uint64_t lkp_mac_da : 48;
	uint32_t lkp_mac_type : 16;
	uint8_t lkp_ip_type : 2;
	uint32_t lkp_ipv4_sa : 32;
	uint32_t lkp_ipv4_da : 32;
	uint8_t lkp_ip_proto : 8;
	uint8_t lkp_ip_tc : 8;
	uint8_t lkp_ip_ttl : 8;
	uint32_t lkp_icmp_type : 16;
	uint32_t lkp_icmp_code : 16;
	uint32_t lkp_l4_sport : 16;
	uint32_t lkp_l4_dport : 16;
	uint32_t lkp_inner_l4_sport : 16;
	uint32_t lkp_inner_l4_dport : 16;
	uint32_t l3_length : 16;
	uint32_t ifindex : 10;
	uint32_t lif : 16;
	uint32_t vrf : 12;
	uint8_t tunnel_type : 4;
	uint8_t tunnel_terminate : 1;
	uint32_t tunnel_vni : 24;
	uint32_t tunnel_lif : 16;
	uint8_t src_vtep_miss : 1;
	uint8_t outer_bd : 8;
	uint32_t outer_rmac_group : 10;
	uint8_t outer_rmac_hit : 1;
	uint8_t outer_dscp : 8;
	uint8_t outer_ttl : 8;
	uint8_t l2_multicast : 1;
	uint8_t src_is_link_local : 1;
	uint32_t bd : 16;
	uint8_t ipv4_unicast_enabled : 1;
	uint8_t igmp_snooping_enabled : 1;
	uint32_t rmac_group : 10;
	uint8_t rmac_hit : 1;
	uint32_t uuc_mc_index : 16;
	uint32_t umc_mc_index : 16;
	uint32_t bcast_mc_index : 16;
	uint32_t multicast_bridge_mc_index : 16;
	uint8_t routed : 1;
	uint32_t if_label : 16;
	uint32_t bd_label : 16;
	uint8_t l2_src_miss : 1;
	uint32_t l2_src_move : 10;
	uint8_t acl_deny : 1;
	uint8_t racl_deny : 1;
	uint8_t l2_redirect : 1;
	uint8_t acl_redirect : 1;
	uint8_t racl_redirect : 1;
	uint8_t fib_hit : 1;
	uint64_t learn_mac : 48;
	uint32_t l2_nexthop : 16;
	uint32_t acl_nexthop : 16;
	uint32_t racl_nexthop : 16;
	uint32_t fib_nexthop : 16;
	uint32_t l2_ecmp : 10;
	uint32_t acl_ecmp : 10;
	uint32_t racl_ecmp : 10;
	uint32_t fib_ecmp : 10;
	uint32_t ecmp_index : 10;
	uint32_t ecmp_offset : 14;
	uint32_t nexthop_index : 16;
	uint32_t lag_offset : 14;
	uint8_t ttl : 8;
	uint32_t egress_ifindex : 10;
	uint32_t egress_bd : 16;
	uint8_t ingress_bypass : 1;
	uint32_t ipv4_dstaddr_24b : 24;
	uint8_t drop_0 : 1;
	uint8_t drop_reason : 8;
	uint8_t msg_type : 8;
	uint32_t stp_group : 10;
	uint8_t stp_state : 3;
	uint8_t stp_enabled : 1;
	uint8_t control_frame : 1;
} ingress_metadata_t;

typedef struct {
	uint32_t eg_mcast_group : 16;
	uint32_t replication_id : 16;
	uint32_t lf_field_list : 32;
} intrinsic_metadata_t;

typedef struct {
	uint8_t isValid : 1;
	uint32_t hwType : 16;
	uint32_t protoType : 16;
	uint8_t hwAddrLen : 8;
	uint8_t protoAddrLen : 8;
	uint32_t opcode : 16;
} arp_rarp_t;

typedef struct {
	uint8_t isValid : 1;
	uint64_t srcHwAddr : 48;
	uint32_t srcProtoAddr : 32;
	uint64_t dstHwAddr : 48;
	uint32_t dstProtoAddr : 32;
} arp_rarp_ipv4_t;

typedef struct {
	uint8_t isValid : 1;
	uint8_t qid : 3;
	uint8_t pad : 1;
	uint32_t reason_code : 12;
	uint32_t rxhash : 16;
	uint32_t bridge_domain : 16;
	uint32_t ingress_lif : 16;
	uint32_t egress_lif : 16;
	uint8_t lu_bypass_ingress : 1;
	uint8_t lu_bypass_egress : 1;
	uint32_t pad1 : 14;
	uint32_t etherType : 16;
} cpu_header_t;

typedef struct {
	uint8_t isValid : 1;
	uint8_t version : 4;
	uint32_t vlan : 12;
	uint8_t priority : 6;
	uint32_t span_id : 10;
	uint8_t direction : 8;
	uint8_t truncated : 8;
} erspan_header_v1_t_0;

typedef struct {
	uint8_t isValid : 1;
	uint8_t version : 4;
	uint32_t vlan : 12;
	uint8_t priority : 6;
	uint32_t span_id : 10;
	uint32_t unknown7 : 32;
} erspan_header_v2_t_0;

typedef struct {
	uint8_t isValid : 1;
	uint64_t dstAddr : 48;
	uint64_t srcAddr : 48;
	uint32_t etherType : 16;
} ethernet_t;

typedef struct {
	uint8_t isValid : 1;
	uint8_t version : 4;
	uint8_t type_ : 4;
	uint8_t sof : 8;
	uint32_t rsvd1 : 32;
	uint32_t ts_upper : 32;
	uint32_t ts_lower : 32;
	uint32_t size_ : 32;
	uint8_t eof : 8;
	uint32_t rsvd2 : 24;
} fcoe_header_t;

typedef struct {
	uint8_t isValid : 1;
	uint8_t ver : 2;
	uint8_t optLen : 6;
	uint8_t oam : 1;
	uint8_t critical : 1;
	uint8_t reserved : 6;
	uint32_t protoType : 16;
	uint32_t vni : 24;
	uint8_t reserved2 : 8;
} genv_t;

typedef struct {
	uint8_t isValid : 1;
	uint8_t C : 1;
	uint8_t R : 1;
	uint8_t K : 1;
	uint8_t S : 1;
	uint8_t s : 1;
	uint8_t recurse : 3;
	uint8_t flags : 5;
	uint8_t ver : 3;
	uint32_t proto : 16;
} gre_t;

typedef struct {
	uint8_t isValid : 1;
	uint8_t type_ : 8;
	uint8_t code : 8;
	uint32_t hdrChecksum : 16;
} icmp_t;

typedef struct {
	uint8_t isValid : 1;
	uint8_t type_ : 8;
	uint8_t code : 8;
	uint32_t hdrChecksum : 16;
} icmpv6_t;

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
	uint8_t version : 4;
	uint8_t trafficClass : 8;
	uint32_t flowLabel : 20;
	uint32_t payloadLen : 16;
	uint8_t nextHdr : 8;
	uint8_t hopLimit : 8;
	uint64_t srcAddr : 64; // >64 128
	uint64_t dstAddr : 64; // >64 128
} ipv6_t;

typedef struct {
	uint8_t isValid : 1;
	uint32_t srcPort : 16;
	uint32_t dstPort : 16;
	uint32_t seqNo : 32;
	uint32_t ackNo : 32;
	uint8_t dataOffset : 4;
	uint8_t res : 4;
	uint8_t flags : 8;
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
	uint8_t isValid : 1;
	uint8_t oam : 1;
	uint8_t context : 1;
	uint8_t flags : 6;
	uint8_t reserved : 8;
	uint32_t protoType : 16;
	uint32_t spath : 24;
	uint8_t sindex : 8;
} nsh_t;

typedef struct {
	uint8_t isValid : 1;
	uint32_t network_platform : 32;
	uint32_t network_shared : 32;
	uint32_t service_platform : 32;
	uint32_t service_shared : 32;
} nsh_context_t;

typedef struct {
	uint8_t isValid : 1;
	uint32_t tni : 24;
	uint8_t reserved : 8;
} nvgre_t;

typedef struct {
	uint8_t isValid : 1;
	uint64_t ib_grh : 64; // >64 128
	uint64_t ib_bth : 64; // >64 96
} roce_header_t;

typedef struct {
	uint8_t isValid : 1;
	uint64_t ib_bth : 64; // >64 96
} roce_v2_header_t;

typedef struct {
	uint8_t isValid : 1;
	uint8_t dsap : 8;
	uint8_t ssap : 8;
	uint8_t control_ : 8;
	uint32_t oui : 24;
	uint32_t type_ : 16;
} snap_header_t;

typedef struct {
	uint8_t isValid : 1;
	uint8_t flags : 8;
	uint32_t reserved : 24;
	uint32_t vni : 24;
	uint8_t reserved2 : 8;
} vxlan_t;

typedef struct {
	uint8_t isValid : 1;
	uint8_t pcp : 3;
	uint8_t cfi : 1;
	uint32_t vid : 12;
	uint32_t etherType : 16;
} vlan_tag_t;

typedef struct {
	egress_metadata_t egress_metadata;
	ingress_metadata_t ingress_metadata;
	intrinsic_metadata_t intrinsic_metadata;
} metadata;

typedef struct {
	arp_rarp_t arp_rarp;
	arp_rarp_ipv4_t arp_rarp_ipv4;
	cpu_header_t cpu_header;
	erspan_header_v1_t_0 erspan_v1_header;
	erspan_header_v2_t_0 erspan_v2_header;
	ethernet_t ethernet;
	fcoe_header_t fcoe;
	genv_t genv;
	gre_t gre;
	icmp_t icmp;
	icmpv6_t icmpv6;
	ethernet_t inner_ethernet;
	icmp_t inner_icmp;
	icmpv6_t inner_icmpv6;
	ipv4_t inner_ipv4;
	ipv6_t inner_ipv6;
	tcp_t inner_tcp;
	udp_t inner_udp;
	ipv4_t ipv4;
	ipv6_t ipv6;
	nsh_t nsh;
	nsh_context_t nsh_context;
	nvgre_t nvgre;
	roce_header_t roce;
	roce_v2_header_t roce_v2;
	snap_header_t snap_header;
	tcp_t tcp;
	udp_t udp;
	vxlan_t vxlan;
	int vlan_tag__index;
	vlan_tag_t vlan_tag_[2];
} headers;

headers hdr;
metadata meta;
standard_metadata_t standard_metadata;


void parse_arp_rarp() {
	hdr.arp_rarp.isValid = 1;
	switch(hdr.arp_rarp.protoType){
		case 2048:	parse_arp_rarp_ipv4(); break;
		default:	accept(); break;
	}
}


void parse_arp_rarp_ipv4() {
	hdr.arp_rarp_ipv4.isValid = 1;
	accept();
}


void parse_cpu_header() {
	hdr.cpu_header.isValid = 1;
	meta.ingress_metadata.ingress_bypass = 1;
	standard_metadata.egress_spec = (uint32_t) hdr.cpu_header.egress_lif;
	if (0 & 63488  == hdr.cpu_header.etherType & 63488) {
			parse_snap_header();
	} else { switch(hdr.cpu_header.etherType) { 
		case 33024:	parse_vlan(); break;
		case 37120:	parse_vlan(); break;
		case 37376:	parse_vlan(); break;
		case 37632:	parse_vlan(); break;
		case 2048:	parse_ipv4(); break;
		case 34525:	parse_ipv6(); break;
		case 2054:	parse_arp_rarp(); break;
		case 32821:	parse_arp_rarp(); break;
		case 35151:	parse_nsh(); break;
		case 35093:	parse_roce(); break;
		case 35078:	parse_fcoe(); break;
		default:	accept(); break;
	} }
}


void parse_erspan_v1() {
	hdr.erspan_v1_header.isValid = 1;
	accept();
}


void parse_erspan_v2() {
	hdr.erspan_v2_header.isValid = 1;
	accept();
}


void parse_ethernet() {
	hdr.ethernet.isValid = 1;
	
		if (0 & 63488  == hdr.ethernet.etherType & 63488) {
			parse_snap_header();
		} else { 
		    switch(hdr.ethernet.etherType) {
			case 36864:	parse_cpu_header(); break;
			case 268:	parse_cpu_header(); break;
			case 33024:	parse_vlan(); break;
			case 37120:	parse_vlan(); break;
			case 37376:	parse_vlan(); break;
			case 37632:	parse_vlan(); break;
			case 2048:	parse_ipv4(); break;
			case 34525:	parse_ipv6(); break;
			case 2054:	parse_arp_rarp(); break;
			case 32821:	parse_arp_rarp(); break;
			case 35151:	parse_nsh(); break;
			case 35093:	parse_roce(); break;
			case 35078:	parse_fcoe(); break;
			default:	accept(); break;
		   }
	       }
}


void parse_fcoe() {
	hdr.fcoe.isValid = 1;
	accept();
}


void parse_geneve() {
	hdr.genv.isValid = 1;
	meta.ingress_metadata.tunnel_vni = hdr.genv.vni;
	meta.ingress_metadata.tunnel_type = 3;
	parse_genv_inner();
}


void parse_genv_inner() {
	switch(hdr.genv.protoType){
		case 25944:	parse_inner_ethernet(); break;
		case 2048:	parse_inner_ipv4(); break;
		case 34525:	parse_inner_ipv6(); break;
		default:	accept(); break;
	}
}


void parse_gre() {
	hdr.gre.isValid = 1;
	meta.ingress_metadata.tunnel_type = 2;
	if((hdr.gre.K == 0) && (hdr.gre.proto == 25944)) {
		parse_nvgre();
	} else if((hdr.gre.K == 0) && (hdr.gre.proto == 35006)) {
		parse_erspan_v1();
	} else if((hdr.gre.K == 0) && (hdr.gre.proto == 8939)) {
		parse_erspan_v2();
	} else if((hdr.gre.K == 0) && (hdr.gre.proto == 35151)) {
		parse_nsh();
	} else { ingress(); }
}


void parse_icmp() {
	hdr.icmp.isValid = 1;
	meta.ingress_metadata.msg_type = hdr.icmp.code;
	accept();
}


void parse_icmpv6() {
	hdr.icmpv6.isValid = 1;
	meta.ingress_metadata.msg_type = hdr.icmpv6.code;
	accept();
}


void parse_inner_ethernet() {
	hdr.inner_ethernet.isValid = 1;
	switch(hdr.inner_ethernet.etherType){
		case 2048:	parse_inner_ipv4(); break;
		case 34525:	parse_inner_ipv6(); break;
		default:	accept(); break;
	}
}


void parse_inner_icmp() {
	hdr.inner_icmp.isValid = 1;
	accept();
}


void parse_inner_icmpv6() {
	hdr.inner_icmpv6.isValid = 1;
	accept();
}


void parse_inner_ipv4() {
	hdr.inner_ipv4.isValid = 1;
	if((hdr.inner_ipv4.fragOffset == 0) && (hdr.inner_ipv4.protocol == 1)) {
		parse_inner_icmp();
	} else if((hdr.inner_ipv4.fragOffset == 0) && (hdr.inner_ipv4.protocol == 6)) {
		parse_inner_tcp();
	} else if((hdr.inner_ipv4.fragOffset == 0) && (hdr.inner_ipv4.protocol == 17)) {
		parse_inner_udp();
	} else { accept(); }
}


void parse_inner_ipv6() {
	hdr.inner_ipv6.isValid = 1;
	switch(hdr.inner_ipv6.nextHdr){
		case 58:	parse_inner_icmpv6(); break;
		case 6:	parse_inner_tcp(); break;
		case 17:	parse_inner_udp(); break;
		default:	accept(); break;
	}
}


void parse_inner_tcp() {
	hdr.inner_tcp.isValid = 1;
	meta.ingress_metadata.lkp_inner_l4_sport = hdr.inner_tcp.srcPort;
	meta.ingress_metadata.lkp_inner_l4_dport = hdr.inner_tcp.dstPort;
	accept();
}


void parse_inner_udp() {
	hdr.inner_udp.isValid = 1;
	meta.ingress_metadata.lkp_inner_l4_sport = hdr.inner_udp.srcPort;
	meta.ingress_metadata.lkp_inner_l4_dport = hdr.inner_udp.dstPort;
	accept();
}


void parse_ipv4() {
	hdr.ipv4.isValid = 1;
	meta.ingress_metadata.ipv4_dstaddr_24b = (uint32_t) hdr.ipv4.dstAddr;
	if((hdr.ipv4.fragOffset == 0) && (hdr.ipv4.protocol == 1)) {
		parse_icmp();
	} else if((hdr.ipv4.fragOffset == 0) && (hdr.ipv4.protocol == 6)) {
		parse_tcp();
	} else if((hdr.ipv4.fragOffset == 0) && (hdr.ipv4.protocol == 17)) {
		parse_udp();
	} else if((hdr.ipv4.fragOffset == 0) && (hdr.ipv4.protocol == 47)) {
		parse_gre();
	} else { accept(); }
}


void parse_ipv6() {
	hdr.ipv6.isValid = 1;
	switch(hdr.ipv6.nextHdr){
		case 58:	parse_icmpv6(); break;
		case 6:	parse_tcp(); break;
		case 17:	parse_udp(); break;
		case 47:	parse_gre(); break;
		default:	accept(); break;
	}
}


void parse_nsh() {
	hdr.nsh.isValid = 1;
	hdr.nsh_context.isValid = 1;
	switch(hdr.nsh.protoType){
		case 2048:	parse_inner_ipv4(); break;
		case 34525:	parse_inner_ipv6(); break;
		case 25944:	parse_inner_ethernet(); break;
		default:	accept(); break;
	}
}


void parse_nvgre() {
	hdr.nvgre.isValid = 1;
	meta.ingress_metadata.tunnel_type = 4;
	meta.ingress_metadata.tunnel_vni = hdr.nvgre.tni;
	parse_inner_ethernet();
}


void parse_roce() {
	hdr.roce.isValid = 1;
	accept();
}


void parse_roce_v2() {
	hdr.roce_v2.isValid = 1;
	accept();
}


void parse_snap_header() {
	hdr.snap_header.isValid = 1;
	accept();
}


void parse_tcp() {
	hdr.tcp.isValid = 1;
	meta.ingress_metadata.lkp_l4_sport = hdr.tcp.srcPort;
	meta.ingress_metadata.lkp_l4_dport = hdr.tcp.dstPort;
	accept();
}


void parse_udp() {
	hdr.udp.isValid = 1;
	meta.ingress_metadata.lkp_l4_sport = hdr.udp.srcPort;
	meta.ingress_metadata.lkp_l4_dport = hdr.udp.dstPort;
	switch(hdr.udp.dstPort){
		case 4789:	parse_vxlan(); break;
		case 6081:	parse_geneve(); break;
		case 1021:	parse_roce_v2(); break;
		default:	accept(); break;
	}
}


void parse_vlan() {
        if(hdr.vlan_tag__index >= 2) reject();
	hdr.vlan_tag_[hdr.vlan_tag__index].isValid = 1;
	hdr.vlan_tag__index++;
        if(hdr.vlan_tag__index - 1 >= 2 || hdr.vlan_tag__index - 1 < 0) reject();
	switch(hdr.vlan_tag_[hdr.vlan_tag__index-1].etherType){
		case 33024:	parse_vlan(); break;
		case 37120:	parse_vlan(); break;
		case 37376:	parse_vlan(); break;
		case 37632:	parse_vlan(); break;
		case 2048:	parse_ipv4(); break;
		case 34525:	parse_ipv6(); break;
		case 2054:	parse_arp_rarp(); break;
		case 32821:	parse_arp_rarp(); break;
		default:	accept(); break;
	}
}


void parse_vxlan() {
	hdr.vxlan.isValid = 1;
	meta.ingress_metadata.tunnel_type = 1;
	meta.ingress_metadata.tunnel_vni = hdr.vxlan.vni;
	parse_inner_ethernet();
}


void start() {
	meta.ingress_metadata.drop_0 = 0;
	parse_ethernet();
}


void accept() {
	
}


void reject() {
	//printf("Packet dropped");
	endAssertions();
}


void ParserImpl() {
	klee_make_symbolic(&hdr, sizeof(hdr), "hdr");
	klee_make_symbolic(&meta, sizeof(meta), "meta");
	klee_make_symbolic(&standard_metadata, sizeof(standard_metadata), "standard_metadata");

	start();
}

typedef struct {
	uint64_t field : 48;
	uint64_t field_0 : 48;
	uint32_t field_1 : 16;
	uint32_t field_2 : 32;
	uint32_t field_3 : 32;
	uint8_t field_4 : 8;
} tuple_0;

//Control
uint32_t tmp_10;
tuple_0 tmp_11;
uint32_t tmp_12;
tuple_0 tmp_13;

void egress() {
	if((meta.egress_metadata.egress_bypass == 0)) {
	if((meta.intrinsic_metadata.replication_id != 0)) {
		rid_1206499();
	}
	if((meta.ingress_metadata.tunnel_terminate == 1)) {
		if((meta.egress_metadata.replica == 0)) {
			tunnel_decap_1206558();
		}
	}
	egress_bd_map_1206069();
	rewrite_1206410();
	if((meta.egress_metadata.tunnel_type != 0)) {
		tunnel_rewrite_1206730();
	tunnel_src_rewrite_1206861();
	tunnel_dst_rewrite_1206677();

	}
	if((meta.egress_metadata.routed == 1)) {
		outer_mac_1206333();
	}
	egress_block_1206128(); 
	if(action_run == 1203258) { egress_vlan_xlate_1206257(); }

	egress_system_acl_1206198();
	cpu_rewrite_1205994();

}
}

// Action
void NoAction_0_1203140() {
	action_run = 1203140;
	
}


// Action
void NoAction_1_1203150() {
	action_run = 1203150;
	
}


// Action
void NoAction_40_1203151() {
	action_run = 1203151;
	
}


// Action
void NoAction_41_1203152() {
	action_run = 1203152;
	
}


// Action
void NoAction_42_1203153() {
	action_run = 1203153;
	
}


// Action
void NoAction_43_1203154() {
	action_run = 1203154;
	
}


// Action
void NoAction_44_1203155() {
	action_run = 1203155;
	
}


// Action
void NoAction_45_1203156() {
	action_run = 1203156;
	
}


// Action
void NoAction_46_1203157() {
	action_run = 1203157;
	
}


// Action
void NoAction_47_1203158() {
	action_run = 1203158;
	
}


// Action
void NoAction_48_1203159() {
	action_run = 1203159;
	
}


// Action
void NoAction_49_1203160() {
	action_run = 1203160;
	
}


// Action
void nop_1_1203161() {
	action_run = 1203161;
	
}


// Action
void nop_2_1203171() {
	action_run = 1203171;
	
}


// Action
void nop_3_1203172() {
	action_run = 1203172;
	
}


// Action
void nop_25_1203173() {
	action_run = 1203173;
	
}


// Action
void nop_26_1203174() {
	action_run = 1203174;
	
}


// Action
void nop_27_1203175() {
	action_run = 1203175;
	
}


// Action
void nop_28_1203176() {
	action_run = 1203176;
	
}


// Action
void set_cpu_tx_rewrite_0_1203177() {
	action_run = 1203177;
		hdr.ethernet.etherType = hdr.cpu_header.etherType;
	hdr.cpu_header.isValid = 0;

}


// Action
void set_cpu_rx_rewrite_0_1203204() {
	action_run = 1203204;
		hdr.cpu_header.isValid = 1;
	hdr.cpu_header.etherType = hdr.ethernet.etherType;
	hdr.cpu_header.ingress_lif = (uint32_t) standard_metadata.ingress_port;

}


// Action
void set_egress_bd_properties_0_1203240() {
	action_run = 1203240;
	uint32_t vnid;
	klee_make_symbolic(&vnid, sizeof(vnid), "vnid");
	meta.egress_metadata.vnid = vnid;

}


// Action
void on_miss_0_1203258() {
	action_run = 1203258;
	
}


// Action
void egress_drop_0_1203268() {
	action_run = 1203268;
		mark_to_drop();

}


// Action
void egress_redirect_to_cpu_0_1203284() {
	action_run = 1203284;
	
}


// Action
void set_egress_packet_vlan_tagged_0_1203294() {
	action_run = 1203294;
	uint32_t vlan_id;
	klee_make_symbolic(&vlan_id, sizeof(vlan_id), "vlan_id");
	hdr.vlan_tag_[0].isValid = 1;
	hdr.vlan_tag_[0].vid = vlan_id;

}


// Action
void set_egress_packet_vlan_untagged_0_1203326() {
	action_run = 1203326;
		hdr.vlan_tag_[0].isValid = 0;

}


// Action
void rewrite_unicast_mac_0_1203347() {
	action_run = 1203347;
	uint64_t smac;
	klee_make_symbolic(&smac, sizeof(smac), "smac");
	hdr.ethernet.srcAddr = smac;
	hdr.ethernet.dstAddr = meta.egress_metadata.mac_da;

}


// Action
void rewrite_multicast_mac_0_1298178() {
	action_run = 1298178;
	uint64_t smac;
	klee_make_symbolic(&smac, sizeof(smac), "smac");
	hdr.ethernet.srcAddr = smac;
	hdr.ethernet.dstAddr = 1101088686080;
	hdr.ethernet.dstAddr &= ~0x3FFFFF;
	hdr.ethernet.dstAddr |= (hdr.ipv4.dstAddr & 0x3FFFFF) & 0x3FFFFF;
	hdr.ipv4.ttl = hdr.ipv4.ttl + 255;

}


// Action
void set_l2_rewrite_0_1203429() {
	action_run = 1203429;
		meta.egress_metadata.routed = 0;

}


// Action
void set_ipv4_unicast_rewrite_0_1203445() {
	action_run = 1203445;
	uint32_t smac_idx;
	klee_make_symbolic(&smac_idx, sizeof(smac_idx), "smac_idx");
uint64_t dmac;
	klee_make_symbolic(&dmac, sizeof(dmac), "dmac");
	meta.egress_metadata.smac_idx = smac_idx;
	meta.egress_metadata.mac_da = dmac;
	meta.egress_metadata.routed = 1;
	hdr.ipv4.ttl = meta.ingress_metadata.ttl;

}


// Action
void set_ipv4_vxlan_rewrite_0_1203486() {
	action_run = 1203486;
	uint32_t outer_bd;
	klee_make_symbolic(&outer_bd, sizeof(outer_bd), "outer_bd");
//uint32_t tunnel_src_index;
//	klee_make_symbolic(&tunnel_src_index, sizeof(tunnel_src_index), "tunnel_src_index");
uint32_t tunnel_dst_index;
	klee_make_symbolic(&tunnel_dst_index, sizeof(tunnel_dst_index), "tunnel_dst_index");
uint32_t smac_idx;
	klee_make_symbolic(&smac_idx, sizeof(smac_idx), "smac_idx");
uint64_t dmac;
	klee_make_symbolic(&dmac, sizeof(dmac), "dmac");
	meta.egress_metadata.bd = outer_bd;
	meta.egress_metadata.smac_idx = smac_idx;
	meta.egress_metadata.mac_da = dmac;
//	meta.egress_metadata.tunnel_src_index = tunnel_src_index;
	meta.egress_metadata.tunnel_dst_index = tunnel_dst_index;
	meta.egress_metadata.routed = 1;
	meta.egress_metadata.tunnel_type = 1;

}


// Action
void set_ipv4_geneve_rewrite_0_1203548() {
	action_run = 1203548;
	uint32_t outer_bd;
	klee_make_symbolic(&outer_bd, sizeof(outer_bd), "outer_bd");
//uint32_t tunnel_src_index;
//	klee_make_symbolic(&tunnel_src_index, sizeof(tunnel_src_index), "tunnel_src_index");
uint32_t tunnel_dst_index;
	klee_make_symbolic(&tunnel_dst_index, sizeof(tunnel_dst_index), "tunnel_dst_index");
uint32_t smac_idx;
	klee_make_symbolic(&smac_idx, sizeof(smac_idx), "smac_idx");
uint64_t dmac;
	klee_make_symbolic(&dmac, sizeof(dmac), "dmac");
	meta.egress_metadata.bd = outer_bd;
	meta.egress_metadata.smac_idx = smac_idx;
	meta.egress_metadata.mac_da = dmac;
//	meta.egress_metadata.tunnel_src_index = tunnel_src_index;
	meta.egress_metadata.tunnel_dst_index = tunnel_dst_index;
	meta.egress_metadata.routed = 1;
	meta.egress_metadata.tunnel_type = 2;

}


// Action
void set_ipv4_nvgre_rewrite_0_1203610() {
	action_run = 1203610;
	uint32_t outer_bd;
	klee_make_symbolic(&outer_bd, sizeof(outer_bd), "outer_bd");
//uint32_t tunnel_src_index;
//	klee_make_symbolic(&tunnel_src_index, sizeof(tunnel_src_index), "tunnel_src_index");
uint32_t tunnel_dst_index;
	klee_make_symbolic(&tunnel_dst_index, sizeof(tunnel_dst_index), "tunnel_dst_index");
uint32_t smac_idx;
	klee_make_symbolic(&smac_idx, sizeof(smac_idx), "smac_idx");
uint64_t dmac;
	klee_make_symbolic(&dmac, sizeof(dmac), "dmac");
	meta.egress_metadata.bd = outer_bd;
	meta.egress_metadata.smac_idx = smac_idx;
	meta.egress_metadata.mac_da = dmac;
//	meta.egress_metadata.tunnel_src_index = tunnel_src_index;
	meta.egress_metadata.tunnel_dst_index = tunnel_dst_index;
	meta.egress_metadata.routed = 1;
	meta.egress_metadata.tunnel_type = 3;

}


// Action
void set_ipv4_erspan_v2_rewrite_0_1203672() {
	action_run = 1203672;
	uint32_t outer_bd;
	klee_make_symbolic(&outer_bd, sizeof(outer_bd), "outer_bd");
//uint32_t tunnel_src_index;
//	klee_make_symbolic(&tunnel_src_index, sizeof(tunnel_src_index), "tunnel_src_index");
uint32_t tunnel_dst_index;
	klee_make_symbolic(&tunnel_dst_index, sizeof(tunnel_dst_index), "tunnel_dst_index");
uint32_t smac_idx;
	klee_make_symbolic(&smac_idx, sizeof(smac_idx), "smac_idx");
uint64_t dmac;
	klee_make_symbolic(&dmac, sizeof(dmac), "dmac");
	meta.egress_metadata.bd = outer_bd;
	meta.egress_metadata.smac_idx = smac_idx;
	meta.egress_metadata.mac_da = dmac;
//	meta.egress_metadata.tunnel_src_index = tunnel_src_index;
	meta.egress_metadata.tunnel_dst_index = tunnel_dst_index;
	meta.egress_metadata.routed = 1;
	meta.egress_metadata.tunnel_type = 4;

}


// Action
void replica_from_rid_0_1203734() {
	action_run = 1203734;
	uint32_t bd;
	klee_make_symbolic(&bd, sizeof(bd), "bd");
	meta.ingress_metadata.egress_bd = bd;
	meta.egress_metadata.replica = 1;

}


// Action
void decapsulate_vxlan_packet_inner_ipv4_udp_0_1203758() {
	action_run = 1203758;
		hdr.ethernet = hdr.inner_ethernet;
	hdr.ipv4.isValid = 1;
	hdr.ipv4 = hdr.inner_ipv4;
	hdr.udp = hdr.inner_udp;
	hdr.inner_ethernet.isValid = 0;
	hdr.inner_ipv4.isValid = 0;
	hdr.inner_udp.isValid = 0;
	hdr.vxlan.isValid = 0;
	meta.ingress_metadata.ttl = meta.ingress_metadata.outer_ttl;

}


// Action
void decapsulate_vxlan_packet_inner_ipv4_tcp_0_1203838() {
	action_run = 1203838;
		hdr.ethernet = hdr.inner_ethernet;
	hdr.ipv4.isValid = 1;
	hdr.ipv4 = hdr.inner_ipv4;
	hdr.tcp.isValid = 1;
	hdr.tcp = hdr.inner_tcp;
	hdr.inner_ethernet.isValid = 0;
	hdr.inner_ipv4.isValid = 0;
	hdr.inner_tcp.isValid = 0;
	hdr.udp.isValid = 0;
	hdr.vxlan.isValid = 0;
	meta.ingress_metadata.ttl = meta.ingress_metadata.outer_ttl;

}


// Action
void decapsulate_geneve_packet_inner_ipv4_udp_0_1203934() {
	action_run = 1203934;
		hdr.ethernet = hdr.inner_ethernet;
	hdr.ipv4.isValid = 1;
	hdr.ipv4 = hdr.inner_ipv4;
	hdr.udp = hdr.inner_udp;
	hdr.inner_ethernet.isValid = 0;
	hdr.inner_ipv4.isValid = 0;
	hdr.inner_udp.isValid = 0;
	hdr.genv.isValid = 0;
	meta.ingress_metadata.ttl = meta.ingress_metadata.outer_ttl;

}


// Action
void decapsulate_geneve_packet_inner_ipv4_tcp_0_1204014() {
	action_run = 1204014;
		hdr.ethernet = hdr.inner_ethernet;
	hdr.ipv4.isValid = 1;
	hdr.ipv4 = hdr.inner_ipv4;
	hdr.tcp.isValid = 1;
	hdr.tcp = hdr.inner_tcp;
	hdr.inner_ethernet.isValid = 0;
	hdr.inner_ipv4.isValid = 0;
	hdr.inner_tcp.isValid = 0;
	hdr.udp.isValid = 0;
	hdr.genv.isValid = 0;
	meta.ingress_metadata.ttl = meta.ingress_metadata.outer_ttl;

}


// Action
void decapsulate_nvgre_packet_inner_ipv4_udp_0_1204110() {
	action_run = 1204110;
		hdr.ethernet = hdr.inner_ethernet;
	hdr.ipv4.isValid = 1;
	hdr.ipv4 = hdr.inner_ipv4;
	hdr.udp = hdr.inner_udp;
	hdr.inner_ethernet.isValid = 0;
	hdr.inner_ipv4.isValid = 0;
	hdr.inner_udp.isValid = 0;
	hdr.nvgre.isValid = 0;
	hdr.gre.isValid = 0;
	meta.ingress_metadata.ttl = meta.ingress_metadata.outer_ttl;

}


// Action
void decapsulate_nvgre_packet_inner_ipv4_tcp_0_1204198() {
	action_run = 1204198;
		hdr.ethernet = hdr.inner_ethernet;
	hdr.ipv4.isValid = 1;
	hdr.ipv4 = hdr.inner_ipv4;
	hdr.tcp.isValid = 1;
	hdr.tcp = hdr.inner_tcp;
	hdr.inner_ethernet.isValid = 0;
	hdr.inner_ipv4.isValid = 0;
	hdr.inner_tcp.isValid = 0;
	hdr.nvgre.isValid = 0;
	hdr.gre.isValid = 0;
	meta.ingress_metadata.ttl = meta.ingress_metadata.outer_ttl;

}


// Action
void rewrite_tunnel_ipv4_dst_0_1204294() {
	action_run = 1204294;
	uint32_t ip;
	klee_make_symbolic(&ip, sizeof(ip), "ip");
	hdr.ipv4.dstAddr = ip;

}


// Action
void ipv4_vxlan_inner_ipv4_udp_rewrite_0_1204312() {
	action_run = 1204312;
		hdr.inner_ethernet.isValid = 1;
	hdr.inner_ethernet = hdr.ethernet;
	hdr.inner_ipv4.isValid = 1;
	hdr.inner_ipv4 = hdr.ipv4;
	hdr.inner_ipv4.ttl = meta.ingress_metadata.ttl;
	hdr.ipv4.isValid = 0;
	hdr.inner_udp.isValid = 1;
	hdr.inner_udp = hdr.udp;
	hdr.udp.isValid = 0;
	hdr.udp.isValid = 1;
	hdr.vxlan.isValid = 1;
	tmp_11.field = hdr.inner_ethernet.srcAddr;
	tmp_11.field_0 = hdr.inner_ethernet.dstAddr;
	tmp_11.field_1 = hdr.inner_ethernet.etherType;
	tmp_11.field_2 = hdr.inner_ipv4.srcAddr;
	tmp_11.field_3 = hdr.inner_ipv4.dstAddr;
	tmp_11.field_4 = hdr.inner_ipv4.protocol;
		klee_make_symbolic(&tmp_10, sizeof(tmp_10), "tmp_10");

	hdr.udp.srcPort = tmp_10;
	hdr.udp.dstPort = 4789;
	hdr.udp.checksum = 0;
	hdr.udp.length_ = meta.ingress_metadata.l3_length;
	hdr.udp.length_ = hdr.udp.length_ + 30;
	hdr.vxlan.flags = 8;
	hdr.vxlan.vni = meta.egress_metadata.vnid;
	hdr.ipv4.isValid = 1;
	hdr.ipv4.protocol = 17;
	hdr.ipv4.ttl = meta.ingress_metadata.ttl;
	hdr.ipv4.version = 4;
	hdr.ipv4.ihl = 5;
	hdr.ipv4.totalLen = meta.ingress_metadata.l3_length;
	hdr.ipv4.totalLen = hdr.ipv4.totalLen + 50;

}


// Action
void ipv4_vxlan_inner_ipv4_tcp_rewrite_0_1204571() {
	action_run = 1204571;
		hdr.inner_ethernet.isValid = 1;
	hdr.inner_ethernet = hdr.ethernet;
	hdr.inner_ipv4.isValid = 1;
	hdr.inner_ipv4 = hdr.ipv4;
	hdr.inner_ipv4.ttl = meta.ingress_metadata.ttl;
	hdr.ipv4.isValid = 0;
	hdr.inner_tcp.isValid = 1;
	hdr.inner_tcp = hdr.tcp;
	hdr.tcp.isValid = 0;
	hdr.udp.isValid = 1;
	hdr.vxlan.isValid = 1;
	tmp_11.field = hdr.inner_ethernet.srcAddr;
	tmp_11.field_0 = hdr.inner_ethernet.dstAddr;
	tmp_11.field_1 = hdr.inner_ethernet.etherType;
	tmp_11.field_2 = hdr.inner_ipv4.srcAddr;
	tmp_11.field_3 = hdr.inner_ipv4.dstAddr;
	tmp_11.field_4 = hdr.inner_ipv4.protocol;
		klee_make_symbolic(&tmp_10, sizeof(tmp_10), "tmp_10");

	hdr.udp.srcPort = tmp_10;
	hdr.udp.dstPort = 4789;
	hdr.udp.checksum = 0;
	hdr.udp.length_ = meta.ingress_metadata.l3_length;
	hdr.udp.length_ = hdr.udp.length_ + 30;
	hdr.vxlan.flags = 8;
	hdr.vxlan.vni = meta.egress_metadata.vnid;
	hdr.ipv4.isValid = 1;
	hdr.ipv4.protocol = 17;
	hdr.ipv4.ttl = meta.ingress_metadata.ttl;
	hdr.ipv4.version = 4;
	hdr.ipv4.ihl = 5;
	hdr.ipv4.totalLen = meta.ingress_metadata.l3_length;
	hdr.ipv4.totalLen = hdr.ipv4.totalLen + 50;

}


// Action
void ipv4_genv_inner_ipv4_udp_rewrite_0_1204809() {
	action_run = 1204809;
		hdr.inner_ethernet.isValid = 1;
	hdr.inner_ethernet = hdr.ethernet;
	hdr.inner_ipv4.isValid = 1;
	hdr.inner_ipv4 = hdr.ipv4;
	hdr.inner_ipv4.ttl = meta.ingress_metadata.ttl;
	hdr.ipv4.isValid = 0;
	hdr.inner_udp.isValid = 1;
	hdr.inner_udp = hdr.udp;
	hdr.udp.isValid = 0;
	hdr.udp.isValid = 1;
	hdr.genv.isValid = 1;
	tmp_13.field = hdr.inner_ethernet.srcAddr;
	tmp_13.field_0 = hdr.inner_ethernet.dstAddr;
	tmp_13.field_1 = hdr.inner_ethernet.etherType;
	tmp_13.field_2 = hdr.inner_ipv4.srcAddr;
	tmp_13.field_3 = hdr.inner_ipv4.dstAddr;
	tmp_13.field_4 = hdr.inner_ipv4.protocol;
		klee_make_symbolic(&tmp_12, sizeof(tmp_12), "tmp_12");

	hdr.udp.srcPort = tmp_12;
	hdr.udp.dstPort = 6081;
	hdr.udp.checksum = 0;
	hdr.udp.length_ = meta.ingress_metadata.l3_length;
	hdr.udp.length_ = hdr.udp.length_ + 30;
	hdr.genv.ver = 0;
	hdr.genv.oam = 0;
	hdr.genv.critical = 0;
	hdr.genv.optLen = 0;
	hdr.genv.protoType = 25944;
	hdr.genv.vni = meta.egress_metadata.vnid;
	hdr.ipv4.isValid = 1;
	hdr.ipv4.protocol = 17;
	hdr.ipv4.ttl = meta.ingress_metadata.ttl;
	hdr.ipv4.version = 4;
	hdr.ipv4.ihl = 5;
	hdr.ipv4.totalLen = meta.ingress_metadata.l3_length;
	hdr.ipv4.totalLen = hdr.ipv4.totalLen + 50;

}


// Action
void ipv4_genv_inner_ipv4_tcp_rewrite_0_1205078() {
	action_run = 1205078;
		hdr.inner_ethernet.isValid = 1;
	hdr.inner_ethernet = hdr.ethernet;
	hdr.inner_ipv4.isValid = 1;
	hdr.inner_ipv4 = hdr.ipv4;
	hdr.inner_ipv4.ttl = meta.ingress_metadata.ttl;
	hdr.ipv4.isValid = 0;
	hdr.inner_tcp.isValid = 1;
	hdr.inner_tcp = hdr.tcp;
	hdr.tcp.isValid = 0;
	hdr.udp.isValid = 1;
	hdr.genv.isValid = 1;
	tmp_13.field = hdr.inner_ethernet.srcAddr;
	tmp_13.field_0 = hdr.inner_ethernet.dstAddr;
	tmp_13.field_1 = hdr.inner_ethernet.etherType;
	tmp_13.field_2 = hdr.inner_ipv4.srcAddr;
	tmp_13.field_3 = hdr.inner_ipv4.dstAddr;
	tmp_13.field_4 = hdr.inner_ipv4.protocol;
		klee_make_symbolic(&tmp_12, sizeof(tmp_12), "tmp_12");

	hdr.udp.srcPort = tmp_12;
	hdr.udp.dstPort = 6081;
	hdr.udp.checksum = 0;
	hdr.udp.length_ = meta.ingress_metadata.l3_length;
	hdr.udp.length_ = hdr.udp.length_ + 30;
	hdr.genv.ver = 0;
	hdr.genv.oam = 0;
	hdr.genv.critical = 0;
	hdr.genv.optLen = 0;
	hdr.genv.protoType = 25944;
	hdr.genv.vni = meta.egress_metadata.vnid;
	hdr.ipv4.isValid = 1;
	hdr.ipv4.protocol = 17;
	hdr.ipv4.ttl = meta.ingress_metadata.ttl;
	hdr.ipv4.version = 4;
	hdr.ipv4.ihl = 5;
	hdr.ipv4.totalLen = meta.ingress_metadata.l3_length;
	hdr.ipv4.totalLen = hdr.ipv4.totalLen + 50;

}


// Action
void ipv4_nvgre_inner_ipv4_udp_rewrite_0_1205332() {
	action_run = 1205332;
		hdr.inner_ethernet.isValid = 1;
	hdr.inner_ethernet = hdr.ethernet;
	hdr.inner_ipv4.isValid = 1;
	hdr.inner_ipv4 = hdr.ipv4;
	hdr.inner_ipv4.ttl = meta.ingress_metadata.ttl;
	hdr.ipv4.isValid = 0;
	hdr.inner_udp.isValid = 1;
	hdr.inner_udp = hdr.udp;
	hdr.udp.isValid = 0;
	hdr.gre.isValid = 1;
	hdr.nvgre.isValid = 1;
	hdr.gre.proto = 25944;
	hdr.gre.K = 1;
	hdr.gre.C = 0;
	hdr.gre.S = 0;
	hdr.nvgre.tni = meta.egress_metadata.vnid;
	hdr.ipv4.isValid = 1;
	hdr.ipv4.protocol = 47;
	hdr.ipv4.ttl = meta.ingress_metadata.ttl;
	hdr.ipv4.version = 4;
	hdr.ipv4.ihl = 5;
	hdr.ipv4.totalLen = meta.ingress_metadata.l3_length;
	hdr.ipv4.totalLen = hdr.ipv4.totalLen + 42;

}


// Action
void ipv4_nvgre_inner_ipv4_tcp_rewrite_0_1205502() {
	action_run = 1205502;
		hdr.inner_ethernet.isValid = 1;
	hdr.inner_ethernet = hdr.ethernet;
	hdr.inner_ipv4.isValid = 1;
	hdr.inner_ipv4 = hdr.ipv4;
	hdr.inner_ipv4.ttl = meta.ingress_metadata.ttl;
	hdr.ipv4.isValid = 0;
	hdr.inner_tcp.isValid = 1;
	hdr.inner_tcp = hdr.tcp;
	hdr.tcp.isValid = 0;
	hdr.gre.isValid = 1;
	hdr.nvgre.isValid = 1;
	hdr.gre.proto = 25944;
	hdr.gre.K = 1;
	hdr.gre.C = 0;
	hdr.gre.S = 0;
	hdr.nvgre.tni = meta.egress_metadata.vnid;
	hdr.ipv4.isValid = 1;
	hdr.ipv4.protocol = 47;
	hdr.ipv4.ttl = meta.ingress_metadata.ttl;
	hdr.ipv4.version = 4;
	hdr.ipv4.ihl = 5;
	hdr.ipv4.totalLen = meta.ingress_metadata.l3_length;
	hdr.ipv4.totalLen = hdr.ipv4.totalLen + 42;

}


// Action
void ipv4_erspan_v2_inner_ipv4_udp_rewrite_0_1205664() {
	action_run = 1205664;
		hdr.inner_ethernet.isValid = 1;
	hdr.inner_ethernet = hdr.ethernet;
	hdr.inner_ipv4.isValid = 1;
	hdr.inner_ipv4 = hdr.ipv4;
	hdr.inner_ipv4.ttl = meta.ingress_metadata.ttl;
	hdr.ipv4.isValid = 0;
	hdr.inner_udp.isValid = 1;
	hdr.inner_udp = hdr.udp;
	hdr.udp.isValid = 0;
	hdr.gre.isValid = 1;
	hdr.erspan_v2_header.isValid = 1;
	hdr.gre.proto = 8939;
	hdr.erspan_v2_header.version = 1;
	hdr.erspan_v2_header.vlan = (uint32_t) meta.egress_metadata.vnid;
	hdr.ipv4.isValid = 1;
	hdr.ipv4.protocol = 47;
	hdr.ipv4.ttl = meta.ingress_metadata.ttl;
	hdr.ipv4.version = 4;
	hdr.ipv4.ihl = 5;
	hdr.ipv4.totalLen = meta.ingress_metadata.l3_length;
	hdr.ipv4.totalLen = hdr.ipv4.totalLen + 46;

}


// Action
void ipv4_erspan_v2_inner_ipv4_tcp_rewrite_0_1205823() {
	action_run = 1205823;
		hdr.inner_ethernet.isValid = 1;
	hdr.inner_ethernet = hdr.ethernet;
	hdr.inner_ipv4.isValid = 1;
	hdr.inner_ipv4 = hdr.ipv4;
	hdr.inner_ipv4.ttl = meta.ingress_metadata.ttl;
	hdr.ipv4.isValid = 0;
	hdr.inner_tcp.isValid = 1;
	hdr.inner_tcp = hdr.tcp;
	hdr.tcp.isValid = 0;
	hdr.gre.isValid = 1;
	hdr.erspan_v2_header.isValid = 1;
	hdr.gre.proto = 8939;
	hdr.erspan_v2_header.version = 1;
	hdr.erspan_v2_header.vlan = (uint32_t) meta.egress_metadata.vnid;
	hdr.ipv4.isValid = 1;
	hdr.ipv4.protocol = 47;
	hdr.ipv4.ttl = meta.ingress_metadata.ttl;
	hdr.ipv4.version = 4;
	hdr.ipv4.ihl = 5;
	hdr.ipv4.totalLen = meta.ingress_metadata.l3_length;
	hdr.ipv4.totalLen = hdr.ipv4.totalLen + 46;

}


// Action
void rewrite_tunnel_ipv4_src_0_1205976() {
	action_run = 1205976;
	uint32_t ip;
	klee_make_symbolic(&ip, sizeof(ip), "ip");
	hdr.ipv4.srcAddr = ip;

}


//Table
void cpu_rewrite_1205994() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: nop_1_1203161(); break;
		case 1: set_cpu_tx_rewrite_0_1203177(); break;
		case 2: set_cpu_rx_rewrite_0_1203204(); break;
		default: NoAction_0_1203140(); break;
	}
	// size 512
	// default_action NoAction_0();
}


//Table
void egress_bd_map_1206069() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: nop_2_1203171(); break;
		case 1: set_egress_bd_properties_0_1203240(); break;
		default: NoAction_1_1203150(); break;
	}
	// size 512
	// default_action NoAction_1();
}


//Table
void egress_block_1206128() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: on_miss_0_1203258(); break;
		case 1: egress_drop_0_1203268(); break;
		default: NoAction_40_1203151(); break;
	}
	// size 256
	// default_action NoAction_40();
}


//Table
void egress_system_acl_1206198() {
	traverse_egress_acl = 1;
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: nop_3_1203172(); break;
		case 1: egress_redirect_to_cpu_0_1203284(); break;
		default: NoAction_41_1203152(); break;
	}
	// size 512
	// default_action NoAction_41();
}


//Table
void egress_vlan_xlate_1206257() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: nop_25_1203173(); break;
		case 1: set_egress_packet_vlan_tagged_0_1203294(); break;
		case 2: set_egress_packet_vlan_untagged_0_1203326(); break;
		default: NoAction_42_1203153(); break;
	}
	// size 512
	// default_action NoAction_42();
}


//Table
void outer_mac_1206333() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: nop_26_1203174(); break;
		case 1: rewrite_unicast_mac_0_1203347(); break;
		case 2: rewrite_multicast_mac_0_1298178(); break;
		default: NoAction_43_1203154(); break;
	}
	// size 512
	// default_action NoAction_43();
}


//Table
void rewrite_1206410() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: nop_27_1203175(); break;
		case 1: set_l2_rewrite_0_1203429(); break;
		case 2: set_ipv4_unicast_rewrite_0_1203445(); break;
		case 3: set_ipv4_vxlan_rewrite_0_1203486(); break;
		case 4: set_ipv4_geneve_rewrite_0_1203548(); break;
		case 5: set_ipv4_nvgre_rewrite_0_1203610(); break;
		case 6: set_ipv4_erspan_v2_rewrite_0_1203672(); break;
		default: NoAction_44_1203155(); break;
	}
	// size 512
	// default_action NoAction_44();
}


//Table
void rid_1206499() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: nop_28_1203176(); break;
		case 1: replica_from_rid_0_1203734(); break;
		default: NoAction_45_1203156(); break;
	}
	// size 512
	// default_action NoAction_45();
}


//Table
void tunnel_decap_1206558() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: decapsulate_vxlan_packet_inner_ipv4_udp_0_1203758(); break;
		case 1: decapsulate_vxlan_packet_inner_ipv4_tcp_0_1203838(); break;
		case 2: decapsulate_geneve_packet_inner_ipv4_udp_0_1203934(); break;
		case 3: decapsulate_geneve_packet_inner_ipv4_tcp_0_1204014(); break;
		case 4: decapsulate_nvgre_packet_inner_ipv4_udp_0_1204110(); break;
		case 5: decapsulate_nvgre_packet_inner_ipv4_tcp_0_1204198(); break;
		default: NoAction_46_1203157(); break;
	}
	// size 512
	// default_action NoAction_46();
}


//Table
void tunnel_dst_rewrite_1206677() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: rewrite_tunnel_ipv4_dst_0_1204294(); break;
		default: NoAction_47_1203158(); break;
	}
	// size 512
	// default_action NoAction_47();
}


//Table
void tunnel_rewrite_1206730() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: ipv4_vxlan_inner_ipv4_udp_rewrite_0_1204312(); break;
		case 1: ipv4_vxlan_inner_ipv4_tcp_rewrite_0_1204571(); break;
		case 2: ipv4_genv_inner_ipv4_udp_rewrite_0_1204809(); break;
		case 3: ipv4_genv_inner_ipv4_tcp_rewrite_0_1205078(); break;
		case 4: ipv4_nvgre_inner_ipv4_udp_rewrite_0_1205332(); break;
		case 5: ipv4_nvgre_inner_ipv4_tcp_rewrite_0_1205502(); break;
		case 6: ipv4_erspan_v2_inner_ipv4_udp_rewrite_0_1205664(); break;
		case 7: ipv4_erspan_v2_inner_ipv4_tcp_rewrite_0_1205823(); break;
		default: NoAction_48_1203159(); break;
	}
	// size 256
	// default_action NoAction_48();
}


//Table
void tunnel_src_rewrite_1206861() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: rewrite_tunnel_ipv4_src_0_1205976(); break;
		default: NoAction_49_1203160(); break;
	}
	// size 512
	// default_action NoAction_49();
}



typedef struct {
	uint32_t bd : 16;
	uint64_t lkp_mac_sa : 48;
	uint32_t ifindex : 10;
} mac_learn_digest;

//Control

void ingress() {
	if((meta.ingress_metadata.ingress_bypass == 0)) {
		validate_outer_ethernet_1211283();
	if((hdr.ipv4.isValid == 1)) {
	validate_outer_ipv4_packet_1211348();
}
	port_mapping_1210554();
	port_vlan_mapping_1210606();
	if((meta.ingress_metadata.stp_group != 0)) {
	spanning_tree_1210879();
}
	outer_rmac_1210483();
	if((hdr.ipv4.isValid == 1)) {
	ipv4_src_vtep_1209824();
}
	if((meta.ingress_metadata.lkp_pkt_type == 1)) {
	if(meta.ingress_metadata.lkp_ip_type == 1 && meta.ingress_metadata.ipv4_unicast_enabled == 1) {
	ipv4_dest_vtep_1209581();
}
}
	if(meta.ingress_metadata.src_vtep_miss == 0 && (meta.ingress_metadata.outer_rmac_hit == 1 && meta.ingress_metadata.tunnel_terminate == 1 || meta.ingress_metadata.lkp_pkt_type == 2 && meta.ingress_metadata.tunnel_terminate == 1)) {
	tunnel_1211206();
} else {
	bd_1_1208666();
}
	validate_packet_1211455();
	smac_1_1210802();
	learn_notify_1210073();
	mirror_acl_1210275();
	if((meta.ingress_metadata.lkp_ip_type == 0)) {
	mac_acl_1210156();
} else {
	if((meta.ingress_metadata.lkp_ip_type == 1)) {
	ip_acl_1209208();
}
}
	rmac_1210731(); 
	if(action_run == 1207735) { 
		dmac_1_1208719(); 
	} else {
 		 if (meta.ingress_metadata.lkp_ip_type == 1 && meta.ingress_metadata.ipv4_unicast_enabled == 1) {
                        ip_racl_1209438();
			ipv4_fib_1209676();
                        if (action_run == 1207725) {
                            ipv4_fib_lpm_1209753();
                        }

                    }

	}
	fwd_result_1208959();
	if((meta.ingress_metadata.ecmp_index != 0)) {
	ecmp_group_1208817();
} else {
	nexthop_1210418();
}
	lag_group_1209901();
	system_acl_1210944();

}
}

// Action
void NoAction_50_1207081() {
	action_run = 1207081;
	
}


// Action
void NoAction_51_1207082() {
	action_run = 1207082;
	
}


// Action
void NoAction_52_1207083() {
	action_run = 1207083;
	
}


// Action
void NoAction_53_1207084() {
	action_run = 1207084;
	
}


// Action
void NoAction_54_1207085() {
	action_run = 1207085;
	
}


// Action
void NoAction_55_1207086() {
	action_run = 1207086;
	
}


// Action
void NoAction_56_1207087() {
	action_run = 1207087;
	
}


// Action
void NoAction_57_1207088() {
	action_run = 1207088;
	
}


// Action
void NoAction_58_1207089() {
	action_run = 1207089;
	
}


// Action
void NoAction_59_1207090() {
	action_run = 1207090;
	
}


// Action
void NoAction_60_1207091() {
	action_run = 1207091;
	
}


// Action
void NoAction_61_1207092() {
	action_run = 1207092;
	
}


// Action
void NoAction_62_1207093() {
	action_run = 1207093;
	
}


// Action
void NoAction_63_1207094() {
	action_run = 1207094;
	
}


// Action
void NoAction_64_1207095() {
	action_run = 1207095;
	
}


// Action
void NoAction_65_1207096() {
	action_run = 1207096;
	
}


// Action
void NoAction_66_1207097() {
	action_run = 1207097;
	
}


// Action
void NoAction_67_1207098() {
	action_run = 1207098;
	
}


// Action
void NoAction_68_1207099() {
	action_run = 1207099;
	
}


// Action
void NoAction_69_1207100() {
	action_run = 1207100;
	
}


// Action
void NoAction_70_1207101() {
	action_run = 1207101;
	
}


// Action
void NoAction_71_1207102() {
	action_run = 1207102;
	
}


// Action
void NoAction_72_1207103() {
	action_run = 1207103;
	
}


// Action
void NoAction_73_1207104() {
	action_run = 1207104;
	
}


// Action
void NoAction_74_1207105() {
	action_run = 1207105;
	
}


// Action
void NoAction_75_1207106() {
	action_run = 1207106;
	
}


// Action
void set_bd_info_0_1207121() {
	action_run = 1207121;
	uint32_t vrf;
	klee_make_symbolic(&vrf, sizeof(vrf), "vrf");
uint32_t rmac_group;
	klee_make_symbolic(&rmac_group, sizeof(rmac_group), "rmac_group");
uint32_t bd_label;
	klee_make_symbolic(&bd_label, sizeof(bd_label), "bd_label");
uint32_t uuc_mc_index;
	klee_make_symbolic(&uuc_mc_index, sizeof(uuc_mc_index), "uuc_mc_index");
uint32_t bcast_mc_index;
	klee_make_symbolic(&bcast_mc_index, sizeof(bcast_mc_index), "bcast_mc_index");
uint32_t umc_mc_index;
	klee_make_symbolic(&umc_mc_index, sizeof(umc_mc_index), "umc_mc_index");
uint8_t ipv4_unicast_enabled;
	klee_make_symbolic(&ipv4_unicast_enabled, sizeof(ipv4_unicast_enabled), "ipv4_unicast_enabled");
uint8_t igmp_snooping_enabled;
	klee_make_symbolic(&igmp_snooping_enabled, sizeof(igmp_snooping_enabled), "igmp_snooping_enabled");
uint32_t stp_group;
	klee_make_symbolic(&stp_group, sizeof(stp_group), "stp_group");
	meta.ingress_metadata.vrf = vrf;
	meta.ingress_metadata.ipv4_unicast_enabled = ipv4_unicast_enabled;
	meta.ingress_metadata.igmp_snooping_enabled = igmp_snooping_enabled;
	meta.ingress_metadata.rmac_group = rmac_group;
	meta.ingress_metadata.uuc_mc_index = uuc_mc_index;
	meta.ingress_metadata.umc_mc_index = umc_mc_index;
	meta.ingress_metadata.bcast_mc_index = bcast_mc_index;
	meta.ingress_metadata.bd_label = bd_label;
	meta.ingress_metadata.stp_group = stp_group;

}


// Action
void nop_29_1207203() {
	action_run = 1207203;
	
}


// Action
void nop_30_1207213() {
	action_run = 1207213;
	
}


// Action
void nop_31_1207214() {
	action_run = 1207214;
	
}


// Action
void nop_32_1207215() {
	action_run = 1207215;
	
}


// Action
void nop_33_1207216() {
	action_run = 1207216;
	
}


// Action
void nop_34_1207217() {
	action_run = 1207217;
	
}


// Action
void nop_35_1207218() {
	action_run = 1207218;
	
}


// Action
void nop_36_1207219() {
	action_run = 1207219;
	
}


// Action
void nop_37_1207220() {
	action_run = 1207220;
	
}


// Action
void nop_38_1207221() {
	action_run = 1207221;
	
}


// Action
void nop_39_1207222() {
	action_run = 1207222;
	
}


// Action
void nop_40_1207223() {
	action_run = 1207223;
	
}


// Action
void nop_41_1207224() {
	action_run = 1207224;
	
}


// Action
void nop_42_1207225() {
	action_run = 1207225;
	
}


// Action
void nop_43_1207226() {
	action_run = 1207226;
	
}


// Action
void dmac_hit_0_1207227() {
	action_run = 1207227;
	uint32_t ifindex;
	klee_make_symbolic(&ifindex, sizeof(ifindex), "ifindex");
	meta.ingress_metadata.egress_ifindex = ifindex;
	meta.ingress_metadata.egress_bd = meta.ingress_metadata.bd;

}


// Action
void dmac_multicast_hit_0_1207254() {
	action_run = 1207254;
	uint32_t mc_index;
	klee_make_symbolic(&mc_index, sizeof(mc_index), "mc_index");
	meta.intrinsic_metadata.eg_mcast_group = mc_index;
	meta.ingress_metadata.egress_bd = meta.ingress_metadata.bd;

}


// Action
void dmac_miss_0_1207281() {
	action_run = 1207281;
		meta.intrinsic_metadata.eg_mcast_group = meta.ingress_metadata.uuc_mc_index;

}


// Action
void dmac_redirect_nexthop_0_1207300() {
	action_run = 1207300;
	uint32_t nexthop_index;
	klee_make_symbolic(&nexthop_index, sizeof(nexthop_index), "nexthop_index");
	meta.ingress_metadata.l2_redirect = 1;
	meta.ingress_metadata.l2_nexthop = nexthop_index;

}


// Action
void dmac_redirect_ecmp_0_1207324() {
	action_run = 1207324;
	uint32_t ecmp_index;
	klee_make_symbolic(&ecmp_index, sizeof(ecmp_index), "ecmp_index");
	meta.ingress_metadata.l2_redirect = 1;
	meta.ingress_metadata.l2_ecmp = ecmp_index;

}


// Action
void set_ecmp_nexthop_details_0_1207348() {
	action_run = 1207348;
	uint32_t ifindex;
	klee_make_symbolic(&ifindex, sizeof(ifindex), "ifindex");
uint32_t bd;
	klee_make_symbolic(&bd, sizeof(bd), "bd");
uint32_t nhop_index;
	klee_make_symbolic(&nhop_index, sizeof(nhop_index), "nhop_index");
	meta.ingress_metadata.egress_ifindex = ifindex;
	meta.ingress_metadata.egress_bd = bd;
	meta.ingress_metadata.nexthop_index = nhop_index;

}


// Action
void set_ecmp_nexthop_details_for_post_routed_flood_0_1207382() {
	action_run = 1207382;
	uint32_t bd;
	klee_make_symbolic(&bd, sizeof(bd), "bd");
uint32_t uuc_mc_index;
	klee_make_symbolic(&uuc_mc_index, sizeof(uuc_mc_index), "uuc_mc_index");
uint32_t nhop_index;
	klee_make_symbolic(&nhop_index, sizeof(nhop_index), "nhop_index");
	meta.intrinsic_metadata.eg_mcast_group = uuc_mc_index;
	meta.ingress_metadata.egress_bd = bd;
	meta.ingress_metadata.nexthop_index = nhop_index;

}


// Action
void set_l2_redirect_action_0_1207416() {
	action_run = 1207416;
		meta.ingress_metadata.nexthop_index = meta.ingress_metadata.l2_nexthop;
	meta.ingress_metadata.ecmp_index = meta.ingress_metadata.l2_ecmp;
	meta.ingress_metadata.ttl = meta.ingress_metadata.lkp_ip_ttl;

}


// Action
void set_acl_redirect_action_0_1207453() {
	action_run = 1207453;
		meta.ingress_metadata.nexthop_index = meta.ingress_metadata.acl_nexthop;
	meta.ingress_metadata.ecmp_index = meta.ingress_metadata.acl_ecmp;

}


// Action
void set_racl_redirect_action_0_1207481() {
	action_run = 1207481;
		meta.ingress_metadata.nexthop_index = meta.ingress_metadata.racl_nexthop;
	meta.ingress_metadata.ecmp_index = meta.ingress_metadata.racl_ecmp;
	meta.ingress_metadata.routed = 1;
	meta.ingress_metadata.ttl = meta.ingress_metadata.lkp_ip_ttl;
	meta.ingress_metadata.ttl = meta.ingress_metadata.ttl + 255;

}


// Action
void set_fib_redirect_action_0_1207535() {
	action_run = 1207535;
		meta.ingress_metadata.nexthop_index = meta.ingress_metadata.fib_nexthop;
	meta.ingress_metadata.ecmp_index = meta.ingress_metadata.fib_ecmp;
	meta.ingress_metadata.routed = 1;
	meta.ingress_metadata.ttl = meta.ingress_metadata.lkp_ip_ttl;
	meta.ingress_metadata.ttl = meta.ingress_metadata.ttl + 255;

}


// Action
void acl_log_1_1207589() {
	action_run = 1207589;
	
}


// Action
void acl_deny_1_1207599() {
	action_run = 1207599;
		meta.ingress_metadata.acl_deny = 1;

}


// Action
void acl_permit_1_1207615() {
	action_run = 1207615;
	
}


// Action
void racl_log_0_1207625() {
	action_run = 1207625;
	
}


// Action
void racl_deny_0_1207635() {
	action_run = 1207635;
		meta.ingress_metadata.racl_deny = 1;

}


// Action
void racl_permit_0_1207651() {
	action_run = 1207651;
	
}


// Action
void racl_redirect_nexthop_0_1207661() {
	action_run = 1207661;
	uint32_t nexthop_index;
	klee_make_symbolic(&nexthop_index, sizeof(nexthop_index), "nexthop_index");
	meta.ingress_metadata.racl_redirect = 1;
	meta.ingress_metadata.racl_nexthop = nexthop_index;

}


// Action
void racl_redirect_ecmp_0_1207685() {
	action_run = 1207685;
	uint32_t ecmp_index;
	klee_make_symbolic(&ecmp_index, sizeof(ecmp_index), "ecmp_index");
	meta.ingress_metadata.racl_redirect = 1;
	meta.ingress_metadata.racl_ecmp = ecmp_index;

}


// Action
void set_tunnel_termination_flag_0_1207709() {
	action_run = 1207709;
		meta.ingress_metadata.tunnel_terminate = 1;

}


// Action
void on_miss_1_1207725() {
	action_run = 1207725;
	
}


// Action
void on_miss_4_1207735() {
	action_run = 1207735;
	
}


// Action
void fib_hit_nexthop_0_1207736() {
	action_run = 1207736;
	uint32_t nexthop_index;
	klee_make_symbolic(&nexthop_index, sizeof(nexthop_index), "nexthop_index");
	meta.ingress_metadata.fib_hit = 1;
	meta.ingress_metadata.fib_nexthop = nexthop_index;

}


// Action
void fib_hit_nexthop_2_1207760() {
	action_run = 1207760;
	uint32_t nexthop_index;
	klee_make_symbolic(&nexthop_index, sizeof(nexthop_index), "nexthop_index");
	meta.ingress_metadata.fib_hit = 1;
	meta.ingress_metadata.fib_nexthop = nexthop_index;

}


// Action
void fib_hit_ecmp_0_1207778() {
	action_run = 1207778;
	uint32_t ecmp_index;
	klee_make_symbolic(&ecmp_index, sizeof(ecmp_index), "ecmp_index");
	meta.ingress_metadata.fib_hit = 1;
	meta.ingress_metadata.fib_ecmp = ecmp_index;

}


// Action
void fib_hit_ecmp_2_1207802() {
	action_run = 1207802;
	uint32_t ecmp_index;
	klee_make_symbolic(&ecmp_index, sizeof(ecmp_index), "ecmp_index");
	meta.ingress_metadata.fib_hit = 1;
	meta.ingress_metadata.fib_ecmp = ecmp_index;

}


// Action
void set_tunnel_lif_0_1207820() {
	action_run = 1207820;
	uint32_t lif;
	klee_make_symbolic(&lif, sizeof(lif), "lif");
	meta.ingress_metadata.tunnel_lif = lif;

}


// Action
void set_src_vtep_miss_flag_0_1207838() {
	action_run = 1207838;
		meta.ingress_metadata.src_vtep_miss = 1;

}


// Action
void set_lag_port_0_1207854() {
	action_run = 1207854;
	uint32_t port;
	klee_make_symbolic(&port, sizeof(port), "port");
	standard_metadata.egress_spec = port;

}


// Action
void generate_learn_notify_0_1207871() {
	action_run = 1207871;
		digest();

}


// Action
void set_mirror_id_0_1207904() {
	action_run = 1207904;
	uint32_t session_id;
	klee_make_symbolic(&session_id, sizeof(session_id), "session_id");
	clone();

}


// Action
void set_nexthop_details_0_1207927() {
	action_run = 1207927;
	uint32_t ifindex;
	klee_make_symbolic(&ifindex, sizeof(ifindex), "ifindex");
uint32_t bd;
	klee_make_symbolic(&bd, sizeof(bd), "bd");
	meta.ingress_metadata.egress_ifindex = ifindex;
	meta.ingress_metadata.egress_bd = bd;

}


// Action
void set_nexthop_details_for_post_routed_flood_0_1207953() {
	action_run = 1207953;
	uint32_t bd;
	klee_make_symbolic(&bd, sizeof(bd), "bd");
uint32_t uuc_mc_index;
	klee_make_symbolic(&uuc_mc_index, sizeof(uuc_mc_index), "uuc_mc_index");
	meta.intrinsic_metadata.eg_mcast_group = uuc_mc_index;
	meta.ingress_metadata.egress_bd = bd;

}


// Action
void set_outer_rmac_hit_flag_0_1207979() {
	action_run = 1207979;
		meta.ingress_metadata.outer_rmac_hit = 1;

}


// Action
void set_ifindex_0_1207995() {
	action_run = 1207995;
	uint32_t ifindex;
	klee_make_symbolic(&ifindex, sizeof(ifindex), "ifindex");
uint32_t if_label;
	klee_make_symbolic(&if_label, sizeof(if_label), "if_label");
	meta.ingress_metadata.ifindex = ifindex;
	meta.ingress_metadata.if_label = if_label;

}


// Action
void set_bd_0_1208021() {
	action_run = 1208021;
	uint32_t outer_vlan_bd;
	klee_make_symbolic(&outer_vlan_bd, sizeof(outer_vlan_bd), "outer_vlan_bd");
uint32_t vrf;
	klee_make_symbolic(&vrf, sizeof(vrf), "vrf");
uint32_t rmac_group;
	klee_make_symbolic(&rmac_group, sizeof(rmac_group), "rmac_group");
uint8_t ipv4_unicast_enabled;
	klee_make_symbolic(&ipv4_unicast_enabled, sizeof(ipv4_unicast_enabled), "ipv4_unicast_enabled");
uint32_t stp_group;
	klee_make_symbolic(&stp_group, sizeof(stp_group), "stp_group");
	meta.ingress_metadata.vrf = vrf;
	meta.ingress_metadata.ipv4_unicast_enabled = ipv4_unicast_enabled;
	meta.ingress_metadata.outer_rmac_group = rmac_group;
	meta.ingress_metadata.bd = outer_vlan_bd;
	meta.ingress_metadata.stp_group = stp_group;

}


// Action
void set_rmac_hit_flag_0_1208071() {
	action_run = 1208071;
		meta.ingress_metadata.rmac_hit = 1;

}


// Action
void smac_miss_0_1208087() {
	action_run = 1208087;
		meta.ingress_metadata.l2_src_miss = 1;

}


// Action
void smac_hit_0_1228079() {
	action_run = 1228079;
	uint32_t ifindex;
	klee_make_symbolic(&ifindex, sizeof(ifindex), "ifindex");
	meta.ingress_metadata.l2_src_move = meta.ingress_metadata.ifindex ^ ifindex;
 

}


// Action
void set_stp_state_0_1208135() {
	action_run = 1208135;
	uint8_t stp_state;
	klee_make_symbolic(&stp_state, sizeof(stp_state), "stp_state");
	meta.ingress_metadata.stp_state = stp_state;

}


// Action
void redirect_to_cpu_0_1208153() {
	action_run = 1208153;
		standard_metadata.egress_spec = 250;
	meta.intrinsic_metadata.eg_mcast_group = 0;

}


// Action
void copy_to_cpu_0_1208174() {
	action_run = 1208174;
		clone();

}


// Action
void drop_packet_0_1208195() {
	action_run = 1208195;
		meta.intrinsic_metadata.eg_mcast_group = 0;
	mark_to_drop();

}


// Action
void terminate_tunnel_inner_ipv4_0_1208217() {
	action_run = 1208217;
	uint32_t bd;
	klee_make_symbolic(&bd, sizeof(bd), "bd");
uint32_t vrf;
	klee_make_symbolic(&vrf, sizeof(vrf), "vrf");
uint32_t rmac_group;
	klee_make_symbolic(&rmac_group, sizeof(rmac_group), "rmac_group");
uint32_t bd_label;
	klee_make_symbolic(&bd_label, sizeof(bd_label), "bd_label");
uint32_t uuc_mc_index;
	klee_make_symbolic(&uuc_mc_index, sizeof(uuc_mc_index), "uuc_mc_index");
uint32_t bcast_mc_index;
	klee_make_symbolic(&bcast_mc_index, sizeof(bcast_mc_index), "bcast_mc_index");
uint32_t umc_mc_index;
	klee_make_symbolic(&umc_mc_index, sizeof(umc_mc_index), "umc_mc_index");
uint8_t ipv4_unicast_enabled;
	klee_make_symbolic(&ipv4_unicast_enabled, sizeof(ipv4_unicast_enabled), "ipv4_unicast_enabled");
uint8_t igmp_snooping_enabled;
	klee_make_symbolic(&igmp_snooping_enabled, sizeof(igmp_snooping_enabled), "igmp_snooping_enabled");
	meta.ingress_metadata.bd = bd;
	meta.ingress_metadata.vrf = vrf;
	meta.ingress_metadata.outer_dscp = meta.ingress_metadata.lkp_ip_tc;
	meta.ingress_metadata.outer_ttl = meta.ingress_metadata.lkp_ip_ttl;
	meta.ingress_metadata.outer_ttl = meta.ingress_metadata.outer_ttl + 255;
	meta.ingress_metadata.lkp_mac_sa = hdr.inner_ethernet.srcAddr;
	meta.ingress_metadata.lkp_mac_da = hdr.inner_ethernet.dstAddr;
	meta.ingress_metadata.lkp_ip_type = 1;
	meta.ingress_metadata.lkp_ipv4_sa = hdr.inner_ipv4.srcAddr;
	meta.ingress_metadata.lkp_ipv4_da = hdr.inner_ipv4.dstAddr;
	meta.ingress_metadata.lkp_ip_proto = hdr.inner_ipv4.protocol;
	meta.ingress_metadata.lkp_ip_tc = hdr.inner_ipv4.diffserv;
	meta.ingress_metadata.lkp_l4_sport = meta.ingress_metadata.lkp_inner_l4_sport;
	meta.ingress_metadata.lkp_l4_dport = meta.ingress_metadata.lkp_inner_l4_dport;
	meta.ingress_metadata.ipv4_unicast_enabled = ipv4_unicast_enabled;
	meta.ingress_metadata.igmp_snooping_enabled = igmp_snooping_enabled;
	meta.ingress_metadata.rmac_group = rmac_group;
	meta.ingress_metadata.uuc_mc_index = uuc_mc_index;
	meta.ingress_metadata.umc_mc_index = umc_mc_index;
	meta.ingress_metadata.bcast_mc_index = bcast_mc_index;
	meta.ingress_metadata.bd_label = bd_label;
	meta.ingress_metadata.l3_length = hdr.inner_ipv4.totalLen;

}


// Action
void set_valid_outer_unicast_packet_0_1208415() {
	action_run = 1208415;
		meta.ingress_metadata.lkp_pkt_type = 1;
	meta.ingress_metadata.lkp_mac_sa = hdr.ethernet.srcAddr;
	meta.ingress_metadata.lkp_mac_da = hdr.ethernet.dstAddr;
	meta.ingress_metadata.lkp_mac_type = hdr.ethernet.etherType;

}


// Action
void set_valid_outer_multicast_packet_0_1208458() {
	action_run = 1208458;
		meta.ingress_metadata.lkp_pkt_type = 2;
	meta.ingress_metadata.lkp_mac_sa = hdr.ethernet.srcAddr;
	meta.ingress_metadata.lkp_mac_da = hdr.ethernet.dstAddr;
	meta.ingress_metadata.lkp_mac_type = hdr.ethernet.etherType;

}


// Action
void set_valid_outer_broadcast_packet_0_1208501() {
	action_run = 1208501;
		meta.ingress_metadata.lkp_pkt_type = 4;
	meta.ingress_metadata.lkp_mac_sa = hdr.ethernet.srcAddr;
	meta.ingress_metadata.lkp_mac_da = hdr.ethernet.dstAddr;
	meta.ingress_metadata.lkp_mac_type = hdr.ethernet.etherType;

}


// Action
void set_valid_outer_ipv4_packet_0_1208544() {
	action_run = 1208544;
		meta.ingress_metadata.lkp_ip_type = 1;
	meta.ingress_metadata.lkp_ipv4_sa = hdr.ipv4.srcAddr;
	meta.ingress_metadata.lkp_ipv4_da = hdr.ipv4.dstAddr;
	meta.ingress_metadata.lkp_ip_proto = hdr.ipv4.protocol;
	meta.ingress_metadata.lkp_ip_tc = hdr.ipv4.diffserv;
	meta.ingress_metadata.lkp_ip_ttl = hdr.ipv4.ttl;
	meta.ingress_metadata.l3_length = hdr.ipv4.totalLen;

}


// Action
void set_malformed_outer_ipv4_packet_0_1208614() {
	action_run = 1208614;
	
}


// Action
void set_l2_multicast_0_1208624() {
	action_run = 1208624;
		meta.ingress_metadata.l2_multicast = 1;

}


// Action
void set_src_is_link_local_0_1208640() {
	action_run = 1208640;
		meta.ingress_metadata.src_is_link_local = 1;

}


// Action
void set_malformed_packet_0_1208656() {
	action_run = 1208656;
	
}


// Action
void nop_44_1209072() {
	action_run = 1209072;
	
}


// Action
void acl_log_2_1209089() {
	action_run = 1209089;
	
}


// Action
void acl_deny_2_1209106() {
	action_run = 1209106;
		meta.ingress_metadata.acl_deny = 1;

}


// Action
void acl_permit_2_1209129() {
	action_run = 1209129;
	
}


// Action
void acl_redirect_nexthop_1209146() {
	action_run = 1209146;
	uint32_t nexthop_index;
	klee_make_symbolic(&nexthop_index, sizeof(nexthop_index), "nexthop_index");
	meta.ingress_metadata.acl_redirect = 1;
	meta.ingress_metadata.acl_nexthop = nexthop_index;

}


// Action
void acl_redirect_ecmp_1209177() {
	action_run = 1209177;
	uint32_t ecmp_index;
	klee_make_symbolic(&ecmp_index, sizeof(ecmp_index), "ecmp_index");
	meta.ingress_metadata.acl_redirect = 1;
	meta.ingress_metadata.acl_ecmp = ecmp_index;

}


//Table
void bd_1_1208666() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: set_bd_info_0_1207121(); break;
		default: NoAction_50_1207081(); break;
	}
	// size 512
	// default_action NoAction_50();
}


//Table
void dmac_1_1208719() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: nop_29_1207203(); break;
		case 1: dmac_hit_0_1207227(); break;
		case 2: dmac_multicast_hit_0_1207254(); break;
		case 3: dmac_miss_0_1207281(); break;
		case 4: dmac_redirect_nexthop_0_1207300(); break;
		case 5: dmac_redirect_ecmp_0_1207324(); break;
		default: NoAction_51_1207082(); break;
	}
	// size 512
	// default_action NoAction_51();
}


//Table
void ecmp_group_1208817() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: nop_30_1207213(); break;
		case 1: set_ecmp_nexthop_details_0_1207348(); break;
		case 2: set_ecmp_nexthop_details_for_post_routed_flood_0_1207382(); break;
		default: NoAction_52_1207083(); break;
	}
	// size 512
	// default_action NoAction_52();
}


//Table
void fwd_result_1208959() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: nop_31_1207214(); break;
		case 1: set_l2_redirect_action_0_1207416(); break;
		case 2: set_acl_redirect_action_0_1207453(); break;
		case 3: set_racl_redirect_action_0_1207481(); break;
		case 4: set_fib_redirect_action_0_1207535(); break;
		default: NoAction_53_1207084(); break;
	}
	// size 512
	// default_action NoAction_53();
}


//Table
void ip_acl_1209208() {
	traverse_ip_acl = 1;
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: nop_44_1209072(); break;
		case 1: acl_log_2_1209089(); break;
		case 2: acl_deny_2_1209106(); break;
		case 3: acl_permit_2_1209129(); break;
		case 4: acl_redirect_nexthop_1209146(); break;
		case 5: acl_redirect_ecmp_1209177(); break;
		default: NoAction_54_1207085(); break;
	}
	// size 512
	// default_action NoAction_54();
}


//Table
void ip_racl_1209438() {
        traverse_ip_racl = 1;
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: nop_32_1207215(); break;
		case 1: racl_log_0_1207625(); break;
		case 2: racl_deny_0_1207635(); break;
		case 3: racl_permit_0_1207651(); break;
		case 4: racl_redirect_nexthop_0_1207661(); break;
		case 5: racl_redirect_ecmp_0_1207685(); break;
		default: NoAction_55_1207086(); break;
	}
	// size 512
	// default_action NoAction_55();
}


//Table
void ipv4_dest_vtep_1209581() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: nop_33_1207216(); break;
		case 1: set_tunnel_termination_flag_0_1207709(); break;
		default: NoAction_56_1207087(); break;
	}
	// size 512
	// default_action NoAction_56();
}


//Table
void ipv4_fib_1209676() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: on_miss_1_1207725(); break;
		case 1: fib_hit_nexthop_0_1207736(); break;
		case 2: fib_hit_ecmp_0_1207778(); break;
		default: NoAction_57_1207088(); break;
	}
	// size 512
	// default_action NoAction_57();
}


//Table
void ipv4_fib_lpm_1209753() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: fib_hit_nexthop_2_1207760(); break;
		case 1: fib_hit_ecmp_2_1207802(); break;
		default: NoAction_58_1207089(); break;
	}
	// size 512
	// default_action NoAction_58();
}


//Table
void ipv4_src_vtep_1209824() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: nop_34_1207217(); break;
		case 1: set_tunnel_lif_0_1207820(); break;
		case 2: set_src_vtep_miss_flag_0_1207838(); break;
		default: NoAction_59_1207090(); break;
	}
	// size 512
	// default_action NoAction_59();
}


//Table
void lag_group_1209901() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: nop_35_1207218(); break;
		case 1: set_lag_port_0_1207854(); break;
		default: NoAction_60_1207091(); break;
	}
	// size 512
	// default_action NoAction_60();
}


//Table
void learn_notify_1210073() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: nop_36_1207219(); break;
		case 1: generate_learn_notify_0_1207871(); break;
		default: NoAction_61_1207092(); break;
	}
	// size 512
	// default_action NoAction_61();
}


//Table
void mac_acl_1210156() {
	traverse_mac_acl = 1;
        int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: nop_37_1207220(); break;
		case 1: acl_log_1_1207589(); break;
		case 2: acl_deny_1_1207599(); break;
		case 3: acl_permit_1_1207615(); break;
		default: NoAction_62_1207093(); break;
	}
	// size 512
	// default_action NoAction_62();
}


//Table
void mirror_acl_1210275() {
	traverse_mirror_acl = 1;
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: nop_38_1207221(); break;
		case 1: set_mirror_id_0_1207904(); break;
		default: NoAction_63_1207094(); break;
	}
	// size 512
	// default_action NoAction_63();
}


//Table
void nexthop_1210418() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: nop_39_1207222(); break;
		case 1: set_nexthop_details_0_1207927(); break;
		case 2: set_nexthop_details_for_post_routed_flood_0_1207953(); break;
		default: NoAction_64_1207095(); break;
	}
	// size 512
	// default_action NoAction_64();
}


//Table
void outer_rmac_1210483() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: nop_40_1207223(); break;
		case 1: set_outer_rmac_hit_flag_0_1207979(); break;
		default: NoAction_65_1207096(); break;
	}
	// size 256
	// default_action NoAction_65();
}


//Table
void port_mapping_1210554() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: set_ifindex_0_1207995(); break;
		default: NoAction_66_1207097(); break;
	}
	// size 258
	// default_action NoAction_66();
}


//Table
void port_vlan_mapping_1210606() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: set_bd_0_1208021(); break;
		default: NoAction_67_1207098(); break;
	}
	// size 512
	// default_action NoAction_67();
}


//Table
void rmac_1210731() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: on_miss_4_1207735(); break;
		case 1: set_rmac_hit_flag_0_1208071(); break;
		default: NoAction_68_1207099(); break;
	}
	// size 512
	// default_action NoAction_68();
}


//Table
void smac_1_1210802() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: nop_41_1207224(); break;
		case 1: smac_miss_0_1208087(); break;
		case 2: smac_hit_0_1228079(); break;
		default: NoAction_69_1207100(); break;
	}
	// size 512
	// default_action NoAction_69();
}


//Table
void spanning_tree_1210879() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: set_stp_state_0_1208135(); break;
		default: NoAction_70_1207101(); break;
	}
	// size 512
	// default_action NoAction_70();
}


//Table
void system_acl_1210944() {
        traverse_system_acl = 1;
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: nop_42_1207225(); break;
		case 1: redirect_to_cpu_0_1208153(); break;
		case 2: copy_to_cpu_0_1208174(); break;
		case 3: drop_packet_0_1208195(); break;
		default: NoAction_71_1207102(); break;
	}
	// size 256
	// default_action NoAction_71();
}


//Table
void tunnel_1211206() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: terminate_tunnel_inner_ipv4_0_1208217(); break;
		default: NoAction_72_1207103(); break;
	}
	// size 512
	// default_action NoAction_72();
}


//Table
void validate_outer_ethernet_1211283() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: set_valid_outer_unicast_packet_0_1208415(); break;
		case 1: set_valid_outer_multicast_packet_0_1208458(); break;
		case 2: set_valid_outer_broadcast_packet_0_1208501(); break;
		default: NoAction_73_1207104(); break;
	}
	// size 64
	// default_action NoAction_73();
}


//Table
void validate_outer_ipv4_packet_1211348() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: set_valid_outer_ipv4_packet_0_1208544(); break;
		case 1: set_malformed_outer_ipv4_packet_0_1208614(); break;
		default: NoAction_74_1207105(); break;
	}
	// size 64
	// default_action NoAction_74();
}


//Table
void validate_packet_1211455() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: nop_43_1207226(); break;
		case 1: set_l2_multicast_0_1208624(); break;
		case 2: set_src_is_link_local_0_1208640(); break;
		case 3: set_malformed_packet_0_1208656(); break;
		default: NoAction_75_1207106(); break;
	}
	// size 64
	// default_action NoAction_75();
}



//Control

void DeparserImpl() {
	//Emit hdr.ethernet
	
	//Emit hdr.cpu_header
	
	//Emit hdr.fcoe
	
	//Emit hdr.roce
	
	//Emit hdr.vlan_tag__0
	
	//Emit hdr.vlan_tag__1
	
	//Emit hdr.arp_rarp
	
	//Emit hdr.arp_rarp_ipv4
	
	//Emit hdr.ipv6
	
	//Emit hdr.icmpv6
	
	//Emit hdr.ipv4
	
	//Emit hdr.gre
	
	//Emit hdr.nsh
	
	//Emit hdr.nsh_context
	
	//Emit hdr.erspan_v2_header
	
	//Emit hdr.erspan_v1_header
	
	//Emit hdr.nvgre
	
	//Emit hdr.udp
	
	//Emit hdr.roce_v2
	
	//Emit hdr.genv
	
	//Emit hdr.vxlan
	
	//Emit hdr.inner_ethernet
	
	//Emit hdr.inner_ipv6
	
	//Emit hdr.inner_icmpv6
	
	//Emit hdr.inner_ipv4
	
	//Emit hdr.inner_udp
	
	//Emit hdr.inner_tcp
	
	//Emit hdr.inner_icmp
	
	//Emit hdr.tcp
	
	//Emit hdr.icmp
	
	//Emit hdr.snap_header
	
}


typedef struct {
	uint8_t field_5 : 4;
	uint8_t field_6 : 4;
	uint8_t field_7 : 8;
	uint32_t field_8 : 16;
	uint32_t field_9 : 16;
	uint8_t field_10 : 3;
	uint32_t field_11 : 13;
	uint8_t field_12 : 8;
	uint8_t field_13 : 8;
	uint32_t field_14 : 32;
	uint32_t field_15 : 32;
} tuple_1;

//Control
uint8_t tmp_14;
uint32_t tmp_15;
uint32_t tmp_17;

void verifyChecksum() {
	if((hdr.ipv4.isValid != 1)) {
	tmp_14 = 0;
} else {
			klee_make_symbolic(&tmp_15, sizeof(tmp_15), "tmp_15");

	tmp_14 = (hdr.inner_ipv4.hdrChecksum == tmp_15);

}
	if(tmp_14) {
	mark_to_drop();
}
		klee_make_symbolic(&tmp_17, sizeof(tmp_17), "tmp_17");

	if((hdr.ipv4.hdrChecksum == tmp_17)) {
	mark_to_drop();
}
}


//Control
uint32_t tmp_19;
uint32_t tmp_20;

void computeChecksum() {
	if((hdr.ipv4.isValid == 1)) {
			klee_make_symbolic(&tmp_19, sizeof(tmp_19), "tmp_19");

	hdr.inner_ipv4.hdrChecksum = tmp_19;

}
		klee_make_symbolic(&tmp_20, sizeof(tmp_20), "tmp_20");

	hdr.ipv4.hdrChecksum = tmp_20;
}


int main() {
	ParserImpl();
	ingress();
	//egress();
	DeparserImpl();
	if((meta.ingress_metadata.ingress_bypass == 0) && !traverse_mirror_acl){
		printf("ASSERT ERROR: mirror ACL not traversed\n");
	}
	if((meta.ingress_metadata.ingress_bypass == 0) && !traverse_mac_acl){
		printf("ASSERT ERROR: mac ACL not traversed\n");
	}
	if( hdr.ipv4.isValid && (meta.ingress_metadata.ingress_bypass == 0) && !traverse_ip_acl){
		printf("ASSERT ERROR: ip ACL not traversed\n");
	}
	if(hdr.ipv4.isValid && (meta.ingress_metadata.ingress_bypass == 0) && !traverse_ip_racl){
		printf("ASSERT ERROR: ip RACL not traversed\n");
	}
	if((meta.ingress_metadata.ingress_bypass == 0) && !traverse_system_acl){
		printf("ASSERT ERROR: system ACL not traversed\n");
	}
	if((meta.egress_metadata.egress_bypass == 0) && !traverse_egress_acl){
		printf("ASSERT ERROR: egress ACL not traversed\n");
	}
	endAssertions();
	return 0;
}

void endAssertions(){

	exit(0);
}

void clone(){
	//printf("packet cloned!");
}


