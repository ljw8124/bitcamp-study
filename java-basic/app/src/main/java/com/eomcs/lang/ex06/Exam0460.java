package com.eomcs.lang.ex06;

import java.util.ArrayList;

// # 흐름 제어문 - for 반복문과 컬렉션
// 값들을 모아 둔 것이 컬렉션이라 함
//
public class Exam0460 {
  public static void main(String[] args) {
    // 배열은 같은 타입의 값만 보관할 수 있지만
    // 컬렉션은 다른 타입의 값도 보관할 수 있다.
    //
    // 배열은 크기가 고정되지만,
    // 컬렉션은 크기가 가변적이다.
    ArrayList list = new ArrayList();
    list.add("홍길동");
    list.add(3.14f); // 부동소수점 가능
    list.add(true); // 논리 가능
    list.add(365);

    for (int i = 0; i < list.size(); i++) // 컬렉션인 경우는 size를 사용함(메서드), ()꼭 써야함
      System.out.println(list.get(i)); //get(index) -> index에 해당하는 값을 출력
  }
}


