package com.eomcs;

// 메뉴를 처리할 클래스가 반드시 만들어야 하는 메서드의 시그너처를 정한다.
interface Handler {
  void execute (); // interface 는 Method body 가 있으면 안된다.
}
