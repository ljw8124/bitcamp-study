package com.eomcs;

class Calculator2 {
  int result; 

  static void plus(Calculator2 ref, int value) { // result의 주소를 저장하기 위해 사용
    ref.result += value; // 인스턴스 변수이므로 주소를 지정하여 접근하여야 함
  }
}

public class Test2 {

  public static void main(String[] args) {
    Calculator2 obj1 = new Calculator2 (); // class Calculator의 변수중 static 이 안붙은 변수를
    // Heap에 생성하라는 것(인스턴스)
    Calculator2 obj2 = new Calculator2();

    Calculator2.plus(obj1, 100); // (주소(장소), 값)
    Calculator2.plus(obj1, 200);
    Calculator2.plus(obj1, 300);

    Calculator2.plus(obj2, 111);
    Calculator2.plus(obj2, 222);

    System.out.println(obj1.result);
    System.out.println(obj2.result);

  }

}
