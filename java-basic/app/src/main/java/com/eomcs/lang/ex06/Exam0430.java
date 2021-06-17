package com.eomcs.lang.ex06;

// # 흐름 제어문 - for 중첩과 break
//
public class Exam0430 {
  public static void main(String[] args) {
    // for 문의 중첩
    for (int i = 1; i <= 10; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.print("*" + " "); // 위 조건문을 만족하는 동안 안의 값을 출력
      }
      System.out.println();
    }
  }
}


