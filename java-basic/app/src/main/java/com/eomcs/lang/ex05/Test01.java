package com.eomcs.lang.ex05;

public class Test01 {
  public static void main(String[] args) {
   
    int lang2 = 0;
    // 00000000 00000000 00000000 00000000으로 초기화

    // 32비트에서 뒤에 8비트를 사용하여 8개의 true/false 값을 저장할 수 있다.
    // 8 비트에서 각 언어에 값을 저장할 비트를 다음과 같다고 가정하자.
    // 00000000
    // ||||||||- css
    // |||||||- html
    // ||||||- php
    // |||||- python
    // ||||- javascript
    // |||- java
    // ||- c++
    // |- c
    //-> 밑에 값으로 설정

    //fianl은 상수값 설정으로 절대 변하지 않는다. 그러므로 아래 값처럼 고정값이 필요할때는 final을 사용하는 것이 좋음
    final int LANG_C      = 0b1000_0000; // 0x80
    final int LANG_CPP    = 0b0100_0000; // 0x40
    final int LANG_JAVA   = 0b0010_0000; // 0x20
    final int LANG_JS     = 0b0001_0000; // 0x10
    final int LANG_PYTHON = 0b0000_1000; // 0x08
    final int LANG_PHP    = 0b0000_0100; // 0x04
    final int LANG_HTML   = 0b0000_0010; // 0x02
    final int LANG_CSS    = 0b0000_0001; // 0x01

    // lang2 |= LANG_C; // c = true
    // lang2 |= LANG_JAVA; // java = true
    // lang2 |= LANG_PYTHON; // python = true
    // lang2 |= LANG_HTML; // html = true
   
    // System.out.println(Integer.toBinaryString(lang2)); //2진수로 출력하라는 의미

    lang2 = LANG_C | LANG_JAVA | LANG_PYTHON | LANG_HTML; //간결표현

    lang2 = lang2 - LANG_JAVA; // 자바제외
   
    System.out.println(Integer.toBinaryString(lang2)); //2진수로 출력하라는 의미
  }
}
