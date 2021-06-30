package com.eomcs.day0630;

import java.util.Scanner;

public class Work05Hotel {
  // 생성자 클래스이름, 리턴값x, void 기술x
  // 생성자 사용은 new 키워드 다음에 기술 '클래스 ob = new  클래스()' 
  // 생성자는 중복가능, 기본생성자 생략가능
  //멤버필드 = 전역변수 private
  private int floor; // 층=행 3층
  private int room; // 호=열 5호 => 3층*5열 = 15방구성
  private String[][] nmae = new String[3][5];
  private String title;
  public Work05Hotel() { }
  public Work05Hotel(String name) { }
  public Work05Hotel(String name, int year) { }


  public void process () {
    Scanner sc = new Scanner (System.in);
    int sel = 9;
    while(true) {
      System.out.println("1. 투숙  2. 퇴실  3.map  4.list  9.종료 >>> ");
      sel = Integer.parseInt(sc.nextLine());
      if (sel == 9) {
        System.out.println("호텔 예약 프로그램 종료합니다.");
        System.exit(1); // break; 같은 역할
      }
      switch (sel) {
        case 1:
          checkIn();
          break;
        case 2:
          checkOut();
          break;
        case 3:
          map();
          break;
        case 4:
        default:

      }
    }
  }

  public void checkIn() {

  }

  public void checkOut() {

  }

  public void map() { // printAll() = list() = display()

  }



  public static void main(String[] args) {
    Work05Hotel wh = new Work05Hotel("남산하얏트");
    wh.process();
  }


}
