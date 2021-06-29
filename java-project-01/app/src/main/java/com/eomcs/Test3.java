package com.eomcs;

class Calculator3 {
  int result; 

  //non-static 메서드 = 인스턴스 메서드
  // => 인스턴스 주소를 받는 "this" 변수가 내장되어 있다.
  // -> this는 내가 선언하지 않아도 자동으로 만들어진다.
  // => 따라서 개발자가 인스턴스 주소를 받는 변수를 파라미터로 선언할 필요가 없다.

  // this 는 reserved keyboard 라고 불림.(ex : class,int ...) 프로그래밍 세계에서 이미 확립된 언어

  void plus(/*Calculator3 this,*/ int value) { // result의 주소를 저장하기 위해 사용
    this.result += value; // 인스턴스 변수이므로 주소를 지정하여 접근하여야 함
    // this. 은 생략가능!!
  }
}

public class Test3 {

  public static void main(String[] args) {
    Calculator3 obj1 = new Calculator3 (); // class Calculator의 변수중 static 이 안붙은 변수를
    // Heap에 생성하라는 것(인스턴스)
    Calculator3 obj2 = new Calculator3();

    // 메서드를 호출할 때 앞에 준 인스턴스 주소는
    // 따라서 인스턴스 메서드를 호출 할 때는 반드시 앞에 인스턴스 주소를 제공해야 한다.
    // 메서드에 내장된 this 라는 변수에 전달 된다.
    // => instance와 this의 관계
    obj1.plus(100); // (주소(장소), 값)
    obj1.plus(200);
    obj1.plus(300);

    obj2.plus(111);
    obj2.plus(222);

    System.out.println(obj1.result);
    System.out.println(obj2.result);

  }

}
