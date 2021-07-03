package com.eomcs.day0702;

public class A01 {

  public static void main(String[] args) {
    String name = args[0];
    int price = Integer.parseInt(args[1]);
    System.out.printf("%s 님이 만든 도시락은 %d 원입니다\n", name, price);

  }

}
