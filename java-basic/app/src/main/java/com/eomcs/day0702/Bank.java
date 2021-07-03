package com.eomcs.day0702;

public class Bank {

  private int pwd = 1234; // private는 현재 클래스에서만 사용가능
  public Bank() { }

  public void cal() {
    System.out.println(pwd);
  }
  public void cal(int m) {}
  public void cal(String name, int m) { }

}

