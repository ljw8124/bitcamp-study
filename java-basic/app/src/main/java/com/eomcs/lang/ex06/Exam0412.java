package com.eomcs.lang.ex06;

//# 흐름 제어문 - for 반복문
//
public class Exam0412 {
  public static void main(String[] args) {
    // for (변수선언 및 초기화; 조건; 증감문) 문장;
    // for (변수선언 및 초기화; 조건; 증감문) {문장1; 문장2; ...}

    // 변수 선언 및 초기화 문장 제거
    int i = 1; // 따로하려면 무조건 먼저 변수 선언 해야함
    // for 문 안에 쓰는 것보다 따로 선언하는 것이 좋음 -> for 문 밖에서도 이용하기 위해서
    for (; i <= 5;) {
      System.out.println(i);
      i++;
    }

    // for 문을 종료한 후에도 i 변수를 사용할 수 있다.
    //System.out.println(i);
  }
}
