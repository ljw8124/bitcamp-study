package com.eomcs.lang.ex04;

public class Test05 {
  public static void main(String[] args) {
    int[] a = new int[3];

    a[0] = 100;
    a[1] = 200;
    a[2] = 300;
    
// 밑에서 다시 배열을 했기 때문에 위에 것은 괜히 메모리만 차지하게 됨
// -> Garbage라고 부른다 -> JVM을 종료하면 JVM이 사용한 모든 메모리는 OS에 반납함
// 이때 Garbage가 사라짐. 또는 JVM이 실행되는 동안 메모리가 부족하게되면 Garbage를 찾아 제거한 후 그 메모리 공간을 사용함
// 수행하는 것은 'Garbage Collector' => Garbage를 제거하여 사용할 메모리 공간을 확보하는 역할
// 메모리가 부족하거나 cpu가 한가할 때 수행함
// => 메모리가 부족하지 않으면 JVM이 종료할 때 까지 Garbage Collector는 일을 하지 않는다

    a = new int[5];
    System.out.println(a[0]);

   }
}
