package com.eomcs.lang.ex03;
public class Exam0210 {
    public static void main (String[] args) {
        //10진수 표현법
        System.out.println(100);

        //8진수 표현법 -> 잘쓰지는 않음
        //0으로 시작
        System.out.println(0114);

        //2진수 표현법 0b 또는 0B로 시작함
        //메모리의 상태를 직설적으로 보여주고 싶을 때 사용
        System.out.println(0b1100100);
        System.out.println(0B1100100);

        //숫자 앞에 0이 있어도 됨
        System.out.println(0b01100100);
        System.out.println(0B01100100);

        //16진수 리터럴
        //2진수를 간결하게 표현하기 위해 사용
        //0x 또는 0X 로 시작
        System.out.println(0x64);
        System.out.println(0X64);

        //숫자앞에 0이 있어도 됨
        System.out.println(0x064);
        System.out.println(0X064);
    }
}
