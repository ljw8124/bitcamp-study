package com.eomcs.day0630;

public class BoardBit implements BoardImp {

  public static void main(String[] args) {

  }

  @Override
  public int boardCount() {
    return 0;
  }

  @Override
  public boolean boardInsert() {
    return false;
  }

  // @Override 생략가능 (재정의 할때)
  public void boardDelete(int num) {
  }

  // 인터페이스 소속 x, 상속x, 재정의대상x => @override 는 불가(기술하면 에러)
  public void index() {

  }

}
