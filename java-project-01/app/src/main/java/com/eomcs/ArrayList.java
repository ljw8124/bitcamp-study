package com.eomcs;

public class ArrayList { // 데이터 목록 관리

  // 배열의 최대 크기를 지정하는 변수는 모든 인스턴스가 같다.
  // => 따라서 각 인스턴스 마다 이 변수를 가질 필요는 없다.
  // => 그러므로 이 변수는 class변수로 그냥 두어도 무방함.
  // => 보통 상수 변수(final 변수)는 static 변수로 선언한다.
  static final int MAX_LENGTH = 100;

  //각 인스턴스 마다 개별적으로 관리해야 하는 변수는 인스턴스 변수로 선언한다.
  Object[] list = new Object[MAX_LENGTH]; // new는 당연히 Heap에 생성
  int size = 0;

  // 메서드가 작업할 때 인스턴스 변수를 사용할 수 있도록 파라미터로 인스턴스 주소를 전달.

  // 인스턴스 변수(예: list, size)를 사용하는 메서드는 인스턴스 메서드를 전환한다.
  // 인스턴스 메서드는 인스턴스 주소를 받는 this 이름의 레퍼런스가 내장하고 있다.
  void append(Object obj) { // 어느 주소에 있는 것을 사용할지 정하는 것.
    this.list[this.size++] = obj; //list와 size 변수가 static 변수가 아니면 주소 꼭 명시해야함.
  }

  Object[] toArray() {
    Object[] arr = new Object[this.size];
    for (int i = 0; i < this.size; i++) {
      arr[i] = this.list[i];
    }
    return arr; // return list; 해버리면 값이 채워지지 않은 배열까지 모두 return됨.
  }

  Object retrieve(int index) {
    return this.list[index];
  }

  void remove(int index) {
    for (int i = index; i < this.size - 1; i++) {
      this.list[i] = this.list[i + 1];
    }
    this.size--;
  }

}
// => static 변수로 접근하는 것이 아니라 instance로 접근하므로 주소가 필요해짐.
// => 인스턴스 주소 생략하는 방법 -> 인스턴스 메서드를 이용한다! this만 넣으면 됨.(자동생성)
// => 인스턴스 메서드로 쓸 것이 아니면 스태틱으로 생성해야됨