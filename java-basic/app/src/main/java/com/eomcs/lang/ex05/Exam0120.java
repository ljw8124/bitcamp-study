package com.eomcs.lang.ex05;

//# 산술 연산자 : 우선 순위 
//
public class Exam0120 {
  public static void main(String[] args) {
    // *, /, % 는 +, - 보다 먼저 계산된다. -> 일반 산수와 같음
    System.out.println(2 + 3 * 7); // 3 * 7을 먼저 수행한다.
    System.out.println(3 * 7 + 2); // 3 * 7을 먼저 수행한다.

    // 같은 우선순위에서는 먼저 나온 것을 먼저 계산한다.
    System.out.println(3 * 8 / 2); // 3 * 8을 먼저 계산
    System.out.println(8 / 2 * 3); // 8 / 2를 먼저 계산 
    // 같은 우선순위의 연산자는 실행 순서가 바뀌더라도 상관없다.

    // 강제로 실행 순서를 바꾸고 싶다면 
    // 괄호()를 묶어라! -> 일반 산수처럼 식을 만들면 됨, 괄호도 연산자로 취급
    System.out.println((2 + 3) * 7); // = 35
  }
}

/* 
# 연산자(operator) 우선 순위, 피연산자(operand)
괄호: ()
후위 연산자: a++, a-- -> 한번 실행한 후 뒤에 +1 된다
전위 연산자: ++a, --a, 단항 연산자(+, -) / 3항 연산자도 존재한다
*, /, %
+, -
비트이동 연산자: <<, >>, >>>
관계 연산자: <, >, <=, >=, instanceof
등위 연산자: ==(같다), !=(다르다)
&
^
|
논리 연산자 AND: &&
논리 연산자 OR: ||
삼항 연산자: (조건) ? 값 : 값 => 조건이 참(true)이라면 왼쪽 값 출력, 거짓(false)이라면 오른쪽 값 출력
할당 연산자: =, +=, -=, *=, /=, %=, &=, ^=, |=, <<=, >>=, >>>=
 */