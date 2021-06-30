package com.eomcs.day0630;

public class TestJumin {
  public static void main(String[] args) {
    // java.lang package String클래스의 메소드 char charAt(int);
    // java.lang package String클래스의 메소드 int indexOf(int/String)
    // java.lang package String클래스의 메소드 String substring(1시작,2끝-1)
    // java.lang package String클래스의 메소드 String substring(1시작) <- 시작부터 끝까지
    String min = "871024-1541965";
    int pos = min.indexOf("-"); // "-" 이 있는 문자열의 배열 수를 알려줌
    System.out.println("pos= " + pos);
    // 10월 24일 생일이네요
    String month = min.substring(2, 4); // 2로 시작해서 4(-1)까지 => 2번째 3번째 출력
    String day = min.substring(4, 6); // 4로 시작해서 6(-1)까지 => 4번째 5번째 출력
    System.out.println(month + "월 " + day + "일 입니다.");

    String last = min.substring(7); //시작점은 7배열부터 끝 없음
    System.out.println(last);

    int len = min.length();
    System.out.println("총자리수 = " + len);

    //min의 문자열의 0번째 배열 char 를 뽑아내는것 -> char의 형식으로
    char a = min.charAt(1);
    System.out.println(a);
  }
}

/*
  public static void main(String[] args) {
    String min = new String();
    while (true) {
      System.out.print("당신의 주민번호를 입력하세요 : ");
      Scanner scanner = new Scanner(System.in);
      min = scanner.nextLine();
      char num = min.charAt(7);
      // charAt을 이용하면 String 문자열은 index 0번째부터 시작
      // 조건 if 남자입니다. 여자입니다

      // ||이나 &&은 조건식끼리 사용할 때 쓴다.
      // |이나 &은 정수끼리 사용할 때 쓴다.

      switch (num) {
        case '1':
        case '3': 
          System.out.println("남자입니다.");
          break;
        case '2':
        case '4':
          System.out.println("여자입니다.");
          break;
        default:
          System.out.println("잘못된 번호를 입력하셨습니다.");
      }
      scanner.close();
    }
  }
 */
