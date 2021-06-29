package com.eomcs.pratice;

import java.util.Scanner;

public class TestJumin {

  public static void main(String[] args) {
    String min = new String();
    Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.print("당신의 주민번호를 입력하세요 : ");
      min = scanner.nextLine();
      char num = min.charAt(7);
      // charAt을 이용하면 String 문자열은 index 0번째부터 시작
      // 조건 if 남자입니다. 여자입니다

      // ||이나 &&은 조건식끼리 사용할 때 쓴다.
      // |이나 &은 정수끼리 사용할 때 쓴다.

      switch (num) {
        case '1':
        case '3': 
          System.out.println("남자입니다.");
          break;
        case '2':
        case '4':
          System.out.println("여자입니다.");
          break;
        default:
          System.out.println("잘못된 번호를 입력하셨습니다.");
      }
      scanner.close();
    }
  }

}
