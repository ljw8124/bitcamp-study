package com.eomcs.day0630;

public class TestBook {
  public int m = 7820;

  public static void main(String[] args) {
    new TestBook().note(); // 익명의 개체
  }

  public void note() { // 인스턴스 메서드 = non-static method
    int m = 2400;
    System.out.println("지역변수 책가격 = " + m); // 2400
    System.out.println("전역변수 책가격 = " + this.m); //7820
    // this 를 쓰려면 non-static으로 사용 ==> static에서는 this 사용 불가능 하다
  }

}
