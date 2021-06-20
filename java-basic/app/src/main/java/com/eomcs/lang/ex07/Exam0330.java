package com.eomcs.lang.ex07;

//# 메서드 : reference를 return 하기
//
public class Exam0330 {

  // swap()에서 만든 int a와 int b의 값을 main()에서 사용하기
  // primitive data type 값을 객체(Object=Instance)에 담아 넘겨라!
  // primitive type은 byte short int long 같은 것! 나머지는 다 reference

  static class MyObject {
    int a;
    int b;
  }

  static MyObject swap(int a, int b) {
    MyObject ref = new MyObject(); // MyObject 설계도에 따라서 설정하라는 것
    ref.a = b;
    ref.b = a;
    return ref;
  }

  public static void main(String[] args) {
    int a = 100;
    int b = 200;

    MyObject ref = swap(a, b);
    System.out.printf("main(): a=%d, b=%d\n", ref.a, ref.b);
  }
}
