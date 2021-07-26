// 다형성 - 다형적 변수와 instanceof 연산자
package com.eomcs.oop.ex06.a;

public class Exam0510 {

  public static void main(String[] args) {
    Vehicle v = new Sedan();

    // instanceof 연산자?
    // => 레퍼런스에 들어있는 주소가 특정 클래스의 인스턴스인지 검사한다.
    // => 또는 그 하위 클래스의 인스턴스인지 검사한다.
    // => true로 나온다면 그 해당 타입으로 형변환 가능하다는 의미
    //
    System.out.println(v instanceof Sedan);
    System.out.println(v instanceof Car);
    System.out.println(v instanceof Vehicle);
    System.out.println(v instanceof Object);

    System.out.println(v instanceof Truck);
    System.out.println(v instanceof Bike);
    // 위 두가지는 false로 출력 -> v는 Truck과 Bike에 쓰지 못한다는 것을 의미한다.
  }

}
