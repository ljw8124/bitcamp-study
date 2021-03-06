package com.eomcs.lang.ex04;

//# 변수 사용 오류 I
//- 변수에 값을 저장하지 않은 상태에서 변수를 사용할 수 없다.
//

public class Exam0330 {
  public static void main(String[] args) {
    
    int age;
    
    //값이 저장되지 않은 변수를 사용하면 문법 오류이다. -> 선언만 하고 값을 지정하지 않았기 때문에 컴파일 오류
    System.out.println(age); // c는 상관없지만 java는 오류 남! if 이 문장을 주석처리한다면 컴파일 오류가 나타나지 않음
  }
}
