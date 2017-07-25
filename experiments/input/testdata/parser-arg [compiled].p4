parser Parser<>();
package Package<>( Parser p1,  Parser p2);
parser Parser1_0() {
  state start {
    accept; }
  state accept { }
  state reject { } }
Parser1_0 p1()
parser Parser2_0() {
  state start {
    accept; }
  state accept { }
  state reject { } }
Parser2_0 p2()
Package main(p1, p2)
