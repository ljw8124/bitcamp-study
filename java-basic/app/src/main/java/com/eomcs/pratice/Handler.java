package com.eomcs.pratice;

import java.util.Scanner;

public class Handler {

  static boolean[] camp = new boolean[5];
  static Scanner sc = new Scanner(System.in);

  void confirm() {
    //캠핑장 예약상태확인 
    for (int i = 0; i < camp.length; i++) {
      if(camp[i] == true) {
        System.out.println("  "+ (i + 1) + "번째 ■캠프사용중입니다 "  );
      } else {
        System.out.println("  "+ (i + 1) + "번째 □캠프장은 비어 있습니다 "  ); 
      }
    } //for end
  }

  void input () {
    System.out.print("예약캠핑번호 입력>>> ");
    int num = Integer.parseInt(sc.nextLine()); //고객이 5입력
    if (num < 1 || num > 5) { System.out.println("올바른 번호를 입력하세요"); }
    if (camp[num - 1] == true) {
      System.out.println("이미 예약된 방 번호 입니다");
    } else {
      System.out.println(num + "번 방이 예약되었습니다");
      camp[num - 1] = true;
    }
  }

  void quit () {
    System.out.print("퇴실캠핑번호 입력>>> ");
    int num = Integer.parseInt(sc.nextLine()); //3입력하면
    if (camp[num - 1] == false) {
      System.out.println(num + " 번 방은 아직 예약되지 않았습니다");
    } else {
      System.out.println(num + "번 방이 퇴실되었습니다");
      camp[num - 1] = false;
    }
  }
}
