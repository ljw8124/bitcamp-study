package com.eomcs.day0630;

import java.io.InputStream;
import java.util.Scanner;

public class Work03jumin {

  public static void main(String[] args) {
    InputStream is = System.in;
    Scanner sc = new Scanner(System.in);
    int sabun = 0;
    String name = null;

    //문제 키보드에서 입력 Scanner 클래스 반드시 입력해서 출력, 예외처리, 형변환
    while (true) {
      try {
        System.out.print("사번 입력 >>> ");
        sabun = Integer.parseInt(sc.nextLine());
        System.out.print("이름 입력>>> ");
        name = sc.nextLine();
        if (name.equals("") || name.equals(null)) {
          System.out.println("바른 이름을 입력하세요");
          continue;
        }
        break;
      } catch (Exception e) {
        System.out.println("바른 사번을 입력하세요");
      }

    }

    System.out.println();
    System.out.println("사번 = " + sabun);
    System.out.println("이름 = " + name);


  }    

}
