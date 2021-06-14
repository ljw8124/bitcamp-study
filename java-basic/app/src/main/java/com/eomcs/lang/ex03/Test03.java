package com.eomcs.lang.ex03;

public class Test03 {
    public static void main (String[] arg) {
        System.out.println(2.127f); //4바이트 메모리에 저장
        System.out.println(1.1f + 1.027f);
        System.out.println(2.0f + 0.127f);
        System.out.println(1.123f + 1.004f);
        System.out.println((2.0f + 0.127f) == 2.127f);
        System.out.println((1.123f + 1.004f) == 2.127f);
    }
}