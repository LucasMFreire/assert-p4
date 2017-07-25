
header_type ethernet_t {
    fields {
        dst_addr : 48;
        src_addr : 48;
        ethertype : 16;
    }
}

header_type stag_t {
    // The stag holds the original source port color
    fields {
        source_color : 8;
    }
}

header_type ipv4_t {
    fields {
        version : 4;
        src_addr : 32;
        dst_addr : 32;
    }
}

header_type local_md_t {
    fields {
        src_port_color : 8; // Mapped at ingress or from stag
        dst_port_color : 8; // Mapped at egress
    }
}

// Header instances declared based on types
header ethernet_t ethernet;
header stag_t stag;
header ipv4_t ipv4;
metadata local_md_t local_md;
parser_value_set host_ports;

parser start { // Always start with an Ethernet header
    return ethernet;
}

parser ethernet {
    extract(ethernet);
    return select(std_md.ingress_port) {
        // Is ingress port a local host port?
        // If so, no stag is present
        host_ports : post_ethernet;
        // Otherwise, packet has an stag
        default : stag;
    }
}

parser stag {
    extract(stag); // Get the stag from the packet
    // Save source port color in md
    set_metadata(local_md.src_port_color, stag.source_color);
    return post_ethernet;
}

parser post_ethernet { // After optional stag
    return select(ethernet.ethertype) {
        0x800: ipv4;
        default: ingress;
    }
}

parser ipv4 {
    extract(ipv4);
    return ingress;
}

action set_source_color(color) {
    modify_field(local_md.src_port_color, color);
}

// Map port number to color
table resolve_source_color {
    reads {
        std_md.ingress_port : exact;
    }
    actions {
        set_source_color;
    }
}

// Map packet dest addr to exit port
// Add/remove stag if necessary
table forward {
    reads {
        ipv4.dst_addr : ternary;
    }
    actions {
        set_local_dest; // Used by edge only, to local
        set_remote_dest; // Used by edge only, to core
        core_pass_through; // Used by core only
    }
}

// Apply security policy based on src/dst port colors
table color_check {
    reads {
        local_md.dst_port_color : exact;
        local_md.src_port_color : exact;
    }
    actions {
        drop;
    }
}

// Set the egress port and remove stag, forwarding local
action set_local_dest(egr_port, color) {
    modify_field(std_md.egress_spec, egr_port);
    modify_field(local_md.dst_port_color, color);
    remove_header(stag);
}

// Set the egress port and add stag, forwarding to core
action set_remote_dest(egr_port) {
    modify_field(std_md.egress_spec, egr_port);
    add_header(stag);
    modify_field(stag.source_color,
    local_md.src_port_color);
}

// The core (non-edge) switches do not need to modify the
// stag; just set the egress port
action core_pass_through(egr_port) {
    modify_field(standard_metadata.egress_spec, egr_port);
}

control ingress {
    if (not valid(stag)) {
        // Packet from local port, map its color
        apply(get_source_color);
    }
    // Where does the packet go? Local or core?
    apply(forward) {
        // Here, forward table used "local"...
        set_local_dest {
            // ... so apply the security policy
            apply(color_check);
        }
    }
}