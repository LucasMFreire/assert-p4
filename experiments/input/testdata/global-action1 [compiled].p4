control c() {
  action Global/Global_1() { }
  table t() @name("t") {
    actions = { Global/Global_1(); }
    default_action = Global/Global_1(); }
  t.apply(); }
control none<>();
package top<>( none n);
top main(c())
