package com.joung.project;

import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

public class MemberHandler extends DB {

  String msg="";
  static String id = null;
  static String password = null;
  Scanner sc = new Scanner(System.in);

  public void selectAll() {
    DBbase();
    try {
      msg = "select * from id";
      RS = ST.executeQuery(msg);
      //      System.out.println(msg);

      // 자바의 정석 39p 참고
      System.out.printf("%10s %4s %20s %20s %18s %15s %10s %10s%n"
          , "ID", "등급", "이름", "이메일주소","핸드폰번호","가입날짜","좋아요","소속클래스");
      System.out.println();
      while(RS.next() == true) {
        String id = RS.getString("id");
        int grade = RS.getInt("grade");
        String name = RS.getString("name");
        String email = RS.getString("email");
        String mobile = RS.getString("mobile");
        Date date  = RS.getDate("join_date");
        int recommended = RS.getInt("recommended");
        String belongs = RS.getString("belongs");
        //System.out.printf(id + "\t" + grade +  "\t" + name+ "\t" + email+ "\t" + mobile+ "\t" + date+ "\t" + recommended+ "\t" + belongs);
        System.out.printf("%10s %4s %20s %30s %20s %20s %10s %15s%n"
            , id, grade, name, email, mobile, date, recommended, belongs);
      }
    } catch (Exception e) {
      System.out.println("에러이유" + e);
    }    
    System.out.println();
  }

  public void login() throws SQLException {
    DBbase();
    System.out.print("id입력: ");
    id = sc.nextLine();
    System.out.print("password입력: ");
    password =sc.nextLine();

    String crt = "select count(id) as cnt from id where id = '" + id + "' and pwd = '" + password + "'";
    //id와 pwd입력값이 데이터베이스와 일치하면 id의 갯수를 카운트한다. 변수 crt에 저장
    RS = ST.executeQuery(crt);
    //쿼리에 변수 crt를 입력
    if (RS.next() == true) {
      int cnt = RS.getInt("cnt");
      // 임시로 설정된 cnt필드의 값을 int cnt에 저장한다.
      // 값이 일치하는 경우 : 1
      // 값이 일치하지 않는 경우 : 0
      if (cnt > 0) { // id,pw 일치하는경우
        String grd = "select grade from id where id = '" + id + "'" ;//입력값 id가 포함된 쿼리문을 변수grd에 입력
        RS = ST.executeQuery(grd);
        //변수 grd를 데이터베이스 변수 RS에 입력한다.
        while(RS.next() == true) {
          int grade = RS.getInt("grade");// id필드 데이터에에 종속되어 있는 grade필드 데이터를 int변수로 저장 
          System.out.println(id + "님의 회원 등급은 " + grade + "번 입니다.");

          switch (grade) {
            case 4:
              System.out.println(grade + "게시글 삭제가능");
            case 3:
              System.out.println(grade + "게시글 수정가능");
            case 2:
              System.out.println(grade + "게시글 추가가능");
            case 1:
              System.out.println(grade + "게시글 조회가능");
            default:
              break;
          }
        }
      } else { // id, pw 일치하지 않는 경우
        System.out.println("비밀번호가 맞지 않습니다.");
      }
    }
    System.out.println();
  }

  public void insertMember() {
    DBbase();
    try {
      //첫 번째 명령어 생성 
      ST = CN.createStatement();

      //키보드에서 데이터 입력
      System.out.print("\nID입력 : ");
      String id = sc.nextLine();
      // System.out.print("grade : "); // grade default 1
      // int grade = Integer.parseInt(sc.nextLine());
      System.out.print("비밀번호입력 : ");
      String password = sc.nextLine();
      System.out.print("이름입력 : ");
      String name = sc.nextLine();
      System.out.print("email입력 : ");
      String email = sc.nextLine();
      System.out.print("mobile입력 : ");
      String mobile = sc.nextLine();
      System.out.print("소속입력 : ");
      String belongs = sc.nextLine();

      msg = "insert into id(id,pwd,name,email,mobile,join_date,belongs)"
          + "values(?, ?, ?, ?, ?, sysdate, ?)";
      PST = CN.prepareStatement(msg);
      PST.setString(1, id);
      PST.setString(2, password);
      PST.setString(3, name);
      PST.setString(4, email);
      PST.setString(5, mobile);
      PST.setString(6, belongs);

      System.out.println(msg);

      int OK = PST.executeUpdate();
      if (OK>0) {
        System.out.println(id + "회원가입 성공했습니다.");
      } else {System.out.println(id + "회원가입 실패했습니다.");}
    }catch (Exception e) { } 
    System.out.println();
  }

  public void deleteMember() {
    DBbase();
    try {
      System.out.print("\n삭제할 ID 입력 : ");
      String id = sc.nextLine();
      System.out.print("\npassword 입력 : ");
      String password = sc.nextLine();
      System.out.print("정말 탈퇴하시겠습니까 ? [y / N]");

      if(!sc.nextLine().equals("y")) {
        System.out.println("회원 탈퇴 취소하셨습니다.");
      } else {
        msg = "delete from id where id = ? and pwd = ?" ;
        PST = CN.prepareStatement(msg);
        PST.setString(1, id);
        PST.setString(2, password);

        int aa = PST.executeUpdate();
        if (aa > 0) {
          System.out.println(id + " 회원탈퇴 성공했습니다.");
        } else {
          System.out.println("회원정보 다시 입력부탁드립니다.");
        }//내부 else end

      }//y/N탈퇴 end
    } catch (Exception e) {
      System.out.println("에러이유" + e);
    }
    System.out.println();
  }//delete end

  //  void Logout() throws SQLException {
  //  System.out.println("정말로 로그아웃 하시겠습니까?(y/N");
  // if (!sc.nextLine().equals("y")) {
  //    System.out.println("취소하였습니다.");      
  //  } else {
  //   if (id == null && password == null) {
  //    System.out.println("로그인이 되어있지 않습니다.");
  //  } else {
  //   id = null;
  //   password = null;
  //   System.out.println("로그아웃 되었습니다.");
  //  }
  // }
  //}

  public void Logout() throws SQLException {
    System.out.println("정말로 로그아웃 하시겠습니까 ? [ y/ N ]");
    if(sc.nextLine().equals("y")) {
      if(id == null && password == null) {
        System.out.println("로그인 되어있지 않습니다.");
      }else { 
        id = null;
        password = null;
        System.out.println("로그아웃되었습니다.");
      }
    }else {
      System.out.println("로그아웃 취소되었습니다.");
    }
    System.out.println();
  }



}
