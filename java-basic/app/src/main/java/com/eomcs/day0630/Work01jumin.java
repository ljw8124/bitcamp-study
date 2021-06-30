package com.eomcs.day0630;

public class Work01jumin {

  public static void main(String[] args) { 
    String min = "871024-1541965";
    String minF = min.substring(0, 6);
    String minB = min.substring(7, 14);

    // System.out.printf("당신의 주민번호는 %s-%s 입니다.\n", minF, minB);

    // 문제 1 총자리수 6-7 13자리수, 14자리수
    // 문제 2 ******-1541965 로 출력
    // 문제 3 2/4 여자, 1/3 남자 스위치문
    // -> length(), substring(), indexOf(), charAt()

    // 문제 1
    int minFLenght = minF.length();
    int minBLenght = minB.length();

    if (minFLenght == 6 && minBLenght == 7) { // 문자열의 비교는 equals() 를 이용한다
      System.out.println("주민번호 입력이 완료되었습니다.");
    } else {
      System.out.println("잘못된 주민번호 입니다.");
    }

    // 문제 2
    min.indexOf("-");
    String minSecret = min.substring(0, min.indexOf("-"));
    minSecret = "******";
    System.out.printf("당신의 주민번호는 %s-%s 입니다.\n", minSecret, minB);

    // 문제 3
    char num = min.charAt(7);
    switch (num) {
      case '1':
      case '3':
        System.out.println("당신은 남자입니다.");
        break;
      case '2':
      case '4':
        System.out.println("당신은 여자입니다.");
        break;
      default:
        System.out.println("잘못된 주민번호 입니다.");
    }



  }

}
