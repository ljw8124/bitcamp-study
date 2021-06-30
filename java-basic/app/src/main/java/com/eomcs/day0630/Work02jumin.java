package com.eomcs.day0630;

import java.io.InputStream;

public class Work02jumin {

  public static void main(String[] args)  throws Exception {
    //    try {
    // 자바에서 표준입력 ascii코드 byte 형태
    // 자바에서 표준입력 System.in  키보드입력
    InputStream is = System.in; // static InputSteram in 필드 표준 -> ascii 코드

    // java.util package Scanner 생성자 3번째(InputStream)
    //    Scanner sc = new Scanner(is);
    //    Scanner sc1 = new Scanner(System.in); // 표준 text a

    System.out.print("단입력>>> ");
    int dan = is.read();
    for (int a = 1; a < 10; a++) {
      System.out.printf("%d * %d = %d\n", dan, a, dan*a);
    }
    //    } catch (Exception e) { }
  }

}
