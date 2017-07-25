parser p() {
  bit<32> a
  bool tmp_9
  bit<32> tmp_10
  bit<32> tmp_11
  bool tmp_12
  bit<32> tmp_13
  bool tmp_14
  bit<32> tmp_15
  bit<32> tmp_16
  bit<32> tmp_17
  bit<32> tmp_18
  state start {
    a = 1;
    tmp_9 = a == 0;
    select{tmp_9} {
      1: start_true
      0: start_false } }
  state start_true {
    tmp_10 = 2;
    start_join; }
  state start_false {
    tmp_10 = 3;
    start_join; }
  state start_join {
    b = tmp_10;
    tmp_11 = b + 1;
    b = tmp_11;
    tmp_12 = a > 0;
    select{tmp_12} {
      1: start_true_0
      0: start_false_0 } }
  state start_true_0 {
    tmp_14 = a > 1;
    select{tmp_14} {
      1: start_true_0_true
      0: start_true_0_false } }
  state start_true_0_true {
    tmp_16 = b + 1;
    tmp_15 = tmp_16;
    start_true_0_join; }
  state start_true_0_false {
    tmp_17 = b + 2;
    tmp_15 = tmp_17;
    start_true_0_join; }
  state start_true_0_join {
    tmp_13 = tmp_15;
    start_join_0; }
  state start_false_0 {
    tmp_18 = b + 3;
    tmp_13 = tmp_18;
    start_join_0; }
  state start_join_0 {
    b = tmp_13;
    accept; }
  state accept { }
  state reject { } }
parser proto<>(out bit<32> b);
package top<>( proto _p);
top main(p())
