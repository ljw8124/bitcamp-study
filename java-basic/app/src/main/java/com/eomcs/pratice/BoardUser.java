package com.eomcs.pratice;

public class BoardUser {

  public static void main(String[] args) {
    Board input = new Board();
    input.setTitle("6월 장미축제"); // xml문서전달 (리턴값 x) setter
    String data = input.getTitle(); // java 에서 출력 (리턴값 o) getter
    System.out.println(data); // 뷰 웹화면

    // 게터 세터 ==> lombok 롬복 연결

  }

}
