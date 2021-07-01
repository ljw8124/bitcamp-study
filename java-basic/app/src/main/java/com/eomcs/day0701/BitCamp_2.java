package com.eomcs.day0701;

public class BitCamp_2 extends LA {

  public static void main(String[] args) {
    BitCamp_2 bit = new BitCamp_2();
    bit.book();
    // static 문맥에서는 this. 와 super. 사용불가

  }

  public void book() {
    System.out.println("book 쿠키키");
    this.cherry();
    super.cherry();
  }

  @Override
  public void cherry() {
    System.out.println("제주산 체리");
  }
}
