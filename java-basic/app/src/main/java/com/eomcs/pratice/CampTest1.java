package com.eomcs.pratice;

import java.util.Scanner;

public class CampTest1 {

  static Scanner sc = new Scanner(System.in);
  static int sel = 9;

  public static void main(String[] args) {
    System.out.println("1차원 배열 캠프예매 28일 월요일 ");

    Handler handler = new Handler ();

    handler.confirm();

    while (true) {
      try {
        System.out.print("\n1.예약  2.퇴실  3.보기  9.종료 : ");
        sel = Integer.parseInt(sc.nextLine());

        if (sel == 9) {
          break;
        }

        switch (sel) {
          case 1: 
            handler.input(); break;
          case 2: //퇴실은 조별/개인별처리
            handler.quit(); break;
          case 3: //전체예약상태
            handler.confirm(); break;
          default: 
            System.out.println("1~3메뉴를 선택하셔야 합니다");
            break;   
        }
      } catch (Exception e) {   }
    }
    System.out.println("캠프장 예약 프로그램을 종료합니다");

    sc.close();
  }//end
}//class END