package com.eomcs.lang.ex05;

//# 산술 연산자 : 데이터 타입과 연산자
//
public class Exam0140 {
  public static void main(String[] args) {
    // 모든 종류의 데이터에 대해 산술 연산자를 사용할 수 있는 것은 아니다.
    // 데이터 타입에 따라 제공되는 연산자가 다르다.
    
    System.out.println(5.75 % 0.24);  // OK!
    //System.out.println(true % false); // boolean 타입에 대해서는 산술 연산자를 사용할 수 없다. 숫자가 아니기 때문에 산술 연산 불가
    //System.out.println(true + true); // 컴파일 오류!
    
    System.out.println("Hello," + "world!"); // OK! '+' 연산자는 문자열 연결 용도로 사용된다. 산수를 더하는 개념이 아니라 문자를 붙이는 역할
    //System.out.println("Hello," - "o,"); // 컴파일 오류!
    //System.out.println("Hello," * 5); // 컴파일 오류!
    
    System.out.println(true && true); // 논리 연산자 이므로 참 또는 참 이므로 참!이라고 출력됨
    //System.out.println(10 && 10); // 컴파일 오류!이다.
  }
}

