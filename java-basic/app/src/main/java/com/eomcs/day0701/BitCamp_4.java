package com.eomcs.day0701;

import com.eomcs.pratice.Father;

public class BitCamp_4 extends Father implements AAA, BBB {

  public static void main(String[] args) {
    BitCamp_4 bit = new BitCamp_4();
    bit.game();

  }

  public void game() {
    System.out.println("삼국지 사마의");
    int m = this.bank();
  }

  @Override
  public void red() {
    System.out.println("BimCamp_4 소속의 red 메소드");
  }

  @Override
  public String memo() {
    return null;
  }

  @Override
  public boolean nullCheck(int key) {
    return false;
  }

  @Override
  public int blue() {
    // TODO Auto-generated method stub
    return 0;
  }

}
