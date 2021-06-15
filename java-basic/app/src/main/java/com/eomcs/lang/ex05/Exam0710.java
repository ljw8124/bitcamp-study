package com.eomcs.lang.ex05;

//# 할당(배정,대입) 연산자  : +=  -=  *=  /=  %=  &=  |=  ^=  <<=  >>=  >>>=
//
public class Exam0710 {
  public static void main(String[] args) {
    int i = 2;

    //i = i + 20; 밑에 문장을 컴파일할때 컴퓨터가 읽는 문장
    i += 20; // += 연산자를 사용하면 위의 코드를 축약할 수 있다.
    System.out.println(i);

    i = 2;
    i *= 5; //== i = i * 5;
    System.out.println(i);

  }
}
