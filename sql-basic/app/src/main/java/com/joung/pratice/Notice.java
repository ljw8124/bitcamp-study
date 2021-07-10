package com.joung.pratice;

import java.util.Scanner;

public class Notice extends DB {

  String msg = "isud = crud 쿼리기술문";    
  int Gtotal = 0;  
  Scanner sc = new Scanner(System.in);

  public void select() {
    DBbase();
    try {
      msg = "select * from notice";
      RS = ST.executeQuery(msg);
      System.out.println(msg);

      //      System.out.println("            데이터 출력            ");
      //      System.out.println("\t\t\t\t전체 레코드 갯수:" + Gtotal);
      //      System.out.println("번호\t이름\t제목\t\t날 짜");
      while(RS.next() == true) {
        //
        int num = RS.getInt("번호");
        String name = RS.getString("이름");
        java.util.Date date = RS.getDate("날짜");
        String title = RS.getString("제목");
        System.out.println(num + "\t" + name + "\t" + title + "\t" + date);
      }
    }catch (Exception e) { System.out.println("에러이유" + e); }    
  }

  public void insert() {
    //    DBbase();
    try {
      //첫 번째 명령어 생성 
      ST = CN.createStatement();

      //키보드에서 데이터 입력
      System.out.print("\n번호입력 : ");
      int a = Integer.parseInt(sc.nextLine());
      System.out.print("이름입력 : ");
      String b = sc.nextLine();
      System.out.print("제목입력 : ");
      String c = sc.nextLine();
      //
      //     
      msg = "insert into notice (번호,이름,제목,날짜) values(" + a + ", '"+ b + "','" + c + "' ,sysdate)";
      //      msg="insert into notice(num,name,title,wdate) values("+a+", '"+b+"', '"+c+"' )";
      System.out.println(msg);
      int OK = ST.executeUpdate(msg);
      if (OK>0) {
        System.out.println(a + "게시글 저장성공했습니다.");
      } else {System.out.println(a + "게시글 저장실패했습니다.");}
    }catch (Exception e) { } 
  }
  public void update () {
    //    DBbase();
    try {
      //수정처리는 대상필드 name,title

      System.out.print("수정할 번호 입력  :");
      String code = sc.nextLine(); 
      System.out.print("이름 수정내역 입력  :");
      String name = sc.nextLine(); 
      System.out.print("제목 수정내역 입력  :");
      String title = sc.nextLine(); 
      //      msg = "update test set code = " + scode +  ", name = '" + name + "' ,title = '" + title + "' where code = " + code  ;
      msg = "update notice set 이름='"+name+"', 제목='"+title+"'  where 번호 = "+code;

      System.out.println(msg);


      int OK = ST.executeUpdate(msg);
      if (OK>0) {
        System.out.println(code + "번 게시글 수정 성공");
      }else {
        System.out.println(code + "번 게시글 수정 실패");
      }
      select();
    }catch(Exception ex) { }    
  }
  public void Delete() {
    //    DBbase();
    try {
      System.out.println("\n삭제할 게시글번호 입력 : ");
      int a = Integer.parseInt(sc.nextLine());

      msg = "delete from notice where 번호 = " + a ;
      System.out.println(msg);
      int aa = ST.executeUpdate(msg);

      if (aa>0) {
        System.out.println(a + "게시글 삭제");
      } else {System.out.println(a + "게시글 삭제실패했습니다.");}

    }catch (Exception e) {System.out.println("에러이유" + e);}
  }//delete end
}
