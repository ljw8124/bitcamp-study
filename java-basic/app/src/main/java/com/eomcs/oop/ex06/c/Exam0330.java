// 오버라이딩(overriding) - 오버라이딩할 때 접근 범위 조정하기 II
package com.eomcs.oop.ex06.c;

public class Exam0330 {
  static class C {
    private void m1() {} // class C에서만 접근가능
    void m2() {} // 같은 클래스와 같은 패키지 내에서 접근가능
    protected void m3() {} // 같은 클래스와 패키지,서브 클래스에서 접근가능
    public void m4() {} // 모두 접근 가능
  }

  static class C4 extends C {

    // 오버라이딩 할 때(메서드를 재정의 할 때)
    // => 원본 보다 접근 범위를 좁힐 수는 없다.
    //
    //  @Override private void m2() {} // (default) ==> private : 컴파일 오류!
    //  @Override void m3() {} // protected ==> (default) : 컴파일 오류!
    //  @Override protected void m4() {} // public ==> protected : 컴파일 오류!

    // 결론!
    // 수퍼 클래스의 메서드를 자식 클래스가 재정의할 때
    // 접근 범위를 확대할 순 있지만, 좁힐 수는 없다!

  }

  public static void main(String[] args) {
    // C, C2, C3, C4 클래스의 주석을 확인하라!
  }
}








