package com.eomcs.day0701;

public class BitCamp_3 {

  public BitCamp_3() {this("종로점", 7, "AiA");} // 기본생성자는 생략가능 => 묵인되어 있음
  public BitCamp_3(String place) { } // String 타입의 매개인자 있는 생성자
  public BitCamp_3(int floor) { } // int 타입의 매개인자 있는 생성자
  public BitCamp_3(String place, int floor, String name) {
    System.out.printf("%s 지점 %d층 %s 과정입니다.\n", place, floor, name);
  }

  public static void main(String[] args) {
    BitCamp_3 bit = new BitCamp_3("종로점", 7, "AiA");
    bit.coffee();
  }

  public void coffee() {
    System.out.println("coffee 맥심 카누");
    this.cookie(); // this. 는 생략가능
  }

  public void cookie() {
    System.out.println("cookie 콰삭칩");
  }

}