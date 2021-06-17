package com.eomcs.lang.ex06;

//# 흐름 제어문 - if 문의 조건
//
public class Exam0130 {
  public static void main(String[] args) {

    // if 문의 조건은 반드시 boolean 데이터여야 한다.
    if (true) System.out.println("1111"); // 참이면 옆 문장 출력
    if (false) System.out.println("2222"); // 거짓이면 옆 문장 출력
    if (10 < 8 + 5) System.out.println("3333"); // 괄호안에 조건을 만족하면 옆 문장 출력

    // 그 외의 모든 데이터 타입은 컴파일 오류이다.
    //if (1) System.out.println("4444"); // 컴파일 오류! 정수x
    //if (3.14f) System.out.println("4444"); // 컴파일 오류! 부동소수점x
    //if (0b0110 & 0b0011) System.out.println("4444"); // 컴파일 오류! 16진수 표현x

    // == 연산자 대신 =을 사용한 경우,(오타) '='과 '=='은 다름
    int a = 100;
    if (a == 100) System.out.println("5555"); // OK!

    // 다음은 a 변수에 100을 넣는다.
    // 그런데 a가 boolean이 아니기 때문에 컴파일 오류가 발생한다. -> a는 int
    //if (a = 100) System.out.println("6666"); // 컴파일 오류! 

    boolean b;
    if (b = true) System.out.println("된다!");
  }
}










