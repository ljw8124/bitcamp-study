package com.eomcs.pratice;

// 인터페이스 메소드를 선언만 -> 추상메소드 abstract method
// 인터페이스 = 메모 = 명세서
// 인터페이스 상속을 받아서 재활용(재정의=overRiding) vs overLoading은 중복
public interface BoardImp { // 키워드  class 대신 interface 기술
  // 상속 받은 클래스에서 재정의 의미. @Overriding 으로 기술 <- 생략 가능
  public int boardCount();
  public void boardInsert();
  public void boardDelete(int num);
}

// 인터페이스와 상속은 계속 나옴 주의