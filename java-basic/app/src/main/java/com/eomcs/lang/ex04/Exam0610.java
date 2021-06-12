package com.eomcs.lang.ex04;

//# 상수 - 변수의 값을 고정하는 방법
//
public class Exam0610 {
  public static void main(String[] args) {
    // 변수
    // => 언제든지 값을 변경할 수 있다.
    int a;
    a = 10;
    // System.out.println(a) 했을 때 10출력
    a = 100;
    // System.out.println(a) 했을 때 100출력
    a = -300;
    // System.out.println(a) 했을 때 -300출력

    // 상수
    // => 값을 오직 한 번만 저장할 수 있다. 이 말은 후에 변경이 불가능하다는 말이다
    // => 변수 앞에 final을 붙여라!
    final int b;
    b = 100;

    // 만약 final로 선언된 변수의 값을 두 번째로 바꾸려 한다면?
    //b = 200; // 컴파일 오류!

    // 변수와 상수를 구분하기 위해서
    // => 상수인 경우 이름을 보통 모두 대문자로 작성한다.
    // => 그리고 변수를 선언하는 문자에서 바로 값을 초기화시킨다.
    final float PI = 3.14159f;
    final float MILE = 0.621371f;


  }
}
