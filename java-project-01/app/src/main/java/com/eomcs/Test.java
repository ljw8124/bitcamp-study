package com.eomcs;

class Calculator1 {
  static int result; // static 변수는 class 이름으로 접근 가능

  static void plus(int value) {
    Calculator1.result += value;
  }
}

public class Test {

  public static void main(String[] args) {
    Calculator1.plus(100);
    Calculator1.plus(200);
    Calculator1.plus(300);
    System.out.println(Calculator1.result);

  }

}
