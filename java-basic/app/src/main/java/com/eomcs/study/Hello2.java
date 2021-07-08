package com.eomcs.study;

public class Hello2 {
  public static void main(String[] args) {
    Tv t = new Tv();
    t.channel = 7;
    t.channelDown();
    System.out.printf("현재 채널은 %d 입니다.\n",t.channel);
  }
}

class Tv {
  String color; // 색상
  boolean power; // 전원상태(on/off)
  int channel; // 채널

  void power() {power = !power;}
  void channelUp() {++channel;}
  void channelDown() {--channel;}
}

