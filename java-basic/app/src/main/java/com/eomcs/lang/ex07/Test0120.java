package com.eomcs.lang.ex07;

import java.util.Scanner;

public class Test0120 {

  static void printSpaces(int spaceLen) {
    for (int count = 0; count < spaceLen; count++) {
      System.out.print(" ");
    }
  }
  static void printStars(int starLen) {
    for (int count = 0; count < starLen; count++) {
      System.out.print("*");
    }
  }
  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);
    System.out.print("밑변의 길이? ");
    int totalLen = keyScan.nextInt();
    keyScan.close();

    for (int starLen = 0; starLen < totalLen; starLen +=2) {
      printSpaces((totalLen - starLen) / 2);
      printStars(starLen);
      System.out.println();
    }
  }
}

