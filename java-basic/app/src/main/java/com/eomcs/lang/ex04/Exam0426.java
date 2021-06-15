package com.eomcs.lang.ex04;

//# 부동소수점 변수 - 크기가 다른 변수끼리 값 할당
//
public class Exam0426 {
  public static void main(String[] args) {

    float f;
    double d;

    d = 3.14;
    
    // 값의 유효 여부에 상관없이 메모리 크기가 큰 변수의 값을 작은 크기에 변수에 저장할 수 없다.
    //f = d; // 문법 오류! double은 8byte고 float은 4byte이기 때문에
    f = (float)d; // 이 경우는 강제 형변환으로 가능하다.-> double을 강제로 float으로 바꿈
    // -> 이 때 8byte 메모리를 4byte 메모리에 억지로 넣는 것이므로 손실이 있을 수 있음
  }
}
