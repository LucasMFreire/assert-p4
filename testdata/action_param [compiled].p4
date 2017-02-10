control c() {
  bit<32> arg_0/arg
  action a_0/a() {
    arg_0/arg = 10;
    x = 10; }
  table t() @name("t") {
    actions = { a_0/a(); }
    default_action = a_0/a(); }
  t.apply(); }
control proto<>(inout bit<32> arg);
package top<>( proto p);
top main(c())
