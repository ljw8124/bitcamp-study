package com.eomcs.day0701;

import java.util.Scanner;

public class Work05Hotel {
  // 생성자 클래스이름, 리턴값x, void 기술x
  // 생성자 사용은 new 키워드 다음에 기술 '클래스 ob = new  클래스()' 
  // 생성자는 중복가능, 기본생성자 생략가능
  //멤버필드 = 전역변수 private
  private int floor; // 층=행 3층
  private int room; // 호=열 5호 => 3층*5열 = 15방구성
  private String[][] name = new String[3][5];
  private String title;
  private String visitorName;

  public Work05Hotel() { }
  public Work05Hotel(String name) { }
  public Work05Hotel(String name, int year) { }
  static Scanner sc = new Scanner (System.in);


  public void process () {
    map();
    int sel = 9;
    while(true) {
      try {
        System.out.print("1. 투숙  2. 퇴실  3.map  4.list  9.종료 >>> ");
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
            list();
          default:

        }

      } catch (Exception e) {
        System.out.println("잘못된 번호를 입력하셨습니다.");
      }

    }

  }

  public void checkIn() {

    System.out.print("투숙하시겠습니까? (y / N) ");
    if (sc.nextLine().equals("y")) {
      System.out.print(">몇층에 투숙? ");
      int floor = Integer.parseInt(sc.nextLine());

      System.out.print(">몇호에 투숙? ");
      int room = Integer.parseInt(sc.nextLine());

      System.out.print(">투숙객 이름? ");
      String visit = sc.nextLine();

      if (name[floor-1][room-1] != null) {
        System.out.println("이미 예약된 호실입니다.");
        System.out.println();
      } else {
        name[floor-1][room-1] = visit;
        System.out.println("# 성공적으로 Check in 되었습니다.");
        System.out.println();
      }

    } else if (sc.nextLine().equals("N")) {
      System.out.println("투숙을 취소하였습니다");
    }
  }

  public void checkOut() {
    System.out.print("퇴실하시겠습니까? (y / N) ");
    if (sc.nextLine().equals("y")) {
      System.out.print(">몇층 퇴실? ");
      int floor = Integer.parseInt(sc.nextLine());

      System.out.print(">몇호 퇴실? ");
      int room = Integer.parseInt(sc.nextLine());

      if (name[floor-1][room-1] == null) {
        System.out.println("이미 비어있는 호실입니다.");
      } else {
        name[floor-1][room-1] = null;
        System.out.println("# 성공적으로 Check out 되었습니다.");
        System.out.println();
      }

    } else if (sc.nextLine().equals("N")) {
      System.out.println("퇴실을 취소하였습니다");
    }

    System.out.println();
  }

  public void map() { // printAll() = list() = display()
    System.out.printf("\t[  %s 투숙상태 ]\n", title);
    for (int f = 0; f < 3; f++) {
      for (int r = 0; r < 5; r++) {
        System.out.print((f + 1) + "0" + (r + 1) + "\t");
      }
      System.out.println();

      for (int j = 0; j < 5; j++) {
        if (this.name[f][j] == null) {
          System.out.print("\t");
          continue;
        }
        System.out.print(this.name[f][j] + "\t");
      }
      System.out.println("\n---------------------------------------");
    }
  }

  public void list() {
    System.out.printf("\t[  list ]\n");
    for (int f = 0; f < 3; f++) {
      for (int r = 0; r < 5; r++) {
        if (name[f][r] == null) {
          System.out.printf("%d0%d호 □ %s\t", f+1, r+1, "");
        } else {
          System.out.printf("%d0%d호 ■ %s\t", f+1, r+1, name[f][r]);
        }
      }
      System.out.println();
    }
  }


  public static void main(String[] args) {
    Work05Hotel wh = new Work05Hotel("남산하얏트");
    wh.process();
  }


}
