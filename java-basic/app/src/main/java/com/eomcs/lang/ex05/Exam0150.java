package com.eomcs.lang.ex05;

//# 산술 연산자 : 암시적 형변환(implicit type conversion) -> 명령하지 않아도 자동으로 형변환 하는 것
//
public class Exam0150 {
  public static void main(String[] args) {
    byte b = 1;
    short s = 2;
    int i = 3;
    long l = 4;
    float f = 5.5f;
    double d = 6.6;
    boolean bool = true;
    char c = 7;

    // byte + byte = int
    // => 연산을 하기 전에 byte 값이 int로 암시적 형변환 된다.
    //byte r1 = b + b; // 컴파일 오류! -> 연산하면서 int로 변환하기 때문에 그릇이 더 작은 byte는 int를 담을 수 없다

    // short + short = int
    // => 연산을 하기 전에 short 값이 int로 암시적 형변환 된다.
    //short r2 = s + s; // 컴파일 오류!

    // byte + short = int
    // => byte와 short 값은 int로 암시적 형변환 된다.
    //short r3 = b + s; // 컴파일 오류!

    // byte + int = int
    // => byte가 (int 메모리에 임시 저장되어) int로 암시적 형변환 한 이후 연산을 수행한다.
    int r4 = b + i; // OK

    // short + int = int
    // => short가 int로 암시적 형변환 한 이후 연산을 수행한다.
    int r5 = s + i; // OK

    // int + long = long -> long이 8byte 이므로 결과 값도 long으로 변환
    // => int가 long으로 암시적 형변환 한 이후에 연산을 수행한다. -> int를 long의 임시메모리에 저장
    //int r6 = i + l; // 컴파일 오류! -> int가 그릇이 더 작기 때문에 더 큰 long을 담으려면 int가 아닌 long으로 변경해야 한다

    // long + float = float / 정수와 부동소수점을 연산하면 무조건 부동소수점 메모리로 변환된다 byte의 크기와 상관없이.
    // => long이 float으로 암시적 형변환 한 후에 연산을 수행한다.
    //long r7 = l + f; // 컴파일 오류! -> 정수와 부동소수점 중에서는 부동소수점이 더 그릇이 크므로 long을 float에 넣지 못한다
    // -> 8byte 메모리가 4byte 메모리에 들어가면서 데이터 소실이 발생할 수 있음. 따라서 주의해야 함

    // int + float = float
    // => 정수 타입의 값과 부동소수점 타입의 값을 연산하면
    //    정수 타입의 값이 암시적 형변환을 통해 부동소수점으로 바뀐다.
    //int r8 = i + f; // 컴파일 오류! -> 마찬가지 부동소수점이 정수보다 우선시된다

    // float + double = double
    //float r9 = f + d; // 컴파일 오류! -> float이 double보다 그릇이 작기 때문에 double로 강제형변환이 필요하다

    // byte + short + int + long + float + double = double // float보다는 double이 유효자리수가 더 큼
    //long r10 = b + s + i + l + f + d; // 컴파일 오류!

    // float + int + long = float
    //long r11 = f + i + l; // 컴파일 오류!

    // boolean + int = 컴파일 오류! / boolean 타입은 불가! 논리 연산자는 산술 하지 못함
    // => 산술 연산자는 정수 타입(byte, short, char, int, long)과
    //    부동소수점 타입(float, double)에 대해서만 
    //    실행할 수 있다. -> 논리 연산자는 불가
    //int r12 = bool + i; // 컴파일 오류!

    int r13 = c + i; // char와 int 는 연산 가능
    // System.out.println(r13);
  }
}

// 정리!
// - 연산은 항상 같은 타입끼리만 가능하다.
// - 다른 타입끼리 연산을 할 때는 둘 중 한개의 타입을 다른 타입을 
//   바꿔야 한다.
// - 타입을 바꾸는 것을 내부적인 규칙에 따라 자동으로 처리한다고 해서
//   "암시적 형변환(implicit type conversion)"이라 부른다.
// - 암시적 형변환 규칙
//   다음과 같이 오른쪽 타입의 값으로 자동 변환시킨다.
//   byte,short,char => int(defalut값) => long => float => double
//
// - 정수와 부동소수점에 대해서만 암시적 형변환이 일어난다.
//   그 외 다른 타입은 불가능하다!