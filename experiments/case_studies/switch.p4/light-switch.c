#define BITSLICE(x, a, b) ((x) >> (b)) & ((1 << ((a)-(b)+1)) - 1)
#include<stdio.h>
#include<stdint.h>
#include<stdlib.h>

int assert_forward = 1;
int action_run;

int traverse_2101150 = 0;
int emit_header_vlan_tag_[0]_2101150 = 0;
int traverse_2101190 = 0;
int emit_header_vlan_tag_[0]) && !emit(vlan_tag_[1]_2101190 = 0;
int traverse_2104798 = 0;int traverse_2106375 = 0;
?? constant_l3_metadata_nexthop_index_2106375;

void _set_nat_src_dst_rewrite_2101760();
void _terminate_cpu_packet_0_2104521();
void _set_nat_src_udp_rewrite_2101801();
void parse_inner_udp();
void parse_ethernet();
void _drop_packet_2102412();
void NoAction_34_2100845();
void parse_tcp();
void _egress_mirror_drop_2102651();
void _set_valid_outer_broadcast_packet_single_tagged_2103654();
void _set_valid_outer_multicast_packet_qinq_tagged_2103592();
void NoAction_45_2103009();
void _set_dst_nat_nexthop_index_2_2105008();
void _set_nexthop_details_for_post_routed_flood_2106527();
void _set_l3_rewrite_2101400();
void _set_multicast_2104694();
void _system_acl_0_2107331();
void NoAction_54_2103018();
void _port_vlan_mapping_miss_2104307();
void NoAction_44_2103008();
void _meter_deny_2105785();
void rmac_miss_0_2103040();
void _set_lag_miss_2106722();
void _ingress_port_mapping_0_2103219();
void _egress_bd_map_0_2101623();
void _set_unicast_2104656();
void _set_src_nat_rewrite_index_2_2105070();
void NoAction_51_2103015();
void _set_nat_dst_rewrite_2101727();
void _copy_to_cpu_with_reason_2107056();
void _egress_mirror_2102608();
void _set_valid_outer_unicast_packet_single_tagged_2103370();
void NoAction_50_2103014();
void parse_fabric_header_cpu();
void _drop_stats_update_2106883();
void NoAction_55_2103019();
void NoAction_35_2100846();
void NoAction_59_2103023();
void _nat_twice_0_2105452();
void _egress_redirect_to_cpu_with_reason_2102557();
void NoAction_43_2103007();
void _meter_permit_2105775();
void _set_valid_outer_broadcast_packet_double_tagged_2103694();
void parse_fabric_payload_header();
void _set_valid_outer_unicast_packet_untagged_2103345();
void NoAction_0_2100832();
void parse_sflow();
void _egress_redirect_to_cpu_2102469();
void _set_unicast_and_ipv6_src_is_link_local_2104672();
void _set_nexthop_details_2106471();
void _ingress_port_properties_0_2103271();
void _ipv4_lkp_2104048();
void NoAction_40_2103004();
void _set_l2_redirect_action_2105880();
void _mirror_0_2101059();
void _set_ecmp_nexthop_details_2106355();
void parse_set_prio_med();
void _nexthop_0_2106659();
void _on_miss_3_2104966();
void _redirect_to_cpu_2106984();
void _set_valid_outer_broadcast_packet_untagged_2103629();
void _set_acl_redirect_action_2105999();
void _set_ifindex_2103127();
void _drop_packet_0_2107210();
void _adjust_lkp_fields_0_2104323();
void _set_egress_packet_vlan_tagged_2102196();
void _vlan_decap_0_2101225();
void parse_icmp();
void _port_vlan_mapping_0_2104388();
void _copy_to_cpu_2106915();
void _set_nat_src_rewrite_2101692();
void _set_nat_src_dst_tcp_rewrite_2102022();
void _set_dst_nat_nexthop_index_2104968();
void parse_qinq_vlan();
void parse_set_prio_high();
void _nop_26_2106905();
void _nop_11_2106344();
void rmac_2103056();
void parse_ipv6();
void parse_ipv4();
void parse_inner_icmp();
void _set_malformed_packet_2104781();
void _egress_system_acl_0_2102697();
void egress_port_type_cpu_0_2100919();
void parse_udp();
void _compute_other_hashes_0_2105720();
void NoAction_48_2103012();
void parse_ipv4_in_ip();
void _fwd_result_0_2106125();
void NoAction_38_2103002();
void _set_nat_redirect_action_2106085();
void _on_miss_4_2104967();
void egress_port_mapping_2100949();
void _set_valid_outer_multicast_packet_double_tagged_2103552();
void _set_mirror_bd_2101041();
void NoAction_52_2103016();
void _nop_9_2105575();
void _switch_config_params_0_2103982();
void _set_bd_properties_2104130();
void _set_valid_outer_unicast_packet_double_tagged_2103410();
void _set_twice_nat_nexthop_index_2105083();
void parse_snap_header();
void parse_qinq();
void NoAction_42_2103006();
void _meter_index_2_2105596();
void _egress_copy_to_cpu_2102428();
void _drop_stats_4_2107293();
void _nat_dst_0_2105157();
void _redirect_to_cpu_with_reason_2107130();
void _malformed_outer_ethernet_packet_2103321();
void NoAction_57_2103021();
void _set_egress_bd_properties_2101589();
void _non_ip_lkp_2104020();
void _nop_7_2104646();
void start();
void _nop_5_2102402();
void _nop_2_2101306();
void _nat_src_0_2105365();
void _set_config_parameters_2103932();
void _remove_vlan_double_tagged_2101174();
void _egress_copy_to_cpu_with_reason_2102512();
void _nop_6_2104511();
void _set_cpu_redirect_action_2105966();
void _negative_mirror_2107252();
void _nat_flow_0_2105246();
void _set_nat_dst_tcp_rewrite_2101981();
void _set_mirror_nhop_2101023();
void _set_valid_outer_multicast_packet_untagged_2103487();
void _set_valid_outer_broadcast_packet_qinq_tagged_2103734();
void _set_valid_outer_unicast_packet_qinq_tagged_2103450();
void _egress_nat_0_2102079();
void _rewrite_0_2101502();
void _computed_one_hash_2105682();
void parse_vlan();
void _drop_packet_with_reason_2107226();
void parse_inner_tcp();
void _set_ecmp_nexthop_details_for_post_routed_flood_2106426();
void _nop_8_2105042();
void _nop_10_2105870();
void _nop_4_2101682();
void _set_twice_nat_nexthop_index_2_2105123();
void _set_l2_rewrite_with_tunnel_2101350();
void _remove_vlan_single_tagged_2101134();
void _nop_3_2101579();
void _set_nat_src_tcp_rewrite_2101940();
void parse_mpls();
void NoAction_41_2103005();
void _set_egress_packet_vlan_double_tagged_2102246();
void parse_fabric_header();
void NoAction_49_2103013();
void accept();
void egress_port_type_normal_0_2100849();
void _set_src_nat_rewrite_index_2105052();
void _set_lag_port_2106732();
void _lag_group_0_2106749();
void _set_broadcast_2104754();
void _fabric_ingress_dst_lkp_2104591();
void rmac_hit_0_2103024();
void _set_egress_packet_vlan_untagged_2102186();
void NoAction_58_2103022();
void NoAction_47_2103011();
void NoAction_53_2103017();
void egress_port_type_fabric_0_2100889();
void _set_nat_dst_udp_rewrite_2101842();
void _nop_0_2101013();
void _meter_action_0_2105801();
void _set_valid_outer_multicast_packet_single_tagged_2103512();
void NoAction_32_2100843();
void _set_ingress_port_properties_2103153();
void reject();
void NoAction_36_2100847();
void _set_fib_redirect_action_2105920();
void _set_multicast_and_ipv6_src_is_link_local_2104721();
void _computed_two_hashes_2105653();
void _set_l3_rewrite_with_tunnel_2101447();
void parse_inner_ipv4();
void _validate_packet_0_2104812();
void NoAction_37_2100848();
void _nop_12_2106354();
void NoAction_1_2100842();
void NoAction_56_2103020();
void NoAction_46_2103010();
void _egress_vlan_xlate_0_2102327();
void _set_l2_rewrite_2101316();
void _ecmp_group_0_2106564();
void _on_miss_2104956();
void _set_nat_src_dst_udp_rewrite_2101883();
void _nop_1_2101124();
void _set_racl_redirect_action_2106039();
void parse_llc_header();
void NoAction_33_2100844();
void NoAction_39_2103003();
void _validate_outer_ethernet_0_2103771();
void parse_arp_rarp();

void end_assertions(){
	if(!(traverse_2101150 == 0) && !(vlan_tag_[0].isValid == 1 && emit_header_vlan_tag_[0]_2101150 == 1)){
		printf("Assert error: if expression traverse, !emit(vlan_tag_[0]) evaluated to false");
	}

	if(!(traverse_2101190 == 0) && !(vlan_tag_[0]) && !emit(vlan_tag_[1].isValid == 1 && emit_header_vlan_tag_[0]) && !emit(vlan_tag_[1]_2101190 == 1)){
		printf("Assert error: if expression traverse, !emit(vlan_tag_[0]) && !emit(vlan_tag_[1]) evaluated to false");
	}

	if(!(traverse_2104798 == 0) && !assert_forward == 0){
		printf("Assert error: if expression traverse, !forward evaluated to false");
	}

	if(!(traverse_2106375 == 0) && !constant_l3_metadata_nexthop_index_2106375 != l3_metadata.nexthop_index){
		printf("Assert error: if expression traverse, !constant(l3_metadata.nexthop_index) evaluated to false");
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
} standard_metadata_t;

void mark_to_drop() {
	assert_forward = 0;
	end_assertions();
	exit(0);
}

typedef struct {
	uint8_t acl_deny : 1;
	uint8_t racl_deny : 1;
	uint32_t acl_nexthop : 16;
	uint32_t racl_nexthop : 16;
	uint8_t acl_nexthop_type : 2;
	uint8_t racl_nexthop_type : 2;
	uint8_t acl_redirect : 1;
	uint8_t racl_redirect : 1;
	uint32_t if_label : 16;
	uint32_t bd_label : 16;
	uint32_t acl_stats_index : 14;
	uint32_t egress_if_label : 16;
	uint32_t egress_bd_label : 16;
	uint8_t ingress_src_port_range_id : 8;
	uint8_t ingress_dst_port_range_id : 8;
	uint8_t egress_src_port_range_id : 8;
	uint8_t egress_dst_port_range_id : 8;
} acl_metadata_t;

typedef struct {
	uint8_t bypass : 1;
	uint8_t port_type : 2;
	uint32_t payload_length : 16;
	uint32_t smac_idx : 9;
	uint32_t bd : 16;
	uint32_t outer_bd : 16;
	uint64_t mac_da : 48;
	uint8_t routed : 1;
	uint32_t same_bd_check : 16;
	uint8_t drop_reason : 8;
	uint32_t ifindex : 16;
} egress_metadata_t;

typedef struct {
	uint8_t packetType : 3;
	uint8_t fabric_header_present : 1;
	uint32_t reason_code : 16;
} fabric_metadata_t;

typedef struct {
	uint8_t enable_dod : 1;
} global_config_metadata_t;

typedef struct {
	uint32_t hash1 : 16;
	uint32_t hash2 : 16;
	uint32_t entropy_hash : 16;
} hash_metadata_t;

typedef struct {
	uint32_t ingress_tstamp : 32;
	uint32_t mirror_session_id : 16;
} i2e_metadata_t;

typedef struct {
	uint32_t ingress_port : 9;
	uint32_t ifindex : 16;
	uint32_t egress_ifindex : 16;
	uint8_t port_type : 2;
	uint32_t outer_bd : 16;
	uint32_t bd : 16;
	uint8_t drop_flag : 1;
	uint8_t drop_reason : 8;
	uint8_t control_frame : 1;
	uint32_t bypass_lookups : 16;
	uint32_t sflow_take_sample : 32;
} ingress_metadata_t;

typedef struct {
	uint8_t resubmit_flag : 1;
	uint64_t ingress_global_timestamp : 48;
	uint32_t mcast_grp : 16;
	uint8_t deflection_flag : 1;
	uint8_t deflect_on_drop : 1;
	uint8_t enq_congest_stat : 2;
	uint8_t deq_congest_stat : 2;
	uint32_t mcast_hash : 13;
	uint32_t egress_rid : 16;
	uint32_t lf_field_list : 32;
	uint8_t priority : 3;
	uint8_t ingress_cos : 3;
	uint8_t packet_color : 2;
	uint8_t qid : 5;
} ingress_intrinsic_metadata_t;

typedef struct {
	uint32_t lkp_ipv4_sa : 32;
	uint32_t lkp_ipv4_da : 32;
	uint8_t ipv4_unicast_enabled : 1;
	uint8_t ipv4_urpf_mode : 2;
} ipv4_metadata_t;

typedef struct {
	uint64_t lkp_ipv6_sa : 64;
	uint64_t lkp_ipv6_da : 64;
	uint8_t ipv6_unicast_enabled : 1;
	uint8_t ipv6_src_is_link_local : 1;
	uint8_t ipv6_urpf_mode : 2;
} ipv6_metadata_t;

typedef struct {
	uint64_t lkp_mac_sa : 48;
	uint64_t lkp_mac_da : 48;
	uint8_t lkp_pkt_type : 3;
	uint32_t lkp_mac_type : 16;
	uint8_t lkp_pcp : 3;
	uint32_t l2_nexthop : 16;
	uint8_t l2_nexthop_type : 2;
	uint8_t l2_redirect : 1;
	uint8_t l2_src_miss : 1;
	uint32_t l2_src_move : 16;
	uint32_t stp_group : 10;
	uint8_t stp_state : 3;
	uint32_t bd_stats_idx : 16;
	uint8_t learning_enabled : 1;
	uint8_t port_vlan_mapping_miss : 1;
	uint32_t same_if_check : 16;
} l2_metadata_t;

typedef struct {
	uint8_t lkp_ip_type : 2;
	uint8_t lkp_ip_version : 4;
	uint8_t lkp_ip_proto : 8;
	uint8_t lkp_dscp : 8;
	uint8_t lkp_ip_ttl : 8;
	uint32_t lkp_l4_sport : 16;
	uint32_t lkp_l4_dport : 16;
	uint32_t lkp_outer_l4_sport : 16;
	uint32_t lkp_outer_l4_dport : 16;
	uint32_t vrf : 16;
	uint32_t rmac_group : 10;
	uint8_t rmac_hit : 1;
	uint8_t urpf_mode : 2;
	uint8_t urpf_hit : 1;
	uint8_t urpf_check_fail : 1;
	uint32_t urpf_bd_group : 16;
	uint8_t fib_hit : 1;
	uint32_t fib_nexthop : 16;
	uint8_t fib_nexthop_type : 2;
	uint32_t same_bd_check : 16;
	uint32_t nexthop_index : 16;
	uint8_t routed : 1;
	uint8_t outer_routed : 1;
	uint8_t mtu_index : 8;
	uint8_t l3_copy : 1;
	uint32_t l3_mtu_check : 16;
	uint32_t egress_l4_sport : 16;
	uint32_t egress_l4_dport : 16;
} l3_metadata_t;

typedef struct {
	uint8_t packet_color : 2;
	uint32_t meter_index : 16;
} meter_metadata_t;

typedef struct {
	uint8_t ipv4_mcast_key_type : 1;
	uint32_t ipv4_mcast_key : 16;
	uint8_t ipv6_mcast_key_type : 1;
	uint32_t ipv6_mcast_key : 16;
	uint8_t outer_mcast_route_hit : 1;
	uint8_t outer_mcast_mode : 2;
	uint8_t mcast_route_hit : 1;
	uint8_t mcast_bridge_hit : 1;
	uint8_t ipv4_multicast_enabled : 1;
	uint8_t ipv6_multicast_enabled : 1;
	uint8_t igmp_snooping_enabled : 1;
	uint8_t mld_snooping_enabled : 1;
	uint32_t bd_mrpf_group : 16;
	uint32_t mcast_rpf_group : 16;
	uint8_t mcast_mode : 2;
	uint32_t multicast_route_mc_index : 16;
	uint32_t multicast_bridge_mc_index : 16;
	uint8_t inner_replica : 1;
	uint8_t replica : 1;
} multicast_metadata_t;

typedef struct {
	uint8_t ingress_nat_mode : 2;
	uint8_t egress_nat_mode : 2;
	uint32_t nat_nexthop : 16;
	uint8_t nat_nexthop_type : 2;
	uint8_t nat_hit : 1;
	uint32_t nat_rewrite_index : 14;
	uint8_t update_checksum : 1;
	uint8_t update_inner_checksum : 1;
	uint32_t l4_len : 16;
} nat_metadata_t;

typedef struct {
	uint8_t nexthop_type : 2;
} nexthop_metadata_t;

typedef struct {
	uint8_t ingress_qos_group : 5;
	uint8_t tc_qos_group : 5;
	uint8_t egress_qos_group : 5;
	uint8_t lkp_tc : 8;
	uint8_t trust_dscp : 1;
	uint8_t trust_pcp : 1;
} qos_metadata_t;

typedef struct {
	uint64_t enq_timestamp : 48;
	uint32_t enq_qdepth : 16;
	uint32_t deq_timedelta : 32;
	uint32_t deq_qdepth : 16;
} queueing_metadata_t;

typedef struct {
	uint8_t ipsg_enabled : 1;
	uint8_t ipsg_check_fail : 1;
} security_metadata_t;

typedef struct {
	uint8_t ingress_tunnel_type : 5;
	uint32_t tunnel_vni : 24;
	uint8_t mpls_enabled : 1;
	uint32_t mpls_label : 20;
	uint8_t mpls_exp : 3;
	uint8_t mpls_ttl : 8;
	uint8_t egress_tunnel_type : 5;
	uint32_t tunnel_index : 14;
	uint32_t tunnel_src_index : 9;
	uint32_t tunnel_smac_index : 9;
	uint32_t tunnel_dst_index : 14;
	uint32_t tunnel_dmac_index : 14;
	uint32_t vnid : 24;
	uint8_t tunnel_terminate : 1;
	uint8_t tunnel_if_check : 1;
	uint8_t egress_header_count : 4;
	uint8_t inner_ip_proto : 8;
	uint8_t skip_encap_inner : 1;
} tunnel_metadata_t;

typedef struct {
	uint8_t isValid : 1;
	uint8_t version : 3;
	uint8_t diag : 5;
	uint8_t state : 2;
	uint8_t p : 1;
	uint8_t f : 1;
	uint8_t c : 1;
	uint8_t a : 1;
	uint8_t d : 1;
	uint8_t m : 1;
	uint8_t detectMult : 8;
	uint8_t len : 8;
	uint32_t myDiscriminator : 32;
	uint32_t yourDiscriminator : 32;
	uint32_t desiredMinTxInterval : 32;
	uint32_t requiredMinRxInterval : 32;
	uint32_t requiredMinEchoRxInterval : 32;
	uint8_t $valid$ : 1;
} bfd_t;

typedef struct {
	uint8_t isValid : 1;
	uint8_t zero : 4;
	uint32_t reserved : 12;
	uint32_t seqNo : 16;
	uint8_t $valid$ : 1;
} eompls_t;

typedef struct {
	uint8_t isValid : 1;
	uint8_t version : 4;
	uint32_t vlan : 12;
	uint8_t priority : 6;
	uint32_t span_id : 10;
	uint32_t timestamp : 32;
	uint32_t sgt : 16;
	uint32_t ft_d_other : 16;
	uint8_t $valid$ : 1;
} erspan_header_t3_t_0;

typedef struct {
	uint8_t isValid : 1;
	uint64_t dstAddr : 48;
	uint64_t srcAddr : 48;
	uint32_t etherType : 16;
	uint8_t $valid$ : 1;
} ethernet_t;

typedef struct {
	uint8_t isValid : 1;
	uint8_t packetType : 3;
	uint8_t headerVersion : 2;
	uint8_t packetVersion : 2;
	uint8_t pad1 : 1;
	uint8_t fabricColor : 3;
	uint8_t fabricQos : 5;
	uint8_t dstDevice : 8;
	uint32_t dstPortOrGroup : 16;
	uint8_t $valid$ : 1;
} fabric_header_t;

typedef struct {
	uint8_t isValid : 1;
	uint8_t egressQueue : 5;
	uint8_t txBypass : 1;
	uint8_t reserved : 2;
	uint32_t ingressPort : 16;
	uint32_t ingressIfindex : 16;
	uint32_t ingressBd : 16;
	uint32_t reasonCode : 16;
	uint32_t mcast_grp : 16;
	uint8_t $valid$ : 1;
} fabric_header_cpu_t;

typedef struct {
	uint8_t isValid : 1;
	uint32_t rewriteIndex : 16;
	uint32_t egressPort : 10;
	uint8_t egressQueue : 5;
	uint8_t pad : 1;
	uint8_t $valid$ : 1;
} fabric_header_mirror_t;

typedef struct {
	uint8_t isValid : 1;
	uint8_t routed : 1;
	uint8_t outerRouted : 1;
	uint8_t tunnelTerminate : 1;
	uint8_t ingressTunnelType : 5;
	uint32_t ingressIfindex : 16;
	uint32_t ingressBd : 16;
	uint32_t mcastGrp : 16;
	uint8_t $valid$ : 1;
} fabric_header_multicast_t;

typedef struct {
	uint8_t isValid : 1;
	uint32_t sflow_session_id : 16;
	uint32_t sflow_egress_ifindex : 16;
	uint8_t $valid$ : 1;
} fabric_header_sflow_t;

typedef struct {
	uint8_t isValid : 1;
	uint8_t routed : 1;
	uint8_t outerRouted : 1;
	uint8_t tunnelTerminate : 1;
	uint8_t ingressTunnelType : 5;
	uint32_t nexthopIndex : 16;
	uint8_t $valid$ : 1;
} fabric_header_unicast_t;

typedef struct {
	uint8_t isValid : 1;
	uint32_t etherType : 16;
	uint8_t $valid$ : 1;
} fabric_payload_header_t;

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
	uint8_t $valid$ : 1;
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
	uint8_t $valid$ : 1;
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
	uint8_t $valid$ : 1;
} gre_t;

typedef struct {
	uint8_t isValid : 1;
	uint32_t typeCode : 16;
	uint32_t hdrChecksum : 16;
	uint8_t $valid$ : 1;
} icmp_t;

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
	uint32_t srcPort : 16;
	uint32_t dstPort : 16;
	uint32_t verifTag : 32;
	uint32_t checksum : 32;
	uint8_t $valid$ : 1;
} sctp_t;

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
	uint8_t $valid$ : 1;
} tcp_t;

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
	uint8_t flags : 8;
	uint32_t nonce : 24;
	uint32_t lsbsInstanceId : 32;
	uint8_t $valid$ : 1;
} lisp_t;

typedef struct {
	uint8_t isValid : 1;
	uint8_t dsap : 8;
	uint8_t ssap : 8;
	uint8_t control_ : 8;
	uint8_t $valid$ : 1;
} llc_header_t;

typedef struct {
	uint8_t isValid : 1;
	uint8_t oam : 1;
	uint8_t context : 1;
	uint8_t flags : 6;
	uint8_t reserved : 8;
	uint32_t protoType : 16;
	uint32_t spath : 24;
	uint8_t sindex : 8;
	uint8_t $valid$ : 1;
} nsh_t;

typedef struct {
	uint8_t isValid : 1;
	uint32_t network_platform : 32;
	uint32_t network_shared : 32;
	uint32_t service_platform : 32;
	uint32_t service_shared : 32;
	uint8_t $valid$ : 1;
} nsh_context_t;

typedef struct {
	uint8_t isValid : 1;
	uint32_t tni : 24;
	uint8_t flow_id : 8;
	uint8_t $valid$ : 1;
} nvgre_t;

typedef struct {
	uint8_t isValid : 1;
	uint64_t ib_grh : 64;
	uint64_t ib_bth : 64;
	uint8_t $valid$ : 1;
} roce_header_t;

typedef struct {
	uint8_t isValid : 1;
	uint64_t ib_bth : 64;
	uint8_t $valid$ : 1;
} roce_v2_header_t;

typedef struct {
	uint8_t isValid : 1;
	uint32_t oui : 24;
	uint32_t type_ : 16;
	uint8_t $valid$ : 1;
} snap_header_t;

typedef struct {
	uint8_t isValid : 1;
	uint8_t version : 2;
	uint8_t reserved : 2;
	uint8_t multiDestination : 1;
	uint8_t optLength : 5;
	uint8_t hopCount : 6;
	uint32_t egressRbridge : 16;
	uint32_t ingressRbridge : 16;
	uint8_t $valid$ : 1;
} trill_t;

typedef struct {
	uint8_t isValid : 1;
	uint8_t direction : 1;
	uint8_t pointer : 1;
	uint32_t destVif : 14;
	uint8_t looped : 1;
	uint8_t reserved : 1;
	uint8_t version : 2;
	uint32_t srcVif : 12;
	uint8_t $valid$ : 1;
} vntag_t;

typedef struct {
	uint8_t isValid : 1;
	uint8_t flags : 8;
	uint32_t reserved : 24;
	uint32_t vni : 24;
	uint8_t reserved2 : 8;
	uint8_t $valid$ : 1;
} vxlan_t;

typedef struct {
	uint8_t isValid : 1;
	uint32_t label : 20;
	uint8_t exp : 3;
	uint8_t bos : 1;
	uint8_t ttl : 8;
	uint8_t $valid$ : 1;
} mpls_t;

typedef struct {
	uint8_t isValid : 1;
	uint8_t pcp : 3;
	uint8_t cfi : 1;
	uint32_t vid : 12;
	uint32_t etherType : 16;
	uint8_t $valid$ : 1;
} vlan_tag_t;

typedef struct {
	acl_metadata_t acl_metadata;
	egress_metadata_t egress_metadata;
	fabric_metadata_t fabric_metadata;
	global_config_metadata_t global_config_metadata;
	hash_metadata_t hash_metadata;
	i2e_metadata_t i2e_metadata;
	ingress_metadata_t ingress_metadata;
	ingress_intrinsic_metadata_t intrinsic_metadata;
	ipv4_metadata_t ipv4_metadata;
	ipv6_metadata_t ipv6_metadata;
	l2_metadata_t l2_metadata;
	l3_metadata_t l3_metadata;
	meter_metadata_t meter_metadata;
	multicast_metadata_t multicast_metadata;
	nat_metadata_t nat_metadata;
	nexthop_metadata_t nexthop_metadata;
	qos_metadata_t qos_metadata;
	queueing_metadata_t queueing_metadata;
	security_metadata_t security_metadata;
	tunnel_metadata_t tunnel_metadata;
} metadata;

typedef struct {
	bfd_t bfd;
	eompls_t eompls;
	erspan_header_t3_t_0 erspan_t3_header;
	ethernet_t ethernet;
	fabric_header_t fabric_header;
	fabric_header_cpu_t fabric_header_cpu;
	fabric_header_mirror_t fabric_header_mirror;
	fabric_header_multicast_t fabric_header_multicast;
	fabric_header_sflow_t fabric_header_sflow;
	fabric_header_unicast_t fabric_header_unicast;
	fabric_payload_header_t fabric_payload_header;
	fcoe_header_t fcoe;
	genv_t genv;
	gre_t gre;
	icmp_t icmp;
	ethernet_t inner_ethernet;
	icmp_t inner_icmp;
	ipv4_t inner_ipv4;
	ipv6_t inner_ipv6;
	sctp_t inner_sctp;
	tcp_t inner_tcp;
	udp_t inner_udp;
	ipv4_t ipv4;
	ipv6_t ipv6;
	lisp_t lisp;
	llc_header_t llc_header;
	nsh_t nsh;
	nsh_context_t nsh_context;
	nvgre_t nvgre;
	udp_t outer_udp;
	roce_header_t roce;
	roce_v2_header_t roce_v2;
	sctp_t sctp;
	snap_header_t snap_header;
	tcp_t tcp;
	trill_t trill;
	udp_t udp;
	vntag_t vntag;
	vxlan_t vxlan;
	int mpls_index;
	mpls_t mpls[3];
	int vlan_tag__index;
	vlan_tag_t vlan_tag_[2];
} headers;

headers hdr;
metadata meta;
standard_metadata_t standard_metadata;


void parse_arp_rarp() {
	parse_set_prio_med();
}


void parse_ethernet() {
	hdr.ethernet.isValid = 1;
	if(((hdr.ethernet.etherType & 65024) == (0 & 65024))){
		parse_llc_header();
	} else if(((hdr.ethernet.etherType & 64000) == (0 & 64000))){
		parse_llc_header();
	} else if((hdr.ethernet.etherType == 36864)){
		parse_fabric_header();
	} else if((hdr.ethernet.etherType == 33024)){
		parse_vlan();
	} else if((hdr.ethernet.etherType == 37120)){
		parse_qinq();
	} else if((hdr.ethernet.etherType == 34887)){
		parse_mpls();
	} else if((hdr.ethernet.etherType == 2048)){
		parse_ipv4();
	} else if((hdr.ethernet.etherType == 34525)){
		parse_ipv6();
	} else if((hdr.ethernet.etherType == 2054)){
		parse_arp_rarp();
	} else if((hdr.ethernet.etherType == 35020)){
		parse_set_prio_high();
	} else if((hdr.ethernet.etherType == 34825)){
		parse_set_prio_high();
	} else {
		accept();
	}
}


void parse_fabric_header() {
	hdr.fabric_header.isValid = 1;
	if((hdr.fabric_header.packetType == 5)){
		parse_fabric_header_cpu();
	} else {
		accept();
	}
}


void parse_fabric_header_cpu() {
	hdr.fabric_header_cpu.isValid = 1;
	meta.ingress_metadata.bypass_lookups = hdr.fabric_header_cpu.reasonCode;
	parse_fabric_payload_header();
}


void parse_fabric_payload_header() {
	hdr.fabric_payload_header.isValid = 1;
	if(((hdr.fabric_payload_header.etherType & 65024) == (0 & 65024))){
		parse_llc_header();
	} else if(((hdr.fabric_payload_header.etherType & 64000) == (0 & 64000))){
		parse_llc_header();
	} else if((hdr.fabric_payload_header.etherType == 33024)){
		parse_vlan();
	} else if((hdr.fabric_payload_header.etherType == 37120)){
		parse_qinq();
	} else if((hdr.fabric_payload_header.etherType == 34887)){
		parse_mpls();
	} else if((hdr.fabric_payload_header.etherType == 2048)){
		parse_ipv4();
	} else if((hdr.fabric_payload_header.etherType == 34525)){
		parse_ipv6();
	} else if((hdr.fabric_payload_header.etherType == 2054)){
		parse_arp_rarp();
	} else if((hdr.fabric_payload_header.etherType == 35020)){
		parse_set_prio_high();
	} else if((hdr.fabric_payload_header.etherType == 34825)){
		parse_set_prio_high();
	} else {
		accept();
	}
}


void parse_icmp() {
	hdr.icmp.isValid = 1;
	meta.l3_metadata.lkp_outer_l4_sport = hdr.icmp.typeCode;
	if(((hdr.icmp.typeCode & 65024) == (33280 & 65024))){
		parse_set_prio_med();
	} else if(((hdr.icmp.typeCode & 64512) == (33792 & 64512))){
		parse_set_prio_med();
	} else if(((hdr.icmp.typeCode & 65280) == (34816 & 65280))){
		parse_set_prio_med();
	} else {
		accept();
	}
}


void parse_inner_icmp() {
	hdr.inner_icmp.isValid = 1;
	meta.l3_metadata.lkp_l4_sport = hdr.inner_icmp.typeCode;
	accept();
}


void parse_inner_ipv4() {
	hdr.inner_ipv4.isValid = 1;
	meta.ipv4_metadata.lkp_ipv4_sa = hdr.inner_ipv4.srcAddr;
	meta.ipv4_metadata.lkp_ipv4_da = hdr.inner_ipv4.dstAddr;
	meta.l3_metadata.lkp_ip_proto = hdr.inner_ipv4.protocol;
	meta.l3_metadata.lkp_ip_ttl = hdr.inner_ipv4.ttl;
	if((hdr.inner_ipv4.fragOffset == 0) && (hdr.inner_ipv4.ihl == 5) && (hdr.inner_ipv4.protocol == 1)){
		parse_inner_icmp();
	} else if((hdr.inner_ipv4.fragOffset == 0) && (hdr.inner_ipv4.ihl == 5) && (hdr.inner_ipv4.protocol == 6)){
		parse_inner_tcp();
	} else if((hdr.inner_ipv4.fragOffset == 0) && (hdr.inner_ipv4.ihl == 5) && (hdr.inner_ipv4.protocol == 17)){
		parse_inner_udp();
	} else {
		accept();
	}
}


void parse_inner_tcp() {
	hdr.inner_tcp.isValid = 1;
	meta.l3_metadata.lkp_l4_sport = hdr.inner_tcp.srcPort;
	meta.l3_metadata.lkp_l4_dport = hdr.inner_tcp.dstPort;
	accept();
}


void parse_inner_udp() {
	hdr.inner_udp.isValid = 1;
	meta.l3_metadata.lkp_l4_sport = hdr.inner_udp.srcPort;
	meta.l3_metadata.lkp_l4_dport = hdr.inner_udp.dstPort;
	accept();
}


void parse_ipv4() {
	hdr.ipv4.isValid = 1;
	if((hdr.ipv4.fragOffset == 0) && (hdr.ipv4.ihl == 5) && (hdr.ipv4.protocol == 1)){
		parse_icmp();
	} else if((hdr.ipv4.fragOffset == 0) && (hdr.ipv4.ihl == 5) && (hdr.ipv4.protocol == 6)){
		parse_tcp();
	} else if((hdr.ipv4.fragOffset == 0) && (hdr.ipv4.ihl == 5) && (hdr.ipv4.protocol == 17)){
		parse_udp();
	} else if((hdr.ipv4.fragOffset == 0) && (hdr.ipv4.ihl == 0) && (hdr.ipv4.protocol == 2)){
		parse_set_prio_med();
	} else if((hdr.ipv4.fragOffset == 0) && (hdr.ipv4.ihl == 0) && (hdr.ipv4.protocol == 88)){
		parse_set_prio_med();
	} else if((hdr.ipv4.fragOffset == 0) && (hdr.ipv4.ihl == 0) && (hdr.ipv4.protocol == 89)){
		parse_set_prio_med();
	} else if((hdr.ipv4.fragOffset == 0) && (hdr.ipv4.ihl == 0) && (hdr.ipv4.protocol == 103)){
		parse_set_prio_med();
	} else if((hdr.ipv4.fragOffset == 0) && (hdr.ipv4.ihl == 0) && (hdr.ipv4.protocol == 112)){
		parse_set_prio_med();
	} else {
		accept();
	}
}


void parse_ipv4_in_ip() {
	meta.tunnel_metadata.ingress_tunnel_type = 3;
	parse_inner_ipv4();
}


void parse_ipv6() {
	hdr.ipv6.isValid = 1;
	if((hdr.ipv6.nextHdr == 58)){
		parse_icmp();
	} else if((hdr.ipv6.nextHdr == 6)){
		parse_tcp();
	} else if((hdr.ipv6.nextHdr == 4)){
		parse_ipv4_in_ip();
	} else if((hdr.ipv6.nextHdr == 88)){
		parse_set_prio_med();
	} else if((hdr.ipv6.nextHdr == 89)){
		parse_set_prio_med();
	} else if((hdr.ipv6.nextHdr == 103)){
		parse_set_prio_med();
	} else if((hdr.ipv6.nextHdr == 112)){
		parse_set_prio_med();
	} else {
		accept();
	}
}


void parse_llc_header() {
	hdr.llc_header.isValid = 1;
	if((hdr.llc_header.dsap == 170) && (hdr.llc_header.ssap == 170)){
		parse_snap_header();
	} else if((hdr.llc_header.dsap == 254) && (hdr.llc_header.ssap == 254)){
		parse_set_prio_med();
	} else {
		accept();
	}
}


void parse_mpls() {
	accept();
}


void parse_qinq() {
	hdr.vlan_tag_[0].isValid = 1;
	if((hdr.vlan_tag_[0].etherType == 33024)){
		parse_qinq_vlan();
	} else {
		accept();
	}
}


void parse_qinq_vlan() {
	hdr.vlan_tag_[1].isValid = 1;
	if((hdr.vlan_tag_[1].etherType == 34887)){
		parse_mpls();
	} else if((hdr.vlan_tag_[1].etherType == 2048)){
		parse_ipv4();
	} else if((hdr.vlan_tag_[1].etherType == 34525)){
		parse_ipv6();
	} else if((hdr.vlan_tag_[1].etherType == 2054)){
		parse_arp_rarp();
	} else if((hdr.vlan_tag_[1].etherType == 35020)){
		parse_set_prio_high();
	} else if((hdr.vlan_tag_[1].etherType == 34825)){
		parse_set_prio_high();
	} else {
		accept();
	}
}


void parse_set_prio_high() {
	meta.intrinsic_metadata.priority = 5;
	accept();
}


void parse_set_prio_med() {
	meta.intrinsic_metadata.priority = 3;
	accept();
}


void parse_sflow() {
	accept();
}


void parse_snap_header() {
	hdr.snap_header.isValid = 1;
	if((hdr.snap_header.type_ == 33024)){
		parse_vlan();
	} else if((hdr.snap_header.type_ == 37120)){
		parse_qinq();
	} else if((hdr.snap_header.type_ == 34887)){
		parse_mpls();
	} else if((hdr.snap_header.type_ == 2048)){
		parse_ipv4();
	} else if((hdr.snap_header.type_ == 34525)){
		parse_ipv6();
	} else if((hdr.snap_header.type_ == 2054)){
		parse_arp_rarp();
	} else if((hdr.snap_header.type_ == 35020)){
		parse_set_prio_high();
	} else if((hdr.snap_header.type_ == 34825)){
		parse_set_prio_high();
	} else {
		accept();
	}
}


void parse_tcp() {
	hdr.tcp.isValid = 1;
	meta.l3_metadata.lkp_outer_l4_sport = hdr.tcp.srcPort;
	meta.l3_metadata.lkp_outer_l4_dport = hdr.tcp.dstPort;
	if((hdr.tcp.dstPort == 179)){
		parse_set_prio_med();
	} else if((hdr.tcp.dstPort == 639)){
		parse_set_prio_med();
	} else {
		accept();
	}
}


void parse_udp() {
	hdr.udp.isValid = 1;
	meta.l3_metadata.lkp_outer_l4_sport = hdr.udp.srcPort;
	meta.l3_metadata.lkp_outer_l4_dport = hdr.udp.dstPort;
	if((hdr.udp.dstPort == 67)){
		parse_set_prio_med();
	} else if((hdr.udp.dstPort == 68)){
		parse_set_prio_med();
	} else if((hdr.udp.dstPort == 546)){
		parse_set_prio_med();
	} else if((hdr.udp.dstPort == 547)){
		parse_set_prio_med();
	} else if((hdr.udp.dstPort == 520)){
		parse_set_prio_med();
	} else if((hdr.udp.dstPort == 521)){
		parse_set_prio_med();
	} else if((hdr.udp.dstPort == 1985)){
		parse_set_prio_med();
	} else if((hdr.udp.dstPort == 6343)){
		parse_sflow();
	} else {
		accept();
	}
}


void parse_vlan() {
	hdr.vlan_tag_[0].isValid = 1;
	if((hdr.vlan_tag_[0].etherType == 34887)){
		parse_mpls();
	} else if((hdr.vlan_tag_[0].etherType == 2048)){
		parse_ipv4();
	} else if((hdr.vlan_tag_[0].etherType == 34525)){
		parse_ipv6();
	} else if((hdr.vlan_tag_[0].etherType == 2054)){
		parse_arp_rarp();
	} else if((hdr.vlan_tag_[0].etherType == 35020)){
		parse_set_prio_high();
	} else if((hdr.vlan_tag_[0].etherType == 34825)){
		parse_set_prio_high();
	} else {
		accept();
	}
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

typedef struct {
	uint32_t field : 16;
	uint32_t field_0 : 16;
	uint32_t field_1 : 16;
	uint32_t field_2 : 9;
} tuple_0;

typedef struct {
	uint32_t field_3 : 32;
	uint32_t field_4 : 16;
} tuple_1;

//Control

void egress() {
	if((meta.intrinsic_metadata.deflection_flag == 0) && (meta.egress_metadata.bypass == 0)) {
		if((standard_metadata.instance_type != 0) && (standard_metadata.instance_type != 5)) {
	_mirror_0_2101059();
} else {
	
}
	egress_port_mapping_2100949();
	if(action_run == 2100849) {
		 	if((standard_metadata.instance_type == 0) || (standard_metadata.instance_type == 5)) {
	_vlan_decap_0_2101225();
}
	if((meta.egress_metadata.routed == 0) || (meta.l3_metadata.nexthop_index != 0)) {
	_rewrite_0_2101502();
} else {
	
}
	_egress_bd_map_0_2101623();
	if((meta.nat_metadata.ingress_nat_mode != 0) && (meta.nat_metadata.ingress_nat_mode != meta.nat_metadata.egress_nat_mode)) {
	_egress_nat_0_2102079();
}

	}
	if((meta.egress_metadata.port_type == 0)) {
	_egress_vlan_xlate_0_2102327();
}

}
	if((meta.egress_metadata.port_type == 0)) {
	if((meta.egress_metadata.bypass == 0)) {
	_egress_system_acl_0_2102697();
}
}
}

// Action
void NoAction_0_2100832() {
	action_run = 2100832;
	
}


// Action
void NoAction_1_2100842() {
	action_run = 2100842;
	
}


// Action
void NoAction_32_2100843() {
	action_run = 2100843;
	
}


// Action
void NoAction_33_2100844() {
	action_run = 2100844;
	
}


// Action
void NoAction_34_2100845() {
	action_run = 2100845;
	
}


// Action
void NoAction_35_2100846() {
	action_run = 2100846;
	
}


// Action
void NoAction_36_2100847() {
	action_run = 2100847;
	
}


// Action
void NoAction_37_2100848() {
	action_run = 2100848;
	
}


// Action
void egress_port_type_normal_0_2100849() {
	action_run = 2100849;
	uint32_t ifindex;
	klee_make_symbolic(&ifindex, sizeof(ifindex), "ifindex");
uint8_t qos_group;
	klee_make_symbolic(&qos_group, sizeof(qos_group), "qos_group");
uint32_t if_label;
	klee_make_symbolic(&if_label, sizeof(if_label), "if_label");
	meta.egress_metadata.port_type = 0;
	meta.egress_metadata.ifindex = ifindex;
	meta.qos_metadata.egress_qos_group = qos_group;
	meta.acl_metadata.egress_if_label = if_label;

}


// Action
void egress_port_type_fabric_0_2100889() {
	action_run = 2100889;
	uint32_t ifindex;
	klee_make_symbolic(&ifindex, sizeof(ifindex), "ifindex");
	meta.egress_metadata.port_type = 1;
	meta.egress_metadata.ifindex = ifindex;
	meta.tunnel_metadata.egress_tunnel_type = 15;

}


// Action
void egress_port_type_cpu_0_2100919() {
	action_run = 2100919;
	uint32_t ifindex;
	klee_make_symbolic(&ifindex, sizeof(ifindex), "ifindex");
	meta.egress_metadata.port_type = 2;
	meta.egress_metadata.ifindex = ifindex;
	meta.tunnel_metadata.egress_tunnel_type = 16;

}


// Action
void _nop_0_2101013() {
	action_run = 2101013;
	
}


// Action
void _set_mirror_nhop_2101023() {
	action_run = 2101023;
	uint32_t nhop_idx;
	klee_make_symbolic(&nhop_idx, sizeof(nhop_idx), "nhop_idx");
	meta.l3_metadata.nexthop_index = nhop_idx;

}


// Action
void _set_mirror_bd_2101041() {
	action_run = 2101041;
	uint32_t bd;
	klee_make_symbolic(&bd, sizeof(bd), "bd");
	meta.egress_metadata.bd = bd;

}


// Action
void _nop_1_2101124() {
	action_run = 2101124;
	
}


// Action
void _remove_vlan_single_tagged_2101134() {
	action_run = 2101134;
		traverse_2101150 = 1;
	hdr.ethernet.etherType = hdr.vlan_tag_[0].etherType;
	hdr.vlan_tag_[0].isValid = 0;

}


// Action
void _remove_vlan_double_tagged_2101174() {
	action_run = 2101174;
		traverse_2101190 = 1;
	hdr.ethernet.etherType = hdr.vlan_tag_[1].etherType;
	hdr.vlan_tag_[0].isValid = 0;
	hdr.vlan_tag_[1].isValid = 0;

}


// Action
void _nop_2_2101306() {
	action_run = 2101306;
	
}


// Action
void _set_l2_rewrite_2101316() {
	action_run = 2101316;
		meta.egress_metadata.routed = 0;
	meta.egress_metadata.bd = meta.ingress_metadata.bd;
	meta.egress_metadata.outer_bd = meta.ingress_metadata.bd;

}


// Action
void _set_l2_rewrite_with_tunnel_2101350() {
	action_run = 2101350;
	uint32_t tunnel_index;
	klee_make_symbolic(&tunnel_index, sizeof(tunnel_index), "tunnel_index");
uint8_t tunnel_type;
	klee_make_symbolic(&tunnel_type, sizeof(tunnel_type), "tunnel_type");
	meta.egress_metadata.routed = 0;
	meta.egress_metadata.bd = meta.ingress_metadata.bd;
	meta.egress_metadata.outer_bd = meta.ingress_metadata.bd;
	meta.tunnel_metadata.tunnel_index = tunnel_index;
	meta.tunnel_metadata.egress_tunnel_type = tunnel_type;

}


// Action
void _set_l3_rewrite_2101400() {
	action_run = 2101400;
	uint32_t bd;
	klee_make_symbolic(&bd, sizeof(bd), "bd");
uint8_t mtu_index;
	klee_make_symbolic(&mtu_index, sizeof(mtu_index), "mtu_index");
uint64_t dmac;
	klee_make_symbolic(&dmac, sizeof(dmac), "dmac");
	meta.egress_metadata.routed = 1;
	meta.egress_metadata.mac_da = dmac;
	meta.egress_metadata.bd = bd;
	meta.egress_metadata.outer_bd = bd;
	meta.l3_metadata.mtu_index = mtu_index;

}


// Action
void _set_l3_rewrite_with_tunnel_2101447() {
	action_run = 2101447;
	uint32_t bd;
	klee_make_symbolic(&bd, sizeof(bd), "bd");
uint64_t dmac;
	klee_make_symbolic(&dmac, sizeof(dmac), "dmac");
uint32_t tunnel_index;
	klee_make_symbolic(&tunnel_index, sizeof(tunnel_index), "tunnel_index");
uint8_t tunnel_type;
	klee_make_symbolic(&tunnel_type, sizeof(tunnel_type), "tunnel_type");
	meta.egress_metadata.routed = 1;
	meta.egress_metadata.mac_da = dmac;
	meta.egress_metadata.bd = bd;
	meta.egress_metadata.outer_bd = bd;
	meta.tunnel_metadata.tunnel_index = tunnel_index;
	meta.tunnel_metadata.egress_tunnel_type = tunnel_type;

}


// Action
void _nop_3_2101579() {
	action_run = 2101579;
	
}


// Action
void _set_egress_bd_properties_2101589() {
	action_run = 2101589;
	uint32_t smac_idx;
	klee_make_symbolic(&smac_idx, sizeof(smac_idx), "smac_idx");
uint8_t nat_mode;
	klee_make_symbolic(&nat_mode, sizeof(nat_mode), "nat_mode");
uint32_t bd_label;
	klee_make_symbolic(&bd_label, sizeof(bd_label), "bd_label");
	meta.egress_metadata.smac_idx = smac_idx;
	meta.nat_metadata.egress_nat_mode = nat_mode;
	meta.acl_metadata.egress_bd_label = bd_label;

}


// Action
void _nop_4_2101682() {
	action_run = 2101682;
	
}


// Action
void _set_nat_src_rewrite_2101692() {
	action_run = 2101692;
	uint32_t src_ip;
	klee_make_symbolic(&src_ip, sizeof(src_ip), "src_ip");
	hdr.ipv4.srcAddr = src_ip;
	meta.nat_metadata.update_checksum = 1;
	meta.nat_metadata.l4_len = hdr.ipv4.totalLen + 65516;

}


// Action
void _set_nat_dst_rewrite_2101727() {
	action_run = 2101727;
	uint32_t dst_ip;
	klee_make_symbolic(&dst_ip, sizeof(dst_ip), "dst_ip");
	hdr.ipv4.dstAddr = dst_ip;
	meta.nat_metadata.update_checksum = 1;
	meta.nat_metadata.l4_len = hdr.ipv4.totalLen + 65516;

}


// Action
void _set_nat_src_dst_rewrite_2101760() {
	action_run = 2101760;
	uint32_t src_ip;
	klee_make_symbolic(&src_ip, sizeof(src_ip), "src_ip");
uint32_t dst_ip;
	klee_make_symbolic(&dst_ip, sizeof(dst_ip), "dst_ip");
	hdr.ipv4.srcAddr = src_ip;
	hdr.ipv4.dstAddr = dst_ip;
	meta.nat_metadata.update_checksum = 1;
	meta.nat_metadata.l4_len = hdr.ipv4.totalLen + 65516;

}


// Action
void _set_nat_src_udp_rewrite_2101801() {
	action_run = 2101801;
	uint32_t src_ip;
	klee_make_symbolic(&src_ip, sizeof(src_ip), "src_ip");
uint32_t src_port;
	klee_make_symbolic(&src_port, sizeof(src_port), "src_port");
	hdr.ipv4.srcAddr = src_ip;
	hdr.udp.srcPort = src_port;
	meta.nat_metadata.update_checksum = 1;
	meta.nat_metadata.l4_len = hdr.ipv4.totalLen + 65516;

}


// Action
void _set_nat_dst_udp_rewrite_2101842() {
	action_run = 2101842;
	uint32_t dst_ip;
	klee_make_symbolic(&dst_ip, sizeof(dst_ip), "dst_ip");
uint32_t dst_port;
	klee_make_symbolic(&dst_port, sizeof(dst_port), "dst_port");
	hdr.ipv4.dstAddr = dst_ip;
	hdr.udp.dstPort = dst_port;
	meta.nat_metadata.update_checksum = 1;
	meta.nat_metadata.l4_len = hdr.ipv4.totalLen + 65516;

}


// Action
void _set_nat_src_dst_udp_rewrite_2101883() {
	action_run = 2101883;
	uint32_t src_ip;
	klee_make_symbolic(&src_ip, sizeof(src_ip), "src_ip");
uint32_t dst_ip;
	klee_make_symbolic(&dst_ip, sizeof(dst_ip), "dst_ip");
uint32_t src_port;
	klee_make_symbolic(&src_port, sizeof(src_port), "src_port");
uint32_t dst_port;
	klee_make_symbolic(&dst_port, sizeof(dst_port), "dst_port");
	hdr.ipv4.srcAddr = src_ip;
	hdr.ipv4.dstAddr = dst_ip;
	hdr.udp.srcPort = src_port;
	hdr.udp.dstPort = dst_port;
	meta.nat_metadata.update_checksum = 1;
	meta.nat_metadata.l4_len = hdr.ipv4.totalLen + 65516;

}


// Action
void _set_nat_src_tcp_rewrite_2101940() {
	action_run = 2101940;
	uint32_t src_ip;
	klee_make_symbolic(&src_ip, sizeof(src_ip), "src_ip");
uint32_t src_port;
	klee_make_symbolic(&src_port, sizeof(src_port), "src_port");
	hdr.ipv4.srcAddr = src_ip;
	hdr.tcp.srcPort = src_port;
	meta.nat_metadata.update_checksum = 1;
	meta.nat_metadata.l4_len = hdr.ipv4.totalLen + 65516;

}


// Action
void _set_nat_dst_tcp_rewrite_2101981() {
	action_run = 2101981;
	uint32_t dst_ip;
	klee_make_symbolic(&dst_ip, sizeof(dst_ip), "dst_ip");
uint32_t dst_port;
	klee_make_symbolic(&dst_port, sizeof(dst_port), "dst_port");
	hdr.ipv4.dstAddr = dst_ip;
	hdr.tcp.dstPort = dst_port;
	meta.nat_metadata.update_checksum = 1;
	meta.nat_metadata.l4_len = hdr.ipv4.totalLen + 65516;

}


// Action
void _set_nat_src_dst_tcp_rewrite_2102022() {
	action_run = 2102022;
	uint32_t src_ip;
	klee_make_symbolic(&src_ip, sizeof(src_ip), "src_ip");
uint32_t dst_ip;
	klee_make_symbolic(&dst_ip, sizeof(dst_ip), "dst_ip");
uint32_t src_port;
	klee_make_symbolic(&src_port, sizeof(src_port), "src_port");
uint32_t dst_port;
	klee_make_symbolic(&dst_port, sizeof(dst_port), "dst_port");
	hdr.ipv4.srcAddr = src_ip;
	hdr.ipv4.dstAddr = dst_ip;
	hdr.tcp.srcPort = src_port;
	hdr.tcp.dstPort = dst_port;
	meta.nat_metadata.update_checksum = 1;
	meta.nat_metadata.l4_len = hdr.ipv4.totalLen + 65516;

}


// Action
void _set_egress_packet_vlan_untagged_2102186() {
	action_run = 2102186;
	
}


// Action
void _set_egress_packet_vlan_tagged_2102196() {
	action_run = 2102196;
	uint32_t vlan_id;
	klee_make_symbolic(&vlan_id, sizeof(vlan_id), "vlan_id");
	hdr.vlan_tag_[0].isValid = 1;
	hdr.vlan_tag_[0].etherType = hdr.ethernet.etherType;
	hdr.vlan_tag_[0].vid = vlan_id;
	hdr.ethernet.etherType = 33024;

}


// Action
void _set_egress_packet_vlan_double_tagged_2102246() {
	action_run = 2102246;
	uint32_t s_tag;
	klee_make_symbolic(&s_tag, sizeof(s_tag), "s_tag");
uint32_t c_tag;
	klee_make_symbolic(&c_tag, sizeof(c_tag), "c_tag");
	hdr.vlan_tag_[1].isValid = 1;
	hdr.vlan_tag_[0].isValid = 1;
	hdr.vlan_tag_[1].etherType = hdr.ethernet.etherType;
	hdr.vlan_tag_[1].vid = c_tag;
	hdr.vlan_tag_[0].etherType = 33024;
	hdr.vlan_tag_[0].vid = s_tag;
	hdr.ethernet.etherType = 37120;

}


// Action
void _nop_5_2102402() {
	action_run = 2102402;
	
}


// Action
void _drop_packet_2102412() {
	action_run = 2102412;
		mark_to_drop();

}


// Action
void _egress_copy_to_cpu_2102428() {
	action_run = 2102428;
	
}


// Action
void _egress_redirect_to_cpu_2102469() {
	action_run = 2102469;
		mark_to_drop();

}


// Action
void _egress_copy_to_cpu_with_reason_2102512() {
	action_run = 2102512;
	uint32_t reason_code;
	klee_make_symbolic(&reason_code, sizeof(reason_code), "reason_code");
	meta.fabric_metadata.reason_code = reason_code;

}


// Action
void _egress_redirect_to_cpu_with_reason_2102557() {
	action_run = 2102557;
	uint32_t reason_code;
	klee_make_symbolic(&reason_code, sizeof(reason_code), "reason_code");
	meta.fabric_metadata.reason_code = reason_code;
	mark_to_drop();

}


// Action
void _egress_mirror_2102608() {
	action_run = 2102608;
	uint32_t session_id;
	klee_make_symbolic(&session_id, sizeof(session_id), "session_id");
	meta.i2e_metadata.mirror_session_id = (uint32_t) session_id;

}


// Action
void _egress_mirror_drop_2102651() {
	action_run = 2102651;
	uint32_t session_id;
	klee_make_symbolic(&session_id, sizeof(session_id), "session_id");
	meta.i2e_metadata.mirror_session_id = (uint32_t) session_id;
	mark_to_drop();

}


//Table
void egress_port_mapping_2100949() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: egress_port_type_normal_0_2100849(); break;
		case 1: egress_port_type_fabric_0_2100889(); break;
		case 2: egress_port_type_cpu_0_2100919(); break;
		default: NoAction_0_2100832(); break;
	}
	// keys: standard_metadata.egress_port:exact
	// size 288
	// default_action NoAction_0();

}


//Table
void _mirror_0_2101059() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: _nop_0_2101013(); break;
		case 1: _set_mirror_nhop_2101023(); break;
		case 2: _set_mirror_bd_2101041(); break;
		default: NoAction_1_2100842(); break;
	}
	// keys: meta.i2e_metadata.mirror_session_id:exact
	// size 1024
	// default_action NoAction_1();

}


//Table
void _vlan_decap_0_2101225() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: _nop_1_2101124(); break;
		case 1: _remove_vlan_single_tagged_2101134(); break;
		case 2: _remove_vlan_double_tagged_2101174(); break;
		default: NoAction_32_2100843(); break;
	}
	// keys: hdr.vlan_tag_[0].$valid$:exact, hdr.vlan_tag_[1].$valid$:exact
	// size 1024
	// default_action NoAction_32();

}


//Table
void _rewrite_0_2101502() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: _nop_2_2101306(); break;
		case 1: _set_l2_rewrite_2101316(); break;
		case 2: _set_l2_rewrite_with_tunnel_2101350(); break;
		case 3: _set_l3_rewrite_2101400(); break;
		case 4: _set_l3_rewrite_with_tunnel_2101447(); break;
		default: NoAction_33_2100844(); break;
	}
	// keys: meta.l3_metadata.nexthop_index:exact
	// size 1024
	// default_action NoAction_33();

}


//Table
void _egress_bd_map_0_2101623() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: _nop_3_2101579(); break;
		case 1: _set_egress_bd_properties_2101589(); break;
		default: NoAction_34_2100845(); break;
	}
	// keys: meta.egress_metadata.bd:exact
	// size 1024
	// default_action NoAction_34();

}


//Table
void _egress_nat_0_2102079() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: _nop_4_2101682(); break;
		case 1: _set_nat_src_rewrite_2101692(); break;
		case 2: _set_nat_dst_rewrite_2101727(); break;
		case 3: _set_nat_src_dst_rewrite_2101760(); break;
		case 4: _set_nat_src_udp_rewrite_2101801(); break;
		case 5: _set_nat_dst_udp_rewrite_2101842(); break;
		case 6: _set_nat_src_dst_udp_rewrite_2101883(); break;
		case 7: _set_nat_src_tcp_rewrite_2101940(); break;
		case 8: _set_nat_dst_tcp_rewrite_2101981(); break;
		case 9: _set_nat_src_dst_tcp_rewrite_2102022(); break;
		default: NoAction_35_2100846(); break;
	}
	// keys: meta.nat_metadata.nat_rewrite_index:exact
	// size 1024
	// default_action NoAction_35();

}


//Table
void _egress_vlan_xlate_0_2102327() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: _set_egress_packet_vlan_untagged_2102186(); break;
		case 1: _set_egress_packet_vlan_tagged_2102196(); break;
		case 2: _set_egress_packet_vlan_double_tagged_2102246(); break;
		default: NoAction_36_2100847(); break;
	}
	// keys: meta.egress_metadata.ifindex:exact, meta.egress_metadata.bd:exact
	// size 1024
	// default_action NoAction_36();

}


//Table
void _egress_system_acl_0_2102697() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: _nop_5_2102402(); break;
		case 1: _drop_packet_2102412(); break;
		case 2: _egress_copy_to_cpu_2102428(); break;
		case 3: _egress_redirect_to_cpu_2102469(); break;
		case 4: _egress_copy_to_cpu_with_reason_2102512(); break;
		case 5: _egress_redirect_to_cpu_with_reason_2102557(); break;
		case 6: _egress_mirror_2102608(); break;
		case 7: _egress_mirror_drop_2102651(); break;
		default: NoAction_37_2100848(); break;
	}
	// keys: meta.fabric_metadata.reason_code:ternary, standard_metadata.egress_port:ternary, meta.intrinsic_metadata.deflection_flag:ternary, meta.l3_metadata.l3_mtu_check:ternary, meta.acl_metadata.acl_deny:ternary
	// size 512
	// default_action NoAction_37();

}



typedef struct {
	uint32_t field_5 : 16;
	uint8_t field_6 : 8;
} tuple_2;

//Control

void ingress() {
	_ingress_port_mapping_0_2103219();
	_ingress_port_properties_0_2103271();
	_validate_outer_ethernet_0_2103771();
	if(action_run == 2103321) {
		 
	}
	_switch_config_params_0_2103982();
	_port_vlan_mapping_0_2104388();
	_adjust_lkp_fields_0_2104323();
	if((meta.ingress_metadata.port_type != 0)) {
	_fabric_ingress_dst_lkp_2104591();
}
	if((meta.ingress_metadata.port_type != 1)) {
		if((meta.ingress_metadata.bypass_lookups & 64 == 0) && (meta.ingress_metadata.drop_flag == 0)) {
	_validate_packet_0_2104812();
}
	rmac_2103056();
	if(action_run == 2103040) {
		 
	}
	_nat_twice_0_2105452();
	if(action_run == 2104967) {
		 	_nat_dst_0_2105157();
	if(action_run == 2104956) {
		 	_nat_src_0_2105365();
	if(action_run == 2104966) {
		 	_nat_flow_0_2105246();

	}

	}

	}

}
	if((meta.ingress_metadata.bypass_lookups & 16 == 0)) {
	_meter_index_2_2105596();
}
	_compute_other_hashes_0_2105720();
	if((meta.ingress_metadata.bypass_lookups & 16 == 0)) {
	_meter_action_0_2105801();
}
	if((meta.ingress_metadata.port_type != 1)) {
		if((meta.ingress_metadata.bypass_lookups != 65535)) {
	_fwd_result_0_2106125();
}
	if((meta.nexthop_metadata.nexthop_type == 1)) {
	_ecmp_group_0_2106564();
} else {
	_nexthop_0_2106659();
}
	if((meta.ingress_metadata.egress_ifindex == 65535)) {
	
} else {
	_lag_group_0_2106749();
}

}
	if((meta.ingress_metadata.port_type != 1)) {
	if((meta.ingress_metadata.bypass_lookups & 32 == 0)) {
		_system_acl_0_2107331();
	if((meta.ingress_metadata.drop_flag == 1)) {
	_drop_stats_4_2107293();
}

}
}
}

// Action
void NoAction_38_2103002() {
	action_run = 2103002;
	
}


// Action
void NoAction_39_2103003() {
	action_run = 2103003;
	
}


// Action
void NoAction_40_2103004() {
	action_run = 2103004;
	
}


// Action
void NoAction_41_2103005() {
	action_run = 2103005;
	
}


// Action
void NoAction_42_2103006() {
	action_run = 2103006;
	
}


// Action
void NoAction_43_2103007() {
	action_run = 2103007;
	
}


// Action
void NoAction_44_2103008() {
	action_run = 2103008;
	
}


// Action
void NoAction_45_2103009() {
	action_run = 2103009;
	
}


// Action
void NoAction_46_2103010() {
	action_run = 2103010;
	
}


// Action
void NoAction_47_2103011() {
	action_run = 2103011;
	
}


// Action
void NoAction_48_2103012() {
	action_run = 2103012;
	
}


// Action
void NoAction_49_2103013() {
	action_run = 2103013;
	
}


// Action
void NoAction_50_2103014() {
	action_run = 2103014;
	
}


// Action
void NoAction_51_2103015() {
	action_run = 2103015;
	
}


// Action
void NoAction_52_2103016() {
	action_run = 2103016;
	
}


// Action
void NoAction_53_2103017() {
	action_run = 2103017;
	
}


// Action
void NoAction_54_2103018() {
	action_run = 2103018;
	
}


// Action
void NoAction_55_2103019() {
	action_run = 2103019;
	
}


// Action
void NoAction_56_2103020() {
	action_run = 2103020;
	
}


// Action
void NoAction_57_2103021() {
	action_run = 2103021;
	
}


// Action
void NoAction_58_2103022() {
	action_run = 2103022;
	
}


// Action
void NoAction_59_2103023() {
	action_run = 2103023;
	
}


// Action
void rmac_hit_0_2103024() {
	action_run = 2103024;
		meta.l3_metadata.rmac_hit = 1;

}


// Action
void rmac_miss_0_2103040() {
	action_run = 2103040;
		meta.l3_metadata.rmac_hit = 0;

}


// Action
void _set_ifindex_2103127() {
	action_run = 2103127;
	uint32_t ifindex;
	klee_make_symbolic(&ifindex, sizeof(ifindex), "ifindex");
uint8_t port_type;
	klee_make_symbolic(&port_type, sizeof(port_type), "port_type");
	meta.ingress_metadata.ifindex = ifindex;
	meta.ingress_metadata.port_type = port_type;

}


// Action
void _set_ingress_port_properties_2103153() {
	action_run = 2103153;
	uint32_t if_label;
	klee_make_symbolic(&if_label, sizeof(if_label), "if_label");
uint8_t qos_group;
	klee_make_symbolic(&qos_group, sizeof(qos_group), "qos_group");
uint8_t tc_qos_group;
	klee_make_symbolic(&tc_qos_group, sizeof(tc_qos_group), "tc_qos_group");
uint8_t tc;
	klee_make_symbolic(&tc, sizeof(tc), "tc");
uint8_t color;
	klee_make_symbolic(&color, sizeof(color), "color");
uint8_t trust_dscp;
	klee_make_symbolic(&trust_dscp, sizeof(trust_dscp), "trust_dscp");
uint8_t trust_pcp;
	klee_make_symbolic(&trust_pcp, sizeof(trust_pcp), "trust_pcp");
	meta.acl_metadata.if_label = if_label;
	meta.qos_metadata.ingress_qos_group = qos_group;
	meta.qos_metadata.tc_qos_group = tc_qos_group;
	meta.qos_metadata.lkp_tc = tc;
	meta.meter_metadata.packet_color = color;
	meta.qos_metadata.trust_dscp = trust_dscp;
	meta.qos_metadata.trust_pcp = trust_pcp;

}


// Action
void _malformed_outer_ethernet_packet_2103321() {
	action_run = 2103321;
	uint8_t drop_reason;
	klee_make_symbolic(&drop_reason, sizeof(drop_reason), "drop_reason");
	meta.ingress_metadata.drop_flag = 1;
	meta.ingress_metadata.drop_reason = drop_reason;

}


// Action
void _set_valid_outer_unicast_packet_untagged_2103345() {
	action_run = 2103345;
		meta.l2_metadata.lkp_pkt_type = 1;
	meta.l2_metadata.lkp_mac_type = hdr.ethernet.etherType;

}


// Action
void _set_valid_outer_unicast_packet_single_tagged_2103370() {
	action_run = 2103370;
		meta.l2_metadata.lkp_pkt_type = 1;
	meta.l2_metadata.lkp_mac_type = hdr.vlan_tag_[0].etherType;
	meta.l2_metadata.lkp_pcp = hdr.vlan_tag_[0].pcp;

}


// Action
void _set_valid_outer_unicast_packet_double_tagged_2103410() {
	action_run = 2103410;
		meta.l2_metadata.lkp_pkt_type = 1;
	meta.l2_metadata.lkp_mac_type = hdr.vlan_tag_[1].etherType;
	meta.l2_metadata.lkp_pcp = hdr.vlan_tag_[0].pcp;

}


// Action
void _set_valid_outer_unicast_packet_qinq_tagged_2103450() {
	action_run = 2103450;
		meta.l2_metadata.lkp_pkt_type = 1;
	meta.l2_metadata.lkp_mac_type = hdr.ethernet.etherType;
	meta.l2_metadata.lkp_pcp = hdr.vlan_tag_[0].pcp;

}


// Action
void _set_valid_outer_multicast_packet_untagged_2103487() {
	action_run = 2103487;
		meta.l2_metadata.lkp_pkt_type = 2;
	meta.l2_metadata.lkp_mac_type = hdr.ethernet.etherType;

}


// Action
void _set_valid_outer_multicast_packet_single_tagged_2103512() {
	action_run = 2103512;
		meta.l2_metadata.lkp_pkt_type = 2;
	meta.l2_metadata.lkp_mac_type = hdr.vlan_tag_[0].etherType;
	meta.l2_metadata.lkp_pcp = hdr.vlan_tag_[0].pcp;

}


// Action
void _set_valid_outer_multicast_packet_double_tagged_2103552() {
	action_run = 2103552;
		meta.l2_metadata.lkp_pkt_type = 2;
	meta.l2_metadata.lkp_mac_type = hdr.vlan_tag_[1].etherType;
	meta.l2_metadata.lkp_pcp = hdr.vlan_tag_[0].pcp;

}


// Action
void _set_valid_outer_multicast_packet_qinq_tagged_2103592() {
	action_run = 2103592;
		meta.l2_metadata.lkp_pkt_type = 2;
	meta.l2_metadata.lkp_mac_type = hdr.ethernet.etherType;
	meta.l2_metadata.lkp_pcp = hdr.vlan_tag_[0].pcp;

}


// Action
void _set_valid_outer_broadcast_packet_untagged_2103629() {
	action_run = 2103629;
		meta.l2_metadata.lkp_pkt_type = 4;
	meta.l2_metadata.lkp_mac_type = hdr.ethernet.etherType;

}


// Action
void _set_valid_outer_broadcast_packet_single_tagged_2103654() {
	action_run = 2103654;
		meta.l2_metadata.lkp_pkt_type = 4;
	meta.l2_metadata.lkp_mac_type = hdr.vlan_tag_[0].etherType;
	meta.l2_metadata.lkp_pcp = hdr.vlan_tag_[0].pcp;

}


// Action
void _set_valid_outer_broadcast_packet_double_tagged_2103694() {
	action_run = 2103694;
		meta.l2_metadata.lkp_pkt_type = 4;
	meta.l2_metadata.lkp_mac_type = hdr.vlan_tag_[1].etherType;
	meta.l2_metadata.lkp_pcp = hdr.vlan_tag_[0].pcp;

}


// Action
void _set_valid_outer_broadcast_packet_qinq_tagged_2103734() {
	action_run = 2103734;
		meta.l2_metadata.lkp_pkt_type = 4;
	meta.l2_metadata.lkp_mac_type = hdr.ethernet.etherType;
	meta.l2_metadata.lkp_pcp = hdr.vlan_tag_[0].pcp;

}


// Action
void _set_config_parameters_2103932() {
	action_run = 2103932;
	uint8_t enable_dod;
	klee_make_symbolic(&enable_dod, sizeof(enable_dod), "enable_dod");
	meta.intrinsic_metadata.deflect_on_drop = enable_dod;
	meta.i2e_metadata.ingress_tstamp = (uint32_t) meta.intrinsic_metadata.ingress_global_timestamp;
	meta.ingress_metadata.ingress_port = standard_metadata.ingress_port;
	meta.l2_metadata.same_if_check = meta.ingress_metadata.ifindex;
	standard_metadata.egress_spec = 511;

}


// Action
void _non_ip_lkp_2104020() {
	action_run = 2104020;
		meta.l2_metadata.lkp_mac_sa = hdr.ethernet.srcAddr;
	meta.l2_metadata.lkp_mac_da = hdr.ethernet.dstAddr;

}


// Action
void _ipv4_lkp_2104048() {
	action_run = 2104048;
		meta.l2_metadata.lkp_mac_sa = hdr.ethernet.srcAddr;
	meta.l2_metadata.lkp_mac_da = hdr.ethernet.dstAddr;
	meta.ipv4_metadata.lkp_ipv4_sa = hdr.ipv4.srcAddr;
	meta.ipv4_metadata.lkp_ipv4_da = hdr.ipv4.dstAddr;
	meta.l3_metadata.lkp_ip_proto = hdr.ipv4.protocol;
	meta.l3_metadata.lkp_ip_ttl = hdr.ipv4.ttl;
	meta.l3_metadata.lkp_l4_sport = meta.l3_metadata.lkp_outer_l4_sport;
	meta.l3_metadata.lkp_l4_dport = meta.l3_metadata.lkp_outer_l4_dport;

}


// Action
void _set_bd_properties_2104130() {
	action_run = 2104130;
	uint32_t bd;
	klee_make_symbolic(&bd, sizeof(bd), "bd");
uint32_t vrf;
	klee_make_symbolic(&vrf, sizeof(vrf), "vrf");
uint32_t stp_group;
	klee_make_symbolic(&stp_group, sizeof(stp_group), "stp_group");
uint8_t learning_enabled;
	klee_make_symbolic(&learning_enabled, sizeof(learning_enabled), "learning_enabled");
uint32_t bd_label;
	klee_make_symbolic(&bd_label, sizeof(bd_label), "bd_label");
uint32_t stats_idx;
	klee_make_symbolic(&stats_idx, sizeof(stats_idx), "stats_idx");
uint32_t rmac_group;
	klee_make_symbolic(&rmac_group, sizeof(rmac_group), "rmac_group");
uint8_t ipv4_unicast_enabled;
	klee_make_symbolic(&ipv4_unicast_enabled, sizeof(ipv4_unicast_enabled), "ipv4_unicast_enabled");
uint8_t ipv6_unicast_enabled;
	klee_make_symbolic(&ipv6_unicast_enabled, sizeof(ipv6_unicast_enabled), "ipv6_unicast_enabled");
uint8_t ipv4_urpf_mode;
	klee_make_symbolic(&ipv4_urpf_mode, sizeof(ipv4_urpf_mode), "ipv4_urpf_mode");
uint8_t ipv6_urpf_mode;
	klee_make_symbolic(&ipv6_urpf_mode, sizeof(ipv6_urpf_mode), "ipv6_urpf_mode");
uint8_t igmp_snooping_enabled;
	klee_make_symbolic(&igmp_snooping_enabled, sizeof(igmp_snooping_enabled), "igmp_snooping_enabled");
uint8_t mld_snooping_enabled;
	klee_make_symbolic(&mld_snooping_enabled, sizeof(mld_snooping_enabled), "mld_snooping_enabled");
uint8_t ipv4_multicast_enabled;
	klee_make_symbolic(&ipv4_multicast_enabled, sizeof(ipv4_multicast_enabled), "ipv4_multicast_enabled");
uint8_t ipv6_multicast_enabled;
	klee_make_symbolic(&ipv6_multicast_enabled, sizeof(ipv6_multicast_enabled), "ipv6_multicast_enabled");
uint32_t mrpf_group;
	klee_make_symbolic(&mrpf_group, sizeof(mrpf_group), "mrpf_group");
uint32_t ipv4_mcast_key;
	klee_make_symbolic(&ipv4_mcast_key, sizeof(ipv4_mcast_key), "ipv4_mcast_key");
uint8_t ipv4_mcast_key_type;
	klee_make_symbolic(&ipv4_mcast_key_type, sizeof(ipv4_mcast_key_type), "ipv4_mcast_key_type");
uint32_t ipv6_mcast_key;
	klee_make_symbolic(&ipv6_mcast_key, sizeof(ipv6_mcast_key), "ipv6_mcast_key");
uint8_t ipv6_mcast_key_type;
	klee_make_symbolic(&ipv6_mcast_key_type, sizeof(ipv6_mcast_key_type), "ipv6_mcast_key_type");
	meta.ingress_metadata.bd = bd;
	meta.ingress_metadata.outer_bd = bd;
	meta.acl_metadata.bd_label = bd_label;
	meta.l2_metadata.stp_group = stp_group;
	meta.l2_metadata.bd_stats_idx = stats_idx;
	meta.l2_metadata.learning_enabled = learning_enabled;
	meta.l3_metadata.vrf = vrf;
	meta.ipv4_metadata.ipv4_unicast_enabled = ipv4_unicast_enabled;
	meta.ipv6_metadata.ipv6_unicast_enabled = ipv6_unicast_enabled;
	meta.ipv4_metadata.ipv4_urpf_mode = ipv4_urpf_mode;
	meta.ipv6_metadata.ipv6_urpf_mode = ipv6_urpf_mode;
	meta.l3_metadata.rmac_group = rmac_group;
	meta.multicast_metadata.igmp_snooping_enabled = igmp_snooping_enabled;
	meta.multicast_metadata.mld_snooping_enabled = mld_snooping_enabled;
	meta.multicast_metadata.ipv4_multicast_enabled = ipv4_multicast_enabled;
	meta.multicast_metadata.ipv6_multicast_enabled = ipv6_multicast_enabled;
	meta.multicast_metadata.bd_mrpf_group = mrpf_group;
	meta.multicast_metadata.ipv4_mcast_key_type = ipv4_mcast_key_type;
	meta.multicast_metadata.ipv4_mcast_key = ipv4_mcast_key;
	meta.multicast_metadata.ipv6_mcast_key_type = ipv6_mcast_key_type;
	meta.multicast_metadata.ipv6_mcast_key = ipv6_mcast_key;

}


// Action
void _port_vlan_mapping_miss_2104307() {
	action_run = 2104307;
		meta.l2_metadata.port_vlan_mapping_miss = 1;

}


// Action
void _nop_6_2104511() {
	action_run = 2104511;
	
}


// Action
void _terminate_cpu_packet_0_2104521() {
	action_run = 2104521;
		standard_metadata.egress_spec = (uint32_t) hdr.fabric_header.dstPortOrGroup;
	meta.egress_metadata.bypass = hdr.fabric_header_cpu.txBypass;
	meta.intrinsic_metadata.mcast_grp = hdr.fabric_header_cpu.mcast_grp;
	hdr.ethernet.etherType = hdr.fabric_payload_header.etherType;
	hdr.fabric_header.isValid = 0;
	hdr.fabric_header_cpu.isValid = 0;
	hdr.fabric_payload_header.isValid = 0;

}


// Action
void _nop_7_2104646() {
	action_run = 2104646;
	
}


// Action
void _set_unicast_2104656() {
	action_run = 2104656;
		meta.l2_metadata.lkp_pkt_type = 1;

}


// Action
void _set_unicast_and_ipv6_src_is_link_local_2104672() {
	action_run = 2104672;
		meta.l2_metadata.lkp_pkt_type = 1;
	meta.ipv6_metadata.ipv6_src_is_link_local = 1;

}


// Action
void _set_multicast_2104694() {
	action_run = 2104694;
		meta.l2_metadata.lkp_pkt_type = 2;
	meta.l2_metadata.bd_stats_idx = meta.l2_metadata.bd_stats_idx + 1;

}


// Action
void _set_multicast_and_ipv6_src_is_link_local_2104721() {
	action_run = 2104721;
		meta.l2_metadata.lkp_pkt_type = 2;
	meta.ipv6_metadata.ipv6_src_is_link_local = 1;
	meta.l2_metadata.bd_stats_idx = meta.l2_metadata.bd_stats_idx + 1;

}


// Action
void _set_broadcast_2104754() {
	action_run = 2104754;
		meta.l2_metadata.lkp_pkt_type = 4;
	meta.l2_metadata.bd_stats_idx = meta.l2_metadata.bd_stats_idx + 2;

}


// Action
void _set_malformed_packet_2104781() {
	action_run = 2104781;
	uint8_t drop_reason;
	klee_make_symbolic(&drop_reason, sizeof(drop_reason), "drop_reason");
	traverse_2104798 = 1;
	meta.ingress_metadata.drop_flag = 1;
	meta.ingress_metadata.drop_reason = drop_reason;

}


// Action
void _on_miss_2104956() {
	action_run = 2104956;
	
}


// Action
void _on_miss_3_2104966() {
	action_run = 2104966;
	
}


// Action
void _on_miss_4_2104967() {
	action_run = 2104967;
	
}


// Action
void _set_dst_nat_nexthop_index_2104968() {
	action_run = 2104968;
	uint32_t nexthop_index;
	klee_make_symbolic(&nexthop_index, sizeof(nexthop_index), "nexthop_index");
uint8_t nexthop_type;
	klee_make_symbolic(&nexthop_type, sizeof(nexthop_type), "nexthop_type");
uint32_t nat_rewrite_index;
	klee_make_symbolic(&nat_rewrite_index, sizeof(nat_rewrite_index), "nat_rewrite_index");
	meta.nat_metadata.nat_nexthop = nexthop_index;
	meta.nat_metadata.nat_nexthop_type = nexthop_type;
	meta.nat_metadata.nat_rewrite_index = nat_rewrite_index;
	meta.nat_metadata.nat_hit = 1;

}


// Action
void _set_dst_nat_nexthop_index_2_2105008() {
	action_run = 2105008;
	uint32_t nexthop_index;
	klee_make_symbolic(&nexthop_index, sizeof(nexthop_index), "nexthop_index");
uint8_t nexthop_type;
	klee_make_symbolic(&nexthop_type, sizeof(nexthop_type), "nexthop_type");
uint32_t nat_rewrite_index;
	klee_make_symbolic(&nat_rewrite_index, sizeof(nat_rewrite_index), "nat_rewrite_index");
	meta.nat_metadata.nat_nexthop = nexthop_index;
	meta.nat_metadata.nat_nexthop_type = nexthop_type;
	meta.nat_metadata.nat_rewrite_index = nat_rewrite_index;
	meta.nat_metadata.nat_hit = 1;

}


// Action
void _nop_8_2105042() {
	action_run = 2105042;
	
}


// Action
void _set_src_nat_rewrite_index_2105052() {
	action_run = 2105052;
	uint32_t nat_rewrite_index;
	klee_make_symbolic(&nat_rewrite_index, sizeof(nat_rewrite_index), "nat_rewrite_index");
	meta.nat_metadata.nat_rewrite_index = nat_rewrite_index;

}


// Action
void _set_src_nat_rewrite_index_2_2105070() {
	action_run = 2105070;
	uint32_t nat_rewrite_index;
	klee_make_symbolic(&nat_rewrite_index, sizeof(nat_rewrite_index), "nat_rewrite_index");
	meta.nat_metadata.nat_rewrite_index = nat_rewrite_index;

}


// Action
void _set_twice_nat_nexthop_index_2105083() {
	action_run = 2105083;
	uint32_t nexthop_index;
	klee_make_symbolic(&nexthop_index, sizeof(nexthop_index), "nexthop_index");
uint8_t nexthop_type;
	klee_make_symbolic(&nexthop_type, sizeof(nexthop_type), "nexthop_type");
uint32_t nat_rewrite_index;
	klee_make_symbolic(&nat_rewrite_index, sizeof(nat_rewrite_index), "nat_rewrite_index");
	meta.nat_metadata.nat_nexthop = nexthop_index;
	meta.nat_metadata.nat_nexthop_type = nexthop_type;
	meta.nat_metadata.nat_rewrite_index = nat_rewrite_index;
	meta.nat_metadata.nat_hit = 1;

}


// Action
void _set_twice_nat_nexthop_index_2_2105123() {
	action_run = 2105123;
	uint32_t nexthop_index;
	klee_make_symbolic(&nexthop_index, sizeof(nexthop_index), "nexthop_index");
uint8_t nexthop_type;
	klee_make_symbolic(&nexthop_type, sizeof(nexthop_type), "nexthop_type");
uint32_t nat_rewrite_index;
	klee_make_symbolic(&nat_rewrite_index, sizeof(nat_rewrite_index), "nat_rewrite_index");
	meta.nat_metadata.nat_nexthop = nexthop_index;
	meta.nat_metadata.nat_nexthop_type = nexthop_type;
	meta.nat_metadata.nat_rewrite_index = nat_rewrite_index;
	meta.nat_metadata.nat_hit = 1;

}


// Action
void _nop_9_2105575() {
	action_run = 2105575;
			uint64_t tmp_symbolic;
	klee_make_symbolic(&tmp_symbolic, sizeof(tmp_symbolic), "tmp_symbolic");
	meta.meter_metadata.packet_color = tmp_symbolic;


}


// Action
void _computed_two_hashes_2105653() {
	action_run = 2105653;
		meta.intrinsic_metadata.mcast_hash = (uint32_t) meta.hash_metadata.hash1;
	meta.hash_metadata.entropy_hash = meta.hash_metadata.hash2;

}


// Action
void _computed_one_hash_2105682() {
	action_run = 2105682;
		meta.hash_metadata.hash1 = meta.hash_metadata.hash2;
	meta.intrinsic_metadata.mcast_hash = (uint32_t) meta.hash_metadata.hash2;
	meta.hash_metadata.entropy_hash = meta.hash_metadata.hash2;

}


// Action
void _meter_permit_2105775() {
	action_run = 2105775;
	
}


// Action
void _meter_deny_2105785() {
	action_run = 2105785;
		mark_to_drop();

}


// Action
void _nop_10_2105870() {
	action_run = 2105870;
	
}


// Action
void _set_l2_redirect_action_2105880() {
	action_run = 2105880;
		meta.l3_metadata.nexthop_index = meta.l2_metadata.l2_nexthop;
	meta.nexthop_metadata.nexthop_type = meta.l2_metadata.l2_nexthop_type;
	meta.ingress_metadata.egress_ifindex = 0;
	meta.intrinsic_metadata.mcast_grp = 0;

}


// Action
void _set_fib_redirect_action_2105920() {
	action_run = 2105920;
		meta.l3_metadata.nexthop_index = meta.l3_metadata.fib_nexthop;
	meta.nexthop_metadata.nexthop_type = meta.l3_metadata.fib_nexthop_type;
	meta.l3_metadata.routed = 1;
	meta.intrinsic_metadata.mcast_grp = 0;
	meta.fabric_metadata.reason_code = 535;

}


// Action
void _set_cpu_redirect_action_2105966() {
	action_run = 2105966;
		meta.l3_metadata.routed = 0;
	meta.intrinsic_metadata.mcast_grp = 0;
	standard_metadata.egress_spec = 64;
	meta.ingress_metadata.egress_ifindex = 0;

}


// Action
void _set_acl_redirect_action_2105999() {
	action_run = 2105999;
		meta.l3_metadata.nexthop_index = meta.acl_metadata.acl_nexthop;
	meta.nexthop_metadata.nexthop_type = meta.acl_metadata.acl_nexthop_type;
	meta.ingress_metadata.egress_ifindex = 0;
	meta.intrinsic_metadata.mcast_grp = 0;

}


// Action
void _set_racl_redirect_action_2106039() {
	action_run = 2106039;
		meta.l3_metadata.nexthop_index = meta.acl_metadata.racl_nexthop;
	meta.nexthop_metadata.nexthop_type = meta.acl_metadata.racl_nexthop_type;
	meta.l3_metadata.routed = 1;
	meta.ingress_metadata.egress_ifindex = 0;
	meta.intrinsic_metadata.mcast_grp = 0;

}


// Action
void _set_nat_redirect_action_2106085() {
	action_run = 2106085;
		meta.l3_metadata.nexthop_index = meta.nat_metadata.nat_nexthop;
	meta.nexthop_metadata.nexthop_type = meta.nat_metadata.nat_nexthop_type;
	meta.l3_metadata.routed = 1;
	meta.intrinsic_metadata.mcast_grp = 0;

}


// Action
void _nop_11_2106344() {
	action_run = 2106344;
	
}


// Action
void _nop_12_2106354() {
	action_run = 2106354;
	
}


// Action
void _set_ecmp_nexthop_details_2106355() {
	action_run = 2106355;
	uint32_t ifindex;
	klee_make_symbolic(&ifindex, sizeof(ifindex), "ifindex");
uint32_t bd;
	klee_make_symbolic(&bd, sizeof(bd), "bd");
uint32_t nhop_index;
	klee_make_symbolic(&nhop_index, sizeof(nhop_index), "nhop_index");
uint8_t tunnel;
	klee_make_symbolic(&tunnel, sizeof(tunnel), "tunnel");
	traverse_2106375 = 1;constant_l3_metadata_nexthop_index_2106375 = l3_metadata.nexthop_index;
	meta.ingress_metadata.egress_ifindex = ifindex;
	meta.l3_metadata.nexthop_index = nhop_index;
	meta.l3_metadata.same_bd_check = meta.ingress_metadata.bd ^ bd;
	meta.l2_metadata.same_if_check = meta.l2_metadata.same_if_check ^ ifindex;
	meta.tunnel_metadata.tunnel_if_check = meta.tunnel_metadata.tunnel_terminate ^ tunnel;

}


// Action
void _set_ecmp_nexthop_details_for_post_routed_flood_2106426() {
	action_run = 2106426;
	uint32_t bd;
	klee_make_symbolic(&bd, sizeof(bd), "bd");
uint32_t uuc_mc_index;
	klee_make_symbolic(&uuc_mc_index, sizeof(uuc_mc_index), "uuc_mc_index");
uint32_t nhop_index;
	klee_make_symbolic(&nhop_index, sizeof(nhop_index), "nhop_index");
	meta.intrinsic_metadata.mcast_grp = uuc_mc_index;
	meta.l3_metadata.nexthop_index = nhop_index;
	meta.ingress_metadata.egress_ifindex = 0;
	meta.l3_metadata.same_bd_check = meta.ingress_metadata.bd ^ bd;

}


// Action
void _set_nexthop_details_2106471() {
	action_run = 2106471;
	uint32_t ifindex;
	klee_make_symbolic(&ifindex, sizeof(ifindex), "ifindex");
uint32_t bd;
	klee_make_symbolic(&bd, sizeof(bd), "bd");
uint8_t tunnel;
	klee_make_symbolic(&tunnel, sizeof(tunnel), "tunnel");
	meta.ingress_metadata.egress_ifindex = ifindex;
	meta.l3_metadata.same_bd_check = meta.ingress_metadata.bd ^ bd;
	meta.l2_metadata.same_if_check = meta.l2_metadata.same_if_check ^ ifindex;
	meta.tunnel_metadata.tunnel_if_check = meta.tunnel_metadata.tunnel_terminate ^ tunnel;

}


// Action
void _set_nexthop_details_for_post_routed_flood_2106527() {
	action_run = 2106527;
	uint32_t bd;
	klee_make_symbolic(&bd, sizeof(bd), "bd");
uint32_t uuc_mc_index;
	klee_make_symbolic(&uuc_mc_index, sizeof(uuc_mc_index), "uuc_mc_index");
	meta.intrinsic_metadata.mcast_grp = uuc_mc_index;
	meta.ingress_metadata.egress_ifindex = 0;
	meta.l3_metadata.same_bd_check = meta.ingress_metadata.bd ^ bd;

}


// Action
void _set_lag_miss_2106722() {
	action_run = 2106722;
	
}


// Action
void _set_lag_port_2106732() {
	action_run = 2106732;
	uint32_t port;
	klee_make_symbolic(&port, sizeof(port), "port");
	standard_metadata.egress_spec = port;

}


// Action
void _drop_stats_update_2106883() {
	action_run = 2106883;
	
}


// Action
void _nop_26_2106905() {
	action_run = 2106905;
	
}


// Action
void _copy_to_cpu_2106915() {
	action_run = 2106915;
	uint8_t qid;
	klee_make_symbolic(&qid, sizeof(qid), "qid");
uint32_t meter_id;
	klee_make_symbolic(&meter_id, sizeof(meter_id), "meter_id");
uint8_t icos;
	klee_make_symbolic(&icos, sizeof(icos), "icos");
	meta.intrinsic_metadata.qid = qid;
	meta.intrinsic_metadata.ingress_cos = icos;
		uint64_t tmp_symbolic;
	klee_make_symbolic(&tmp_symbolic, sizeof(tmp_symbolic), "tmp_symbolic");
	meta.intrinsic_metadata.packet_color = tmp_symbolic;


}


// Action
void _redirect_to_cpu_2106984() {
	action_run = 2106984;
	uint8_t qid;
	klee_make_symbolic(&qid, sizeof(qid), "qid");
uint32_t meter_id;
	klee_make_symbolic(&meter_id, sizeof(meter_id), "meter_id");
uint8_t icos;
	klee_make_symbolic(&icos, sizeof(icos), "icos");
	meta.intrinsic_metadata.qid = qid;
	meta.intrinsic_metadata.ingress_cos = icos;
		uint64_t tmp_symbolic;
	klee_make_symbolic(&tmp_symbolic, sizeof(tmp_symbolic), "tmp_symbolic");
	meta.intrinsic_metadata.packet_color = tmp_symbolic;

	mark_to_drop();

}


// Action
void _copy_to_cpu_with_reason_2107056() {
	action_run = 2107056;
	uint32_t reason_code;
	klee_make_symbolic(&reason_code, sizeof(reason_code), "reason_code");
uint8_t qid;
	klee_make_symbolic(&qid, sizeof(qid), "qid");
uint32_t meter_id;
	klee_make_symbolic(&meter_id, sizeof(meter_id), "meter_id");
uint8_t icos;
	klee_make_symbolic(&icos, sizeof(icos), "icos");
	meta.fabric_metadata.reason_code = reason_code;
	meta.intrinsic_metadata.qid = qid;
	meta.intrinsic_metadata.ingress_cos = icos;
		uint64_t tmp_symbolic;
	klee_make_symbolic(&tmp_symbolic, sizeof(tmp_symbolic), "tmp_symbolic");
	meta.intrinsic_metadata.packet_color = tmp_symbolic;


}


// Action
void _redirect_to_cpu_with_reason_2107130() {
	action_run = 2107130;
	uint32_t reason_code;
	klee_make_symbolic(&reason_code, sizeof(reason_code), "reason_code");
uint8_t qid;
	klee_make_symbolic(&qid, sizeof(qid), "qid");
uint32_t meter_id;
	klee_make_symbolic(&meter_id, sizeof(meter_id), "meter_id");
uint8_t icos;
	klee_make_symbolic(&icos, sizeof(icos), "icos");
	meta.fabric_metadata.reason_code = reason_code;
	meta.intrinsic_metadata.qid = qid;
	meta.intrinsic_metadata.ingress_cos = icos;
		uint64_t tmp_symbolic;
	klee_make_symbolic(&tmp_symbolic, sizeof(tmp_symbolic), "tmp_symbolic");
	meta.intrinsic_metadata.packet_color = tmp_symbolic;

	mark_to_drop();

}


// Action
void _drop_packet_0_2107210() {
	action_run = 2107210;
		mark_to_drop();

}


// Action
void _drop_packet_with_reason_2107226() {
	action_run = 2107226;
	uint32_t drop_reason;
	klee_make_symbolic(&drop_reason, sizeof(drop_reason), "drop_reason");
	mark_to_drop();

}


// Action
void _negative_mirror_2107252() {
	action_run = 2107252;
	uint32_t session_id;
	klee_make_symbolic(&session_id, sizeof(session_id), "session_id");
	mark_to_drop();

}


//Table
void rmac_2103056() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: rmac_hit_0_2103024(); break;
		case 1: rmac_miss_0_2103040(); break;
		default: NoAction_38_2103002(); break;
	}
	// keys: meta.l3_metadata.rmac_group:exact, meta.l2_metadata.lkp_mac_da:exact
	// size 1024
	// default_action NoAction_38();

}


//Table
void _ingress_port_mapping_0_2103219() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: _set_ifindex_2103127(); break;
		default: NoAction_39_2103003(); break;
	}
	// keys: standard_metadata.ingress_port:exact
	// size 288
	// default_action NoAction_39();

}


//Table
void _ingress_port_properties_0_2103271() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: _set_ingress_port_properties_2103153(); break;
		default: NoAction_40_2103004(); break;
	}
	// keys: standard_metadata.ingress_port:exact
	// size 288
	// default_action NoAction_40();

}


//Table
void _validate_outer_ethernet_0_2103771() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: _malformed_outer_ethernet_packet_2103321(); break;
		case 1: _set_valid_outer_unicast_packet_untagged_2103345(); break;
		case 2: _set_valid_outer_unicast_packet_single_tagged_2103370(); break;
		case 3: _set_valid_outer_unicast_packet_double_tagged_2103410(); break;
		case 4: _set_valid_outer_unicast_packet_qinq_tagged_2103450(); break;
		case 5: _set_valid_outer_multicast_packet_untagged_2103487(); break;
		case 6: _set_valid_outer_multicast_packet_single_tagged_2103512(); break;
		case 7: _set_valid_outer_multicast_packet_double_tagged_2103552(); break;
		case 8: _set_valid_outer_multicast_packet_qinq_tagged_2103592(); break;
		case 9: _set_valid_outer_broadcast_packet_untagged_2103629(); break;
		case 10: _set_valid_outer_broadcast_packet_single_tagged_2103654(); break;
		case 11: _set_valid_outer_broadcast_packet_double_tagged_2103694(); break;
		case 12: _set_valid_outer_broadcast_packet_qinq_tagged_2103734(); break;
		default: NoAction_41_2103005(); break;
	}
	// keys: hdr.ethernet.srcAddr:ternary, hdr.ethernet.dstAddr:ternary, hdr.vlan_tag_[0].$valid$:exact, hdr.vlan_tag_[1].$valid$:exact
	// size 512
	// default_action NoAction_41();

}


//Table
void _switch_config_params_0_2103982() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: _set_config_parameters_2103932(); break;
		default: NoAction_42_2103006(); break;
	}
	// size 1
	// default_action NoAction_42();

}


//Table
void _adjust_lkp_fields_0_2104323() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: _non_ip_lkp_2104020(); break;
		case 1: _ipv4_lkp_2104048(); break;
		default: NoAction_43_2103007(); break;
	}
	// keys: hdr.ipv4.$valid$:exact, hdr.ipv6.$valid$:exact
	// default_action NoAction_43();

}


//Table
void _port_vlan_mapping_0_2104388() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: _set_bd_properties_2104130(); break;
		case 1: _port_vlan_mapping_miss_2104307(); break;
		default: NoAction_44_2103008(); break;
	}
	// keys: meta.ingress_metadata.ifindex:exact, hdr.vlan_tag_[0].$valid$:exact, hdr.vlan_tag_[0].vid:exact, hdr.vlan_tag_[1].$valid$:exact, hdr.vlan_tag_[1].vid:exact
	// size 4096
	// default_action NoAction_44();

}


//Table
void _fabric_ingress_dst_lkp_2104591() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: _nop_6_2104511(); break;
		case 1: _terminate_cpu_packet_0_2104521(); break;
		default: NoAction_45_2103009(); break;
	}
	// keys: hdr.fabric_header.dstDevice:exact
	// default_action NoAction_45();

}


//Table
void _validate_packet_0_2104812() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: _nop_7_2104646(); break;
		case 1: _set_unicast_2104656(); break;
		case 2: _set_unicast_and_ipv6_src_is_link_local_2104672(); break;
		case 3: _set_multicast_2104694(); break;
		case 4: _set_multicast_and_ipv6_src_is_link_local_2104721(); break;
		case 5: _set_broadcast_2104754(); break;
		case 6: _set_malformed_packet_2104781(); break;
		default: NoAction_46_2103010(); break;
	}
	// keys: meta.l2_metadata.lkp_mac_sa:ternary, meta.l2_metadata.lkp_mac_da:ternary, meta.l3_metadata.lkp_ip_type:ternary, meta.l3_metadata.lkp_ip_ttl:ternary, meta.l3_metadata.lkp_ip_version:ternary, BITSLICE(meta.ipv4_metadata.lkp_ipv4_sa, 31, 24):ternary
	// size 512
	// default_action NoAction_46();

}


//Table
void _nat_dst_0_2105157() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: _on_miss_2104956(); break;
		case 1: _set_dst_nat_nexthop_index_2104968(); break;
		default: NoAction_47_2103011(); break;
	}
	// keys: meta.l3_metadata.vrf:exact, meta.ipv4_metadata.lkp_ipv4_da:exact, meta.l3_metadata.lkp_ip_proto:exact, meta.l3_metadata.lkp_l4_dport:exact
	// size 1024
	// default_action NoAction_47();

}


//Table
void _nat_flow_0_2105246() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: _nop_8_2105042(); break;
		case 1: _set_src_nat_rewrite_index_2105052(); break;
		case 2: _set_dst_nat_nexthop_index_2_2105008(); break;
		case 3: _set_twice_nat_nexthop_index_2105083(); break;
		default: NoAction_48_2103012(); break;
	}
	// keys: meta.l3_metadata.vrf:ternary, meta.ipv4_metadata.lkp_ipv4_sa:ternary, meta.ipv4_metadata.lkp_ipv4_da:ternary, meta.l3_metadata.lkp_ip_proto:ternary, meta.l3_metadata.lkp_l4_sport:ternary, meta.l3_metadata.lkp_l4_dport:ternary
	// size 512
	// default_action NoAction_48();

}


//Table
void _nat_src_0_2105365() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: _on_miss_3_2104966(); break;
		case 1: _set_src_nat_rewrite_index_2_2105070(); break;
		default: NoAction_49_2103013(); break;
	}
	// keys: meta.l3_metadata.vrf:exact, meta.ipv4_metadata.lkp_ipv4_sa:exact, meta.l3_metadata.lkp_ip_proto:exact, meta.l3_metadata.lkp_l4_sport:exact
	// size 1024
	// default_action NoAction_49();

}


//Table
void _nat_twice_0_2105452() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: _on_miss_4_2104967(); break;
		case 1: _set_twice_nat_nexthop_index_2_2105123(); break;
		default: NoAction_50_2103014(); break;
	}
	// keys: meta.l3_metadata.vrf:exact, meta.ipv4_metadata.lkp_ipv4_sa:exact, meta.ipv4_metadata.lkp_ipv4_da:exact, meta.l3_metadata.lkp_ip_proto:exact, meta.l3_metadata.lkp_l4_sport:exact, meta.l3_metadata.lkp_l4_dport:exact
	// size 1024
	// default_action NoAction_50();

}


//Table
void _meter_index_2_2105596() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: _nop_9_2105575(); break;
		default: NoAction_51_2103015(); break;
	}
	// keys: meta.meter_metadata.meter_index:exact
	// size 1024
	// default_action NoAction_51();

}


//Table
void _compute_other_hashes_0_2105720() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: _computed_two_hashes_2105653(); break;
		case 1: _computed_one_hash_2105682(); break;
		default: NoAction_52_2103016(); break;
	}
	// keys: meta.hash_metadata.hash1:exact
	// default_action NoAction_52();

}


//Table
void _meter_action_0_2105801() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: _meter_permit_2105775(); break;
		case 1: _meter_deny_2105785(); break;
		default: NoAction_53_2103017(); break;
	}
	// keys: meta.meter_metadata.packet_color:exact, meta.meter_metadata.meter_index:exact
	// size 1024
	// default_action NoAction_53();

}


//Table
void _fwd_result_0_2106125() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: _nop_10_2105870(); break;
		case 1: _set_l2_redirect_action_2105880(); break;
		case 2: _set_fib_redirect_action_2105920(); break;
		case 3: _set_cpu_redirect_action_2105966(); break;
		case 4: _set_acl_redirect_action_2105999(); break;
		case 5: _set_racl_redirect_action_2106039(); break;
		case 6: _set_nat_redirect_action_2106085(); break;
		default: NoAction_54_2103018(); break;
	}
	// keys: meta.l2_metadata.l2_redirect:ternary, meta.acl_metadata.acl_redirect:ternary, meta.acl_metadata.racl_redirect:ternary, meta.l3_metadata.rmac_hit:ternary, meta.l3_metadata.fib_hit:ternary, meta.nat_metadata.nat_hit:ternary, meta.l2_metadata.lkp_pkt_type:ternary, meta.l3_metadata.lkp_ip_type:ternary, meta.multicast_metadata.igmp_snooping_enabled:ternary, meta.multicast_metadata.mld_snooping_enabled:ternary, meta.multicast_metadata.mcast_route_hit:ternary, meta.multicast_metadata.mcast_bridge_hit:ternary, meta.multicast_metadata.mcast_rpf_group:ternary, meta.multicast_metadata.mcast_mode:ternary
	// size 512
	// default_action NoAction_54();

}


//Table
void _ecmp_group_0_2106564() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: _nop_11_2106344(); break;
		case 1: _set_ecmp_nexthop_details_2106355(); break;
		case 2: _set_ecmp_nexthop_details_for_post_routed_flood_2106426(); break;
		default: NoAction_55_2103019(); break;
	}
	// keys: meta.l3_metadata.nexthop_index:exact, meta.hash_metadata.hash1:selector
	// size 1024
	// default_action NoAction_55();

}


//Table
void _nexthop_0_2106659() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: _nop_12_2106354(); break;
		case 1: _set_nexthop_details_2106471(); break;
		case 2: _set_nexthop_details_for_post_routed_flood_2106527(); break;
		default: NoAction_56_2103020(); break;
	}
	// keys: meta.l3_metadata.nexthop_index:exact
	// size 1024
	// default_action NoAction_56();

}


//Table
void _lag_group_0_2106749() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: _set_lag_miss_2106722(); break;
		case 1: _set_lag_port_2106732(); break;
		default: NoAction_57_2103021(); break;
	}
	// keys: meta.ingress_metadata.egress_ifindex:exact, meta.hash_metadata.hash2:selector
	// size 1024
	// default_action NoAction_57();

}


//Table
void _drop_stats_4_2107293() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: _drop_stats_update_2106883(); break;
		default: NoAction_58_2103022(); break;
	}
	// size 1024
	// default_action NoAction_58();

}


//Table
void _system_acl_0_2107331() {
	int symbol;
	klee_make_symbolic(&symbol, sizeof(symbol), "symbol");
	switch(symbol) {
		case 0: _nop_26_2106905(); break;
		case 1: _redirect_to_cpu_2106984(); break;
		case 2: _redirect_to_cpu_with_reason_2107130(); break;
		case 3: _copy_to_cpu_2106915(); break;
		case 4: _copy_to_cpu_with_reason_2107056(); break;
		case 5: _drop_packet_0_2107210(); break;
		case 6: _drop_packet_with_reason_2107226(); break;
		case 7: _negative_mirror_2107252(); break;
		default: NoAction_59_2103023(); break;
	}
	// keys: meta.acl_metadata.if_label:ternary, meta.acl_metadata.bd_label:ternary, meta.ingress_metadata.ifindex:ternary, meta.l2_metadata.lkp_mac_type:ternary, meta.l2_metadata.port_vlan_mapping_miss:ternary, meta.security_metadata.ipsg_check_fail:ternary, meta.acl_metadata.acl_deny:ternary, meta.acl_metadata.racl_deny:ternary, meta.l3_metadata.urpf_check_fail:ternary, meta.ingress_metadata.drop_flag:ternary, meta.l3_metadata.l3_copy:ternary, meta.l3_metadata.rmac_hit:ternary, meta.l3_metadata.routed:ternary, meta.ipv6_metadata.ipv6_src_is_link_local:ternary, meta.l2_metadata.same_if_check:ternary, meta.tunnel_metadata.tunnel_if_check:ternary, meta.l3_metadata.same_bd_check:ternary, meta.l3_metadata.lkp_ip_ttl:ternary, meta.l2_metadata.stp_state:ternary, meta.ingress_metadata.control_frame:ternary, meta.ipv4_metadata.ipv4_unicast_enabled:ternary, meta.ipv6_metadata.ipv6_unicast_enabled:ternary, meta.ingress_metadata.egress_ifindex:ternary, meta.fabric_metadata.reason_code:ternary
	// size 512
	// default_action NoAction_59();

}



//Control

void DeparserImpl() {
	//Emit hdr.ethernet
	
	//Emit hdr.fabric_header
	
	//Emit hdr.fabric_header_cpu
	
	//Emit hdr.fabric_payload_header
	
	//Emit hdr.llc_header
	
	//Emit hdr.snap_header
	
	//Emit hdr.vlan_tag_[0]
	emit_header_vlan_tag_[0]_2101150 = 1;emit_header_vlan_tag_[0]) && !emit(vlan_tag_[1]_2101190 = 1;
	//Emit hdr.vlan_tag_[1]
	emit_header_vlan_tag_[0]_2101150 = 1;emit_header_vlan_tag_[0]) && !emit(vlan_tag_[1]_2101190 = 1;
	//Emit hdr.ipv6
	
	//Emit hdr.inner_ipv4
	
	//Emit hdr.inner_udp
	
	//Emit hdr.inner_tcp
	
	//Emit hdr.inner_icmp
	
	//Emit hdr.ipv4
	
	//Emit hdr.udp
	
	//Emit hdr.tcp
	
	//Emit hdr.icmp
	
}


typedef struct {
	uint8_t field_7 : 4;
	uint8_t field_8 : 4;
	uint8_t field_9 : 8;
	uint32_t field_10 : 16;
	uint32_t field_11 : 16;
	uint8_t field_12 : 3;
	uint32_t field_13 : 13;
	uint8_t field_14 : 8;
	uint8_t field_15 : 8;
	uint32_t field_16 : 32;
	uint32_t field_17 : 32;
} tuple_3;

//Control
uint8_t tmp_7;
uint32_t tmp_8;
uint8_t tmp_10;
uint32_t tmp_11;

void verifyChecksum() {
	if((hdr.inner_ipv4.ihl != 5)) {
	tmp_7 = 0;
} else {
			klee_make_symbolic(&tmp_8, sizeof(tmp_8), "tmp_8");

	tmp_7 = (hdr.inner_ipv4.hdrChecksum == tmp_8);

}
	if(tmp_7) {
	mark_to_drop();
}
	if((hdr.ipv4.ihl != 5)) {
	tmp_10 = 0;
} else {
			klee_make_symbolic(&tmp_11, sizeof(tmp_11), "tmp_11");

	tmp_10 = (hdr.ipv4.hdrChecksum == tmp_11);

}
	if(tmp_10) {
	mark_to_drop();
}
}


//Control
uint32_t tmp_13;
uint32_t tmp_14;

void computeChecksum() {
	if((hdr.inner_ipv4.ihl == 5)) {
			klee_make_symbolic(&tmp_13, sizeof(tmp_13), "tmp_13");

	hdr.inner_ipv4.hdrChecksum = tmp_13;

}
	if((hdr.ipv4.ihl == 5)) {
			klee_make_symbolic(&tmp_14, sizeof(tmp_14), "tmp_14");

	hdr.ipv4.hdrChecksum = tmp_14;

}
}


int main() {
	ParserImpl();
	ingress();
	egress();
	DeparserImpl();
	end_assertions();
	return 0;
}


