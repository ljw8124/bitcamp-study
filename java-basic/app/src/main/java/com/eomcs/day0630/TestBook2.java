package com.eomcs.day0630;

public class TestBook2 {
  public int m = 7820;

  public static void main(String[] args) {
    char a = 'A', b = '0', c = 97;
    System.out.printf("%c  %c  %c\n", a, b, c);

    int x = a;
    int y = b;
    int z = c;
    System.out.printf("%d  %d  %d\n", x, y, z);
  }

  public void note() { // 인스턴스 메서드 = non-static method
    int m = 2400;
    System.out.println("지역변수 책가격 = " + m); // 2400
    System.out.println("전역변수 책가격 = " + this.m); //7820
    // this 를 쓰려면 non-static으로 사용 ==> static에서는 this 사용 불가능 하다
  }

}
