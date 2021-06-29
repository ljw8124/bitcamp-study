package com.eomcs.pratice;

public class TestNote {

  // 무조건 public static void main(String[] args) 가 나와야 함 -> 단독 실행을 위해서 필요
  // => 다른 프로그램을 위해서 존재하는 경우 main 메서드를 쓰지 않음
  public static void main(String[] args) {
    System.out.println("이정우 ");
    System.out.println("까사노 ");

    TestNote tn = new TestNote();
    tn.note();
    String title = tn.book(); // 리턴 값 존재
    // tn.note(); 
  }

  public String book() {
    String my = "대통령의 글쓰기"; // 지역 변수(로컬 변수)
    return my;
  }

  public int price() {
    int money = 2700;
    return money;
  }

  public void note() { // 인스턴스 메서드 = non-static method

    String title = book();
    int money = price();

    System.out.println("책제목 = " + title);
    System.out.println("책제목 = " + book());
    System.out.println("책가격 = " + money);
    System.out.println("책가격 = " + price());
  }


}
