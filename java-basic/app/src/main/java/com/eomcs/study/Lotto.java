package com.eomcs.study;

public class Lotto {
  static int[] input() {
    int[] num = new int[6];
    num[0] = 2; num[1] = 7; num[2] = 5; num[3] = 9; num[4] = 3; num[5] = 8;
    return num;
  }

  static void output(int [] num) {
    for (int i = 0; i < num.length; i++) {
      System.out.print(num[i] + "\t");
    }
    System.out.println();
  }

  int outputSum() {
    int[] num = new int[6];
    num[0] = 2; num[1] = 7; num[2] = 5; num[3] = 9; num[4] = 3; num[5] = 8;

    int sum = 0;
    for (int i = 0; i < num.length; i++) {
      sum += num[i];
    }
    return sum;
  }
}
