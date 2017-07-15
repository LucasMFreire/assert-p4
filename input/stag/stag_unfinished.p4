/* -*- P4_16 -*- */
#include <core.p4>
#include <v1model.p4>

const bit<16> TYPE_IPV4 = 0x800;
const bit<5>  IPV4_OPTION_STAG = 31;

/*************************************************************************
*********************** H E A D E R S  ***********************************
*************************************************************************/

typedef bit<9>  egressSpec_t;
typedef bit<48> macAddr_t;
typedef bit<32> ip4Addr_t;

header ethernet_t {
    macAddr_t dstAddr;
    macAddr_t srcAddr;
    bit<16>   etherType;
}

header ipv4_t {
    bit<4>    version;
    bit<4>    ihl;
    bit<8>    diffserv;
    bit<16>   totalLen;
    bit<16>   identification;
    bit<3>    flags;
    bit<13>   fragOffset;
    bit<8>    ttl;
    bit<8>    protocol;
    bit<16>   hdrChecksum;
    ip4Addr_t srcAddr;
    ip4Addr_t dstAddr;
}

struct metadata {
    
}

header ipv4_option_t {
    bit<1> copyFlag;
    bit<2> optClass;
    bit<5> option;
    bit<8> optionLength;
}

header stag_t {
    // The stag holds the original source port color
    bit<8>  source_color;
}

header local_md_t {
    bit<8>  src_port_color;
    bit<8>  dst_port_color;
    bit<1>  toLocal;
}

struct headers {
    ethernet_t   ethernet;
    ipv4_t       ipv4;
    ipv4_option_t  ipv4_option;
    stag_t        stag;
}

error { IPHeaderTooShort }

/*************************************************************************
*********************** P A R S E R  ***********************************
*************************************************************************/

parser ParserImpl(packet_in packet,
out headers hdr,
inout metadata meta,
inout standard_metadata_t standard_metadata) {

    state start {
        transition parse_ethernet;
    }

    state parse_ethernet {
        packet.extract(hdr.ethernet);
        transition select(hdr.ethernet.etherType) {
            TYPE_IPV4: parse_ipv4;
            default: accept;
        }
    }

    state parse_ipv4 {
        packet.extract(hdr.ipv4);
        verify(hdr.ipv4.ihl >= 5, error.IPHeaderTooShort);
        transition select(hdr.ipv4.ihl) {
            5             : accept;
            default       : parse_ipv4_option;
        }
    }

    state parse_ipv4_option {
        packet.extract(hdr.ipv4_option);
        transition select(hdr.ipv4_option.option) {
            IPV4_OPTION_STAG: parse_stag;
            default: accept;
        }
    }

    state parse_stag {
        packet.extract(hdr.stag);
        local_md.src_port_color = hdr.stag.source_color;
        transition accept;
    }
}


/*************************************************************************
************   C H E C K S U M    V E R I F I C A T I O N   *************
*************************************************************************/

control verifyChecksum(in headers hdr, inout metadata meta) {   
    apply {  }
}


/*************************************************************************
**************  I N G R E S S   P R O C E S S I N G   *******************
*************************************************************************/

control ingress(inout headers hdr, inout metadata meta, inout standard_metadata_t standard_metadata) {
    action drop() {
        mark_to_drop();
    }
    
        
    action ipv4_forward(macAddr_t dstAddr, egressSpec_t port) {
        standard_metadata.egress_spec = port;
        hdr.ethernet.srcAddr = hdr.ethernet.dstAddr;
        hdr.ethernet.dstAddr = dstAddr;
        hdr.ipv4.ttl = hdr.ipv4.ttl - 1;
    }

        
    table ipv4_lpm {
        key = {
            hdr.ipv4.dstAddr: lpm;
        }
        actions = {
            ipv4_forward;
            drop;
            NoAction;
        }
        size = 1024;
        default_action = NoAction();
    }

    action to_local(bit<8> color){
	local_md.dst_port_color = color;
	local_md.toLocal = 1;
    }

    action to_core(){
	local_md.toLocal = 0;
    }

    table core_local {
	key = {hdr.ipv4.dstAddr: ternary;}
	actions = { to_local; to_core; }
	size = 1024;
	default_action = to_core;
    }    

    table color_check {
	key = {
	    local_md.dst_port_color: exact;
	    local_md.src_port_color: exact;
	}
	actions = {
	    drop;
	    NoAction;
	}
	size = 1024;
	default_action = drop;
    }
	
    apply {
        if (hdr.ipv4.isValid()) {
            ipv4_lpm.apply();    
        }

	if (core_local.apply().action_run){
	     to_local: {
		color_check.apply();
	     }
	}

    }
}

/*************************************************************************
****************  E G R E S S   P R O C E S S I N G   *******************
*************************************************************************/

control egress(inout headers hdr, inout metadata meta, inout standard_metadata_t standard_metadata) {
  action add_stag_option(bit<8> color) {
        hdr.ipv4_option.setValid();
        hdr.ipv4_option.copyFlag     = 1;
        hdr.ipv4_option.optClass     = 2;
        hdr.ipv4_option.option       = IPV4_OPTION_STAG;
        hdr.ipv4_option.optionLength = 4;  /* sizeof(ipv4_option) + sizeof(stag) */
        
        hdr.stag.setValid();
        hdr.stag.source_color = color
        hdr.ipv4.ihl = hdr.ipv4.ihl + 1;
  }

  table stag {
	key = { standard_metadata.ingress_port : exact; }
        actions        = { add_stag_option; NoAction; }
        default_action =  NoAction();      
  }
}
  apply { 
	if (!hdr.stag.isValid() {
	    // Packet from local port, map its color
	    stag.apply();
	}
  }
}

/*************************************************************************
*************   C H E C K S U M    C O M P U T A T I O N   **************
*************************************************************************/


control computeChecksum(
inout headers  hdr,
inout metadata meta)
{
    Checksum16() ipv4_checksum;
    
    apply {
        if (hdr.ipv4.isValid()) {
            hdr.ipv4.hdrChecksum = ipv4_checksum.get(
            {    
                hdr.ipv4.version,
                hdr.ipv4.ihl,
                hdr.ipv4.diffserv,
                hdr.ipv4.totalLen,
                hdr.ipv4.identification,
                hdr.ipv4.flags,
                hdr.ipv4.fragOffset,
                hdr.ipv4.ttl,
                hdr.ipv4.protocol,
                hdr.ipv4.srcAddr,
                hdr.ipv4.dstAddr
            });
        }
    }
}

/*************************************************************************
***********************  D E P A R S E R  *******************************
*************************************************************************/

control DeparserImpl(packet_out packet, in headers hdr) {
    apply {
        packet.emit(hdr.ethernet);
        packet.emit(hdr.ipv4);
        packet.emit(hdr.ipv4_option);
	if(!local_md.toLocal){
            packet.emit(hdr.stag);
	}              
    }
}

/*************************************************************************
***********************  S W I T C H  *******************************
*************************************************************************/

V1Switch(
ParserImpl(),
verifyChecksum(),
ingress(),
egress(),
computeChecksum(),
DeparserImpl()
) main;
