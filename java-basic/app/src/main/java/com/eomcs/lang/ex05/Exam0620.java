package com.eomcs.lang.ex05;

//# 증감 연산자 : 후위(post-fix) 감소 연산자
//
public class Exam0620 {
  public static void main(String[] args) {
    int i = 7;

    i--;
    // 현재 위치에 i 메모리에 들어 있는 값(변수를 놓는게 아님)을 꺼내 놓는다. 
    // i 메모리의 값을 1 감소시킨다. -> 먼저 실행하고 그 후에 감소

    i--;

    System.out.println(i); // 5

    System.out.println(i--);
    // == System.out.println(5);
    // i = i - 1;
    System.out.println(i);

  }
}
