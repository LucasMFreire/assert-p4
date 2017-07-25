#include <core.p4>
#include <v1model.p4>

struct egress_metadata_t {
    bit<9>  smac_idx;
    bit<16> bd;
    bit<1>  replica;
    bit<24> vnid;
    bit<48> mac_da;
    bit<1>  routed;
    bit<1>  mtu_check_fail;
    bit<4>  tunnel_type;
    bit<9>  tunnel_src_index;
    bit<14> tunnel_dst_index;
    bit<8>  drop_reason;
    bit<1>  egress_bypass;
}

struct ingress_metadata_t {
    bit<3>  lkp_pkt_type;
    bit<48> lkp_mac_sa;
    bit<48> lkp_mac_da;
    bit<16> lkp_mac_type;
    bit<2>  lkp_ip_type;
    bit<32> lkp_ipv4_sa;
    bit<32> lkp_ipv4_da;
    bit<8>  lkp_ip_proto;
    bit<8>  lkp_ip_tc;
    bit<8>  lkp_ip_ttl;
    bit<16> lkp_icmp_type;
    bit<16> lkp_icmp_code;
    bit<16> lkp_l4_sport;
    bit<16> lkp_l4_dport;
    bit<16> lkp_inner_l4_sport;
    bit<16> lkp_inner_l4_dport;
    bit<16> l3_length;
    bit<10> ifindex;
    bit<16> lif;
    bit<12> vrf;
    bit<4>  tunnel_type;
    bit<1>  tunnel_terminate;
    bit<24> tunnel_vni;
    bit<16> tunnel_lif;
    bit<1>  src_vtep_miss;
    bit<8>  outer_bd;
    bit<10> outer_rmac_group;
    bit<1>  outer_rmac_hit;
    bit<8>  outer_dscp;
    bit<8>  outer_ttl;
    bit<1>  l2_multicast;
    bit<1>  src_is_link_local;
    bit<16> bd;
    bit<1>  ipv4_unicast_enabled;
    bit<1>  igmp_snooping_enabled;
    bit<10> rmac_group;
    bit<1>  rmac_hit;
    bit<16> uuc_mc_index;
    bit<16> umc_mc_index;
    bit<16> bcast_mc_index;
    bit<16> multicast_bridge_mc_index;
    bit<1>  routed;
    bit<16> if_label;
    bit<16> bd_label;
    bit<1>  l2_src_miss;
    bit<10> l2_src_move;
    bit<1>  acl_deny;
    bit<1>  racl_deny;
    bit<1>  l2_redirect;
    bit<1>  acl_redirect;
    bit<1>  racl_redirect;
    bit<1>  fib_hit;
    bit<48> learn_mac;
    bit<16> l2_nexthop;
    bit<16> acl_nexthop;
    bit<16> racl_nexthop;
    bit<16> fib_nexthop;
    bit<10> l2_ecmp;
    bit<10> acl_ecmp;
    bit<10> racl_ecmp;
    bit<10> fib_ecmp;
    bit<10> ecmp_index;
    bit<14> ecmp_offset;
    bit<16> nexthop_index;
    bit<14> lag_offset;
    bit<8>  ttl;
    bit<10> egress_ifindex;
    bit<16> egress_bd;
    bit<1>  ingress_bypass;
    bit<24> ipv4_dstaddr_24b;
    bit<1>  drop_0;
    bit<8>  drop_reason;
    bit<8>  msg_type;
    bit<10> stp_group;
    bit<3>  stp_state;
    bit<1>  stp_enabled;
    bit<1>  control_frame;
}

struct intrinsic_metadata_t {
    bit<16> eg_mcast_group;
    bit<16> replication_id;
    bit<32> lf_field_list;
}

header arp_rarp_t {
    bit<16> hwType;
    bit<16> protoType;
    bit<8>  hwAddrLen;
    bit<8>  protoAddrLen;
    bit<16> opcode;
}

header arp_rarp_ipv4_t {
    bit<48> srcHwAddr;
    bit<32> srcProtoAddr;
    bit<48> dstHwAddr;
    bit<32> dstProtoAddr;
}

header cpu_header_t {
    bit<3>  qid;
    bit<1>  pad;
    bit<12> reason_code;
    bit<16> rxhash;
    bit<16> bridge_domain;
    bit<16> ingress_lif;
    bit<16> egress_lif;
    bit<1>  lu_bypass_ingress;
    bit<1>  lu_bypass_egress;
    bit<14> pad1;
    bit<16> etherType;
}

@name("erspan_header_v1_t") header erspan_header_v1_t_0 {
    bit<4>  version;
    bit<12> vlan;
    bit<6>  priority;
    bit<10> span_id;
    bit<8>  direction;
    bit<8>  truncated;
}

@name("erspan_header_v2_t") header erspan_header_v2_t_0 {
    bit<4>  version;
    bit<12> vlan;
    bit<6>  priority;
    bit<10> span_id;
    bit<32> unknown7;
}

header ethernet_t {
    bit<48> dstAddr;
    bit<48> srcAddr;
    bit<16> etherType;
}

header fcoe_header_t {
    bit<4>  version;
    bit<4>  type_;
    bit<8>  sof;
    bit<32> rsvd1;
    bit<32> ts_upper;
    bit<32> ts_lower;
    bit<32> size_;
    bit<8>  eof;
    bit<24> rsvd2;
}

header genv_t {
    bit<2>  ver;
    bit<6>  optLen;
    bit<1>  oam;
    bit<1>  critical;
    bit<6>  reserved;
    bit<16> protoType;
    bit<24> vni;
    bit<8>  reserved2;
}

header gre_t {
    bit<1>  C;
    bit<1>  R;
    bit<1>  K;
    bit<1>  S;
    bit<1>  s;
    bit<3>  recurse;
    bit<5>  flags;
    bit<3>  ver;
    bit<16> proto;
}

header icmp_t {
    bit<8>  type_;
    bit<8>  code;
    bit<16> hdrChecksum;
}

header icmpv6_t {
    bit<8>  type_;
    bit<8>  code;
    bit<16> hdrChecksum;
}

header ipv4_t {
    bit<4>  version;
    bit<4>  ihl;
    bit<8>  diffserv;
    bit<16> totalLen;
    bit<16> identification;
    bit<3>  flags;
    bit<13> fragOffset;
    bit<8>  ttl;
    bit<8>  protocol;
    bit<16> hdrChecksum;
    bit<32> srcAddr;
    bit<32> dstAddr;
}

header ipv6_t {
    bit<4>   version;
    bit<8>   trafficClass;
    bit<20>  flowLabel;
    bit<16>  payloadLen;
    bit<8>   nextHdr;
    bit<8>   hopLimit;
    bit<128> srcAddr;
    bit<128> dstAddr;
}

header tcp_t {
    bit<16> srcPort;
    bit<16> dstPort;
    bit<32> seqNo;
    bit<32> ackNo;
    bit<4>  dataOffset;
    bit<4>  res;
    bit<8>  flags;
    bit<16> window;
    bit<16> checksum;
    bit<16> urgentPtr;
}

header udp_t {
    bit<16> srcPort;
    bit<16> dstPort;
    bit<16> length_;
    bit<16> checksum;
}

header nsh_t {
    bit<1>  oam;
    bit<1>  context;
    bit<6>  flags;
    bit<8>  reserved;
    bit<16> protoType;
    bit<24> spath;
    bit<8>  sindex;
}

header nsh_context_t {
    bit<32> network_platform;
    bit<32> network_shared;
    bit<32> service_platform;
    bit<32> service_shared;
}

header nvgre_t {
    bit<24> tni;
    bit<8>  reserved;
}

header roce_header_t {
    bit<320> ib_grh;
    bit<96>  ib_bth;
}

header roce_v2_header_t {
    bit<96> ib_bth;
}

header snap_header_t {
    bit<8>  dsap;
    bit<8>  ssap;
    bit<8>  control_;
    bit<24> oui;
    bit<16> type_;
}

header vxlan_t {
    bit<8>  flags;
    bit<24> reserved;
    bit<24> vni;
    bit<8>  reserved2;
}

header vlan_tag_t {
    bit<3>  pcp;
    bit<1>  cfi;
    bit<12> vid;
    bit<16> etherType;
}

struct metadata {
    @name("egress_metadata") 
    egress_metadata_t    egress_metadata;
    @name("ingress_metadata") 
    ingress_metadata_t   ingress_metadata;
    @name("intrinsic_metadata") 
    intrinsic_metadata_t intrinsic_metadata;
}

struct headers {
    @name("arp_rarp") 
    arp_rarp_t           arp_rarp;
    @name("arp_rarp_ipv4") 
    arp_rarp_ipv4_t      arp_rarp_ipv4;
    @name("cpu_header") 
    cpu_header_t         cpu_header;
    @name("erspan_v1_header") 
    erspan_header_v1_t_0 erspan_v1_header;
    @name("erspan_v2_header") 
    erspan_header_v2_t_0 erspan_v2_header;
    @name("ethernet") 
    ethernet_t           ethernet;
    @name("fcoe") 
    fcoe_header_t        fcoe;
    @name("genv") 
    genv_t               genv;
    @name("gre") 
    gre_t                gre;
    @name("icmp") 
    icmp_t               icmp;
    @name("icmpv6") 
    icmpv6_t             icmpv6;
    @name("inner_ethernet") 
    ethernet_t           inner_ethernet;
    @name("inner_icmp") 
    icmp_t               inner_icmp;
    @name("inner_icmpv6") 
    icmpv6_t             inner_icmpv6;
    @name("inner_ipv4") 
    ipv4_t               inner_ipv4;
    @name("inner_ipv6") 
    ipv6_t               inner_ipv6;
    @name("inner_tcp") 
    tcp_t                inner_tcp;
    @name("inner_udp") 
    udp_t                inner_udp;
    @name("ipv4") 
    ipv4_t               ipv4;
    @name("ipv6") 
    ipv6_t               ipv6;
    @name("nsh") 
    nsh_t                nsh;
    @name("nsh_context") 
    nsh_context_t        nsh_context;
    @name("nvgre") 
    nvgre_t              nvgre;
    @name("roce") 
    roce_header_t        roce;
    @name("roce_v2") 
    roce_v2_header_t     roce_v2;
    @name("snap_header") 
    snap_header_t        snap_header;
    @name("tcp") 
    tcp_t                tcp;
    @name("udp") 
    udp_t                udp;
    @name("vxlan") 
    vxlan_t              vxlan;
    @name(".vlan_tag_") 
    vlan_tag_t[2]        vlan_tag_;
}

parser ParserImpl(packet_in packet, out headers hdr, inout metadata meta, inout standard_metadata_t standard_metadata) {
    @name(".parse_arp_rarp") state parse_arp_rarp {
        packet.extract(hdr.arp_rarp);
        transition select(hdr.arp_rarp.protoType) {
            16w0x800: parse_arp_rarp_ipv4;
            default: accept;
        }
    }
    @name(".parse_arp_rarp_ipv4") state parse_arp_rarp_ipv4 {
        packet.extract(hdr.arp_rarp_ipv4);
        transition accept;
    }
    @name(".parse_cpu_header") state parse_cpu_header {
        packet.extract(hdr.cpu_header);
        meta.ingress_metadata.ingress_bypass = 1w1;
        standard_metadata.egress_spec = (bit<9>)hdr.cpu_header.egress_lif;
        transition select(hdr.cpu_header.etherType) {
            16w0 &&& 16w0xf800: parse_snap_header;
            16w0x8100: parse_vlan;
            16w0x9100: parse_vlan;
            16w0x9200: parse_vlan;
            16w0x9300: parse_vlan;
            16w0x800: parse_ipv4;
            16w0x86dd: parse_ipv6;
            16w0x806: parse_arp_rarp;
            16w0x8035: parse_arp_rarp;
            16w0x894f: parse_nsh;
            16w0x8915: parse_roce;
            16w0x8906: parse_fcoe;
            default: accept;
        }
    }
    @name(".parse_erspan_v1") state parse_erspan_v1 {
        packet.extract(hdr.erspan_v1_header);
        transition accept;
    }
    @name(".parse_erspan_v2") state parse_erspan_v2 {
        packet.extract(hdr.erspan_v2_header);
        transition accept;
    }
    @name(".parse_ethernet") state parse_ethernet {
        packet.extract(hdr.ethernet);
        transition select(hdr.ethernet.etherType) {
            16w0 &&& 16w0xf800: parse_snap_header;
            16w0x9000: parse_cpu_header;
            16w0x10c: parse_cpu_header;
            16w0x8100: parse_vlan;
            16w0x9100: parse_vlan;
            16w0x9200: parse_vlan;
            16w0x9300: parse_vlan;
            16w0x800: parse_ipv4;
            16w0x86dd: parse_ipv6;
            16w0x806: parse_arp_rarp;
            16w0x8035: parse_arp_rarp;
            16w0x894f: parse_nsh;
            16w0x8915: parse_roce;
            16w0x8906: parse_fcoe;
            default: accept;
        }
    }
    @name(".parse_fcoe") state parse_fcoe {
        packet.extract(hdr.fcoe);
        transition accept;
    }
    @name(".parse_geneve") state parse_geneve {
        packet.extract(hdr.genv);
        meta.ingress_metadata.tunnel_vni = hdr.genv.vni;
        meta.ingress_metadata.tunnel_type = 4w3;
        transition parse_genv_inner;
    }
    @name(".parse_genv_inner") state parse_genv_inner {
        transition select(hdr.genv.protoType) {
            16w0x6558: parse_inner_ethernet;
            16w0x800: parse_inner_ipv4;
            16w0x86dd: parse_inner_ipv6;
            default: accept;
        }
    }
    @name(".parse_gre") state parse_gre {
        packet.extract(hdr.gre);
        meta.ingress_metadata.tunnel_type = 4w2;
        transition select(hdr.gre.K, hdr.gre.proto) {
            (1w0x0, 16w0x6558): parse_nvgre;
            (1w0x0, 16w0x88be): parse_erspan_v1;
            (1w0x0, 16w0x22eb): parse_erspan_v2;
            (1w0x0, 16w0x894f): parse_nsh;
            default: accept;
        }
    }
    @name(".parse_icmp") state parse_icmp {
        packet.extract(hdr.icmp);
        meta.ingress_metadata.msg_type = hdr.icmp.code;
        transition accept;
    }
    @name(".parse_icmpv6") state parse_icmpv6 {
        packet.extract(hdr.icmpv6);
        meta.ingress_metadata.msg_type = hdr.icmpv6.code;
        transition accept;
    }
    @name(".parse_inner_ethernet") state parse_inner_ethernet {
        packet.extract(hdr.inner_ethernet);
        transition select(hdr.inner_ethernet.etherType) {
            16w0x800: parse_inner_ipv4;
            16w0x86dd: parse_inner_ipv6;
            default: accept;
        }
    }
    @name(".parse_inner_icmp") state parse_inner_icmp {
        packet.extract(hdr.inner_icmp);
        transition accept;
    }
    @name(".parse_inner_icmpv6") state parse_inner_icmpv6 {
        packet.extract(hdr.inner_icmpv6);
        transition accept;
    }
    @name(".parse_inner_ipv4") state parse_inner_ipv4 {
        packet.extract(hdr.inner_ipv4);
        transition select(hdr.inner_ipv4.fragOffset, hdr.inner_ipv4.protocol) {
            (13w0, 8w1): parse_inner_icmp;
            (13w0, 8w6): parse_inner_tcp;
            (13w0, 8w17): parse_inner_udp;
            default: accept;
        }
    }
    @name(".parse_inner_ipv6") state parse_inner_ipv6 {
        packet.extract(hdr.inner_ipv6);
        transition select(hdr.inner_ipv6.nextHdr) {
            8w58: parse_inner_icmpv6;
            8w6: parse_inner_tcp;
            8w17: parse_inner_udp;
            default: accept;
        }
    }
    @name(".parse_inner_tcp") state parse_inner_tcp {
        packet.extract(hdr.inner_tcp);
        meta.ingress_metadata.lkp_inner_l4_sport = hdr.inner_tcp.srcPort;
        meta.ingress_metadata.lkp_inner_l4_dport = hdr.inner_tcp.dstPort;
        transition accept;
    }
    @name(".parse_inner_udp") state parse_inner_udp {
        packet.extract(hdr.inner_udp);
        meta.ingress_metadata.lkp_inner_l4_sport = hdr.inner_udp.srcPort;
        meta.ingress_metadata.lkp_inner_l4_dport = hdr.inner_udp.dstPort;
        transition accept;
    }
    @name(".parse_ipv4") state parse_ipv4 {
        packet.extract(hdr.ipv4);
        meta.ingress_metadata.ipv4_dstaddr_24b = (bit<24>)hdr.ipv4.dstAddr;
        transition select(hdr.ipv4.fragOffset, hdr.ipv4.protocol) {
            (13w0, 8w1): parse_icmp;
            (13w0, 8w6): parse_tcp;
            (13w0, 8w17): parse_udp;
            (13w0, 8w47): parse_gre;
            default: accept;
        }
    }
    @name(".parse_ipv6") state parse_ipv6 {
        packet.extract(hdr.ipv6);
        transition select(hdr.ipv6.nextHdr) {
            8w58: parse_icmpv6;
            8w6: parse_tcp;
            8w17: parse_udp;
            8w47: parse_gre;
            default: accept;
        }
    }
    @name(".parse_nsh") state parse_nsh {
        packet.extract(hdr.nsh);
        packet.extract(hdr.nsh_context);
        transition select(hdr.nsh.protoType) {
            16w0x800: parse_inner_ipv4;
            16w0x86dd: parse_inner_ipv6;
            16w0x6558: parse_inner_ethernet;
            default: accept;
        }
    }
    @name(".parse_nvgre") state parse_nvgre {
        packet.extract(hdr.nvgre);
        meta.ingress_metadata.tunnel_type = 4w4;
        meta.ingress_metadata.tunnel_vni = hdr.nvgre.tni;
        transition parse_inner_ethernet;
    }
    @name(".parse_roce") state parse_roce {
        packet.extract(hdr.roce);
        transition accept;
    }
    @name(".parse_roce_v2") state parse_roce_v2 {
        packet.extract(hdr.roce_v2);
        transition accept;
    }
    @name(".parse_snap_header") state parse_snap_header {
        packet.extract(hdr.snap_header);
        transition accept;
    }
    @name(".parse_tcp") state parse_tcp {
        packet.extract(hdr.tcp);
        meta.ingress_metadata.lkp_l4_sport = hdr.tcp.srcPort;
        meta.ingress_metadata.lkp_l4_dport = hdr.tcp.dstPort;
        transition accept;
    }
    @name(".parse_udp") state parse_udp {
        packet.extract(hdr.udp);
        meta.ingress_metadata.lkp_l4_sport = hdr.udp.srcPort;
        meta.ingress_metadata.lkp_l4_dport = hdr.udp.dstPort;
        transition select(hdr.udp.dstPort) {
            16w4789: parse_vxlan;
            16w6081: parse_geneve;
            16w1021: parse_roce_v2;
            default: accept;
        }
    }
    @name(".parse_vlan") state parse_vlan {
        packet.extract(hdr.vlan_tag_.next);
        transition select(hdr.vlan_tag_.last.etherType) {
            16w0x8100: parse_vlan;
            16w0x9100: parse_vlan;
            16w0x9200: parse_vlan;
            16w0x9300: parse_vlan;
            16w0x800: parse_ipv4;
            16w0x86dd: parse_ipv6;
            16w0x806: parse_arp_rarp;
            16w0x8035: parse_arp_rarp;
            default: accept;
        }
    }
    @name(".parse_vxlan") state parse_vxlan {
        packet.extract(hdr.vxlan);
        meta.ingress_metadata.tunnel_type = 4w1;
        meta.ingress_metadata.tunnel_vni = hdr.vxlan.vni;
        transition parse_inner_ethernet;
    }
    @name(".start") state start {
        meta.ingress_metadata.drop_0 = 1w0;
        transition parse_ethernet;
    }
}

control egress(inout headers hdr, inout metadata meta, inout standard_metadata_t standard_metadata) {
    @name(".nop") action nop() {
    }
    @name(".set_cpu_tx_rewrite") action set_cpu_tx_rewrite() {
        hdr.ethernet.etherType = hdr.cpu_header.etherType;
        hdr.cpu_header.setInvalid();
    }
    @name(".set_cpu_rx_rewrite") action set_cpu_rx_rewrite() {
        hdr.cpu_header.setValid();
        hdr.cpu_header.etherType = hdr.ethernet.etherType;
        hdr.cpu_header.ingress_lif = (bit<16>)standard_metadata.ingress_port;
    }
    @name(".set_egress_bd_properties") action set_egress_bd_properties(bit<24> vnid) {
        meta.egress_metadata.vnid = vnid;
    }
    @name(".on_miss") action on_miss() {
    }
    @name(".egress_drop") action egress_drop() {
        mark_to_drop();
    }
    @name(".egress_redirect_to_cpu") action egress_redirect_to_cpu() {
    }
    @name(".set_egress_packet_vlan_tagged") action set_egress_packet_vlan_tagged(bit<12> vlan_id) {
        hdr.vlan_tag_[0].setValid();
        hdr.vlan_tag_[0].vid = vlan_id;
    }
    @name(".set_egress_packet_vlan_untagged") action set_egress_packet_vlan_untagged() {
        hdr.vlan_tag_[0].setInvalid();
    }
    @name(".rewrite_unicast_mac") action rewrite_unicast_mac(bit<48> smac) {
        hdr.ethernet.srcAddr = smac;
        hdr.ethernet.dstAddr = meta.egress_metadata.mac_da;
    }
    @name(".rewrite_multicast_mac") action rewrite_multicast_mac(bit<48> smac) {
        hdr.ethernet.srcAddr = smac;
        hdr.ethernet.dstAddr = 48w0x1005e000000;
        hdr.ethernet.dstAddr[22:0] = ((bit<48>)hdr.ipv4.dstAddr)[22:0];
        hdr.ipv4.ttl = hdr.ipv4.ttl + 8w255;
    }
    @name(".set_l2_rewrite") action set_l2_rewrite() {
        meta.egress_metadata.routed = 1w0;
    }
    @name(".set_ipv4_unicast_rewrite") action set_ipv4_unicast_rewrite(bit<9> smac_idx, bit<48> dmac) {
        meta.egress_metadata.smac_idx = smac_idx;
        meta.egress_metadata.mac_da = dmac;
        meta.egress_metadata.routed = 1w1;
        hdr.ipv4.ttl = meta.ingress_metadata.ttl;
    }
    @name(".set_ipv4_vxlan_rewrite") action set_ipv4_vxlan_rewrite(bit<16> outer_bd, bit<9> tunnel_src_index, bit<14> tunnel_dst_index, bit<9> smac_idx, bit<48> dmac) {
        meta.egress_metadata.bd = outer_bd;
        meta.egress_metadata.smac_idx = smac_idx;
        meta.egress_metadata.mac_da = dmac;
        meta.egress_metadata.tunnel_src_index = tunnel_src_index;
        meta.egress_metadata.tunnel_dst_index = tunnel_dst_index;
        meta.egress_metadata.routed = 1w1;
        meta.egress_metadata.tunnel_type = 4w1;
    }
    @name(".set_ipv4_geneve_rewrite") action set_ipv4_geneve_rewrite(bit<16> outer_bd, bit<9> tunnel_src_index, bit<14> tunnel_dst_index, bit<9> smac_idx, bit<48> dmac) {
        meta.egress_metadata.bd = outer_bd;
        meta.egress_metadata.smac_idx = smac_idx;
        meta.egress_metadata.mac_da = dmac;
        meta.egress_metadata.tunnel_src_index = tunnel_src_index;
        meta.egress_metadata.tunnel_dst_index = tunnel_dst_index;
        meta.egress_metadata.routed = 1w1;
        meta.egress_metadata.tunnel_type = 4w2;
    }
    @name(".set_ipv4_nvgre_rewrite") action set_ipv4_nvgre_rewrite(bit<16> outer_bd, bit<9> tunnel_src_index, bit<14> tunnel_dst_index, bit<9> smac_idx, bit<48> dmac) {
        meta.egress_metadata.bd = outer_bd;
        meta.egress_metadata.smac_idx = smac_idx;
        meta.egress_metadata.mac_da = dmac;
        meta.egress_metadata.tunnel_src_index = tunnel_src_index;
        meta.egress_metadata.tunnel_dst_index = tunnel_dst_index;
        meta.egress_metadata.routed = 1w1;
        meta.egress_metadata.tunnel_type = 4w3;
    }
    @name(".set_ipv4_erspan_v2_rewrite") action set_ipv4_erspan_v2_rewrite(bit<16> outer_bd, bit<9> tunnel_src_index, bit<14> tunnel_dst_index, bit<9> smac_idx, bit<48> dmac) {
        meta.egress_metadata.bd = outer_bd;
        meta.egress_metadata.smac_idx = smac_idx;
        meta.egress_metadata.mac_da = dmac;
        meta.egress_metadata.tunnel_src_index = tunnel_src_index;
        meta.egress_metadata.tunnel_dst_index = tunnel_dst_index;
        meta.egress_metadata.routed = 1w1;
        meta.egress_metadata.tunnel_type = 4w4;
    }
    @name(".replica_from_rid") action replica_from_rid(bit<16> bd) {
        meta.ingress_metadata.egress_bd = bd;
        meta.egress_metadata.replica = 1w1;
    }
    @name(".decapsulate_vxlan_packet_inner_ipv4_udp") action decapsulate_vxlan_packet_inner_ipv4_udp() {
        hdr.ethernet = hdr.inner_ethernet;
        hdr.ipv4.setValid();
        hdr.ipv4 = hdr.inner_ipv4;
        hdr.udp = hdr.inner_udp;
        hdr.inner_ethernet.setInvalid();
        hdr.inner_ipv4.setInvalid();
        hdr.inner_udp.setInvalid();
        hdr.vxlan.setInvalid();
        meta.ingress_metadata.ttl = meta.ingress_metadata.outer_ttl;
    }
    @name(".decapsulate_vxlan_packet_inner_ipv4_tcp") action decapsulate_vxlan_packet_inner_ipv4_tcp() {
        hdr.ethernet = hdr.inner_ethernet;
        hdr.ipv4.setValid();
        hdr.ipv4 = hdr.inner_ipv4;
        hdr.tcp.setValid();
        hdr.tcp = hdr.inner_tcp;
        hdr.inner_ethernet.setInvalid();
        hdr.inner_ipv4.setInvalid();
        hdr.inner_tcp.setInvalid();
        hdr.udp.setInvalid();
        hdr.vxlan.setInvalid();
        meta.ingress_metadata.ttl = meta.ingress_metadata.outer_ttl;
    }
    @name(".decapsulate_geneve_packet_inner_ipv4_udp") action decapsulate_geneve_packet_inner_ipv4_udp() {
        hdr.ethernet = hdr.inner_ethernet;
        hdr.ipv4.setValid();
        hdr.ipv4 = hdr.inner_ipv4;
        hdr.udp = hdr.inner_udp;
        hdr.inner_ethernet.setInvalid();
        hdr.inner_ipv4.setInvalid();
        hdr.inner_udp.setInvalid();
        hdr.genv.setInvalid();
        meta.ingress_metadata.ttl = meta.ingress_metadata.outer_ttl;
    }
    @name(".decapsulate_geneve_packet_inner_ipv4_tcp") action decapsulate_geneve_packet_inner_ipv4_tcp() {
        hdr.ethernet = hdr.inner_ethernet;
        hdr.ipv4.setValid();
        hdr.ipv4 = hdr.inner_ipv4;
        hdr.tcp.setValid();
        hdr.tcp = hdr.inner_tcp;
        hdr.inner_ethernet.setInvalid();
        hdr.inner_ipv4.setInvalid();
        hdr.inner_tcp.setInvalid();
        hdr.udp.setInvalid();
        hdr.genv.setInvalid();
        meta.ingress_metadata.ttl = meta.ingress_metadata.outer_ttl;
    }
    @name(".decapsulate_nvgre_packet_inner_ipv4_udp") action decapsulate_nvgre_packet_inner_ipv4_udp() {
        hdr.ethernet = hdr.inner_ethernet;
        hdr.ipv4.setValid();
        hdr.ipv4 = hdr.inner_ipv4;
        hdr.udp = hdr.inner_udp;
        hdr.inner_ethernet.setInvalid();
        hdr.inner_ipv4.setInvalid();
        hdr.inner_udp.setInvalid();
        hdr.nvgre.setInvalid();
        hdr.gre.setInvalid();
        meta.ingress_metadata.ttl = meta.ingress_metadata.outer_ttl;
    }
    @name(".decapsulate_nvgre_packet_inner_ipv4_tcp") action decapsulate_nvgre_packet_inner_ipv4_tcp() {
        hdr.ethernet = hdr.inner_ethernet;
        hdr.ipv4.setValid();
        hdr.ipv4 = hdr.inner_ipv4;
        hdr.tcp.setValid();
        hdr.tcp = hdr.inner_tcp;
        hdr.inner_ethernet.setInvalid();
        hdr.inner_ipv4.setInvalid();
        hdr.inner_tcp.setInvalid();
        hdr.nvgre.setInvalid();
        hdr.gre.setInvalid();
        meta.ingress_metadata.ttl = meta.ingress_metadata.outer_ttl;
    }
    @name(".rewrite_tunnel_ipv4_dst") action rewrite_tunnel_ipv4_dst(bit<32> ip) {
        hdr.ipv4.dstAddr = ip;
    }
    @name(".f_copy_ipv4_to_inner") action f_copy_ipv4_to_inner() {
        hdr.inner_ethernet.setValid();
        hdr.inner_ethernet = hdr.ethernet;
        hdr.inner_ipv4.setValid();
        hdr.inner_ipv4 = hdr.ipv4;
        hdr.inner_ipv4.ttl = meta.ingress_metadata.ttl;
        hdr.ipv4.setInvalid();
    }
    @name(".f_copy_ipv4_udp_to_inner") action f_copy_ipv4_udp_to_inner() {
        f_copy_ipv4_to_inner();
        hdr.inner_udp.setValid();
        hdr.inner_udp = hdr.udp;
        hdr.udp.setInvalid();
    }
    @name(".f_insert_vxlan_header") action f_insert_vxlan_header() {
        hdr.udp.setValid();
        hdr.vxlan.setValid();
        hash(hdr.udp.srcPort, HashAlgorithm.crc16, (bit<16>)0, { hdr.inner_ethernet.srcAddr, hdr.inner_ethernet.dstAddr, hdr.inner_ethernet.etherType, hdr.inner_ipv4.srcAddr, hdr.inner_ipv4.dstAddr, hdr.inner_ipv4.protocol }, (bit<32>)16384);
        hdr.udp.dstPort = 16w4789;
        hdr.udp.checksum = 16w0;
        hdr.udp.length_ = meta.ingress_metadata.l3_length;
        hdr.udp.length_ = hdr.udp.length_ + 16w30;
        hdr.vxlan.flags = 8w0x8;
        hdr.vxlan.vni = meta.egress_metadata.vnid;
    }
    @name(".f_insert_ipv4_header") action f_insert_ipv4_header(bit<8> proto) {
        hdr.ipv4.setValid();
        hdr.ipv4.protocol = proto;
        hdr.ipv4.ttl = meta.ingress_metadata.ttl;
        hdr.ipv4.version = 4w0x4;
        hdr.ipv4.ihl = 4w0x5;
    }
    @name(".ipv4_vxlan_inner_ipv4_udp_rewrite") action ipv4_vxlan_inner_ipv4_udp_rewrite() {
        f_copy_ipv4_udp_to_inner();
        f_insert_vxlan_header();
        f_insert_ipv4_header(8w17);
        hdr.ipv4.totalLen = meta.ingress_metadata.l3_length;
        hdr.ipv4.totalLen = hdr.ipv4.totalLen + 16w50;
    }
    @name(".f_copy_ipv4_tcp_to_inner") action f_copy_ipv4_tcp_to_inner() {
        f_copy_ipv4_to_inner();
        hdr.inner_tcp.setValid();
        hdr.inner_tcp = hdr.tcp;
        hdr.tcp.setInvalid();
    }
    @name(".ipv4_vxlan_inner_ipv4_tcp_rewrite") action ipv4_vxlan_inner_ipv4_tcp_rewrite() {
        f_copy_ipv4_tcp_to_inner();
        f_insert_vxlan_header();
        f_insert_ipv4_header(8w17);
        hdr.ipv4.totalLen = meta.ingress_metadata.l3_length;
        hdr.ipv4.totalLen = hdr.ipv4.totalLen + 16w50;
    }
    @name(".f_insert_genv_header") action f_insert_genv_header() {
        hdr.udp.setValid();
        hdr.genv.setValid();
        hash(hdr.udp.srcPort, HashAlgorithm.crc16, (bit<16>)0, { hdr.inner_ethernet.srcAddr, hdr.inner_ethernet.dstAddr, hdr.inner_ethernet.etherType, hdr.inner_ipv4.srcAddr, hdr.inner_ipv4.dstAddr, hdr.inner_ipv4.protocol }, (bit<32>)16384);
        hdr.udp.dstPort = 16w6081;
        hdr.udp.checksum = 16w0;
        hdr.udp.length_ = meta.ingress_metadata.l3_length;
        hdr.udp.length_ = hdr.udp.length_ + 16w30;
        hdr.genv.ver = 2w0;
        hdr.genv.oam = 1w0;
        hdr.genv.critical = 1w0;
        hdr.genv.optLen = 6w0;
        hdr.genv.protoType = 16w0x6558;
        hdr.genv.vni = meta.egress_metadata.vnid;
    }
    @name(".ipv4_genv_inner_ipv4_udp_rewrite") action ipv4_genv_inner_ipv4_udp_rewrite() {
        f_copy_ipv4_udp_to_inner();
        f_insert_genv_header();
        f_insert_ipv4_header(8w17);
        hdr.ipv4.totalLen = meta.ingress_metadata.l3_length;
        hdr.ipv4.totalLen = hdr.ipv4.totalLen + 16w50;
    }
    @name(".ipv4_genv_inner_ipv4_tcp_rewrite") action ipv4_genv_inner_ipv4_tcp_rewrite() {
        f_copy_ipv4_tcp_to_inner();
        f_insert_genv_header();
        f_insert_ipv4_header(8w17);
        hdr.ipv4.totalLen = meta.ingress_metadata.l3_length;
        hdr.ipv4.totalLen = hdr.ipv4.totalLen + 16w50;
    }
    @name(".f_insert_nvgre_header") action f_insert_nvgre_header() {
        hdr.gre.setValid();
        hdr.nvgre.setValid();
        hdr.gre.proto = 16w0x6558;
        hdr.gre.K = 1w1;
        hdr.gre.C = 1w0;
        hdr.gre.S = 1w0;
        hdr.nvgre.tni = meta.egress_metadata.vnid;
    }
    @name(".ipv4_nvgre_inner_ipv4_udp_rewrite") action ipv4_nvgre_inner_ipv4_udp_rewrite() {
        f_copy_ipv4_udp_to_inner();
        f_insert_nvgre_header();
        f_insert_ipv4_header(8w47);
        hdr.ipv4.totalLen = meta.ingress_metadata.l3_length;
        hdr.ipv4.totalLen = hdr.ipv4.totalLen + 16w42;
    }
    @name(".ipv4_nvgre_inner_ipv4_tcp_rewrite") action ipv4_nvgre_inner_ipv4_tcp_rewrite() {
        f_copy_ipv4_tcp_to_inner();
        f_insert_nvgre_header();
        f_insert_ipv4_header(8w47);
        hdr.ipv4.totalLen = meta.ingress_metadata.l3_length;
        hdr.ipv4.totalLen = hdr.ipv4.totalLen + 16w42;
    }
    @name(".f_insert_erspan_v2_header") action f_insert_erspan_v2_header() {
        hdr.gre.setValid();
        hdr.erspan_v2_header.setValid();
        hdr.gre.proto = 16w0x22eb;
        hdr.erspan_v2_header.version = 4w1;
        hdr.erspan_v2_header.vlan = (bit<12>)meta.egress_metadata.vnid;
    }
    @name(".ipv4_erspan_v2_inner_ipv4_udp_rewrite") action ipv4_erspan_v2_inner_ipv4_udp_rewrite() {
        f_copy_ipv4_udp_to_inner();
        f_insert_erspan_v2_header();
        f_insert_ipv4_header(8w47);
        hdr.ipv4.totalLen = meta.ingress_metadata.l3_length;
        hdr.ipv4.totalLen = hdr.ipv4.totalLen + 16w46;
    }
    @name(".ipv4_erspan_v2_inner_ipv4_tcp_rewrite") action ipv4_erspan_v2_inner_ipv4_tcp_rewrite() {
        f_copy_ipv4_tcp_to_inner();
        f_insert_erspan_v2_header();
        f_insert_ipv4_header(8w47);
        hdr.ipv4.totalLen = meta.ingress_metadata.l3_length;
        hdr.ipv4.totalLen = hdr.ipv4.totalLen + 16w46;
    }
    @name(".rewrite_tunnel_ipv4_src") action rewrite_tunnel_ipv4_src(bit<32> ip) {
        hdr.ipv4.srcAddr = ip;
    }
    @name(".cpu_rewrite") table cpu_rewrite {
        actions = {
            nop;
            set_cpu_tx_rewrite;
            set_cpu_rx_rewrite;
        }
        key = {
            standard_metadata.egress_port : ternary;
            standard_metadata.ingress_port: ternary;
        }
        size = 512;
    }
    @name(".egress_bd_map") table egress_bd_map {
        actions = {
            nop;
            set_egress_bd_properties;
        }
        key = {
            meta.ingress_metadata.egress_bd: exact;
        }
        size = 512;
    }
    @name(".egress_block") table egress_block {
        actions = {
            on_miss;
            egress_drop;
        }
        key = {
            standard_metadata.egress_port         : exact;
            meta.intrinsic_metadata.replication_id: exact;
        }
        size = 256;
    }
    @name(".egress_system_acl") table egress_system_acl {
        actions = {
            nop;
            egress_redirect_to_cpu;
        }
        key = {
            meta.egress_metadata.mtu_check_fail: ternary;
        }
        size = 512;
    }
    @name(".egress_vlan_xlate") table egress_vlan_xlate {
        actions = {
            nop;
            set_egress_packet_vlan_tagged;
            set_egress_packet_vlan_untagged;
        }
        key = {
            standard_metadata.egress_port: exact;
            meta.egress_metadata.bd      : exact;
        }
        size = 512;
    }
    @name(".outer_mac") table outer_mac {
        actions = {
            nop;
            rewrite_unicast_mac;
            rewrite_multicast_mac;
        }
        key = {
            meta.egress_metadata.smac_idx: exact;
            hdr.ipv4.dstAddr             : ternary;
        }
        size = 512;
    }
    @name(".rewrite") table rewrite {
        actions = {
            nop;
            set_l2_rewrite;
            set_ipv4_unicast_rewrite;
            set_ipv4_vxlan_rewrite;
            set_ipv4_geneve_rewrite;
            set_ipv4_nvgre_rewrite;
            set_ipv4_erspan_v2_rewrite;
        }
        key = {
            meta.ingress_metadata.nexthop_index: exact;
        }
        size = 512;
    }
    @name(".rid") table rid {
        actions = {
            nop;
            replica_from_rid;
        }
        key = {
            meta.intrinsic_metadata.replication_id: exact;
        }
        size = 512;
    }
    @name(".tunnel_decap") table tunnel_decap {
        actions = {
            decapsulate_vxlan_packet_inner_ipv4_udp;
            decapsulate_vxlan_packet_inner_ipv4_tcp;
            decapsulate_geneve_packet_inner_ipv4_udp;
            decapsulate_geneve_packet_inner_ipv4_tcp;
            decapsulate_nvgre_packet_inner_ipv4_udp;
            decapsulate_nvgre_packet_inner_ipv4_tcp;
        }
        key = {
            meta.ingress_metadata.tunnel_type: exact;
            hdr.inner_ipv4.isValid()         : exact;
            hdr.inner_tcp.isValid()          : exact;
            hdr.inner_udp.isValid()          : exact;
        }
        size = 512;
    }
    @name(".tunnel_dst_rewrite") table tunnel_dst_rewrite {
        actions = {
            rewrite_tunnel_ipv4_dst;
        }
        key = {
            meta.egress_metadata.tunnel_dst_index: exact;
        }
        size = 512;
    }
    @name(".tunnel_rewrite") table tunnel_rewrite {
        actions = {
            ipv4_vxlan_inner_ipv4_udp_rewrite;
            ipv4_vxlan_inner_ipv4_tcp_rewrite;
            ipv4_genv_inner_ipv4_udp_rewrite;
            ipv4_genv_inner_ipv4_tcp_rewrite;
            ipv4_nvgre_inner_ipv4_udp_rewrite;
            ipv4_nvgre_inner_ipv4_tcp_rewrite;
            ipv4_erspan_v2_inner_ipv4_udp_rewrite;
            ipv4_erspan_v2_inner_ipv4_tcp_rewrite;
        }
        key = {
            meta.egress_metadata.tunnel_type: exact;
            hdr.ipv4.isValid()              : exact;
            hdr.tcp.isValid()               : exact;
            hdr.udp.isValid()               : exact;
        }
        size = 256;
    }
    @name(".tunnel_src_rewrite") table tunnel_src_rewrite {
        actions = {
            rewrite_tunnel_ipv4_src;
        }
        key = {
            meta.egress_metadata.tunnel_src_index: exact;
        }
        size = 512;
    }
    apply {
        if (meta.egress_metadata.egress_bypass == 1w0) {
            if (meta.intrinsic_metadata.replication_id != 16w0) {
                rid.apply();
            }
            if (meta.ingress_metadata.tunnel_terminate == 1w1) {
                if (meta.egress_metadata.replica == 1w0) {
                    tunnel_decap.apply();
                }
            }
            egress_bd_map.apply();
            rewrite.apply();
            if (meta.egress_metadata.tunnel_type != 4w0) {
                tunnel_rewrite.apply();
                tunnel_src_rewrite.apply();
                tunnel_dst_rewrite.apply();
            }
            if (meta.egress_metadata.routed == 1w1) {
                outer_mac.apply();
            }
            switch (egress_block.apply().action_run) {
                on_miss: {
                    egress_vlan_xlate.apply();
                }
            }

            egress_system_acl.apply();
            cpu_rewrite.apply();
        }
    }
}

@name("mac_learn_digest") struct mac_learn_digest {
    bit<16> bd;
    bit<48> lkp_mac_sa;
    bit<10> ifindex;
}

control ingress(inout headers hdr, inout metadata meta, inout standard_metadata_t standard_metadata) {
    @name(".ip_acl_counters") direct_counter(CounterType.packets) ip_acl_counters;
    @name(".set_bd_info") action set_bd_info(bit<12> vrf, bit<10> rmac_group, bit<16> bd_label, bit<16> uuc_mc_index, bit<16> bcast_mc_index, bit<16> umc_mc_index, bit<1> ipv4_unicast_enabled, bit<1> igmp_snooping_enabled, bit<10> stp_group) {
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
    @name(".nop") action nop() {
    }
    @name(".dmac_hit") action dmac_hit(bit<10> ifindex) {
        meta.ingress_metadata.egress_ifindex = ifindex;
        meta.ingress_metadata.egress_bd = meta.ingress_metadata.bd;
    }
    @name(".dmac_multicast_hit") action dmac_multicast_hit(bit<16> mc_index) {
        meta.intrinsic_metadata.eg_mcast_group = mc_index;
        meta.ingress_metadata.egress_bd = meta.ingress_metadata.bd;
    }
    @name(".dmac_miss") action dmac_miss() {
        meta.intrinsic_metadata.eg_mcast_group = meta.ingress_metadata.uuc_mc_index;
    }
    @name(".dmac_redirect_nexthop") action dmac_redirect_nexthop(bit<16> nexthop_index) {
        meta.ingress_metadata.l2_redirect = 1w1;
        meta.ingress_metadata.l2_nexthop = nexthop_index;
    }
    @name(".dmac_redirect_ecmp") action dmac_redirect_ecmp(bit<10> ecmp_index) {
        meta.ingress_metadata.l2_redirect = 1w1;
        meta.ingress_metadata.l2_ecmp = ecmp_index;
    }
    @name(".set_ecmp_nexthop_details") action set_ecmp_nexthop_details(bit<10> ifindex, bit<16> bd, bit<16> nhop_index) {
        meta.ingress_metadata.egress_ifindex = ifindex;
        meta.ingress_metadata.egress_bd = bd;
        meta.ingress_metadata.nexthop_index = nhop_index;
    }
    @name(".set_ecmp_nexthop_details_for_post_routed_flood") action set_ecmp_nexthop_details_for_post_routed_flood(bit<16> bd, bit<16> uuc_mc_index, bit<16> nhop_index) {
        meta.intrinsic_metadata.eg_mcast_group = uuc_mc_index;
        meta.ingress_metadata.egress_bd = bd;
        meta.ingress_metadata.nexthop_index = nhop_index;
    }
    @name(".set_l2_redirect_action") action set_l2_redirect_action() {
        meta.ingress_metadata.nexthop_index = meta.ingress_metadata.l2_nexthop;
        meta.ingress_metadata.ecmp_index = meta.ingress_metadata.l2_ecmp;
        meta.ingress_metadata.ttl = meta.ingress_metadata.lkp_ip_ttl;
    }
    @name(".set_acl_redirect_action") action set_acl_redirect_action() {
        meta.ingress_metadata.nexthop_index = meta.ingress_metadata.acl_nexthop;
        meta.ingress_metadata.ecmp_index = meta.ingress_metadata.acl_ecmp;
    }
    @name(".set_racl_redirect_action") action set_racl_redirect_action() {
        meta.ingress_metadata.nexthop_index = meta.ingress_metadata.racl_nexthop;
        meta.ingress_metadata.ecmp_index = meta.ingress_metadata.racl_ecmp;
        meta.ingress_metadata.routed = 1w1;
        meta.ingress_metadata.ttl = meta.ingress_metadata.lkp_ip_ttl;
        meta.ingress_metadata.ttl = meta.ingress_metadata.ttl + 8w255;
    }
    @name(".set_fib_redirect_action") action set_fib_redirect_action() {
        meta.ingress_metadata.nexthop_index = meta.ingress_metadata.fib_nexthop;
        meta.ingress_metadata.ecmp_index = meta.ingress_metadata.fib_ecmp;
        meta.ingress_metadata.routed = 1w1;
        meta.ingress_metadata.ttl = meta.ingress_metadata.lkp_ip_ttl;
        meta.ingress_metadata.ttl = meta.ingress_metadata.ttl + 8w255;
    }
    @name(".acl_log") action acl_log() {
    }
    @name(".acl_deny") action acl_deny() {
        meta.ingress_metadata.acl_deny = 1w1;
    }
    @name(".acl_permit") action acl_permit() {
    }
    @name(".acl_redirect_nexthop") action acl_redirect_nexthop(bit<16> nexthop_index) {
        meta.ingress_metadata.acl_redirect = 1w1;
        meta.ingress_metadata.acl_nexthop = nexthop_index;
    }
    @name(".acl_redirect_ecmp") action acl_redirect_ecmp(bit<10> ecmp_index) {
        meta.ingress_metadata.acl_redirect = 1w1;
        meta.ingress_metadata.acl_ecmp = ecmp_index;
    }
    @name(".racl_log") action racl_log() {
    }
    @name(".racl_deny") action racl_deny() {
        meta.ingress_metadata.racl_deny = 1w1;
    }
    @name(".racl_permit") action racl_permit() {
    }
    @name(".racl_redirect_nexthop") action racl_redirect_nexthop(bit<16> nexthop_index) {
        meta.ingress_metadata.racl_redirect = 1w1;
        meta.ingress_metadata.racl_nexthop = nexthop_index;
    }
    @name(".racl_redirect_ecmp") action racl_redirect_ecmp(bit<10> ecmp_index) {
        meta.ingress_metadata.racl_redirect = 1w1;
        meta.ingress_metadata.racl_ecmp = ecmp_index;
    }
    @name(".set_tunnel_termination_flag") action set_tunnel_termination_flag() {
        meta.ingress_metadata.tunnel_terminate = 1w1;
    }
    @name(".on_miss") action on_miss() {
    }
    @name(".fib_hit_nexthop") action fib_hit_nexthop(bit<16> nexthop_index) {
        meta.ingress_metadata.fib_hit = 1w1;
        meta.ingress_metadata.fib_nexthop = nexthop_index;
    }
    @name(".fib_hit_ecmp") action fib_hit_ecmp(bit<10> ecmp_index) {
        meta.ingress_metadata.fib_hit = 1w1;
        meta.ingress_metadata.fib_ecmp = ecmp_index;
    }
    @name(".set_tunnel_lif") action set_tunnel_lif(bit<16> lif) {
        meta.ingress_metadata.tunnel_lif = lif;
    }
    @name(".set_src_vtep_miss_flag") action set_src_vtep_miss_flag() {
        meta.ingress_metadata.src_vtep_miss = 1w1;
    }
    @name(".set_lag_port") action set_lag_port(bit<9> port) {
        standard_metadata.egress_spec = port;
    }
    @name(".generate_learn_notify") action generate_learn_notify() {
        digest<mac_learn_digest>((bit<32>)1024, { meta.ingress_metadata.bd, meta.ingress_metadata.lkp_mac_sa, meta.ingress_metadata.ifindex });
    }
    @name(".set_mirror_id") action set_mirror_id(bit<32> session_id) {
        clone(CloneType.I2E, (bit<32>)session_id);
    }
    @name(".set_nexthop_details") action set_nexthop_details(bit<10> ifindex, bit<16> bd) {
        meta.ingress_metadata.egress_ifindex = ifindex;
        meta.ingress_metadata.egress_bd = bd;
    }
    @name(".set_nexthop_details_for_post_routed_flood") action set_nexthop_details_for_post_routed_flood(bit<16> bd, bit<16> uuc_mc_index) {
        meta.intrinsic_metadata.eg_mcast_group = uuc_mc_index;
        meta.ingress_metadata.egress_bd = bd;
    }
    @name(".set_outer_rmac_hit_flag") action set_outer_rmac_hit_flag() {
        meta.ingress_metadata.outer_rmac_hit = 1w1;
    }
    @name(".set_ifindex") action set_ifindex(bit<10> ifindex, bit<16> if_label) {
        meta.ingress_metadata.ifindex = ifindex;
        meta.ingress_metadata.if_label = if_label;
    }
    @name(".set_bd") action set_bd(bit<16> outer_vlan_bd, bit<12> vrf, bit<10> rmac_group, bit<1> ipv4_unicast_enabled, bit<10> stp_group) {
        meta.ingress_metadata.vrf = vrf;
        meta.ingress_metadata.ipv4_unicast_enabled = ipv4_unicast_enabled;
        meta.ingress_metadata.outer_rmac_group = rmac_group;
        meta.ingress_metadata.bd = outer_vlan_bd;
        meta.ingress_metadata.stp_group = stp_group;
    }
    @name(".set_rmac_hit_flag") action set_rmac_hit_flag() {
        meta.ingress_metadata.rmac_hit = 1w1;
    }
    @name(".smac_miss") action smac_miss() {
        meta.ingress_metadata.l2_src_miss = 1w1;
    }
    @name(".smac_hit") action smac_hit(bit<10> ifindex) {
        meta.ingress_metadata.l2_src_move = meta.ingress_metadata.ifindex ^ ifindex;
        meta.ingress_metadata.egress_bd = meta.ingress_metadata.egress_bd + 16w0;
    }
    @name(".set_stp_state") action set_stp_state(bit<3> stp_state) {
        meta.ingress_metadata.stp_state = stp_state;
    }
    @name(".redirect_to_cpu") action redirect_to_cpu() {
        standard_metadata.egress_spec = 9w250;
        meta.intrinsic_metadata.eg_mcast_group = 16w0;
    }
    @name(".copy_to_cpu") action copy_to_cpu() {
        clone(CloneType.I2E, (bit<32>)32w250);
    }
    @name(".drop_packet") action drop_packet() {
        meta.intrinsic_metadata.eg_mcast_group = 16w0;
        mark_to_drop();
    }
    @name(".terminate_tunnel_inner_ipv4") action terminate_tunnel_inner_ipv4(bit<16> bd, bit<12> vrf, bit<10> rmac_group, bit<16> bd_label, bit<16> uuc_mc_index, bit<16> bcast_mc_index, bit<16> umc_mc_index, bit<1> ipv4_unicast_enabled, bit<1> igmp_snooping_enabled) {
        meta.ingress_metadata.bd = bd;
        meta.ingress_metadata.vrf = vrf;
        meta.ingress_metadata.outer_dscp = meta.ingress_metadata.lkp_ip_tc;
        meta.ingress_metadata.outer_ttl = meta.ingress_metadata.lkp_ip_ttl;
        meta.ingress_metadata.outer_ttl = meta.ingress_metadata.outer_ttl + 8w255;
        meta.ingress_metadata.lkp_mac_sa = hdr.inner_ethernet.srcAddr;
        meta.ingress_metadata.lkp_mac_da = hdr.inner_ethernet.dstAddr;
        meta.ingress_metadata.lkp_ip_type = 2w1;
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
    @name(".set_valid_outer_unicast_packet") action set_valid_outer_unicast_packet() {
        meta.ingress_metadata.lkp_pkt_type = 3w1;
        meta.ingress_metadata.lkp_mac_sa = hdr.ethernet.srcAddr;
        meta.ingress_metadata.lkp_mac_da = hdr.ethernet.dstAddr;
        meta.ingress_metadata.lkp_mac_type = hdr.ethernet.etherType;
    }
    @name(".set_valid_outer_multicast_packet") action set_valid_outer_multicast_packet() {
        meta.ingress_metadata.lkp_pkt_type = 3w2;
        meta.ingress_metadata.lkp_mac_sa = hdr.ethernet.srcAddr;
        meta.ingress_metadata.lkp_mac_da = hdr.ethernet.dstAddr;
        meta.ingress_metadata.lkp_mac_type = hdr.ethernet.etherType;
    }
    @name(".set_valid_outer_broadcast_packet") action set_valid_outer_broadcast_packet() {
        meta.ingress_metadata.lkp_pkt_type = 3w4;
        meta.ingress_metadata.lkp_mac_sa = hdr.ethernet.srcAddr;
        meta.ingress_metadata.lkp_mac_da = hdr.ethernet.dstAddr;
        meta.ingress_metadata.lkp_mac_type = hdr.ethernet.etherType;
    }
    @name(".set_valid_outer_ipv4_packet") action set_valid_outer_ipv4_packet() {
        meta.ingress_metadata.lkp_ip_type = 2w1;
        meta.ingress_metadata.lkp_ipv4_sa = hdr.ipv4.srcAddr;
        meta.ingress_metadata.lkp_ipv4_da = hdr.ipv4.dstAddr;
        meta.ingress_metadata.lkp_ip_proto = hdr.ipv4.protocol;
        meta.ingress_metadata.lkp_ip_tc = hdr.ipv4.diffserv;
        meta.ingress_metadata.lkp_ip_ttl = hdr.ipv4.ttl;
        meta.ingress_metadata.l3_length = hdr.ipv4.totalLen;
    }
    @name(".set_malformed_outer_ipv4_packet") action set_malformed_outer_ipv4_packet() {
    }
    @name(".set_l2_multicast") action set_l2_multicast() {
        meta.ingress_metadata.l2_multicast = 1w1;
    }
    @name(".set_src_is_link_local") action set_src_is_link_local() {
        meta.ingress_metadata.src_is_link_local = 1w1;
    }
    @name(".set_malformed_packet") action set_malformed_packet() {
    }
    @name(".bd") table bd {
        actions = {
            set_bd_info;
        }
        key = {
            meta.ingress_metadata.bd: exact;
        }
        size = 512;
    }
    @name(".dmac") table dmac {
        support_timeout = true;
        actions = {
            nop;
            dmac_hit;
            dmac_multicast_hit;
            dmac_miss;
            dmac_redirect_nexthop;
            dmac_redirect_ecmp;
        }
        key = {
            meta.ingress_metadata.bd        : exact;
            meta.ingress_metadata.lkp_mac_da: exact;
        }
        size = 512;
    }
    @name(".ecmp_group") table ecmp_group {
        actions = {
            nop;
            set_ecmp_nexthop_details;
            set_ecmp_nexthop_details_for_post_routed_flood;
        }
        key = {
            meta.ingress_metadata.ecmp_index  : exact;
            meta.ingress_metadata.lkp_ipv4_sa : selector;
            meta.ingress_metadata.lkp_ipv4_da : selector;
            meta.ingress_metadata.lkp_ip_proto: selector;
            meta.ingress_metadata.lkp_l4_sport: selector;
            meta.ingress_metadata.lkp_l4_dport: selector;
        }
        size = 512;
        @name(".ecmp_action_profile") implementation = action_selector(HashAlgorithm.crc16, 32w512, 32w10);
    }
    @name(".fwd_result") table fwd_result {
        actions = {
            nop;
            set_l2_redirect_action;
            set_acl_redirect_action;
            set_racl_redirect_action;
            set_fib_redirect_action;
        }
        key = {
            meta.ingress_metadata.l2_redirect  : ternary;
            meta.ingress_metadata.acl_redirect : ternary;
            meta.ingress_metadata.racl_redirect: ternary;
            meta.ingress_metadata.fib_hit      : ternary;
        }
        size = 512;
    }
    @name(".nop") action nop_0() {
        ip_acl_counters.count();
    }
    @name(".acl_log") action acl_log_0() {
        ip_acl_counters.count();
    }
    @name(".acl_deny") action acl_deny_0() {
        ip_acl_counters.count();
        meta.ingress_metadata.acl_deny = 1w1;
    }
    @name(".acl_permit") action acl_permit_0() {
        ip_acl_counters.count();
    }
    @name(".acl_redirect_nexthop") action acl_redirect_nexthop_0(bit<16> nexthop_index) {
        ip_acl_counters.count();
        meta.ingress_metadata.acl_redirect = 1w1;
        meta.ingress_metadata.acl_nexthop = nexthop_index;
    }
    @name(".acl_redirect_ecmp") action acl_redirect_ecmp_0(bit<10> ecmp_index) {
        ip_acl_counters.count();
        meta.ingress_metadata.acl_redirect = 1w1;
        meta.ingress_metadata.acl_ecmp = ecmp_index;
    }
    @name(".ip_acl") table ip_acl {
        actions = {
            nop_0;
            acl_log_0;
            acl_deny_0;
            acl_permit_0;
            acl_redirect_nexthop_0;
            acl_redirect_ecmp_0;
        }
        key = {
            meta.ingress_metadata.if_label    : ternary;
            meta.ingress_metadata.bd_label    : ternary;
            meta.ingress_metadata.lkp_ipv4_sa : ternary;
            meta.ingress_metadata.lkp_ipv4_da : ternary;
            meta.ingress_metadata.lkp_ip_proto: ternary;
            meta.ingress_metadata.lkp_l4_sport: ternary;
            meta.ingress_metadata.lkp_l4_dport: ternary;
            meta.ingress_metadata.lkp_mac_type: ternary;
            meta.ingress_metadata.msg_type    : ternary;
            hdr.tcp.isValid()                 : exact;
            hdr.tcp.flags                     : ternary;
            meta.ingress_metadata.ttl         : ternary;
        }
        size = 512;
        @name(".ip_acl_counters") counters = direct_counter(CounterType.packets);
    }
    @name(".ip_racl") table ip_racl {
        actions = {
            nop;
            racl_log;
            racl_deny;
            racl_permit;
            racl_redirect_nexthop;
            racl_redirect_ecmp;
        }
        key = {
            meta.ingress_metadata.bd_label    : ternary;
            meta.ingress_metadata.lkp_ipv4_sa : ternary;
            meta.ingress_metadata.lkp_ipv4_da : ternary;
            meta.ingress_metadata.lkp_ip_proto: ternary;
            meta.ingress_metadata.lkp_l4_sport: ternary;
            meta.ingress_metadata.lkp_l4_dport: ternary;
        }
        size = 512;
    }
    @name(".ipv4_dest_vtep") table ipv4_dest_vtep {
        actions = {
            nop;
            set_tunnel_termination_flag;
        }
        key = {
            meta.ingress_metadata.vrf         : exact;
            meta.ingress_metadata.lkp_ipv4_da : exact;
            meta.ingress_metadata.lkp_ip_proto: exact;
            meta.ingress_metadata.lkp_l4_dport: exact;
        }
        size = 512;
    }
    @name(".ipv4_fib") table ipv4_fib {
        actions = {
            on_miss;
            fib_hit_nexthop;
            fib_hit_ecmp;
        }
        key = {
            meta.ingress_metadata.vrf        : exact;
            meta.ingress_metadata.lkp_ipv4_da: exact;
        }
        size = 512;
    }
    @name(".ipv4_fib_lpm") table ipv4_fib_lpm {
        actions = {
            fib_hit_nexthop;
            fib_hit_ecmp;
        }
        key = {
            meta.ingress_metadata.vrf        : exact;
            meta.ingress_metadata.lkp_ipv4_da: lpm;
        }
        size = 512;
    }
    @name(".ipv4_src_vtep") table ipv4_src_vtep {
        actions = {
            nop;
            set_tunnel_lif;
            set_src_vtep_miss_flag;
        }
        key = {
            meta.ingress_metadata.vrf        : exact;
            meta.ingress_metadata.lkp_ipv4_sa: exact;
        }
        size = 512;
    }
    @name(".lag_group") table lag_group {
        actions = {
            nop;
            set_lag_port;
        }
        key = {
            meta.ingress_metadata.egress_ifindex: exact;
            meta.ingress_metadata.lkp_mac_sa    : selector;
            meta.ingress_metadata.lkp_mac_da    : selector;
            meta.ingress_metadata.lkp_mac_type  : selector;
            meta.ingress_metadata.lkp_ipv4_sa   : selector;
            meta.ingress_metadata.lkp_ipv4_da   : selector;
            meta.ingress_metadata.lkp_ip_proto  : selector;
            meta.ingress_metadata.lkp_l4_sport  : selector;
            meta.ingress_metadata.lkp_l4_dport  : selector;
        }
        size = 512;
        @name(".lag_action_profile") implementation = action_selector(HashAlgorithm.crc16, 32w512, 32w8);
    }
    @name(".learn_notify") table learn_notify {
        actions = {
            nop;
            generate_learn_notify;
        }
        key = {
            meta.ingress_metadata.l2_src_miss: ternary;
            meta.ingress_metadata.l2_src_move: ternary;
            meta.ingress_metadata.stp_state  : ternary;
        }
        size = 512;
    }
    @name(".mac_acl") table mac_acl {
        actions = {
            nop;
            acl_log;
            acl_deny;
            acl_permit;
        }
        key = {
            meta.ingress_metadata.if_label    : ternary;
            meta.ingress_metadata.bd_label    : ternary;
            meta.ingress_metadata.lkp_mac_sa  : ternary;
            meta.ingress_metadata.lkp_mac_da  : ternary;
            meta.ingress_metadata.lkp_mac_type: ternary;
        }
        size = 512;
    }
    @name(".mirror_acl") table mirror_acl {
        actions = {
            nop;
            set_mirror_id;
        }
        key = {
            meta.ingress_metadata.if_label    : ternary;
            meta.ingress_metadata.bd_label    : ternary;
            meta.ingress_metadata.lkp_ipv4_sa : ternary;
            meta.ingress_metadata.lkp_ipv4_da : ternary;
            meta.ingress_metadata.lkp_ip_proto: ternary;
            meta.ingress_metadata.lkp_mac_sa  : ternary;
            meta.ingress_metadata.lkp_mac_da  : ternary;
            meta.ingress_metadata.lkp_mac_type: ternary;
        }
        size = 512;
    }
    @name(".nexthop") table nexthop {
        actions = {
            nop;
            set_nexthop_details;
            set_nexthop_details_for_post_routed_flood;
        }
        key = {
            meta.ingress_metadata.nexthop_index: exact;
        }
        size = 512;
    }
    @name(".outer_rmac") table outer_rmac {
        actions = {
            nop;
            set_outer_rmac_hit_flag;
        }
        key = {
            meta.ingress_metadata.outer_rmac_group: exact;
            meta.ingress_metadata.lkp_mac_da      : exact;
        }
        size = 256;
    }
    @name(".port_mapping") table port_mapping {
        actions = {
            set_ifindex;
        }
        key = {
            standard_metadata.ingress_port: exact;
        }
        size = 258;
    }
    @name(".port_vlan_mapping") table port_vlan_mapping {
        actions = {
            set_bd;
        }
        key = {
            meta.ingress_metadata.ifindex: exact;
            hdr.vlan_tag_[0].isValid()   : exact;
            hdr.vlan_tag_[0].vid         : exact;
            hdr.vlan_tag_[1].isValid()   : exact;
            hdr.vlan_tag_[1].vid         : exact;
        }
        size = 512;
        @name(".outer_bd_action_profile") implementation = action_profile(32w256);
    }
    @name(".rmac") table rmac {
        actions = {
            on_miss;
            set_rmac_hit_flag;
        }
        key = {
            meta.ingress_metadata.rmac_group: exact;
            meta.ingress_metadata.lkp_mac_da: exact;
        }
        size = 512;
    }
    @name(".smac") table smac {
        actions = {
            nop;
            smac_miss;
            smac_hit;
        }
        key = {
            meta.ingress_metadata.bd        : exact;
            meta.ingress_metadata.lkp_mac_sa: exact;
        }
        size = 512;
    }
    @name(".spanning_tree") table spanning_tree {
        actions = {
            set_stp_state;
        }
        key = {
            meta.ingress_metadata.ifindex  : exact;
            meta.ingress_metadata.stp_group: exact;
        }
        size = 512;
    }
    @name(".system_acl") table system_acl {
        actions = {
            nop;
            redirect_to_cpu;
            copy_to_cpu;
            drop_packet;
        }
        key = {
            meta.ingress_metadata.if_label         : ternary;
            meta.ingress_metadata.bd_label         : ternary;
            meta.ingress_metadata.lkp_ipv4_sa      : ternary;
            meta.ingress_metadata.lkp_ipv4_da      : ternary;
            meta.ingress_metadata.lkp_ip_proto     : ternary;
            meta.ingress_metadata.lkp_mac_sa       : ternary;
            meta.ingress_metadata.lkp_mac_da       : ternary;
            meta.ingress_metadata.lkp_mac_type     : ternary;
            meta.ingress_metadata.acl_deny         : ternary;
            meta.ingress_metadata.racl_deny        : ternary;
            meta.ingress_metadata.src_vtep_miss    : ternary;
            meta.ingress_metadata.routed           : ternary;
            meta.ingress_metadata.src_is_link_local: ternary;
            meta.ingress_metadata.ttl              : ternary;
            meta.ingress_metadata.stp_state        : ternary;
            meta.ingress_metadata.control_frame    : ternary;
            standard_metadata.egress_spec          : ternary;
        }
        size = 256;
    }
    @name(".tunnel") table tunnel {
        actions = {
            terminate_tunnel_inner_ipv4;
        }
        key = {
            meta.ingress_metadata.tunnel_vni : exact;
            meta.ingress_metadata.tunnel_type: exact;
            hdr.inner_ipv4.isValid()         : exact;
        }
        size = 512;
    }
    @name(".validate_outer_ethernet") table validate_outer_ethernet {
        actions = {
            set_valid_outer_unicast_packet;
            set_valid_outer_multicast_packet;
            set_valid_outer_broadcast_packet;
        }
        key = {
            hdr.ethernet.dstAddr: ternary;
        }
        size = 64;
    }
    @name(".validate_outer_ipv4_packet") table validate_outer_ipv4_packet {
        actions = {
            set_valid_outer_ipv4_packet;
            set_malformed_outer_ipv4_packet;
        }
        key = {
            hdr.ipv4.version: exact;
            hdr.ipv4.ihl    : exact;
            hdr.ipv4.ttl    : exact;
            hdr.ipv4.srcAddr: ternary;
            hdr.ipv4.dstAddr: ternary;
        }
        size = 64;
    }
    @name(".validate_packet") table validate_packet {
        actions = {
            nop;
            set_l2_multicast;
            set_src_is_link_local;
            set_malformed_packet;
        }
        key = {
            meta.ingress_metadata.lkp_mac_da : ternary;
            meta.ingress_metadata.lkp_ipv4_da: ternary;
        }
        size = 64;
    }
    apply {
        if (meta.ingress_metadata.ingress_bypass == 1w0) {
            validate_outer_ethernet.apply();
            if (hdr.ipv4.isValid()) {
                validate_outer_ipv4_packet.apply();
            }
            port_mapping.apply();
            port_vlan_mapping.apply();
            if (meta.ingress_metadata.stp_group != 10w0) {
                spanning_tree.apply();
            }
            outer_rmac.apply();
            if (hdr.ipv4.isValid()) {
                ipv4_src_vtep.apply();
            }
            if (meta.ingress_metadata.lkp_pkt_type == 3w1) {
                if (meta.ingress_metadata.lkp_ip_type == 2w1 && meta.ingress_metadata.ipv4_unicast_enabled == 1w1) {
                    ipv4_dest_vtep.apply();
                }
            }
            if (meta.ingress_metadata.src_vtep_miss == 1w0 && (meta.ingress_metadata.outer_rmac_hit == 1w1 && meta.ingress_metadata.tunnel_terminate == 1w1 || meta.ingress_metadata.lkp_pkt_type == 3w2 && meta.ingress_metadata.tunnel_terminate == 1w1)) {
                tunnel.apply();
            }
            else {
                bd.apply();
            }
            validate_packet.apply();
            smac.apply();
            learn_notify.apply();
            mirror_acl.apply();
            if (meta.ingress_metadata.lkp_ip_type == 2w0) {
                mac_acl.apply();
            }
            else {
                if (meta.ingress_metadata.lkp_ip_type == 2w1) {
                    ip_acl.apply();
                }
            }
            switch (rmac.apply().action_run) {
                default: {
                    if (meta.ingress_metadata.lkp_ip_type == 2w1 && meta.ingress_metadata.ipv4_unicast_enabled == 1w1) {
                        ip_racl.apply();
                        switch (ipv4_fib.apply().action_run) {
                            on_miss: {
                                ipv4_fib_lpm.apply();
                            }
                        }

                    }
                }
                on_miss: {
                    dmac.apply();
                }
            }

            fwd_result.apply();
            if (meta.ingress_metadata.ecmp_index != 10w0) {
                ecmp_group.apply();
            }
            else {
                nexthop.apply();
            }
            lag_group.apply();
            system_acl.apply();
        }
    }
}

control DeparserImpl(packet_out packet, in headers hdr) {
    apply {
        packet.emit(hdr.ethernet);
        packet.emit(hdr.cpu_header);
        packet.emit(hdr.fcoe);
        packet.emit(hdr.roce);
        packet.emit(hdr.vlan_tag_);
        packet.emit(hdr.arp_rarp);
        packet.emit(hdr.arp_rarp_ipv4);
        packet.emit(hdr.ipv6);
        packet.emit(hdr.icmpv6);
        packet.emit(hdr.ipv4);
        packet.emit(hdr.gre);
        packet.emit(hdr.nsh);
        packet.emit(hdr.nsh_context);
        packet.emit(hdr.erspan_v2_header);
        packet.emit(hdr.erspan_v1_header);
        packet.emit(hdr.nvgre);
        packet.emit(hdr.udp);
        packet.emit(hdr.roce_v2);
        packet.emit(hdr.genv);
        packet.emit(hdr.vxlan);
        packet.emit(hdr.inner_ethernet);
        packet.emit(hdr.inner_ipv6);
        packet.emit(hdr.inner_icmpv6);
        packet.emit(hdr.inner_ipv4);
        packet.emit(hdr.inner_udp);
        packet.emit(hdr.inner_tcp);
        packet.emit(hdr.inner_icmp);
        packet.emit(hdr.tcp);
        packet.emit(hdr.icmp);
        packet.emit(hdr.snap_header);
    }
}

control verifyChecksum(in headers hdr, inout metadata meta) {
    Checksum16() inner_ipv4_checksum;
    Checksum16() ipv4_checksum;
    apply {
        if (hdr.ipv4.isValid() && hdr.inner_ipv4.hdrChecksum == inner_ipv4_checksum.get({ hdr.inner_ipv4.version, hdr.inner_ipv4.ihl, hdr.inner_ipv4.diffserv, hdr.inner_ipv4.totalLen, hdr.inner_ipv4.identification, hdr.inner_ipv4.flags, hdr.inner_ipv4.fragOffset, hdr.inner_ipv4.ttl, hdr.inner_ipv4.protocol, hdr.inner_ipv4.srcAddr, hdr.inner_ipv4.dstAddr })) 
            mark_to_drop();
        if (hdr.ipv4.hdrChecksum == ipv4_checksum.get({ hdr.ipv4.version, hdr.ipv4.ihl, hdr.ipv4.diffserv, hdr.ipv4.totalLen, hdr.ipv4.identification, hdr.ipv4.flags, hdr.ipv4.fragOffset, hdr.ipv4.ttl, hdr.ipv4.protocol, hdr.ipv4.srcAddr, hdr.ipv4.dstAddr })) 
            mark_to_drop();
    }
}

control computeChecksum(inout headers hdr, inout metadata meta) {
    Checksum16() inner_ipv4_checksum;
    Checksum16() ipv4_checksum;
    apply {
        if (hdr.ipv4.isValid()) 
            hdr.inner_ipv4.hdrChecksum = inner_ipv4_checksum.get({ hdr.inner_ipv4.version, hdr.inner_ipv4.ihl, hdr.inner_ipv4.diffserv, hdr.inner_ipv4.totalLen, hdr.inner_ipv4.identification, hdr.inner_ipv4.flags, hdr.inner_ipv4.fragOffset, hdr.inner_ipv4.ttl, hdr.inner_ipv4.protocol, hdr.inner_ipv4.srcAddr, hdr.inner_ipv4.dstAddr });
        hdr.ipv4.hdrChecksum = ipv4_checksum.get({ hdr.ipv4.version, hdr.ipv4.ihl, hdr.ipv4.diffserv, hdr.ipv4.totalLen, hdr.ipv4.identification, hdr.ipv4.flags, hdr.ipv4.fragOffset, hdr.ipv4.ttl, hdr.ipv4.protocol, hdr.ipv4.srcAddr, hdr.ipv4.dstAddr });
    }
}

V1Switch(ParserImpl(), verifyChecksum(), ingress(), egress(), computeChecksum(), DeparserImpl()) main;
