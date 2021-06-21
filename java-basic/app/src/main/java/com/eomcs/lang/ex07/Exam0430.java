package com.eomcs.lang.ex07;

//# 메서드 : 인스턴스와 Heap 메모리 영역
//
public class Exam0430 {

  // Heap 메모리에 어떤 변수를 만들어야 하는지 적어 놓은 설계도
  // 이런 형태의 class를 nested class 중첩 class 라고 부른다
  static class MyObject { // class 명이 다르기 때문에 .class 파일이 따로 생성
    int a;
    int b;
  }

  static MyObject getMyObject() {
    MyObject ref = new MyObject(); // 이 때 Heap에 변수를 생성 
    ref.a = 100; // .은 heap의 메모리에 찾아가서 a에 대입하라는 것이다
    ref.b = 200;

    return ref;
  }

  public static void main(String[] args) {
    MyObject ref;
    ref = getMyObject();
    System.out.println(ref.a);
    System.out.println(ref.b);
  }
}

// 1) main() 호출
//    => JVM Stack: args, ref 변수 생성
// 2) getMyObject() 호출
//    => JVM Stack: ref 변수 생성
//    => Method Area: MyObject 클래스를 로딩
//    => Heap: MyObject 설계도에 따라 인스턴스 생성
// 3) getMyObject() 호출 끝
//    => JVM Stack: getMyObject() 관련 메모리(ref 변수) 제거 (리턴하면서 삭제)
//    => new로 생성한 Heap에 존재하는 변수는 제거되지 않고 남아있음 
//    => MyObject의 인스턴스의 주소 리턴
// 4) main() 호출 끝
//    => JVM Stack: main() 관련 메모리 제거 
// 5) JVM 종료
//    => JVM이 사용한 모든 메모리(Method Area, JVM Stack, Heap 등)를 OS 반납.