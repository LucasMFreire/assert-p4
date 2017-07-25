control c() {
  action a_0/a() { }
  action a_2/a_1() { }
  action b_0/b() { }
  table t1() @name("t1") {
    actions = { a_0/a();
      b_0/b(); }
    default_action = a_0/a(); }
  table t2() @name("t2") {
    actions = { a_2/a_1(); }
    default_action = a_2/a_1(); }
  t1.apply();
  t2.apply(); }
control empty<>();
package top<>( empty e);
top main(c())
