package com.eomcs.lang.ex06;

public class Test01 {

  static int countEvenNumbers(int value) {
    int count = 0;

    // 이 메서드는 주어진 파라미터(value)로 주어진 값을 분석하여
    // 짝수 개수를 리턴하는 메서드이다.
    // 코드를 완성하시오!
    // ex) value = 4567034 --> 리턴 값 = 4
    // ex) value = 8088753 --> 리턴 값 = 3

    int n = value;
    while (n != 0 ) {
      if ((n & 0x01) == 0) {
        count++;
      }
      n /= 10;
    }

    return count;
  }

  public static void main(String[] args) {
    int result = countEvenNumbers(4567034);
    System.out.println(result); //4

    result = countEvenNumbers(8188753);
    System.out.println(result); //4

  }
}
