package com.eomcs;

import java.util.Scanner;

public class ComputeHandler implements Handler{
  static Scanner keyScan;

  public void execute () {
    while (true) {
      System.out.println("계산식 : (이전 메뉴 : back) (예: 100 * 4) ");
      String expression = keyScan.nextLine();

      if (expression.equals("back")) {
        break;
      }

      String[] arr = expression.split(" ");
      if (arr.length != 3) {
        System.out.println("계산식의 입력이 잘못되었습니다.");
        continue;
      }
      int a = Integer.parseInt(arr[0]);
      int b = Integer.parseInt(arr[2]);

      switch (arr[1]) {
        case "+":
          System.out.printf("%d + %d = %d\n", a, b, a + b);
          break;
        case "-":
          System.out.printf("%d - %d = %d\n", a, b, a - b);
          break;
        case "*":
          System.out.printf("%d * %d = %d\n", a, b, a * b);
          break;
        case "/":
          System.out.printf("%d / %d = %d\n", a, b, a / b);
          break;
        case "%":
          System.out.printf("%d %% %d = %d\n", a, b, a % b);
          break;
        default:
          System.out.println("이 연산자는 지원하지 않습니다.");

      }
    }
  }
}
