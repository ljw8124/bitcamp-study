package com.eomcs.array;

public class TestException {

  public static void main(String[] args) {

    int su1 = 9;
    int su2 = 5;
    int hap, mok = 0;

    hap = su1 * su2;
    mok = su1 / su2;

    System.out.printf("%d * %d = %d\n", su1, su2, hap);
    System.out.printf("%d / %d = %d\n", su1, su2, mok);

    boolean[] camp = new boolean[5];
    try {
      System.out.println(camp[1]);
      System.out.println(camp[5]);
    } catch (Exception ex) {System.out.println("에러이유" + ex);} 


  }

}
