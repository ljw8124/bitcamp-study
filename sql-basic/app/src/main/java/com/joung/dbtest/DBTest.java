package com.joung.dbtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class DBTest {

  Connection CN = null; // DB서버연결정보
  Statement ST = null; // 명령어 생성

  ResultSet RS = null; // 조회결과를 기억, select 조회결과값 전체데이터를 기억

  PreparedStatement PST = null;

  String msg = "isud = crud 쿼리문 기술";
  int Gtotal = 0; // 전체 개수와 조회 개수 비교

  static Scanner keyScan = new Scanner(System.in);

  public static void main(String[] args) {
    DBTest DB = new DBTest();

    try {
      //기본셋팅 완료
      Class.forName("oracle.jdbc.driver.OracleDriver");
      String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
      DB.CN = DriverManager.getConnection(url, "system", "1234"); // 서버에 연결
      //  System.out.println("오라클 드라이버 및 서버 연결성공");

      DB.ST =  DB.CN.createStatement(); // 첫번째. 명령어 생성

      loop :while (true) {
        System.out.println("\t[ menu ]");
        System.out.println("1. connect code");
        System.out.println("2. select code");
        System.out.println("3. delete code");
        System.out.println("4. select code partially");
        System.out.println("5. update code");
        System.out.println("종료를 원한다면..quit");
        System.out.print("입력 : ");
        String input = keyScan.nextLine();
        switch (input) {
          case "1" : DB.dbConnect(); break;
          case "2" : DB.dbSelectAll(); break;
          case "3" : DB.dbDelete(); break;
          case "4" : DB.dbSelect(); break;
          case "5" : DB.dbUpdate(); break;
          case "quit" :
            System.out.println("입력을 종료합니다.");
            break loop;
          default : 
            System.out.println("잘못된 입력입니다.");
            System.out.println();
        }
      }

    } catch (Exception ex) {
      System.out.printf("에러이유 = %s\n",ex);
    }
    keyScan.close();
  }
  // 신규등록, 전체 출력 성공 후 메소드 생성해서 최대한 메소드 활용
  // order by code =>  code 순서대로 배열

  void dbConnect() { // 키보드에서 데이터 입력
    try {
      System.out.print("\ncode입력(ex.1100)>>> "); 
      int code = Integer.parseInt(keyScan.nextLine());

      System.out.print("이름입력>>> ");
      String name = keyScan.nextLine();
      System.out.print("내용입력>>> ");
      String content = keyScan.nextLine();

      //3번째. 쿼리문 완성
      msg = "insert into test(code, name, title, wdate, cnt) values(?, ?, ?, sysdate, 0)";
      PST = CN.prepareStatement(msg);
      PST.setInt(1, code);
      PST.setString(2, name);
      PST.setString(3, content);
      System.out.println(msg); // 출력안해도됨

      //4번째. 서버에서 실행 executeUpdate("insert ~~")
      int Condition = PST.executeUpdate(); // 한건출력, 다수출력, 전체출력 - select 별도
      if (Condition > 0) {
        System.out.printf("%d 코드 데이터 저장 성공했습니다.\n",code);
      } else {
        System.out.printf("%d 코드 데이터 저장 실패했습니다.\n",code);
      }

    } catch(Exception ex) {
      System.out.println("이미 존재하는 코드 번호 입니다.");
    }
    System.out.println();
  }

  void dbSelectAll() {
    try {
      System.out.println("포로그램 전체데이터를 읽어오는 중...");
      System.out.println();
      // Thread.sleep(3000);

      msg = "select * from test"; // 문자열을 명령어로 인식해서 실행하도록 Statement
      RS =  ST.executeQuery(msg);

      System.out.println("코드 \t 이름 \t 제목 \t 날짜 \t 조회수");
      while (RS.next() == true) {
        // 필드접근해서 데이터 가져올 때 getXXX()가 필요
        int ucode =  RS.getInt("code");
        String uname =  RS.getString("name");
        String ucontent =  RS.getString("title");
        java.util.Date udate = RS.getDate("wdate");
        int ucnt = RS.getInt("cnt");
        System.out.println(ucode + "\t" + uname + "\t" + ucontent + "\t" + udate + "\t" + ucnt);
      }
    } catch(Exception ex) {
      System.out.printf("에러이유 = %s\n",ex);
    }
    System.out.println();
  }

  void dbSelect () {
    try {
      System.out.print("보고자 하는 코드 입력>>> ");
      String view = keyScan.nextLine();
      msg = "select * from test where code = ?";
      PST = CN.prepareStatement(msg);
      PST.setString(1, view);
      RS = PST.executeQuery();

      System.out.println("코드\t이름\t제목\t날짜\t조회수");
      while (RS.next() == true) {
        // 필드접근해서 데이터 가져올 때 getXXX()가 필요
        int ucode =  RS.getInt("code");
        String uname =  RS.getString("name");
        String ucontent =  RS.getString("title");
        java.util.Date udate = RS.getDate("wdate");
        int ucnt = RS.getInt("cnt");
        System.out.println(ucode + "\t" + uname + "\t" + ucontent + "\t" + udate + "\t" + ucnt);
      }
    } catch(Exception ex) { }
    System.out.println();
  }

  void dbUpdate() {
    try {
      System.out.print("수정할 코드 입력>>> ");
      String update = keyScan.nextLine(); // next() 는 공백주면 인식x, nextLine()은 공백도 인식.
      System.out.print("수정 name 입력>>> ");
      String uName = keyScan.nextLine();
      System.out.print("수정 title 입력>>> ");
      String uTitle = keyScan.nextLine();

      msg = "update test set name  = ?, title = ?, wdate = sysdate where code = ?";
      PST = CN.prepareStatement(msg);
      PST.setString(1, uName);
      PST.setString(2, uTitle);
      PST.setString(3, update);

      System.out.println(msg);
      //ST = CN.createStatement();

      int condition = PST.executeUpdate(); // 진짜 수정하기 위한 코드
      if (condition > 0) {
        System.out.printf("%s 데이터 수정 성공\n", update);
        dbSelectAll();
      } else { System.out.printf("%s 데이터 수정 실패\n",update);
      }
    } catch(Exception ex) {System.out.println("잘못된 정보를 입력하였습니다.");}
  }

  void dbDelete() {
    try {
      System.out.print("삭제할 코드 입력>>> ");
      String del = keyScan.nextLine();
      msg = "delete from test where code = ?";
      PST = CN.prepareStatement(msg);
      PST.setString(1, del);

      System.out.println(msg);
      int condition = PST.executeUpdate();
      if (condition > 0) {
        System.out.printf("%s 데이터 삭제 성공\n", del);
      } else { System.out.printf("%s 데이터 삭제 실패\n",del);
      }

    } catch(Exception ex) { }
  }

}
