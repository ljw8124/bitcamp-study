package com.eomcs.study;

public class LottoUser {
  public static void main(String[] args) {


    int[] lotto = Lotto.input();

    Lotto.output(lotto); // 리턴을 하지 않으므로(void) 변수로 따로 선언 불가

    Lotto totalSum = new Lotto();
    int value = totalSum.outputSum();

    System.out.printf("배열의 전체 합은 %d 입니다\n", totalSum.outputSum());
    System.out.printf("배열의 전체 합은 %d 입니다\n", value);

  }

}
