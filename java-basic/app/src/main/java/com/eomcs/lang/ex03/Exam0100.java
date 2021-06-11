package com.eomcs.lang.ex03;
public class Exam0100 {
    public static void main (String[] arg) {
        System.out.println("------정수리터럴");
        System.out.println(78); //10진수
        System.out.println(+78); //10진수
        System.out.println(-78); //10진수
        System.out.println(0116); //8진수 -> 숫자앞에 0이 먼저나옴 (잘쓰지않음)
        System.out.println(0x4e); //16진수 -> 숫자앞에 0x가 먼저나옴 (사용하긴함)
        System.out.println(0b01001110); //2진수-> 숫자앞에 0b가 먼저나옴 (개념으로 사용할때가 많음), 2진수로 변환가능하다면 모두 저장 가능

        System.out.println("------부동소수점 리터럴"); // -> IEEE 754 사용하여 2진수로 저장
        System.out.println(3.14);
        System.out.println(31.4e-1);

        System.out.println("------논리 리터럴"); //참거짓
        System.out.println(true);
        System.out.println(false);

        System.out.println("------문자 리터럴"); // -> charater set을 이용하여 2진수로 변환 ex)EUC-KR, 조합형, MS-949, utf-8 ...
        System.out.println('가'); //한 글자는 ''로 표현

        System.out.println("------문자열 리터럴");
        System.out.println("오호라 코딩스쿨"); // 문자열은 ""로 표현
    }
}

/*
리터럴은 어떤 데이터(값)을 표현하는 방법이다
-> 정수 표현 ex)100(약-21억 ~ +21억 사이의 값), 100l, 100L 이중 100L로 표현하는것이 좋음 이때는 약 -900경 ~ 900경 까지 사이의 값
-> 부동소수점 표현 ex)3.14(약 15자리정도 표현), 3.14f, 3.14F 이때는 3.14f를 많이 사용한다 이때는 약 7자리로 소수점 표현
-> 문자 표현(한개의 문자) ex 'A', '가'
-> 논리 값 표현 ex) true, false 이 때 다 소문자로 적어야 한다
-> null (주소 없음)
*/
