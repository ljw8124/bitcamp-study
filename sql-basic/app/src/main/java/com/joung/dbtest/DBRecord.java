package com.joung.dbtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class DBRecord {
  public static void main(String[] args) {
    Connection CN = null; //DB서버연결정보 서버ip주소 계정id,pwd
    Statement ST = null;  //ST=CN.createStatement()명령어생성 삭제,신규등록,조회하라
    ResultSet RS = null;  //select조회결과값 전체데이터를 기억합니다
    String msg = "isud=crud쿼리문기술";
    int Gtotal = 0;  
    Scanner sc = new Scanner(System.in);

    try {
      Class.forName("oracle.jdbc.driver.OracleDriver"); //오라클드라이브로드
      String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE" ;
      CN = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","system","1234");
      //System.out.println("오라클 드라이브및 서버연결성공 ");

      //첫번째명령어생성
      ST = CN.createStatement();
      /////////////////////////////////////////////////////////////////
      msg = "select count(*) as hit from test ";
      RS = ST.executeQuery(msg);
      if( RS.next()==true) { Gtotal = RS.getInt("hit"); }
      /////////////////////////////////////////////////////////////////

      System.out.println("프로그램 전체데이터 읽어오는중입니다");
      Thread.sleep(1000);
      msg = "select * from  test " ; //문자열을 명령어 인식해서 실행하도록 Statement
      RS = ST.executeQuery(msg);

      System.out.println("------------- 데이터 출력 ----------------");
      System.out.println("\t\t\t    전체레코드갯수:" + Gtotal);
      System.out.println("코 드\t이 름\t제 목\t날 짜\t   조회수");
      while (RS.next() == true) {
        //필드접근해서 데이터가져올때 getXXX()
        int ucode = RS.getInt("code");
        String uname = RS.getString("name");
        java.util.Date udt = RS.getDate("wdate");
        String utitle = RS.getString("title");
        int ucnt = RS.getInt("cnt");
        System.out.println(ucode +"\t" + uname+"\t" + utitle+"\t" + udt+"\t" + ucnt);
      }
    }catch (Exception ex) { System.out.println("에러이유 " + ex);}  
    sc.close();
  }//main end

  //신규등록,전체출력성공후 메소드생성해서 최대한 메소드활용    
  //본인작성한 코드는 복사후 붙여넣기 주석처리 

}//class END
