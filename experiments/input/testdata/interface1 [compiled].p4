extern X<T> {
  <null> X<>(); }
extern Y<> {
  <null> Y<>(); }
parser p() {
  state start {
    accept; }
  state accept { }
  state reject { } }
parser empty<>();
package sw<>( empty e);
sw main(p())
