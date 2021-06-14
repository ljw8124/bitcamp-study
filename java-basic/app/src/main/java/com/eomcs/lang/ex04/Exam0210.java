package com.eomcs.lang.ex04;

//# 블록 안에서 변수 선언 위치  
//
public class Exam0210 {
  
  public static void main(String[] args) {
    //사용할 변수를 블록({}) 시작 부분에 미리 선언해 놓아도 된다. -> 이 때 선언한 변수의 유효 범위는 그 해당 블록({}) 내에서만 유효함.
    int age;
    int weight;
    int height;
    
    age = 20;
    weight = 100;
    height = 200;
    
    //변수가 필요할 때 블록({}) 중간 부분에 언제든 선언할 수 있다. //그 대신 위와 마찬가지로 해당 블록 내에서만 유효함.
    int score;
    
    score = 100;
    System.out.println(age);
  }
  // System.out.println(age); 여기서 출력하게되면 컴파일 오류가 발생. 왜냐하면 선언한 변수의 유효 범위 밖에서 선언되지 않은 age를 출력하려 했기 때문이다
}
