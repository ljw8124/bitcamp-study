package com.eomcs.lang.ex07;

import java.util.Scanner;

//# 메서드(Method) = 함수 (Function) : 사용 전
// 메서드는 명렁어를 기능 단위로 묶는 방법을 말함(관리를 용이하게 하기 위해)
//
//                이 때 변수는 리턴 값의 데이터 타입과 같아야 한다
// 표현식/   밑에 변수는 메서드를 실행할 때 값을 받는 변수로 '파라미터(parameter)'라 불림
// 메서드명(변수 선언, 변수선언, ...) {   <- 리턴타입은 메서드가 리턴하는 값의 데이터타입을 가리킴
//   명령문 ex) 변수선언, 연산자, 조건문, 반복문, ...
//      return 값;
//
//
public class Exam0110 {
  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);
    System.out.print("밑변의 길이? ");
    int len = keyScan.nextInt();
    keyScan.close(); // 입력할 일 없어지면 필요없으니까 바로 닫아도 된다

    int starLen = 1;
    while (starLen <= len) {
      // 별 앞에 공백 출력
      int spaceCnt = 1;
      int spaceLen = (len - starLen) / 2;
      while (spaceCnt <= spaceLen) {
        System.out.print(" ");
        spaceCnt++;
      }

      // 별 출력
      int starCnt = 1;
      while (starCnt <= starLen) {
        System.out.print("*");
        starCnt++;
      }

      // 출력 줄 바꾸기
      System.out.println();
      starLen += 2;

    }
  }
}