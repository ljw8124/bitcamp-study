package com.eomcs.pratice;

public class Lotto {

  public static int[] input() {
    int[] su = new int[6]; // su 배열 지역 변수로 선언
    su[0] = 2; su[1] = 3; su[2] = 5; su[4] = 4; su[5] = 1;
    return su;
  }

  public static void output(int[] number) {
    for (int i = 0; i < number.length; i++) {
      System.out.print(number[i] +"\t");
    }
    System.out.println("\n로또 출력 완료");
  }

  public int inputSum() {
    int[] su = new int[6]; // su 배열 지역 변수로 선언
    su[0] = 2; su[1] = 3; su[2] = 5; su[4] = 4; su[5] = 1;

    int sum = 0;
    for (int i = 0; i < su.length; i++) {
      sum += su[i];
    }
    //    System.out.println(sum);
    return sum;
  }

}


