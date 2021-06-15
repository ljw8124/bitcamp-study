package com.eomcs.lang.ex05;

//# 산술 연산자 : 암시적 형변환과 연산 우선순위
//
public class Exam0160 {
  public static void main(String[] args) {
    float r1 = 5 / 2 + 3.1f;
    // 계산 순서:
    // r1 = int(5) / int(2) + float(3.1);
    // r1 = int(2) + float(3.1);
    // r1 = float(2.0) + float(3.1)
    // r1 = float(5.1)
    //
    // => 연산 우선 순위에 따라 계산하는 순간에 암시적 형변환이 이루어진다. float이 포함되어 있으므로 소수점으로 표현된다
    // => 모든 값을 최종 결과 타입으로 바꾸고 계산하지는 않는다. 연산자중 하나만 최종 결과 타입으로 바꾸면 되기 때문에
    // => 소수점을 출력하고 싶다면 연산자 둘중 하나는 정수이고 하나는 소수점이라면 자동으로 소수점을 포함한 값으로 출력된다
    System.out.println(r1);
    
    float r2 = 3.1f + 5 / 2;
    // 계산 순서 -> 한쪽이 float이어서 float으로 형변환 되었음
    // r2 = float(3.1) + int(5) / int(2)
    // r2 = float(3.1) + int(2)
    // r2 = float(3.1) + float(2.0)
    // r2 = float(5.1)
    System.out.println(r2);
  }
}










