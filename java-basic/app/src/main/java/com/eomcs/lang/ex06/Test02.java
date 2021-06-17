package com.eomcs.lang.ex06;

import java.util.Scanner;

public class Test02 {

  public static void main(String[] args) {

    Scanner keyScan = new Scanner(System.in);
    System.out.print("점수를 입력하세요 : ");
    int score = keyScan.nextInt();

    if ((score < 0) || (score > 100)){
      System.out.println("올바른 점수를 입력하세요.");
    } else if (score < 100) {
      switch (score) {
        case 100:
        case 90:
          System.out.println("A");
          break;
        case 80:
        case 70:
          System.out.println("B");
          break;
        case 60:
        case 50:
        case 40:
          System.out.println("C");
          break;
        default:
          System.out.println("F");
      }
    }
    keyScan.close();
  }
}
