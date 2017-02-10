parser parse<H>(out H headers);
package ebpfFilter<H>( parse<H> prs);
struct Headers_t { }
parser prs() {
  state start {
    accept; }
  state accept { }
  state reject { } }
ebpfFilter<Headers_t> main(prs())
