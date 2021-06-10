package com.eomcs.lang.ex03;
public class Exam0220 {
    public static void main (String[] args) {
        //모든 숫자 맨 앞,맨 뒤에 문자 삽입 불가능

        //10진수
        System.out.println(1234567);
        System.out.println(1234_567);
        System.out.println(12_345_67);

        //8진수
        System.out.println(077);
        System.out.println(0_77);
        System.out.println(07_7);

        //2진수
        System.out.println(0b1100100);
        System.out.println(0b110_0100);
        System.out.println(0b1_1_0_0_1_0_0);

        //16진수
        System.out.println(0xffaa);
        System.out.println(0xff_aa);
    }
}