package com.eomcs.lang.ex07;

// # JVM 아규먼트 응용 II
//
public class Exam0630 {

  public static void main(String[] 변수명은상관없다) {
    // JVM에 기본으로 설정되어 있는 프로퍼티를 모두 출력하라!
    //
    // JVM의 전체 프로퍼티 목록 가져오기
    java.util.Properties props = System.getProperties();

    java.util.Set keySet = props.keySet();

    for (Object key : keySet) { // Object는 모든 걸 다 담을 수 있음(string,int ...등)
      String value = System.getProperty((String) key); // 그래서 여기서 string이란걸 알려줌
      System.out.printf("%s = %s\n", key, value);
    }
  }
}


