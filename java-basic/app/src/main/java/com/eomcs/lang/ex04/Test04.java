package com.eomcs.lang.ex04;

public class Test04 {
  public static void main(String[] args) {
    // 배열 메모리의 시작 주소를 저장할 레퍼런스 선언
    int[] a;

    // 레퍼런스 변수에 배열 메무리의 주소를 준다.
    a = new int[3];

    a[0] = 100;
    a[1] = 200;
    a[2] = 300;
    // a[3] = 400; // 컴파일은 되나 실행이 안됨. 배열 안에 없기 때문에 실행 불가

    System.out.println(a[0]);
    System.out.println(a[1]);
    System.out.println(a[2]);
    // System.out.println(a[3]); // 존재하지 않는 값이기 때문에 실행 오류


    int[] b;
    b = a; //주소를 공유하게 되어서 같은 값을 가지게됨
    System.out.println(b[1]);
    
   }
}
