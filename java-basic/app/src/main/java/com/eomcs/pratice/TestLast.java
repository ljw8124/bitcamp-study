package com.eomcs.pratice;

//형변환 연산 Integer. 의 활용
public class TestLast {

  public static void main(String[] args) {

    int a = 234;
    double b = 78.9;
    String c = "1200";

    // 1. b타입을 int형으로 변환
    int x = (int)b;
    System.out.println(x + 34);

    // 2. c타입을 int형으로 변환
    int y = Integer.parseInt(c);
    System.out.println(y + 34);

    // 3. a타입을 String형으로 변환
    String z = Integer.toString(a);
    String g = String.valueOf(a);
    System.out.println(z + 34);
    System.out.println(g);
  }

}
