package com.eomcs.lang.ex07;

//# 메서드 : 스택 메모리 응용 I
//
public class Exam0440 {

  static int m1(int value) {
    int r1 = m2(value);
    int r2 = m3(value);
    return r1 + r2;
  }

  static int m2(int value) {
    return value + 100;
  }

  static int m3(int value) {
    return value + 200;
  }

  public static void main(String[] args) { // main을 제일 먼저 호출
    int r = m1(5);
    System.out.println(r);
  }
}
// JVM Stack 메모리의 사용
// 0) 시작
// 1) main()
// 2) main() => m1()
// 3) main() => m1() => m2() 이후 m2 메모리 삭제
// 4) main() => m1()
// 5) main() => m1() => m3() 이후 m3 메모리 삭제
// 6) main() => m1() 이후 m1 메모리 삭제
// 7) main() 값 출력 후 메인 메소드의 메모리도 삭제
// 8) 종료! -> 실행 이 후 OS로 부터 할당받은 메모리를 다시 반납함