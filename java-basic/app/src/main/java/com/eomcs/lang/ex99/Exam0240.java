package com.eomcs.lang.ex99;

//# 키보드 입력 받기 - 여러 종류의 데이터를 섞어 입력 받기
//
public class Exam0240 {
  public static void main(String[] args) { 
    java.util.Scanner keyboard = new java.util.Scanner(System.in);

    System.out.print("나이? ");
    int age = keyboard.nextInt();
    // nextInt()는 한 개의 토큰을 읽은 후에 줄 바꿈 코드는 읽기 전 상태로 내비둔다.
    // 버퍼에서 한개의 토큰을 꺼낸다.
    // 따라서 다음에 nextLine()을 호출하면 의도치 않게 빈 문자열을 가진 한 줄을 
    // 읽는 상황이 된다. => 엔터를 읽어버림
    // nextInt() 다음에 nextLine()을 호출할 때 이런 상황이 발생한다.
    // 해결 방법? nextInt()를 호출한 후 남아있는 엔터 코드를 읽어서 제거하라.
    keyboard.nextLine(); // 남아 있는 빈 문자열의 한 줄(LF 코드)을 읽어서 버린다.
    // -> 숫자 뒤에 붙은 줄바꿈 코드(엔터)를 제거하는 효과

    // 위에서 엔터를 제거했기 때문에 다음 한줄을 입력할 때 까지 기다린다
    System.out.print("이름? ");
    String name = keyboard.nextLine();

    keyboard.close();

    System.out.printf("%d(%s)\n", age, name);
  }
}















