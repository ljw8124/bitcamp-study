package com.eomcs.lang.ex04;

public class Test01 {
  public static void main(String[] args) {
    char c; //char는 Unicode 문자 코드(0 ~ 65536)를 저장하는 변수

    c = 0x0041; //A 문자에 해당하는 Unicode를 16진수로 표현하여 저장한다.
    System.out.println(c); //c변수에 저장된 문자 코드를 println()에 전달하면 해당 문자 코드의 값을 출력함

    c = 0x41; // 숫자앞에 00은 생략가능함
    System.out.println(c); 

    c = 65; // A 문자의 유니코드를 10진수로 표현해도 된다.
    System.out.println(c);

    c = '헐'; //한글 '헐'의 유니코드 값(0xD5D0)을 c 변수에 저장한 후 출력한다 -> 유니코드를 다 알 수 없으므로 도구를 제공한다 (operator)
    //도구가 그 문자의 유니코드 값을 알아내서 자기가 넣음
    System.out.println(c);
    
     c = 0xd5d0; //한글 '헐'의 유니코드 값(0xD5D0)을 c 변수에 저장한 후 출력한다
    System.out.println(c);
   }
}
