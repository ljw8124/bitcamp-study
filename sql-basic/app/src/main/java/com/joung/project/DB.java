package com.joung.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DB {

  Connection CN = null; //DB서버연결정보 서버ip주소 계정id,pwd
  Statement ST = null;  //ST=CN.createStatement()명령어생성 삭제,신규등록,조회하라
  ResultSet RS = null;  //select조회결과값 전체데이터를 기억합니다
  PreparedStatement PST = null; //좀 더 용이하게 자바변수 sql문에 넣는 방법, 미리 컴파일 되있음

  String msg = "";  

  public void DBbase() {

    try {
      Class.forName("oracle.jdbc.driver.OracleDriver"); 
      CN = DriverManager.getConnection("jdbc:oracle:thin:@61.72.146.172:8810:xe","system","oracle");
      ST = CN.createStatement(); 
    } catch(Exception e) {
      System.out.println("error =" + e);
    }

  }//end
}
