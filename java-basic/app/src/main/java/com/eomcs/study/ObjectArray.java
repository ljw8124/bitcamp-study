package com.eomcs.study;

public class ObjectArray {
  public static void main(String[] args) {
    Tv[] tvArr = new Tv[3];

    for(int i = 0; i < tvArr.length; i++) {
      tvArr[i] = new Tv();
      tvArr[i].channel = i + 10;
    }

    for(int i = 0; i < tvArr.length; i++) {
      tvArr[i].channelUp();
      System.out.printf("tvArr[%d],channel = %d\n",i, tvArr[i].channel);
    }

  }

}
// 변수는 하나의 데이터만을 저장
// 배열은 같은 종류의 데이터를 저장
// 구조체는 관계없는 종료의 데이터 하나에 저장 가능

/*
 public static void main(String[] args) {
    Tv t1 = new Tv();
    Tv t2 = new Tv();
    Tv t3 = new Tv();

    // 참조변수의 배열 = 객체배열
    Tv[] tvArr = new Tv[3];
    tvArr[0] = new Tv();
    tvArr[1] = new Tv();
    tvArr[2] = new Tv();
    }
    // 위에 처럼 따로 만들어주어야 한다
 */