package com.eomcs.pratice;

public class LottoUser {

  public static void main(String[] args) {
    int[] result = Lotto.input(); // 출력의 목적x output이 출력의 목적을 가짐

    Lotto.output(result);

    Lotto lotto = new Lotto();
    lotto.inputSum(); // 리턴값을 받지 않으면 그냥 호출만 함. 에러는 없음
    int value = lotto.inputSum();

    System.out.printf("합계는 %d 입니다\n", value);
    System.out.printf("합계는 %d 입니다\n", lotto.inputSum());
    System.out.println("LottoUser");

  }

}