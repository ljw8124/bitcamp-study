package com.eomcs;

public class ArrayList2 { // 데이터 목록 관리

  static final int MAX_LENGTH = 100;
  static Object[] list = new Object[MAX_LENGTH];
  static int size = 0;

  static void append(Object obj) {
    list[size++] = obj;
  }

  static Object[] toArray() {
    Object[] arr = new Object[size];
    for (int i = 0; i < size; i++) {
      arr[i] = list[i];
    }
    return arr; // return list; 해버리면 값이 채워지지 않은 배열까지 모두 return됨
  }

  static Object retrieve(int index) {
    return list[index];
  }

  static void remove(int index) {
    for (int i = index; i < size - 1; i++) {
      list[i] = list[i + 1];
    }
    size--;
  }

}
