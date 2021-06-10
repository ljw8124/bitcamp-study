package com.eomcs.lang.ex03;
public class Exam0100 {
    public static void main (String[] arg) {
        System.out.println("------정수리터럴");
        System.out.println(78); //10진수
        System.out.println(+78); //10진수
        System.out.println(-78); //10진수
        System.out.println(0116); //8진수
        System.out.println(0x4e); //16진수
        System.out.println(0b01001110); //2진수

        System.out.println("------부동소수점 리터럴");
        System.out.println(3.14);
        System.out.println(31.4e-1);

        System.out.println("------논리 리터럴"); //참거짓
        System.out.println(true);
        System.out.println(false);

        System.out.println("------문자 리터럴");
        System.out.println('가'); //한 글자는 ''로 표현

        System.out.println("------문자열 리터럴");
        System.out.println("오호라 코딩스쿨"); // 문자열은 ""로 표현
    }
}