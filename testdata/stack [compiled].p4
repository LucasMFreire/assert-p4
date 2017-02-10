header h { }
parser p() {
  h[4] stack
  h b
  state start {
    stack[0].setInvalid();
    stack[1].setInvalid();
    stack[2].setInvalid();
    stack[3].setInvalid();
    stack[3].setValid();
    b = stack.last;
    stack[2] = b;
    accept; }
  state accept { }
  state reject { } }
control c() {
  h[4] stack_2/stack
  h b_2/b
  action act() {
    stack_2/stack[3].setValid();
    b_2/b = stack_2/stack[3];
    stack_2/stack[2] = b_2/b;
    stack_2/stack.push_front(2);
    stack_2/stack.pop_front(2); }
  table tbl_act() {
    actions = { act(); }
    const default_action = act(); }
  tbl_act.apply(); }
parser Simple<>();
control Simpler<>();
package top<>( Simple par,  Simpler ctr);
top main(p(), c())
