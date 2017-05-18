val block99 = InstructionBlock(

)

val block5961 = InstructionBlock(

)

val block5985 = InstructionBlock(
	Assign('meta.l3_metadata.nexthop_index', :@('nhop_idx'))
)

val block6009 = InstructionBlock(
	Assign('meta.egress_metadata.bd', :@('bd'))
)

val block6059 = InstructionBlock(
	Assign('hdr.fabric_header_sflow.isValid', ConstantValue(1)),
	Assign('hdr.fabric_header_sflow.sflow_session_id', :@('meta.sflow_metadata.sflow_session_id')),
	Assign('hdr.fabric_header_sflow.sflow_egress_ifindex', :@('meta.ingress_metadata.egress_ifindex')),
	Assign('meta.fabric_metadata.reason_code', :@('reason_code'))
)

val block6123 = InstructionBlock(
	mirror
)

val block6153 = InstructionBlock(

)

val block6173 = InstructionBlock(
	Assign('meta.egress_metadata.routed', ConstantValue(0))
)

val block6260 = InstructionBlock(
	Assign('meta.egress_metadata.bd', :@('bd')),
	Assign('meta.multicast_metadata.replica', ConstantValue(1)),
	Assign('meta.multicast_metadata.inner_replica', ConstantValue(0)),
	Assign('meta.egress_metadata.routed', :@('meta.l3_metadata.outer_routed')),
	Assign('meta.egress_metadata.same_bd_check', <BXor>6237),
	Assign('meta.tunnel_metadata.tunnel_index', :@('tunnel_index')),
	Assign('meta.tunnel_metadata.egress_tunnel_type', :@('tunnel_type')),
	Assign('meta.tunnel_metadata.egress_header_count', :@('header_count'))
)

val block6347 = InstructionBlock(
	Assign('meta.egress_metadata.bd', :@('bd')),
	Assign('meta.multicast_metadata.replica', ConstantValue(1)),
	Assign('meta.multicast_metadata.inner_replica', ConstantValue(1)),
	Assign('meta.egress_metadata.routed', :@('meta.l3_metadata.routed')),
	Assign('meta.egress_metadata.same_bd_check', <BXor>6324),
	Assign('meta.tunnel_metadata.tunnel_index', :@('tunnel_index')),
	Assign('meta.tunnel_metadata.egress_tunnel_type', :@('tunnel_type')),
	Assign('meta.tunnel_metadata.egress_header_count', :@('header_count'))
)

val block6476 = InstructionBlock(
	rid,
	replica_type
)

val block6478 = InstructionBlock(
	If(Constrain('meta.intrinsic_metadata.egress_rid', :~:(:==:(ConstantValue(0)))), block6476)
)

val block6508 = InstructionBlock(

)

val block6545 = InstructionBlock(
	Assign('hdr.ethernet.etherType', :@('hdr.vlan_tag__0.etherType')),
	Assign('hdr.vlan_tag__0.isValid', ConstantValue(0))
)

val block6593 = InstructionBlock(
	Assign('hdr.ethernet.etherType', :@('hdr.vlan_tag__1.etherType')),
	Assign('hdr.vlan_tag__0.isValid', ConstantValue(0)),
	Assign('hdr.vlan_tag__1.isValid', ConstantValue(0))
)

val block6673 = InstructionBlock(
	vlan_decap
)

val block6718 = InstructionBlock(
	Assign('hdr.udp', :@('hdr.inner_udp')),
	Assign('hdr.inner_udp.isValid', ConstantValue(0))
)

val block6755 = InstructionBlock(
	Assign('hdr.tcp', :@('hdr.inner_tcp')),
	Assign('hdr.inner_tcp.isValid', ConstantValue(0)),
	Assign('hdr.udp.isValid', ConstantValue(0))
)

val block6792 = InstructionBlock(
	Assign('hdr.icmp', :@('hdr.inner_icmp')),
	Assign('hdr.inner_icmp.isValid', ConstantValue(0)),
	Assign('hdr.udp.isValid', ConstantValue(0))
)

val block6814 = InstructionBlock(
	Assign('hdr.udp.isValid', ConstantValue(0))
)

val block6874 = InstructionBlock(
	Assign('hdr.ethernet', :@('hdr.inner_ethernet')),
	Assign('hdr.ipv4', :@('hdr.inner_ipv4')),
	Assign('hdr.vxlan.isValid', ConstantValue(0)),
	Assign('hdr.ipv6.isValid', ConstantValue(0)),
	Assign('hdr.inner_ethernet.isValid', ConstantValue(0)),
	Assign('hdr.inner_ipv4.isValid', ConstantValue(0))
)

val block6934 = InstructionBlock(
	Assign('hdr.ethernet', :@('hdr.inner_ethernet')),
	Assign('hdr.ipv6', :@('hdr.inner_ipv6')),
	Assign('hdr.vxlan.isValid', ConstantValue(0)),
	Assign('hdr.ipv4.isValid', ConstantValue(0)),
	Assign('hdr.inner_ethernet.isValid', ConstantValue(0)),
	Assign('hdr.inner_ipv6.isValid', ConstantValue(0))
)

val block6987 = InstructionBlock(
	Assign('hdr.ethernet', :@('hdr.inner_ethernet')),
	Assign('hdr.vxlan.isValid', ConstantValue(0)),
	Assign('hdr.ipv4.isValid', ConstantValue(0)),
	Assign('hdr.ipv6.isValid', ConstantValue(0)),
	Assign('hdr.inner_ethernet.isValid', ConstantValue(0))
)

val block7047 = InstructionBlock(
	Assign('hdr.ethernet', :@('hdr.inner_ethernet')),
	Assign('hdr.ipv4', :@('hdr.inner_ipv4')),
	Assign('hdr.genv.isValid', ConstantValue(0)),
	Assign('hdr.ipv6.isValid', ConstantValue(0)),
	Assign('hdr.inner_ethernet.isValid', ConstantValue(0)),
	Assign('hdr.inner_ipv4.isValid', ConstantValue(0))
)

val block7107 = InstructionBlock(
	Assign('hdr.ethernet', :@('hdr.inner_ethernet')),
	Assign('hdr.ipv6', :@('hdr.inner_ipv6')),
	Assign('hdr.genv.isValid', ConstantValue(0)),
	Assign('hdr.ipv4.isValid', ConstantValue(0)),
	Assign('hdr.inner_ethernet.isValid', ConstantValue(0)),
	Assign('hdr.inner_ipv6.isValid', ConstantValue(0))
)

val block7160 = InstructionBlock(
	Assign('hdr.ethernet', :@('hdr.inner_ethernet')),
	Assign('hdr.genv.isValid', ConstantValue(0)),
	Assign('hdr.ipv4.isValid', ConstantValue(0)),
	Assign('hdr.ipv6.isValid', ConstantValue(0)),
	Assign('hdr.inner_ethernet.isValid', ConstantValue(0))
)

val block7228 = InstructionBlock(
	Assign('hdr.ethernet', :@('hdr.inner_ethernet')),
	Assign('hdr.ipv4', :@('hdr.inner_ipv4')),
	Assign('hdr.nvgre.isValid', ConstantValue(0)),
	Assign('hdr.gre.isValid', ConstantValue(0)),
	Assign('hdr.ipv6.isValid', ConstantValue(0)),
	Assign('hdr.inner_ethernet.isValid', ConstantValue(0)),
	Assign('hdr.inner_ipv4.isValid', ConstantValue(0))
)

val block7296 = InstructionBlock(
	Assign('hdr.ethernet', :@('hdr.inner_ethernet')),
	Assign('hdr.ipv6', :@('hdr.inner_ipv6')),
	Assign('hdr.nvgre.isValid', ConstantValue(0)),
	Assign('hdr.gre.isValid', ConstantValue(0)),
	Assign('hdr.ipv4.isValid', ConstantValue(0)),
	Assign('hdr.inner_ethernet.isValid', ConstantValue(0)),
	Assign('hdr.inner_ipv6.isValid', ConstantValue(0))
)

val block7357 = InstructionBlock(
	Assign('hdr.ethernet', :@('hdr.inner_ethernet')),
	Assign('hdr.nvgre.isValid', ConstantValue(0)),
	Assign('hdr.gre.isValid', ConstantValue(0)),
	Assign('hdr.ipv4.isValid', ConstantValue(0)),
	Assign('hdr.ipv6.isValid', ConstantValue(0)),
	Assign('hdr.inner_ethernet.isValid', ConstantValue(0))
)

val block7408 = InstructionBlock(
	Assign('hdr.ipv4', :@('hdr.inner_ipv4')),
	Assign('hdr.gre.isValid', ConstantValue(0)),
	Assign('hdr.ipv6.isValid', ConstantValue(0)),
	Assign('hdr.inner_ipv4.isValid', ConstantValue(0)),
	Assign('hdr.ethernet.etherType', ConstantValue(2048))
)

val block7459 = InstructionBlock(
	Assign('hdr.ipv6', :@('hdr.inner_ipv6')),
	Assign('hdr.gre.isValid', ConstantValue(0)),
	Assign('hdr.ipv4.isValid', ConstantValue(0)),
	Assign('hdr.inner_ipv6.isValid', ConstantValue(0)),
	Assign('hdr.ethernet.etherType', ConstantValue(34525))
)

val block7506 = InstructionBlock(
	Assign('hdr.ethernet.etherType', :@('hdr.gre.proto')),
	Assign('hdr.gre.isValid', ConstantValue(0)),
	Assign('hdr.ipv4.isValid', ConstantValue(0)),
	Assign('hdr.inner_ipv6.isValid', ConstantValue(0))
)

val block7549 = InstructionBlock(
	Assign('hdr.ipv4', :@('hdr.inner_ipv4')),
	Assign('hdr.ipv6.isValid', ConstantValue(0)),
	Assign('hdr.inner_ipv4.isValid', ConstantValue(0)),
	Assign('hdr.ethernet.etherType', ConstantValue(2048))
)

val block7592 = InstructionBlock(
	Assign('hdr.ipv6', :@('hdr.inner_ipv6')),
	Assign('hdr.ipv4.isValid', ConstantValue(0)),
	Assign('hdr.inner_ipv6.isValid', ConstantValue(0)),
	Assign('hdr.ethernet.etherType', ConstantValue(34525))
)

val block7638 = InstructionBlock(
	Assign('hdr.mpls_0.isValid', ConstantValue(0)),
	Assign('hdr.ipv4', :@('hdr.inner_ipv4')),
	Assign('hdr.inner_ipv4.isValid', ConstantValue(0)),
	Assign('hdr.ethernet.etherType', ConstantValue(2048))
)

val block7684 = InstructionBlock(
	Assign('hdr.mpls_0.isValid', ConstantValue(0)),
	Assign('hdr.ipv6', :@('hdr.inner_ipv6')),
	Assign('hdr.inner_ipv6.isValid', ConstantValue(0)),
	Assign('hdr.ethernet.etherType', ConstantValue(34525))
)

val block7739 = InstructionBlock(
	Assign('hdr.mpls_0.isValid', ConstantValue(0)),
	Assign('hdr.ethernet', :@('hdr.inner_ethernet')),
	Assign('hdr.ipv4', :@('hdr.inner_ipv4')),
	Assign('hdr.inner_ethernet.isValid', ConstantValue(0)),
	Assign('hdr.inner_ipv4.isValid', ConstantValue(0))
)

val block7794 = InstructionBlock(
	Assign('hdr.mpls_0.isValid', ConstantValue(0)),
	Assign('hdr.ethernet', :@('hdr.inner_ethernet')),
	Assign('hdr.ipv6', :@('hdr.inner_ipv6')),
	Assign('hdr.inner_ethernet.isValid', ConstantValue(0)),
	Assign('hdr.inner_ipv6.isValid', ConstantValue(0))
)

val block7834 = InstructionBlock(
	Assign('hdr.mpls_0.isValid', ConstantValue(0)),
	Assign('hdr.ethernet', :@('hdr.inner_ethernet')),
	Assign('hdr.inner_ethernet.isValid', ConstantValue(0))
)

val block7891 = InstructionBlock(
	Assign('hdr.mpls_0.isValid', ConstantValue(0)),
	Assign('hdr.mpls_1.isValid', ConstantValue(0)),
	Assign('hdr.ipv4', :@('hdr.inner_ipv4')),
	Assign('hdr.inner_ipv4.isValid', ConstantValue(0)),
	Assign('hdr.ethernet.etherType', ConstantValue(2048))
)

val block7948 = InstructionBlock(
	Assign('hdr.mpls_0.isValid', ConstantValue(0)),
	Assign('hdr.mpls_1.isValid', ConstantValue(0)),
	Assign('hdr.ipv6', :@('hdr.inner_ipv6')),
	Assign('hdr.inner_ipv6.isValid', ConstantValue(0)),
	Assign('hdr.ethernet.etherType', ConstantValue(34525))
)

val block8014 = InstructionBlock(
	Assign('hdr.mpls_0.isValid', ConstantValue(0)),
	Assign('hdr.mpls_1.isValid', ConstantValue(0)),
	Assign('hdr.ethernet', :@('hdr.inner_ethernet')),
	Assign('hdr.ipv4', :@('hdr.inner_ipv4')),
	Assign('hdr.inner_ethernet.isValid', ConstantValue(0)),
	Assign('hdr.inner_ipv4.isValid', ConstantValue(0))
)

val block8080 = InstructionBlock(
	Assign('hdr.mpls_0.isValid', ConstantValue(0)),
	Assign('hdr.mpls_1.isValid', ConstantValue(0)),
	Assign('hdr.ethernet', :@('hdr.inner_ethernet')),
	Assign('hdr.ipv6', :@('hdr.inner_ipv6')),
	Assign('hdr.inner_ethernet.isValid', ConstantValue(0)),
	Assign('hdr.inner_ipv6.isValid', ConstantValue(0))
)

val block8131 = InstructionBlock(
	Assign('hdr.mpls_0.isValid', ConstantValue(0)),
	Assign('hdr.mpls_1.isValid', ConstantValue(0)),
	Assign('hdr.ethernet', :@('hdr.inner_ethernet')),
	Assign('hdr.inner_ethernet.isValid', ConstantValue(0))
)

val block8199 = InstructionBlock(
	Assign('hdr.mpls_0.isValid', ConstantValue(0)),
	Assign('hdr.mpls_1.isValid', ConstantValue(0)),
	Assign('hdr.mpls_2.isValid', ConstantValue(0)),
	Assign('hdr.ipv4', :@('hdr.inner_ipv4')),
	Assign('hdr.inner_ipv4.isValid', ConstantValue(0)),
	Assign('hdr.ethernet.etherType', ConstantValue(2048))
)

val block8267 = InstructionBlock(
	Assign('hdr.mpls_0.isValid', ConstantValue(0)),
	Assign('hdr.mpls_1.isValid', ConstantValue(0)),
	Assign('hdr.mpls_2.isValid', ConstantValue(0)),
	Assign('hdr.ipv6', :@('hdr.inner_ipv6')),
	Assign('hdr.inner_ipv6.isValid', ConstantValue(0)),
	Assign('hdr.ethernet.etherType', ConstantValue(34525))
)

val block8344 = InstructionBlock(
	Assign('hdr.mpls_0.isValid', ConstantValue(0)),
	Assign('hdr.mpls_1.isValid', ConstantValue(0)),
	Assign('hdr.mpls_2.isValid', ConstantValue(0)),
	Assign('hdr.ethernet', :@('hdr.inner_ethernet')),
	Assign('hdr.ipv4', :@('hdr.inner_ipv4')),
	Assign('hdr.inner_ethernet.isValid', ConstantValue(0)),
	Assign('hdr.inner_ipv4.isValid', ConstantValue(0))
)

val block8421 = InstructionBlock(
	Assign('hdr.mpls_0.isValid', ConstantValue(0)),
	Assign('hdr.mpls_1.isValid', ConstantValue(0)),
	Assign('hdr.mpls_2.isValid', ConstantValue(0)),
	Assign('hdr.ethernet', :@('hdr.inner_ethernet')),
	Assign('hdr.ipv6', :@('hdr.inner_ipv6')),
	Assign('hdr.inner_ethernet.isValid', ConstantValue(0)),
	Assign('hdr.inner_ipv6.isValid', ConstantValue(0))
)

val block8483 = InstructionBlock(
	Assign('hdr.mpls_0.isValid', ConstantValue(0)),
	Assign('hdr.mpls_1.isValid', ConstantValue(0)),
	Assign('hdr.mpls_2.isValid', ConstantValue(0)),
	Assign('hdr.ethernet', :@('hdr.inner_ethernet')),
	Assign('hdr.inner_ethernet.isValid', ConstantValue(0))
)

val block8746 = InstructionBlock(
	tunnel_decap_process_outer,
	tunnel_decap_process_inner
)

val block8748 = InstructionBlock(
	Allocate('LOr8730'),
	If(Constrain('meta.multicast_metadata.inner_replica', :==:(ConstantValue(1))),
		If(Constrain('meta.multicast_metadata.replica', :==:(ConstantValue(0))),
			Assign('LOr8730', ConstantValue(1)),
		Assign('LOr8730', ConstantValue(0))),
	Assign('LOr8730', ConstantValue(1))),
	If(Constrain('LOr8730'), :==:(ConstantValue(1)), block8746),
	Deallocate('LOr8730')
)

val block8750 = InstructionBlock(
	If(Constrain('meta.tunnel_metadata.tunnel_terminate', :==:(ConstantValue(1))), block8748)
)

val block8780 = InstructionBlock(

)

val block8818 = InstructionBlock(
	Assign('meta.egress_metadata.routed', ConstantValue(0)),
	Assign('meta.egress_metadata.bd', :@('meta.ingress_metadata.bd')),
	Assign('meta.egress_metadata.outer_bd', :@('meta.ingress_metadata.bd'))
)

val block8876 = InstructionBlock(
	Assign('meta.egress_metadata.routed', ConstantValue(0)),
	Assign('meta.egress_metadata.bd', :@('meta.ingress_metadata.bd')),
	Assign('meta.egress_metadata.outer_bd', :@('meta.ingress_metadata.bd')),
	Assign('meta.tunnel_metadata.tunnel_index', :@('tunnel_index')),
	Assign('meta.tunnel_metadata.egress_tunnel_type', :@('tunnel_type'))
)

val block8933 = InstructionBlock(
	Assign('meta.egress_metadata.routed', ConstantValue(1)),
	Assign('meta.egress_metadata.mac_da', :@('dmac')),
	Assign('meta.egress_metadata.bd', :@('bd')),
	Assign('meta.egress_metadata.outer_bd', :@('bd')),
	Assign('meta.l3_metadata.mtu_index', :@('mtu_index'))
)

val block9000 = InstructionBlock(
	Assign('meta.egress_metadata.routed', ConstantValue(1)),
	Assign('meta.egress_metadata.mac_da', :@('dmac')),
	Assign('meta.egress_metadata.bd', :@('bd')),
	Assign('meta.egress_metadata.outer_bd', :@('bd')),
	Assign('meta.tunnel_metadata.tunnel_index', :@('tunnel_index')),
	Assign('meta.tunnel_metadata.egress_tunnel_type', :@('tunnel_type'))
)

val block9071 = InstructionBlock(
	Assign('meta.egress_metadata.routed', :@('meta.l3_metadata.routed')),
	Assign('meta.egress_metadata.bd', :@('meta.ingress_metadata.bd')),
	Assign('hdr.mpls_0.label', :@('label')),
	Assign('meta.tunnel_metadata.tunnel_index', :@('tunnel_index')),
	Assign('meta.tunnel_metadata.egress_header_count', :@('header_count')),
	Assign('meta.tunnel_metadata.egress_tunnel_type', ConstantValue(13))
)

val block9129 = InstructionBlock(
	Assign('meta.egress_metadata.routed', :@('meta.l3_metadata.routed')),
	Assign('meta.egress_metadata.bd', :@('meta.ingress_metadata.bd')),
	Assign('meta.tunnel_metadata.tunnel_index', :@('tunnel_index')),
	Assign('meta.tunnel_metadata.egress_header_count', :@('header_count')),
	Assign('meta.tunnel_metadata.egress_tunnel_type', ConstantValue(13))
)

val block9211 = InstructionBlock(
	Assign('meta.egress_metadata.routed', :@('meta.l3_metadata.routed')),
	Assign('meta.egress_metadata.bd', :@('bd')),
	Assign('hdr.mpls_0.label', :@('label')),
	Assign('meta.egress_metadata.mac_da', :@('dmac')),
	Assign('meta.tunnel_metadata.tunnel_index', :@('tunnel_index')),
	Assign('meta.tunnel_metadata.egress_header_count', :@('header_count')),
	Assign('meta.tunnel_metadata.egress_tunnel_type', ConstantValue(14))
)

val block9280 = InstructionBlock(
	Assign('meta.egress_metadata.routed', :@('meta.l3_metadata.routed')),
	Assign('meta.egress_metadata.bd', :@('bd')),
	Assign('meta.egress_metadata.mac_da', :@('dmac')),
	Assign('meta.tunnel_metadata.tunnel_index', :@('tunnel_index')),
	Assign('meta.tunnel_metadata.egress_header_count', :@('header_count')),
	Assign('meta.tunnel_metadata.egress_tunnel_type', ConstantValue(14))
)

val block9314 = InstructionBlock(
	Assign('<Slice>9302', <Slice>9312)
)

val block9328 = InstructionBlock(

)

val block9504 = InstructionBlock(
	rewrite
)

val block9513 = InstructionBlock(
	rewrite_multicast
)

val block9515 = InstructionBlock(
	Allocate('LOr9495'),
	If(Constrain('meta.egress_metadata.routed', :==:(ConstantValue(0))),
		If(Constrain('meta.l3_metadata.nexthop_index', :~:(:==:(ConstantValue(0)))),
			Assign('LOr9495', ConstantValue(1)),
		Assign('LOr9495', ConstantValue(0))),
	Assign('LOr9495', ConstantValue(1))),
	If(Constrain('LOr9495'), :==:(ConstantValue(1)), block9504, block9513),
	Deallocate('LOr9495')
)

val block9545 = InstructionBlock(

)

val block9589 = InstructionBlock(
	Assign('meta.egress_metadata.smac_idx', :@('smac_idx')),
	Assign('meta.nat_metadata.egress_nat_mode', :@('nat_mode')),
	Assign('meta.acl_metadata.egress_bd_label', :@('bd_label'))
)

val block9647 = InstructionBlock(
	egress_bd_map
)

val block9677 = InstructionBlock(

)

val block9701 = InstructionBlock(
	Assign('meta.l3_metadata.lkp_dscp', :@('exp'))
)

val block9725 = InstructionBlock(
	Assign('meta.l3_metadata.lkp_dscp', :@('dscp'))
)

val block9749 = InstructionBlock(
	Assign('meta.l2_metadata.lkp_pcp', :@('pcp'))
)

val block9829 = InstructionBlock(
	egress_qos_map
)

val block9831 = InstructionBlock(
	If(Constrain('<BOr>9818', :==:(ConstantValue(0))), block9829)
)

val block9861 = InstructionBlock(

)

val block9904 = InstructionBlock(
	Assign('hdr.ethernet.dstAddr', :@('meta.egress_metadata.mac_da')),
	Assign('hdr.ipv4.ttl', :+:(:@('hdr.ipv4.ttl'), ConstantValue(255))),
	Assign('hdr.ipv4.diffserv', :@('meta.l3_metadata.lkp_dscp'))
)

val block9949 = InstructionBlock(
	Assign('hdr.ethernet.dstAddr', <BOr>9927),
	Assign('hdr.ipv4.ttl', :+:(:@('hdr.ipv4.ttl'), ConstantValue(255))),
	Assign('hdr.ipv4.diffserv', :@('meta.l3_metadata.lkp_dscp'))
)

val block9992 = InstructionBlock(
	Assign('hdr.ethernet.dstAddr', :@('meta.egress_metadata.mac_da')),
	Assign('hdr.ipv6.hopLimit', :+:(:@('hdr.ipv6.hopLimit'), ConstantValue(255))),
	Assign('hdr.ipv6.trafficClass', :@('meta.l3_metadata.lkp_dscp'))
)

val block10037 = InstructionBlock(
	Assign('hdr.ethernet.dstAddr', <BOr>10015),
	Assign('hdr.ipv6.hopLimit', :+:(:@('hdr.ipv6.hopLimit'), ConstantValue(255))),
	Assign('hdr.ipv6.trafficClass', :@('meta.l3_metadata.lkp_dscp'))
)

val block10077 = InstructionBlock(
	Assign('hdr.ethernet.dstAddr', :@('meta.egress_metadata.mac_da')),
	Assign('hdr.mpls_0.ttl', :+:(:@('hdr.mpls_0.ttl'), ConstantValue(255)))
)

val block10101 = InstructionBlock(
	Assign('hdr.ethernet.srcAddr', :@('smac'))
)

val block10275 = InstructionBlock(
	l3_rewrite,
	smac_rewrite
)

val block10277 = InstructionBlock(
	If(Constrain('meta.egress_metadata.routed', :==:(ConstantValue(1))), block10275)
)

val block10313 = InstructionBlock(
	Assign('meta.l3_metadata.l3_mtu_check', ConstantValue(65535))
)

val block10342 = InstructionBlock(
	Assign('meta.l3_metadata.l3_mtu_check', :-:(:@('l3_mtu'), :@('hdr.ipv4.totalLen')))
)

val block10371 = InstructionBlock(
	Assign('meta.l3_metadata.l3_mtu_check', :-:(:@('l3_mtu'), :@('hdr.ipv6.payloadLen')))
)

val block10452 = InstructionBlock(
	mtu
)

val block10488 = InstructionBlock(
	Assign('hdr.int_switch_id_header.bos', ConstantValue(1))
)

val block10508 = InstructionBlock(
	Assign('hdr.int_ingress_port_id_header.bos', ConstantValue(1))
)

val block10528 = InstructionBlock(
	Assign('hdr.int_hop_latency_header.bos', ConstantValue(1))
)

val block10548 = InstructionBlock(
	Assign('hdr.int_q_occupancy_header.bos', ConstantValue(1))
)

val block10568 = InstructionBlock(
	Assign('hdr.int_ingress_tstamp_header.bos', ConstantValue(1))
)

val block10588 = InstructionBlock(
	Assign('hdr.int_egress_port_id_header.bos', ConstantValue(1))
)

val block10608 = InstructionBlock(
	Assign('hdr.int_q_congestion_header.bos', ConstantValue(1))
)

val block10628 = InstructionBlock(
	Assign('hdr.int_egress_port_tx_utilization_header.bos', ConstantValue(1))
)

val block10642 = InstructionBlock(

)

val block10701 = InstructionBlock(
	Assign('meta.int_metadata.insert_cnt', :-:(:@('hdr.int_header.max_hop_cnt'), :@('hdr.int_header.total_hop_cnt'))),
	Assign('meta.int_metadata.switch_id', :@('switch_id')),
	Assign('meta.int_metadata.insert_byte_cnt', <Shl>10690),
	Assign('meta.int_metadata.gpe_int_hdr_len8', :@('hdr.int_header.ins_cnt'))
)

val block10854 = InstructionBlock(
	Assign('meta.int_metadata.insert_cnt', :@('hop_cnt')),
	Assign('meta.int_metadata.switch_id', :@('switch_id')),
	Assign('meta.int_metadata.insert_byte_cnt', :@('ins_byte_cnt')),
	Assign('meta.int_metadata.gpe_int_hdr_len8', :@('total_words')),
	Assign('hdr.int_header.isValid', ConstantValue(1)),
	Assign('hdr.int_header.ver', ConstantValue(0)),
	Assign('hdr.int_header.rep', ConstantValue(0)),
	Assign('hdr.int_header.c', ConstantValue(0)),
	Assign('hdr.int_header.e', ConstantValue(0)),
	Assign('hdr.int_header.rsvd1', ConstantValue(0)),
	Assign('hdr.int_header.ins_cnt', :@('ins_cnt')),
	Assign('hdr.int_header.max_hop_cnt', :@('hop_cnt')),
	Assign('hdr.int_header.total_hop_cnt', ConstantValue(0)),
	Assign('hdr.int_header.instruction_mask_0003', :@('ins_mask0003')),
	Assign('hdr.int_header.instruction_mask_0407', :@('ins_mask0407')),
	Assign('hdr.int_header.instruction_mask_0811', ConstantValue(0)),
	Assign('hdr.int_header.instruction_mask_1215', ConstantValue(0)),
	Assign('hdr.int_header.rsvd2', ConstantValue(0))
)

val block10904 = InstructionBlock(
	Assign('meta.int_metadata.switch_id', ConstantValue(0)),
	Assign('meta.int_metadata.insert_byte_cnt', ConstantValue(0)),
	Assign('meta.int_metadata.insert_cnt', ConstantValue(0)),
	Assign('meta.int_metadata.gpe_int_hdr_len8', ConstantValue(0)),
	Assign('meta.int_metadata.gpe_int_hdr_len', ConstantValue(0)),
	Assign('meta.int_metadata.instruction_cnt', ConstantValue(0))
)

val block10918 = InstructionBlock(

)

val block10955 = InstructionBlock(
	Assign('hdr.int_q_occupancy_header.isValid', ConstantValue(1)),
	Assign('hdr.int_q_occupancy_header.q_occupancy1', ConstantValue(0)),
	Assign('hdr.int_q_occupancy_header.q_occupancy0', :@('meta.queueing_metadata.enq_qdepth'))
)

val block10975 = InstructionBlock(
	int_set_header_3
)

val block11006 = InstructionBlock(
	Assign('hdr.int_hop_latency_header.isValid', ConstantValue(1)),
	Assign('hdr.int_hop_latency_header.hop_latency', :@('meta.queueing_metadata.deq_timedelta'))
)

val block11026 = InstructionBlock(
	int_set_header_2
)

val block11052 = InstructionBlock(
	int_set_header_3,
	int_set_header_2
)

val block11089 = InstructionBlock(
	Assign('hdr.int_ingress_port_id_header.isValid', ConstantValue(1)),
	Assign('hdr.int_ingress_port_id_header.ingress_port_id_1', ConstantValue(0)),
	Assign('hdr.int_ingress_port_id_header.ingress_port_id_0', :@('meta.ingress_metadata.ifindex'))
)

val block11109 = InstructionBlock(
	int_set_header_1
)

val block11135 = InstructionBlock(
	int_set_header_3,
	int_set_header_1
)

val block11161 = InstructionBlock(
	int_set_header_2,
	int_set_header_1
)

val block11193 = InstructionBlock(
	int_set_header_3,
	int_set_header_2,
	int_set_header_1
)

val block11224 = InstructionBlock(
	Assign('hdr.int_switch_id_header.isValid', ConstantValue(1)),
	Assign('hdr.int_switch_id_header.switch_id', :@('meta.int_metadata.switch_id'))
)

val block11244 = InstructionBlock(
	int_set_header_0
)

val block11270 = InstructionBlock(
	int_set_header_3,
	int_set_header_0
)

val block11296 = InstructionBlock(
	int_set_header_2,
	int_set_header_0
)

val block11328 = InstructionBlock(
	int_set_header_3,
	int_set_header_2,
	int_set_header_0
)

val block11354 = InstructionBlock(
	int_set_header_1,
	int_set_header_0
)

val block11386 = InstructionBlock(
	int_set_header_3,
	int_set_header_1,
	int_set_header_0
)

val block11418 = InstructionBlock(
	int_set_header_2,
	int_set_header_1,
	int_set_header_0
)

val block11456 = InstructionBlock(
	int_set_header_3,
	int_set_header_2,
	int_set_header_1,
	int_set_header_0
)

val block11470 = InstructionBlock(

)

val block11498 = InstructionBlock(
	Assign('hdr.int_egress_port_tx_utilization_header.isValid', ConstantValue(1)),
	Assign('hdr.int_egress_port_tx_utilization_header.egress_port_tx_utilization', ConstantValue(2147483647))
)

val block11518 = InstructionBlock(
	int_set_header_7
)

val block11546 = InstructionBlock(
	Assign('hdr.int_q_congestion_header.isValid', ConstantValue(1)),
	Assign('hdr.int_q_congestion_header.q_congestion', ConstantValue(2147483647))
)

val block11566 = InstructionBlock(
	int_set_header_6
)

val block11592 = InstructionBlock(
	int_set_header_7,
	int_set_header_6
)

val block11622 = InstructionBlock(
	Assign('hdr.int_egress_port_id_header.isValid', ConstantValue(1)),
	Assign('hdr.int_egress_port_id_header.egress_port_id', :@('standard_metadata.egress_port'))
)

val block11642 = InstructionBlock(
	int_set_header_5
)

val block11668 = InstructionBlock(
	int_set_header_7,
	int_set_header_5
)

val block11694 = InstructionBlock(
	int_set_header_6,
	int_set_header_5
)

val block11726 = InstructionBlock(
	int_set_header_7,
	int_set_header_6,
	int_set_header_5
)

val block11757 = InstructionBlock(
	Assign('hdr.int_ingress_tstamp_header.isValid', ConstantValue(1)),
	Assign('hdr.int_ingress_tstamp_header.ingress_tstamp', :@('meta.i2e_metadata.ingress_tstamp'))
)

val block11777 = InstructionBlock(
	int_set_header_4
)

val block11803 = InstructionBlock(
	int_set_header_7,
	int_set_header_4
)

val block11829 = InstructionBlock(
	int_set_header_6,
	int_set_header_4
)

val block11861 = InstructionBlock(
	int_set_header_7,
	int_set_header_6,
	int_set_header_4
)

val block11887 = InstructionBlock(
	int_set_header_5,
	int_set_header_4
)

val block11919 = InstructionBlock(
	int_set_header_7,
	int_set_header_5,
	int_set_header_4
)

val block11951 = InstructionBlock(
	int_set_header_6,
	int_set_header_5,
	int_set_header_4
)

val block11989 = InstructionBlock(
	int_set_header_7,
	int_set_header_6,
	int_set_header_5,
	int_set_header_4
)

val block12009 = InstructionBlock(
	Assign('hdr.int_header.e', ConstantValue(1))
)

val block12034 = InstructionBlock(
	Assign('hdr.int_header.total_hop_cnt', :+:(:@('hdr.int_header.total_hop_cnt'), ConstantValue(1)))
)

val block12570 = InstructionBlock(
	int_inst_0003,
	int_inst_0407,
	int_inst_0811,
	int_inst_1215,
	int_bos
)

val block12579 = InstructionBlock(
	If(Constrain('meta.int_metadata.insert_cnt', :~:(:==:(ConstantValue(0)))), block12570),
	int_meta_header_update
)

val block12584 = InstructionBlock(
	Fork(InstructionBlock(), block12579)
)

val block12614 = InstructionBlock(

)

val block12645 = InstructionBlock(
	Assign('meta.nat_metadata.update_checksum', ConstantValue(1)),
	Assign('meta.nat_metadata.l4_len', :+:(:@('hdr.ipv4.totalLen'), ConstantValue(65516)))
)

val block12675 = InstructionBlock(
	Assign('hdr.ipv4.srcAddr', :@('src_ip')),
	nat_update_l4_checksum
)

val block12705 = InstructionBlock(
	Assign('hdr.ipv4.dstAddr', :@('dst_ip')),
	nat_update_l4_checksum
)

val block12745 = InstructionBlock(
	Assign('hdr.ipv4.srcAddr', :@('src_ip')),
	Assign('hdr.ipv4.dstAddr', :@('dst_ip')),
	nat_update_l4_checksum
)

val block12785 = InstructionBlock(
	Assign('hdr.ipv4.srcAddr', :@('src_ip')),
	Assign('hdr.udp.srcPort', :@('src_port')),
	nat_update_l4_checksum
)

val block12825 = InstructionBlock(
	Assign('hdr.ipv4.dstAddr', :@('dst_ip')),
	Assign('hdr.udp.dstPort', :@('dst_port')),
	nat_update_l4_checksum
)

val block12885 = InstructionBlock(
	Assign('hdr.ipv4.srcAddr', :@('src_ip')),
	Assign('hdr.ipv4.dstAddr', :@('dst_ip')),
	Assign('hdr.udp.srcPort', :@('src_port')),
	Assign('hdr.udp.dstPort', :@('dst_port')),
	nat_update_l4_checksum
)

val block12925 = InstructionBlock(
	Assign('hdr.ipv4.srcAddr', :@('src_ip')),
	Assign('hdr.tcp.srcPort', :@('src_port')),
	nat_update_l4_checksum
)

val block12965 = InstructionBlock(
	Assign('hdr.ipv4.dstAddr', :@('dst_ip')),
	Assign('hdr.tcp.dstPort', :@('dst_port')),
	nat_update_l4_checksum
)

val block13025 = InstructionBlock(
	Assign('hdr.ipv4.srcAddr', :@('src_ip')),
	Assign('hdr.ipv4.dstAddr', :@('dst_ip')),
	Assign('hdr.tcp.srcPort', :@('src_port')),
	Assign('hdr.tcp.dstPort', :@('dst_port')),
	nat_update_l4_checksum
)

val block13124 = InstructionBlock(
	egress_nat
)

val block13126 = InstructionBlock(
	Allocate('LAnd13115'),
	If(Constrain('meta.nat_metadata.ingress_nat_mode', :~:(:==:(ConstantValue(0)))),
		If(Constrain('meta.nat_metadata.ingress_nat_mode', :~:(:==:(meta.nat_metadata.egress_nat_mode))),
			Assign('LAnd13115', ConstantValue(1)),
		Assign('LAnd13115', ConstantValue(0))),
	Assign('LAnd13115', ConstantValue(0))),
	If(Constrain('LAnd13115'), :==:(ConstantValue(1)), block13124),
	Deallocate('LAnd13115')
)

val block13156 = InstructionBlock(

)

val block13237 = InstructionBlock(
	egress_bd_stats_0
)

val block13267 = InstructionBlock(

)

val block13291 = InstructionBlock(
	Assign('meta.acl_metadata.egress_dst_port_range_id', :@('range_id'))
)

val block13315 = InstructionBlock(
	Assign('meta.acl_metadata.egress_src_port_range_id', :@('range_id'))
)

val block13347 = InstructionBlock(
	Assign('meta.l3_metadata.egress_l4_sport', :@('hdr.tcp.srcPort')),
	Assign('meta.l3_metadata.egress_l4_dport', :@('hdr.tcp.dstPort'))
)

val block13379 = InstructionBlock(
	Assign('meta.l3_metadata.egress_l4_sport', :@('hdr.udp.srcPort')),
	Assign('meta.l3_metadata.egress_l4_dport', :@('hdr.udp.dstPort'))
)

val block13402 = InstructionBlock(
	Assign('meta.l3_metadata.egress_l4_sport', :@('hdr.icmp.typeCode'))
)

val block13597 = InstructionBlock(
	egress_l4port_fields,
	egress_l4_src_port,
	egress_l4_dst_port
)

val block13627 = InstructionBlock(

)

val block13651 = InstructionBlock(
	Assign('meta.tunnel_metadata.vnid', :@('vnid'))
)

val block13675 = InstructionBlock(
	Assign('hdr.ethernet.dstAddr', :@('dmac'))
)

val block13699 = InstructionBlock(
	Assign('hdr.ipv4.dstAddr', :@('ip'))
)

val block13723 = InstructionBlock(
	Assign('hdr.ipv6.dstAddr', :@('ip'))
)

val block13782 = InstructionBlock(
	Assign('hdr.inner_ipv4', :@('hdr.ipv4')),
	Assign('hdr.inner_udp', :@('hdr.udp')),
	Assign('meta.egress_metadata.payload_length', :@('hdr.ipv4.totalLen')),
	Assign('hdr.udp.isValid', ConstantValue(0)),
	Assign('hdr.ipv4.isValid', ConstantValue(0)),
	Assign('meta.tunnel_metadata.inner_ip_proto', ConstantValue(4))
)

val block13841 = InstructionBlock(
	Assign('hdr.inner_ipv4', :@('hdr.ipv4')),
	Assign('hdr.inner_tcp', :@('hdr.tcp')),
	Assign('meta.egress_metadata.payload_length', :@('hdr.ipv4.totalLen')),
	Assign('hdr.tcp.isValid', ConstantValue(0)),
	Assign('hdr.ipv4.isValid', ConstantValue(0)),
	Assign('meta.tunnel_metadata.inner_ip_proto', ConstantValue(4))
)

val block13900 = InstructionBlock(
	Assign('hdr.inner_ipv4', :@('hdr.ipv4')),
	Assign('hdr.inner_icmp', :@('hdr.icmp')),
	Assign('meta.egress_metadata.payload_length', :@('hdr.ipv4.totalLen')),
	Assign('hdr.icmp.isValid', ConstantValue(0)),
	Assign('hdr.ipv4.isValid', ConstantValue(0)),
	Assign('meta.tunnel_metadata.inner_ip_proto', ConstantValue(4))
)

val block13944 = InstructionBlock(
	Assign('hdr.inner_ipv4', :@('hdr.ipv4')),
	Assign('meta.egress_metadata.payload_length', :@('hdr.ipv4.totalLen')),
	Assign('hdr.ipv4.isValid', ConstantValue(0)),
	Assign('meta.tunnel_metadata.inner_ip_proto', ConstantValue(4))
)

val block13997 = InstructionBlock(
	Assign('hdr.inner_ipv6', :@('hdr.ipv6')),
	Assign('hdr.inner_udp', :@('hdr.udp')),
	Assign('meta.egress_metadata.payload_length', :+:(:@('hdr.ipv6.payloadLen'), ConstantValue(40))),
	Assign('hdr.ipv6.isValid', ConstantValue(0)),
	Assign('meta.tunnel_metadata.inner_ip_proto', ConstantValue(41))
)

val block14058 = InstructionBlock(
	Assign('hdr.inner_ipv6', :@('hdr.ipv6')),
	Assign('hdr.inner_tcp', :@('hdr.tcp')),
	Assign('meta.egress_metadata.payload_length', :+:(:@('hdr.ipv6.payloadLen'), ConstantValue(40))),
	Assign('hdr.tcp.isValid', ConstantValue(0)),
	Assign('hdr.ipv6.isValid', ConstantValue(0)),
	Assign('meta.tunnel_metadata.inner_ip_proto', ConstantValue(41))
)

val block14119 = InstructionBlock(
	Assign('hdr.inner_ipv6', :@('hdr.ipv6')),
	Assign('hdr.inner_icmp', :@('hdr.icmp')),
	Assign('meta.egress_metadata.payload_length', :+:(:@('hdr.ipv6.payloadLen'), ConstantValue(40))),
	Assign('hdr.icmp.isValid', ConstantValue(0)),
	Assign('hdr.ipv6.isValid', ConstantValue(0)),
	Assign('meta.tunnel_metadata.inner_ip_proto', ConstantValue(41))
)

val block14165 = InstructionBlock(
	Assign('hdr.inner_ipv6', :@('hdr.ipv6')),
	Assign('meta.egress_metadata.payload_length', :+:(:@('hdr.ipv6.payloadLen'), ConstantValue(40))),
	Assign('hdr.ipv6.isValid', ConstantValue(0)),
	Assign('meta.tunnel_metadata.inner_ip_proto', ConstantValue(41))
)

val block14192 = InstructionBlock(
	Assign('meta.egress_metadata.payload_length', :+:(:@('standard_metadata.packet_length'), <Cast>14189))
)

val block14216 = InstructionBlock(
	Assign('meta.tunnel_metadata.tunnel_index', :@('tunnel_index'))
)

val block14327 = InstructionBlock(
	Assign('hdr.inner_ethernet', :@('hdr.ethernet')),
	Assign('hdr.udp.isValid', ConstantValue(1)),
	Assign('hdr.vxlan.isValid', ConstantValue(1)),
	Assign('hdr.udp.srcPort', :@('meta.hash_metadata.entropy_hash')),
	Assign('hdr.udp.dstPort', ConstantValue(4789)),
	Assign('meta.l3_metadata.egress_l4_sport', :@('meta.hash_metadata.entropy_hash')),
	Assign('meta.l3_metadata.egress_l4_dport', ConstantValue(4789)),
	Assign('hdr.udp.checksum', ConstantValue(0)),
	Assign('hdr.udp.length_', :+:(:@('meta.egress_metadata.payload_length'), ConstantValue(30))),
	Assign('hdr.vxlan.flags', ConstantValue(8)),
	Assign('hdr.vxlan.reserved', ConstantValue(0)),
	Assign('hdr.vxlan.vni', :@('meta.tunnel_metadata.vnid')),
	Assign('hdr.vxlan.reserved2', ConstantValue(0))
)

val block14383 = InstructionBlock(
	Assign('hdr.ipv4.isValid', ConstantValue(1)),
	Assign('hdr.ipv4.protocol', :@('proto')),
	Assign('hdr.ipv4.ttl', ConstantValue(64)),
	Assign('hdr.ipv4.version', ConstantValue(4)),
	Assign('hdr.ipv4.ihl', ConstantValue(5)),
	Assign('hdr.ipv4.identification', ConstantValue(0))
)

val block14427 = InstructionBlock(
	f_insert_vxlan_header,
	f_insert_ipv4_header,
	Assign('hdr.ipv4.totalLen', :+:(:@('meta.egress_metadata.payload_length'), ConstantValue(50))),
	Assign('hdr.ethernet.etherType', ConstantValue(2048))
)

val block14562 = InstructionBlock(
	Assign('hdr.inner_ethernet', :@('hdr.ethernet')),
	Assign('hdr.udp.isValid', ConstantValue(1)),
	Assign('hdr.genv.isValid', ConstantValue(1)),
	Assign('hdr.udp.srcPort', :@('meta.hash_metadata.entropy_hash')),
	Assign('hdr.udp.dstPort', ConstantValue(6081)),
	Assign('meta.l3_metadata.egress_l4_sport', :@('meta.hash_metadata.entropy_hash')),
	Assign('meta.l3_metadata.egress_l4_dport', ConstantValue(6081)),
	Assign('hdr.udp.checksum', ConstantValue(0)),
	Assign('hdr.udp.length_', :+:(:@('meta.egress_metadata.payload_length'), ConstantValue(30))),
	Assign('hdr.genv.ver', ConstantValue(0)),
	Assign('hdr.genv.oam', ConstantValue(0)),
	Assign('hdr.genv.critical', ConstantValue(0)),
	Assign('hdr.genv.optLen', ConstantValue(0)),
	Assign('hdr.genv.protoType', ConstantValue(25944)),
	Assign('hdr.genv.vni', :@('meta.tunnel_metadata.vnid')),
	Assign('hdr.genv.reserved', ConstantValue(0)),
	Assign('hdr.genv.reserved2', ConstantValue(0))
)

val block14606 = InstructionBlock(
	f_insert_genv_header,
	f_insert_ipv4_header,
	Assign('hdr.ipv4.totalLen', :+:(:@('meta.egress_metadata.payload_length'), ConstantValue(50))),
	Assign('hdr.ethernet.etherType', ConstantValue(2048))
)

val block14725 = InstructionBlock(
	Assign('hdr.inner_ethernet', :@('hdr.ethernet')),
	Assign('hdr.gre.isValid', ConstantValue(1)),
	Assign('hdr.nvgre.isValid', ConstantValue(1)),
	Assign('hdr.gre.proto', ConstantValue(25944)),
	Assign('hdr.gre.recurse', ConstantValue(0)),
	Assign('hdr.gre.flags', ConstantValue(0)),
	Assign('hdr.gre.ver', ConstantValue(0)),
	Assign('hdr.gre.R', ConstantValue(0)),
	Assign('hdr.gre.K', ConstantValue(1)),
	Assign('hdr.gre.C', ConstantValue(0)),
	Assign('hdr.gre.S', ConstantValue(0)),
	Assign('hdr.gre.s', ConstantValue(0)),
	Assign('hdr.nvgre.tni', :@('meta.tunnel_metadata.vnid')),
	Assign('<Slice>14714', <Slice>14723)
)

val block14769 = InstructionBlock(
	f_insert_nvgre_header,
	f_insert_ipv4_header,
	Assign('hdr.ipv4.totalLen', :+:(:@('meta.egress_metadata.payload_length'), ConstantValue(42))),
	Assign('hdr.ethernet.etherType', ConstantValue(2048))
)

val block14791 = InstructionBlock(
	Assign('hdr.gre.isValid', ConstantValue(1))
)

val block14844 = InstructionBlock(
	f_insert_gre_header,
	Assign('hdr.gre.proto', :@('hdr.ethernet.etherType')),
	f_insert_ipv4_header,
	Assign('hdr.ipv4.totalLen', :+:(:@('meta.egress_metadata.payload_length'), ConstantValue(24))),
	Assign('hdr.ethernet.etherType', ConstantValue(2048))
)

val block14885 = InstructionBlock(
	f_insert_ipv4_header,
	Assign('hdr.ipv4.totalLen', :+:(:@('meta.egress_metadata.payload_length'), ConstantValue(20))),
	Assign('hdr.ethernet.etherType', ConstantValue(2048))
)

val block14941 = InstructionBlock(
	Assign('hdr.ipv6.isValid', ConstantValue(1)),
	Assign('hdr.ipv6.version', ConstantValue(6)),
	Assign('hdr.ipv6.nextHdr', :@('proto')),
	Assign('hdr.ipv6.hopLimit', ConstantValue(64)),
	Assign('hdr.ipv6.trafficClass', ConstantValue(0)),
	Assign('hdr.ipv6.flowLabel', ConstantValue(0))
)

val block14994 = InstructionBlock(
	f_insert_gre_header,
	Assign('hdr.gre.proto', :@('hdr.ethernet.etherType')),
	f_insert_ipv6_header,
	Assign('hdr.ipv6.payloadLen', :+:(:@('meta.egress_metadata.payload_length'), ConstantValue(4))),
	Assign('hdr.ethernet.etherType', ConstantValue(34525))
)

val block15033 = InstructionBlock(
	f_insert_ipv6_header,
	Assign('hdr.ipv6.payloadLen', :@('meta.egress_metadata.payload_length')),
	Assign('hdr.ethernet.etherType', ConstantValue(34525))
)

val block15077 = InstructionBlock(
	f_insert_nvgre_header,
	f_insert_ipv6_header,
	Assign('hdr.ipv6.payloadLen', :+:(:@('meta.egress_metadata.payload_length'), ConstantValue(22))),
	Assign('hdr.ethernet.etherType', ConstantValue(34525))
)

val block15121 = InstructionBlock(
	f_insert_vxlan_header,
	f_insert_ipv6_header,
	Assign('hdr.ipv6.payloadLen', :+:(:@('meta.egress_metadata.payload_length'), ConstantValue(30))),
	Assign('hdr.ethernet.etherType', ConstantValue(34525))
)

val block15165 = InstructionBlock(
	f_insert_genv_header,
	f_insert_ipv6_header,
	Assign('hdr.ipv6.payloadLen', :+:(:@('meta.egress_metadata.payload_length'), ConstantValue(30))),
	Assign('hdr.ethernet.etherType', ConstantValue(34525))
)

val block15202 = InstructionBlock(
	Assign('hdr.inner_ethernet', :@('hdr.ethernet')),
	hdr.mpls.push_front,
	Assign('hdr.ethernet.etherType', ConstantValue(34887))
)

val block15232 = InstructionBlock(
	hdr.mpls.push_front,
	Assign('hdr.ethernet.etherType', ConstantValue(34887))
)

val block15269 = InstructionBlock(
	Assign('hdr.inner_ethernet', :@('hdr.ethernet')),
	hdr.mpls.push_front,
	Assign('hdr.ethernet.etherType', ConstantValue(34887))
)

val block15299 = InstructionBlock(
	hdr.mpls.push_front,
	Assign('hdr.ethernet.etherType', ConstantValue(34887))
)

val block15336 = InstructionBlock(
	Assign('hdr.inner_ethernet', :@('hdr.ethernet')),
	hdr.mpls.push_front,
	Assign('hdr.ethernet.etherType', ConstantValue(34887))
)

val block15366 = InstructionBlock(
	hdr.mpls.push_front,
	Assign('hdr.ethernet.etherType', ConstantValue(34887))
)

val block15487 = InstructionBlock(
	Assign('hdr.inner_ethernet', :@('hdr.ethernet')),
	Assign('hdr.gre.isValid', ConstantValue(1)),
	Assign('hdr.erspan_t3_header.isValid', ConstantValue(1)),
	Assign('hdr.gre.C', ConstantValue(0)),
	Assign('hdr.gre.R', ConstantValue(0)),
	Assign('hdr.gre.K', ConstantValue(0)),
	Assign('hdr.gre.S', ConstantValue(0)),
	Assign('hdr.gre.s', ConstantValue(0)),
	Assign('hdr.gre.recurse', ConstantValue(0)),
	Assign('hdr.gre.flags', ConstantValue(0)),
	Assign('hdr.gre.ver', ConstantValue(0)),
	Assign('hdr.gre.proto', ConstantValue(8939)),
	Assign('hdr.erspan_t3_header.timestamp', :@('meta.i2e_metadata.ingress_tstamp')),
	Assign('hdr.erspan_t3_header.span_id', :@('meta.i2e_metadata.mirror_session_id')),
	Assign('hdr.erspan_t3_header.version', ConstantValue(2)),
	Assign('hdr.erspan_t3_header.sgt', ConstantValue(0))
)

val block15507 = InstructionBlock(
	f_insert_erspan_common_header
)

val block15545 = InstructionBlock(
	f_insert_erspan_t3_header,
	f_insert_ipv4_header,
	Assign('hdr.ipv4.totalLen', :+:(:@('meta.egress_metadata.payload_length'), ConstantValue(50)))
)

val block15583 = InstructionBlock(
	f_insert_erspan_t3_header,
	f_insert_ipv6_header,
	Assign('hdr.ipv6.payloadLen', :+:(:@('meta.egress_metadata.payload_length'), ConstantValue(26)))
)

val block15612 = InstructionBlock(
	Assign('meta.l3_metadata.l3_mtu_check', :-:(:@('l3_mtu'), :@('meta.egress_metadata.payload_length')))
)

val block15632 = InstructionBlock(
	Assign('meta.l3_metadata.l3_mtu_check', ConstantValue(65535))
)

val block15745 = InstructionBlock(
	Assign('hdr.fabric_header.isValid', ConstantValue(1)),
	Assign('hdr.fabric_header.headerVersion', ConstantValue(0)),
	Assign('hdr.fabric_header.packetVersion', ConstantValue(0)),
	Assign('hdr.fabric_header.pad1', ConstantValue(0)),
	Assign('hdr.fabric_header.packetType', ConstantValue(5)),
	Assign('hdr.fabric_header_cpu.isValid', ConstantValue(1)),
	Assign('hdr.fabric_header_cpu.ingressPort', :@('meta.ingress_metadata.ingress_port')),
	Assign('hdr.fabric_header_cpu.ingressIfindex', :@('meta.ingress_metadata.ifindex')),
	Assign('hdr.fabric_header_cpu.ingressBd', :@('meta.ingress_metadata.bd')),
	Assign('hdr.fabric_header_cpu.reasonCode', :@('meta.fabric_metadata.reason_code')),
	Assign('hdr.fabric_payload_header.isValid', ConstantValue(1)),
	Assign('hdr.fabric_payload_header.etherType', :@('hdr.ethernet.etherType')),
	Assign('hdr.ethernet.etherType', ConstantValue(36864))
)

val block15809 = InstructionBlock(
	Assign('meta.egress_metadata.outer_bd', :@('outer_bd')),
	Assign('meta.tunnel_metadata.tunnel_smac_index', :@('smac_idx')),
	Assign('meta.tunnel_metadata.tunnel_dmac_index', :@('dmac_idx')),
	Assign('meta.tunnel_metadata.tunnel_src_index', :@('sip_index')),
	Assign('meta.tunnel_metadata.tunnel_dst_index', :@('dip_index'))
)

val block15891 = InstructionBlock(
	Assign('hdr.mpls_0.label', :@('label1')),
	Assign('hdr.mpls_0.exp', :@('exp1')),
	Assign('hdr.mpls_0.bos', ConstantValue(1)),
	Assign('hdr.mpls_0.ttl', :@('ttl1')),
	Assign('meta.tunnel_metadata.tunnel_smac_index', :@('smac_idx')),
	Assign('meta.tunnel_metadata.tunnel_dmac_index', :@('dmac_idx'))
)

val block16021 = InstructionBlock(
	Assign('hdr.mpls_0.label', :@('label1')),
	Assign('hdr.mpls_0.exp', :@('exp1')),
	Assign('hdr.mpls_0.ttl', :@('ttl1')),
	Assign('hdr.mpls_0.bos', ConstantValue(0)),
	Assign('hdr.mpls_1.label', :@('label2')),
	Assign('hdr.mpls_1.exp', :@('exp2')),
	Assign('hdr.mpls_1.ttl', :@('ttl2')),
	Assign('hdr.mpls_1.bos', ConstantValue(1)),
	Assign('meta.tunnel_metadata.tunnel_smac_index', :@('smac_idx')),
	Assign('meta.tunnel_metadata.tunnel_dmac_index', :@('dmac_idx'))
)

val block16199 = InstructionBlock(
	Assign('hdr.mpls_0.label', :@('label1')),
	Assign('hdr.mpls_0.exp', :@('exp1')),
	Assign('hdr.mpls_0.ttl', :@('ttl1')),
	Assign('hdr.mpls_0.bos', ConstantValue(0)),
	Assign('hdr.mpls_1.label', :@('label2')),
	Assign('hdr.mpls_1.exp', :@('exp2')),
	Assign('hdr.mpls_1.ttl', :@('ttl2')),
	Assign('hdr.mpls_1.bos', ConstantValue(0)),
	Assign('hdr.mpls_2.label', :@('label3')),
	Assign('hdr.mpls_2.exp', :@('exp3')),
	Assign('hdr.mpls_2.ttl', :@('ttl3')),
	Assign('hdr.mpls_2.bos', ConstantValue(1)),
	Assign('meta.tunnel_metadata.tunnel_smac_index', :@('smac_idx')),
	Assign('meta.tunnel_metadata.tunnel_dmac_index', :@('dmac_idx'))
)

val block16339 = InstructionBlock(
	Assign('hdr.fabric_header.isValid', ConstantValue(1)),
	Assign('hdr.fabric_header.headerVersion', ConstantValue(0)),
	Assign('hdr.fabric_header.packetVersion', ConstantValue(0)),
	Assign('hdr.fabric_header.pad1', ConstantValue(0)),
	Assign('hdr.fabric_header.packetType', ConstantValue(1)),
	Assign('hdr.fabric_header.dstDevice', :@('meta.fabric_metadata.dst_device')),
	Assign('hdr.fabric_header.dstPortOrGroup', :@('meta.fabric_metadata.dst_port')),
	Assign('hdr.fabric_header_unicast.isValid', ConstantValue(1)),
	Assign('hdr.fabric_header_unicast.tunnelTerminate', :@('meta.tunnel_metadata.tunnel_terminate')),
	Assign('hdr.fabric_header_unicast.routed', :@('meta.l3_metadata.routed')),
	Assign('hdr.fabric_header_unicast.outerRouted', :@('meta.l3_metadata.outer_routed')),
	Assign('hdr.fabric_header_unicast.ingressTunnelType', :@('meta.tunnel_metadata.ingress_tunnel_type')),
	Assign('hdr.fabric_header_unicast.nexthopIndex', :@('meta.l3_metadata.nexthop_index')),
	Assign('hdr.fabric_payload_header.isValid', ConstantValue(1)),
	Assign('hdr.fabric_payload_header.etherType', :@('hdr.ethernet.etherType')),
	Assign('hdr.ethernet.etherType', ConstantValue(36864))
)

val block16495 = InstructionBlock(
	Assign('hdr.fabric_header.isValid', ConstantValue(1)),
	Assign('hdr.fabric_header.headerVersion', ConstantValue(0)),
	Assign('hdr.fabric_header.packetVersion', ConstantValue(0)),
	Assign('hdr.fabric_header.pad1', ConstantValue(0)),
	Assign('hdr.fabric_header.packetType', ConstantValue(2)),
	Assign('hdr.fabric_header.dstDevice', ConstantValue(127)),
	Assign('hdr.fabric_header.dstPortOrGroup', :@('fabric_mgid')),
	Assign('hdr.fabric_header_multicast.ingressIfindex', :@('meta.ingress_metadata.ifindex')),
	Assign('hdr.fabric_header_multicast.ingressBd', :@('meta.ingress_metadata.bd')),
	Assign('hdr.fabric_header_multicast.isValid', ConstantValue(1)),
	Assign('hdr.fabric_header_multicast.tunnelTerminate', :@('meta.tunnel_metadata.tunnel_terminate')),
	Assign('hdr.fabric_header_multicast.routed', :@('meta.l3_metadata.routed')),
	Assign('hdr.fabric_header_multicast.outerRouted', :@('meta.l3_metadata.outer_routed')),
	Assign('hdr.fabric_header_multicast.ingressTunnelType', :@('meta.tunnel_metadata.ingress_tunnel_type')),
	Assign('hdr.fabric_header_multicast.mcastGrp', :@('meta.multicast_metadata.mcast_grp')),
	Assign('hdr.fabric_payload_header.isValid', ConstantValue(1)),
	Assign('hdr.fabric_payload_header.etherType', :@('hdr.ethernet.etherType')),
	Assign('hdr.ethernet.etherType', ConstantValue(36864))
)

val block16519 = InstructionBlock(
	Assign('hdr.ethernet.srcAddr', :@('smac'))
)

val block16543 = InstructionBlock(
	Assign('hdr.ipv4.srcAddr', :@('ip'))
)

val block16567 = InstructionBlock(
	Assign('hdr.ipv6.srcAddr', :@('ip'))
)

val block17199 = InstructionBlock(
	tunnel_encap_process_inner
)

val block17250 = InstructionBlock(
	egress_vni,
	Allocate('LAnd17190'),
	If(Constrain('meta.tunnel_metadata.egress_tunnel_type', :~:(:==:(ConstantValue(15)))),
		If(Constrain('meta.tunnel_metadata.egress_tunnel_type', :~:(:==:(ConstantValue(16)))),
			Assign('LAnd17190', ConstantValue(1)),
		Assign('LAnd17190', ConstantValue(0))),
	Assign('LAnd17190', ConstantValue(0))),
	If(Constrain('LAnd17190'), :==:(ConstantValue(1)), block17199),
	Deallocate('LAnd17190'),
	tunnel_encap_process_outer,
	tunnel_rewrite,
	tunnel_mtu,
	tunnel_src_rewrite,
	tunnel_dst_rewrite,
	tunnel_smac_rewrite,
	tunnel_dmac_rewrite
)

val block17252 = InstructionBlock(
	Allocate('LAnd17169'),
	If(Constrain('meta.fabric_metadata.fabric_header_present', :==:(ConstantValue(0))),
		If(Constrain('meta.tunnel_metadata.egress_tunnel_type', :~:(:==:(ConstantValue(0)))),
			Assign('LAnd17169', ConstantValue(1)),
		Assign('LAnd17169', ConstantValue(0))),
	Assign('LAnd17169', ConstantValue(0))),
	If(Constrain('LAnd17169'), :==:(ConstantValue(1)), block17250),
	Deallocate('LAnd17169')
)

val block17282 = InstructionBlock(

)

val block17312 = InstructionBlock(
	Assign('meta.acl_metadata.acl_deny', ConstantValue(1)),
	Assign('meta.fabric_metadata.reason_code', :@('acl_copy_reason'))
)

val block17336 = InstructionBlock(
	Assign('meta.fabric_metadata.reason_code', :@('acl_copy_reason'))
)

val block17617 = InstructionBlock(
	egress_ip_acl
)

val block17634 = InstructionBlock(
	egress_ipv6_acl
)

val block17643 = InstructionBlock(
	egress_mac_acl
)

val block17645 = InstructionBlock(
	If(Constrain(hdr.ipv6.isValid), block17634, block17643)
)

val block17647 = InstructionBlock(
	If(Constrain(hdr.ipv4.isValid), block17617, block17645)
)

val block17719 = InstructionBlock(
	Assign('hdr.ipv4.totalLen', :+:(:@('hdr.ipv4.totalLen'), :@('meta.int_metadata.insert_byte_cnt'))),
	Assign('hdr.udp.length_', :+:(:@('hdr.udp.length_'), :@('meta.int_metadata.insert_byte_cnt'))),
	Assign('hdr.vxlan_gpe_int_header.len', :+:(:@('hdr.vxlan_gpe_int_header.len'), :@('meta.int_metadata.gpe_int_hdr_len8')))
)

val block17796 = InstructionBlock(
	Assign('hdr.vxlan_gpe_int_header.isValid', ConstantValue(1)),
	Assign('hdr.vxlan_gpe_int_header.int_type', ConstantValue(1)),
	Assign('hdr.vxlan_gpe_int_header.next_proto', ConstantValue(3)),
	Assign('hdr.vxlan_gpe.next_proto', ConstantValue(5)),
	Assign('hdr.vxlan_gpe_int_header.len', :@('meta.int_metadata.gpe_int_hdr_len8')),
	Assign('hdr.ipv4.totalLen', :+:(:@('hdr.ipv4.totalLen'), :@('meta.int_metadata.insert_byte_cnt'))),
	Assign('hdr.udp.length_', :+:(:@('hdr.udp.length_'), :@('meta.int_metadata.insert_byte_cnt')))
)

val block17810 = InstructionBlock(

)

val block17905 = InstructionBlock(
	int_outer_encap
)

val block17907 = InstructionBlock(
	If(Constrain('meta.int_metadata.insert_cnt', :~:(:==:(ConstantValue(0)))), block17905)
)

val block17937 = InstructionBlock(

)

val block17993 = InstructionBlock(
	Assign('hdr.vlan_tag__0.isValid', ConstantValue(1)),
	Assign('hdr.vlan_tag__0.etherType', :@('hdr.ethernet.etherType')),
	Assign('hdr.vlan_tag__0.vid', :@('vlan_id')),
	Assign('hdr.ethernet.etherType', ConstantValue(33024))
)

val block18082 = InstructionBlock(
	Assign('hdr.vlan_tag__1.isValid', ConstantValue(1)),
	Assign('hdr.vlan_tag__0.isValid', ConstantValue(1)),
	Assign('hdr.vlan_tag__1.etherType', :@('hdr.ethernet.etherType')),
	Assign('hdr.vlan_tag__1.vid', :@('c_tag')),
	Assign('hdr.vlan_tag__0.etherType', ConstantValue(33024)),
	Assign('hdr.vlan_tag__0.vid', :@('s_tag')),
	Assign('hdr.ethernet.etherType', ConstantValue(37120))
)

val block18150 = InstructionBlock(
	egress_vlan_xlate
)

val block18222 = InstructionBlock(
	Assign('meta.egress_filter_metadata.ifindex_check', <BXor>18192),
	Assign('meta.egress_filter_metadata.bd', <BXor>18206),
	Assign('meta.egress_filter_metadata.inner_bd', <BXor>18220)
)

val block18242 = InstructionBlock(
	mark_to_drop
)

val block18376 = InstructionBlock(
	egress_filter_drop
)

val block18378 = InstructionBlock(
	Allocate('LOr18367'),
	Allocate('LAnd18346'),
	Allocate('LAnd18339'),
	Allocate('LAnd18332'),
	If(Constrain('meta.tunnel_metadata.ingress_tunnel_type', :==:(ConstantValue(0))),
		If(Constrain('meta.tunnel_metadata.egress_tunnel_type', :==:(ConstantValue(0))),
			Assign('LAnd18332', ConstantValue(1)),
		Assign('LAnd18332', ConstantValue(0))),
	Assign('LAnd18332', ConstantValue(0))),
	If(Constrain('LAnd18332'),
		If(Constrain('meta.egress_filter_metadata.bd', :==:(ConstantValue(0))),
			Assign('LAnd18339', ConstantValue(1)),
		Assign('LAnd18339', ConstantValue(0))),
	Assign('LAnd18339', ConstantValue(0))),
	Deallocate('LAnd18332'),
	If(Constrain('LAnd18339'),
		If(Constrain('meta.egress_filter_metadata.ifindex_check', :==:(ConstantValue(0))),
			Assign('LAnd18346', ConstantValue(1)),
		Assign('LAnd18346', ConstantValue(0))),
	Assign('LAnd18346', ConstantValue(0))),
	Deallocate('LAnd18339'),
	Allocate('LAnd18366'),
	Allocate('LAnd18359'),
	If(Constrain('meta.tunnel_metadata.ingress_tunnel_type', :~:(:==:(ConstantValue(0)))),
		If(Constrain('meta.tunnel_metadata.egress_tunnel_type', :~:(:==:(ConstantValue(0)))),
			Assign('LAnd18359', ConstantValue(1)),
		Assign('LAnd18359', ConstantValue(0))),
	Assign('LAnd18359', ConstantValue(0))),
	If(Constrain('LAnd18359'),
		If(Constrain('meta.egress_filter_metadata.inner_bd', :==:(ConstantValue(0))),
			Assign('LAnd18366', ConstantValue(1)),
		Assign('LAnd18366', ConstantValue(0))),
	Assign('LAnd18366', ConstantValue(0))),
	Deallocate('LAnd18359'),
	If(Constrain('LAnd18346'),
		If(Constrain('LAnd18366'),
			Assign('LOr18367', ConstantValue(1)),
		Assign('LOr18367', ConstantValue(0))),
	Assign('LOr18367', ConstantValue(1))),
	Deallocate('LAnd18346'),
	Deallocate('LAnd18366'),
	If(Constrain('LOr18367'), :==:(ConstantValue(1)), block18376),
	Deallocate('LOr18367')
)

val block18380 = InstructionBlock(
	egress_filter,
	If(Constrain('meta.multicast_metadata.inner_replica', :==:(ConstantValue(1))), block18378)
)

val block18410 = InstructionBlock(

)

val block18430 = InstructionBlock(
	mark_to_drop
)

val block18477 = InstructionBlock(
	clone3
)

val block18503 = InstructionBlock(
	egress_copy_to_cpu,
	mark_to_drop
)

val block18533 = InstructionBlock(
	Assign('meta.fabric_metadata.reason_code', :@('reason_code')),
	egress_copy_to_cpu
)

val block18564 = InstructionBlock(
	egress_copy_to_cpu_with_reason,
	mark_to_drop
)

val block18613 = InstructionBlock(
	Assign('meta.i2e_metadata.mirror_session_id', :@('session_id')),
	clone3
)

val block18644 = InstructionBlock(
	egress_mirror,
	mark_to_drop
)

val block18754 = InstructionBlock(
	egress_system_acl
)

val block18756 = InstructionBlock(
	If(Constrain('meta.egress_metadata.bypass', :==:(ConstantValue(0))), block18754)
)

val block18822 = InstructionBlock(
	Assign('meta.egress_metadata.port_type', ConstantValue(0)),
	Assign('meta.egress_metadata.ifindex', :@('ifindex')),
	Assign('meta.qos_metadata.egress_qos_group', :@('qos_group')),
	Assign('meta.acl_metadata.egress_if_label', :@('if_label'))
)

val block18858 = InstructionBlock(
	Assign('meta.egress_metadata.port_type', ConstantValue(1)),
	Assign('meta.egress_metadata.ifindex', :@('ifindex')),
	Assign('meta.tunnel_metadata.egress_tunnel_type', ConstantValue(15))
)

val block18894 = InstructionBlock(
	Assign('meta.egress_metadata.port_type', ConstantValue(2)),
	Assign('meta.egress_metadata.ifindex', :@('ifindex')),
	Assign('meta.tunnel_metadata.egress_tunnel_type', ConstantValue(16))
)

val block19252 = InstructionBlock(
	process_mirroring_0
)

val block19267 = InstructionBlock(
	process_replication_0
)

val block19305 = InstructionBlock(
	process_vlan_decap_0
)

val block19424 = InstructionBlock(
	Allocate('LOr19290'),
	If(Constrain('standard_metadata.instance_type', :==:(ConstantValue(0))),
		If(Constrain('standard_metadata.instance_type', :==:(ConstantValue(5))),
			Assign('LOr19290', ConstantValue(1)),
		Assign('LOr19290', ConstantValue(0))),
	Assign('LOr19290', ConstantValue(1))),
	If(Constrain('LOr19290'), :==:(ConstantValue(1)), block19305),
	Deallocate('LOr19290'),
	process_tunnel_decap_0,
	process_rewrite_0,
	process_egress_bd_0,
	process_egress_qos_map_0,
	process_mac_rewrite_0,
	process_mtu_0,
	process_int_insertion_0,
	process_egress_nat_0,
	process_egress_bd_stats_0
)

val block19475 = InstructionBlock(
	process_egress_acl_0
)

val block19510 = InstructionBlock(
	process_vlan_xlate_0
)

val block19525 = InstructionBlock(
	Allocate('LAnd19237'),
	If(Constrain('standard_metadata.instance_type', :~:(:==:(ConstantValue(0)))),
		If(Constrain('standard_metadata.instance_type', :~:(:==:(ConstantValue(5)))),
			Assign('LAnd19237', ConstantValue(1)),
		Assign('LAnd19237', ConstantValue(0))),
	Assign('LAnd19237', ConstantValue(0))),
	If(Constrain('LAnd19237'), :==:(ConstantValue(1)), block19252, block19267),
	Deallocate('LAnd19237'),
	Fork(InstructionBlock(), block19424),
	process_egress_l4port_0,
	process_tunnel_encap_0,
	If(Constrain('meta.egress_metadata.port_type', :==:(ConstantValue(0))), block19475),
	process_int_outer_encap_0,
	If(Constrain('meta.egress_metadata.port_type', :==:(ConstantValue(0))), block19510),
	process_egress_filter_0
)

val block19547 = InstructionBlock(
	process_egress_system_acl_0
)

val block19549 = InstructionBlock(
	Allocate('LAnd19225'),
	If(Constrain('meta.intrinsic_metadata.deflection_flag', :==:(ConstantValue(0))),
		If(Constrain('meta.egress_metadata.bypass', :==:(ConstantValue(0))),
			Assign('LAnd19225', ConstantValue(1)),
		Assign('LAnd19225', ConstantValue(0))),
	Assign('LAnd19225', ConstantValue(0))),
	If(Constrain('LAnd19225'), :==:(ConstantValue(1)), block19525),
	Deallocate('LAnd19225'),
	If(Constrain('meta.egress_metadata.port_type', :==:(ConstantValue(0))), block19547)
)

val block19599 = InstructionBlock(
	Assign('meta.ingress_metadata.ifindex', :@('ifindex')),
	Assign('meta.ingress_metadata.port_type', :@('port_type'))
)

val block19683 = InstructionBlock(
	Assign('meta.acl_metadata.if_label', :@('if_label')),
	Assign('meta.qos_metadata.ingress_qos_group', :@('qos_group')),
	Assign('meta.qos_metadata.tc_qos_group', :@('tc_qos_group')),
	Assign('meta.qos_metadata.lkp_tc', :@('tc')),
	Assign('meta.meter_metadata.packet_color', :@('color')),
	Assign('meta.qos_metadata.trust_dscp', :@('trust_dscp')),
	Assign('meta.qos_metadata.trust_pcp', :@('trust_pcp'))
)

val block19787 = InstructionBlock(
	ingress_port_mapping,
	ingress_port_properties
)

val block19841 = InstructionBlock(
	Assign('meta.l3_metadata.lkp_ip_type', ConstantValue(1)),
	Assign('meta.l3_metadata.lkp_dscp', :@('hdr.ipv4.diffserv')),
	Assign('meta.l3_metadata.lkp_ip_version', :@('hdr.ipv4.version'))
)

val block19871 = InstructionBlock(
	Assign('meta.ingress_metadata.drop_flag', ConstantValue(1)),
	Assign('meta.ingress_metadata.drop_reason', :@('drop_reason'))
)

val block19948 = InstructionBlock(
	validate_outer_ipv4_packet
)

val block20002 = InstructionBlock(
	Assign('meta.l3_metadata.lkp_ip_type', ConstantValue(2)),
	Assign('meta.l3_metadata.lkp_dscp', :@('hdr.ipv6.trafficClass')),
	Assign('meta.l3_metadata.lkp_ip_version', :@('hdr.ipv6.version'))
)

val block20032 = InstructionBlock(
	Assign('meta.ingress_metadata.drop_flag', ConstantValue(1)),
	Assign('meta.ingress_metadata.drop_reason', :@('drop_reason'))
)

val block20109 = InstructionBlock(
	validate_outer_ipv6_packet
)

val block20163 = InstructionBlock(
	Assign('meta.tunnel_metadata.mpls_label', :@('hdr.mpls_0.label')),
	Assign('meta.tunnel_metadata.mpls_exp', :@('hdr.mpls_0.exp'))
)

val block20201 = InstructionBlock(
	Assign('meta.tunnel_metadata.mpls_label', :@('hdr.mpls_1.label')),
	Assign('meta.tunnel_metadata.mpls_exp', :@('hdr.mpls_1.exp'))
)

val block20239 = InstructionBlock(
	Assign('meta.tunnel_metadata.mpls_label', :@('hdr.mpls_2.label')),
	Assign('meta.tunnel_metadata.mpls_exp', :@('hdr.mpls_2.exp'))
)

val block20392 = InstructionBlock(
	validate_mpls_packet
)

val block20438 = InstructionBlock(
	Assign('meta.ingress_metadata.drop_flag', ConstantValue(1)),
	Assign('meta.ingress_metadata.drop_reason', :@('drop_reason'))
)

val block20467 = InstructionBlock(
	Assign('meta.l2_metadata.lkp_pkt_type', ConstantValue(1)),
	Assign('meta.l2_metadata.lkp_mac_type', :@('hdr.ethernet.etherType'))
)

val block20511 = InstructionBlock(
	Assign('meta.l2_metadata.lkp_pkt_type', ConstantValue(1)),
	Assign('meta.l2_metadata.lkp_mac_type', :@('hdr.vlan_tag__0.etherType')),
	Assign('meta.l2_metadata.lkp_pcp', :@('hdr.vlan_tag__0.pcp'))
)

val block20555 = InstructionBlock(
	Assign('meta.l2_metadata.lkp_pkt_type', ConstantValue(1)),
	Assign('meta.l2_metadata.lkp_mac_type', :@('hdr.vlan_tag__1.etherType')),
	Assign('meta.l2_metadata.lkp_pcp', :@('hdr.vlan_tag__0.pcp'))
)

val block20596 = InstructionBlock(
	Assign('meta.l2_metadata.lkp_pkt_type', ConstantValue(1)),
	Assign('meta.l2_metadata.lkp_mac_type', :@('hdr.ethernet.etherType')),
	Assign('meta.l2_metadata.lkp_pcp', :@('hdr.vlan_tag__0.pcp'))
)

val block20625 = InstructionBlock(
	Assign('meta.l2_metadata.lkp_pkt_type', ConstantValue(2)),
	Assign('meta.l2_metadata.lkp_mac_type', :@('hdr.ethernet.etherType'))
)

val block20669 = InstructionBlock(
	Assign('meta.l2_metadata.lkp_pkt_type', ConstantValue(2)),
	Assign('meta.l2_metadata.lkp_mac_type', :@('hdr.vlan_tag__0.etherType')),
	Assign('meta.l2_metadata.lkp_pcp', :@('hdr.vlan_tag__0.pcp'))
)

val block20713 = InstructionBlock(
	Assign('meta.l2_metadata.lkp_pkt_type', ConstantValue(2)),
	Assign('meta.l2_metadata.lkp_mac_type', :@('hdr.vlan_tag__1.etherType')),
	Assign('meta.l2_metadata.lkp_pcp', :@('hdr.vlan_tag__0.pcp'))
)

val block20754 = InstructionBlock(
	Assign('meta.l2_metadata.lkp_pkt_type', ConstantValue(2)),
	Assign('meta.l2_metadata.lkp_mac_type', :@('hdr.ethernet.etherType')),
	Assign('meta.l2_metadata.lkp_pcp', :@('hdr.vlan_tag__0.pcp'))
)

val block20783 = InstructionBlock(
	Assign('meta.l2_metadata.lkp_pkt_type', ConstantValue(4)),
	Assign('meta.l2_metadata.lkp_mac_type', :@('hdr.ethernet.etherType'))
)

val block20827 = InstructionBlock(
	Assign('meta.l2_metadata.lkp_pkt_type', ConstantValue(4)),
	Assign('meta.l2_metadata.lkp_mac_type', :@('hdr.vlan_tag__0.etherType')),
	Assign('meta.l2_metadata.lkp_pcp', :@('hdr.vlan_tag__0.pcp'))
)

val block20871 = InstructionBlock(
	Assign('meta.l2_metadata.lkp_pkt_type', ConstantValue(4)),
	Assign('meta.l2_metadata.lkp_mac_type', :@('hdr.vlan_tag__1.etherType')),
	Assign('meta.l2_metadata.lkp_pcp', :@('hdr.vlan_tag__0.pcp'))
)

val block20912 = InstructionBlock(
	Assign('meta.l2_metadata.lkp_pkt_type', ConstantValue(4)),
	Assign('meta.l2_metadata.lkp_mac_type', :@('hdr.ethernet.etherType')),
	Assign('meta.l2_metadata.lkp_pcp', :@('hdr.vlan_tag__0.pcp'))
)

val block21102 = InstructionBlock(
	validate_outer_ipv4_header_0
)

val block21125 = InstructionBlock(
	validate_outer_ipv6_header_0
)

val block21151 = InstructionBlock(
	validate_mpls_header_0
)

val block21153 = InstructionBlock(
	If(Constrain(hdr.mpls_0.isValid), block21151)
)

val block21155 = InstructionBlock(
	If(Constrain(hdr.ipv6.isValid), block21125, block21153)
)

val block21157 = InstructionBlock(
	If(Constrain(hdr.ipv4.isValid), block21102, block21155)
)

val block21162 = InstructionBlock(

)

val block21167 = InstructionBlock(
	Fork(InstructionBlock(), block21157,block21162)
)

val block21207 = InstructionBlock(
	Assign('meta.intrinsic_metadata.deflect_on_drop', :@('enable_dod'))
)

val block21282 = InstructionBlock(
	deflect_on_drop,
	Assign('meta.i2e_metadata.ingress_tstamp', :@('meta.intrinsic_metadata.ingress_global_timestamp')),
	Assign('meta.ingress_metadata.ingress_port', :@('standard_metadata.ingress_port')),
	Assign('meta.l2_metadata.same_if_check', :@('meta.ingress_metadata.ifindex')),
	Assign('standard_metadata.egress_spec', ConstantValue(511)),
	random
)

val block21327 = InstructionBlock(
	switch_config_params
)

val block21564 = InstructionBlock(
	Assign('meta.ingress_metadata.bd', :@('bd')),
	Assign('meta.ingress_metadata.outer_bd', :@('bd')),
	Assign('meta.acl_metadata.bd_label', :@('bd_label')),
	Assign('meta.l2_metadata.stp_group', :@('stp_group')),
	Assign('meta.l2_metadata.bd_stats_idx', :@('stats_idx')),
	Assign('meta.l2_metadata.learning_enabled', :@('learning_enabled')),
	Assign('meta.l3_metadata.vrf', :@('vrf')),
	Assign('meta.ipv4_metadata.ipv4_unicast_enabled', :@('ipv4_unicast_enabled')),
	Assign('meta.ipv6_metadata.ipv6_unicast_enabled', :@('ipv6_unicast_enabled')),
	Assign('meta.ipv4_metadata.ipv4_urpf_mode', :@('ipv4_urpf_mode')),
	Assign('meta.ipv6_metadata.ipv6_urpf_mode', :@('ipv6_urpf_mode')),
	Assign('meta.l3_metadata.rmac_group', :@('rmac_group')),
	Assign('meta.multicast_metadata.igmp_snooping_enabled', :@('igmp_snooping_enabled')),
	Assign('meta.multicast_metadata.mld_snooping_enabled', :@('mld_snooping_enabled')),
	Assign('meta.multicast_metadata.ipv4_multicast_enabled', :@('ipv4_multicast_enabled')),
	Assign('meta.multicast_metadata.ipv6_multicast_enabled', :@('ipv6_multicast_enabled')),
	Assign('meta.multicast_metadata.bd_mrpf_group', :@('mrpf_group')),
	Assign('meta.multicast_metadata.ipv4_mcast_key_type', :@('ipv4_mcast_key_type')),
	Assign('meta.multicast_metadata.ipv4_mcast_key', :@('ipv4_mcast_key')),
	Assign('meta.multicast_metadata.ipv6_mcast_key_type', :@('ipv6_mcast_key_type')),
	Assign('meta.multicast_metadata.ipv6_mcast_key', :@('ipv6_mcast_key'))
)

val block21584 = InstructionBlock(
	Assign('meta.l2_metadata.port_vlan_mapping_miss', ConstantValue(1))
)

val block21704 = InstructionBlock(
	port_vlan_mapping
)

val block21744 = InstructionBlock(
	Assign('meta.l2_metadata.stp_state', :@('stp_state'))
)

val block21820 = InstructionBlock(
	spanning_tree
)

val block21822 = InstructionBlock(
	Allocate('LAnd21811'),
	If(Constrain('meta.ingress_metadata.port_type', :==:(ConstantValue(0))),
		If(Constrain('meta.l2_metadata.stp_group', :~:(:==:(ConstantValue(0)))),
			Assign('LAnd21811', ConstantValue(1)),
		Assign('LAnd21811', ConstantValue(0))),
	Assign('LAnd21811', ConstantValue(0))),
	If(Constrain('LAnd21811'), :==:(ConstantValue(1)), block21820),
	Deallocate('LAnd21811')
)

val block21852 = InstructionBlock(

)

val block21876 = InstructionBlock(
	Assign('meta.qos_metadata.lkp_tc', :@('tc'))
)

val block21900 = InstructionBlock(
	Assign('meta.meter_metadata.packet_color', :@('color'))
)

val block21934 = InstructionBlock(
	Assign('meta.qos_metadata.lkp_tc', :@('tc')),
	Assign('meta.meter_metadata.packet_color', :@('color'))
)

val block22081 = InstructionBlock(
	ingress_qos_map_dscp
)

val block22097 = InstructionBlock(
	ingress_qos_map_pcp
)

val block22099 = InstructionBlock(
	If(Constrain('meta.qos_metadata.trust_pcp', :==:(ConstantValue(1))), block22097)
)

val block22101 = InstructionBlock(
	If(Constrain('meta.qos_metadata.trust_dscp', :==:(ConstantValue(1))), block22081, block22099)
)

val block22103 = InstructionBlock(
	If(Constrain('<BOr>22063', :==:(ConstantValue(0))), block22101)
)

val block22133 = InstructionBlock(

)

val block22153 = InstructionBlock(
	Assign('meta.security_metadata.ipsg_check_fail', ConstantValue(1))
)

val block22312 = InstructionBlock(
	ipsg_permit_special
)

val block22317 = InstructionBlock(
	Fork(InstructionBlock(), block22312)
)

val block22319 = InstructionBlock(
	Allocate('LAnd22292'),
	If(Constrain('meta.ingress_metadata.port_type', :==:(ConstantValue(0))),
		If(Constrain('meta.security_metadata.ipsg_enabled', :==:(ConstantValue(1))),
			Assign('LAnd22292', ConstantValue(1)),
		Assign('LAnd22292', ConstantValue(0))),
	Assign('LAnd22292', ConstantValue(0))),
	If(Constrain('LAnd22292'), :==:(ConstantValue(1)), block22317),
	Deallocate('LAnd22292')
)

val block22394 = InstructionBlock(
	Assign('hdr.vxlan_gpe.next_proto', :@('hdr.vxlan_gpe_int_header.next_proto')),
	Assign('hdr.vxlan_gpe_int_header.isValid', ConstantValue(0)),
	Assign('hdr.ipv4.totalLen', :-:(:@('hdr.ipv4.totalLen'), :@('meta.int_metadata.insert_byte_cnt'))),
	Assign('hdr.udp.length_', :-:(:@('hdr.udp.length_'), :@('meta.int_metadata.insert_byte_cnt')))
)

val block22408 = InstructionBlock(

)

val block22428 = InstructionBlock(
	Assign('meta.int_metadata_i2e.source', ConstantValue(1))
)

val block22448 = InstructionBlock(
	Assign('meta.int_metadata_i2e.source', ConstantValue(0))
)

val block22775 = InstructionBlock(
	Assign('meta.int_metadata_i2e.sink', ConstantValue(1)),
	Assign('meta.i2e_metadata.mirror_session_id', :@('mirror_id')),
	clone3,
	Assign('hdr.int_header.isValid', ConstantValue(0)),
	Assign('hdr.int_val_0.isValid', ConstantValue(0)),
	Assign('hdr.int_val_1.isValid', ConstantValue(0)),
	Assign('hdr.int_val_2.isValid', ConstantValue(0)),
	Assign('hdr.int_val_3.isValid', ConstantValue(0)),
	Assign('hdr.int_val_4.isValid', ConstantValue(0)),
	Assign('hdr.int_val_5.isValid', ConstantValue(0)),
	Assign('hdr.int_val_6.isValid', ConstantValue(0)),
	Assign('hdr.int_val_7.isValid', ConstantValue(0)),
	Assign('hdr.int_val_8.isValid', ConstantValue(0)),
	Assign('hdr.int_val_9.isValid', ConstantValue(0)),
	Assign('hdr.int_val_10.isValid', ConstantValue(0)),
	Assign('hdr.int_val_11.isValid', ConstantValue(0)),
	Assign('hdr.int_val_12.isValid', ConstantValue(0)),
	Assign('hdr.int_val_13.isValid', ConstantValue(0)),
	Assign('hdr.int_val_14.isValid', ConstantValue(0)),
	Assign('hdr.int_val_15.isValid', ConstantValue(0)),
	Assign('hdr.int_val_16.isValid', ConstantValue(0)),
	Assign('hdr.int_val_17.isValid', ConstantValue(0)),
	Assign('hdr.int_val_18.isValid', ConstantValue(0)),
	Assign('hdr.int_val_19.isValid', ConstantValue(0)),
	Assign('hdr.int_val_20.isValid', ConstantValue(0)),
	Assign('hdr.int_val_21.isValid', ConstantValue(0)),
	Assign('hdr.int_val_22.isValid', ConstantValue(0)),
	Assign('hdr.int_val_23.isValid', ConstantValue(0))
)

val block22812 = InstructionBlock(
	Assign('meta.int_metadata.insert_byte_cnt', <Shl>22802),
	int_sink
)

val block22832 = InstructionBlock(
	Assign('meta.int_metadata_i2e.sink', ConstantValue(0))
)

val block23111 = InstructionBlock(
	int_source
)

val block23127 = InstructionBlock(
	int_terminate,
	int_sink_update_outer
)

val block23129 = InstructionBlock(
	If(Constrain(!hdr.int_header.isValid), block23111, block23127)
)

val block23159 = InstructionBlock(

)

val block23230 = InstructionBlock(
	Assign('meta.i2e_metadata.mirror_session_id', :@('sflow_i2e_mirror_id')),
	clone3
)

val block23269 = InstructionBlock(
	Assign('meta.ingress_metadata.sflow_take_sample', :+:(:@('rate_thr'), :@('meta.ingress_metadata.sflow_take_sample'))),
	Assign('meta.sflow_metadata.sflow_session_id', :@('session_id'))
)

val block23431 = InstructionBlock(
	sflow_ingress,
	sflow_ing_take_sample
)

val block23461 = InstructionBlock(

)

val block23534 = InstructionBlock(
	Assign('standard_metadata.egress_spec', :@('hdr.fabric_header.dstPortOrGroup')),
	Assign('meta.egress_metadata.bypass', :@('hdr.fabric_header_cpu.txBypass')),
	Assign('meta.intrinsic_metadata.mcast_grp', :@('hdr.fabric_header_cpu.mcast_grp')),
	Assign('hdr.ethernet.etherType', :@('hdr.fabric_payload_header.etherType')),
	Assign('hdr.fabric_header.isValid', ConstantValue(0)),
	Assign('hdr.fabric_header_cpu.isValid', ConstantValue(0)),
	Assign('hdr.fabric_payload_header.isValid', ConstantValue(0))
)

val block23572 = InstructionBlock(
	Assign('meta.fabric_metadata.fabric_header_present', ConstantValue(1)),
	Assign('meta.fabric_metadata.dst_device', :@('hdr.fabric_header.dstDevice')),
	Assign('meta.fabric_metadata.dst_port', :@('hdr.fabric_header.dstPortOrGroup'))
)

val block23672 = InstructionBlock(
	Assign('standard_metadata.egress_spec', :@('hdr.fabric_header.dstPortOrGroup')),
	Assign('meta.tunnel_metadata.tunnel_terminate', :@('hdr.fabric_header_unicast.tunnelTerminate')),
	Assign('meta.tunnel_metadata.ingress_tunnel_type', :@('hdr.fabric_header_unicast.ingressTunnelType')),
	Assign('meta.l3_metadata.nexthop_index', :@('hdr.fabric_header_unicast.nexthopIndex')),
	Assign('meta.l3_metadata.routed', :@('hdr.fabric_header_unicast.routed')),
	Assign('meta.l3_metadata.outer_routed', :@('hdr.fabric_header_unicast.outerRouted')),
	Assign('hdr.ethernet.etherType', :@('hdr.fabric_payload_header.etherType')),
	Assign('hdr.fabric_header.isValid', ConstantValue(0)),
	Assign('hdr.fabric_header_unicast.isValid', ConstantValue(0)),
	Assign('hdr.fabric_payload_header.isValid', ConstantValue(0))
)

val block23701 = InstructionBlock(
	Assign('meta.fabric_metadata.fabric_header_present', ConstantValue(1)),
	Assign('meta.intrinsic_metadata.mcast_grp', :@('hdr.fabric_header.dstPortOrGroup'))
)

val block23799 = InstructionBlock(
	Assign('meta.tunnel_metadata.tunnel_terminate', :@('hdr.fabric_header_multicast.tunnelTerminate')),
	Assign('meta.tunnel_metadata.ingress_tunnel_type', :@('hdr.fabric_header_multicast.ingressTunnelType')),
	Assign('meta.l3_metadata.nexthop_index', ConstantValue(0)),
	Assign('meta.l3_metadata.routed', :@('hdr.fabric_header_multicast.routed')),
	Assign('meta.l3_metadata.outer_routed', :@('hdr.fabric_header_multicast.outerRouted')),
	Assign('meta.intrinsic_metadata.mcast_grp', :@('hdr.fabric_header_multicast.mcastGrp')),
	Assign('hdr.ethernet.etherType', :@('hdr.fabric_payload_header.etherType')),
	Assign('hdr.fabric_header.isValid', ConstantValue(0)),
	Assign('hdr.fabric_header_multicast.isValid', ConstantValue(0)),
	Assign('hdr.fabric_payload_header.isValid', ConstantValue(0))
)

val block23813 = InstructionBlock(

)

val block23854 = InstructionBlock(
	Assign('meta.l2_metadata.lkp_mac_sa', :@('hdr.ethernet.srcAddr')),
	Assign('meta.l2_metadata.lkp_mac_da', :@('hdr.ethernet.dstAddr')),
	Assign('meta.l2_metadata.lkp_mac_type', :@('hdr.ethernet.etherType'))
)

val block23931 = InstructionBlock(
	Assign('meta.l2_metadata.lkp_mac_sa', :@('hdr.ethernet.srcAddr')),
	Assign('meta.l2_metadata.lkp_mac_da', :@('hdr.ethernet.dstAddr')),
	Assign('meta.ipv4_metadata.lkp_ipv4_sa', :@('hdr.ipv4.srcAddr')),
	Assign('meta.ipv4_metadata.lkp_ipv4_da', :@('hdr.ipv4.dstAddr')),
	Assign('meta.l3_metadata.lkp_ip_proto', :@('hdr.ipv4.protocol')),
	Assign('meta.l3_metadata.lkp_l4_sport', :@('meta.l3_metadata.lkp_outer_l4_sport')),
	Assign('meta.l3_metadata.lkp_l4_dport', :@('meta.l3_metadata.lkp_outer_l4_dport'))
)

val block24008 = InstructionBlock(
	Assign('meta.l2_metadata.lkp_mac_sa', :@('hdr.ethernet.srcAddr')),
	Assign('meta.l2_metadata.lkp_mac_da', :@('hdr.ethernet.dstAddr')),
	Assign('meta.ipv6_metadata.lkp_ipv6_sa', :@('hdr.ipv6.srcAddr')),
	Assign('meta.ipv6_metadata.lkp_ipv6_da', :@('hdr.ipv6.dstAddr')),
	Assign('meta.l3_metadata.lkp_ip_proto', :@('hdr.ipv6.nextHdr')),
	Assign('meta.l3_metadata.lkp_l4_sport', :@('meta.l3_metadata.lkp_outer_l4_sport')),
	Assign('meta.l3_metadata.lkp_l4_dport', :@('meta.l3_metadata.lkp_outer_l4_dport'))
)

val block24213 = InstructionBlock(
	fabric_ingress_src_lkp
)

val block24229 = InstructionBlock(
	native_packet_over_fabric
)

val block24231 = InstructionBlock(
	If(Constrain(hdr.fabric_header_multicast.isValid), block24213),
	If(Constrain('meta.tunnel_metadata.tunnel_terminate', :==:(ConstantValue(0))), block24229)
)

val block24233 = InstructionBlock(
	fabric_ingress_dst_lkp,
	If(Constrain('meta.ingress_metadata.port_type', :==:(ConstantValue(1))), block24231)
)

val block24235 = InstructionBlock(
	If(Constrain('meta.ingress_metadata.port_type', :~:(:==:(ConstantValue(0)))), block24233)
)

val block24265 = InstructionBlock(

)

val block24285 = InstructionBlock(
	Assign('meta.tunnel_metadata.tunnel_terminate', ConstantValue(1))
)

val block24315 = InstructionBlock(
	Assign('meta.tunnel_metadata.tunnel_vni', :@('tunnel_vni')),
	Assign('meta.tunnel_metadata.tunnel_terminate', ConstantValue(1))
)

val block24329 = InstructionBlock(

)

val block24353 = InstructionBlock(
	Assign('meta.ingress_metadata.ifindex', :@('ifindex'))
)

val block24500 = InstructionBlock(
	ipv4_dest_vtep
)

val block24505 = InstructionBlock(
	Fork(InstructionBlock(), block24500)
)

val block24535 = InstructionBlock(

)

val block24555 = InstructionBlock(
	Assign('meta.tunnel_metadata.tunnel_terminate', ConstantValue(1))
)

val block24585 = InstructionBlock(
	Assign('meta.tunnel_metadata.tunnel_vni', :@('tunnel_vni')),
	Assign('meta.tunnel_metadata.tunnel_terminate', ConstantValue(1))
)

val block24599 = InstructionBlock(

)

val block24623 = InstructionBlock(
	Assign('meta.ingress_metadata.ifindex', :@('ifindex'))
)

val block24770 = InstructionBlock(
	ipv6_dest_vtep
)

val block24775 = InstructionBlock(
	Fork(InstructionBlock(), block24770)
)

val block24840 = InstructionBlock(
	Assign('meta.tunnel_metadata.tunnel_terminate', ConstantValue(1)),
	Assign('meta.tunnel_metadata.ingress_tunnel_type', :@('tunnel_type')),
	Assign('meta.ingress_metadata.bd', :@('bd')),
	Assign('meta.l2_metadata.lkp_mac_type', :@('hdr.inner_ethernet.etherType'))
)

val block24889 = InstructionBlock(
	Assign('meta.tunnel_metadata.tunnel_terminate', ConstantValue(1)),
	Assign('meta.tunnel_metadata.ingress_tunnel_type', :@('tunnel_type')),
	Assign('meta.ingress_metadata.bd', :@('bd')),
	Assign('meta.l2_metadata.lkp_mac_type', :@('hdr.inner_ethernet.etherType'))
)

val block24971 = InstructionBlock(
	Assign('meta.tunnel_metadata.tunnel_terminate', ConstantValue(1)),
	Assign('meta.tunnel_metadata.ingress_tunnel_type', :@('tunnel_type')),
	Assign('meta.l3_metadata.vrf', :@('vrf')),
	Assign('meta.l2_metadata.lkp_mac_sa', :@('hdr.ethernet.srcAddr')),
	Assign('meta.l2_metadata.lkp_mac_da', :@('hdr.ethernet.dstAddr')),
	Assign('meta.l3_metadata.lkp_ip_type', ConstantValue(1)),
	Assign('meta.l2_metadata.lkp_mac_type', :@('hdr.inner_ethernet.etherType')),
	Assign('meta.l3_metadata.lkp_ip_version', :@('hdr.inner_ipv4.version'))
)

val block25053 = InstructionBlock(
	Assign('meta.tunnel_metadata.tunnel_terminate', ConstantValue(1)),
	Assign('meta.tunnel_metadata.ingress_tunnel_type', :@('tunnel_type')),
	Assign('meta.l3_metadata.vrf', :@('vrf')),
	Assign('meta.l2_metadata.lkp_mac_sa', :@('hdr.ethernet.srcAddr')),
	Assign('meta.l2_metadata.lkp_mac_da', :@('hdr.ethernet.dstAddr')),
	Assign('meta.l3_metadata.lkp_ip_type', ConstantValue(2)),
	Assign('meta.l2_metadata.lkp_mac_type', :@('hdr.inner_ethernet.etherType')),
	Assign('meta.l3_metadata.lkp_ip_version', :@('hdr.inner_ipv6.version'))
)

val block25095 = InstructionBlock(
	Assign('meta.ingress_metadata.egress_ifindex', :@('ifindex')),
	Assign('meta.l2_metadata.lkp_mac_sa', :@('hdr.ethernet.srcAddr')),
	Assign('meta.l2_metadata.lkp_mac_da', :@('hdr.ethernet.dstAddr'))
)

val block25149 = InstructionBlock(
	Assign('meta.l3_metadata.fib_nexthop', :@('nexthop_index')),
	Assign('meta.l3_metadata.fib_nexthop_type', ConstantValue(0)),
	Assign('meta.l3_metadata.fib_hit', ConstantValue(1)),
	Assign('meta.l2_metadata.lkp_mac_sa', :@('hdr.ethernet.srcAddr')),
	Assign('meta.l2_metadata.lkp_mac_da', :@('hdr.ethernet.dstAddr'))
)

val block25239 = InstructionBlock(
	mpls_0
)

val block25269 = InstructionBlock(

)

val block25283 = InstructionBlock(

)

val block25334 = InstructionBlock(
	Assign('meta.intrinsic_metadata.mcast_grp', :@('mc_index')),
	Assign('meta.multicast_metadata.outer_mcast_route_hit', ConstantValue(1)),
	Assign('meta.multicast_metadata.mcast_rpf_group', <BXor>25326),
	Assign('meta.fabric_metadata.dst_device', ConstantValue(127))
)

val block25370 = InstructionBlock(
	Assign('meta.intrinsic_metadata.mcast_grp', :@('mc_index')),
	Assign('meta.tunnel_metadata.tunnel_terminate', ConstantValue(1)),
	Assign('meta.fabric_metadata.dst_device', ConstantValue(127))
)

val block25427 = InstructionBlock(
	Assign('meta.multicast_metadata.outer_mcast_mode', ConstantValue(1)),
	Assign('meta.intrinsic_metadata.mcast_grp', :@('mc_index')),
	Assign('meta.multicast_metadata.outer_mcast_route_hit', ConstantValue(1)),
	Assign('meta.multicast_metadata.mcast_rpf_group', <BXor>25419),
	Assign('meta.fabric_metadata.dst_device', ConstantValue(127))
)

val block25484 = InstructionBlock(
	Assign('meta.multicast_metadata.outer_mcast_mode', ConstantValue(2)),
	Assign('meta.intrinsic_metadata.mcast_grp', :@('mc_index')),
	Assign('meta.multicast_metadata.outer_mcast_route_hit', ConstantValue(1)),
	Assign('meta.multicast_metadata.mcast_rpf_group', <BOr>25476),
	Assign('meta.fabric_metadata.dst_device', ConstantValue(127))
)

val block25520 = InstructionBlock(
	Assign('meta.intrinsic_metadata.mcast_grp', :@('mc_index')),
	Assign('meta.tunnel_metadata.tunnel_terminate', ConstantValue(1)),
	Assign('meta.fabric_metadata.dst_device', ConstantValue(127))
)

val block25683 = InstructionBlock(
	outer_ipv4_multicast_star_g
)

val block25688 = InstructionBlock(
	Fork(InstructionBlock(), block25683)
)

val block25718 = InstructionBlock(

)

val block25732 = InstructionBlock(

)

val block25783 = InstructionBlock(
	Assign('meta.intrinsic_metadata.mcast_grp', :@('mc_index')),
	Assign('meta.multicast_metadata.outer_mcast_route_hit', ConstantValue(1)),
	Assign('meta.multicast_metadata.mcast_rpf_group', <BXor>25775),
	Assign('meta.fabric_metadata.dst_device', ConstantValue(127))
)

val block25819 = InstructionBlock(
	Assign('meta.intrinsic_metadata.mcast_grp', :@('mc_index')),
	Assign('meta.tunnel_metadata.tunnel_terminate', ConstantValue(1)),
	Assign('meta.fabric_metadata.dst_device', ConstantValue(127))
)

val block25876 = InstructionBlock(
	Assign('meta.multicast_metadata.outer_mcast_mode', ConstantValue(1)),
	Assign('meta.intrinsic_metadata.mcast_grp', :@('mc_index')),
	Assign('meta.multicast_metadata.outer_mcast_route_hit', ConstantValue(1)),
	Assign('meta.multicast_metadata.mcast_rpf_group', <BXor>25868),
	Assign('meta.fabric_metadata.dst_device', ConstantValue(127))
)

val block25933 = InstructionBlock(
	Assign('meta.multicast_metadata.outer_mcast_mode', ConstantValue(2)),
	Assign('meta.intrinsic_metadata.mcast_grp', :@('mc_index')),
	Assign('meta.multicast_metadata.outer_mcast_route_hit', ConstantValue(1)),
	Assign('meta.multicast_metadata.mcast_rpf_group', <BOr>25925),
	Assign('meta.fabric_metadata.dst_device', ConstantValue(127))
)

val block25969 = InstructionBlock(
	Assign('meta.intrinsic_metadata.mcast_grp', :@('mc_index')),
	Assign('meta.tunnel_metadata.tunnel_terminate', ConstantValue(1)),
	Assign('meta.fabric_metadata.dst_device', ConstantValue(127))
)

val block26132 = InstructionBlock(
	outer_ipv6_multicast_star_g
)

val block26137 = InstructionBlock(
	Fork(InstructionBlock(), block26132)
)

val block26157 = InstructionBlock(

)

val block26240 = InstructionBlock(
	process_outer_ipv4_multicast_0
)

val block26263 = InstructionBlock(
	process_outer_ipv6_multicast_0
)

val block26265 = InstructionBlock(
	If(Constrain(hdr.ipv6.isValid), block26263)
)

val block26280 = InstructionBlock(
	If(Constrain(hdr.ipv4.isValid), block26240, block26265),
	process_outer_multicast_rpf_0
)

val block26328 = InstructionBlock(
	Assign('meta.l2_metadata.lkp_mac_sa', :@('hdr.ethernet.srcAddr')),
	Assign('meta.l2_metadata.lkp_mac_da', :@('hdr.ethernet.dstAddr'))
)

val block26414 = InstructionBlock(
	Assign('meta.l2_metadata.lkp_mac_sa', :@('hdr.ethernet.srcAddr')),
	Assign('meta.l2_metadata.lkp_mac_da', :@('hdr.ethernet.dstAddr')),
	Assign('meta.ipv4_metadata.lkp_ipv4_sa', :@('hdr.ipv4.srcAddr')),
	Assign('meta.ipv4_metadata.lkp_ipv4_da', :@('hdr.ipv4.dstAddr')),
	Assign('meta.l3_metadata.lkp_ip_proto', :@('hdr.ipv4.protocol')),
	Assign('meta.l3_metadata.lkp_ip_ttl', :@('hdr.ipv4.ttl')),
	Assign('meta.l3_metadata.lkp_l4_sport', :@('meta.l3_metadata.lkp_outer_l4_sport')),
	Assign('meta.l3_metadata.lkp_l4_dport', :@('meta.l3_metadata.lkp_outer_l4_dport'))
)

val block26500 = InstructionBlock(
	Assign('meta.l2_metadata.lkp_mac_sa', :@('hdr.ethernet.srcAddr')),
	Assign('meta.l2_metadata.lkp_mac_da', :@('hdr.ethernet.dstAddr')),
	Assign('meta.ipv6_metadata.lkp_ipv6_sa', :@('hdr.ipv6.srcAddr')),
	Assign('meta.ipv6_metadata.lkp_ipv6_da', :@('hdr.ipv6.dstAddr')),
	Assign('meta.l3_metadata.lkp_ip_proto', :@('hdr.ipv6.nextHdr')),
	Assign('meta.l3_metadata.lkp_ip_ttl', :@('hdr.ipv6.hopLimit')),
	Assign('meta.l3_metadata.lkp_l4_sport', :@('meta.l3_metadata.lkp_outer_l4_sport')),
	Assign('meta.l3_metadata.lkp_l4_dport', :@('meta.l3_metadata.lkp_outer_l4_dport'))
)

val block26514 = InstructionBlock(

)

val block26534 = InstructionBlock(
	Assign('meta.l3_metadata.rmac_hit', ConstantValue(1))
)

val block26548 = InstructionBlock(

)

val block26562 = InstructionBlock(

)

val block26627 = InstructionBlock(
	Assign('meta.tunnel_metadata.tunnel_terminate', ConstantValue(1)),
	Assign('meta.ingress_metadata.bd', :@('bd')),
	Assign('meta.acl_metadata.bd_label', :@('bd_label')),
	Assign('meta.l2_metadata.bd_stats_idx', :@('stats_idx')),
	Assign('meta.l3_metadata.lkp_ip_type', ConstantValue(0)),
	Assign('meta.l2_metadata.lkp_mac_type', :@('hdr.inner_ethernet.etherType'))
)

val block26771 = InstructionBlock(
	Assign('meta.tunnel_metadata.tunnel_terminate', ConstantValue(1)),
	Assign('meta.ingress_metadata.bd', :@('bd')),
	Assign('meta.l3_metadata.vrf', :@('vrf')),
	Assign('meta.ipv4_metadata.ipv4_unicast_enabled', :@('ipv4_unicast_enabled')),
	Assign('meta.ipv4_metadata.ipv4_urpf_mode', :@('ipv4_urpf_mode')),
	Assign('meta.l3_metadata.rmac_group', :@('rmac_group')),
	Assign('meta.acl_metadata.bd_label', :@('bd_label')),
	Assign('meta.l2_metadata.bd_stats_idx', :@('stats_idx')),
	Assign('meta.l3_metadata.lkp_ip_type', ConstantValue(1)),
	Assign('meta.l2_metadata.lkp_mac_type', :@('hdr.inner_ethernet.etherType')),
	Assign('meta.l3_metadata.lkp_ip_version', :@('hdr.inner_ipv4.version')),
	Assign('meta.multicast_metadata.igmp_snooping_enabled', :@('igmp_snooping_enabled')),
	Assign('meta.multicast_metadata.ipv4_multicast_enabled', :@('ipv4_multicast_enabled')),
	Assign('meta.multicast_metadata.bd_mrpf_group', :@('mrpf_group'))
)

val block26884 = InstructionBlock(
	Assign('meta.tunnel_metadata.tunnel_terminate', ConstantValue(1)),
	Assign('meta.l3_metadata.vrf', :@('vrf')),
	Assign('meta.ipv4_metadata.ipv4_unicast_enabled', :@('ipv4_unicast_enabled')),
	Assign('meta.ipv4_metadata.ipv4_urpf_mode', :@('ipv4_urpf_mode')),
	Assign('meta.l3_metadata.rmac_group', :@('rmac_group')),
	Assign('meta.l2_metadata.lkp_mac_sa', :@('hdr.ethernet.srcAddr')),
	Assign('meta.l2_metadata.lkp_mac_da', :@('hdr.ethernet.dstAddr')),
	Assign('meta.l3_metadata.lkp_ip_type', ConstantValue(1)),
	Assign('meta.l3_metadata.lkp_ip_version', :@('hdr.inner_ipv4.version')),
	Assign('meta.multicast_metadata.bd_mrpf_group', :@('mrpf_group')),
	Assign('meta.multicast_metadata.ipv4_multicast_enabled', :@('ipv4_multicast_enabled'))
)

val block27028 = InstructionBlock(
	Assign('meta.tunnel_metadata.tunnel_terminate', ConstantValue(1)),
	Assign('meta.ingress_metadata.bd', :@('bd')),
	Assign('meta.l3_metadata.vrf', :@('vrf')),
	Assign('meta.ipv6_metadata.ipv6_unicast_enabled', :@('ipv6_unicast_enabled')),
	Assign('meta.ipv6_metadata.ipv6_urpf_mode', :@('ipv6_urpf_mode')),
	Assign('meta.l3_metadata.rmac_group', :@('rmac_group')),
	Assign('meta.acl_metadata.bd_label', :@('bd_label')),
	Assign('meta.l2_metadata.bd_stats_idx', :@('stats_idx')),
	Assign('meta.l3_metadata.lkp_ip_type', ConstantValue(2)),
	Assign('meta.l2_metadata.lkp_mac_type', :@('hdr.inner_ethernet.etherType')),
	Assign('meta.l3_metadata.lkp_ip_version', :@('hdr.inner_ipv6.version')),
	Assign('meta.multicast_metadata.bd_mrpf_group', :@('mrpf_group')),
	Assign('meta.multicast_metadata.ipv6_multicast_enabled', :@('ipv6_multicast_enabled')),
	Assign('meta.multicast_metadata.mld_snooping_enabled', :@('mld_snooping_enabled'))
)

val block27141 = InstructionBlock(
	Assign('meta.tunnel_metadata.tunnel_terminate', ConstantValue(1)),
	Assign('meta.l3_metadata.vrf', :@('vrf')),
	Assign('meta.ipv6_metadata.ipv6_unicast_enabled', :@('ipv6_unicast_enabled')),
	Assign('meta.ipv6_metadata.ipv6_urpf_mode', :@('ipv6_urpf_mode')),
	Assign('meta.l3_metadata.rmac_group', :@('rmac_group')),
	Assign('meta.l2_metadata.lkp_mac_sa', :@('hdr.ethernet.srcAddr')),
	Assign('meta.l2_metadata.lkp_mac_da', :@('hdr.ethernet.dstAddr')),
	Assign('meta.l3_metadata.lkp_ip_type', ConstantValue(2)),
	Assign('meta.l3_metadata.lkp_ip_version', :@('hdr.inner_ipv6.version')),
	Assign('meta.multicast_metadata.bd_mrpf_group', :@('mrpf_group')),
	Assign('meta.multicast_metadata.ipv6_multicast_enabled', :@('ipv6_multicast_enabled'))
)

val block27527 = InstructionBlock(
	process_ipv4_vtep_0
)

val block27550 = InstructionBlock(
	process_ipv6_vtep_0
)

val block27576 = InstructionBlock(
	process_mpls_0
)

val block27578 = InstructionBlock(
	If(Constrain(hdr.mpls_0.isValid), block27576)
)

val block27580 = InstructionBlock(
	If(Constrain(hdr.ipv6.isValid), block27550, block27578)
)

val block27582 = InstructionBlock(
	If(Constrain(hdr.ipv4.isValid), block27527, block27580)
)

val block27600 = InstructionBlock(
	process_outer_multicast_0
)

val block27605 = InstructionBlock(
	Fork(InstructionBlock(), block27582,block27600)
)

val block27667 = InstructionBlock(
	tunnel_lookup_miss_0
)

val block27672 = InstructionBlock(
	Fork(InstructionBlock(), block27667)
)

val block27681 = InstructionBlock(
	adjust_lkp_fields
)

val block27683 = InstructionBlock(
	process_ingress_fabric_0,
	If(Constrain('meta.tunnel_metadata.ingress_tunnel_type', :~:(:==:(ConstantValue(0)))), block27605),
	Allocate('LOr27647'),
	Allocate('LAnd27646'),
	Allocate('LOr27645'),
	Allocate('LAnd27631'),
	If(Constrain('meta.multicast_metadata.outer_mcast_mode', :==:(ConstantValue(1))),
		If(Constrain('meta.multicast_metadata.mcast_rpf_group', :==:(ConstantValue(0))),
			Assign('LAnd27631', ConstantValue(1)),
		Assign('LAnd27631', ConstantValue(0))),
	Assign('LAnd27631', ConstantValue(0))),
	Allocate('LAnd27644'),
	If(Constrain('meta.multicast_metadata.outer_mcast_mode', :==:(ConstantValue(2))),
		If(Constrain('meta.multicast_metadata.mcast_rpf_group', :~:(:==:(ConstantValue(0)))),
			Assign('LAnd27644', ConstantValue(1)),
		Assign('LAnd27644', ConstantValue(0))),
	Assign('LAnd27644', ConstantValue(0))),
	If(Constrain('LAnd27631'),
		If(Constrain('LAnd27644'),
			Assign('LOr27645', ConstantValue(1)),
		Assign('LOr27645', ConstantValue(0))),
	Assign('LOr27645', ConstantValue(1))),
	Deallocate('LAnd27631'),
	Deallocate('LAnd27644'),
	If(Constrain('meta.multicast_metadata.outer_mcast_route_hit', :==:(ConstantValue(1))),
		If(Constrain('LOr27645'),
			Assign('LAnd27646', ConstantValue(1)),
		Assign('LAnd27646', ConstantValue(0))),
	Assign('LAnd27646', ConstantValue(0))),
	Deallocate('LOr27645'),
	If(Constrain('meta.tunnel_metadata.tunnel_terminate', :==:(ConstantValue(1))),
		If(Constrain('LAnd27646'),
			Assign('LOr27647', ConstantValue(1)),
		Assign('LOr27647', ConstantValue(0))),
	Assign('LOr27647', ConstantValue(1))),
	Deallocate('LAnd27646'),
	If(Constrain('LOr27647'), :==:(ConstantValue(1)), block27672, block27681),
	Deallocate('LOr27647')
)

val block27732 = InstructionBlock(

)

val block27772 = InstructionBlock(
	storm_control_meter.execute_meter,
	Assign('meta.meter_metadata.meter_index', :@('meter_idx'))
)

val block27843 = InstructionBlock(
	storm_control
)

val block27845 = InstructionBlock(
	If(Constrain('meta.ingress_metadata.port_type', :==:(ConstantValue(0))), block27843)
)

val block27875 = InstructionBlock(

)

val block27895 = InstructionBlock(
	Assign('meta.l2_metadata.lkp_pkt_type', ConstantValue(1))
)

val block27921 = InstructionBlock(
	Assign('meta.l2_metadata.lkp_pkt_type', ConstantValue(1)),
	Assign('meta.ipv6_metadata.ipv6_src_is_link_local', ConstantValue(1))
)

val block27952 = InstructionBlock(
	Assign('meta.l2_metadata.lkp_pkt_type', ConstantValue(2)),
	Assign('meta.l2_metadata.bd_stats_idx', :+:(:@('meta.l2_metadata.bd_stats_idx'), ConstantValue(1)))
)

val block27989 = InstructionBlock(
	Assign('meta.l2_metadata.lkp_pkt_type', ConstantValue(2)),
	Assign('meta.ipv6_metadata.ipv6_src_is_link_local', ConstantValue(1)),
	Assign('meta.l2_metadata.bd_stats_idx', :+:(:@('meta.l2_metadata.bd_stats_idx'), ConstantValue(1)))
)

val block28020 = InstructionBlock(
	Assign('meta.l2_metadata.lkp_pkt_type', ConstantValue(4)),
	Assign('meta.l2_metadata.bd_stats_idx', :+:(:@('meta.l2_metadata.bd_stats_idx'), ConstantValue(2)))
)

val block28050 = InstructionBlock(
	Assign('meta.ingress_metadata.drop_flag', ConstantValue(1)),
	Assign('meta.ingress_metadata.drop_reason', :@('drop_reason'))
)

val block28191 = InstructionBlock(
	validate_packet
)

val block28193 = InstructionBlock(
	Allocate('LAnd28182'),
	If(Constrain('<BOr>28173', :==:(ConstantValue(0))),
		If(Constrain('meta.ingress_metadata.drop_flag', :==:(ConstantValue(0))),
			Assign('LAnd28182', ConstantValue(1)),
		Assign('LAnd28182', ConstantValue(0))),
	Assign('LAnd28182', ConstantValue(0))),
	If(Constrain('LAnd28182'), :==:(ConstantValue(1)), block28191),
	Deallocate('LAnd28182')
)

val block28223 = InstructionBlock(

)

val block28247 = InstructionBlock(
	Assign('meta.acl_metadata.ingress_dst_port_range_id', :@('range_id'))
)

val block28271 = InstructionBlock(
	Assign('meta.acl_metadata.ingress_src_port_range_id', :@('range_id'))
)

val block28383 = InstructionBlock(
	ingress_l4_src_port,
	ingress_l4_dst_port
)

val block28413 = InstructionBlock(

)

val block28449 = InstructionBlock(
	Assign('meta.ingress_metadata.egress_ifindex', :@('ifindex')),
	Assign('meta.l2_metadata.same_if_check', <BXor>28447)
)

val block28479 = InstructionBlock(
	Assign('meta.intrinsic_metadata.mcast_grp', :@('mc_index')),
	Assign('meta.fabric_metadata.dst_device', ConstantValue(127))
)

val block28505 = InstructionBlock(
	Assign('meta.ingress_metadata.egress_ifindex', ConstantValue(65535)),
	Assign('meta.fabric_metadata.dst_device', ConstantValue(127))
)

val block28541 = InstructionBlock(
	Assign('meta.l2_metadata.l2_redirect', ConstantValue(1)),
	Assign('meta.l2_metadata.l2_nexthop', :@('nexthop_index')),
	Assign('meta.l2_metadata.l2_nexthop_type', ConstantValue(0))
)

val block28577 = InstructionBlock(
	Assign('meta.l2_metadata.l2_redirect', ConstantValue(1)),
	Assign('meta.l2_metadata.l2_nexthop', :@('ecmp_index')),
	Assign('meta.l2_metadata.l2_nexthop_type', ConstantValue(1))
)

val block28597 = InstructionBlock(
	mark_to_drop
)

val block28617 = InstructionBlock(
	Assign('meta.l2_metadata.l2_src_miss', ConstantValue(1))
)

val block28646 = InstructionBlock(
	Assign('meta.l2_metadata.l2_src_move', <BXor>28644)
)

val block28802 = InstructionBlock(
	smac
)

val block28820 = InstructionBlock(
	dmac
)

val block28822 = InstructionBlock(
	Allocate('LAnd28793'),
	If(Constrain('<BOr>28784', :==:(ConstantValue(0))),
		If(Constrain('meta.ingress_metadata.port_type', :==:(ConstantValue(0))),
			Assign('LAnd28793', ConstantValue(1)),
		Assign('LAnd28793', ConstantValue(0))),
	Assign('LAnd28793', ConstantValue(0))),
	If(Constrain('LAnd28793'), :==:(ConstantValue(1)), block28802),
	Deallocate('LAnd28793'),
	If(Constrain('<BOr>28809', :==:(ConstantValue(0))), block28820)
)

val block28852 = InstructionBlock(

)

val block28942 = InstructionBlock(
	Assign('meta.acl_metadata.acl_deny', ConstantValue(1)),
	Assign('meta.acl_metadata.acl_stats_index', :@('acl_stats_index')),
	Assign('meta.meter_metadata.meter_index', :@('acl_meter_index')),
	Assign('meta.fabric_metadata.reason_code', :@('acl_copy_reason')),
	Assign('meta.nat_metadata.ingress_nat_mode', :@('nat_mode')),
	Assign('meta.intrinsic_metadata.ingress_cos', :@('ingress_cos')),
	Assign('meta.qos_metadata.lkp_tc', :@('tc')),
	Assign('meta.meter_metadata.packet_color', :@('color'))
)

val block29026 = InstructionBlock(
	Assign('meta.acl_metadata.acl_stats_index', :@('acl_stats_index')),
	Assign('meta.meter_metadata.meter_index', :@('acl_meter_index')),
	Assign('meta.fabric_metadata.reason_code', :@('acl_copy_reason')),
	Assign('meta.nat_metadata.ingress_nat_mode', :@('nat_mode')),
	Assign('meta.intrinsic_metadata.ingress_cos', :@('ingress_cos')),
	Assign('meta.qos_metadata.lkp_tc', :@('tc')),
	Assign('meta.meter_metadata.packet_color', :@('color'))
)

val block29132 = InstructionBlock(
	Assign('meta.acl_metadata.acl_redirect', ConstantValue(1)),
	Assign('meta.acl_metadata.acl_nexthop', :@('nexthop_index')),
	Assign('meta.acl_metadata.acl_nexthop_type', ConstantValue(0)),
	Assign('meta.acl_metadata.acl_stats_index', :@('acl_stats_index')),
	Assign('meta.meter_metadata.meter_index', :@('acl_meter_index')),
	Assign('meta.fabric_metadata.reason_code', :@('acl_copy_reason')),
	Assign('meta.nat_metadata.ingress_nat_mode', :@('nat_mode')),
	Assign('meta.intrinsic_metadata.ingress_cos', :@('ingress_cos')),
	Assign('meta.qos_metadata.lkp_tc', :@('tc')),
	Assign('meta.meter_metadata.packet_color', :@('color'))
)

val block29238 = InstructionBlock(
	Assign('meta.acl_metadata.acl_redirect', ConstantValue(1)),
	Assign('meta.acl_metadata.acl_nexthop', :@('ecmp_index')),
	Assign('meta.acl_metadata.acl_nexthop_type', ConstantValue(1)),
	Assign('meta.acl_metadata.acl_stats_index', :@('acl_stats_index')),
	Assign('meta.meter_metadata.meter_index', :@('acl_meter_index')),
	Assign('meta.fabric_metadata.reason_code', :@('acl_copy_reason')),
	Assign('meta.nat_metadata.ingress_nat_mode', :@('nat_mode')),
	Assign('meta.intrinsic_metadata.ingress_cos', :@('ingress_cos')),
	Assign('meta.qos_metadata.lkp_tc', :@('tc')),
	Assign('meta.meter_metadata.packet_color', :@('color'))
)

val block29347 = InstructionBlock(
	Assign('meta.i2e_metadata.mirror_session_id', :@('session_id')),
	clone3,
	Assign('meta.acl_metadata.acl_stats_index', :@('acl_stats_index')),
	Assign('meta.meter_metadata.meter_index', :@('acl_meter_index')),
	Assign('meta.nat_metadata.ingress_nat_mode', :@('nat_mode')),
	Assign('meta.intrinsic_metadata.ingress_cos', :@('ingress_cos')),
	Assign('meta.qos_metadata.lkp_tc', :@('tc')),
	Assign('meta.meter_metadata.packet_color', :@('color'))
)

val block29454 = InstructionBlock(
	mac_acl
)

val block29456 = InstructionBlock(
	If(Constrain('<BOr>29443', :==:(ConstantValue(0))), block29454)
)

val block29486 = InstructionBlock(

)

val block29576 = InstructionBlock(
	Assign('meta.acl_metadata.acl_deny', ConstantValue(1)),
	Assign('meta.acl_metadata.acl_stats_index', :@('acl_stats_index')),
	Assign('meta.meter_metadata.meter_index', :@('acl_meter_index')),
	Assign('meta.fabric_metadata.reason_code', :@('acl_copy_reason')),
	Assign('meta.nat_metadata.ingress_nat_mode', :@('nat_mode')),
	Assign('meta.intrinsic_metadata.ingress_cos', :@('ingress_cos')),
	Assign('meta.qos_metadata.lkp_tc', :@('tc')),
	Assign('meta.meter_metadata.packet_color', :@('color'))
)

val block29660 = InstructionBlock(
	Assign('meta.acl_metadata.acl_stats_index', :@('acl_stats_index')),
	Assign('meta.meter_metadata.meter_index', :@('acl_meter_index')),
	Assign('meta.fabric_metadata.reason_code', :@('acl_copy_reason')),
	Assign('meta.nat_metadata.ingress_nat_mode', :@('nat_mode')),
	Assign('meta.intrinsic_metadata.ingress_cos', :@('ingress_cos')),
	Assign('meta.qos_metadata.lkp_tc', :@('tc')),
	Assign('meta.meter_metadata.packet_color', :@('color'))
)

val block29766 = InstructionBlock(
	Assign('meta.acl_metadata.acl_redirect', ConstantValue(1)),
	Assign('meta.acl_metadata.acl_nexthop', :@('nexthop_index')),
	Assign('meta.acl_metadata.acl_nexthop_type', ConstantValue(0)),
	Assign('meta.acl_metadata.acl_stats_index', :@('acl_stats_index')),
	Assign('meta.meter_metadata.meter_index', :@('acl_meter_index')),
	Assign('meta.fabric_metadata.reason_code', :@('acl_copy_reason')),
	Assign('meta.nat_metadata.ingress_nat_mode', :@('nat_mode')),
	Assign('meta.intrinsic_metadata.ingress_cos', :@('ingress_cos')),
	Assign('meta.qos_metadata.lkp_tc', :@('tc')),
	Assign('meta.meter_metadata.packet_color', :@('color'))
)

val block29872 = InstructionBlock(
	Assign('meta.acl_metadata.acl_redirect', ConstantValue(1)),
	Assign('meta.acl_metadata.acl_nexthop', :@('ecmp_index')),
	Assign('meta.acl_metadata.acl_nexthop_type', ConstantValue(1)),
	Assign('meta.acl_metadata.acl_stats_index', :@('acl_stats_index')),
	Assign('meta.meter_metadata.meter_index', :@('acl_meter_index')),
	Assign('meta.fabric_metadata.reason_code', :@('acl_copy_reason')),
	Assign('meta.nat_metadata.ingress_nat_mode', :@('nat_mode')),
	Assign('meta.intrinsic_metadata.ingress_cos', :@('ingress_cos')),
	Assign('meta.qos_metadata.lkp_tc', :@('tc')),
	Assign('meta.meter_metadata.packet_color', :@('color'))
)

val block29981 = InstructionBlock(
	Assign('meta.i2e_metadata.mirror_session_id', :@('session_id')),
	clone3,
	Assign('meta.acl_metadata.acl_stats_index', :@('acl_stats_index')),
	Assign('meta.meter_metadata.meter_index', :@('acl_meter_index')),
	Assign('meta.nat_metadata.ingress_nat_mode', :@('nat_mode')),
	Assign('meta.intrinsic_metadata.ingress_cos', :@('ingress_cos')),
	Assign('meta.qos_metadata.lkp_tc', :@('tc')),
	Assign('meta.meter_metadata.packet_color', :@('color'))
)

val block30238 = InstructionBlock(
	ip_acl
)

val block30254 = InstructionBlock(
	ipv6_acl
)

val block30256 = InstructionBlock(
	If(Constrain('meta.l3_metadata.lkp_ip_type', :==:(ConstantValue(2))), block30254)
)

val block30258 = InstructionBlock(
	If(Constrain('meta.l3_metadata.lkp_ip_type', :==:(ConstantValue(1))), block30238, block30256)
)

val block30260 = InstructionBlock(
	If(Constrain('<BOr>30220', :==:(ConstantValue(0))), block30258)
)

val block30290 = InstructionBlock(

)

val block30360 = InstructionBlock(
	Assign('meta.acl_metadata.racl_deny', ConstantValue(1)),
	Assign('meta.acl_metadata.acl_stats_index', :@('acl_stats_index')),
	Assign('meta.fabric_metadata.reason_code', :@('acl_copy_reason')),
	Assign('meta.intrinsic_metadata.ingress_cos', :@('ingress_cos')),
	Assign('meta.qos_metadata.lkp_tc', :@('tc')),
	Assign('meta.meter_metadata.packet_color', :@('color'))
)

val block30424 = InstructionBlock(
	Assign('meta.acl_metadata.acl_stats_index', :@('acl_stats_index')),
	Assign('meta.fabric_metadata.reason_code', :@('acl_copy_reason')),
	Assign('meta.intrinsic_metadata.ingress_cos', :@('ingress_cos')),
	Assign('meta.qos_metadata.lkp_tc', :@('tc')),
	Assign('meta.meter_metadata.packet_color', :@('color'))
)

val block30510 = InstructionBlock(
	Assign('meta.acl_metadata.racl_redirect', ConstantValue(1)),
	Assign('meta.acl_metadata.racl_nexthop', :@('nexthop_index')),
	Assign('meta.acl_metadata.racl_nexthop_type', ConstantValue(0)),
	Assign('meta.acl_metadata.acl_stats_index', :@('acl_stats_index')),
	Assign('meta.fabric_metadata.reason_code', :@('acl_copy_reason')),
	Assign('meta.intrinsic_metadata.ingress_cos', :@('ingress_cos')),
	Assign('meta.qos_metadata.lkp_tc', :@('tc')),
	Assign('meta.meter_metadata.packet_color', :@('color'))
)

val block30596 = InstructionBlock(
	Assign('meta.acl_metadata.racl_redirect', ConstantValue(1)),
	Assign('meta.acl_metadata.racl_nexthop', :@('ecmp_index')),
	Assign('meta.acl_metadata.racl_nexthop_type', ConstantValue(1)),
	Assign('meta.acl_metadata.acl_stats_index', :@('acl_stats_index')),
	Assign('meta.fabric_metadata.reason_code', :@('acl_copy_reason')),
	Assign('meta.intrinsic_metadata.ingress_cos', :@('ingress_cos')),
	Assign('meta.qos_metadata.lkp_tc', :@('tc')),
	Assign('meta.meter_metadata.packet_color', :@('color'))
)

val block30698 = InstructionBlock(
	ipv4_racl
)

val block30728 = InstructionBlock(

)

val block30767 = InstructionBlock(
	Assign('meta.l3_metadata.urpf_hit', ConstantValue(1)),
	Assign('meta.l3_metadata.urpf_bd_group', :@('urpf_bd_group')),
	Assign('meta.l3_metadata.urpf_mode', :@('meta.ipv4_metadata.ipv4_urpf_mode'))
)

val block30787 = InstructionBlock(
	Assign('meta.l3_metadata.urpf_check_fail', ConstantValue(1))
)

val block30924 = InstructionBlock(
	ipv4_urpf_lpm
)

val block30929 = InstructionBlock(
	Fork(InstructionBlock(), block30924)
)

val block30931 = InstructionBlock(
	If(Constrain('meta.ipv4_metadata.ipv4_urpf_mode', :~:(:==:(ConstantValue(0)))), block30929)
)

val block30961 = InstructionBlock(

)

val block30997 = InstructionBlock(
	Assign('meta.l3_metadata.fib_hit', ConstantValue(1)),
	Assign('meta.l3_metadata.fib_nexthop', :@('nexthop_index')),
	Assign('meta.l3_metadata.fib_nexthop_type', ConstantValue(0))
)

val block31033 = InstructionBlock(
	Assign('meta.l3_metadata.fib_hit', ConstantValue(1)),
	Assign('meta.l3_metadata.fib_nexthop', :@('ecmp_index')),
	Assign('meta.l3_metadata.fib_nexthop_type', ConstantValue(1))
)

val block31169 = InstructionBlock(
	ipv4_fib_lpm
)

val block31174 = InstructionBlock(
	Fork(InstructionBlock(), block31169)
)

val block31204 = InstructionBlock(

)

val block31274 = InstructionBlock(
	Assign('meta.acl_metadata.racl_deny', ConstantValue(1)),
	Assign('meta.acl_metadata.acl_stats_index', :@('acl_stats_index')),
	Assign('meta.fabric_metadata.reason_code', :@('acl_copy_reason')),
	Assign('meta.intrinsic_metadata.ingress_cos', :@('ingress_cos')),
	Assign('meta.qos_metadata.lkp_tc', :@('tc')),
	Assign('meta.meter_metadata.packet_color', :@('color'))
)

val block31338 = InstructionBlock(
	Assign('meta.acl_metadata.acl_stats_index', :@('acl_stats_index')),
	Assign('meta.fabric_metadata.reason_code', :@('acl_copy_reason')),
	Assign('meta.intrinsic_metadata.ingress_cos', :@('ingress_cos')),
	Assign('meta.qos_metadata.lkp_tc', :@('tc')),
	Assign('meta.meter_metadata.packet_color', :@('color'))
)

val block31424 = InstructionBlock(
	Assign('meta.acl_metadata.racl_redirect', ConstantValue(1)),
	Assign('meta.acl_metadata.racl_nexthop', :@('nexthop_index')),
	Assign('meta.acl_metadata.racl_nexthop_type', ConstantValue(0)),
	Assign('meta.acl_metadata.acl_stats_index', :@('acl_stats_index')),
	Assign('meta.fabric_metadata.reason_code', :@('acl_copy_reason')),
	Assign('meta.intrinsic_metadata.ingress_cos', :@('ingress_cos')),
	Assign('meta.qos_metadata.lkp_tc', :@('tc')),
	Assign('meta.meter_metadata.packet_color', :@('color'))
)

val block31510 = InstructionBlock(
	Assign('meta.acl_metadata.racl_redirect', ConstantValue(1)),
	Assign('meta.acl_metadata.racl_nexthop', :@('ecmp_index')),
	Assign('meta.acl_metadata.racl_nexthop_type', ConstantValue(1)),
	Assign('meta.acl_metadata.acl_stats_index', :@('acl_stats_index')),
	Assign('meta.fabric_metadata.reason_code', :@('acl_copy_reason')),
	Assign('meta.intrinsic_metadata.ingress_cos', :@('ingress_cos')),
	Assign('meta.qos_metadata.lkp_tc', :@('tc')),
	Assign('meta.meter_metadata.packet_color', :@('color'))
)

val block31612 = InstructionBlock(
	ipv6_racl
)

val block31642 = InstructionBlock(

)

val block31681 = InstructionBlock(
	Assign('meta.l3_metadata.urpf_hit', ConstantValue(1)),
	Assign('meta.l3_metadata.urpf_bd_group', :@('urpf_bd_group')),
	Assign('meta.l3_metadata.urpf_mode', :@('meta.ipv6_metadata.ipv6_urpf_mode'))
)

val block31701 = InstructionBlock(
	Assign('meta.l3_metadata.urpf_check_fail', ConstantValue(1))
)

val block31838 = InstructionBlock(
	ipv6_urpf_lpm
)

val block31843 = InstructionBlock(
	Fork(InstructionBlock(), block31838)
)

val block31845 = InstructionBlock(
	If(Constrain('meta.ipv6_metadata.ipv6_urpf_mode', :~:(:==:(ConstantValue(0)))), block31843)
)

val block31875 = InstructionBlock(

)

val block31911 = InstructionBlock(
	Assign('meta.l3_metadata.fib_hit', ConstantValue(1)),
	Assign('meta.l3_metadata.fib_nexthop', :@('nexthop_index')),
	Assign('meta.l3_metadata.fib_nexthop_type', ConstantValue(0))
)

val block31947 = InstructionBlock(
	Assign('meta.l3_metadata.fib_hit', ConstantValue(1)),
	Assign('meta.l3_metadata.fib_nexthop', :@('ecmp_index')),
	Assign('meta.l3_metadata.fib_nexthop_type', ConstantValue(1))
)

val block32083 = InstructionBlock(
	ipv6_fib_lpm
)

val block32088 = InstructionBlock(
	Fork(InstructionBlock(), block32083)
)

val block32118 = InstructionBlock(

)

val block32138 = InstructionBlock(
	Assign('meta.l3_metadata.urpf_check_fail', ConstantValue(1))
)

val block32217 = InstructionBlock(
	urpf_bd
)

val block32219 = InstructionBlock(
	Allocate('LAnd32208'),
	If(Constrain('meta.l3_metadata.urpf_mode', :==:(ConstantValue(2))),
		If(Constrain('meta.l3_metadata.urpf_hit', :==:(ConstantValue(1))),
			Assign('LAnd32208', ConstantValue(1)),
		Assign('LAnd32208', ConstantValue(0))),
	Assign('LAnd32208', ConstantValue(0))),
	If(Constrain('LAnd32208'), :==:(ConstantValue(1)), block32217),
	Deallocate('LAnd32208')
)

val block32249 = InstructionBlock(

)

val block32279 = InstructionBlock(
	Assign('meta.multicast_metadata.multicast_bridge_mc_index', :@('mc_index')),
	Assign('meta.multicast_metadata.mcast_bridge_hit', ConstantValue(1))
)

val block32293 = InstructionBlock(

)

val block32323 = InstructionBlock(
	Assign('meta.multicast_metadata.multicast_bridge_mc_index', :@('mc_index')),
	Assign('meta.multicast_metadata.mcast_bridge_hit', ConstantValue(1))
)

val block32374 = InstructionBlock(
	Assign('meta.multicast_metadata.multicast_route_mc_index', :@('mc_index')),
	Assign('meta.multicast_metadata.mcast_mode', ConstantValue(1)),
	Assign('meta.multicast_metadata.mcast_route_hit', ConstantValue(1)),
	Assign('meta.multicast_metadata.mcast_rpf_group', <BXor>32372)
)

val block32394 = InstructionBlock(
	Assign('meta.l3_metadata.l3_copy', ConstantValue(1))
)

val block32445 = InstructionBlock(
	Assign('meta.multicast_metadata.mcast_mode', ConstantValue(1)),
	Assign('meta.multicast_metadata.multicast_route_mc_index', :@('mc_index')),
	Assign('meta.multicast_metadata.mcast_route_hit', ConstantValue(1)),
	Assign('meta.multicast_metadata.mcast_rpf_group', <BXor>32443)
)

val block32496 = InstructionBlock(
	Assign('meta.multicast_metadata.mcast_mode', ConstantValue(2)),
	Assign('meta.multicast_metadata.multicast_route_mc_index', :@('mc_index')),
	Assign('meta.multicast_metadata.mcast_route_hit', ConstantValue(1)),
	Assign('meta.multicast_metadata.mcast_rpf_group', <BOr>32494)
)

val block32798 = InstructionBlock(
	ipv4_multicast_bridge_star_g
)

val block32803 = InstructionBlock(
	Fork(InstructionBlock(), block32798)
)

val block32839 = InstructionBlock(
	ipv4_multicast_route_star_g
)

val block32844 = InstructionBlock(
	Fork(InstructionBlock(), block32839)
)

val block32846 = InstructionBlock(
	If(Constrain('<BOr>32776', :==:(ConstantValue(0))), block32803),
	Allocate('LAnd32819'),
	If(Constrain('<BOr>32810', :==:(ConstantValue(0))),
		If(Constrain('meta.multicast_metadata.ipv4_multicast_enabled', :==:(ConstantValue(1))),
			Assign('LAnd32819', ConstantValue(1)),
		Assign('LAnd32819', ConstantValue(0))),
	Assign('LAnd32819', ConstantValue(0))),
	If(Constrain('LAnd32819'), :==:(ConstantValue(1)), block32844),
	Deallocate('LAnd32819')
)

val block32876 = InstructionBlock(

)

val block32906 = InstructionBlock(
	Assign('meta.multicast_metadata.multicast_bridge_mc_index', :@('mc_index')),
	Assign('meta.multicast_metadata.mcast_bridge_hit', ConstantValue(1))
)

val block32920 = InstructionBlock(

)

val block32950 = InstructionBlock(
	Assign('meta.multicast_metadata.multicast_bridge_mc_index', :@('mc_index')),
	Assign('meta.multicast_metadata.mcast_bridge_hit', ConstantValue(1))
)

val block33001 = InstructionBlock(
	Assign('meta.multicast_metadata.multicast_route_mc_index', :@('mc_index')),
	Assign('meta.multicast_metadata.mcast_mode', ConstantValue(1)),
	Assign('meta.multicast_metadata.mcast_route_hit', ConstantValue(1)),
	Assign('meta.multicast_metadata.mcast_rpf_group', <BXor>32999)
)

val block33021 = InstructionBlock(
	Assign('meta.l3_metadata.l3_copy', ConstantValue(1))
)

val block33072 = InstructionBlock(
	Assign('meta.multicast_metadata.mcast_mode', ConstantValue(1)),
	Assign('meta.multicast_metadata.multicast_route_mc_index', :@('mc_index')),
	Assign('meta.multicast_metadata.mcast_route_hit', ConstantValue(1)),
	Assign('meta.multicast_metadata.mcast_rpf_group', <BXor>33070)
)

val block33123 = InstructionBlock(
	Assign('meta.multicast_metadata.mcast_mode', ConstantValue(2)),
	Assign('meta.multicast_metadata.multicast_route_mc_index', :@('mc_index')),
	Assign('meta.multicast_metadata.mcast_route_hit', ConstantValue(1)),
	Assign('meta.multicast_metadata.mcast_rpf_group', <BOr>33121)
)

val block33425 = InstructionBlock(
	ipv6_multicast_bridge_star_g
)

val block33430 = InstructionBlock(
	Fork(InstructionBlock(), block33425)
)

val block33466 = InstructionBlock(
	ipv6_multicast_route_star_g
)

val block33471 = InstructionBlock(
	Fork(InstructionBlock(), block33466)
)

val block33473 = InstructionBlock(
	If(Constrain('<BOr>33403', :==:(ConstantValue(0))), block33430),
	Allocate('LAnd33446'),
	If(Constrain('<BOr>33437', :==:(ConstantValue(0))),
		If(Constrain('meta.multicast_metadata.ipv6_multicast_enabled', :==:(ConstantValue(1))),
			Assign('LAnd33446', ConstantValue(1)),
		Assign('LAnd33446', ConstantValue(0))),
	Assign('LAnd33446', ConstantValue(0))),
	If(Constrain('LAnd33446'), :==:(ConstantValue(1)), block33471),
	Deallocate('LAnd33446')
)

val block33493 = InstructionBlock(

)

val block33575 = InstructionBlock(
	process_ipv4_multicast_0
)

val block33597 = InstructionBlock(
	process_ipv6_multicast_0
)

val block33599 = InstructionBlock(
	If(Constrain('meta.l3_metadata.lkp_ip_type', :==:(ConstantValue(2))), block33597)
)

val block33614 = InstructionBlock(
	If(Constrain('meta.l3_metadata.lkp_ip_type', :==:(ConstantValue(1))), block33575, block33599),
	process_multicast_rpf_0
)

val block33644 = InstructionBlock(

)

val block33694 = InstructionBlock(
	Assign('meta.nat_metadata.nat_nexthop', :@('nexthop_index')),
	Assign('meta.nat_metadata.nat_nexthop_type', :@('nexthop_type')),
	Assign('meta.nat_metadata.nat_rewrite_index', :@('nat_rewrite_index')),
	Assign('meta.nat_metadata.nat_hit', ConstantValue(1))
)

val block33708 = InstructionBlock(

)

val block33732 = InstructionBlock(
	Assign('meta.nat_metadata.nat_rewrite_index', :@('nat_rewrite_index'))
)

val block33782 = InstructionBlock(
	Assign('meta.nat_metadata.nat_nexthop', :@('nexthop_index')),
	Assign('meta.nat_metadata.nat_nexthop_type', :@('nexthop_type')),
	Assign('meta.nat_metadata.nat_rewrite_index', :@('nat_rewrite_index')),
	Assign('meta.nat_metadata.nat_hit', ConstantValue(1))
)

val block34132 = InstructionBlock(
	nat_flow
)

val block34137 = InstructionBlock(
	Fork(InstructionBlock(), block34132)
)

val block34142 = InstructionBlock(
	Fork(InstructionBlock(), block34137)
)

val block34147 = InstructionBlock(
	Fork(InstructionBlock(), block34142)
)

val block34199 = InstructionBlock(

)

val block34224 = InstructionBlock(
	meter_index.read
)

val block34292 = InstructionBlock(
	meter_index_0
)

val block34294 = InstructionBlock(
	If(Constrain('<BOr>34281', :==:(ConstantValue(0))), block34292)
)

val block34424 = InstructionBlock(
	hash,
	hash
)

val block34538 = InstructionBlock(
	hash,
	hash
)

val block34594 = InstructionBlock(
	hash
)

val block34626 = InstructionBlock(
	Assign('meta.intrinsic_metadata.mcast_hash', :@('meta.hash_metadata.hash1')),
	Assign('meta.hash_metadata.entropy_hash', :@('meta.hash_metadata.hash2'))
)

val block34667 = InstructionBlock(
	Assign('meta.hash_metadata.hash1', :@('meta.hash_metadata.hash2')),
	Assign('meta.intrinsic_metadata.mcast_hash', :@('meta.hash_metadata.hash2')),
	Assign('meta.hash_metadata.entropy_hash', :@('meta.hash_metadata.hash2'))
)

val block34871 = InstructionBlock(
	compute_ipv4_hashes
)

val block34910 = InstructionBlock(
	compute_ipv6_hashes
)

val block34919 = InstructionBlock(
	compute_non_ip_hashes
)

val block34921 = InstructionBlock(
	Allocate('LOr34901'),
	Allocate('LAnd34886'),
	If(Constrain('meta.tunnel_metadata.tunnel_terminate', :==:(ConstantValue(0))),
		If(Constrain(hdr.ipv6.isValid),
			Assign('LAnd34886', ConstantValue(1)),
		Assign('LAnd34886', ConstantValue(0))),
	Assign('LAnd34886', ConstantValue(0))),
	Allocate('LAnd34900'),
	If(Constrain('meta.tunnel_metadata.tunnel_terminate', :==:(ConstantValue(1))),
		If(Constrain(hdr.inner_ipv6.isValid),
			Assign('LAnd34900', ConstantValue(1)),
		Assign('LAnd34900', ConstantValue(0))),
	Assign('LAnd34900', ConstantValue(0))),
	If(Constrain('LAnd34886'),
		If(Constrain('LAnd34900'),
			Assign('LOr34901', ConstantValue(1)),
		Assign('LOr34901', ConstantValue(0))),
	Assign('LOr34901', ConstantValue(1))),
	Deallocate('LAnd34886'),
	Deallocate('LAnd34900'),
	If(Constrain('LOr34901'), :==:(ConstantValue(1)), block34910, block34919),
	Deallocate('LOr34901')
)

val block34930 = InstructionBlock(
	Allocate('LOr34862'),
	Allocate('LAnd34847'),
	If(Constrain('meta.tunnel_metadata.tunnel_terminate', :==:(ConstantValue(0))),
		If(Constrain(hdr.ipv4.isValid),
			Assign('LAnd34847', ConstantValue(1)),
		Assign('LAnd34847', ConstantValue(0))),
	Assign('LAnd34847', ConstantValue(0))),
	Allocate('LAnd34861'),
	If(Constrain('meta.tunnel_metadata.tunnel_terminate', :==:(ConstantValue(1))),
		If(Constrain(hdr.inner_ipv4.isValid),
			Assign('LAnd34861', ConstantValue(1)),
		Assign('LAnd34861', ConstantValue(0))),
	Assign('LAnd34861', ConstantValue(0))),
	If(Constrain('LAnd34847'),
		If(Constrain('LAnd34861'),
			Assign('LOr34862', ConstantValue(1)),
		Assign('LOr34862', ConstantValue(0))),
	Assign('LOr34862', ConstantValue(1))),
	Deallocate('LAnd34847'),
	Deallocate('LAnd34861'),
	If(Constrain('LOr34862'), :==:(ConstantValue(1)), block34871, block34921),
	Deallocate('LOr34862'),
	compute_other_hashes
)

val block34960 = InstructionBlock(

)

val block34980 = InstructionBlock(
	mark_to_drop
)

val block35073 = InstructionBlock(
	meter_action
)

val block35075 = InstructionBlock(
	If(Constrain('<BOr>35062', :==:(ConstantValue(0))), block35073)
)

val block35138 = InstructionBlock(
	ingress_bd_stats.count
)

val block35183 = InstructionBlock(
	ingress_bd_stats_0
)

val block35246 = InstructionBlock(
	acl_stats.count
)

val block35291 = InstructionBlock(
	acl_stats_0
)

val block35321 = InstructionBlock(

)

val block35401 = InstructionBlock(
	storm_control_stats_0
)

val block35431 = InstructionBlock(

)

val block35481 = InstructionBlock(
	Assign('meta.l3_metadata.nexthop_index', :@('meta.l2_metadata.l2_nexthop')),
	Assign('meta.nexthop_metadata.nexthop_type', :@('meta.l2_metadata.l2_nexthop_type')),
	Assign('meta.ingress_metadata.egress_ifindex', ConstantValue(0)),
	Assign('meta.intrinsic_metadata.mcast_grp', ConstantValue(0)),
	Assign('meta.fabric_metadata.dst_device', ConstantValue(0))
)

val block35537 = InstructionBlock(
	Assign('meta.l3_metadata.nexthop_index', :@('meta.l3_metadata.fib_nexthop')),
	Assign('meta.nexthop_metadata.nexthop_type', :@('meta.l3_metadata.fib_nexthop_type')),
	Assign('meta.l3_metadata.routed', ConstantValue(1)),
	Assign('meta.intrinsic_metadata.mcast_grp', ConstantValue(0)),
	Assign('meta.fabric_metadata.reason_code', ConstantValue(535)),
	Assign('meta.fabric_metadata.dst_device', ConstantValue(0))
)

val block35580 = InstructionBlock(
	Assign('meta.l3_metadata.routed', ConstantValue(0)),
	Assign('meta.intrinsic_metadata.mcast_grp', ConstantValue(0)),
	Assign('standard_metadata.egress_spec', ConstantValue(64)),
	Assign('meta.ingress_metadata.egress_ifindex', ConstantValue(0)),
	Assign('meta.fabric_metadata.dst_device', ConstantValue(0))
)

val block35630 = InstructionBlock(
	Assign('meta.l3_metadata.nexthop_index', :@('meta.acl_metadata.acl_nexthop')),
	Assign('meta.nexthop_metadata.nexthop_type', :@('meta.acl_metadata.acl_nexthop_type')),
	Assign('meta.ingress_metadata.egress_ifindex', ConstantValue(0)),
	Assign('meta.intrinsic_metadata.mcast_grp', ConstantValue(0)),
	Assign('meta.fabric_metadata.dst_device', ConstantValue(0))
)

val block35686 = InstructionBlock(
	Assign('meta.l3_metadata.nexthop_index', :@('meta.acl_metadata.racl_nexthop')),
	Assign('meta.nexthop_metadata.nexthop_type', :@('meta.acl_metadata.racl_nexthop_type')),
	Assign('meta.l3_metadata.routed', ConstantValue(1)),
	Assign('meta.ingress_metadata.egress_ifindex', ConstantValue(0)),
	Assign('meta.intrinsic_metadata.mcast_grp', ConstantValue(0)),
	Assign('meta.fabric_metadata.dst_device', ConstantValue(0))
)

val block35736 = InstructionBlock(
	Assign('meta.l3_metadata.nexthop_index', :@('meta.nat_metadata.nat_nexthop')),
	Assign('meta.nexthop_metadata.nexthop_type', :@('meta.nat_metadata.nat_nexthop_type')),
	Assign('meta.l3_metadata.routed', ConstantValue(1)),
	Assign('meta.intrinsic_metadata.mcast_grp', ConstantValue(0)),
	Assign('meta.fabric_metadata.dst_device', ConstantValue(0))
)

val block35783 = InstructionBlock(
	Assign('meta.fabric_metadata.dst_device', ConstantValue(127)),
	Assign('meta.ingress_metadata.egress_ifindex', ConstantValue(0)),
	Assign('meta.intrinsic_metadata.mcast_grp', :@('meta.multicast_metadata.multicast_route_mc_index')),
	Assign('meta.l3_metadata.routed', ConstantValue(1)),
	Assign('meta.l3_metadata.same_bd_check', ConstantValue(65535))
)

val block35818 = InstructionBlock(
	Assign('meta.fabric_metadata.dst_device', ConstantValue(127)),
	Assign('meta.ingress_metadata.egress_ifindex', ConstantValue(0)),
	Assign('meta.intrinsic_metadata.mcast_grp', :@('meta.multicast_metadata.multicast_bridge_mc_index'))
)

val block35844 = InstructionBlock(
	Assign('meta.fabric_metadata.dst_device', ConstantValue(127)),
	Assign('meta.ingress_metadata.egress_ifindex', ConstantValue(65535))
)

val block35870 = InstructionBlock(
	Assign('meta.ingress_metadata.drop_flag', ConstantValue(1)),
	Assign('meta.ingress_metadata.drop_reason', ConstantValue(44))
)

val block36054 = InstructionBlock(
	fwd_result
)

val block36056 = InstructionBlock(
	If(Constrain(!'meta.ingress_metadata.bypass_lookups', :==:(ConstantValue(65535))), block36054)
)

val block36086 = InstructionBlock(

)

val block36162 = InstructionBlock(
	Assign('meta.ingress_metadata.egress_ifindex', :@('ifindex')),
	Assign('meta.l3_metadata.nexthop_index', :@('nhop_index')),
	Assign('meta.l3_metadata.same_bd_check', <BXor>36136),
	Assign('meta.l2_metadata.same_if_check', <BXor>36148),
	Assign('meta.tunnel_metadata.tunnel_if_check', <BXor>36160)
)

val block36223 = InstructionBlock(
	Assign('meta.intrinsic_metadata.mcast_grp', :@('uuc_mc_index')),
	Assign('meta.l3_metadata.nexthop_index', :@('nhop_index')),
	Assign('meta.ingress_metadata.egress_ifindex', ConstantValue(0)),
	Assign('meta.l3_metadata.same_bd_check', <BXor>36215),
	Assign('meta.fabric_metadata.dst_device', ConstantValue(127))
)

val block36289 = InstructionBlock(
	Assign('meta.ingress_metadata.egress_ifindex', :@('ifindex')),
	Assign('meta.l3_metadata.same_bd_check', <BXor>36263),
	Assign('meta.l2_metadata.same_if_check', <BXor>36275),
	Assign('meta.tunnel_metadata.tunnel_if_check', <BXor>36287)
)

val block36340 = InstructionBlock(
	Assign('meta.intrinsic_metadata.mcast_grp', :@('uuc_mc_index')),
	Assign('meta.ingress_metadata.egress_ifindex', ConstantValue(0)),
	Assign('meta.l3_metadata.same_bd_check', <BXor>36332),
	Assign('meta.fabric_metadata.dst_device', ConstantValue(127))
)

val block36486 = InstructionBlock(
	ecmp_group
)

val block36495 = InstructionBlock(
	nexthop
)

val block36497 = InstructionBlock(
	If(Constrain('meta.nexthop_metadata.nexthop_type', :==:(ConstantValue(1))), block36486, block36495)
)

val block36527 = InstructionBlock(

)

val block36551 = InstructionBlock(
	Assign('meta.intrinsic_metadata.mcast_grp', :@('mc_index'))
)

val block36616 = InstructionBlock(
	bd_flood
)

val block36646 = InstructionBlock(

)

val block36669 = InstructionBlock(
	Assign('standard_metadata.egress_spec', :@('port'))
)

val block36703 = InstructionBlock(
	Assign('meta.fabric_metadata.dst_device', :@('device')),
	Assign('meta.fabric_metadata.dst_port', :@('port'))
)

val block36792 = InstructionBlock(
	lag_group
)

val block36842 = InstructionBlock(

)

val block36883 = InstructionBlock(
	digest
)

val block36962 = InstructionBlock(
	learn_notify
)

val block36964 = InstructionBlock(
	If(Constrain('meta.l2_metadata.learning_enabled', :==:(ConstantValue(1))), block36962)
)

val block36994 = InstructionBlock(

)

val block37017 = InstructionBlock(
	Assign('standard_metadata.egress_spec', :@('port'))
)

val block37043 = InstructionBlock(
	Assign('meta.multicast_metadata.mcast_grp', :@('meta.intrinsic_metadata.mcast_grp'))
)

val block37128 = InstructionBlock(
	fabric_lag
)

val block37158 = InstructionBlock(

)

val block37182 = InstructionBlock(
	Assign('meta.intrinsic_metadata.ingress_cos', :@('icos'))
)

val block37206 = InstructionBlock(
	Assign('meta.intrinsic_metadata.qid', :@('qid'))
)

val block37240 = InstructionBlock(
	Assign('meta.intrinsic_metadata.ingress_cos', :@('icos')),
	Assign('meta.intrinsic_metadata.qid', :@('qid'))
)

val block37311 = InstructionBlock(
	traffic_class
)

val block37412 = InstructionBlock(
	drop_stats_2.count
)

val block37426 = InstructionBlock(

)

val block37512 = InstructionBlock(
	Assign('meta.intrinsic_metadata.qid', :@('qid')),
	Assign('meta.intrinsic_metadata.ingress_cos', :@('icos')),
	clone3,
	copp.execute_meter
)

val block37559 = InstructionBlock(
	copy_to_cpu,
	mark_to_drop,
	Assign('meta.fabric_metadata.dst_device', ConstantValue(0))
)

val block37604 = InstructionBlock(
	Assign('meta.fabric_metadata.reason_code', :@('reason_code')),
	copy_to_cpu
)

val block37656 = InstructionBlock(
	copy_to_cpu_with_reason,
	mark_to_drop,
	Assign('meta.fabric_metadata.dst_device', ConstantValue(0))
)

val block37676 = InstructionBlock(
	mark_to_drop
)

val block37711 = InstructionBlock(
	drop_stats.count,
	mark_to_drop
)

val block37759 = InstructionBlock(
	clone3,
	mark_to_drop
)

val block38053 = InstructionBlock(
	drop_stats_0
)

val block38055 = InstructionBlock(
	system_acl,
	If(Constrain('meta.ingress_metadata.drop_flag', :==:(ConstantValue(1))), block38053)
)

val block38057 = InstructionBlock(
	If(Constrain('<BOr>38028', :==:(ConstantValue(0))), block38055)
)

val block38093 = InstructionBlock(
	Assign('meta.l3_metadata.rmac_hit', ConstantValue(1))
)

val block38113 = InstructionBlock(
	Assign('meta.l3_metadata.rmac_hit', ConstantValue(0))
)

val block38945 = InstructionBlock(
	process_mac_acl_0
)

val block38960 = InstructionBlock(
	process_ip_acl_0
)

val block39034 = InstructionBlock(
	process_ipv4_racl_0,
	process_ipv4_urpf_0,
	process_ipv4_fib_0
)

val block39089 = InstructionBlock(
	process_ipv6_racl_0,
	process_ipv6_urpf_0,
	process_ipv6_fib_0
)

val block39091 = InstructionBlock(
	Allocate('LAnd39048'),
	If(Constrain('meta.l3_metadata.lkp_ip_type', :==:(ConstantValue(2))),
		If(Constrain('meta.ipv6_metadata.ipv6_unicast_enabled', :==:(ConstantValue(1))),
			Assign('LAnd39048', ConstantValue(1)),
		Assign('LAnd39048', ConstantValue(0))),
	Assign('LAnd39048', ConstantValue(0))),
	If(Constrain('LAnd39048'), :==:(ConstantValue(1)), block39089),
	Deallocate('LAnd39048')
)

val block39106 = InstructionBlock(
	Allocate('LAnd38993'),
	If(Constrain('meta.l3_metadata.lkp_ip_type', :==:(ConstantValue(1))),
		If(Constrain('meta.ipv4_metadata.ipv4_unicast_enabled', :==:(ConstantValue(1))),
			Assign('LAnd38993', ConstantValue(1)),
		Assign('LAnd38993', ConstantValue(0))),
	Assign('LAnd38993', ConstantValue(0))),
	If(Constrain('LAnd38993'), :==:(ConstantValue(1)), block39034, block39091),
	Deallocate('LAnd38993'),
	process_urpf_bd_0
)

val block39108 = InstructionBlock(
	If(Constrain('<BOr>38977', :==:(ConstantValue(0))), block39106)
)

val block39126 = InstructionBlock(
	process_multicast_0
)

val block39144 = InstructionBlock(
	process_validate_packet_0,
	process_ingress_l4port_0,
	process_mac_0,
	If(Constrain('meta.l3_metadata.lkp_ip_type', :==:(ConstantValue(0))), block38945, block38960),
	Fork(InstructionBlock(), block39108,block39126),
	process_ingress_nat_0
)

val block39146 = InstructionBlock(
	If(Constrain(!<LAnd>38883), block39144)
)

val block39279 = InstructionBlock(
	process_multicast_flooding_0
)

val block39294 = InstructionBlock(
	process_lag_0
)

val block39309 = InstructionBlock(
	process_ingress_bd_stats_0,
	process_ingress_acl_stats_0,
	process_storm_control_stats_0,
	process_fwd_results_0,
	process_nexthop_0,
	If(Constrain('meta.ingress_metadata.egress_ifindex', :==:(ConstantValue(65535))), block39279, block39294),
	process_mac_learning_0
)

val block39357 = InstructionBlock(
	process_system_acl_0
)

val block39359 = InstructionBlock(
	process_ingress_port_mapping_0,
	process_validate_outer_header_0,
	process_global_params_0,
	process_port_vlan_mapping_0,
	process_spanning_tree_0,
	process_ingress_qos_map_0,
	process_ip_sourceguard_0,
	process_int_endpoint_0,
	process_ingress_sflow_0,
	process_tunnel_0,
	process_storm_control_0,
	If(Constrain('meta.ingress_metadata.port_type', :~:(:==:(ConstantValue(1)))), block39146),
	process_meter_index_0,
	process_hashes_0,
	process_meter_action_0,
	If(Constrain('meta.ingress_metadata.port_type', :~:(:==:(ConstantValue(1)))), block39309),
	process_fabric_lag_0,
	process_traffic_class_0,
	If(Constrain('meta.ingress_metadata.port_type', :~:(:==:(ConstantValue(1)))), block39357)
)

val block39802 = InstructionBlock(
	//Emit hdr.ethernet
	CreateTag('hdr.ethernet.dstAddr', 0),
	Allocate(Tag('hdr.ethernet.dstAddr'), 48),
	Assign(Tag('hdr.ethernet.dstAddr'), :@('hdr.ethernet')),
	CreateTag('hdr.ethernet.srcAddr', 48),
	Allocate(Tag('hdr.ethernet.srcAddr'), 48),
	Assign(Tag('hdr.ethernet.srcAddr'), :@('hdr.ethernet')),
	CreateTag('hdr.ethernet.etherType', 96),
	Allocate(Tag('hdr.ethernet.etherType'), 16),
	Assign(Tag('hdr.ethernet.etherType'), :@('hdr.ethernet')),
	//Emit hdr.fabric_header
	CreateTag('hdr.fabric_header.packetType', 112),
	Allocate(Tag('hdr.fabric_header.packetType'), 3),
	Assign(Tag('hdr.fabric_header.packetType'), :@('hdr.fabric_header')),
	CreateTag('hdr.fabric_header.headerVersion', 115),
	Allocate(Tag('hdr.fabric_header.headerVersion'), 2),
	Assign(Tag('hdr.fabric_header.headerVersion'), :@('hdr.fabric_header')),
	CreateTag('hdr.fabric_header.packetVersion', 117),
	Allocate(Tag('hdr.fabric_header.packetVersion'), 2),
	Assign(Tag('hdr.fabric_header.packetVersion'), :@('hdr.fabric_header')),
	CreateTag('hdr.fabric_header.pad1', 119),
	Allocate(Tag('hdr.fabric_header.pad1'), 1),
	Assign(Tag('hdr.fabric_header.pad1'), :@('hdr.fabric_header')),
	CreateTag('hdr.fabric_header.fabricColor', 120),
	Allocate(Tag('hdr.fabric_header.fabricColor'), 3),
	Assign(Tag('hdr.fabric_header.fabricColor'), :@('hdr.fabric_header')),
	CreateTag('hdr.fabric_header.fabricQos', 123),
	Allocate(Tag('hdr.fabric_header.fabricQos'), 5),
	Assign(Tag('hdr.fabric_header.fabricQos'), :@('hdr.fabric_header')),
	CreateTag('hdr.fabric_header.dstDevice', 128),
	Allocate(Tag('hdr.fabric_header.dstDevice'), 8),
	Assign(Tag('hdr.fabric_header.dstDevice'), :@('hdr.fabric_header')),
	CreateTag('hdr.fabric_header.dstPortOrGroup', 136),
	Allocate(Tag('hdr.fabric_header.dstPortOrGroup'), 16),
	Assign(Tag('hdr.fabric_header.dstPortOrGroup'), :@('hdr.fabric_header')),
	//Emit hdr.fabric_header_cpu
	CreateTag('hdr.fabric_header_cpu.egressQueue', 152),
	Allocate(Tag('hdr.fabric_header_cpu.egressQueue'), 5),
	Assign(Tag('hdr.fabric_header_cpu.egressQueue'), :@('hdr.fabric_header_cpu')),
	CreateTag('hdr.fabric_header_cpu.txBypass', 157),
	Allocate(Tag('hdr.fabric_header_cpu.txBypass'), 1),
	Assign(Tag('hdr.fabric_header_cpu.txBypass'), :@('hdr.fabric_header_cpu')),
	CreateTag('hdr.fabric_header_cpu.reserved', 158),
	Allocate(Tag('hdr.fabric_header_cpu.reserved'), 2),
	Assign(Tag('hdr.fabric_header_cpu.reserved'), :@('hdr.fabric_header_cpu')),
	CreateTag('hdr.fabric_header_cpu.ingressPort', 160),
	Allocate(Tag('hdr.fabric_header_cpu.ingressPort'), 16),
	Assign(Tag('hdr.fabric_header_cpu.ingressPort'), :@('hdr.fabric_header_cpu')),
	CreateTag('hdr.fabric_header_cpu.ingressIfindex', 176),
	Allocate(Tag('hdr.fabric_header_cpu.ingressIfindex'), 16),
	Assign(Tag('hdr.fabric_header_cpu.ingressIfindex'), :@('hdr.fabric_header_cpu')),
	CreateTag('hdr.fabric_header_cpu.ingressBd', 192),
	Allocate(Tag('hdr.fabric_header_cpu.ingressBd'), 16),
	Assign(Tag('hdr.fabric_header_cpu.ingressBd'), :@('hdr.fabric_header_cpu')),
	CreateTag('hdr.fabric_header_cpu.reasonCode', 208),
	Allocate(Tag('hdr.fabric_header_cpu.reasonCode'), 16),
	Assign(Tag('hdr.fabric_header_cpu.reasonCode'), :@('hdr.fabric_header_cpu')),
	CreateTag('hdr.fabric_header_cpu.mcast_grp', 224),
	Allocate(Tag('hdr.fabric_header_cpu.mcast_grp'), 16),
	Assign(Tag('hdr.fabric_header_cpu.mcast_grp'), :@('hdr.fabric_header_cpu')),
	//Emit hdr.fabric_header_sflow
	CreateTag('hdr.fabric_header_sflow.sflow_session_id', 240),
	Allocate(Tag('hdr.fabric_header_sflow.sflow_session_id'), 16),
	Assign(Tag('hdr.fabric_header_sflow.sflow_session_id'), :@('hdr.fabric_header_sflow')),
	CreateTag('hdr.fabric_header_sflow.sflow_egress_ifindex', 256),
	Allocate(Tag('hdr.fabric_header_sflow.sflow_egress_ifindex'), 16),
	Assign(Tag('hdr.fabric_header_sflow.sflow_egress_ifindex'), :@('hdr.fabric_header_sflow')),
	//Emit hdr.fabric_header_mirror
	CreateTag('hdr.fabric_header_mirror.rewriteIndex', 272),
	Allocate(Tag('hdr.fabric_header_mirror.rewriteIndex'), 16),
	Assign(Tag('hdr.fabric_header_mirror.rewriteIndex'), :@('hdr.fabric_header_mirror')),
	CreateTag('hdr.fabric_header_mirror.egressPort', 288),
	Allocate(Tag('hdr.fabric_header_mirror.egressPort'), 10),
	Assign(Tag('hdr.fabric_header_mirror.egressPort'), :@('hdr.fabric_header_mirror')),
	CreateTag('hdr.fabric_header_mirror.egressQueue', 298),
	Allocate(Tag('hdr.fabric_header_mirror.egressQueue'), 5),
	Assign(Tag('hdr.fabric_header_mirror.egressQueue'), :@('hdr.fabric_header_mirror')),
	CreateTag('hdr.fabric_header_mirror.pad', 303),
	Allocate(Tag('hdr.fabric_header_mirror.pad'), 1),
	Assign(Tag('hdr.fabric_header_mirror.pad'), :@('hdr.fabric_header_mirror')),
	//Emit hdr.fabric_header_multicast
	CreateTag('hdr.fabric_header_multicast.routed', 304),
	Allocate(Tag('hdr.fabric_header_multicast.routed'), 1),
	Assign(Tag('hdr.fabric_header_multicast.routed'), :@('hdr.fabric_header_multicast')),
	CreateTag('hdr.fabric_header_multicast.outerRouted', 305),
	Allocate(Tag('hdr.fabric_header_multicast.outerRouted'), 1),
	Assign(Tag('hdr.fabric_header_multicast.outerRouted'), :@('hdr.fabric_header_multicast')),
	CreateTag('hdr.fabric_header_multicast.tunnelTerminate', 306),
	Allocate(Tag('hdr.fabric_header_multicast.tunnelTerminate'), 1),
	Assign(Tag('hdr.fabric_header_multicast.tunnelTerminate'), :@('hdr.fabric_header_multicast')),
	CreateTag('hdr.fabric_header_multicast.ingressTunnelType', 307),
	Allocate(Tag('hdr.fabric_header_multicast.ingressTunnelType'), 5),
	Assign(Tag('hdr.fabric_header_multicast.ingressTunnelType'), :@('hdr.fabric_header_multicast')),
	CreateTag('hdr.fabric_header_multicast.ingressIfindex', 312),
	Allocate(Tag('hdr.fabric_header_multicast.ingressIfindex'), 16),
	Assign(Tag('hdr.fabric_header_multicast.ingressIfindex'), :@('hdr.fabric_header_multicast')),
	CreateTag('hdr.fabric_header_multicast.ingressBd', 328),
	Allocate(Tag('hdr.fabric_header_multicast.ingressBd'), 16),
	Assign(Tag('hdr.fabric_header_multicast.ingressBd'), :@('hdr.fabric_header_multicast')),
	CreateTag('hdr.fabric_header_multicast.mcastGrp', 344),
	Allocate(Tag('hdr.fabric_header_multicast.mcastGrp'), 16),
	Assign(Tag('hdr.fabric_header_multicast.mcastGrp'), :@('hdr.fabric_header_multicast')),
	//Emit hdr.fabric_header_unicast
	CreateTag('hdr.fabric_header_unicast.routed', 360),
	Allocate(Tag('hdr.fabric_header_unicast.routed'), 1),
	Assign(Tag('hdr.fabric_header_unicast.routed'), :@('hdr.fabric_header_unicast')),
	CreateTag('hdr.fabric_header_unicast.outerRouted', 361),
	Allocate(Tag('hdr.fabric_header_unicast.outerRouted'), 1),
	Assign(Tag('hdr.fabric_header_unicast.outerRouted'), :@('hdr.fabric_header_unicast')),
	CreateTag('hdr.fabric_header_unicast.tunnelTerminate', 362),
	Allocate(Tag('hdr.fabric_header_unicast.tunnelTerminate'), 1),
	Assign(Tag('hdr.fabric_header_unicast.tunnelTerminate'), :@('hdr.fabric_header_unicast')),
	CreateTag('hdr.fabric_header_unicast.ingressTunnelType', 363),
	Allocate(Tag('hdr.fabric_header_unicast.ingressTunnelType'), 5),
	Assign(Tag('hdr.fabric_header_unicast.ingressTunnelType'), :@('hdr.fabric_header_unicast')),
	CreateTag('hdr.fabric_header_unicast.nexthopIndex', 368),
	Allocate(Tag('hdr.fabric_header_unicast.nexthopIndex'), 16),
	Assign(Tag('hdr.fabric_header_unicast.nexthopIndex'), :@('hdr.fabric_header_unicast')),
	//Emit hdr.fabric_payload_header
	CreateTag('hdr.fabric_payload_header.etherType', 384),
	Allocate(Tag('hdr.fabric_payload_header.etherType'), 16),
	Assign(Tag('hdr.fabric_payload_header.etherType'), :@('hdr.fabric_payload_header')),
	//Emit hdr.llc_header
	CreateTag('hdr.llc_header.dsap', 400),
	Allocate(Tag('hdr.llc_header.dsap'), 8),
	Assign(Tag('hdr.llc_header.dsap'), :@('hdr.llc_header')),
	CreateTag('hdr.llc_header.ssap', 408),
	Allocate(Tag('hdr.llc_header.ssap'), 8),
	Assign(Tag('hdr.llc_header.ssap'), :@('hdr.llc_header')),
	CreateTag('hdr.llc_header.control_', 416),
	Allocate(Tag('hdr.llc_header.control_'), 8),
	Assign(Tag('hdr.llc_header.control_'), :@('hdr.llc_header')),
	//Emit hdr.snap_header
	CreateTag('hdr.snap_header.oui', 424),
	Allocate(Tag('hdr.snap_header.oui'), 24),
	Assign(Tag('hdr.snap_header.oui'), :@('hdr.snap_header')),
	CreateTag('hdr.snap_header.type_', 448),
	Allocate(Tag('hdr.snap_header.type_'), 16),
	Assign(Tag('hdr.snap_header.type_'), :@('hdr.snap_header')),
	//Emit hdr.vlan_tag__0
	CreateTag('hdr.vlan_tag__0.pcp', 464),
	Allocate(Tag('hdr.vlan_tag__0.pcp'), 3),
	Assign(Tag('hdr.vlan_tag__0.pcp'), :@('hdr.vlan_tag__0')),
	CreateTag('hdr.vlan_tag__0.cfi', 467),
	Allocate(Tag('hdr.vlan_tag__0.cfi'), 1),
	Assign(Tag('hdr.vlan_tag__0.cfi'), :@('hdr.vlan_tag__0')),
	CreateTag('hdr.vlan_tag__0.vid', 468),
	Allocate(Tag('hdr.vlan_tag__0.vid'), 12),
	Assign(Tag('hdr.vlan_tag__0.vid'), :@('hdr.vlan_tag__0')),
	CreateTag('hdr.vlan_tag__0.etherType', 480),
	Allocate(Tag('hdr.vlan_tag__0.etherType'), 16),
	Assign(Tag('hdr.vlan_tag__0.etherType'), :@('hdr.vlan_tag__0')),
	//Emit hdr.vlan_tag__1
	CreateTag('hdr.vlan_tag__1.pcp', 496),
	Allocate(Tag('hdr.vlan_tag__1.pcp'), 3),
	Assign(Tag('hdr.vlan_tag__1.pcp'), :@('hdr.vlan_tag__1')),
	CreateTag('hdr.vlan_tag__1.cfi', 499),
	Allocate(Tag('hdr.vlan_tag__1.cfi'), 1),
	Assign(Tag('hdr.vlan_tag__1.cfi'), :@('hdr.vlan_tag__1')),
	CreateTag('hdr.vlan_tag__1.vid', 500),
	Allocate(Tag('hdr.vlan_tag__1.vid'), 12),
	Assign(Tag('hdr.vlan_tag__1.vid'), :@('hdr.vlan_tag__1')),
	CreateTag('hdr.vlan_tag__1.etherType', 512),
	Allocate(Tag('hdr.vlan_tag__1.etherType'), 16),
	Assign(Tag('hdr.vlan_tag__1.etherType'), :@('hdr.vlan_tag__1')),
	//Emit hdr.ipv6
	CreateTag('hdr.ipv6.version', 528),
	Allocate(Tag('hdr.ipv6.version'), 4),
	Assign(Tag('hdr.ipv6.version'), :@('hdr.ipv6')),
	CreateTag('hdr.ipv6.trafficClass', 532),
	Allocate(Tag('hdr.ipv6.trafficClass'), 8),
	Assign(Tag('hdr.ipv6.trafficClass'), :@('hdr.ipv6')),
	CreateTag('hdr.ipv6.flowLabel', 540),
	Allocate(Tag('hdr.ipv6.flowLabel'), 20),
	Assign(Tag('hdr.ipv6.flowLabel'), :@('hdr.ipv6')),
	CreateTag('hdr.ipv6.payloadLen', 560),
	Allocate(Tag('hdr.ipv6.payloadLen'), 16),
	Assign(Tag('hdr.ipv6.payloadLen'), :@('hdr.ipv6')),
	CreateTag('hdr.ipv6.nextHdr', 576),
	Allocate(Tag('hdr.ipv6.nextHdr'), 8),
	Assign(Tag('hdr.ipv6.nextHdr'), :@('hdr.ipv6')),
	CreateTag('hdr.ipv6.hopLimit', 584),
	Allocate(Tag('hdr.ipv6.hopLimit'), 8),
	Assign(Tag('hdr.ipv6.hopLimit'), :@('hdr.ipv6')),
	CreateTag('hdr.ipv6.srcAddr', 592),
	Allocate(Tag('hdr.ipv6.srcAddr'), 128),
	Assign(Tag('hdr.ipv6.srcAddr'), :@('hdr.ipv6')),
	CreateTag('hdr.ipv6.dstAddr', 720),
	Allocate(Tag('hdr.ipv6.dstAddr'), 128),
	Assign(Tag('hdr.ipv6.dstAddr'), :@('hdr.ipv6')),
	//Emit hdr.ipv4
	CreateTag('hdr.ipv4.version', 848),
	Allocate(Tag('hdr.ipv4.version'), 4),
	Assign(Tag('hdr.ipv4.version'), :@('hdr.ipv4')),
	CreateTag('hdr.ipv4.ihl', 852),
	Allocate(Tag('hdr.ipv4.ihl'), 4),
	Assign(Tag('hdr.ipv4.ihl'), :@('hdr.ipv4')),
	CreateTag('hdr.ipv4.diffserv', 856),
	Allocate(Tag('hdr.ipv4.diffserv'), 8),
	Assign(Tag('hdr.ipv4.diffserv'), :@('hdr.ipv4')),
	CreateTag('hdr.ipv4.totalLen', 864),
	Allocate(Tag('hdr.ipv4.totalLen'), 16),
	Assign(Tag('hdr.ipv4.totalLen'), :@('hdr.ipv4')),
	CreateTag('hdr.ipv4.identification', 880),
	Allocate(Tag('hdr.ipv4.identification'), 16),
	Assign(Tag('hdr.ipv4.identification'), :@('hdr.ipv4')),
	CreateTag('hdr.ipv4.flags', 896),
	Allocate(Tag('hdr.ipv4.flags'), 3),
	Assign(Tag('hdr.ipv4.flags'), :@('hdr.ipv4')),
	CreateTag('hdr.ipv4.fragOffset', 899),
	Allocate(Tag('hdr.ipv4.fragOffset'), 13),
	Assign(Tag('hdr.ipv4.fragOffset'), :@('hdr.ipv4')),
	CreateTag('hdr.ipv4.ttl', 912),
	Allocate(Tag('hdr.ipv4.ttl'), 8),
	Assign(Tag('hdr.ipv4.ttl'), :@('hdr.ipv4')),
	CreateTag('hdr.ipv4.protocol', 920),
	Allocate(Tag('hdr.ipv4.protocol'), 8),
	Assign(Tag('hdr.ipv4.protocol'), :@('hdr.ipv4')),
	CreateTag('hdr.ipv4.hdrChecksum', 928),
	Allocate(Tag('hdr.ipv4.hdrChecksum'), 16),
	Assign(Tag('hdr.ipv4.hdrChecksum'), :@('hdr.ipv4')),
	CreateTag('hdr.ipv4.srcAddr', 944),
	Allocate(Tag('hdr.ipv4.srcAddr'), 32),
	Assign(Tag('hdr.ipv4.srcAddr'), :@('hdr.ipv4')),
	CreateTag('hdr.ipv4.dstAddr', 976),
	Allocate(Tag('hdr.ipv4.dstAddr'), 32),
	Assign(Tag('hdr.ipv4.dstAddr'), :@('hdr.ipv4')),
	//Emit hdr.gre
	CreateTag('hdr.gre.C', 1008),
	Allocate(Tag('hdr.gre.C'), 1),
	Assign(Tag('hdr.gre.C'), :@('hdr.gre')),
	CreateTag('hdr.gre.R', 1009),
	Allocate(Tag('hdr.gre.R'), 1),
	Assign(Tag('hdr.gre.R'), :@('hdr.gre')),
	CreateTag('hdr.gre.K', 1010),
	Allocate(Tag('hdr.gre.K'), 1),
	Assign(Tag('hdr.gre.K'), :@('hdr.gre')),
	CreateTag('hdr.gre.S', 1011),
	Allocate(Tag('hdr.gre.S'), 1),
	Assign(Tag('hdr.gre.S'), :@('hdr.gre')),
	CreateTag('hdr.gre.s', 1012),
	Allocate(Tag('hdr.gre.s'), 1),
	Assign(Tag('hdr.gre.s'), :@('hdr.gre')),
	CreateTag('hdr.gre.recurse', 1013),
	Allocate(Tag('hdr.gre.recurse'), 3),
	Assign(Tag('hdr.gre.recurse'), :@('hdr.gre')),
	CreateTag('hdr.gre.flags', 1016),
	Allocate(Tag('hdr.gre.flags'), 5),
	Assign(Tag('hdr.gre.flags'), :@('hdr.gre')),
	CreateTag('hdr.gre.ver', 1021),
	Allocate(Tag('hdr.gre.ver'), 3),
	Assign(Tag('hdr.gre.ver'), :@('hdr.gre')),
	CreateTag('hdr.gre.proto', 1024),
	Allocate(Tag('hdr.gre.proto'), 16),
	Assign(Tag('hdr.gre.proto'), :@('hdr.gre')),
	//Emit hdr.erspan_t3_header
	CreateTag('hdr.erspan_t3_header.version', 1040),
	Allocate(Tag('hdr.erspan_t3_header.version'), 4),
	Assign(Tag('hdr.erspan_t3_header.version'), :@('hdr.erspan_t3_header')),
	CreateTag('hdr.erspan_t3_header.vlan', 1044),
	Allocate(Tag('hdr.erspan_t3_header.vlan'), 12),
	Assign(Tag('hdr.erspan_t3_header.vlan'), :@('hdr.erspan_t3_header')),
	CreateTag('hdr.erspan_t3_header.priority', 1056),
	Allocate(Tag('hdr.erspan_t3_header.priority'), 6),
	Assign(Tag('hdr.erspan_t3_header.priority'), :@('hdr.erspan_t3_header')),
	CreateTag('hdr.erspan_t3_header.span_id', 1062),
	Allocate(Tag('hdr.erspan_t3_header.span_id'), 10),
	Assign(Tag('hdr.erspan_t3_header.span_id'), :@('hdr.erspan_t3_header')),
	CreateTag('hdr.erspan_t3_header.timestamp', 1072),
	Allocate(Tag('hdr.erspan_t3_header.timestamp'), 32),
	Assign(Tag('hdr.erspan_t3_header.timestamp'), :@('hdr.erspan_t3_header')),
	CreateTag('hdr.erspan_t3_header.sgt', 1104),
	Allocate(Tag('hdr.erspan_t3_header.sgt'), 16),
	Assign(Tag('hdr.erspan_t3_header.sgt'), :@('hdr.erspan_t3_header')),
	CreateTag('hdr.erspan_t3_header.ft_d_other', 1120),
	Allocate(Tag('hdr.erspan_t3_header.ft_d_other'), 16),
	Assign(Tag('hdr.erspan_t3_header.ft_d_other'), :@('hdr.erspan_t3_header')),
	//Emit hdr.nvgre
	CreateTag('hdr.nvgre.tni', 1136),
	Allocate(Tag('hdr.nvgre.tni'), 24),
	Assign(Tag('hdr.nvgre.tni'), :@('hdr.nvgre')),
	CreateTag('hdr.nvgre.flow_id', 1160),
	Allocate(Tag('hdr.nvgre.flow_id'), 8),
	Assign(Tag('hdr.nvgre.flow_id'), :@('hdr.nvgre')),
	//Emit hdr.udp
	CreateTag('hdr.udp.srcPort', 1168),
	Allocate(Tag('hdr.udp.srcPort'), 16),
	Assign(Tag('hdr.udp.srcPort'), :@('hdr.udp')),
	CreateTag('hdr.udp.dstPort', 1184),
	Allocate(Tag('hdr.udp.dstPort'), 16),
	Assign(Tag('hdr.udp.dstPort'), :@('hdr.udp')),
	CreateTag('hdr.udp.length_', 1200),
	Allocate(Tag('hdr.udp.length_'), 16),
	Assign(Tag('hdr.udp.length_'), :@('hdr.udp')),
	CreateTag('hdr.udp.checksum', 1216),
	Allocate(Tag('hdr.udp.checksum'), 16),
	Assign(Tag('hdr.udp.checksum'), :@('hdr.udp')),
	//Emit hdr.sflow
	CreateTag('hdr.sflow.version', 1232),
	Allocate(Tag('hdr.sflow.version'), 32),
	Assign(Tag('hdr.sflow.version'), :@('hdr.sflow')),
	CreateTag('hdr.sflow.addrType', 1264),
	Allocate(Tag('hdr.sflow.addrType'), 32),
	Assign(Tag('hdr.sflow.addrType'), :@('hdr.sflow')),
	CreateTag('hdr.sflow.ipAddress', 1296),
	Allocate(Tag('hdr.sflow.ipAddress'), 32),
	Assign(Tag('hdr.sflow.ipAddress'), :@('hdr.sflow')),
	CreateTag('hdr.sflow.subAgentId', 1328),
	Allocate(Tag('hdr.sflow.subAgentId'), 32),
	Assign(Tag('hdr.sflow.subAgentId'), :@('hdr.sflow')),
	CreateTag('hdr.sflow.seqNumber', 1360),
	Allocate(Tag('hdr.sflow.seqNumber'), 32),
	Assign(Tag('hdr.sflow.seqNumber'), :@('hdr.sflow')),
	CreateTag('hdr.sflow.uptime', 1392),
	Allocate(Tag('hdr.sflow.uptime'), 32),
	Assign(Tag('hdr.sflow.uptime'), :@('hdr.sflow')),
	CreateTag('hdr.sflow.numSamples', 1424),
	Allocate(Tag('hdr.sflow.numSamples'), 32),
	Assign(Tag('hdr.sflow.numSamples'), :@('hdr.sflow')),
	//Emit hdr.vxlan_gpe
	CreateTag('hdr.vxlan_gpe.flags', 1456),
	Allocate(Tag('hdr.vxlan_gpe.flags'), 8),
	Assign(Tag('hdr.vxlan_gpe.flags'), :@('hdr.vxlan_gpe')),
	CreateTag('hdr.vxlan_gpe.reserved', 1464),
	Allocate(Tag('hdr.vxlan_gpe.reserved'), 16),
	Assign(Tag('hdr.vxlan_gpe.reserved'), :@('hdr.vxlan_gpe')),
	CreateTag('hdr.vxlan_gpe.next_proto', 1480),
	Allocate(Tag('hdr.vxlan_gpe.next_proto'), 8),
	Assign(Tag('hdr.vxlan_gpe.next_proto'), :@('hdr.vxlan_gpe')),
	CreateTag('hdr.vxlan_gpe.vni', 1488),
	Allocate(Tag('hdr.vxlan_gpe.vni'), 24),
	Assign(Tag('hdr.vxlan_gpe.vni'), :@('hdr.vxlan_gpe')),
	CreateTag('hdr.vxlan_gpe.reserved2', 1512),
	Allocate(Tag('hdr.vxlan_gpe.reserved2'), 8),
	Assign(Tag('hdr.vxlan_gpe.reserved2'), :@('hdr.vxlan_gpe')),
	//Emit hdr.vxlan_gpe_int_header
	CreateTag('hdr.vxlan_gpe_int_header.int_type', 1520),
	Allocate(Tag('hdr.vxlan_gpe_int_header.int_type'), 8),
	Assign(Tag('hdr.vxlan_gpe_int_header.int_type'), :@('hdr.vxlan_gpe_int_header')),
	CreateTag('hdr.vxlan_gpe_int_header.rsvd', 1528),
	Allocate(Tag('hdr.vxlan_gpe_int_header.rsvd'), 8),
	Assign(Tag('hdr.vxlan_gpe_int_header.rsvd'), :@('hdr.vxlan_gpe_int_header')),
	CreateTag('hdr.vxlan_gpe_int_header.len', 1536),
	Allocate(Tag('hdr.vxlan_gpe_int_header.len'), 8),
	Assign(Tag('hdr.vxlan_gpe_int_header.len'), :@('hdr.vxlan_gpe_int_header')),
	CreateTag('hdr.vxlan_gpe_int_header.next_proto', 1544),
	Allocate(Tag('hdr.vxlan_gpe_int_header.next_proto'), 8),
	Assign(Tag('hdr.vxlan_gpe_int_header.next_proto'), :@('hdr.vxlan_gpe_int_header')),
	//Emit hdr.int_header
	CreateTag('hdr.int_header.ver', 1552),
	Allocate(Tag('hdr.int_header.ver'), 2),
	Assign(Tag('hdr.int_header.ver'), :@('hdr.int_header')),
	CreateTag('hdr.int_header.rep', 1554),
	Allocate(Tag('hdr.int_header.rep'), 2),
	Assign(Tag('hdr.int_header.rep'), :@('hdr.int_header')),
	CreateTag('hdr.int_header.c', 1556),
	Allocate(Tag('hdr.int_header.c'), 1),
	Assign(Tag('hdr.int_header.c'), :@('hdr.int_header')),
	CreateTag('hdr.int_header.e', 1557),
	Allocate(Tag('hdr.int_header.e'), 1),
	Assign(Tag('hdr.int_header.e'), :@('hdr.int_header')),
	CreateTag('hdr.int_header.rsvd1', 1558),
	Allocate(Tag('hdr.int_header.rsvd1'), 5),
	Assign(Tag('hdr.int_header.rsvd1'), :@('hdr.int_header')),
	CreateTag('hdr.int_header.ins_cnt', 1563),
	Allocate(Tag('hdr.int_header.ins_cnt'), 5),
	Assign(Tag('hdr.int_header.ins_cnt'), :@('hdr.int_header')),
	CreateTag('hdr.int_header.max_hop_cnt', 1568),
	Allocate(Tag('hdr.int_header.max_hop_cnt'), 8),
	Assign(Tag('hdr.int_header.max_hop_cnt'), :@('hdr.int_header')),
	CreateTag('hdr.int_header.total_hop_cnt', 1576),
	Allocate(Tag('hdr.int_header.total_hop_cnt'), 8),
	Assign(Tag('hdr.int_header.total_hop_cnt'), :@('hdr.int_header')),
	CreateTag('hdr.int_header.instruction_mask_0003', 1584),
	Allocate(Tag('hdr.int_header.instruction_mask_0003'), 4),
	Assign(Tag('hdr.int_header.instruction_mask_0003'), :@('hdr.int_header')),
	CreateTag('hdr.int_header.instruction_mask_0407', 1588),
	Allocate(Tag('hdr.int_header.instruction_mask_0407'), 4),
	Assign(Tag('hdr.int_header.instruction_mask_0407'), :@('hdr.int_header')),
	CreateTag('hdr.int_header.instruction_mask_0811', 1592),
	Allocate(Tag('hdr.int_header.instruction_mask_0811'), 4),
	Assign(Tag('hdr.int_header.instruction_mask_0811'), :@('hdr.int_header')),
	CreateTag('hdr.int_header.instruction_mask_1215', 1596),
	Allocate(Tag('hdr.int_header.instruction_mask_1215'), 4),
	Assign(Tag('hdr.int_header.instruction_mask_1215'), :@('hdr.int_header')),
	CreateTag('hdr.int_header.rsvd2', 1600),
	Allocate(Tag('hdr.int_header.rsvd2'), 16),
	Assign(Tag('hdr.int_header.rsvd2'), :@('hdr.int_header')),
	//Emit hdr.int_switch_id_header
	CreateTag('hdr.int_switch_id_header.bos', 1616),
	Allocate(Tag('hdr.int_switch_id_header.bos'), 1),
	Assign(Tag('hdr.int_switch_id_header.bos'), :@('hdr.int_switch_id_header')),
	CreateTag('hdr.int_switch_id_header.switch_id', 1617),
	Allocate(Tag('hdr.int_switch_id_header.switch_id'), 31),
	Assign(Tag('hdr.int_switch_id_header.switch_id'), :@('hdr.int_switch_id_header')),
	//Emit hdr.int_ingress_port_id_header
	CreateTag('hdr.int_ingress_port_id_header.bos', 1648),
	Allocate(Tag('hdr.int_ingress_port_id_header.bos'), 1),
	Assign(Tag('hdr.int_ingress_port_id_header.bos'), :@('hdr.int_ingress_port_id_header')),
	CreateTag('hdr.int_ingress_port_id_header.ingress_port_id_1', 1649),
	Allocate(Tag('hdr.int_ingress_port_id_header.ingress_port_id_1'), 15),
	Assign(Tag('hdr.int_ingress_port_id_header.ingress_port_id_1'), :@('hdr.int_ingress_port_id_header')),
	CreateTag('hdr.int_ingress_port_id_header.ingress_port_id_0', 1664),
	Allocate(Tag('hdr.int_ingress_port_id_header.ingress_port_id_0'), 16),
	Assign(Tag('hdr.int_ingress_port_id_header.ingress_port_id_0'), :@('hdr.int_ingress_port_id_header')),
	//Emit hdr.int_hop_latency_header
	CreateTag('hdr.int_hop_latency_header.bos', 1680),
	Allocate(Tag('hdr.int_hop_latency_header.bos'), 1),
	Assign(Tag('hdr.int_hop_latency_header.bos'), :@('hdr.int_hop_latency_header')),
	CreateTag('hdr.int_hop_latency_header.hop_latency', 1681),
	Allocate(Tag('hdr.int_hop_latency_header.hop_latency'), 31),
	Assign(Tag('hdr.int_hop_latency_header.hop_latency'), :@('hdr.int_hop_latency_header')),
	//Emit hdr.int_q_occupancy_header
	CreateTag('hdr.int_q_occupancy_header.bos', 1712),
	Allocate(Tag('hdr.int_q_occupancy_header.bos'), 1),
	Assign(Tag('hdr.int_q_occupancy_header.bos'), :@('hdr.int_q_occupancy_header')),
	CreateTag('hdr.int_q_occupancy_header.q_occupancy1', 1713),
	Allocate(Tag('hdr.int_q_occupancy_header.q_occupancy1'), 7),
	Assign(Tag('hdr.int_q_occupancy_header.q_occupancy1'), :@('hdr.int_q_occupancy_header')),
	CreateTag('hdr.int_q_occupancy_header.q_occupancy0', 1720),
	Allocate(Tag('hdr.int_q_occupancy_header.q_occupancy0'), 24),
	Assign(Tag('hdr.int_q_occupancy_header.q_occupancy0'), :@('hdr.int_q_occupancy_header')),
	//Emit hdr.int_ingress_tstamp_header
	CreateTag('hdr.int_ingress_tstamp_header.bos', 1744),
	Allocate(Tag('hdr.int_ingress_tstamp_header.bos'), 1),
	Assign(Tag('hdr.int_ingress_tstamp_header.bos'), :@('hdr.int_ingress_tstamp_header')),
	CreateTag('hdr.int_ingress_tstamp_header.ingress_tstamp', 1745),
	Allocate(Tag('hdr.int_ingress_tstamp_header.ingress_tstamp'), 31),
	Assign(Tag('hdr.int_ingress_tstamp_header.ingress_tstamp'), :@('hdr.int_ingress_tstamp_header')),
	//Emit hdr.int_egress_port_id_header
	CreateTag('hdr.int_egress_port_id_header.bos', 1776),
	Allocate(Tag('hdr.int_egress_port_id_header.bos'), 1),
	Assign(Tag('hdr.int_egress_port_id_header.bos'), :@('hdr.int_egress_port_id_header')),
	CreateTag('hdr.int_egress_port_id_header.egress_port_id', 1777),
	Allocate(Tag('hdr.int_egress_port_id_header.egress_port_id'), 31),
	Assign(Tag('hdr.int_egress_port_id_header.egress_port_id'), :@('hdr.int_egress_port_id_header')),
	//Emit hdr.int_q_congestion_header
	CreateTag('hdr.int_q_congestion_header.bos', 1808),
	Allocate(Tag('hdr.int_q_congestion_header.bos'), 1),
	Assign(Tag('hdr.int_q_congestion_header.bos'), :@('hdr.int_q_congestion_header')),
	CreateTag('hdr.int_q_congestion_header.q_congestion', 1809),
	Allocate(Tag('hdr.int_q_congestion_header.q_congestion'), 31),
	Assign(Tag('hdr.int_q_congestion_header.q_congestion'), :@('hdr.int_q_congestion_header')),
	//Emit hdr.int_egress_port_tx_utilization_header
	CreateTag('hdr.int_egress_port_tx_utilization_header.bos', 1840),
	Allocate(Tag('hdr.int_egress_port_tx_utilization_header.bos'), 1),
	Assign(Tag('hdr.int_egress_port_tx_utilization_header.bos'), :@('hdr.int_egress_port_tx_utilization_header')),
	CreateTag('hdr.int_egress_port_tx_utilization_header.egress_port_tx_utilization', 1841),
	Allocate(Tag('hdr.int_egress_port_tx_utilization_header.egress_port_tx_utilization'), 31),
	Assign(Tag('hdr.int_egress_port_tx_utilization_header.egress_port_tx_utilization'), :@('hdr.int_egress_port_tx_utilization_header')),
	//Emit hdr.int_val
	CreateTag('hdr.int_val.bos', 1872),
	Allocate(Tag('hdr.int_val.bos'), 1),
	Assign(Tag('hdr.int_val.bos'), :@('hdr.int_val')),
	CreateTag('hdr.int_val.val', 1873),
	Allocate(Tag('hdr.int_val.val'), 31),
	Assign(Tag('hdr.int_val.val'), :@('hdr.int_val')),
	//Emit hdr.genv
	CreateTag('hdr.genv.ver', 1904),
	Allocate(Tag('hdr.genv.ver'), 2),
	Assign(Tag('hdr.genv.ver'), :@('hdr.genv')),
	CreateTag('hdr.genv.optLen', 1906),
	Allocate(Tag('hdr.genv.optLen'), 6),
	Assign(Tag('hdr.genv.optLen'), :@('hdr.genv')),
	CreateTag('hdr.genv.oam', 1912),
	Allocate(Tag('hdr.genv.oam'), 1),
	Assign(Tag('hdr.genv.oam'), :@('hdr.genv')),
	CreateTag('hdr.genv.critical', 1913),
	Allocate(Tag('hdr.genv.critical'), 1),
	Assign(Tag('hdr.genv.critical'), :@('hdr.genv')),
	CreateTag('hdr.genv.reserved', 1914),
	Allocate(Tag('hdr.genv.reserved'), 6),
	Assign(Tag('hdr.genv.reserved'), :@('hdr.genv')),
	CreateTag('hdr.genv.protoType', 1920),
	Allocate(Tag('hdr.genv.protoType'), 16),
	Assign(Tag('hdr.genv.protoType'), :@('hdr.genv')),
	CreateTag('hdr.genv.vni', 1936),
	Allocate(Tag('hdr.genv.vni'), 24),
	Assign(Tag('hdr.genv.vni'), :@('hdr.genv')),
	CreateTag('hdr.genv.reserved2', 1960),
	Allocate(Tag('hdr.genv.reserved2'), 8),
	Assign(Tag('hdr.genv.reserved2'), :@('hdr.genv')),
	//Emit hdr.vxlan
	CreateTag('hdr.vxlan.flags', 1968),
	Allocate(Tag('hdr.vxlan.flags'), 8),
	Assign(Tag('hdr.vxlan.flags'), :@('hdr.vxlan')),
	CreateTag('hdr.vxlan.reserved', 1976),
	Allocate(Tag('hdr.vxlan.reserved'), 24),
	Assign(Tag('hdr.vxlan.reserved'), :@('hdr.vxlan')),
	CreateTag('hdr.vxlan.vni', 2000),
	Allocate(Tag('hdr.vxlan.vni'), 24),
	Assign(Tag('hdr.vxlan.vni'), :@('hdr.vxlan')),
	CreateTag('hdr.vxlan.reserved2', 2024),
	Allocate(Tag('hdr.vxlan.reserved2'), 8),
	Assign(Tag('hdr.vxlan.reserved2'), :@('hdr.vxlan')),
	//Emit hdr.tcp
	CreateTag('hdr.tcp.srcPort', 2032),
	Allocate(Tag('hdr.tcp.srcPort'), 16),
	Assign(Tag('hdr.tcp.srcPort'), :@('hdr.tcp')),
	CreateTag('hdr.tcp.dstPort', 2048),
	Allocate(Tag('hdr.tcp.dstPort'), 16),
	Assign(Tag('hdr.tcp.dstPort'), :@('hdr.tcp')),
	CreateTag('hdr.tcp.seqNo', 2064),
	Allocate(Tag('hdr.tcp.seqNo'), 32),
	Assign(Tag('hdr.tcp.seqNo'), :@('hdr.tcp')),
	CreateTag('hdr.tcp.ackNo', 2096),
	Allocate(Tag('hdr.tcp.ackNo'), 32),
	Assign(Tag('hdr.tcp.ackNo'), :@('hdr.tcp')),
	CreateTag('hdr.tcp.dataOffset', 2128),
	Allocate(Tag('hdr.tcp.dataOffset'), 4),
	Assign(Tag('hdr.tcp.dataOffset'), :@('hdr.tcp')),
	CreateTag('hdr.tcp.res', 2132),
	Allocate(Tag('hdr.tcp.res'), 4),
	Assign(Tag('hdr.tcp.res'), :@('hdr.tcp')),
	CreateTag('hdr.tcp.flags', 2136),
	Allocate(Tag('hdr.tcp.flags'), 8),
	Assign(Tag('hdr.tcp.flags'), :@('hdr.tcp')),
	CreateTag('hdr.tcp.window', 2144),
	Allocate(Tag('hdr.tcp.window'), 16),
	Assign(Tag('hdr.tcp.window'), :@('hdr.tcp')),
	CreateTag('hdr.tcp.checksum', 2160),
	Allocate(Tag('hdr.tcp.checksum'), 16),
	Assign(Tag('hdr.tcp.checksum'), :@('hdr.tcp')),
	CreateTag('hdr.tcp.urgentPtr', 2176),
	Allocate(Tag('hdr.tcp.urgentPtr'), 16),
	Assign(Tag('hdr.tcp.urgentPtr'), :@('hdr.tcp')),
	//Emit hdr.icmp
	CreateTag('hdr.icmp.typeCode', 2192),
	Allocate(Tag('hdr.icmp.typeCode'), 16),
	Assign(Tag('hdr.icmp.typeCode'), :@('hdr.icmp')),
	CreateTag('hdr.icmp.hdrChecksum', 2208),
	Allocate(Tag('hdr.icmp.hdrChecksum'), 16),
	Assign(Tag('hdr.icmp.hdrChecksum'), :@('hdr.icmp')),
	//Emit hdr.mpls
	CreateTag('hdr.mpls.label', 2224),
	Allocate(Tag('hdr.mpls.label'), 20),
	Assign(Tag('hdr.mpls.label'), :@('hdr.mpls')),
	CreateTag('hdr.mpls.exp', 2244),
	Allocate(Tag('hdr.mpls.exp'), 3),
	Assign(Tag('hdr.mpls.exp'), :@('hdr.mpls')),
	CreateTag('hdr.mpls.bos', 2247),
	Allocate(Tag('hdr.mpls.bos'), 1),
	Assign(Tag('hdr.mpls.bos'), :@('hdr.mpls')),
	CreateTag('hdr.mpls.ttl', 2248),
	Allocate(Tag('hdr.mpls.ttl'), 8),
	Assign(Tag('hdr.mpls.ttl'), :@('hdr.mpls')),
	//Emit hdr.inner_ethernet
	CreateTag('hdr.inner_ethernet.dstAddr', 2256),
	Allocate(Tag('hdr.inner_ethernet.dstAddr'), 48),
	Assign(Tag('hdr.inner_ethernet.dstAddr'), :@('hdr.inner_ethernet')),
	CreateTag('hdr.inner_ethernet.srcAddr', 2304),
	Allocate(Tag('hdr.inner_ethernet.srcAddr'), 48),
	Assign(Tag('hdr.inner_ethernet.srcAddr'), :@('hdr.inner_ethernet')),
	CreateTag('hdr.inner_ethernet.etherType', 2352),
	Allocate(Tag('hdr.inner_ethernet.etherType'), 16),
	Assign(Tag('hdr.inner_ethernet.etherType'), :@('hdr.inner_ethernet')),
	//Emit hdr.inner_ipv6
	CreateTag('hdr.inner_ipv6.version', 2368),
	Allocate(Tag('hdr.inner_ipv6.version'), 4),
	Assign(Tag('hdr.inner_ipv6.version'), :@('hdr.inner_ipv6')),
	CreateTag('hdr.inner_ipv6.trafficClass', 2372),
	Allocate(Tag('hdr.inner_ipv6.trafficClass'), 8),
	Assign(Tag('hdr.inner_ipv6.trafficClass'), :@('hdr.inner_ipv6')),
	CreateTag('hdr.inner_ipv6.flowLabel', 2380),
	Allocate(Tag('hdr.inner_ipv6.flowLabel'), 20),
	Assign(Tag('hdr.inner_ipv6.flowLabel'), :@('hdr.inner_ipv6')),
	CreateTag('hdr.inner_ipv6.payloadLen', 2400),
	Allocate(Tag('hdr.inner_ipv6.payloadLen'), 16),
	Assign(Tag('hdr.inner_ipv6.payloadLen'), :@('hdr.inner_ipv6')),
	CreateTag('hdr.inner_ipv6.nextHdr', 2416),
	Allocate(Tag('hdr.inner_ipv6.nextHdr'), 8),
	Assign(Tag('hdr.inner_ipv6.nextHdr'), :@('hdr.inner_ipv6')),
	CreateTag('hdr.inner_ipv6.hopLimit', 2424),
	Allocate(Tag('hdr.inner_ipv6.hopLimit'), 8),
	Assign(Tag('hdr.inner_ipv6.hopLimit'), :@('hdr.inner_ipv6')),
	CreateTag('hdr.inner_ipv6.srcAddr', 2432),
	Allocate(Tag('hdr.inner_ipv6.srcAddr'), 128),
	Assign(Tag('hdr.inner_ipv6.srcAddr'), :@('hdr.inner_ipv6')),
	CreateTag('hdr.inner_ipv6.dstAddr', 2560),
	Allocate(Tag('hdr.inner_ipv6.dstAddr'), 128),
	Assign(Tag('hdr.inner_ipv6.dstAddr'), :@('hdr.inner_ipv6')),
	//Emit hdr.inner_ipv4
	CreateTag('hdr.inner_ipv4.version', 2688),
	Allocate(Tag('hdr.inner_ipv4.version'), 4),
	Assign(Tag('hdr.inner_ipv4.version'), :@('hdr.inner_ipv4')),
	CreateTag('hdr.inner_ipv4.ihl', 2692),
	Allocate(Tag('hdr.inner_ipv4.ihl'), 4),
	Assign(Tag('hdr.inner_ipv4.ihl'), :@('hdr.inner_ipv4')),
	CreateTag('hdr.inner_ipv4.diffserv', 2696),
	Allocate(Tag('hdr.inner_ipv4.diffserv'), 8),
	Assign(Tag('hdr.inner_ipv4.diffserv'), :@('hdr.inner_ipv4')),
	CreateTag('hdr.inner_ipv4.totalLen', 2704),
	Allocate(Tag('hdr.inner_ipv4.totalLen'), 16),
	Assign(Tag('hdr.inner_ipv4.totalLen'), :@('hdr.inner_ipv4')),
	CreateTag('hdr.inner_ipv4.identification', 2720),
	Allocate(Tag('hdr.inner_ipv4.identification'), 16),
	Assign(Tag('hdr.inner_ipv4.identification'), :@('hdr.inner_ipv4')),
	CreateTag('hdr.inner_ipv4.flags', 2736),
	Allocate(Tag('hdr.inner_ipv4.flags'), 3),
	Assign(Tag('hdr.inner_ipv4.flags'), :@('hdr.inner_ipv4')),
	CreateTag('hdr.inner_ipv4.fragOffset', 2739),
	Allocate(Tag('hdr.inner_ipv4.fragOffset'), 13),
	Assign(Tag('hdr.inner_ipv4.fragOffset'), :@('hdr.inner_ipv4')),
	CreateTag('hdr.inner_ipv4.ttl', 2752),
	Allocate(Tag('hdr.inner_ipv4.ttl'), 8),
	Assign(Tag('hdr.inner_ipv4.ttl'), :@('hdr.inner_ipv4')),
	CreateTag('hdr.inner_ipv4.protocol', 2760),
	Allocate(Tag('hdr.inner_ipv4.protocol'), 8),
	Assign(Tag('hdr.inner_ipv4.protocol'), :@('hdr.inner_ipv4')),
	CreateTag('hdr.inner_ipv4.hdrChecksum', 2768),
	Allocate(Tag('hdr.inner_ipv4.hdrChecksum'), 16),
	Assign(Tag('hdr.inner_ipv4.hdrChecksum'), :@('hdr.inner_ipv4')),
	CreateTag('hdr.inner_ipv4.srcAddr', 2784),
	Allocate(Tag('hdr.inner_ipv4.srcAddr'), 32),
	Assign(Tag('hdr.inner_ipv4.srcAddr'), :@('hdr.inner_ipv4')),
	CreateTag('hdr.inner_ipv4.dstAddr', 2816),
	Allocate(Tag('hdr.inner_ipv4.dstAddr'), 32),
	Assign(Tag('hdr.inner_ipv4.dstAddr'), :@('hdr.inner_ipv4')),
	//Emit hdr.inner_udp
	CreateTag('hdr.inner_udp.srcPort', 2848),
	Allocate(Tag('hdr.inner_udp.srcPort'), 16),
	Assign(Tag('hdr.inner_udp.srcPort'), :@('hdr.inner_udp')),
	CreateTag('hdr.inner_udp.dstPort', 2864),
	Allocate(Tag('hdr.inner_udp.dstPort'), 16),
	Assign(Tag('hdr.inner_udp.dstPort'), :@('hdr.inner_udp')),
	CreateTag('hdr.inner_udp.length_', 2880),
	Allocate(Tag('hdr.inner_udp.length_'), 16),
	Assign(Tag('hdr.inner_udp.length_'), :@('hdr.inner_udp')),
	CreateTag('hdr.inner_udp.checksum', 2896),
	Allocate(Tag('hdr.inner_udp.checksum'), 16),
	Assign(Tag('hdr.inner_udp.checksum'), :@('hdr.inner_udp')),
	//Emit hdr.inner_tcp
	CreateTag('hdr.inner_tcp.srcPort', 2912),
	Allocate(Tag('hdr.inner_tcp.srcPort'), 16),
	Assign(Tag('hdr.inner_tcp.srcPort'), :@('hdr.inner_tcp')),
	CreateTag('hdr.inner_tcp.dstPort', 2928),
	Allocate(Tag('hdr.inner_tcp.dstPort'), 16),
	Assign(Tag('hdr.inner_tcp.dstPort'), :@('hdr.inner_tcp')),
	CreateTag('hdr.inner_tcp.seqNo', 2944),
	Allocate(Tag('hdr.inner_tcp.seqNo'), 32),
	Assign(Tag('hdr.inner_tcp.seqNo'), :@('hdr.inner_tcp')),
	CreateTag('hdr.inner_tcp.ackNo', 2976),
	Allocate(Tag('hdr.inner_tcp.ackNo'), 32),
	Assign(Tag('hdr.inner_tcp.ackNo'), :@('hdr.inner_tcp')),
	CreateTag('hdr.inner_tcp.dataOffset', 3008),
	Allocate(Tag('hdr.inner_tcp.dataOffset'), 4),
	Assign(Tag('hdr.inner_tcp.dataOffset'), :@('hdr.inner_tcp')),
	CreateTag('hdr.inner_tcp.res', 3012),
	Allocate(Tag('hdr.inner_tcp.res'), 4),
	Assign(Tag('hdr.inner_tcp.res'), :@('hdr.inner_tcp')),
	CreateTag('hdr.inner_tcp.flags', 3016),
	Allocate(Tag('hdr.inner_tcp.flags'), 8),
	Assign(Tag('hdr.inner_tcp.flags'), :@('hdr.inner_tcp')),
	CreateTag('hdr.inner_tcp.window', 3024),
	Allocate(Tag('hdr.inner_tcp.window'), 16),
	Assign(Tag('hdr.inner_tcp.window'), :@('hdr.inner_tcp')),
	CreateTag('hdr.inner_tcp.checksum', 3040),
	Allocate(Tag('hdr.inner_tcp.checksum'), 16),
	Assign(Tag('hdr.inner_tcp.checksum'), :@('hdr.inner_tcp')),
	CreateTag('hdr.inner_tcp.urgentPtr', 3056),
	Allocate(Tag('hdr.inner_tcp.urgentPtr'), 16),
	Assign(Tag('hdr.inner_tcp.urgentPtr'), :@('hdr.inner_tcp')),
	//Emit hdr.inner_icmp
	CreateTag('hdr.inner_icmp.typeCode', 3072),
	Allocate(Tag('hdr.inner_icmp.typeCode'), 16),
	Assign(Tag('hdr.inner_icmp.typeCode'), :@('hdr.inner_icmp')),
	CreateTag('hdr.inner_icmp.hdrChecksum', 3088),
	Allocate(Tag('hdr.inner_icmp.hdrChecksum'), 16),
	Assign(Tag('hdr.inner_icmp.hdrChecksum'), :@('hdr.inner_icmp'))
)

val block39971 = InstructionBlock(
	Allocate('LAnd39892'),
	If(Constrain('hdr.inner_ipv4.ihl', :==:(ConstantValue(5))),
		If(Constrain('hdr.inner_ipv4.hdrChecksum', :==:(inner_ipv4_checksum.get)),
			Assign('LAnd39892', ConstantValue(1)),
		Assign('LAnd39892', ConstantValue(0))),
	Assign('LAnd39892', ConstantValue(0))),
	If(Constrain('LAnd39892'), :==:(ConstantValue(1)), mark_to_drop),
	Deallocate('LAnd39892'),
	Allocate('LAnd39963'),
	If(Constrain('hdr.ipv4.ihl', :==:(ConstantValue(5))),
		If(Constrain('hdr.ipv4.hdrChecksum', :==:(ipv4_checksum.get)),
			Assign('LAnd39963', ConstantValue(1)),
		Assign('LAnd39963', ConstantValue(0))),
	Assign('LAnd39963', ConstantValue(0))),
	If(Constrain('LAnd39963'), :==:(ConstantValue(1)), mark_to_drop),
	Deallocate('LAnd39963')
)

val block40126 = InstructionBlock(
	If(Constrain('hdr.inner_ipv4.ihl', :==:(ConstantValue(5))), Assign('hdr.inner_ipv4.hdrChecksum', inner_ipv4_checksum.get)),
	If(Constrain('hdr.ipv4.ihl', :==:(ConstantValue(5))), Assign('hdr.ipv4.hdrChecksum', ipv4_checksum.get))
)

<Type_Error>16
<Type_Extern>69
<Type_Extern>84
<Type_Method>95
// Action
val NoAction = InstructionBlock(
	block99
)


<Declaration_MatchKind>106
<Declaration_MatchKind>110









<Type_Extern>161
<Type_Enum>167
<Type_Extern>192
<Type_Extern>206
<Type_Extern>236
<Type_Extern>260
<Type_Extern>299
<Type_Extern>313
<Type_Method>328
<Type_Method>341
<Type_Enum>350
<Type_Method>355
<Type_Method>380
<Type_Extern>400
<Type_Enum>405
<Type_Method>414
<Type_Method>424
<Type_Method>436
<Type_Method>452
<Type_Method>461
<Type_Parser>481
<Type_Control>494
<Type_Control>510
<Type_Control>526
<Type_Control>539
<Type_Control>551
<Type_Package>610





















































































































































































































































































































































,
Allocate('int_valIndex')
,
Allocate('mplsIndex')
,
Allocate('vlan_tag_Index')


val parse_all_int_meta_value_heders = InstructionBlock(
	// extract hdr.int_switch_id_header
	Assign('hdr.int_switch_id_header.isValid', ConstantValue(1)),
	Assign('hdr.int_switch_id_header.bos', SymbolicValue()),
	Assign('hdr.int_switch_id_header.switch_id', SymbolicValue()),
	// extract hdr.int_ingress_port_id_header
	Assign('hdr.int_ingress_port_id_header.isValid', ConstantValue(1)),
	Assign('hdr.int_ingress_port_id_header.bos', SymbolicValue()),
	Assign('hdr.int_ingress_port_id_header.ingress_port_id_1', SymbolicValue()),
	Assign('hdr.int_ingress_port_id_header.ingress_port_id_0', SymbolicValue()),
	// extract hdr.int_hop_latency_header
	Assign('hdr.int_hop_latency_header.isValid', ConstantValue(1)),
	Assign('hdr.int_hop_latency_header.bos', SymbolicValue()),
	Assign('hdr.int_hop_latency_header.hop_latency', SymbolicValue()),
	// extract hdr.int_q_occupancy_header
	Assign('hdr.int_q_occupancy_header.isValid', ConstantValue(1)),
	Assign('hdr.int_q_occupancy_header.bos', SymbolicValue()),
	Assign('hdr.int_q_occupancy_header.q_occupancy1', SymbolicValue()),
	Assign('hdr.int_q_occupancy_header.q_occupancy0', SymbolicValue()),
	// extract hdr.int_ingress_tstamp_header
	Assign('hdr.int_ingress_tstamp_header.isValid', ConstantValue(1)),
	Assign('hdr.int_ingress_tstamp_header.bos', SymbolicValue()),
	Assign('hdr.int_ingress_tstamp_header.ingress_tstamp', SymbolicValue()),
	// extract hdr.int_egress_port_id_header
	Assign('hdr.int_egress_port_id_header.isValid', ConstantValue(1)),
	Assign('hdr.int_egress_port_id_header.bos', SymbolicValue()),
	Assign('hdr.int_egress_port_id_header.egress_port_id', SymbolicValue()),
	// extract hdr.int_q_congestion_header
	Assign('hdr.int_q_congestion_header.isValid', ConstantValue(1)),
	Assign('hdr.int_q_congestion_header.bos', SymbolicValue()),
	Assign('hdr.int_q_congestion_header.q_congestion', SymbolicValue()),
	// extract hdr.int_egress_port_tx_utilization_header
	Assign('hdr.int_egress_port_tx_utilization_header.isValid', ConstantValue(1)),
	Assign('hdr.int_egress_port_tx_utilization_header.bos', SymbolicValue()),
	Assign('hdr.int_egress_port_tx_utilization_header.egress_port_tx_utilization', SymbolicValue()),
	parse_int_val
)


val parse_arp_rarp = InstructionBlock(
	parse_set_prio_med
)


val parse_bfd = InstructionBlock(
	// extract hdr.bfd
	Assign('hdr.bfd.isValid', ConstantValue(1)),
	Assign('hdr.bfd.version', SymbolicValue()),
	Assign('hdr.bfd.diag', SymbolicValue()),
	Assign('hdr.bfd.state', SymbolicValue()),
	Assign('hdr.bfd.p', SymbolicValue()),
	Assign('hdr.bfd.f', SymbolicValue()),
	Assign('hdr.bfd.c', SymbolicValue()),
	Assign('hdr.bfd.a', SymbolicValue()),
	Assign('hdr.bfd.d', SymbolicValue()),
	Assign('hdr.bfd.m', SymbolicValue()),
	Assign('hdr.bfd.detectMult', SymbolicValue()),
	Assign('hdr.bfd.len', SymbolicValue()),
	Assign('hdr.bfd.myDiscriminator', SymbolicValue()),
	Assign('hdr.bfd.yourDiscriminator', SymbolicValue()),
	Assign('hdr.bfd.desiredMinTxInterval', SymbolicValue()),
	Assign('hdr.bfd.requiredMinRxInterval', SymbolicValue()),
	Assign('hdr.bfd.requiredMinEchoRxInterval', SymbolicValue()),
	parse_set_prio_max
)


val parse_eompls = InstructionBlock(
	Assign('meta.tunnel_metadata.ingress_tunnel_type', ConstantValue(6)),
	parse_inner_ethernet
)


val parse_erspan_t3 = InstructionBlock(
	// extract hdr.erspan_t3_header
	Assign('hdr.erspan_t3_header.isValid', ConstantValue(1)),
	Assign('hdr.erspan_t3_header.version', SymbolicValue()),
	Assign('hdr.erspan_t3_header.vlan', SymbolicValue()),
	Assign('hdr.erspan_t3_header.priority', SymbolicValue()),
	Assign('hdr.erspan_t3_header.span_id', SymbolicValue()),
	Assign('hdr.erspan_t3_header.timestamp', SymbolicValue()),
	Assign('hdr.erspan_t3_header.sgt', SymbolicValue()),
	Assign('hdr.erspan_t3_header.ft_d_other', SymbolicValue()),
	parse_inner_ethernet
)


val parse_ethernet = InstructionBlock(
	// extract hdr.ethernet
	Assign('hdr.ethernet.isValid', ConstantValue(1)),
	Assign('hdr.ethernet.dstAddr', SymbolicValue()),
	Assign('hdr.ethernet.srcAddr', SymbolicValue()),
	Assign('hdr.ethernet.etherType', SymbolicValue()),
	//TODO: MASK
If(Constrain('hdr.ethernet.etherType', :==:(ConstantValue(36864))), parse_fabric_header,
	If(Constrain('hdr.ethernet.etherType', :==:(ConstantValue(33024))), parse_vlan,
	If(Constrain('hdr.ethernet.etherType', :==:(ConstantValue(37120))), parse_qinq,
	If(Constrain('hdr.ethernet.etherType', :==:(ConstantValue(34887))), parse_mpls,
	If(Constrain('hdr.ethernet.etherType', :==:(ConstantValue(2048))), parse_ipv4,
	If(Constrain('hdr.ethernet.etherType', :==:(ConstantValue(34525))), parse_ipv6,
	If(Constrain('hdr.ethernet.etherType', :==:(ConstantValue(2054))), parse_arp_rarp,
	If(Constrain('hdr.ethernet.etherType', :==:(ConstantValue(35020))), parse_set_prio_high,
	If(Constrain('hdr.ethernet.etherType', :==:(ConstantValue(34825))), parse_set_prio_high,
	accept)))))))))))
)


val parse_fabric_header = InstructionBlock(
	// extract hdr.fabric_header
	Assign('hdr.fabric_header.isValid', ConstantValue(1)),
	Assign('hdr.fabric_header.packetType', SymbolicValue()),
	Assign('hdr.fabric_header.headerVersion', SymbolicValue()),
	Assign('hdr.fabric_header.packetVersion', SymbolicValue()),
	Assign('hdr.fabric_header.pad1', SymbolicValue()),
	Assign('hdr.fabric_header.fabricColor', SymbolicValue()),
	Assign('hdr.fabric_header.fabricQos', SymbolicValue()),
	Assign('hdr.fabric_header.dstDevice', SymbolicValue()),
	Assign('hdr.fabric_header.dstPortOrGroup', SymbolicValue()),
	If(Constrain('hdr.fabric_header.packetType', :==:(ConstantValue(1))), parse_fabric_header_unicast,
	If(Constrain('hdr.fabric_header.packetType', :==:(ConstantValue(2))), parse_fabric_header_multicast,
	If(Constrain('hdr.fabric_header.packetType', :==:(ConstantValue(3))), parse_fabric_header_mirror,
	If(Constrain('hdr.fabric_header.packetType', :==:(ConstantValue(5))), parse_fabric_header_cpu,
	accept))))
)


val parse_fabric_header_cpu = InstructionBlock(
	// extract hdr.fabric_header_cpu
	Assign('hdr.fabric_header_cpu.isValid', ConstantValue(1)),
	Assign('hdr.fabric_header_cpu.egressQueue', SymbolicValue()),
	Assign('hdr.fabric_header_cpu.txBypass', SymbolicValue()),
	Assign('hdr.fabric_header_cpu.reserved', SymbolicValue()),
	Assign('hdr.fabric_header_cpu.ingressPort', SymbolicValue()),
	Assign('hdr.fabric_header_cpu.ingressIfindex', SymbolicValue()),
	Assign('hdr.fabric_header_cpu.ingressBd', SymbolicValue()),
	Assign('hdr.fabric_header_cpu.reasonCode', SymbolicValue()),
	Assign('hdr.fabric_header_cpu.mcast_grp', SymbolicValue()),
	Assign('meta.ingress_metadata.bypass_lookups', :@('hdr.fabric_header_cpu.reasonCode')),
	If(Constrain('hdr.fabric_header_cpu.reasonCode', :==:(ConstantValue(4))), parse_fabric_sflow_header,
	parse_fabric_payload_header)
)


val parse_fabric_header_mirror = InstructionBlock(
	// extract hdr.fabric_header_mirror
	Assign('hdr.fabric_header_mirror.isValid', ConstantValue(1)),
	Assign('hdr.fabric_header_mirror.rewriteIndex', SymbolicValue()),
	Assign('hdr.fabric_header_mirror.egressPort', SymbolicValue()),
	Assign('hdr.fabric_header_mirror.egressQueue', SymbolicValue()),
	Assign('hdr.fabric_header_mirror.pad', SymbolicValue()),
	parse_fabric_payload_header
)


val parse_fabric_header_multicast = InstructionBlock(
	// extract hdr.fabric_header_multicast
	Assign('hdr.fabric_header_multicast.isValid', ConstantValue(1)),
	Assign('hdr.fabric_header_multicast.routed', SymbolicValue()),
	Assign('hdr.fabric_header_multicast.outerRouted', SymbolicValue()),
	Assign('hdr.fabric_header_multicast.tunnelTerminate', SymbolicValue()),
	Assign('hdr.fabric_header_multicast.ingressTunnelType', SymbolicValue()),
	Assign('hdr.fabric_header_multicast.ingressIfindex', SymbolicValue()),
	Assign('hdr.fabric_header_multicast.ingressBd', SymbolicValue()),
	Assign('hdr.fabric_header_multicast.mcastGrp', SymbolicValue()),
	parse_fabric_payload_header
)


val parse_fabric_header_unicast = InstructionBlock(
	// extract hdr.fabric_header_unicast
	Assign('hdr.fabric_header_unicast.isValid', ConstantValue(1)),
	Assign('hdr.fabric_header_unicast.routed', SymbolicValue()),
	Assign('hdr.fabric_header_unicast.outerRouted', SymbolicValue()),
	Assign('hdr.fabric_header_unicast.tunnelTerminate', SymbolicValue()),
	Assign('hdr.fabric_header_unicast.ingressTunnelType', SymbolicValue()),
	Assign('hdr.fabric_header_unicast.nexthopIndex', SymbolicValue()),
	parse_fabric_payload_header
)


val parse_fabric_payload_header = InstructionBlock(
	// extract hdr.fabric_payload_header
	Assign('hdr.fabric_payload_header.isValid', ConstantValue(1)),
	Assign('hdr.fabric_payload_header.etherType', SymbolicValue()),
	//TODO: MASK
If(Constrain('hdr.fabric_payload_header.etherType', :==:(ConstantValue(33024))), parse_vlan,
	If(Constrain('hdr.fabric_payload_header.etherType', :==:(ConstantValue(37120))), parse_qinq,
	If(Constrain('hdr.fabric_payload_header.etherType', :==:(ConstantValue(34887))), parse_mpls,
	If(Constrain('hdr.fabric_payload_header.etherType', :==:(ConstantValue(2048))), parse_ipv4,
	If(Constrain('hdr.fabric_payload_header.etherType', :==:(ConstantValue(34525))), parse_ipv6,
	If(Constrain('hdr.fabric_payload_header.etherType', :==:(ConstantValue(2054))), parse_arp_rarp,
	If(Constrain('hdr.fabric_payload_header.etherType', :==:(ConstantValue(35020))), parse_set_prio_high,
	If(Constrain('hdr.fabric_payload_header.etherType', :==:(ConstantValue(34825))), parse_set_prio_high,
	accept))))))))))
)


val parse_fabric_sflow_header = InstructionBlock(
	// extract hdr.fabric_header_sflow
	Assign('hdr.fabric_header_sflow.isValid', ConstantValue(1)),
	Assign('hdr.fabric_header_sflow.sflow_session_id', SymbolicValue()),
	Assign('hdr.fabric_header_sflow.sflow_egress_ifindex', SymbolicValue()),
	parse_fabric_payload_header
)


val parse_fcoe = InstructionBlock(
	// extract hdr.fcoe
	Assign('hdr.fcoe.isValid', ConstantValue(1)),
	Assign('hdr.fcoe.version', SymbolicValue()),
	Assign('hdr.fcoe.type_', SymbolicValue()),
	Assign('hdr.fcoe.sof', SymbolicValue()),
	Assign('hdr.fcoe.rsvd1', SymbolicValue()),
	Assign('hdr.fcoe.ts_upper', SymbolicValue()),
	Assign('hdr.fcoe.ts_lower', SymbolicValue()),
	Assign('hdr.fcoe.size_', SymbolicValue()),
	Assign('hdr.fcoe.eof', SymbolicValue()),
	Assign('hdr.fcoe.rsvd2', SymbolicValue()),
	accept
)


val parse_geneve = InstructionBlock(
	// extract hdr.genv
	Assign('hdr.genv.isValid', ConstantValue(1)),
	Assign('hdr.genv.ver', SymbolicValue()),
	Assign('hdr.genv.optLen', SymbolicValue()),
	Assign('hdr.genv.oam', SymbolicValue()),
	Assign('hdr.genv.critical', SymbolicValue()),
	Assign('hdr.genv.reserved', SymbolicValue()),
	Assign('hdr.genv.protoType', SymbolicValue()),
	Assign('hdr.genv.vni', SymbolicValue()),
	Assign('hdr.genv.reserved2', SymbolicValue()),
	Assign('meta.tunnel_metadata.tunnel_vni', :@('hdr.genv.vni')),
	Assign('meta.tunnel_metadata.ingress_tunnel_type', ConstantValue(4)),
	Allocate('selectedMultipleParam'),
	Assign('selectedMultipleParam', ConstantValue(0)),
	If(Constrain('selectedMultipleParam', :==:(ConstantValue(0))), 
		If(Constrain('hdr.genv.ver', :==:(ConstantValue(0))), 
		If(Constrain('hdr.genv.optLen', :==:(ConstantValue(0))), 
		If(Constrain('hdr.genv.protoType', :==:(ConstantValue(25944))), 
		InstructionBlock(Assign('selectedMultipleParam', ConstantValue(1)), parse_inner_ethernet))))),
	If(Constrain('selectedMultipleParam', :==:(ConstantValue(0))), 
		If(Constrain('hdr.genv.ver', :==:(ConstantValue(0))), 
		If(Constrain('hdr.genv.optLen', :==:(ConstantValue(0))), 
		If(Constrain('hdr.genv.protoType', :==:(ConstantValue(2048))), 
		InstructionBlock(Assign('selectedMultipleParam', ConstantValue(1)), parse_inner_ipv4))))),
	If(Constrain('selectedMultipleParam', :==:(ConstantValue(0))), 
		If(Constrain('hdr.genv.ver', :==:(ConstantValue(0))), 
		If(Constrain('hdr.genv.optLen', :==:(ConstantValue(0))), 
		If(Constrain('hdr.genv.protoType', :==:(ConstantValue(34525))), 
		InstructionBlock(Assign('selectedMultipleParam', ConstantValue(1)), parse_inner_ipv6))))),
	If(Constrain('selectedMultipleParam', :==:(ConstantValue(0))),
		InstructionBlock(Assign('selectedMultipleParam', ConstantValue(1)), accept)),
	Deallocate('selectedMultipleParam')
)


val parse_gpe_int_header = InstructionBlock(
	// extract hdr.vxlan_gpe_int_header
	Assign('hdr.vxlan_gpe_int_header.isValid', ConstantValue(1)),
	Assign('hdr.vxlan_gpe_int_header.int_type', SymbolicValue()),
	Assign('hdr.vxlan_gpe_int_header.rsvd', SymbolicValue()),
	Assign('hdr.vxlan_gpe_int_header.len', SymbolicValue()),
	Assign('hdr.vxlan_gpe_int_header.next_proto', SymbolicValue()),
	Assign('meta.int_metadata.gpe_int_hdr_len', :@('hdr.vxlan_gpe_int_header.len')),
	parse_int_header
)


val parse_gre = InstructionBlock(
	// extract hdr.gre
	Assign('hdr.gre.isValid', ConstantValue(1)),
	Assign('hdr.gre.C', SymbolicValue()),
	Assign('hdr.gre.R', SymbolicValue()),
	Assign('hdr.gre.K', SymbolicValue()),
	Assign('hdr.gre.S', SymbolicValue()),
	Assign('hdr.gre.s', SymbolicValue()),
	Assign('hdr.gre.recurse', SymbolicValue()),
	Assign('hdr.gre.flags', SymbolicValue()),
	Assign('hdr.gre.ver', SymbolicValue()),
	Assign('hdr.gre.proto', SymbolicValue()),
	Allocate('selectedMultipleParam'),
	Assign('selectedMultipleParam', ConstantValue(0)),
	If(Constrain('selectedMultipleParam', :==:(ConstantValue(0))), 
		If(Constrain('hdr.gre.C', :==:(ConstantValue(0))), 
		If(Constrain('hdr.gre.R', :==:(ConstantValue(0))), 
		If(Constrain('hdr.gre.K', :==:(ConstantValue(1))), 
		If(Constrain('hdr.gre.S', :==:(ConstantValue(0))), 
		If(Constrain('hdr.gre.s', :==:(ConstantValue(0))), 
		If(Constrain('hdr.gre.recurse', :==:(ConstantValue(0))), 
		If(Constrain('hdr.gre.flags', :==:(ConstantValue(0))), 
		If(Constrain('hdr.gre.ver', :==:(ConstantValue(0))), 
		If(Constrain('hdr.gre.proto', :==:(ConstantValue(25944))), 
		InstructionBlock(Assign('selectedMultipleParam', ConstantValue(1)), parse_nvgre))))))))))),
	If(Constrain('selectedMultipleParam', :==:(ConstantValue(0))), 
		If(Constrain('hdr.gre.C', :==:(ConstantValue(0))), 
		If(Constrain('hdr.gre.R', :==:(ConstantValue(0))), 
		If(Constrain('hdr.gre.K', :==:(ConstantValue(0))), 
		If(Constrain('hdr.gre.S', :==:(ConstantValue(0))), 
		If(Constrain('hdr.gre.s', :==:(ConstantValue(0))), 
		If(Constrain('hdr.gre.recurse', :==:(ConstantValue(0))), 
		If(Constrain('hdr.gre.flags', :==:(ConstantValue(0))), 
		If(Constrain('hdr.gre.ver', :==:(ConstantValue(0))), 
		If(Constrain('hdr.gre.proto', :==:(ConstantValue(2048))), 
		InstructionBlock(Assign('selectedMultipleParam', ConstantValue(1)), parse_gre_ipv4))))))))))),
	If(Constrain('selectedMultipleParam', :==:(ConstantValue(0))), 
		If(Constrain('hdr.gre.C', :==:(ConstantValue(0))), 
		If(Constrain('hdr.gre.R', :==:(ConstantValue(0))), 
		If(Constrain('hdr.gre.K', :==:(ConstantValue(0))), 
		If(Constrain('hdr.gre.S', :==:(ConstantValue(0))), 
		If(Constrain('hdr.gre.s', :==:(ConstantValue(0))), 
		If(Constrain('hdr.gre.recurse', :==:(ConstantValue(0))), 
		If(Constrain('hdr.gre.flags', :==:(ConstantValue(0))), 
		If(Constrain('hdr.gre.ver', :==:(ConstantValue(0))), 
		If(Constrain('hdr.gre.proto', :==:(ConstantValue(34525))), 
		InstructionBlock(Assign('selectedMultipleParam', ConstantValue(1)), parse_gre_ipv6))))))))))),
	If(Constrain('selectedMultipleParam', :==:(ConstantValue(0))), 
		If(Constrain('hdr.gre.C', :==:(ConstantValue(0))), 
		If(Constrain('hdr.gre.R', :==:(ConstantValue(0))), 
		If(Constrain('hdr.gre.K', :==:(ConstantValue(0))), 
		If(Constrain('hdr.gre.S', :==:(ConstantValue(0))), 
		If(Constrain('hdr.gre.s', :==:(ConstantValue(0))), 
		If(Constrain('hdr.gre.recurse', :==:(ConstantValue(0))), 
		If(Constrain('hdr.gre.flags', :==:(ConstantValue(0))), 
		If(Constrain('hdr.gre.ver', :==:(ConstantValue(0))), 
		If(Constrain('hdr.gre.proto', :==:(ConstantValue(8939))), 
		InstructionBlock(Assign('selectedMultipleParam', ConstantValue(1)), parse_erspan_t3))))))))))),
	If(Constrain('selectedMultipleParam', :==:(ConstantValue(0))),
		InstructionBlock(Assign('selectedMultipleParam', ConstantValue(1)), accept)),
	Deallocate('selectedMultipleParam')
)


val parse_gre_ipv4 = InstructionBlock(
	Assign('meta.tunnel_metadata.ingress_tunnel_type', ConstantValue(2)),
	parse_inner_ipv4
)


val parse_gre_ipv6 = InstructionBlock(
	Assign('meta.tunnel_metadata.ingress_tunnel_type', ConstantValue(2)),
	parse_inner_ipv6
)


val parse_gre_v6 = InstructionBlock(
	// extract hdr.gre
	Assign('hdr.gre.isValid', ConstantValue(1)),
	Assign('hdr.gre.C', SymbolicValue()),
	Assign('hdr.gre.R', SymbolicValue()),
	Assign('hdr.gre.K', SymbolicValue()),
	Assign('hdr.gre.S', SymbolicValue()),
	Assign('hdr.gre.s', SymbolicValue()),
	Assign('hdr.gre.recurse', SymbolicValue()),
	Assign('hdr.gre.flags', SymbolicValue()),
	Assign('hdr.gre.ver', SymbolicValue()),
	Assign('hdr.gre.proto', SymbolicValue()),
	Allocate('selectedMultipleParam'),
	Assign('selectedMultipleParam', ConstantValue(0)),
	If(Constrain('selectedMultipleParam', :==:(ConstantValue(0))), 
		If(Constrain('hdr.gre.C', :==:(ConstantValue(0))), 
		If(Constrain('hdr.gre.R', :==:(ConstantValue(0))), 
		If(Constrain('hdr.gre.K', :==:(ConstantValue(0))), 
		If(Constrain('hdr.gre.S', :==:(ConstantValue(0))), 
		If(Constrain('hdr.gre.s', :==:(ConstantValue(0))), 
		If(Constrain('hdr.gre.recurse', :==:(ConstantValue(0))), 
		If(Constrain('hdr.gre.flags', :==:(ConstantValue(0))), 
		If(Constrain('hdr.gre.ver', :==:(ConstantValue(0))), 
		If(Constrain('hdr.gre.proto', :==:(ConstantValue(2048))), 
		InstructionBlock(Assign('selectedMultipleParam', ConstantValue(1)), parse_gre_ipv4))))))))))),
	If(Constrain('selectedMultipleParam', :==:(ConstantValue(0))),
		InstructionBlock(Assign('selectedMultipleParam', ConstantValue(1)), accept)),
	Deallocate('selectedMultipleParam')
)


val parse_icmp = InstructionBlock(
	// extract hdr.icmp
	Assign('hdr.icmp.isValid', ConstantValue(1)),
	Assign('hdr.icmp.typeCode', SymbolicValue()),
	Assign('hdr.icmp.hdrChecksum', SymbolicValue()),
	Assign('meta.l3_metadata.lkp_outer_l4_sport', :@('hdr.icmp.typeCode')),
	//TODO: MASK
accept)))
)


val parse_inner_ethernet = InstructionBlock(
	// extract hdr.inner_ethernet
	Assign('hdr.inner_ethernet.isValid', ConstantValue(1)),
	Assign('hdr.inner_ethernet.dstAddr', SymbolicValue()),
	Assign('hdr.inner_ethernet.srcAddr', SymbolicValue()),
	Assign('hdr.inner_ethernet.etherType', SymbolicValue()),
	Assign('meta.l2_metadata.lkp_mac_sa', :@('hdr.inner_ethernet.srcAddr')),
	Assign('meta.l2_metadata.lkp_mac_da', :@('hdr.inner_ethernet.dstAddr')),
	If(Constrain('hdr.inner_ethernet.etherType', :==:(ConstantValue(2048))), parse_inner_ipv4,
	If(Constrain('hdr.inner_ethernet.etherType', :==:(ConstantValue(34525))), parse_inner_ipv6,
	accept))
)


val parse_inner_icmp = InstructionBlock(
	// extract hdr.inner_icmp
	Assign('hdr.inner_icmp.isValid', ConstantValue(1)),
	Assign('hdr.inner_icmp.typeCode', SymbolicValue()),
	Assign('hdr.inner_icmp.hdrChecksum', SymbolicValue()),
	Assign('meta.l3_metadata.lkp_l4_sport', :@('hdr.inner_icmp.typeCode')),
	accept
)


val parse_inner_ipv4 = InstructionBlock(
	// extract hdr.inner_ipv4
	Assign('hdr.inner_ipv4.isValid', ConstantValue(1)),
	Assign('hdr.inner_ipv4.version', SymbolicValue()),
	Assign('hdr.inner_ipv4.ihl', SymbolicValue()),
	Assign('hdr.inner_ipv4.diffserv', SymbolicValue()),
	Assign('hdr.inner_ipv4.totalLen', SymbolicValue()),
	Assign('hdr.inner_ipv4.identification', SymbolicValue()),
	Assign('hdr.inner_ipv4.flags', SymbolicValue()),
	Assign('hdr.inner_ipv4.fragOffset', SymbolicValue()),
	Assign('hdr.inner_ipv4.ttl', SymbolicValue()),
	Assign('hdr.inner_ipv4.protocol', SymbolicValue()),
	Assign('hdr.inner_ipv4.hdrChecksum', SymbolicValue()),
	Assign('hdr.inner_ipv4.srcAddr', SymbolicValue()),
	Assign('hdr.inner_ipv4.dstAddr', SymbolicValue()),
	Assign('meta.ipv4_metadata.lkp_ipv4_sa', :@('hdr.inner_ipv4.srcAddr')),
	Assign('meta.ipv4_metadata.lkp_ipv4_da', :@('hdr.inner_ipv4.dstAddr')),
	Assign('meta.l3_metadata.lkp_ip_proto', :@('hdr.inner_ipv4.protocol')),
	Assign('meta.l3_metadata.lkp_ip_ttl', :@('hdr.inner_ipv4.ttl')),
	Allocate('selectedMultipleParam'),
	Assign('selectedMultipleParam', ConstantValue(0)),
	If(Constrain('selectedMultipleParam', :==:(ConstantValue(0))), 
		If(Constrain('hdr.inner_ipv4.fragOffset', :==:(ConstantValue(0))), 
		If(Constrain('hdr.inner_ipv4.ihl', :==:(ConstantValue(5))), 
		If(Constrain('hdr.inner_ipv4.protocol', :==:(ConstantValue(1))), 
		InstructionBlock(Assign('selectedMultipleParam', ConstantValue(1)), parse_inner_icmp))))),
	If(Constrain('selectedMultipleParam', :==:(ConstantValue(0))), 
		If(Constrain('hdr.inner_ipv4.fragOffset', :==:(ConstantValue(0))), 
		If(Constrain('hdr.inner_ipv4.ihl', :==:(ConstantValue(5))), 
		If(Constrain('hdr.inner_ipv4.protocol', :==:(ConstantValue(6))), 
		InstructionBlock(Assign('selectedMultipleParam', ConstantValue(1)), parse_inner_tcp))))),
	If(Constrain('selectedMultipleParam', :==:(ConstantValue(0))), 
		If(Constrain('hdr.inner_ipv4.fragOffset', :==:(ConstantValue(0))), 
		If(Constrain('hdr.inner_ipv4.ihl', :==:(ConstantValue(5))), 
		If(Constrain('hdr.inner_ipv4.protocol', :==:(ConstantValue(17))), 
		InstructionBlock(Assign('selectedMultipleParam', ConstantValue(1)), parse_inner_udp))))),
	If(Constrain('selectedMultipleParam', :==:(ConstantValue(0))),
		InstructionBlock(Assign('selectedMultipleParam', ConstantValue(1)), accept)),
	Deallocate('selectedMultipleParam')
)


val parse_inner_ipv6 = InstructionBlock(
	// extract hdr.inner_ipv6
	Assign('hdr.inner_ipv6.isValid', ConstantValue(1)),
	Assign('hdr.inner_ipv6.version', SymbolicValue()),
	Assign('hdr.inner_ipv6.trafficClass', SymbolicValue()),
	Assign('hdr.inner_ipv6.flowLabel', SymbolicValue()),
	Assign('hdr.inner_ipv6.payloadLen', SymbolicValue()),
	Assign('hdr.inner_ipv6.nextHdr', SymbolicValue()),
	Assign('hdr.inner_ipv6.hopLimit', SymbolicValue()),
	Assign('hdr.inner_ipv6.srcAddr', SymbolicValue()),
	Assign('hdr.inner_ipv6.dstAddr', SymbolicValue()),
	Assign('meta.ipv6_metadata.lkp_ipv6_sa', :@('hdr.inner_ipv6.srcAddr')),
	Assign('meta.ipv6_metadata.lkp_ipv6_da', :@('hdr.inner_ipv6.dstAddr')),
	Assign('meta.l3_metadata.lkp_ip_proto', :@('hdr.inner_ipv6.nextHdr')),
	Assign('meta.l3_metadata.lkp_ip_ttl', :@('hdr.inner_ipv6.hopLimit')),
	If(Constrain('hdr.inner_ipv6.nextHdr', :==:(ConstantValue(58))), parse_inner_icmp,
	If(Constrain('hdr.inner_ipv6.nextHdr', :==:(ConstantValue(6))), parse_inner_tcp,
	If(Constrain('hdr.inner_ipv6.nextHdr', :==:(ConstantValue(17))), parse_inner_udp,
	accept)))
)


val parse_inner_sctp = InstructionBlock(
	// extract hdr.inner_sctp
	Assign('hdr.inner_sctp.isValid', ConstantValue(1)),
	Assign('hdr.inner_sctp.srcPort', SymbolicValue()),
	Assign('hdr.inner_sctp.dstPort', SymbolicValue()),
	Assign('hdr.inner_sctp.verifTag', SymbolicValue()),
	Assign('hdr.inner_sctp.checksum', SymbolicValue()),
	accept
)


val parse_inner_tcp = InstructionBlock(
	// extract hdr.inner_tcp
	Assign('hdr.inner_tcp.isValid', ConstantValue(1)),
	Assign('hdr.inner_tcp.srcPort', SymbolicValue()),
	Assign('hdr.inner_tcp.dstPort', SymbolicValue()),
	Assign('hdr.inner_tcp.seqNo', SymbolicValue()),
	Assign('hdr.inner_tcp.ackNo', SymbolicValue()),
	Assign('hdr.inner_tcp.dataOffset', SymbolicValue()),
	Assign('hdr.inner_tcp.res', SymbolicValue()),
	Assign('hdr.inner_tcp.flags', SymbolicValue()),
	Assign('hdr.inner_tcp.window', SymbolicValue()),
	Assign('hdr.inner_tcp.checksum', SymbolicValue()),
	Assign('hdr.inner_tcp.urgentPtr', SymbolicValue()),
	Assign('meta.l3_metadata.lkp_l4_sport', :@('hdr.inner_tcp.srcPort')),
	Assign('meta.l3_metadata.lkp_l4_dport', :@('hdr.inner_tcp.dstPort')),
	accept
)


val parse_inner_udp = InstructionBlock(
	// extract hdr.inner_udp
	Assign('hdr.inner_udp.isValid', ConstantValue(1)),
	Assign('hdr.inner_udp.srcPort', SymbolicValue()),
	Assign('hdr.inner_udp.dstPort', SymbolicValue()),
	Assign('hdr.inner_udp.length_', SymbolicValue()),
	Assign('hdr.inner_udp.checksum', SymbolicValue()),
	Assign('meta.l3_metadata.lkp_l4_sport', :@('hdr.inner_udp.srcPort')),
	Assign('meta.l3_metadata.lkp_l4_dport', :@('hdr.inner_udp.dstPort')),
	accept
)


val parse_int_header = InstructionBlock(
	// extract hdr.int_header
	Assign('hdr.int_header.isValid', ConstantValue(1)),
	Assign('hdr.int_header.ver', SymbolicValue()),
	Assign('hdr.int_header.rep', SymbolicValue()),
	Assign('hdr.int_header.c', SymbolicValue()),
	Assign('hdr.int_header.e', SymbolicValue()),
	Assign('hdr.int_header.rsvd1', SymbolicValue()),
	Assign('hdr.int_header.ins_cnt', SymbolicValue()),
	Assign('hdr.int_header.max_hop_cnt', SymbolicValue()),
	Assign('hdr.int_header.total_hop_cnt', SymbolicValue()),
	Assign('hdr.int_header.instruction_mask_0003', SymbolicValue()),
	Assign('hdr.int_header.instruction_mask_0407', SymbolicValue()),
	Assign('hdr.int_header.instruction_mask_0811', SymbolicValue()),
	Assign('hdr.int_header.instruction_mask_1215', SymbolicValue()),
	Assign('hdr.int_header.rsvd2', SymbolicValue()),
	Assign('meta.int_metadata.instruction_cnt', :@('hdr.int_header.ins_cnt')),
	Allocate('selectedMultipleParam'),
	Assign('selectedMultipleParam', ConstantValue(0)),
	If(Constrain('selectedMultipleParam', :==:(ConstantValue(0))), 
		If(Constrain('hdr.int_header.rsvd1', :==:(ConstantValue(0))), 
		If(Constrain('hdr.int_header.total_hop_cnt', :==:(ConstantValue(0))), 
		InstructionBlock(Assign('selectedMultipleParam', ConstantValue(1)), accept)))),
	If(Constrain('selectedMultipleParam', :==:(ConstantValue(0))), 
		//TODO: MASK
//TODO: MASK
InstructionBlock(Assign('selectedMultipleParam', ConstantValue(1)), parse_int_val)))),
	If(Constrain('selectedMultipleParam', :==:(ConstantValue(0))),
		InstructionBlock(Assign('selectedMultipleParam', ConstantValue(1)), accept)),
	If(Constrain('selectedMultipleParam', :==:(ConstantValue(0))),
		InstructionBlock(Assign('selectedMultipleParam', ConstantValue(1)), parse_all_int_meta_value_heders)),
	Deallocate('selectedMultipleParam')
)


val parse_int_val = InstructionBlock(
	// extract hdr.int_val.next
	If('int_valIndex', :==:(ConstantValue(0)),
		instructionBlock(
			Assign('int_val_0.isValid', ConstantValue(1)),
			Assign('int_val_0.bos', SymbolicValue()),
			Assign('int_val_0.val', SymbolicValue())),
	If('int_valIndex', :==:(ConstantValue(1)),
		instructionBlock(
			Assign('int_val_1.isValid', ConstantValue(1)),
			Assign('int_val_1.bos', SymbolicValue()),
			Assign('int_val_1.val', SymbolicValue())),
	If('int_valIndex', :==:(ConstantValue(2)),
		instructionBlock(
			Assign('int_val_2.isValid', ConstantValue(1)),
			Assign('int_val_2.bos', SymbolicValue()),
			Assign('int_val_2.val', SymbolicValue())),
	If('int_valIndex', :==:(ConstantValue(3)),
		instructionBlock(
			Assign('int_val_3.isValid', ConstantValue(1)),
			Assign('int_val_3.bos', SymbolicValue()),
			Assign('int_val_3.val', SymbolicValue())),
	If('int_valIndex', :==:(ConstantValue(4)),
		instructionBlock(
			Assign('int_val_4.isValid', ConstantValue(1)),
			Assign('int_val_4.bos', SymbolicValue()),
			Assign('int_val_4.val', SymbolicValue())),
	If('int_valIndex', :==:(ConstantValue(5)),
		instructionBlock(
			Assign('int_val_5.isValid', ConstantValue(1)),
			Assign('int_val_5.bos', SymbolicValue()),
			Assign('int_val_5.val', SymbolicValue())),
	If('int_valIndex', :==:(ConstantValue(6)),
		instructionBlock(
			Assign('int_val_6.isValid', ConstantValue(1)),
			Assign('int_val_6.bos', SymbolicValue()),
			Assign('int_val_6.val', SymbolicValue())),
	If('int_valIndex', :==:(ConstantValue(7)),
		instructionBlock(
			Assign('int_val_7.isValid', ConstantValue(1)),
			Assign('int_val_7.bos', SymbolicValue()),
			Assign('int_val_7.val', SymbolicValue())),
	If('int_valIndex', :==:(ConstantValue(8)),
		instructionBlock(
			Assign('int_val_8.isValid', ConstantValue(1)),
			Assign('int_val_8.bos', SymbolicValue()),
			Assign('int_val_8.val', SymbolicValue())),
	If('int_valIndex', :==:(ConstantValue(9)),
		instructionBlock(
			Assign('int_val_9.isValid', ConstantValue(1)),
			Assign('int_val_9.bos', SymbolicValue()),
			Assign('int_val_9.val', SymbolicValue())),
	If('int_valIndex', :==:(ConstantValue(10)),
		instructionBlock(
			Assign('int_val_10.isValid', ConstantValue(1)),
			Assign('int_val_10.bos', SymbolicValue()),
			Assign('int_val_10.val', SymbolicValue())),
	If('int_valIndex', :==:(ConstantValue(11)),
		instructionBlock(
			Assign('int_val_11.isValid', ConstantValue(1)),
			Assign('int_val_11.bos', SymbolicValue()),
			Assign('int_val_11.val', SymbolicValue())),
	If('int_valIndex', :==:(ConstantValue(12)),
		instructionBlock(
			Assign('int_val_12.isValid', ConstantValue(1)),
			Assign('int_val_12.bos', SymbolicValue()),
			Assign('int_val_12.val', SymbolicValue())),
	If('int_valIndex', :==:(ConstantValue(13)),
		instructionBlock(
			Assign('int_val_13.isValid', ConstantValue(1)),
			Assign('int_val_13.bos', SymbolicValue()),
			Assign('int_val_13.val', SymbolicValue())),
	If('int_valIndex', :==:(ConstantValue(14)),
		instructionBlock(
			Assign('int_val_14.isValid', ConstantValue(1)),
			Assign('int_val_14.bos', SymbolicValue()),
			Assign('int_val_14.val', SymbolicValue())),
	If('int_valIndex', :==:(ConstantValue(15)),
		instructionBlock(
			Assign('int_val_15.isValid', ConstantValue(1)),
			Assign('int_val_15.bos', SymbolicValue()),
			Assign('int_val_15.val', SymbolicValue())),
	If('int_valIndex', :==:(ConstantValue(16)),
		instructionBlock(
			Assign('int_val_16.isValid', ConstantValue(1)),
			Assign('int_val_16.bos', SymbolicValue()),
			Assign('int_val_16.val', SymbolicValue())),
	If('int_valIndex', :==:(ConstantValue(17)),
		instructionBlock(
			Assign('int_val_17.isValid', ConstantValue(1)),
			Assign('int_val_17.bos', SymbolicValue()),
			Assign('int_val_17.val', SymbolicValue())),
	If('int_valIndex', :==:(ConstantValue(18)),
		instructionBlock(
			Assign('int_val_18.isValid', ConstantValue(1)),
			Assign('int_val_18.bos', SymbolicValue()),
			Assign('int_val_18.val', SymbolicValue())),
	If('int_valIndex', :==:(ConstantValue(19)),
		instructionBlock(
			Assign('int_val_19.isValid', ConstantValue(1)),
			Assign('int_val_19.bos', SymbolicValue()),
			Assign('int_val_19.val', SymbolicValue())),
	If('int_valIndex', :==:(ConstantValue(20)),
		instructionBlock(
			Assign('int_val_20.isValid', ConstantValue(1)),
			Assign('int_val_20.bos', SymbolicValue()),
			Assign('int_val_20.val', SymbolicValue())),
	If('int_valIndex', :==:(ConstantValue(21)),
		instructionBlock(
			Assign('int_val_21.isValid', ConstantValue(1)),
			Assign('int_val_21.bos', SymbolicValue()),
			Assign('int_val_21.val', SymbolicValue())),
	If('int_valIndex', :==:(ConstantValue(22)),
		instructionBlock(
			Assign('int_val_22.isValid', ConstantValue(1)),
			Assign('int_val_22.bos', SymbolicValue()),
			Assign('int_val_22.val', SymbolicValue())),
	If('int_valIndex', :==:(ConstantValue(23)),
		instructionBlock(
			Assign('int_val_23.isValid', ConstantValue(1)),
			Assign('int_val_23.bos', SymbolicValue()),
			Assign('int_val_23.val', SymbolicValue())))))))))))))))))))))))))),
	Assign('int_valIndex', :+:('int_valIndex',ConstantValue(1))),
	If(Constrain('hdr.int_val.last.bos', :==:(ConstantValue(0))), parse_int_val,
	If(Constrain('hdr.int_val.last.bos', :==:(ConstantValue(1))), parse_inner_ethernet,
	)
)


val parse_ipv4 = InstructionBlock(
	// extract hdr.ipv4
	Assign('hdr.ipv4.isValid', ConstantValue(1)),
	Assign('hdr.ipv4.version', SymbolicValue()),
	Assign('hdr.ipv4.ihl', SymbolicValue()),
	Assign('hdr.ipv4.diffserv', SymbolicValue()),
	Assign('hdr.ipv4.totalLen', SymbolicValue()),
	Assign('hdr.ipv4.identification', SymbolicValue()),
	Assign('hdr.ipv4.flags', SymbolicValue()),
	Assign('hdr.ipv4.fragOffset', SymbolicValue()),
	Assign('hdr.ipv4.ttl', SymbolicValue()),
	Assign('hdr.ipv4.protocol', SymbolicValue()),
	Assign('hdr.ipv4.hdrChecksum', SymbolicValue()),
	Assign('hdr.ipv4.srcAddr', SymbolicValue()),
	Assign('hdr.ipv4.dstAddr', SymbolicValue()),
	Allocate('selectedMultipleParam'),
	Assign('selectedMultipleParam', ConstantValue(0)),
	If(Constrain('selectedMultipleParam', :==:(ConstantValue(0))), 
		If(Constrain('hdr.ipv4.fragOffset', :==:(ConstantValue(0))), 
		If(Constrain('hdr.ipv4.ihl', :==:(ConstantValue(5))), 
		If(Constrain('hdr.ipv4.protocol', :==:(ConstantValue(1))), 
		InstructionBlock(Assign('selectedMultipleParam', ConstantValue(1)), parse_icmp))))),
	If(Constrain('selectedMultipleParam', :==:(ConstantValue(0))), 
		If(Constrain('hdr.ipv4.fragOffset', :==:(ConstantValue(0))), 
		If(Constrain('hdr.ipv4.ihl', :==:(ConstantValue(5))), 
		If(Constrain('hdr.ipv4.protocol', :==:(ConstantValue(6))), 
		InstructionBlock(Assign('selectedMultipleParam', ConstantValue(1)), parse_tcp))))),
	If(Constrain('selectedMultipleParam', :==:(ConstantValue(0))), 
		If(Constrain('hdr.ipv4.fragOffset', :==:(ConstantValue(0))), 
		If(Constrain('hdr.ipv4.ihl', :==:(ConstantValue(5))), 
		If(Constrain('hdr.ipv4.protocol', :==:(ConstantValue(17))), 
		InstructionBlock(Assign('selectedMultipleParam', ConstantValue(1)), parse_udp))))),
	If(Constrain('selectedMultipleParam', :==:(ConstantValue(0))), 
		If(Constrain('hdr.ipv4.fragOffset', :==:(ConstantValue(0))), 
		If(Constrain('hdr.ipv4.ihl', :==:(ConstantValue(5))), 
		If(Constrain('hdr.ipv4.protocol', :==:(ConstantValue(47))), 
		InstructionBlock(Assign('selectedMultipleParam', ConstantValue(1)), parse_gre))))),
	If(Constrain('selectedMultipleParam', :==:(ConstantValue(0))), 
		If(Constrain('hdr.ipv4.fragOffset', :==:(ConstantValue(0))), 
		If(Constrain('hdr.ipv4.ihl', :==:(ConstantValue(5))), 
		If(Constrain('hdr.ipv4.protocol', :==:(ConstantValue(4))), 
		InstructionBlock(Assign('selectedMultipleParam', ConstantValue(1)), parse_ipv4_in_ip))))),
	If(Constrain('selectedMultipleParam', :==:(ConstantValue(0))), 
		If(Constrain('hdr.ipv4.fragOffset', :==:(ConstantValue(0))), 
		If(Constrain('hdr.ipv4.ihl', :==:(ConstantValue(5))), 
		If(Constrain('hdr.ipv4.protocol', :==:(ConstantValue(41))), 
		InstructionBlock(Assign('selectedMultipleParam', ConstantValue(1)), parse_ipv6_in_ip))))),
	If(Constrain('selectedMultipleParam', :==:(ConstantValue(0))), 
		If(Constrain('hdr.ipv4.fragOffset', :==:(ConstantValue(0))), 
		If(Constrain('hdr.ipv4.ihl', :==:(ConstantValue(0))), 
		If(Constrain('hdr.ipv4.protocol', :==:(ConstantValue(2))), 
		InstructionBlock(Assign('selectedMultipleParam', ConstantValue(1)), parse_set_prio_med))))),
	If(Constrain('selectedMultipleParam', :==:(ConstantValue(0))), 
		If(Constrain('hdr.ipv4.fragOffset', :==:(ConstantValue(0))), 
		If(Constrain('hdr.ipv4.ihl', :==:(ConstantValue(0))), 
		If(Constrain('hdr.ipv4.protocol', :==:(ConstantValue(88))), 
		InstructionBlock(Assign('selectedMultipleParam', ConstantValue(1)), parse_set_prio_med))))),
	If(Constrain('selectedMultipleParam', :==:(ConstantValue(0))), 
		If(Constrain('hdr.ipv4.fragOffset', :==:(ConstantValue(0))), 
		If(Constrain('hdr.ipv4.ihl', :==:(ConstantValue(0))), 
		If(Constrain('hdr.ipv4.protocol', :==:(ConstantValue(89))), 
		InstructionBlock(Assign('selectedMultipleParam', ConstantValue(1)), parse_set_prio_med))))),
	If(Constrain('selectedMultipleParam', :==:(ConstantValue(0))), 
		If(Constrain('hdr.ipv4.fragOffset', :==:(ConstantValue(0))), 
		If(Constrain('hdr.ipv4.ihl', :==:(ConstantValue(0))), 
		If(Constrain('hdr.ipv4.protocol', :==:(ConstantValue(103))), 
		InstructionBlock(Assign('selectedMultipleParam', ConstantValue(1)), parse_set_prio_med))))),
	If(Constrain('selectedMultipleParam', :==:(ConstantValue(0))), 
		If(Constrain('hdr.ipv4.fragOffset', :==:(ConstantValue(0))), 
		If(Constrain('hdr.ipv4.ihl', :==:(ConstantValue(0))), 
		If(Constrain('hdr.ipv4.protocol', :==:(ConstantValue(112))), 
		InstructionBlock(Assign('selectedMultipleParam', ConstantValue(1)), parse_set_prio_med))))),
	If(Constrain('selectedMultipleParam', :==:(ConstantValue(0))),
		InstructionBlock(Assign('selectedMultipleParam', ConstantValue(1)), accept)),
	Deallocate('selectedMultipleParam')
)


val parse_ipv4_in_ip = InstructionBlock(
	Assign('meta.tunnel_metadata.ingress_tunnel_type', ConstantValue(3)),
	parse_inner_ipv4
)


val parse_ipv6 = InstructionBlock(
	// extract hdr.ipv6
	Assign('hdr.ipv6.isValid', ConstantValue(1)),
	Assign('hdr.ipv6.version', SymbolicValue()),
	Assign('hdr.ipv6.trafficClass', SymbolicValue()),
	Assign('hdr.ipv6.flowLabel', SymbolicValue()),
	Assign('hdr.ipv6.payloadLen', SymbolicValue()),
	Assign('hdr.ipv6.nextHdr', SymbolicValue()),
	Assign('hdr.ipv6.hopLimit', SymbolicValue()),
	Assign('hdr.ipv6.srcAddr', SymbolicValue()),
	Assign('hdr.ipv6.dstAddr', SymbolicValue()),
	If(Constrain('hdr.ipv6.nextHdr', :==:(ConstantValue(58))), parse_icmp,
	If(Constrain('hdr.ipv6.nextHdr', :==:(ConstantValue(6))), parse_tcp,
	If(Constrain('hdr.ipv6.nextHdr', :==:(ConstantValue(4))), parse_ipv4_in_ip,
	If(Constrain('hdr.ipv6.nextHdr', :==:(ConstantValue(17))), parse_udp,
	If(Constrain('hdr.ipv6.nextHdr', :==:(ConstantValue(47))), parse_gre,
	If(Constrain('hdr.ipv6.nextHdr', :==:(ConstantValue(41))), parse_ipv6_in_ip,
	If(Constrain('hdr.ipv6.nextHdr', :==:(ConstantValue(88))), parse_set_prio_med,
	If(Constrain('hdr.ipv6.nextHdr', :==:(ConstantValue(89))), parse_set_prio_med,
	If(Constrain('hdr.ipv6.nextHdr', :==:(ConstantValue(103))), parse_set_prio_med,
	If(Constrain('hdr.ipv6.nextHdr', :==:(ConstantValue(112))), parse_set_prio_med,
	accept))))))))))
)


val parse_ipv6_in_ip = InstructionBlock(
	Assign('meta.tunnel_metadata.ingress_tunnel_type', ConstantValue(3)),
	parse_inner_ipv6
)


val parse_lisp = InstructionBlock(
	// extract hdr.lisp
	Assign('hdr.lisp.isValid', ConstantValue(1)),
	Assign('hdr.lisp.flags', SymbolicValue()),
	Assign('hdr.lisp.nonce', SymbolicValue()),
	Assign('hdr.lisp.lsbsInstanceId', SymbolicValue()),
	
)


val parse_llc_header = InstructionBlock(
	// extract hdr.llc_header
	Assign('hdr.llc_header.isValid', ConstantValue(1)),
	Assign('hdr.llc_header.dsap', SymbolicValue()),
	Assign('hdr.llc_header.ssap', SymbolicValue()),
	Assign('hdr.llc_header.control_', SymbolicValue()),
	Allocate('selectedMultipleParam'),
	Assign('selectedMultipleParam', ConstantValue(0)),
	If(Constrain('selectedMultipleParam', :==:(ConstantValue(0))), 
		If(Constrain('hdr.llc_header.dsap', :==:(ConstantValue(170))), 
		If(Constrain('hdr.llc_header.ssap', :==:(ConstantValue(170))), 
		InstructionBlock(Assign('selectedMultipleParam', ConstantValue(1)), parse_snap_header)))),
	If(Constrain('selectedMultipleParam', :==:(ConstantValue(0))), 
		If(Constrain('hdr.llc_header.dsap', :==:(ConstantValue(254))), 
		If(Constrain('hdr.llc_header.ssap', :==:(ConstantValue(254))), 
		InstructionBlock(Assign('selectedMultipleParam', ConstantValue(1)), parse_set_prio_med)))),
	If(Constrain('selectedMultipleParam', :==:(ConstantValue(0))),
		InstructionBlock(Assign('selectedMultipleParam', ConstantValue(1)), accept)),
	Deallocate('selectedMultipleParam')
)


val parse_mpls = InstructionBlock(
	// extract hdr.mpls.next
	If('mplsIndex', :==:(ConstantValue(0)),
		instructionBlock(
			Assign('mpls_0.isValid', ConstantValue(1)),
			Assign('mpls_0.label', SymbolicValue()),
			Assign('mpls_0.exp', SymbolicValue()),
			Assign('mpls_0.bos', SymbolicValue()),
			Assign('mpls_0.ttl', SymbolicValue())),
	If('mplsIndex', :==:(ConstantValue(1)),
		instructionBlock(
			Assign('mpls_1.isValid', ConstantValue(1)),
			Assign('mpls_1.label', SymbolicValue()),
			Assign('mpls_1.exp', SymbolicValue()),
			Assign('mpls_1.bos', SymbolicValue()),
			Assign('mpls_1.ttl', SymbolicValue())),
	If('mplsIndex', :==:(ConstantValue(2)),
		instructionBlock(
			Assign('mpls_2.isValid', ConstantValue(1)),
			Assign('mpls_2.label', SymbolicValue()),
			Assign('mpls_2.exp', SymbolicValue()),
			Assign('mpls_2.bos', SymbolicValue()),
			Assign('mpls_2.ttl', SymbolicValue()))))),
	Assign('mplsIndex', :+:('mplsIndex',ConstantValue(1))),
	If(Constrain('hdr.mpls.last.bos', :==:(ConstantValue(0))), parse_mpls,
	If(Constrain('hdr.mpls.last.bos', :==:(ConstantValue(1))), parse_mpls_bos,
	accept))
)


val parse_mpls_bos = InstructionBlock(
	
)


val parse_mpls_inner_ipv4 = InstructionBlock(
	Assign('meta.tunnel_metadata.ingress_tunnel_type', ConstantValue(9)),
	parse_inner_ipv4
)


val parse_mpls_inner_ipv6 = InstructionBlock(
	Assign('meta.tunnel_metadata.ingress_tunnel_type', ConstantValue(9)),
	parse_inner_ipv6
)


val parse_nsh = InstructionBlock(
	// extract hdr.nsh
	Assign('hdr.nsh.isValid', ConstantValue(1)),
	Assign('hdr.nsh.oam', SymbolicValue()),
	Assign('hdr.nsh.context', SymbolicValue()),
	Assign('hdr.nsh.flags', SymbolicValue()),
	Assign('hdr.nsh.reserved', SymbolicValue()),
	Assign('hdr.nsh.protoType', SymbolicValue()),
	Assign('hdr.nsh.spath', SymbolicValue()),
	Assign('hdr.nsh.sindex', SymbolicValue()),
	// extract hdr.nsh_context
	Assign('hdr.nsh_context.isValid', ConstantValue(1)),
	Assign('hdr.nsh_context.network_platform', SymbolicValue()),
	Assign('hdr.nsh_context.network_shared', SymbolicValue()),
	Assign('hdr.nsh_context.service_platform', SymbolicValue()),
	Assign('hdr.nsh_context.service_shared', SymbolicValue()),
	If(Constrain('hdr.nsh.protoType', :==:(ConstantValue(2048))), parse_inner_ipv4,
	If(Constrain('hdr.nsh.protoType', :==:(ConstantValue(34525))), parse_inner_ipv6,
	If(Constrain('hdr.nsh.protoType', :==:(ConstantValue(25944))), parse_inner_ethernet,
	accept)))
)


val parse_nvgre = InstructionBlock(
	// extract hdr.nvgre
	Assign('hdr.nvgre.isValid', ConstantValue(1)),
	Assign('hdr.nvgre.tni', SymbolicValue()),
	Assign('hdr.nvgre.flow_id', SymbolicValue()),
	Assign('meta.tunnel_metadata.ingress_tunnel_type', ConstantValue(5)),
	Assign('meta.tunnel_metadata.tunnel_vni', :@('hdr.nvgre.tni')),
	parse_inner_ethernet
)


val parse_pw = InstructionBlock(
	accept
)


val parse_qinq = InstructionBlock(
	// extract hdr.vlan_tag__0
	Assign('hdr.isValid', ConstantValue(1)),
	Assign('hdr._0pcp', SymbolicValue()),
	Assign('hdr._0cfi', SymbolicValue()),
	Assign('hdr._0vid', SymbolicValue()),
	Assign('hdr._0etherType', SymbolicValue()),
	If(Constrain('hdr.vlan_tag__0.etherType', :==:(ConstantValue(33024))), parse_qinq_vlan,
	accept)
)


val parse_qinq_vlan = InstructionBlock(
	// extract hdr.vlan_tag__1
	Assign('hdr.isValid', ConstantValue(1)),
	Assign('hdr._1pcp', SymbolicValue()),
	Assign('hdr._1cfi', SymbolicValue()),
	Assign('hdr._1vid', SymbolicValue()),
	Assign('hdr._1etherType', SymbolicValue()),
	If(Constrain('hdr.vlan_tag__1.etherType', :==:(ConstantValue(34887))), parse_mpls,
	If(Constrain('hdr.vlan_tag__1.etherType', :==:(ConstantValue(2048))), parse_ipv4,
	If(Constrain('hdr.vlan_tag__1.etherType', :==:(ConstantValue(34525))), parse_ipv6,
	If(Constrain('hdr.vlan_tag__1.etherType', :==:(ConstantValue(2054))), parse_arp_rarp,
	If(Constrain('hdr.vlan_tag__1.etherType', :==:(ConstantValue(35020))), parse_set_prio_high,
	If(Constrain('hdr.vlan_tag__1.etherType', :==:(ConstantValue(34825))), parse_set_prio_high,
	accept))))))
)


val parse_roce = InstructionBlock(
	// extract hdr.roce
	Assign('hdr.roce.isValid', ConstantValue(1)),
	Assign('hdr.roce.ib_grh', SymbolicValue()),
	Assign('hdr.roce.ib_bth', SymbolicValue()),
	accept
)


val parse_roce_v2 = InstructionBlock(
	// extract hdr.roce_v2
	Assign('hdr.roce_v2.isValid', ConstantValue(1)),
	Assign('hdr.roce_v2.ib_bth', SymbolicValue()),
	accept
)


val parse_sctp = InstructionBlock(
	// extract hdr.sctp
	Assign('hdr.sctp.isValid', ConstantValue(1)),
	Assign('hdr.sctp.srcPort', SymbolicValue()),
	Assign('hdr.sctp.dstPort', SymbolicValue()),
	Assign('hdr.sctp.verifTag', SymbolicValue()),
	Assign('hdr.sctp.checksum', SymbolicValue()),
	accept
)


val parse_set_prio_high = InstructionBlock(
	Assign('meta.intrinsic_metadata.priority', ConstantValue(5)),
	accept
)


val parse_set_prio_max = InstructionBlock(
	Assign('meta.intrinsic_metadata.priority', ConstantValue(7)),
	accept
)


val parse_set_prio_med = InstructionBlock(
	Assign('meta.intrinsic_metadata.priority', ConstantValue(3)),
	accept
)


val parse_sflow = InstructionBlock(
	// extract hdr.sflow
	Assign('hdr.sflow.isValid', ConstantValue(1)),
	Assign('hdr.sflow.version', SymbolicValue()),
	Assign('hdr.sflow.addrType', SymbolicValue()),
	Assign('hdr.sflow.ipAddress', SymbolicValue()),
	Assign('hdr.sflow.subAgentId', SymbolicValue()),
	Assign('hdr.sflow.seqNumber', SymbolicValue()),
	Assign('hdr.sflow.uptime', SymbolicValue()),
	Assign('hdr.sflow.numSamples', SymbolicValue()),
	accept
)


val parse_snap_header = InstructionBlock(
	// extract hdr.snap_header
	Assign('hdr.snap_header.isValid', ConstantValue(1)),
	Assign('hdr.snap_header.oui', SymbolicValue()),
	Assign('hdr.snap_header.type_', SymbolicValue()),
	If(Constrain('hdr.snap_header.type_', :==:(ConstantValue(33024))), parse_vlan,
	If(Constrain('hdr.snap_header.type_', :==:(ConstantValue(37120))), parse_qinq,
	If(Constrain('hdr.snap_header.type_', :==:(ConstantValue(34887))), parse_mpls,
	If(Constrain('hdr.snap_header.type_', :==:(ConstantValue(2048))), parse_ipv4,
	If(Constrain('hdr.snap_header.type_', :==:(ConstantValue(34525))), parse_ipv6,
	If(Constrain('hdr.snap_header.type_', :==:(ConstantValue(2054))), parse_arp_rarp,
	If(Constrain('hdr.snap_header.type_', :==:(ConstantValue(35020))), parse_set_prio_high,
	If(Constrain('hdr.snap_header.type_', :==:(ConstantValue(34825))), parse_set_prio_high,
	accept))))))))
)


val parse_tcp = InstructionBlock(
	// extract hdr.tcp
	Assign('hdr.tcp.isValid', ConstantValue(1)),
	Assign('hdr.tcp.srcPort', SymbolicValue()),
	Assign('hdr.tcp.dstPort', SymbolicValue()),
	Assign('hdr.tcp.seqNo', SymbolicValue()),
	Assign('hdr.tcp.ackNo', SymbolicValue()),
	Assign('hdr.tcp.dataOffset', SymbolicValue()),
	Assign('hdr.tcp.res', SymbolicValue()),
	Assign('hdr.tcp.flags', SymbolicValue()),
	Assign('hdr.tcp.window', SymbolicValue()),
	Assign('hdr.tcp.checksum', SymbolicValue()),
	Assign('hdr.tcp.urgentPtr', SymbolicValue()),
	Assign('meta.l3_metadata.lkp_outer_l4_sport', :@('hdr.tcp.srcPort')),
	Assign('meta.l3_metadata.lkp_outer_l4_dport', :@('hdr.tcp.dstPort')),
	If(Constrain('hdr.tcp.dstPort', :==:(ConstantValue(179))), parse_set_prio_med,
	If(Constrain('hdr.tcp.dstPort', :==:(ConstantValue(639))), parse_set_prio_med,
	accept))
)


val parse_trill = InstructionBlock(
	// extract hdr.trill
	Assign('hdr.trill.isValid', ConstantValue(1)),
	Assign('hdr.trill.version', SymbolicValue()),
	Assign('hdr.trill.reserved', SymbolicValue()),
	Assign('hdr.trill.multiDestination', SymbolicValue()),
	Assign('hdr.trill.optLength', SymbolicValue()),
	Assign('hdr.trill.hopCount', SymbolicValue()),
	Assign('hdr.trill.egressRbridge', SymbolicValue()),
	Assign('hdr.trill.ingressRbridge', SymbolicValue()),
	parse_inner_ethernet
)


val parse_udp = InstructionBlock(
	// extract hdr.udp
	Assign('hdr.udp.isValid', ConstantValue(1)),
	Assign('hdr.udp.srcPort', SymbolicValue()),
	Assign('hdr.udp.dstPort', SymbolicValue()),
	Assign('hdr.udp.length_', SymbolicValue()),
	Assign('hdr.udp.checksum', SymbolicValue()),
	Assign('meta.l3_metadata.lkp_outer_l4_sport', :@('hdr.udp.srcPort')),
	Assign('meta.l3_metadata.lkp_outer_l4_dport', :@('hdr.udp.dstPort')),
	If(Constrain('hdr.udp.dstPort', :==:(ConstantValue(4789))), parse_vxlan,
	If(Constrain('hdr.udp.dstPort', :==:(ConstantValue(6081))), parse_geneve,
	If(Constrain('hdr.udp.dstPort', :==:(ConstantValue(4790))), parse_vxlan_gpe,
	If(Constrain('hdr.udp.dstPort', :==:(ConstantValue(67))), parse_set_prio_med,
	If(Constrain('hdr.udp.dstPort', :==:(ConstantValue(68))), parse_set_prio_med,
	If(Constrain('hdr.udp.dstPort', :==:(ConstantValue(546))), parse_set_prio_med,
	If(Constrain('hdr.udp.dstPort', :==:(ConstantValue(547))), parse_set_prio_med,
	If(Constrain('hdr.udp.dstPort', :==:(ConstantValue(520))), parse_set_prio_med,
	If(Constrain('hdr.udp.dstPort', :==:(ConstantValue(521))), parse_set_prio_med,
	If(Constrain('hdr.udp.dstPort', :==:(ConstantValue(1985))), parse_set_prio_med,
	If(Constrain('hdr.udp.dstPort', :==:(ConstantValue(6343))), parse_sflow,
	accept)))))))))))
)


val parse_udp_v6 = InstructionBlock(
	// extract hdr.udp
	Assign('hdr.udp.isValid', ConstantValue(1)),
	Assign('hdr.udp.srcPort', SymbolicValue()),
	Assign('hdr.udp.dstPort', SymbolicValue()),
	Assign('hdr.udp.length_', SymbolicValue()),
	Assign('hdr.udp.checksum', SymbolicValue()),
	Assign('meta.l3_metadata.lkp_outer_l4_sport', :@('hdr.udp.srcPort')),
	Assign('meta.l3_metadata.lkp_outer_l4_dport', :@('hdr.udp.dstPort')),
	If(Constrain('hdr.udp.dstPort', :==:(ConstantValue(67))), parse_set_prio_med,
	If(Constrain('hdr.udp.dstPort', :==:(ConstantValue(68))), parse_set_prio_med,
	If(Constrain('hdr.udp.dstPort', :==:(ConstantValue(546))), parse_set_prio_med,
	If(Constrain('hdr.udp.dstPort', :==:(ConstantValue(547))), parse_set_prio_med,
	If(Constrain('hdr.udp.dstPort', :==:(ConstantValue(520))), parse_set_prio_med,
	If(Constrain('hdr.udp.dstPort', :==:(ConstantValue(521))), parse_set_prio_med,
	If(Constrain('hdr.udp.dstPort', :==:(ConstantValue(1985))), parse_set_prio_med,
	accept)))))))
)


val parse_vlan = InstructionBlock(
	// extract hdr.vlan_tag__0
	Assign('hdr.isValid', ConstantValue(1)),
	Assign('hdr._0pcp', SymbolicValue()),
	Assign('hdr._0cfi', SymbolicValue()),
	Assign('hdr._0vid', SymbolicValue()),
	Assign('hdr._0etherType', SymbolicValue()),
	If(Constrain('hdr.vlan_tag__0.etherType', :==:(ConstantValue(34887))), parse_mpls,
	If(Constrain('hdr.vlan_tag__0.etherType', :==:(ConstantValue(2048))), parse_ipv4,
	If(Constrain('hdr.vlan_tag__0.etherType', :==:(ConstantValue(34525))), parse_ipv6,
	If(Constrain('hdr.vlan_tag__0.etherType', :==:(ConstantValue(2054))), parse_arp_rarp,
	If(Constrain('hdr.vlan_tag__0.etherType', :==:(ConstantValue(35020))), parse_set_prio_high,
	If(Constrain('hdr.vlan_tag__0.etherType', :==:(ConstantValue(34825))), parse_set_prio_high,
	accept))))))
)


val parse_vntag = InstructionBlock(
	// extract hdr.vntag
	Assign('hdr.vntag.isValid', ConstantValue(1)),
	Assign('hdr.vntag.direction', SymbolicValue()),
	Assign('hdr.vntag.pointer', SymbolicValue()),
	Assign('hdr.vntag.destVif', SymbolicValue()),
	Assign('hdr.vntag.looped', SymbolicValue()),
	Assign('hdr.vntag.reserved', SymbolicValue()),
	Assign('hdr.vntag.version', SymbolicValue()),
	Assign('hdr.vntag.srcVif', SymbolicValue()),
	parse_inner_ethernet
)


val parse_vpls = InstructionBlock(
	accept
)


val parse_vxlan = InstructionBlock(
	// extract hdr.vxlan
	Assign('hdr.vxlan.isValid', ConstantValue(1)),
	Assign('hdr.vxlan.flags', SymbolicValue()),
	Assign('hdr.vxlan.reserved', SymbolicValue()),
	Assign('hdr.vxlan.vni', SymbolicValue()),
	Assign('hdr.vxlan.reserved2', SymbolicValue()),
	Assign('meta.tunnel_metadata.ingress_tunnel_type', ConstantValue(1)),
	Assign('meta.tunnel_metadata.tunnel_vni', :@('hdr.vxlan.vni')),
	parse_inner_ethernet
)


val parse_vxlan_gpe = InstructionBlock(
	// extract hdr.vxlan_gpe
	Assign('hdr.vxlan_gpe.isValid', ConstantValue(1)),
	Assign('hdr.vxlan_gpe.flags', SymbolicValue()),
	Assign('hdr.vxlan_gpe.reserved', SymbolicValue()),
	Assign('hdr.vxlan_gpe.next_proto', SymbolicValue()),
	Assign('hdr.vxlan_gpe.vni', SymbolicValue()),
	Assign('hdr.vxlan_gpe.reserved2', SymbolicValue()),
	Assign('meta.tunnel_metadata.ingress_tunnel_type', ConstantValue(12)),
	Assign('meta.tunnel_metadata.tunnel_vni', :@('hdr.vxlan_gpe.vni')),
	Allocate('selectedMultipleParam'),
	Assign('selectedMultipleParam', ConstantValue(0)),
	If(Constrain('selectedMultipleParam', :==:(ConstantValue(0))), 
		//TODO: MASK
//TODO: MASK
InstructionBlock(Assign('selectedMultipleParam', ConstantValue(1)), parse_gpe_int_header)))),
	If(Constrain('selectedMultipleParam', :==:(ConstantValue(0))),
		InstructionBlock(Assign('selectedMultipleParam', ConstantValue(1)), parse_inner_ethernet)),
	Deallocate('selectedMultipleParam')
)


val start = InstructionBlock(
	parse_ethernet
)



Allocate('hdr')
Allocate('meta')
Allocate('standard_metadata')
// Action
val nop = InstructionBlock(
	block5961
)


// Action
val set_mirror_nhop = InstructionBlock(
	Assign('nhop_idx', SymbolicValue()),
	block5985
)


// Action
val set_mirror_bd = InstructionBlock(
	Assign('bd', SymbolicValue()),
	block6009
)


// Action
val sflow_pkt_to_cpu = InstructionBlock(
	Assign('reason_code', SymbolicValue()),
	block6059
)


//Table
val mirror = InstructionBlock(
	Fork(nop, set_mirror_nhop, set_mirror_bd, sflow_pkt_to_cpu, NoAction)
	// keys: meta.i2e_metadata.mirror_session_id
	// size ConstantValue(1024)
	// default_action NoAction
)


block6123
Allocate('hdr')
Allocate('meta')
Allocate('standard_metadata')
// Action
val nop = InstructionBlock(
	block6153
)


// Action
val set_replica_copy_bridged = InstructionBlock(
	block6173
)


// Action
val outer_replica_from_rid = InstructionBlock(
	Assign('bd', SymbolicValue()),
	Assign('tunnel_index', SymbolicValue()),
	Assign('tunnel_type', SymbolicValue()),
	Assign('header_count', SymbolicValue()),
	block6260
)


// Action
val inner_replica_from_rid = InstructionBlock(
	Assign('bd', SymbolicValue()),
	Assign('tunnel_index', SymbolicValue()),
	Assign('tunnel_type', SymbolicValue()),
	Assign('header_count', SymbolicValue()),
	block6347
)


//Table
val replica_type = InstructionBlock(
	Fork(nop, set_replica_copy_bridged, NoAction)
	// keys: meta.multicast_metadata.replica, meta.egress_metadata.same_bd_check
	// size ConstantValue(512)
	// default_action NoAction
)


//Table
val rid = InstructionBlock(
	Fork(nop, outer_replica_from_rid, inner_replica_from_rid, NoAction)
	// keys: meta.intrinsic_metadata.egress_rid
	// size ConstantValue(1024)
	// default_action NoAction
)


block6478
Allocate('hdr')
Allocate('meta')
Allocate('standard_metadata')
// Action
val nop = InstructionBlock(
	block6508
)


// Action
val remove_vlan_single_tagged = InstructionBlock(
	block6545
)


// Action
val remove_vlan_double_tagged = InstructionBlock(
	block6593
)


//Table
val vlan_decap = InstructionBlock(
	Fork(nop, remove_vlan_single_tagged, remove_vlan_double_tagged, NoAction)
	// keys: hdr.vlan_tag__0.isValid, hdr.vlan_tag__1.isValid
	// size ConstantValue(1024)
	// default_action NoAction
)


block6673
Allocate('hdr')
Allocate('meta')
Allocate('standard_metadata')
// Action
val decap_inner_udp = InstructionBlock(
	block6718
)


// Action
val decap_inner_tcp = InstructionBlock(
	block6755
)


// Action
val decap_inner_icmp = InstructionBlock(
	block6792
)


// Action
val decap_inner_unknown = InstructionBlock(
	block6814
)


// Action
val decap_vxlan_inner_ipv4 = InstructionBlock(
	block6874
)


// Action
val decap_vxlan_inner_ipv6 = InstructionBlock(
	block6934
)


// Action
val decap_vxlan_inner_non_ip = InstructionBlock(
	block6987
)


// Action
val decap_genv_inner_ipv4 = InstructionBlock(
	block7047
)


// Action
val decap_genv_inner_ipv6 = InstructionBlock(
	block7107
)


// Action
val decap_genv_inner_non_ip = InstructionBlock(
	block7160
)


// Action
val decap_nvgre_inner_ipv4 = InstructionBlock(
	block7228
)


// Action
val decap_nvgre_inner_ipv6 = InstructionBlock(
	block7296
)


// Action
val decap_nvgre_inner_non_ip = InstructionBlock(
	block7357
)


// Action
val decap_gre_inner_ipv4 = InstructionBlock(
	block7408
)


// Action
val decap_gre_inner_ipv6 = InstructionBlock(
	block7459
)


// Action
val decap_gre_inner_non_ip = InstructionBlock(
	block7506
)


// Action
val decap_ip_inner_ipv4 = InstructionBlock(
	block7549
)


// Action
val decap_ip_inner_ipv6 = InstructionBlock(
	block7592
)


// Action
val decap_mpls_inner_ipv4_pop1 = InstructionBlock(
	block7638
)


// Action
val decap_mpls_inner_ipv6_pop1 = InstructionBlock(
	block7684
)


// Action
val decap_mpls_inner_ethernet_ipv4_pop1 = InstructionBlock(
	block7739
)


// Action
val decap_mpls_inner_ethernet_ipv6_pop1 = InstructionBlock(
	block7794
)


// Action
val decap_mpls_inner_ethernet_non_ip_pop1 = InstructionBlock(
	block7834
)


// Action
val decap_mpls_inner_ipv4_pop2 = InstructionBlock(
	block7891
)


// Action
val decap_mpls_inner_ipv6_pop2 = InstructionBlock(
	block7948
)


// Action
val decap_mpls_inner_ethernet_ipv4_pop2 = InstructionBlock(
	block8014
)


// Action
val decap_mpls_inner_ethernet_ipv6_pop2 = InstructionBlock(
	block8080
)


// Action
val decap_mpls_inner_ethernet_non_ip_pop2 = InstructionBlock(
	block8131
)


// Action
val decap_mpls_inner_ipv4_pop3 = InstructionBlock(
	block8199
)


// Action
val decap_mpls_inner_ipv6_pop3 = InstructionBlock(
	block8267
)


// Action
val decap_mpls_inner_ethernet_ipv4_pop3 = InstructionBlock(
	block8344
)


// Action
val decap_mpls_inner_ethernet_ipv6_pop3 = InstructionBlock(
	block8421
)


// Action
val decap_mpls_inner_ethernet_non_ip_pop3 = InstructionBlock(
	block8483
)


//Table
val tunnel_decap_process_inner = InstructionBlock(
	Fork(decap_inner_udp, decap_inner_tcp, decap_inner_icmp, decap_inner_unknown, NoAction)
	// keys: hdr.inner_tcp.isValid, hdr.inner_udp.isValid, hdr.inner_icmp.isValid
	// size ConstantValue(1024)
	// default_action NoAction
)


//Table
val tunnel_decap_process_outer = InstructionBlock(
	Fork(decap_vxlan_inner_ipv4, decap_vxlan_inner_ipv6, decap_vxlan_inner_non_ip, decap_genv_inner_ipv4, decap_genv_inner_ipv6, decap_genv_inner_non_ip, decap_nvgre_inner_ipv4, decap_nvgre_inner_ipv6, decap_nvgre_inner_non_ip, decap_gre_inner_ipv4, decap_gre_inner_ipv6, decap_gre_inner_non_ip, decap_ip_inner_ipv4, decap_ip_inner_ipv6, decap_mpls_inner_ipv4_pop1, decap_mpls_inner_ipv6_pop1, decap_mpls_inner_ethernet_ipv4_pop1, decap_mpls_inner_ethernet_ipv6_pop1, decap_mpls_inner_ethernet_non_ip_pop1, decap_mpls_inner_ipv4_pop2, decap_mpls_inner_ipv6_pop2, decap_mpls_inner_ethernet_ipv4_pop2, decap_mpls_inner_ethernet_ipv6_pop2, decap_mpls_inner_ethernet_non_ip_pop2, decap_mpls_inner_ipv4_pop3, decap_mpls_inner_ipv6_pop3, decap_mpls_inner_ethernet_ipv4_pop3, decap_mpls_inner_ethernet_ipv6_pop3, decap_mpls_inner_ethernet_non_ip_pop3, NoAction)
	// keys: meta.tunnel_metadata.ingress_tunnel_type, hdr.inner_ipv4.isValid, hdr.inner_ipv6.isValid
	// size ConstantValue(1024)
	// default_action NoAction
)


block8750
Allocate('hdr')
Allocate('meta')
Allocate('standard_metadata')
// Action
val nop = InstructionBlock(
	block8780
)


// Action
val set_l2_rewrite = InstructionBlock(
	block8818
)


// Action
val set_l2_rewrite_with_tunnel = InstructionBlock(
	Assign('tunnel_index', SymbolicValue()),
	Assign('tunnel_type', SymbolicValue()),
	block8876
)


// Action
val set_l3_rewrite = InstructionBlock(
	Assign('bd', SymbolicValue()),
	Assign('mtu_index', SymbolicValue()),
	Assign('dmac', SymbolicValue()),
	block8933
)


// Action
val set_l3_rewrite_with_tunnel = InstructionBlock(
	Assign('bd', SymbolicValue()),
	Assign('dmac', SymbolicValue()),
	Assign('tunnel_index', SymbolicValue()),
	Assign('tunnel_type', SymbolicValue()),
	block9000
)


// Action
val set_mpls_swap_push_rewrite_l2 = InstructionBlock(
	Assign('label', SymbolicValue()),
	Assign('tunnel_index', SymbolicValue()),
	Assign('header_count', SymbolicValue()),
	block9071
)


// Action
val set_mpls_push_rewrite_l2 = InstructionBlock(
	Assign('tunnel_index', SymbolicValue()),
	Assign('header_count', SymbolicValue()),
	block9129
)


// Action
val set_mpls_swap_push_rewrite_l3 = InstructionBlock(
	Assign('bd', SymbolicValue()),
	Assign('dmac', SymbolicValue()),
	Assign('label', SymbolicValue()),
	Assign('tunnel_index', SymbolicValue()),
	Assign('header_count', SymbolicValue()),
	block9211
)


// Action
val set_mpls_push_rewrite_l3 = InstructionBlock(
	Assign('bd', SymbolicValue()),
	Assign('dmac', SymbolicValue()),
	Assign('tunnel_index', SymbolicValue()),
	Assign('header_count', SymbolicValue()),
	block9280
)


// Action
val rewrite_ipv4_multicast = InstructionBlock(
	block9314
)


// Action
val rewrite_ipv6_multicast = InstructionBlock(
	block9328
)


//Table
val rewrite = InstructionBlock(
	Fork(nop, set_l2_rewrite, set_l2_rewrite_with_tunnel, set_l3_rewrite, set_l3_rewrite_with_tunnel, set_mpls_swap_push_rewrite_l2, set_mpls_push_rewrite_l2, set_mpls_swap_push_rewrite_l3, set_mpls_push_rewrite_l3, NoAction)
	// keys: meta.l3_metadata.nexthop_index
	// size ConstantValue(1024)
	// default_action NoAction
)


//Table
val rewrite_multicast = InstructionBlock(
	Fork(nop, rewrite_ipv4_multicast, rewrite_ipv6_multicast, NoAction)
	// keys: hdr.ipv4.isValid, hdr.ipv6.isValid, <Slice>9454, <Slice>9466
	// default_action NoAction
)


block9515
Allocate('hdr')
Allocate('meta')
Allocate('standard_metadata')
// Action
val nop = InstructionBlock(
	block9545
)


// Action
val set_egress_bd_properties = InstructionBlock(
	Assign('smac_idx', SymbolicValue()),
	Assign('nat_mode', SymbolicValue()),
	Assign('bd_label', SymbolicValue()),
	block9589
)


//Table
val egress_bd_map = InstructionBlock(
	Fork(nop, set_egress_bd_properties, NoAction)
	// keys: meta.egress_metadata.bd
	// size ConstantValue(1024)
	// default_action NoAction
)


block9647
Allocate('hdr')
Allocate('meta')
Allocate('standard_metadata')
// Action
val nop = InstructionBlock(
	block9677
)


// Action
val set_mpls_exp_marking = InstructionBlock(
	Assign('exp', SymbolicValue()),
	block9701
)


// Action
val set_ip_dscp_marking = InstructionBlock(
	Assign('dscp', SymbolicValue()),
	block9725
)


// Action
val set_vlan_pcp_marking = InstructionBlock(
	Assign('pcp', SymbolicValue()),
	block9749
)


//Table
val egress_qos_map = InstructionBlock(
	Fork(nop, set_mpls_exp_marking, set_ip_dscp_marking, set_vlan_pcp_marking, NoAction)
	// keys: meta.qos_metadata.egress_qos_group, meta.qos_metadata.lkp_tc
	// size ConstantValue(512)
	// default_action NoAction
)


block9831
Allocate('hdr')
Allocate('meta')
Allocate('standard_metadata')
// Action
val nop = InstructionBlock(
	block9861
)


// Action
val ipv4_unicast_rewrite = InstructionBlock(
	block9904
)


// Action
val ipv4_multicast_rewrite = InstructionBlock(
	block9949
)


// Action
val ipv6_unicast_rewrite = InstructionBlock(
	block9992
)


// Action
val ipv6_multicast_rewrite = InstructionBlock(
	block10037
)


// Action
val mpls_rewrite = InstructionBlock(
	block10077
)


// Action
val rewrite_smac = InstructionBlock(
	Assign('smac', SymbolicValue()),
	block10101
)


//Table
val l3_rewrite = InstructionBlock(
	Fork(nop, ipv4_unicast_rewrite, ipv4_multicast_rewrite, ipv6_unicast_rewrite, ipv6_multicast_rewrite, mpls_rewrite, NoAction)
	// keys: hdr.ipv4.isValid, hdr.ipv6.isValid, hdr.mpls_0.isValid, <Slice>10181, <Slice>10193
	// default_action NoAction
)


//Table
val smac_rewrite = InstructionBlock(
	Fork(rewrite_smac, NoAction)
	// keys: meta.egress_metadata.smac_idx
	// size ConstantValue(512)
	// default_action NoAction
)


block10277
Allocate('hdr')
Allocate('meta')
Allocate('standard_metadata')
// Action
val mtu_miss = InstructionBlock(
	block10313
)


// Action
val ipv4_mtu_check = InstructionBlock(
	Assign('l3_mtu', SymbolicValue()),
	block10342
)


// Action
val ipv6_mtu_check = InstructionBlock(
	Assign('l3_mtu', SymbolicValue()),
	block10371
)


//Table
val mtu = InstructionBlock(
	Fork(mtu_miss, ipv4_mtu_check, ipv6_mtu_check, NoAction)
	// keys: meta.l3_metadata.mtu_index, hdr.ipv4.isValid, hdr.ipv6.isValid
	// size ConstantValue(1024)
	// default_action NoAction
)


block10452
Allocate('hdr')
Allocate('meta')
Allocate('standard_metadata')
// Action
val int_set_header_0_bos = InstructionBlock(
	block10488
)


// Action
val int_set_header_1_bos = InstructionBlock(
	block10508
)


// Action
val int_set_header_2_bos = InstructionBlock(
	block10528
)


// Action
val int_set_header_3_bos = InstructionBlock(
	block10548
)


// Action
val int_set_header_4_bos = InstructionBlock(
	block10568
)


// Action
val int_set_header_5_bos = InstructionBlock(
	block10588
)


// Action
val int_set_header_6_bos = InstructionBlock(
	block10608
)


// Action
val int_set_header_7_bos = InstructionBlock(
	block10628
)


// Action
val nop = InstructionBlock(
	block10642
)


// Action
val int_transit = InstructionBlock(
	Assign('switch_id', SymbolicValue()),
	block10701
)


// Action
val int_src = InstructionBlock(
	Assign('switch_id', SymbolicValue()),
	Assign('hop_cnt', SymbolicValue()),
	Assign('ins_cnt', SymbolicValue()),
	Assign('ins_mask0003', SymbolicValue()),
	Assign('ins_mask0407', SymbolicValue()),
	Assign('ins_byte_cnt', SymbolicValue()),
	Assign('total_words', SymbolicValue()),
	block10854
)


// Action
val int_reset = InstructionBlock(
	block10904
)


// Action
val int_set_header_0003_i0 = InstructionBlock(
	block10918
)


// Action
val int_set_header_3 = InstructionBlock(
	block10955
)


// Action
val int_set_header_0003_i1 = InstructionBlock(
	block10975
)


// Action
val int_set_header_2 = InstructionBlock(
	block11006
)


// Action
val int_set_header_0003_i2 = InstructionBlock(
	block11026
)


// Action
val int_set_header_0003_i3 = InstructionBlock(
	block11052
)


// Action
val int_set_header_1 = InstructionBlock(
	block11089
)


// Action
val int_set_header_0003_i4 = InstructionBlock(
	block11109
)


// Action
val int_set_header_0003_i5 = InstructionBlock(
	block11135
)


// Action
val int_set_header_0003_i6 = InstructionBlock(
	block11161
)


// Action
val int_set_header_0003_i7 = InstructionBlock(
	block11193
)


// Action
val int_set_header_0 = InstructionBlock(
	block11224
)


// Action
val int_set_header_0003_i8 = InstructionBlock(
	block11244
)


// Action
val int_set_header_0003_i9 = InstructionBlock(
	block11270
)


// Action
val int_set_header_0003_i10 = InstructionBlock(
	block11296
)


// Action
val int_set_header_0003_i11 = InstructionBlock(
	block11328
)


// Action
val int_set_header_0003_i12 = InstructionBlock(
	block11354
)


// Action
val int_set_header_0003_i13 = InstructionBlock(
	block11386
)


// Action
val int_set_header_0003_i14 = InstructionBlock(
	block11418
)


// Action
val int_set_header_0003_i15 = InstructionBlock(
	block11456
)


// Action
val int_set_header_0407_i0 = InstructionBlock(
	block11470
)


// Action
val int_set_header_7 = InstructionBlock(
	block11498
)


// Action
val int_set_header_0407_i1 = InstructionBlock(
	block11518
)


// Action
val int_set_header_6 = InstructionBlock(
	block11546
)


// Action
val int_set_header_0407_i2 = InstructionBlock(
	block11566
)


// Action
val int_set_header_0407_i3 = InstructionBlock(
	block11592
)


// Action
val int_set_header_5 = InstructionBlock(
	block11622
)


// Action
val int_set_header_0407_i4 = InstructionBlock(
	block11642
)


// Action
val int_set_header_0407_i5 = InstructionBlock(
	block11668
)


// Action
val int_set_header_0407_i6 = InstructionBlock(
	block11694
)


// Action
val int_set_header_0407_i7 = InstructionBlock(
	block11726
)


// Action
val int_set_header_4 = InstructionBlock(
	block11757
)


// Action
val int_set_header_0407_i8 = InstructionBlock(
	block11777
)


// Action
val int_set_header_0407_i9 = InstructionBlock(
	block11803
)


// Action
val int_set_header_0407_i10 = InstructionBlock(
	block11829
)


// Action
val int_set_header_0407_i11 = InstructionBlock(
	block11861
)


// Action
val int_set_header_0407_i12 = InstructionBlock(
	block11887
)


// Action
val int_set_header_0407_i13 = InstructionBlock(
	block11919
)


// Action
val int_set_header_0407_i14 = InstructionBlock(
	block11951
)


// Action
val int_set_header_0407_i15 = InstructionBlock(
	block11989
)


// Action
val int_set_e_bit = InstructionBlock(
	block12009
)


// Action
val int_update_total_hop_cnt = InstructionBlock(
	block12034
)


//Table
val int_bos = InstructionBlock(
	Fork(int_set_header_0_bos, int_set_header_1_bos, int_set_header_2_bos, int_set_header_3_bos, int_set_header_4_bos, int_set_header_5_bos, int_set_header_6_bos, int_set_header_7_bos, nop, NoAction)
	// keys: hdr.int_header.total_hop_cnt, hdr.int_header.instruction_mask_0003, hdr.int_header.instruction_mask_0407, hdr.int_header.instruction_mask_0811, hdr.int_header.instruction_mask_1215
	// size ConstantValue(17)
	// default_action NoAction
)


//Table
val int_insert = InstructionBlock(
	Fork(int_transit, int_src, int_reset, NoAction)
	// keys: meta.int_metadata_i2e.source, meta.int_metadata_i2e.sink, hdr.int_header.isValid
	// size ConstantValue(3)
	// default_action NoAction
)


//Table
val int_inst_0003 = InstructionBlock(
	Fork(int_set_header_0003_i0, int_set_header_0003_i1, int_set_header_0003_i2, int_set_header_0003_i3, int_set_header_0003_i4, int_set_header_0003_i5, int_set_header_0003_i6, int_set_header_0003_i7, int_set_header_0003_i8, int_set_header_0003_i9, int_set_header_0003_i10, int_set_header_0003_i11, int_set_header_0003_i12, int_set_header_0003_i13, int_set_header_0003_i14, int_set_header_0003_i15, NoAction)
	// keys: hdr.int_header.instruction_mask_0003
	// size ConstantValue(17)
	// default_action NoAction
)


//Table
val int_inst_0407 = InstructionBlock(
	Fork(int_set_header_0407_i0, int_set_header_0407_i1, int_set_header_0407_i2, int_set_header_0407_i3, int_set_header_0407_i4, int_set_header_0407_i5, int_set_header_0407_i6, int_set_header_0407_i7, int_set_header_0407_i8, int_set_header_0407_i9, int_set_header_0407_i10, int_set_header_0407_i11, int_set_header_0407_i12, int_set_header_0407_i13, int_set_header_0407_i14, int_set_header_0407_i15, nop, NoAction)
	// keys: hdr.int_header.instruction_mask_0407
	// size ConstantValue(17)
	// default_action NoAction
)


//Table
val int_inst_0811 = InstructionBlock(
	Fork(nop, NoAction)
	// keys: hdr.int_header.instruction_mask_0811
	// size ConstantValue(16)
	// default_action NoAction
)


//Table
val int_inst_1215 = InstructionBlock(
	Fork(nop, NoAction)
	// keys: hdr.int_header.instruction_mask_1215
	// size ConstantValue(17)
	// default_action NoAction
)


//Table
val int_meta_header_update = InstructionBlock(
	Fork(int_set_e_bit, int_update_total_hop_cnt, NoAction)
	// keys: meta.int_metadata.insert_cnt
	// size ConstantValue(2)
	// default_action NoAction
)


block12584
Allocate('hdr')
Allocate('meta')
Allocate('standard_metadata')
// Action
val nop = InstructionBlock(
	block12614
)


// Action
val nat_update_l4_checksum = InstructionBlock(
	block12645
)


// Action
val set_nat_src_rewrite = InstructionBlock(
	Assign('src_ip', SymbolicValue()),
	block12675
)


// Action
val set_nat_dst_rewrite = InstructionBlock(
	Assign('dst_ip', SymbolicValue()),
	block12705
)


// Action
val set_nat_src_dst_rewrite = InstructionBlock(
	Assign('src_ip', SymbolicValue()),
	Assign('dst_ip', SymbolicValue()),
	block12745
)


// Action
val set_nat_src_udp_rewrite = InstructionBlock(
	Assign('src_ip', SymbolicValue()),
	Assign('src_port', SymbolicValue()),
	block12785
)


// Action
val set_nat_dst_udp_rewrite = InstructionBlock(
	Assign('dst_ip', SymbolicValue()),
	Assign('dst_port', SymbolicValue()),
	block12825
)


// Action
val set_nat_src_dst_udp_rewrite = InstructionBlock(
	Assign('src_ip', SymbolicValue()),
	Assign('dst_ip', SymbolicValue()),
	Assign('src_port', SymbolicValue()),
	Assign('dst_port', SymbolicValue()),
	block12885
)


// Action
val set_nat_src_tcp_rewrite = InstructionBlock(
	Assign('src_ip', SymbolicValue()),
	Assign('src_port', SymbolicValue()),
	block12925
)


// Action
val set_nat_dst_tcp_rewrite = InstructionBlock(
	Assign('dst_ip', SymbolicValue()),
	Assign('dst_port', SymbolicValue()),
	block12965
)


// Action
val set_nat_src_dst_tcp_rewrite = InstructionBlock(
	Assign('src_ip', SymbolicValue()),
	Assign('dst_ip', SymbolicValue()),
	Assign('src_port', SymbolicValue()),
	Assign('dst_port', SymbolicValue()),
	block13025
)


//Table
val egress_nat = InstructionBlock(
	Fork(nop, set_nat_src_rewrite, set_nat_dst_rewrite, set_nat_src_dst_rewrite, set_nat_src_udp_rewrite, set_nat_dst_udp_rewrite, set_nat_src_dst_udp_rewrite, set_nat_src_tcp_rewrite, set_nat_dst_tcp_rewrite, set_nat_src_dst_tcp_rewrite, NoAction)
	// keys: meta.nat_metadata.nat_rewrite_index
	// size ConstantValue(1024)
	// default_action NoAction
)


block13126
Allocate('hdr')
Allocate('meta')
Allocate('standard_metadata')
// Action
val nop = InstructionBlock(
	block13156
)


//Table
val egress_bd_stats_0 = InstructionBlock(
	Fork(nop, NoAction)
	// keys: meta.egress_metadata.bd, meta.l2_metadata.lkp_pkt_type
	// size ConstantValue(1024)
	// default_action NoAction
<ConstructorCallExpression>13223
)


block13237
Allocate('hdr')
Allocate('meta')
Allocate('standard_metadata')
// Action
val nop = InstructionBlock(
	block13267
)


// Action
val set_egress_dst_port_range_id = InstructionBlock(
	Assign('range_id', SymbolicValue()),
	block13291
)


// Action
val set_egress_src_port_range_id = InstructionBlock(
	Assign('range_id', SymbolicValue()),
	block13315
)


// Action
val set_egress_tcp_port_fields = InstructionBlock(
	block13347
)


// Action
val set_egress_udp_port_fields = InstructionBlock(
	block13379
)


// Action
val set_egress_icmp_port_fields = InstructionBlock(
	block13402
)


//Table
val egress_l4_dst_port = InstructionBlock(
	Fork(nop, set_egress_dst_port_range_id, NoAction)
	// keys: meta.l3_metadata.egress_l4_dport
	// size ConstantValue(512)
	// default_action NoAction
)


//Table
val egress_l4_src_port = InstructionBlock(
	Fork(nop, set_egress_src_port_range_id, NoAction)
	// keys: meta.l3_metadata.egress_l4_sport
	// size ConstantValue(512)
	// default_action NoAction
)


//Table
val egress_l4port_fields = InstructionBlock(
	Fork(nop, set_egress_tcp_port_fields, set_egress_udp_port_fields, set_egress_icmp_port_fields, NoAction)
	// keys: hdr.tcp.isValid, hdr.udp.isValid, hdr.icmp.isValid
	// size ConstantValue(4)
	// default_action NoAction
)


block13597
Allocate('hdr')
Allocate('meta')
Allocate('standard_metadata')
// Action
val nop = InstructionBlock(
	block13627
)


// Action
val set_egress_tunnel_vni = InstructionBlock(
	Assign('vnid', SymbolicValue()),
	block13651
)


// Action
val rewrite_tunnel_dmac = InstructionBlock(
	Assign('dmac', SymbolicValue()),
	block13675
)


// Action
val rewrite_tunnel_ipv4_dst = InstructionBlock(
	Assign('ip', SymbolicValue()),
	block13699
)


// Action
val rewrite_tunnel_ipv6_dst = InstructionBlock(
	Assign('ip', SymbolicValue()),
	block13723
)


// Action
val inner_ipv4_udp_rewrite = InstructionBlock(
	block13782
)


// Action
val inner_ipv4_tcp_rewrite = InstructionBlock(
	block13841
)


// Action
val inner_ipv4_icmp_rewrite = InstructionBlock(
	block13900
)


// Action
val inner_ipv4_unknown_rewrite = InstructionBlock(
	block13944
)


// Action
val inner_ipv6_udp_rewrite = InstructionBlock(
	block13997
)


// Action
val inner_ipv6_tcp_rewrite = InstructionBlock(
	block14058
)


// Action
val inner_ipv6_icmp_rewrite = InstructionBlock(
	block14119
)


// Action
val inner_ipv6_unknown_rewrite = InstructionBlock(
	block14165
)


// Action
val inner_non_ip_rewrite = InstructionBlock(
	block14192
)


// Action
val fabric_rewrite = InstructionBlock(
	Assign('tunnel_index', SymbolicValue()),
	block14216
)


// Action
val f_insert_vxlan_header = InstructionBlock(
	block14327
)


// Action
val f_insert_ipv4_header = InstructionBlock(
	Assign('proto', SymbolicValue()),
	block14383
)


// Action
val ipv4_vxlan_rewrite = InstructionBlock(
	block14427
)


// Action
val f_insert_genv_header = InstructionBlock(
	block14562
)


// Action
val ipv4_genv_rewrite = InstructionBlock(
	block14606
)


// Action
val f_insert_nvgre_header = InstructionBlock(
	block14725
)


// Action
val ipv4_nvgre_rewrite = InstructionBlock(
	block14769
)


// Action
val f_insert_gre_header = InstructionBlock(
	block14791
)


// Action
val ipv4_gre_rewrite = InstructionBlock(
	block14844
)


// Action
val ipv4_ip_rewrite = InstructionBlock(
	block14885
)


// Action
val f_insert_ipv6_header = InstructionBlock(
	Assign('proto', SymbolicValue()),
	block14941
)


// Action
val ipv6_gre_rewrite = InstructionBlock(
	block14994
)


// Action
val ipv6_ip_rewrite = InstructionBlock(
	block15033
)


// Action
val ipv6_nvgre_rewrite = InstructionBlock(
	block15077
)


// Action
val ipv6_vxlan_rewrite = InstructionBlock(
	block15121
)


// Action
val ipv6_genv_rewrite = InstructionBlock(
	block15165
)


// Action
val mpls_ethernet_push1_rewrite = InstructionBlock(
	block15202
)


// Action
val mpls_ip_push1_rewrite = InstructionBlock(
	block15232
)


// Action
val mpls_ethernet_push2_rewrite = InstructionBlock(
	block15269
)


// Action
val mpls_ip_push2_rewrite = InstructionBlock(
	block15299
)


// Action
val mpls_ethernet_push3_rewrite = InstructionBlock(
	block15336
)


// Action
val mpls_ip_push3_rewrite = InstructionBlock(
	block15366
)


// Action
val f_insert_erspan_common_header = InstructionBlock(
	block15487
)


// Action
val f_insert_erspan_t3_header = InstructionBlock(
	block15507
)


// Action
val ipv4_erspan_t3_rewrite = InstructionBlock(
	block15545
)


// Action
val ipv6_erspan_t3_rewrite = InstructionBlock(
	block15583
)


// Action
val tunnel_mtu_check = InstructionBlock(
	Assign('l3_mtu', SymbolicValue()),
	block15612
)


// Action
val tunnel_mtu_miss = InstructionBlock(
	block15632
)


// Action
val cpu_rx_rewrite = InstructionBlock(
	block15745
)


// Action
val set_tunnel_rewrite_details = InstructionBlock(
	Assign('outer_bd', SymbolicValue()),
	Assign('smac_idx', SymbolicValue()),
	Assign('dmac_idx', SymbolicValue()),
	Assign('sip_index', SymbolicValue()),
	Assign('dip_index', SymbolicValue()),
	block15809
)


// Action
val set_mpls_rewrite_push1 = InstructionBlock(
	Assign('label1', SymbolicValue()),
	Assign('exp1', SymbolicValue()),
	Assign('ttl1', SymbolicValue()),
	Assign('smac_idx', SymbolicValue()),
	Assign('dmac_idx', SymbolicValue()),
	block15891
)


// Action
val set_mpls_rewrite_push2 = InstructionBlock(
	Assign('label1', SymbolicValue()),
	Assign('exp1', SymbolicValue()),
	Assign('ttl1', SymbolicValue()),
	Assign('label2', SymbolicValue()),
	Assign('exp2', SymbolicValue()),
	Assign('ttl2', SymbolicValue()),
	Assign('smac_idx', SymbolicValue()),
	Assign('dmac_idx', SymbolicValue()),
	block16021
)


// Action
val set_mpls_rewrite_push3 = InstructionBlock(
	Assign('label1', SymbolicValue()),
	Assign('exp1', SymbolicValue()),
	Assign('ttl1', SymbolicValue()),
	Assign('label2', SymbolicValue()),
	Assign('exp2', SymbolicValue()),
	Assign('ttl2', SymbolicValue()),
	Assign('label3', SymbolicValue()),
	Assign('exp3', SymbolicValue()),
	Assign('ttl3', SymbolicValue()),
	Assign('smac_idx', SymbolicValue()),
	Assign('dmac_idx', SymbolicValue()),
	block16199
)


// Action
val fabric_unicast_rewrite = InstructionBlock(
	block16339
)


// Action
val fabric_multicast_rewrite = InstructionBlock(
	Assign('fabric_mgid', SymbolicValue()),
	block16495
)


// Action
val rewrite_tunnel_smac = InstructionBlock(
	Assign('smac', SymbolicValue()),
	block16519
)


// Action
val rewrite_tunnel_ipv4_src = InstructionBlock(
	Assign('ip', SymbolicValue()),
	block16543
)


// Action
val rewrite_tunnel_ipv6_src = InstructionBlock(
	Assign('ip', SymbolicValue()),
	block16567
)


//Table
val egress_vni = InstructionBlock(
	Fork(nop, set_egress_tunnel_vni, NoAction)
	// keys: meta.egress_metadata.bd, meta.tunnel_metadata.egress_tunnel_type
	// size ConstantValue(1024)
	// default_action NoAction
)


//Table
val tunnel_dmac_rewrite = InstructionBlock(
	Fork(nop, rewrite_tunnel_dmac, NoAction)
	// keys: meta.tunnel_metadata.tunnel_dmac_index
	// size ConstantValue(1024)
	// default_action NoAction
)


//Table
val tunnel_dst_rewrite = InstructionBlock(
	Fork(nop, rewrite_tunnel_ipv4_dst, rewrite_tunnel_ipv6_dst, NoAction)
	// keys: meta.tunnel_metadata.tunnel_dst_index
	// size ConstantValue(1024)
	// default_action NoAction
)


//Table
val tunnel_encap_process_inner = InstructionBlock(
	Fork(inner_ipv4_udp_rewrite, inner_ipv4_tcp_rewrite, inner_ipv4_icmp_rewrite, inner_ipv4_unknown_rewrite, inner_ipv6_udp_rewrite, inner_ipv6_tcp_rewrite, inner_ipv6_icmp_rewrite, inner_ipv6_unknown_rewrite, inner_non_ip_rewrite, NoAction)
	// keys: hdr.ipv4.isValid, hdr.ipv6.isValid, hdr.tcp.isValid, hdr.udp.isValid, hdr.icmp.isValid
	// size ConstantValue(1024)
	// default_action NoAction
)


//Table
val tunnel_encap_process_outer = InstructionBlock(
	Fork(nop, fabric_rewrite, ipv4_vxlan_rewrite, ipv4_genv_rewrite, ipv4_nvgre_rewrite, ipv4_gre_rewrite, ipv4_ip_rewrite, ipv6_gre_rewrite, ipv6_ip_rewrite, ipv6_nvgre_rewrite, ipv6_vxlan_rewrite, ipv6_genv_rewrite, mpls_ethernet_push1_rewrite, mpls_ip_push1_rewrite, mpls_ethernet_push2_rewrite, mpls_ip_push2_rewrite, mpls_ethernet_push3_rewrite, mpls_ip_push3_rewrite, ipv4_erspan_t3_rewrite, ipv6_erspan_t3_rewrite, NoAction)
	// keys: meta.tunnel_metadata.egress_tunnel_type, meta.tunnel_metadata.egress_header_count, meta.multicast_metadata.replica
	// size ConstantValue(1024)
	// default_action NoAction
)


//Table
val tunnel_mtu = InstructionBlock(
	Fork(tunnel_mtu_check, tunnel_mtu_miss, NoAction)
	// keys: meta.tunnel_metadata.tunnel_index
	// size ConstantValue(1024)
	// default_action NoAction
)


//Table
val tunnel_rewrite = InstructionBlock(
	Fork(nop, cpu_rx_rewrite, set_tunnel_rewrite_details, set_mpls_rewrite_push1, set_mpls_rewrite_push2, set_mpls_rewrite_push3, fabric_unicast_rewrite, fabric_multicast_rewrite, NoAction)
	// keys: meta.tunnel_metadata.tunnel_index
	// size ConstantValue(1024)
	// default_action NoAction
)


//Table
val tunnel_smac_rewrite = InstructionBlock(
	Fork(nop, rewrite_tunnel_smac, NoAction)
	// keys: meta.tunnel_metadata.tunnel_smac_index
	// size ConstantValue(1024)
	// default_action NoAction
)


//Table
val tunnel_src_rewrite = InstructionBlock(
	Fork(nop, rewrite_tunnel_ipv4_src, rewrite_tunnel_ipv6_src, NoAction)
	// keys: meta.tunnel_metadata.tunnel_src_index
	// size ConstantValue(1024)
	// default_action NoAction
)


block17252
Allocate('hdr')
Allocate('meta')
Allocate('standard_metadata')
// Action
val nop = InstructionBlock(
	block17282
)


// Action
val egress_acl_deny = InstructionBlock(
	Assign('acl_copy_reason', SymbolicValue()),
	block17312
)


// Action
val egress_acl_permit = InstructionBlock(
	Assign('acl_copy_reason', SymbolicValue()),
	block17336
)


//Table
val egress_ip_acl = InstructionBlock(
	Fork(nop, egress_acl_deny, egress_acl_permit, NoAction)
	// keys: meta.acl_metadata.egress_if_label, meta.acl_metadata.egress_bd_label, hdr.ipv4.srcAddr, hdr.ipv4.dstAddr, hdr.ipv4.protocol, meta.acl_metadata.egress_src_port_range_id, meta.acl_metadata.egress_dst_port_range_id
	// size ConstantValue(512)
	// default_action NoAction
)


//Table
val egress_ipv6_acl = InstructionBlock(
	Fork(nop, egress_acl_deny, egress_acl_permit, NoAction)
	// keys: meta.acl_metadata.egress_if_label, meta.acl_metadata.egress_bd_label, hdr.ipv6.srcAddr, hdr.ipv6.dstAddr, hdr.ipv6.nextHdr, meta.acl_metadata.egress_src_port_range_id, meta.acl_metadata.egress_dst_port_range_id
	// size ConstantValue(512)
	// default_action NoAction
)


//Table
val egress_mac_acl = InstructionBlock(
	Fork(nop, egress_acl_deny, egress_acl_permit, NoAction)
	// keys: meta.acl_metadata.egress_if_label, meta.acl_metadata.egress_bd_label, hdr.ethernet.srcAddr, hdr.ethernet.dstAddr, hdr.ethernet.etherType
	// size ConstantValue(512)
	// default_action NoAction
)


block17647
Allocate('hdr')
Allocate('meta')
Allocate('standard_metadata')
// Action
val int_update_vxlan_gpe_ipv4 = InstructionBlock(
	block17719
)


// Action
val int_add_update_vxlan_gpe_ipv4 = InstructionBlock(
	block17796
)


// Action
val nop = InstructionBlock(
	block17810
)


//Table
val int_outer_encap = InstructionBlock(
	Fork(int_update_vxlan_gpe_ipv4, int_add_update_vxlan_gpe_ipv4, nop, NoAction)
	// keys: hdr.ipv4.isValid, hdr.vxlan_gpe.isValid, meta.int_metadata_i2e.source, meta.tunnel_metadata.egress_tunnel_type
	// size ConstantValue(8)
	// default_action NoAction
)


block17907
Allocate('hdr')
Allocate('meta')
Allocate('standard_metadata')
// Action
val set_egress_packet_vlan_untagged = InstructionBlock(
	block17937
)


// Action
val set_egress_packet_vlan_tagged = InstructionBlock(
	Assign('vlan_id', SymbolicValue()),
	block17993
)


// Action
val set_egress_packet_vlan_double_tagged = InstructionBlock(
	Assign('s_tag', SymbolicValue()),
	Assign('c_tag', SymbolicValue()),
	block18082
)


//Table
val egress_vlan_xlate = InstructionBlock(
	Fork(set_egress_packet_vlan_untagged, set_egress_packet_vlan_tagged, set_egress_packet_vlan_double_tagged, NoAction)
	// keys: meta.egress_metadata.ifindex, meta.egress_metadata.bd
	// size ConstantValue(1024)
	// default_action NoAction
)


block18150
Allocate('hdr')
Allocate('meta')
Allocate('standard_metadata')
// Action
val egress_filter_check = InstructionBlock(
	block18222
)


// Action
val set_egress_filter_drop = InstructionBlock(
	block18242
)


//Table
val egress_filter = InstructionBlock(
	Fork(egress_filter_check, NoAction)
	// default_action NoAction
)


//Table
val egress_filter_drop = InstructionBlock(
	Fork(set_egress_filter_drop, NoAction)
	// default_action NoAction
)


block18380
Allocate('hdr')
Allocate('meta')
Allocate('standard_metadata')
// Action
val nop = InstructionBlock(
	block18410
)


// Action
val drop_packet = InstructionBlock(
	block18430
)


// Action
val egress_copy_to_cpu = InstructionBlock(
	block18477
)


// Action
val egress_redirect_to_cpu = InstructionBlock(
	block18503
)


// Action
val egress_copy_to_cpu_with_reason = InstructionBlock(
	Assign('reason_code', SymbolicValue()),
	block18533
)


// Action
val egress_redirect_to_cpu_with_reason = InstructionBlock(
	Assign('reason_code', SymbolicValue()),
	block18564
)


// Action
val egress_mirror = InstructionBlock(
	Assign('session_id', SymbolicValue()),
	block18613
)


// Action
val egress_mirror_drop = InstructionBlock(
	Assign('session_id', SymbolicValue()),
	block18644
)


//Table
val egress_system_acl = InstructionBlock(
	Fork(nop, drop_packet, egress_copy_to_cpu, egress_redirect_to_cpu, egress_copy_to_cpu_with_reason, egress_redirect_to_cpu_with_reason, egress_mirror, egress_mirror_drop, NoAction)
	// keys: meta.fabric_metadata.reason_code, standard_metadata.egress_port, meta.intrinsic_metadata.deflection_flag, meta.l3_metadata.l3_mtu_check, meta.acl_metadata.acl_deny
	// size ConstantValue(512)
	// default_action NoAction
)


block18756
Allocate('hdr')
Allocate('meta')
Allocate('standard_metadata')
// Action
val egress_port_type_normal = InstructionBlock(
	Assign('ifindex', SymbolicValue()),
	Assign('qos_group', SymbolicValue()),
	Assign('if_label', SymbolicValue()),
	block18822
)


// Action
val egress_port_type_fabric = InstructionBlock(
	Assign('ifindex', SymbolicValue()),
	block18858
)


// Action
val egress_port_type_cpu = InstructionBlock(
	Assign('ifindex', SymbolicValue()),
	block18894
)


//Table
val egress_port_mapping = InstructionBlock(
	Fork(egress_port_type_normal, egress_port_type_fabric, egress_port_type_cpu, NoAction)
	// keys: standard_metadata.egress_port
	// size ConstantValue(288)
	// default_action NoAction
)


<Declaration_Instance>18958
<Declaration_Instance>18972
<Declaration_Instance>18986
<Declaration_Instance>19000
<Declaration_Instance>19014
<Declaration_Instance>19028
<Declaration_Instance>19042
<Declaration_Instance>19056
<Declaration_Instance>19070
<Declaration_Instance>19084
<Declaration_Instance>19098
<Declaration_Instance>19112
<Declaration_Instance>19126
<Declaration_Instance>19140
<Declaration_Instance>19154
<Declaration_Instance>19168
<Declaration_Instance>19182
<Declaration_Instance>19196
<Declaration_Instance>19210
block19549
Allocate('hdr')
Allocate('meta')
Allocate('standard_metadata')
// Action
val set_ifindex = InstructionBlock(
	Assign('ifindex', SymbolicValue()),
	Assign('port_type', SymbolicValue()),
	block19599
)


// Action
val set_ingress_port_properties = InstructionBlock(
	Assign('if_label', SymbolicValue()),
	Assign('qos_group', SymbolicValue()),
	Assign('tc_qos_group', SymbolicValue()),
	Assign('tc', SymbolicValue()),
	Assign('color', SymbolicValue()),
	Assign('trust_dscp', SymbolicValue()),
	Assign('trust_pcp', SymbolicValue()),
	block19683
)


//Table
val ingress_port_mapping = InstructionBlock(
	Fork(set_ifindex, NoAction)
	// keys: standard_metadata.ingress_port
	// size ConstantValue(288)
	// default_action NoAction
)


//Table
val ingress_port_properties = InstructionBlock(
	Fork(set_ingress_port_properties, NoAction)
	// keys: standard_metadata.ingress_port
	// size ConstantValue(288)
	// default_action NoAction
)


block19787
Allocate('hdr')
Allocate('meta')
Allocate('standard_metadata')
// Action
val set_valid_outer_ipv4_packet = InstructionBlock(
	block19841
)


// Action
val set_malformed_outer_ipv4_packet = InstructionBlock(
	Assign('drop_reason', SymbolicValue()),
	block19871
)


//Table
val validate_outer_ipv4_packet = InstructionBlock(
	Fork(set_valid_outer_ipv4_packet, set_malformed_outer_ipv4_packet, NoAction)
	// keys: hdr.ipv4.version, hdr.ipv4.ttl, <Slice>19920
	// size ConstantValue(512)
	// default_action NoAction
)


block19948
Allocate('hdr')
Allocate('meta')
Allocate('standard_metadata')
// Action
val set_valid_outer_ipv6_packet = InstructionBlock(
	block20002
)


// Action
val set_malformed_outer_ipv6_packet = InstructionBlock(
	Assign('drop_reason', SymbolicValue()),
	block20032
)


//Table
val validate_outer_ipv6_packet = InstructionBlock(
	Fork(set_valid_outer_ipv6_packet, set_malformed_outer_ipv6_packet, NoAction)
	// keys: hdr.ipv6.version, hdr.ipv6.hopLimit, <Slice>20081
	// size ConstantValue(512)
	// default_action NoAction
)


block20109
Allocate('hdr')
Allocate('meta')
Allocate('standard_metadata')
// Action
val set_valid_mpls_label1 = InstructionBlock(
	block20163
)


// Action
val set_valid_mpls_label2 = InstructionBlock(
	block20201
)


// Action
val set_valid_mpls_label3 = InstructionBlock(
	block20239
)


//Table
val validate_mpls_packet = InstructionBlock(
	Fork(set_valid_mpls_label1, set_valid_mpls_label2, set_valid_mpls_label3, NoAction)
	// keys: hdr.mpls_0.label, hdr.mpls_0.bos, hdr.mpls_0.isValid, hdr.mpls_1.label, hdr.mpls_1.bos, hdr.mpls_1.isValid, hdr.mpls_2.label, hdr.mpls_2.bos, hdr.mpls_2.isValid
	// size ConstantValue(512)
	// default_action NoAction
)


block20392
Allocate('hdr')
Allocate('meta')
Allocate('standard_metadata')
// Action
val malformed_outer_ethernet_packet = InstructionBlock(
	Assign('drop_reason', SymbolicValue()),
	block20438
)


// Action
val set_valid_outer_unicast_packet_untagged = InstructionBlock(
	block20467
)


// Action
val set_valid_outer_unicast_packet_single_tagged = InstructionBlock(
	block20511
)


// Action
val set_valid_outer_unicast_packet_double_tagged = InstructionBlock(
	block20555
)


// Action
val set_valid_outer_unicast_packet_qinq_tagged = InstructionBlock(
	block20596
)


// Action
val set_valid_outer_multicast_packet_untagged = InstructionBlock(
	block20625
)


// Action
val set_valid_outer_multicast_packet_single_tagged = InstructionBlock(
	block20669
)


// Action
val set_valid_outer_multicast_packet_double_tagged = InstructionBlock(
	block20713
)


// Action
val set_valid_outer_multicast_packet_qinq_tagged = InstructionBlock(
	block20754
)


// Action
val set_valid_outer_broadcast_packet_untagged = InstructionBlock(
	block20783
)


// Action
val set_valid_outer_broadcast_packet_single_tagged = InstructionBlock(
	block20827
)


// Action
val set_valid_outer_broadcast_packet_double_tagged = InstructionBlock(
	block20871
)


// Action
val set_valid_outer_broadcast_packet_qinq_tagged = InstructionBlock(
	block20912
)


//Table
val validate_outer_ethernet = InstructionBlock(
	Fork(malformed_outer_ethernet_packet, set_valid_outer_unicast_packet_untagged, set_valid_outer_unicast_packet_single_tagged, set_valid_outer_unicast_packet_double_tagged, set_valid_outer_unicast_packet_qinq_tagged, set_valid_outer_multicast_packet_untagged, set_valid_outer_multicast_packet_single_tagged, set_valid_outer_multicast_packet_double_tagged, set_valid_outer_multicast_packet_qinq_tagged, set_valid_outer_broadcast_packet_untagged, set_valid_outer_broadcast_packet_single_tagged, set_valid_outer_broadcast_packet_double_tagged, set_valid_outer_broadcast_packet_qinq_tagged, NoAction)
	// keys: hdr.ethernet.srcAddr, hdr.ethernet.dstAddr, hdr.vlan_tag__0.isValid, hdr.vlan_tag__1.isValid
	// size ConstantValue(512)
	// default_action NoAction
)


<Declaration_Instance>21040
<Declaration_Instance>21054
<Declaration_Instance>21068
block21167
Allocate('hdr')
Allocate('meta')
Allocate('standard_metadata')
// Action
val deflect_on_drop = InstructionBlock(
	Assign('enable_dod', SymbolicValue()),
	block21207
)


// Action
val set_config_parameters = InstructionBlock(
	Assign('enable_dod', SymbolicValue()),
	block21282
)


//Table
val switch_config_params = InstructionBlock(
	Fork(set_config_parameters, NoAction)
	// size ConstantValue(1)
	// default_action NoAction
)


block21327
Allocate('hdr')
Allocate('meta')
Allocate('standard_metadata')
// Action
val set_bd_properties = InstructionBlock(
	Assign('bd', SymbolicValue()),
	Assign('vrf', SymbolicValue()),
	Assign('stp_group', SymbolicValue()),
	Assign('learning_enabled', SymbolicValue()),
	Assign('bd_label', SymbolicValue()),
	Assign('stats_idx', SymbolicValue()),
	Assign('rmac_group', SymbolicValue()),
	Assign('ipv4_unicast_enabled', SymbolicValue()),
	Assign('ipv6_unicast_enabled', SymbolicValue()),
	Assign('ipv4_urpf_mode', SymbolicValue()),
	Assign('ipv6_urpf_mode', SymbolicValue()),
	Assign('igmp_snooping_enabled', SymbolicValue()),
	Assign('mld_snooping_enabled', SymbolicValue()),
	Assign('ipv4_multicast_enabled', SymbolicValue()),
	Assign('ipv6_multicast_enabled', SymbolicValue()),
	Assign('mrpf_group', SymbolicValue()),
	Assign('ipv4_mcast_key', SymbolicValue()),
	Assign('ipv4_mcast_key_type', SymbolicValue()),
	Assign('ipv6_mcast_key', SymbolicValue()),
	Assign('ipv6_mcast_key_type', SymbolicValue()),
	block21564
)


// Action
val port_vlan_mapping_miss = InstructionBlock(
	block21584
)


//Table
val port_vlan_mapping = InstructionBlock(
	Fork(set_bd_properties, port_vlan_mapping_miss, NoAction)
	// keys: meta.ingress_metadata.ifindex, hdr.vlan_tag__0.isValid, hdr.vlan_tag__0.vid, hdr.vlan_tag__1.isValid, hdr.vlan_tag__1.vid
	// size ConstantValue(4096)
	// default_action NoAction
<ConstructorCallExpression>21690
)


block21704
Allocate('hdr')
Allocate('meta')
Allocate('standard_metadata')
// Action
val set_stp_state = InstructionBlock(
	Assign('stp_state', SymbolicValue()),
	block21744
)


//Table
val spanning_tree = InstructionBlock(
	Fork(set_stp_state, NoAction)
	// keys: meta.ingress_metadata.ifindex, meta.l2_metadata.stp_group
	// size ConstantValue(1024)
	// default_action NoAction
)


block21822
Allocate('hdr')
Allocate('meta')
Allocate('standard_metadata')
// Action
val nop = InstructionBlock(
	block21852
)


// Action
val set_ingress_tc = InstructionBlock(
	Assign('tc', SymbolicValue()),
	block21876
)


// Action
val set_ingress_color = InstructionBlock(
	Assign('color', SymbolicValue()),
	block21900
)


// Action
val set_ingress_tc_and_color = InstructionBlock(
	Assign('tc', SymbolicValue()),
	Assign('color', SymbolicValue()),
	block21934
)


//Table
val ingress_qos_map_dscp = InstructionBlock(
	Fork(nop, set_ingress_tc, set_ingress_color, set_ingress_tc_and_color, NoAction)
	// keys: meta.qos_metadata.ingress_qos_group, meta.l3_metadata.lkp_dscp
	// size ConstantValue(64)
	// default_action NoAction
)


//Table
val ingress_qos_map_pcp = InstructionBlock(
	Fork(nop, set_ingress_tc, set_ingress_color, set_ingress_tc_and_color, NoAction)
	// keys: meta.qos_metadata.ingress_qos_group, meta.l2_metadata.lkp_pcp
	// size ConstantValue(64)
	// default_action NoAction
)


block22103
Allocate('hdr')
Allocate('meta')
Allocate('standard_metadata')
// Action
val on_miss = InstructionBlock(
	block22133
)


// Action
val ipsg_miss = InstructionBlock(
	block22153
)


//Table
val ipsg = InstructionBlock(
	Fork(on_miss, NoAction)
	// keys: meta.ingress_metadata.ifindex, meta.ingress_metadata.bd, meta.l2_metadata.lkp_mac_sa, meta.ipv4_metadata.lkp_ipv4_sa
	// size ConstantValue(1024)
	// default_action NoAction
)


//Table
val ipsg_permit_special = InstructionBlock(
	Fork(ipsg_miss, NoAction)
	// keys: meta.l3_metadata.lkp_ip_proto, meta.l3_metadata.lkp_l4_dport, meta.ipv4_metadata.lkp_ipv4_da
	// size ConstantValue(512)
	// default_action NoAction
)


block22319
Allocate('hdr')
Allocate('meta')
Allocate('standard_metadata')
// Action
val int_sink_update_vxlan_gpe_v4 = InstructionBlock(
	block22394
)


// Action
val nop = InstructionBlock(
	block22408
)


// Action
val int_set_src = InstructionBlock(
	block22428
)


// Action
val int_set_no_src = InstructionBlock(
	block22448
)


// Action
val int_sink = InstructionBlock(
	Assign('mirror_id', SymbolicValue()),
	block22775
)


// Action
val int_sink_gpe = InstructionBlock(
	Assign('mirror_id', SymbolicValue()),
	block22812
)


// Action
val int_no_sink = InstructionBlock(
	block22832
)


//Table
val int_sink_update_outer = InstructionBlock(
	Fork(int_sink_update_vxlan_gpe_v4, nop, NoAction)
	// keys: hdr.vxlan_gpe_int_header.isValid, hdr.ipv4.isValid, meta.int_metadata_i2e.sink
	// size ConstantValue(2)
	// default_action NoAction
)


//Table
val int_source = InstructionBlock(
	Fork(int_set_src, int_set_no_src, NoAction)
	// keys: hdr.int_header.isValid, hdr.ipv4.isValid, meta.ipv4_metadata.lkp_ipv4_da, meta.ipv4_metadata.lkp_ipv4_sa, hdr.inner_ipv4.isValid, hdr.inner_ipv4.dstAddr, hdr.inner_ipv4.srcAddr
	// size ConstantValue(256)
	// default_action NoAction
)


//Table
val int_terminate = InstructionBlock(
	Fork(int_sink_gpe, int_no_sink, NoAction)
	// keys: hdr.int_header.isValid, hdr.vxlan_gpe_int_header.isValid, hdr.ipv4.isValid, meta.ipv4_metadata.lkp_ipv4_da, hdr.inner_ipv4.isValid, hdr.inner_ipv4.dstAddr
	// size ConstantValue(256)
	// default_action NoAction
)


block23129
Allocate('hdr')
Allocate('meta')
Allocate('standard_metadata')
// Action
val nop = InstructionBlock(
	block23159
)


// Action
val sflow_ing_pkt_to_cpu = InstructionBlock(
	Assign('sflow_i2e_mirror_id', SymbolicValue()),
	block23230
)


// Action
val sflow_ing_session_enable = InstructionBlock(
	Assign('rate_thr', SymbolicValue()),
	Assign('session_id', SymbolicValue()),
	block23269
)


//Table
val sflow_ing_take_sample = InstructionBlock(
	Fork(nop, sflow_ing_pkt_to_cpu, NoAction)
	// keys: meta.ingress_metadata.sflow_take_sample, meta.sflow_metadata.sflow_session_id
	// size ConstantValue(16)
	// default_action NoAction
)


//Table
val sflow_ingress = InstructionBlock(
	Fork(nop, sflow_ing_session_enable, NoAction)
	// keys: meta.ingress_metadata.ifindex, meta.ipv4_metadata.lkp_ipv4_sa, meta.ipv4_metadata.lkp_ipv4_da, hdr.sflow.isValid
	// size ConstantValue(512)
	// default_action NoAction
<ConstructorCallExpression>23410
)


block23431
Allocate('hdr')
Allocate('meta')
Allocate('standard_metadata')
// Action
val nop = InstructionBlock(
	block23461
)


// Action
val terminate_cpu_packet = InstructionBlock(
	block23534
)


// Action
val switch_fabric_unicast_packet = InstructionBlock(
	block23572
)


// Action
val terminate_fabric_unicast_packet = InstructionBlock(
	block23672
)


// Action
val switch_fabric_multicast_packet = InstructionBlock(
	block23701
)


// Action
val terminate_fabric_multicast_packet = InstructionBlock(
	block23799
)


// Action
val set_ingress_ifindex_properties = InstructionBlock(
	block23813
)


// Action
val non_ip_over_fabric = InstructionBlock(
	block23854
)


// Action
val ipv4_over_fabric = InstructionBlock(
	block23931
)


// Action
val ipv6_over_fabric = InstructionBlock(
	block24008
)


//Table
val fabric_ingress_dst_lkp = InstructionBlock(
	Fork(nop, terminate_cpu_packet, switch_fabric_unicast_packet, terminate_fabric_unicast_packet, switch_fabric_multicast_packet, terminate_fabric_multicast_packet, NoAction)
	// keys: hdr.fabric_header.dstDevice
	// default_action NoAction
)


//Table
val fabric_ingress_src_lkp = InstructionBlock(
	Fork(nop, set_ingress_ifindex_properties, NoAction)
	// keys: hdr.fabric_header_multicast.ingressIfindex
	// size ConstantValue(1024)
	// default_action NoAction
)


//Table
val native_packet_over_fabric = InstructionBlock(
	Fork(non_ip_over_fabric, ipv4_over_fabric, ipv6_over_fabric, NoAction)
	// keys: hdr.ipv4.isValid, hdr.ipv6.isValid
	// size ConstantValue(1024)
	// default_action NoAction
)


block24235
Allocate('hdr')
Allocate('meta')
Allocate('standard_metadata')
// Action
val nop = InstructionBlock(
	block24265
)


// Action
val set_tunnel_termination_flag = InstructionBlock(
	block24285
)


// Action
val set_tunnel_vni_and_termination_flag = InstructionBlock(
	Assign('tunnel_vni', SymbolicValue()),
	block24315
)


// Action
val on_miss = InstructionBlock(
	block24329
)


// Action
val src_vtep_hit = InstructionBlock(
	Assign('ifindex', SymbolicValue()),
	block24353
)


//Table
val ipv4_dest_vtep = InstructionBlock(
	Fork(nop, set_tunnel_termination_flag, set_tunnel_vni_and_termination_flag, NoAction)
	// keys: meta.l3_metadata.vrf, hdr.ipv4.dstAddr, meta.tunnel_metadata.ingress_tunnel_type
	// size ConstantValue(1024)
	// default_action NoAction
)


//Table
val ipv4_src_vtep = InstructionBlock(
	Fork(on_miss, src_vtep_hit, NoAction)
	// keys: meta.l3_metadata.vrf, hdr.ipv4.srcAddr, meta.tunnel_metadata.ingress_tunnel_type
	// size ConstantValue(1024)
	// default_action NoAction
)


block24505
Allocate('hdr')
Allocate('meta')
Allocate('standard_metadata')
// Action
val nop = InstructionBlock(
	block24535
)


// Action
val set_tunnel_termination_flag = InstructionBlock(
	block24555
)


// Action
val set_tunnel_vni_and_termination_flag = InstructionBlock(
	Assign('tunnel_vni', SymbolicValue()),
	block24585
)


// Action
val on_miss = InstructionBlock(
	block24599
)


// Action
val src_vtep_hit = InstructionBlock(
	Assign('ifindex', SymbolicValue()),
	block24623
)


//Table
val ipv6_dest_vtep = InstructionBlock(
	Fork(nop, set_tunnel_termination_flag, set_tunnel_vni_and_termination_flag, NoAction)
	// keys: meta.l3_metadata.vrf, hdr.ipv6.dstAddr, meta.tunnel_metadata.ingress_tunnel_type
	// size ConstantValue(1024)
	// default_action NoAction
)


//Table
val ipv6_src_vtep = InstructionBlock(
	Fork(on_miss, src_vtep_hit, NoAction)
	// keys: meta.l3_metadata.vrf, hdr.ipv6.srcAddr, meta.tunnel_metadata.ingress_tunnel_type
	// size ConstantValue(1024)
	// default_action NoAction
)


block24775
Allocate('hdr')
Allocate('meta')
Allocate('standard_metadata')
// Action
val terminate_eompls = InstructionBlock(
	Assign('bd', SymbolicValue()),
	Assign('tunnel_type', SymbolicValue()),
	block24840
)


// Action
val terminate_vpls = InstructionBlock(
	Assign('bd', SymbolicValue()),
	Assign('tunnel_type', SymbolicValue()),
	block24889
)


// Action
val terminate_ipv4_over_mpls = InstructionBlock(
	Assign('vrf', SymbolicValue()),
	Assign('tunnel_type', SymbolicValue()),
	block24971
)


// Action
val terminate_ipv6_over_mpls = InstructionBlock(
	Assign('vrf', SymbolicValue()),
	Assign('tunnel_type', SymbolicValue()),
	block25053
)


// Action
val terminate_pw = InstructionBlock(
	Assign('ifindex', SymbolicValue()),
	block25095
)


// Action
val forward_mpls = InstructionBlock(
	Assign('nexthop_index', SymbolicValue()),
	block25149
)


//Table
val mpls_0 = InstructionBlock(
	Fork(terminate_eompls, terminate_vpls, terminate_ipv4_over_mpls, terminate_ipv6_over_mpls, terminate_pw, forward_mpls, NoAction)
	// keys: meta.tunnel_metadata.mpls_label, hdr.inner_ipv4.isValid, hdr.inner_ipv6.isValid
	// size ConstantValue(1024)
	// default_action NoAction
)


block25239
Allocate('hdr')
Allocate('meta')
Allocate('standard_metadata')
// Action
val nop = InstructionBlock(
	block25269
)


// Action
val on_miss = InstructionBlock(
	block25283
)


// Action
val outer_multicast_route_s_g_hit = InstructionBlock(
	Assign('mc_index', SymbolicValue()),
	Assign('mcast_rpf_group', SymbolicValue()),
	block25334
)


// Action
val outer_multicast_bridge_s_g_hit = InstructionBlock(
	Assign('mc_index', SymbolicValue()),
	block25370
)


// Action
val outer_multicast_route_sm_star_g_hit = InstructionBlock(
	Assign('mc_index', SymbolicValue()),
	Assign('mcast_rpf_group', SymbolicValue()),
	block25427
)


// Action
val outer_multicast_route_bidir_star_g_hit = InstructionBlock(
	Assign('mc_index', SymbolicValue()),
	Assign('mcast_rpf_group', SymbolicValue()),
	block25484
)


// Action
val outer_multicast_bridge_star_g_hit = InstructionBlock(
	Assign('mc_index', SymbolicValue()),
	block25520
)


//Table
val outer_ipv4_multicast = InstructionBlock(
	Fork(nop, on_miss, outer_multicast_route_s_g_hit, outer_multicast_bridge_s_g_hit, NoAction)
	// keys: meta.multicast_metadata.ipv4_mcast_key_type, meta.multicast_metadata.ipv4_mcast_key, hdr.ipv4.srcAddr, hdr.ipv4.dstAddr
	// size ConstantValue(1024)
	// default_action NoAction
)


//Table
val outer_ipv4_multicast_star_g = InstructionBlock(
	Fork(nop, outer_multicast_route_sm_star_g_hit, outer_multicast_route_bidir_star_g_hit, outer_multicast_bridge_star_g_hit, NoAction)
	// keys: meta.multicast_metadata.ipv4_mcast_key_type, meta.multicast_metadata.ipv4_mcast_key, hdr.ipv4.dstAddr
	// size ConstantValue(512)
	// default_action NoAction
)


block25688
Allocate('hdr')
Allocate('meta')
Allocate('standard_metadata')
// Action
val nop = InstructionBlock(
	block25718
)


// Action
val on_miss = InstructionBlock(
	block25732
)


// Action
val outer_multicast_route_s_g_hit = InstructionBlock(
	Assign('mc_index', SymbolicValue()),
	Assign('mcast_rpf_group', SymbolicValue()),
	block25783
)


// Action
val outer_multicast_bridge_s_g_hit = InstructionBlock(
	Assign('mc_index', SymbolicValue()),
	block25819
)


// Action
val outer_multicast_route_sm_star_g_hit = InstructionBlock(
	Assign('mc_index', SymbolicValue()),
	Assign('mcast_rpf_group', SymbolicValue()),
	block25876
)


// Action
val outer_multicast_route_bidir_star_g_hit = InstructionBlock(
	Assign('mc_index', SymbolicValue()),
	Assign('mcast_rpf_group', SymbolicValue()),
	block25933
)


// Action
val outer_multicast_bridge_star_g_hit = InstructionBlock(
	Assign('mc_index', SymbolicValue()),
	block25969
)


//Table
val outer_ipv6_multicast = InstructionBlock(
	Fork(nop, on_miss, outer_multicast_route_s_g_hit, outer_multicast_bridge_s_g_hit, NoAction)
	// keys: meta.multicast_metadata.ipv6_mcast_key_type, meta.multicast_metadata.ipv6_mcast_key, hdr.ipv6.srcAddr, hdr.ipv6.dstAddr
	// size ConstantValue(1024)
	// default_action NoAction
)


//Table
val outer_ipv6_multicast_star_g = InstructionBlock(
	Fork(nop, outer_multicast_route_sm_star_g_hit, outer_multicast_route_bidir_star_g_hit, outer_multicast_bridge_star_g_hit, NoAction)
	// keys: meta.multicast_metadata.ipv6_mcast_key_type, meta.multicast_metadata.ipv6_mcast_key, hdr.ipv6.dstAddr
	// size ConstantValue(512)
	// default_action NoAction
)


block26137
Allocate('hdr')
Allocate('meta')
Allocate('standard_metadata')
block26157
Allocate('hdr')
Allocate('meta')
Allocate('standard_metadata')
<Declaration_Instance>26188
<Declaration_Instance>26202
<Declaration_Instance>26216
block26280
Allocate('hdr')
Allocate('meta')
Allocate('standard_metadata')
// Action
val non_ip_lkp = InstructionBlock(
	block26328
)


// Action
val ipv4_lkp = InstructionBlock(
	block26414
)


// Action
val ipv6_lkp = InstructionBlock(
	block26500
)


// Action
val on_miss = InstructionBlock(
	block26514
)


// Action
val outer_rmac_hit = InstructionBlock(
	block26534
)


// Action
val nop = InstructionBlock(
	block26548
)


// Action
val tunnel_lookup_miss = InstructionBlock(
	block26562
)


// Action
val terminate_tunnel_inner_non_ip = InstructionBlock(
	Assign('bd', SymbolicValue()),
	Assign('bd_label', SymbolicValue()),
	Assign('stats_idx', SymbolicValue()),
	block26627
)


// Action
val terminate_tunnel_inner_ethernet_ipv4 = InstructionBlock(
	Assign('bd', SymbolicValue()),
	Assign('vrf', SymbolicValue()),
	Assign('rmac_group', SymbolicValue()),
	Assign('bd_label', SymbolicValue()),
	Assign('ipv4_unicast_enabled', SymbolicValue()),
	Assign('ipv4_urpf_mode', SymbolicValue()),
	Assign('igmp_snooping_enabled', SymbolicValue()),
	Assign('stats_idx', SymbolicValue()),
	Assign('ipv4_multicast_enabled', SymbolicValue()),
	Assign('mrpf_group', SymbolicValue()),
	block26771
)


// Action
val terminate_tunnel_inner_ipv4 = InstructionBlock(
	Assign('vrf', SymbolicValue()),
	Assign('rmac_group', SymbolicValue()),
	Assign('ipv4_urpf_mode', SymbolicValue()),
	Assign('ipv4_unicast_enabled', SymbolicValue()),
	Assign('ipv4_multicast_enabled', SymbolicValue()),
	Assign('mrpf_group', SymbolicValue()),
	block26884
)


// Action
val terminate_tunnel_inner_ethernet_ipv6 = InstructionBlock(
	Assign('bd', SymbolicValue()),
	Assign('vrf', SymbolicValue()),
	Assign('rmac_group', SymbolicValue()),
	Assign('bd_label', SymbolicValue()),
	Assign('ipv6_unicast_enabled', SymbolicValue()),
	Assign('ipv6_urpf_mode', SymbolicValue()),
	Assign('mld_snooping_enabled', SymbolicValue()),
	Assign('stats_idx', SymbolicValue()),
	Assign('ipv6_multicast_enabled', SymbolicValue()),
	Assign('mrpf_group', SymbolicValue()),
	block27028
)


// Action
val terminate_tunnel_inner_ipv6 = InstructionBlock(
	Assign('vrf', SymbolicValue()),
	Assign('rmac_group', SymbolicValue()),
	Assign('ipv6_unicast_enabled', SymbolicValue()),
	Assign('ipv6_urpf_mode', SymbolicValue()),
	Assign('ipv6_multicast_enabled', SymbolicValue()),
	Assign('mrpf_group', SymbolicValue()),
	block27141
)


//Table
val adjust_lkp_fields = InstructionBlock(
	Fork(non_ip_lkp, ipv4_lkp, ipv6_lkp, NoAction)
	// keys: hdr.ipv4.isValid, hdr.ipv6.isValid
	// default_action NoAction
)


//Table
val outer_rmac = InstructionBlock(
	Fork(on_miss, outer_rmac_hit, NoAction)
	// keys: meta.l3_metadata.rmac_group, hdr.ethernet.dstAddr
	// size ConstantValue(1024)
	// default_action NoAction
)


//Table
val tunnel = InstructionBlock(
	Fork(nop, tunnel_lookup_miss, terminate_tunnel_inner_non_ip, terminate_tunnel_inner_ethernet_ipv4, terminate_tunnel_inner_ipv4, terminate_tunnel_inner_ethernet_ipv6, terminate_tunnel_inner_ipv6, NoAction)
	// keys: meta.tunnel_metadata.tunnel_vni, meta.tunnel_metadata.ingress_tunnel_type, hdr.inner_ipv4.isValid, hdr.inner_ipv6.isValid
	// size ConstantValue(1024)
	// default_action NoAction
)


//Table
val tunnel_lookup_miss_0 = InstructionBlock(
	Fork(non_ip_lkp, ipv4_lkp, ipv6_lkp, NoAction)
	// keys: hdr.ipv4.isValid, hdr.ipv6.isValid
	// default_action NoAction
)


<Declaration_Instance>27417
<Declaration_Instance>27431
<Declaration_Instance>27445
<Declaration_Instance>27459
<Declaration_Instance>27473
block27683
Allocate('hdr')
Allocate('meta')
Allocate('standard_metadata')
<Declaration_Instance>27719
// Action
val nop = InstructionBlock(
	block27732
)


// Action
val set_storm_control_meter = InstructionBlock(
	Assign('meter_idx', SymbolicValue()),
	block27772
)


//Table
val storm_control = InstructionBlock(
	Fork(nop, set_storm_control_meter, NoAction)
	// keys: standard_metadata.ingress_port, meta.l2_metadata.lkp_pkt_type
	// size ConstantValue(512)
	// default_action NoAction
)


block27845
Allocate('hdr')
Allocate('meta')
Allocate('standard_metadata')
// Action
val nop = InstructionBlock(
	block27875
)


// Action
val set_unicast = InstructionBlock(
	block27895
)


// Action
val set_unicast_and_ipv6_src_is_link_local = InstructionBlock(
	block27921
)


// Action
val set_multicast = InstructionBlock(
	block27952
)


// Action
val set_multicast_and_ipv6_src_is_link_local = InstructionBlock(
	block27989
)


// Action
val set_broadcast = InstructionBlock(
	block28020
)


// Action
val set_malformed_packet = InstructionBlock(
	Assign('drop_reason', SymbolicValue()),
	block28050
)


//Table
val validate_packet = InstructionBlock(
	Fork(nop, set_unicast, set_unicast_and_ipv6_src_is_link_local, set_multicast, set_multicast_and_ipv6_src_is_link_local, set_broadcast, set_malformed_packet, NoAction)
	// keys: meta.l2_metadata.lkp_mac_sa, meta.l2_metadata.lkp_mac_da, meta.l3_metadata.lkp_ip_type, meta.l3_metadata.lkp_ip_ttl, meta.l3_metadata.lkp_ip_version, <Slice>28135, <Slice>28147
	// size ConstantValue(512)
	// default_action NoAction
)


block28193
Allocate('hdr')
Allocate('meta')
Allocate('standard_metadata')
// Action
val nop = InstructionBlock(
	block28223
)


// Action
val set_ingress_dst_port_range_id = InstructionBlock(
	Assign('range_id', SymbolicValue()),
	block28247
)


// Action
val set_ingress_src_port_range_id = InstructionBlock(
	Assign('range_id', SymbolicValue()),
	block28271
)


//Table
val ingress_l4_dst_port = InstructionBlock(
	Fork(nop, set_ingress_dst_port_range_id, NoAction)
	// keys: meta.l3_metadata.lkp_l4_dport
	// size ConstantValue(512)
	// default_action NoAction
)


//Table
val ingress_l4_src_port = InstructionBlock(
	Fork(nop, set_ingress_src_port_range_id, NoAction)
	// keys: meta.l3_metadata.lkp_l4_sport
	// size ConstantValue(512)
	// default_action NoAction
)


block28383
Allocate('hdr')
Allocate('meta')
Allocate('standard_metadata')
// Action
val nop = InstructionBlock(
	block28413
)


// Action
val dmac_hit = InstructionBlock(
	Assign('ifindex', SymbolicValue()),
	block28449
)


// Action
val dmac_multicast_hit = InstructionBlock(
	Assign('mc_index', SymbolicValue()),
	block28479
)


// Action
val dmac_miss = InstructionBlock(
	block28505
)


// Action
val dmac_redirect_nexthop = InstructionBlock(
	Assign('nexthop_index', SymbolicValue()),
	block28541
)


// Action
val dmac_redirect_ecmp = InstructionBlock(
	Assign('ecmp_index', SymbolicValue()),
	block28577
)


// Action
val dmac_drop = InstructionBlock(
	block28597
)


// Action
val smac_miss = InstructionBlock(
	block28617
)


// Action
val smac_hit = InstructionBlock(
	Assign('ifindex', SymbolicValue()),
	block28646
)


//Table
val dmac = InstructionBlock(
ConstantValue(0)
	Fork(nop, dmac_hit, dmac_multicast_hit, dmac_miss, dmac_redirect_nexthop, dmac_redirect_ecmp, dmac_drop, NoAction)
	// keys: meta.ingress_metadata.bd, meta.l2_metadata.lkp_mac_da
	// size ConstantValue(1024)
	// default_action NoAction
)


//Table
val smac = InstructionBlock(
	Fork(nop, smac_miss, smac_hit, NoAction)
	// keys: meta.ingress_metadata.bd, meta.l2_metadata.lkp_mac_sa
	// size ConstantValue(1024)
	// default_action NoAction
)


block28822
Allocate('hdr')
Allocate('meta')
Allocate('standard_metadata')
// Action
val nop = InstructionBlock(
	block28852
)


// Action
val acl_deny = InstructionBlock(
	Assign('acl_stats_index', SymbolicValue()),
	Assign('acl_meter_index', SymbolicValue()),
	Assign('acl_copy_reason', SymbolicValue()),
	Assign('nat_mode', SymbolicValue()),
	Assign('ingress_cos', SymbolicValue()),
	Assign('tc', SymbolicValue()),
	Assign('color', SymbolicValue()),
	block28942
)


// Action
val acl_permit = InstructionBlock(
	Assign('acl_stats_index', SymbolicValue()),
	Assign('acl_meter_index', SymbolicValue()),
	Assign('acl_copy_reason', SymbolicValue()),
	Assign('nat_mode', SymbolicValue()),
	Assign('ingress_cos', SymbolicValue()),
	Assign('tc', SymbolicValue()),
	Assign('color', SymbolicValue()),
	block29026
)


// Action
val acl_redirect_nexthop = InstructionBlock(
	Assign('nexthop_index', SymbolicValue()),
	Assign('acl_stats_index', SymbolicValue()),
	Assign('acl_meter_index', SymbolicValue()),
	Assign('acl_copy_reason', SymbolicValue()),
	Assign('nat_mode', SymbolicValue()),
	Assign('ingress_cos', SymbolicValue()),
	Assign('tc', SymbolicValue()),
	Assign('color', SymbolicValue()),
	block29132
)


// Action
val acl_redirect_ecmp = InstructionBlock(
	Assign('ecmp_index', SymbolicValue()),
	Assign('acl_stats_index', SymbolicValue()),
	Assign('acl_meter_index', SymbolicValue()),
	Assign('acl_copy_reason', SymbolicValue()),
	Assign('nat_mode', SymbolicValue()),
	Assign('ingress_cos', SymbolicValue()),
	Assign('tc', SymbolicValue()),
	Assign('color', SymbolicValue()),
	block29238
)


// Action
val acl_mirror = InstructionBlock(
	Assign('session_id', SymbolicValue()),
	Assign('acl_stats_index', SymbolicValue()),
	Assign('acl_meter_index', SymbolicValue()),
	Assign('nat_mode', SymbolicValue()),
	Assign('ingress_cos', SymbolicValue()),
	Assign('tc', SymbolicValue()),
	Assign('color', SymbolicValue()),
	block29347
)


//Table
val mac_acl = InstructionBlock(
	Fork(nop, acl_deny, acl_permit, acl_redirect_nexthop, acl_redirect_ecmp, acl_mirror, NoAction)
	// keys: meta.acl_metadata.if_label, meta.acl_metadata.bd_label, meta.l2_metadata.lkp_mac_sa, meta.l2_metadata.lkp_mac_da, meta.l2_metadata.lkp_mac_type
	// size ConstantValue(512)
	// default_action NoAction
)


block29456
Allocate('hdr')
Allocate('meta')
Allocate('standard_metadata')
// Action
val nop = InstructionBlock(
	block29486
)


// Action
val acl_deny = InstructionBlock(
	Assign('acl_stats_index', SymbolicValue()),
	Assign('acl_meter_index', SymbolicValue()),
	Assign('acl_copy_reason', SymbolicValue()),
	Assign('nat_mode', SymbolicValue()),
	Assign('ingress_cos', SymbolicValue()),
	Assign('tc', SymbolicValue()),
	Assign('color', SymbolicValue()),
	block29576
)


// Action
val acl_permit = InstructionBlock(
	Assign('acl_stats_index', SymbolicValue()),
	Assign('acl_meter_index', SymbolicValue()),
	Assign('acl_copy_reason', SymbolicValue()),
	Assign('nat_mode', SymbolicValue()),
	Assign('ingress_cos', SymbolicValue()),
	Assign('tc', SymbolicValue()),
	Assign('color', SymbolicValue()),
	block29660
)


// Action
val acl_redirect_nexthop = InstructionBlock(
	Assign('nexthop_index', SymbolicValue()),
	Assign('acl_stats_index', SymbolicValue()),
	Assign('acl_meter_index', SymbolicValue()),
	Assign('acl_copy_reason', SymbolicValue()),
	Assign('nat_mode', SymbolicValue()),
	Assign('ingress_cos', SymbolicValue()),
	Assign('tc', SymbolicValue()),
	Assign('color', SymbolicValue()),
	block29766
)


// Action
val acl_redirect_ecmp = InstructionBlock(
	Assign('ecmp_index', SymbolicValue()),
	Assign('acl_stats_index', SymbolicValue()),
	Assign('acl_meter_index', SymbolicValue()),
	Assign('acl_copy_reason', SymbolicValue()),
	Assign('nat_mode', SymbolicValue()),
	Assign('ingress_cos', SymbolicValue()),
	Assign('tc', SymbolicValue()),
	Assign('color', SymbolicValue()),
	block29872
)


// Action
val acl_mirror = InstructionBlock(
	Assign('session_id', SymbolicValue()),
	Assign('acl_stats_index', SymbolicValue()),
	Assign('acl_meter_index', SymbolicValue()),
	Assign('nat_mode', SymbolicValue()),
	Assign('ingress_cos', SymbolicValue()),
	Assign('tc', SymbolicValue()),
	Assign('color', SymbolicValue()),
	block29981
)


//Table
val ip_acl = InstructionBlock(
	Fork(nop, acl_deny, acl_permit, acl_redirect_nexthop, acl_redirect_ecmp, acl_mirror, NoAction)
	// keys: meta.acl_metadata.if_label, meta.acl_metadata.bd_label, meta.ipv4_metadata.lkp_ipv4_sa, meta.ipv4_metadata.lkp_ipv4_da, meta.l3_metadata.lkp_ip_proto, meta.acl_metadata.ingress_src_port_range_id, meta.acl_metadata.ingress_dst_port_range_id, hdr.tcp.flags, meta.l3_metadata.lkp_ip_ttl
	// size ConstantValue(512)
	// default_action NoAction
)


//Table
val ipv6_acl = InstructionBlock(
	Fork(nop, acl_deny, acl_permit, acl_redirect_nexthop, acl_redirect_ecmp, acl_mirror, NoAction)
	// keys: meta.acl_metadata.if_label, meta.acl_metadata.bd_label, meta.ipv6_metadata.lkp_ipv6_sa, meta.ipv6_metadata.lkp_ipv6_da, meta.l3_metadata.lkp_ip_proto, meta.acl_metadata.ingress_src_port_range_id, meta.acl_metadata.ingress_dst_port_range_id, hdr.tcp.flags, meta.l3_metadata.lkp_ip_ttl
	// size ConstantValue(512)
	// default_action NoAction
)


block30260
Allocate('hdr')
Allocate('meta')
Allocate('standard_metadata')
// Action
val nop = InstructionBlock(
	block30290
)


// Action
val racl_deny = InstructionBlock(
	Assign('acl_stats_index', SymbolicValue()),
	Assign('acl_copy_reason', SymbolicValue()),
	Assign('ingress_cos', SymbolicValue()),
	Assign('tc', SymbolicValue()),
	Assign('color', SymbolicValue()),
	block30360
)


// Action
val racl_permit = InstructionBlock(
	Assign('acl_stats_index', SymbolicValue()),
	Assign('acl_copy_reason', SymbolicValue()),
	Assign('ingress_cos', SymbolicValue()),
	Assign('tc', SymbolicValue()),
	Assign('color', SymbolicValue()),
	block30424
)


// Action
val racl_redirect_nexthop = InstructionBlock(
	Assign('nexthop_index', SymbolicValue()),
	Assign('acl_stats_index', SymbolicValue()),
	Assign('acl_copy_reason', SymbolicValue()),
	Assign('ingress_cos', SymbolicValue()),
	Assign('tc', SymbolicValue()),
	Assign('color', SymbolicValue()),
	block30510
)


// Action
val racl_redirect_ecmp = InstructionBlock(
	Assign('ecmp_index', SymbolicValue()),
	Assign('acl_stats_index', SymbolicValue()),
	Assign('acl_copy_reason', SymbolicValue()),
	Assign('ingress_cos', SymbolicValue()),
	Assign('tc', SymbolicValue()),
	Assign('color', SymbolicValue()),
	block30596
)


//Table
val ipv4_racl = InstructionBlock(
	Fork(nop, racl_deny, racl_permit, racl_redirect_nexthop, racl_redirect_ecmp, NoAction)
	// keys: meta.acl_metadata.bd_label, meta.ipv4_metadata.lkp_ipv4_sa, meta.ipv4_metadata.lkp_ipv4_da, meta.l3_metadata.lkp_ip_proto, meta.acl_metadata.ingress_src_port_range_id, meta.acl_metadata.ingress_dst_port_range_id
	// size ConstantValue(512)
	// default_action NoAction
)


block30698
Allocate('hdr')
Allocate('meta')
Allocate('standard_metadata')
// Action
val on_miss = InstructionBlock(
	block30728
)


// Action
val ipv4_urpf_hit = InstructionBlock(
	Assign('urpf_bd_group', SymbolicValue()),
	block30767
)


// Action
val urpf_miss = InstructionBlock(
	block30787
)


//Table
val ipv4_urpf = InstructionBlock(
	Fork(on_miss, ipv4_urpf_hit, NoAction)
	// keys: meta.l3_metadata.vrf, meta.ipv4_metadata.lkp_ipv4_sa
	// size ConstantValue(1024)
	// default_action NoAction
)


//Table
val ipv4_urpf_lpm = InstructionBlock(
	Fork(ipv4_urpf_hit, urpf_miss, NoAction)
	// keys: meta.l3_metadata.vrf, meta.ipv4_metadata.lkp_ipv4_sa
	// size ConstantValue(512)
	// default_action NoAction
)


block30931
Allocate('hdr')
Allocate('meta')
Allocate('standard_metadata')
// Action
val on_miss = InstructionBlock(
	block30961
)


// Action
val fib_hit_nexthop = InstructionBlock(
	Assign('nexthop_index', SymbolicValue()),
	block30997
)


// Action
val fib_hit_ecmp = InstructionBlock(
	Assign('ecmp_index', SymbolicValue()),
	block31033
)


//Table
val ipv4_fib = InstructionBlock(
	Fork(on_miss, fib_hit_nexthop, fib_hit_ecmp, NoAction)
	// keys: meta.l3_metadata.vrf, meta.ipv4_metadata.lkp_ipv4_da
	// size ConstantValue(1024)
	// default_action NoAction
)


//Table
val ipv4_fib_lpm = InstructionBlock(
	Fork(on_miss, fib_hit_nexthop, fib_hit_ecmp, NoAction)
	// keys: meta.l3_metadata.vrf, meta.ipv4_metadata.lkp_ipv4_da
	// size ConstantValue(512)
	// default_action NoAction
)


block31174
Allocate('hdr')
Allocate('meta')
Allocate('standard_metadata')
// Action
val nop = InstructionBlock(
	block31204
)


// Action
val racl_deny = InstructionBlock(
	Assign('acl_stats_index', SymbolicValue()),
	Assign('acl_copy_reason', SymbolicValue()),
	Assign('ingress_cos', SymbolicValue()),
	Assign('tc', SymbolicValue()),
	Assign('color', SymbolicValue()),
	block31274
)


// Action
val racl_permit = InstructionBlock(
	Assign('acl_stats_index', SymbolicValue()),
	Assign('acl_copy_reason', SymbolicValue()),
	Assign('ingress_cos', SymbolicValue()),
	Assign('tc', SymbolicValue()),
	Assign('color', SymbolicValue()),
	block31338
)


// Action
val racl_redirect_nexthop = InstructionBlock(
	Assign('nexthop_index', SymbolicValue()),
	Assign('acl_stats_index', SymbolicValue()),
	Assign('acl_copy_reason', SymbolicValue()),
	Assign('ingress_cos', SymbolicValue()),
	Assign('tc', SymbolicValue()),
	Assign('color', SymbolicValue()),
	block31424
)


// Action
val racl_redirect_ecmp = InstructionBlock(
	Assign('ecmp_index', SymbolicValue()),
	Assign('acl_stats_index', SymbolicValue()),
	Assign('acl_copy_reason', SymbolicValue()),
	Assign('ingress_cos', SymbolicValue()),
	Assign('tc', SymbolicValue()),
	Assign('color', SymbolicValue()),
	block31510
)


//Table
val ipv6_racl = InstructionBlock(
	Fork(nop, racl_deny, racl_permit, racl_redirect_nexthop, racl_redirect_ecmp, NoAction)
	// keys: meta.acl_metadata.bd_label, meta.ipv6_metadata.lkp_ipv6_sa, meta.ipv6_metadata.lkp_ipv6_da, meta.l3_metadata.lkp_ip_proto, meta.acl_metadata.ingress_src_port_range_id, meta.acl_metadata.ingress_dst_port_range_id
	// size ConstantValue(512)
	// default_action NoAction
)


block31612
Allocate('hdr')
Allocate('meta')
Allocate('standard_metadata')
// Action
val on_miss = InstructionBlock(
	block31642
)


// Action
val ipv6_urpf_hit = InstructionBlock(
	Assign('urpf_bd_group', SymbolicValue()),
	block31681
)


// Action
val urpf_miss = InstructionBlock(
	block31701
)


//Table
val ipv6_urpf = InstructionBlock(
	Fork(on_miss, ipv6_urpf_hit, NoAction)
	// keys: meta.l3_metadata.vrf, meta.ipv6_metadata.lkp_ipv6_sa
	// size ConstantValue(1024)
	// default_action NoAction
)


//Table
val ipv6_urpf_lpm = InstructionBlock(
	Fork(ipv6_urpf_hit, urpf_miss, NoAction)
	// keys: meta.l3_metadata.vrf, meta.ipv6_metadata.lkp_ipv6_sa
	// size ConstantValue(512)
	// default_action NoAction
)


block31845
Allocate('hdr')
Allocate('meta')
Allocate('standard_metadata')
// Action
val on_miss = InstructionBlock(
	block31875
)


// Action
val fib_hit_nexthop = InstructionBlock(
	Assign('nexthop_index', SymbolicValue()),
	block31911
)


// Action
val fib_hit_ecmp = InstructionBlock(
	Assign('ecmp_index', SymbolicValue()),
	block31947
)


//Table
val ipv6_fib = InstructionBlock(
	Fork(on_miss, fib_hit_nexthop, fib_hit_ecmp, NoAction)
	// keys: meta.l3_metadata.vrf, meta.ipv6_metadata.lkp_ipv6_da
	// size ConstantValue(1024)
	// default_action NoAction
)


//Table
val ipv6_fib_lpm = InstructionBlock(
	Fork(on_miss, fib_hit_nexthop, fib_hit_ecmp, NoAction)
	// keys: meta.l3_metadata.vrf, meta.ipv6_metadata.lkp_ipv6_da
	// size ConstantValue(512)
	// default_action NoAction
)


block32088
Allocate('hdr')
Allocate('meta')
Allocate('standard_metadata')
// Action
val nop = InstructionBlock(
	block32118
)


// Action
val urpf_bd_miss = InstructionBlock(
	block32138
)


//Table
val urpf_bd = InstructionBlock(
	Fork(nop, urpf_bd_miss, NoAction)
	// keys: meta.l3_metadata.urpf_bd_group, meta.ingress_metadata.bd
	// size ConstantValue(1024)
	// default_action NoAction
)


block32219
Allocate('hdr')
Allocate('meta')
Allocate('standard_metadata')
// Action
val on_miss = InstructionBlock(
	block32249
)


// Action
val multicast_bridge_s_g_hit = InstructionBlock(
	Assign('mc_index', SymbolicValue()),
	block32279
)


// Action
val nop = InstructionBlock(
	block32293
)


// Action
val multicast_bridge_star_g_hit = InstructionBlock(
	Assign('mc_index', SymbolicValue()),
	block32323
)


// Action
val multicast_route_s_g_hit = InstructionBlock(
	Assign('mc_index', SymbolicValue()),
	Assign('mcast_rpf_group', SymbolicValue()),
	block32374
)


// Action
val multicast_route_star_g_miss = InstructionBlock(
	block32394
)


// Action
val multicast_route_sm_star_g_hit = InstructionBlock(
	Assign('mc_index', SymbolicValue()),
	Assign('mcast_rpf_group', SymbolicValue()),
	block32445
)


// Action
val multicast_route_bidir_star_g_hit = InstructionBlock(
	Assign('mc_index', SymbolicValue()),
	Assign('mcast_rpf_group', SymbolicValue()),
	block32496
)


//Table
val ipv4_multicast_bridge = InstructionBlock(
	Fork(on_miss, multicast_bridge_s_g_hit, NoAction)
	// keys: meta.ingress_metadata.bd, meta.ipv4_metadata.lkp_ipv4_sa, meta.ipv4_metadata.lkp_ipv4_da
	// size ConstantValue(1024)
	// default_action NoAction
)


//Table
val ipv4_multicast_bridge_star_g = InstructionBlock(
	Fork(nop, multicast_bridge_star_g_hit, NoAction)
	// keys: meta.ingress_metadata.bd, meta.ipv4_metadata.lkp_ipv4_da
	// size ConstantValue(1024)
	// default_action NoAction
)


//Table
val ipv4_multicast_route = InstructionBlock(
	Fork(on_miss, multicast_route_s_g_hit, NoAction)
	// keys: meta.l3_metadata.vrf, meta.ipv4_metadata.lkp_ipv4_sa, meta.ipv4_metadata.lkp_ipv4_da
	// size ConstantValue(1024)
	// default_action NoAction
<ConstructorCallExpression>32688
)


//Table
val ipv4_multicast_route_star_g = InstructionBlock(
	Fork(multicast_route_star_g_miss, multicast_route_sm_star_g_hit, multicast_route_bidir_star_g_hit, NoAction)
	// keys: meta.l3_metadata.vrf, meta.ipv4_metadata.lkp_ipv4_da
	// size ConstantValue(1024)
	// default_action NoAction
<ConstructorCallExpression>32764
)


block32846
Allocate('hdr')
Allocate('meta')
Allocate('standard_metadata')
// Action
val on_miss = InstructionBlock(
	block32876
)


// Action
val multicast_bridge_s_g_hit = InstructionBlock(
	Assign('mc_index', SymbolicValue()),
	block32906
)


// Action
val nop = InstructionBlock(
	block32920
)


// Action
val multicast_bridge_star_g_hit = InstructionBlock(
	Assign('mc_index', SymbolicValue()),
	block32950
)


// Action
val multicast_route_s_g_hit = InstructionBlock(
	Assign('mc_index', SymbolicValue()),
	Assign('mcast_rpf_group', SymbolicValue()),
	block33001
)


// Action
val multicast_route_star_g_miss = InstructionBlock(
	block33021
)


// Action
val multicast_route_sm_star_g_hit = InstructionBlock(
	Assign('mc_index', SymbolicValue()),
	Assign('mcast_rpf_group', SymbolicValue()),
	block33072
)


// Action
val multicast_route_bidir_star_g_hit = InstructionBlock(
	Assign('mc_index', SymbolicValue()),
	Assign('mcast_rpf_group', SymbolicValue()),
	block33123
)


//Table
val ipv6_multicast_bridge = InstructionBlock(
	Fork(on_miss, multicast_bridge_s_g_hit, NoAction)
	// keys: meta.ingress_metadata.bd, meta.ipv6_metadata.lkp_ipv6_sa, meta.ipv6_metadata.lkp_ipv6_da
	// size ConstantValue(1024)
	// default_action NoAction
)


//Table
val ipv6_multicast_bridge_star_g = InstructionBlock(
	Fork(nop, multicast_bridge_star_g_hit, NoAction)
	// keys: meta.ingress_metadata.bd, meta.ipv6_metadata.lkp_ipv6_da
	// size ConstantValue(1024)
	// default_action NoAction
)


//Table
val ipv6_multicast_route = InstructionBlock(
	Fork(on_miss, multicast_route_s_g_hit, NoAction)
	// keys: meta.l3_metadata.vrf, meta.ipv6_metadata.lkp_ipv6_sa, meta.ipv6_metadata.lkp_ipv6_da
	// size ConstantValue(1024)
	// default_action NoAction
<ConstructorCallExpression>33315
)


//Table
val ipv6_multicast_route_star_g = InstructionBlock(
	Fork(multicast_route_star_g_miss, multicast_route_sm_star_g_hit, multicast_route_bidir_star_g_hit, NoAction)
	// keys: meta.l3_metadata.vrf, meta.ipv6_metadata.lkp_ipv6_da
	// size ConstantValue(1024)
	// default_action NoAction
<ConstructorCallExpression>33391
)


block33473
Allocate('hdr')
Allocate('meta')
Allocate('standard_metadata')
block33493
Allocate('hdr')
Allocate('meta')
Allocate('standard_metadata')
<Declaration_Instance>33524
<Declaration_Instance>33538
<Declaration_Instance>33552
block33614
Allocate('hdr')
Allocate('meta')
Allocate('standard_metadata')
// Action
val on_miss = InstructionBlock(
	block33644
)


// Action
val set_dst_nat_nexthop_index = InstructionBlock(
	Assign('nexthop_index', SymbolicValue()),
	Assign('nexthop_type', SymbolicValue()),
	Assign('nat_rewrite_index', SymbolicValue()),
	block33694
)


// Action
val nop = InstructionBlock(
	block33708
)


// Action
val set_src_nat_rewrite_index = InstructionBlock(
	Assign('nat_rewrite_index', SymbolicValue()),
	block33732
)


// Action
val set_twice_nat_nexthop_index = InstructionBlock(
	Assign('nexthop_index', SymbolicValue()),
	Assign('nexthop_type', SymbolicValue()),
	Assign('nat_rewrite_index', SymbolicValue()),
	block33782
)


//Table
val nat_dst = InstructionBlock(
	Fork(on_miss, set_dst_nat_nexthop_index, NoAction)
	// keys: meta.l3_metadata.vrf, meta.ipv4_metadata.lkp_ipv4_da, meta.l3_metadata.lkp_ip_proto, meta.l3_metadata.lkp_l4_dport
	// size ConstantValue(1024)
	// default_action NoAction
)


//Table
val nat_flow = InstructionBlock(
	Fork(nop, set_src_nat_rewrite_index, set_dst_nat_nexthop_index, set_twice_nat_nexthop_index, NoAction)
	// keys: meta.l3_metadata.vrf, meta.ipv4_metadata.lkp_ipv4_sa, meta.ipv4_metadata.lkp_ipv4_da, meta.l3_metadata.lkp_ip_proto, meta.l3_metadata.lkp_l4_sport, meta.l3_metadata.lkp_l4_dport
	// size ConstantValue(512)
	// default_action NoAction
)


//Table
val nat_src = InstructionBlock(
	Fork(on_miss, set_src_nat_rewrite_index, NoAction)
	// keys: meta.l3_metadata.vrf, meta.ipv4_metadata.lkp_ipv4_sa, meta.l3_metadata.lkp_ip_proto, meta.l3_metadata.lkp_l4_sport
	// size ConstantValue(1024)
	// default_action NoAction
)


//Table
val nat_twice = InstructionBlock(
	Fork(on_miss, set_twice_nat_nexthop_index, NoAction)
	// keys: meta.l3_metadata.vrf, meta.ipv4_metadata.lkp_ipv4_sa, meta.ipv4_metadata.lkp_ipv4_da, meta.l3_metadata.lkp_ip_proto, meta.l3_metadata.lkp_l4_sport, meta.l3_metadata.lkp_l4_dport
	// size ConstantValue(1024)
	// default_action NoAction
)


block34147
Allocate('hdr')
Allocate('meta')
Allocate('standard_metadata')
<Declaration_Instance>34186
// Action
val nop = InstructionBlock(
	block34199
)


// Action
val nop_0 = InstructionBlock(
	block34224
)


//Table
val meter_index_0 = InstructionBlock(
	Fork(nop_0, NoAction)
	// keys: meta.meter_metadata.meter_index
	// size ConstantValue(1024)
	// default_action NoAction
meter_index
)


block34294
Allocate('hdr')
Allocate('meta')
Allocate('standard_metadata')
// Action
val compute_lkp_ipv4_hash = InstructionBlock(
	block34424
)


// Action
val compute_lkp_ipv6_hash = InstructionBlock(
	block34538
)


// Action
val compute_lkp_non_ip_hash = InstructionBlock(
	block34594
)


// Action
val computed_two_hashes = InstructionBlock(
	block34626
)


// Action
val computed_one_hash = InstructionBlock(
	block34667
)


//Table
val compute_ipv4_hashes = InstructionBlock(
	Fork(compute_lkp_ipv4_hash, NoAction)
	// keys: meta.ingress_metadata.drop_flag
	// default_action NoAction
)


//Table
val compute_ipv6_hashes = InstructionBlock(
	Fork(compute_lkp_ipv6_hash, NoAction)
	// keys: meta.ingress_metadata.drop_flag
	// default_action NoAction
)


//Table
val compute_non_ip_hashes = InstructionBlock(
	Fork(compute_lkp_non_ip_hash, NoAction)
	// keys: meta.ingress_metadata.drop_flag
	// default_action NoAction
)


//Table
val compute_other_hashes = InstructionBlock(
	Fork(computed_two_hashes, computed_one_hash, NoAction)
	// keys: meta.hash_metadata.hash1
	// default_action NoAction
)


block34930
Allocate('hdr')
Allocate('meta')
Allocate('standard_metadata')
// Action
val meter_permit = InstructionBlock(
	block34960
)


// Action
val meter_deny = InstructionBlock(
	block34980
)


//Table
val meter_action = InstructionBlock(
	Fork(meter_permit, meter_deny, NoAction)
	// keys: meta.meter_metadata.packet_color, meta.meter_metadata.meter_index
	// size ConstantValue(1024)
	// default_action NoAction
<ConstructorCallExpression>35050
)


block35075
Allocate('hdr')
Allocate('meta')
Allocate('standard_metadata')
<Declaration_Instance>35111
// Action
val update_ingress_bd_stats = InstructionBlock(
	block35138
)


//Table
val ingress_bd_stats_0 = InstructionBlock(
	Fork(update_ingress_bd_stats, NoAction)
	// size ConstantValue(1024)
	// default_action NoAction
)


block35183
Allocate('hdr')
Allocate('meta')
Allocate('standard_metadata')
<Declaration_Instance>35219
// Action
val acl_stats_update = InstructionBlock(
	block35246
)


//Table
val acl_stats_0 = InstructionBlock(
	Fork(acl_stats_update, NoAction)
	// size ConstantValue(1024)
	// default_action NoAction
)


block35291
Allocate('hdr')
Allocate('meta')
Allocate('standard_metadata')
// Action
val nop = InstructionBlock(
	block35321
)


//Table
val storm_control_stats_0 = InstructionBlock(
	Fork(nop, NoAction)
	// keys: meta.meter_metadata.packet_color, standard_metadata.ingress_port
	// size ConstantValue(1024)
	// default_action NoAction
<ConstructorCallExpression>35387
)


block35401
Allocate('hdr')
Allocate('meta')
Allocate('standard_metadata')
// Action
val nop = InstructionBlock(
	block35431
)


// Action
val set_l2_redirect_action = InstructionBlock(
	block35481
)


// Action
val set_fib_redirect_action = InstructionBlock(
	block35537
)


// Action
val set_cpu_redirect_action = InstructionBlock(
	block35580
)


// Action
val set_acl_redirect_action = InstructionBlock(
	block35630
)


// Action
val set_racl_redirect_action = InstructionBlock(
	block35686
)


// Action
val set_nat_redirect_action = InstructionBlock(
	block35736
)


// Action
val set_multicast_route_action = InstructionBlock(
	block35783
)


// Action
val set_multicast_bridge_action = InstructionBlock(
	block35818
)


// Action
val set_multicast_flood = InstructionBlock(
	block35844
)


// Action
val set_multicast_drop = InstructionBlock(
	block35870
)


//Table
val fwd_result = InstructionBlock(
	Fork(nop, set_l2_redirect_action, set_fib_redirect_action, set_cpu_redirect_action, set_acl_redirect_action, set_racl_redirect_action, set_nat_redirect_action, set_multicast_route_action, set_multicast_bridge_action, set_multicast_flood, set_multicast_drop, NoAction)
	// keys: meta.l2_metadata.l2_redirect, meta.acl_metadata.acl_redirect, meta.acl_metadata.racl_redirect, meta.l3_metadata.rmac_hit, meta.l3_metadata.fib_hit, meta.nat_metadata.nat_hit, meta.l2_metadata.lkp_pkt_type, meta.l3_metadata.lkp_ip_type, meta.multicast_metadata.igmp_snooping_enabled, meta.multicast_metadata.mld_snooping_enabled, meta.multicast_metadata.mcast_route_hit, meta.multicast_metadata.mcast_bridge_hit, meta.multicast_metadata.mcast_rpf_group, meta.multicast_metadata.mcast_mode
	// size ConstantValue(512)
	// default_action NoAction
)


block36056
Allocate('hdr')
Allocate('meta')
Allocate('standard_metadata')
// Action
val nop = InstructionBlock(
	block36086
)


// Action
val set_ecmp_nexthop_details = InstructionBlock(
	Assign('ifindex', SymbolicValue()),
	Assign('bd', SymbolicValue()),
	Assign('nhop_index', SymbolicValue()),
	Assign('tunnel', SymbolicValue()),
	block36162
)


// Action
val set_ecmp_nexthop_details_for_post_routed_flood = InstructionBlock(
	Assign('bd', SymbolicValue()),
	Assign('uuc_mc_index', SymbolicValue()),
	Assign('nhop_index', SymbolicValue()),
	block36223
)


// Action
val set_nexthop_details = InstructionBlock(
	Assign('ifindex', SymbolicValue()),
	Assign('bd', SymbolicValue()),
	Assign('tunnel', SymbolicValue()),
	block36289
)


// Action
val set_nexthop_details_for_post_routed_flood = InstructionBlock(
	Assign('bd', SymbolicValue()),
	Assign('uuc_mc_index', SymbolicValue()),
	block36340
)


//Table
val ecmp_group = InstructionBlock(
	Fork(nop, set_ecmp_nexthop_details, set_ecmp_nexthop_details_for_post_routed_flood, NoAction)
	// keys: meta.l3_metadata.nexthop_index, meta.hash_metadata.hash1
	// size ConstantValue(1024)
	// default_action NoAction
<ConstructorCallExpression>36415
)


//Table
val nexthop = InstructionBlock(
	Fork(nop, set_nexthop_details, set_nexthop_details_for_post_routed_flood, NoAction)
	// keys: meta.l3_metadata.nexthop_index
	// size ConstantValue(1024)
	// default_action NoAction
)


block36497
Allocate('hdr')
Allocate('meta')
Allocate('standard_metadata')
// Action
val nop = InstructionBlock(
	block36527
)


// Action
val set_bd_flood_mc_index = InstructionBlock(
	Assign('mc_index', SymbolicValue()),
	block36551
)


//Table
val bd_flood = InstructionBlock(
	Fork(nop, set_bd_flood_mc_index, NoAction)
	// keys: meta.ingress_metadata.bd, meta.l2_metadata.lkp_pkt_type
	// size ConstantValue(1024)
	// default_action NoAction
)


block36616
Allocate('hdr')
Allocate('meta')
Allocate('standard_metadata')
// Action
val set_lag_miss = InstructionBlock(
	block36646
)


// Action
val set_lag_port = InstructionBlock(
	Assign('port', SymbolicValue()),
	block36669
)


// Action
val set_lag_remote_port = InstructionBlock(
	Assign('device', SymbolicValue()),
	Assign('port', SymbolicValue()),
	block36703
)


//Table
val lag_group = InstructionBlock(
	Fork(set_lag_miss, set_lag_port, set_lag_remote_port, NoAction)
	// keys: meta.ingress_metadata.egress_ifindex, meta.hash_metadata.hash2
	// size ConstantValue(1024)
	// default_action NoAction
<ConstructorCallExpression>36778
)


block36792




Allocate('hdr')
Allocate('meta')
Allocate('standard_metadata')
// Action
val nop = InstructionBlock(
	block36842
)


// Action
val generate_learn_notify = InstructionBlock(
	block36883
)


//Table
val learn_notify = InstructionBlock(
	Fork(nop, generate_learn_notify, NoAction)
	// keys: meta.l2_metadata.l2_src_miss, meta.l2_metadata.l2_src_move, meta.l2_metadata.stp_state
	// size ConstantValue(512)
	// default_action NoAction
)


block36964
Allocate('hdr')
Allocate('meta')
Allocate('standard_metadata')
// Action
val nop = InstructionBlock(
	block36994
)


// Action
val set_fabric_lag_port = InstructionBlock(
	Assign('port', SymbolicValue()),
	block37017
)


// Action
val set_fabric_multicast = InstructionBlock(
	Assign('fabric_mgid', SymbolicValue()),
	block37043
)


//Table
val fabric_lag = InstructionBlock(
	Fork(nop, set_fabric_lag_port, set_fabric_multicast, NoAction)
	// keys: meta.fabric_metadata.dst_device, meta.hash_metadata.hash2
	// default_action NoAction
<ConstructorCallExpression>37114
)


block37128
Allocate('hdr')
Allocate('meta')
Allocate('standard_metadata')
// Action
val nop = InstructionBlock(
	block37158
)


// Action
val set_icos = InstructionBlock(
	Assign('icos', SymbolicValue()),
	block37182
)


// Action
val set_queue = InstructionBlock(
	Assign('qid', SymbolicValue()),
	block37206
)


// Action
val set_icos_and_queue = InstructionBlock(
	Assign('icos', SymbolicValue()),
	Assign('qid', SymbolicValue()),
	block37240
)


//Table
val traffic_class = InstructionBlock(
	Fork(nop, set_icos, set_queue, set_icos_and_queue, NoAction)
	// keys: meta.qos_metadata.tc_qos_group, meta.qos_metadata.lkp_tc
	// size ConstantValue(512)
	// default_action NoAction
)


block37311
Allocate('hdr')
Allocate('meta')
Allocate('standard_metadata')
<Declaration_Instance>37347
<Declaration_Instance>37366
<Declaration_Instance>37385
// Action
val drop_stats_update = InstructionBlock(
	block37412
)


// Action
val nop = InstructionBlock(
	block37426
)


// Action
val copy_to_cpu = InstructionBlock(
	Assign('qid', SymbolicValue()),
	Assign('meter_id', SymbolicValue()),
	Assign('icos', SymbolicValue()),
	block37512
)


// Action
val redirect_to_cpu = InstructionBlock(
	Assign('qid', SymbolicValue()),
	Assign('meter_id', SymbolicValue()),
	Assign('icos', SymbolicValue()),
	block37559
)


// Action
val copy_to_cpu_with_reason = InstructionBlock(
	Assign('reason_code', SymbolicValue()),
	Assign('qid', SymbolicValue()),
	Assign('meter_id', SymbolicValue()),
	Assign('icos', SymbolicValue()),
	block37604
)


// Action
val redirect_to_cpu_with_reason = InstructionBlock(
	Assign('reason_code', SymbolicValue()),
	Assign('qid', SymbolicValue()),
	Assign('meter_id', SymbolicValue()),
	Assign('icos', SymbolicValue()),
	block37656
)


// Action
val drop_packet = InstructionBlock(
	block37676
)


// Action
val drop_packet_with_reason = InstructionBlock(
	Assign('drop_reason', SymbolicValue()),
	block37711
)


// Action
val negative_mirror = InstructionBlock(
	Assign('session_id', SymbolicValue()),
	block37759
)


//Table
val drop_stats_0 = InstructionBlock(
	Fork(drop_stats_update, NoAction)
	// size ConstantValue(1024)
	// default_action NoAction
)


//Table
val system_acl = InstructionBlock(
	Fork(nop, redirect_to_cpu, redirect_to_cpu_with_reason, copy_to_cpu, copy_to_cpu_with_reason, drop_packet, drop_packet_with_reason, negative_mirror, NoAction)
	// keys: meta.acl_metadata.if_label, meta.acl_metadata.bd_label, meta.ingress_metadata.ifindex, meta.l2_metadata.lkp_mac_type, meta.l2_metadata.port_vlan_mapping_miss, meta.security_metadata.ipsg_check_fail, meta.acl_metadata.acl_deny, meta.acl_metadata.racl_deny, meta.l3_metadata.urpf_check_fail, meta.ingress_metadata.drop_flag, meta.l3_metadata.l3_copy, meta.l3_metadata.rmac_hit, meta.l3_metadata.routed, meta.ipv6_metadata.ipv6_src_is_link_local, meta.l2_metadata.same_if_check, meta.tunnel_metadata.tunnel_if_check, meta.l3_metadata.same_bd_check, meta.l3_metadata.lkp_ip_ttl, meta.l2_metadata.stp_state, meta.ingress_metadata.control_frame, meta.ipv4_metadata.ipv4_unicast_enabled, meta.ipv6_metadata.ipv6_unicast_enabled, meta.ingress_metadata.egress_ifindex, meta.fabric_metadata.reason_code
	// size ConstantValue(512)
	// default_action NoAction
)


block38057
Allocate('hdr')
Allocate('meta')
Allocate('standard_metadata')
// Action
val rmac_hit = InstructionBlock(
	block38093
)


// Action
val rmac_miss = InstructionBlock(
	block38113
)


//Table
val rmac = InstructionBlock(
	Fork(rmac_hit, rmac_miss, NoAction)
	// keys: meta.l3_metadata.rmac_group, meta.l2_metadata.lkp_mac_da
	// size ConstantValue(1024)
	// default_action NoAction
)


<Declaration_Instance>38182
<Declaration_Instance>38196
<Declaration_Instance>38210
<Declaration_Instance>38224
<Declaration_Instance>38238
<Declaration_Instance>38252
<Declaration_Instance>38266
<Declaration_Instance>38280
<Declaration_Instance>38294
<Declaration_Instance>38308
<Declaration_Instance>38322
<Declaration_Instance>38336
<Declaration_Instance>38350
<Declaration_Instance>38364
<Declaration_Instance>38378
<Declaration_Instance>38392
<Declaration_Instance>38406
<Declaration_Instance>38420
<Declaration_Instance>38434
<Declaration_Instance>38448
<Declaration_Instance>38462
<Declaration_Instance>38476
<Declaration_Instance>38490
<Declaration_Instance>38504
<Declaration_Instance>38518
<Declaration_Instance>38532
<Declaration_Instance>38546
<Declaration_Instance>38560
<Declaration_Instance>38574
<Declaration_Instance>38588
<Declaration_Instance>38602
<Declaration_Instance>38616
<Declaration_Instance>38630
<Declaration_Instance>38644
<Declaration_Instance>38658
<Declaration_Instance>38672
<Declaration_Instance>38686
<Declaration_Instance>38700
<Declaration_Instance>38714
block39359
Allocate('packet')
Allocate('hdr')
block39802
Allocate('hdr')
Allocate('meta')
<Declaration_Instance>39821
<Declaration_Instance>39826
block39971
Allocate('hdr')
Allocate('meta')
<Declaration_Instance>39990
<Declaration_Instance>39995
block40126
<Declaration_Instance>40156

