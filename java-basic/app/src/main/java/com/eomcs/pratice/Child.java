package com.eomcs.pratice;

// 상속의 경우 다중 상속은 불가능함 => 하려면 상속받으려는 대상에 상속을 시켜야 함 
// 상속에 final이 있으면 상속 불가
public class Child extends Father {

  //super.car();

  public static void main(String[] args) {
    // 모든 클래스 최상위 Object클래스 상속받았음
    Child cd = new Child();
    cd.book();

    int a = cd.bank();
  }

  public void book() {
    int m = bank();
    super.car();
    this.car();
  }

  @Override
  public void car() {
    System.out.println("Child 자식클래스 car메소드");
  }

}

