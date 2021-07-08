package com.joung.dbtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Board {
  Connection CN = null;
  Statement ST = null;
  ResultSet RS = null;
  String msg = "isud = crud 쿼리문 기술";
  int Gtotal = 0; // 전체 개수와 조회 개수 비교
  Scanner keyScan = new Scanner(System.in);

  public static void main(String[] args) {
    // 1번째 오라클드라이버 로드하는 명령어 Class.forName(" ")
    // 2번째 DB 서버 접근 계정명,pwd    127.0.0.1:152:XE  system/1234
    // 3번째 명령어생성은 2번째 서버정보를 참조해서 명령어 생성  Statement ST = 

  }

  public void dbConnect() {
    try {
      Class.forName("oracle.jdbc.driver.OracleDriver");
      String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
      CN = DriverManager.getConnection(url, "system", "1234"); 
      ST =  CN.createStatement(); // 첫번째. 명령어 생성
    } catch(Exception ex) { }
  }

  public void dbInsert() {
    try {

    } catch(Exception ex) { }
  }

  public void dbSelectAll() {
    try {
      ST = CN.createStatement();
      msg = "select * from test";
      ResultSet rs = ST.executeQuery(msg);
      while (rs.next() == true) {
        int a = rs.getInt("code");
        String b = rs.getString("name");
        String c = rs.getString("title");
        System.out.println(a + "\t" + b + "\t" + c);
      }

    } catch(Exception ex) { }
  }

  public void dbDelete() {
    try {
      System.out.print("삭제할 코드 입력>>> ");
      String del = keyScan.nextLine();
      msg = "delete from test where code = " + "'" + del + "'";
      System.out.println(msg);
      int OK = ST.executeUpdate(msg);
      if (OK > 0) {
        System.out.printf("%s 데이터 삭제 성공\n", del);
      } else { System.out.printf("%s 데이터 삭제 실패\n",del);
      }

    } catch(Exception ex) { }
  }

}
