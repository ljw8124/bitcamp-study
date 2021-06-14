package com.eomcs.lang.ex04;

//# 변수의 값 변경
//
public class Exam0170 {
  public static void main(String[] args) {
    int age;
     
    age = 20; 
    System.out.println(age);
    
    //할당 연산자를 이용하면 언제든 해당 메모리에 다른 값을 저장할 수 있다.
    age = 30; // 이 때부터 age의 값은 20이 아니라 30으로 설정
    System.out.println(age);
  }
}

