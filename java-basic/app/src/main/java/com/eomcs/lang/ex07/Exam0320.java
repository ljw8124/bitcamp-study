package com.eomcs.lang.ex07;

//# 메서드 : call by reference 주소를 메서드 파라미터에 저장
//
public class Exam0320 {

  static void swap(int[] arr) {
    System.out.printf("swap(): arr[0]=%d, arr[1]=%d\n", arr[0], arr[1]);
    int temp = arr[0];
    arr[0] = arr[1]; // 주소 찾아가서 변경하는 것이므로 main의 배열도 변경 
    arr[1] = temp; // 주소 찾아가서 변경하는 것이므로 main의 배열도 변경
    System.out.printf("swap(): arr[0]=%d, arr[1]=%d\n", arr[0], arr[1]);
  }

  public static void main(String[] args) {
    int[] arr = new int[] {100, 200};
    swap(arr); // 배열 인스턴스(메모리)를 넘기는 것이 아니다. 
    // 주소를 넘기는 것이다.
    // 그래서 "call by reference" 라 부른다.
    System.out.printf("main(): arr[0]=%d, arr[1]=%d\n", arr[0], arr[1]);
  }
}
// Heap 은 JVM 메모리 영역에서 새로운 명령으로 만드는 변수를 두는 영역이다
// = 인스턴스라고 부름
// new를 붙이는 인스턴스는 오직 Heap에만 생성된다
// JVM Stack은 메서드를 호출할 때 마다 로컬 변수를 생성한다
// => 메서드 호출이 끝나면 그 메소드의 로컬 변수가 제거된다