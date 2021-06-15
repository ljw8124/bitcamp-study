package com.eomcs.lang.ex05;

//# 관계 연산자(relational operators: <, <=, >, >=), 등위 연산자(equality operators: ==(같으냐), !=(다르냐))
//
public class Exam0210 {
  public static void main(String[] args) {
    int a = 10;
    int b = 20;
    
    // 비교의 결과는 true 또는 false이다. (논리연산자)
    // 즉 boolean 값이다.
    boolean r1 = a < b; // true
    
    // int r2 = a < b; // 컴파일 오류! -> 관계연산자의 결과는 boolean 값 int로는 논리 연산자를 출력할 수 없음

    System.out.println(a < b); // true
    System.out.println(a <= b); // true
    System.out.println(a > b); // false
    System.out.println(a >= b); // false
    System.out.println(a == b); // false
    System.out.println(a != b); // true

// 오히려 문법 오류가 낫고 잘못된 값을 산출하는 것이 더 걱정이다
  }
}
