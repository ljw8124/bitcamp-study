package com.eomcs.study;

public class Ex {
  public static void main(String[] args) {
    Tv t1 = new Tv();
    Tv t2 = new Tv();
    System.out.printf("t1의 channel값은 %d 입니다.\n",t1.channel);
    System.out.printf("t2의 channel값은 %d 입니다.\n",t2.channel);

    t1.channel = 7;
    System.out.println("t1의 값을 7로 변경하였습니다.");

    t2 = t1;
    System.out.printf("t1의 channel값은 %d 입니다.\n",t1.channel);
    System.out.printf("t2의 channel값은 %d 입니다.\n",t2.channel);
  }
}