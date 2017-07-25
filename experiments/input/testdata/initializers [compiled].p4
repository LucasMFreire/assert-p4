extern Fake<> {
  <null> Fake<>();
  void call<>(in bit<32> data); }
parser P() {
  bit<32> x
  @name("fake") Fake fake()
  state start {
    x = 0;
    fake.call(x);
    accept; }
  state accept { }
  state reject { } }
control C() {
  bit<32> x_2/x
  bit<32> y
  bit<32> tmp_0
  @name("fake") Fake fake_2/fake()
  action act() {
    x_2/x = 0;
    tmp_0 = x_2/x + 1;
    y = tmp_0;
    fake_2/fake.call(y); }
  table tbl_act() {
    actions = { act(); }
    const default_action = act(); }
  tbl_act.apply(); }
parser SimpleParser<>();
control SimpleControl<>();
package top<>( SimpleParser prs,  SimpleControl ctrl);
top main(P(), C())
