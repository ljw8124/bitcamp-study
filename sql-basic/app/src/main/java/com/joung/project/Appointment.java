package com.joung.project;

import java.util.Date;
import java.util.Scanner;

public class Appointment extends MemberHandler{ // 스터디 약속
  static Scanner keyScan = new Scanner(System.in);

  public void viewAppointment() {
    DBbase();
    try { 
      msg = "select * from appointment";

      RS = ST.executeQuery(msg);
      //      System.out.println(msg);

      // 자바의 정석 39p 참고
      System.out.printf("%5s %10s %10s %10s %10s %10s %4s %4s%n"
          , "번호", "제목", "장소", "시간","날짜", "ID","정원", "조회수");
      System.out.println();
      while(RS.next() == true) {
        int num = RS.getInt("num");
        String title = RS.getString("title");
        String location = RS.getString("location");
        String time = RS.getString("time");
        Date date  = RS.getDate("written");
        String id = RS.getString("id");
        int numLimit = RS.getInt("numlimit");
        int viewCount = RS.getInt("viewcount");
        //System.out.printf(id + "\t" + grade +  "\t" + name+ "\t" + email+ "\t" + mobile+ "\t" + date+ "\t" + recommended+ "\t" + belongs);
        System.out.printf("%5s %10s %10s %10s %10s %10s %4s %4s%n"
            , num, title, location, time, date, id, numLimit, viewCount);
      }
    } catch(Exception ex) {
      System.out.println("잘못 입력입니다.");
    }
    System.out.println();
  }

  public void insertAppointment() {
    System.out.println("스터디원 모집 게시판");
    DBbase();
    try {
      ST = CN.createStatement();
      System.out.print("\n제목 : ");
      String title = keyScan.nextLine();
      System.out.print("장소 : ");
      String location = keyScan.nextLine();
      System.out.print("시간 : ");
      String time = keyScan.nextLine();
      System.out.print("정원 : ");
      int numLimit = Integer.parseInt(keyScan.nextLine());
      msg = "insert into appointment(num, title, location, time, written, id, numlimit, viewcount) "
          + "values(seq.nextval, ?, ?, ?, sysdate, '" + id  + "',? ,0)";
      PST = CN.prepareStatement(msg);
      PST.setString(1, title);
      PST.setString(2, location);
      PST.setString(3, time);
      PST.setInt(4, numLimit);

      int condition = PST.executeUpdate();
      if (condition > 0) {
        System.out.println(title + " 게시글이 등록되었습니다.");
      } else {
        System.out.println(title + " 게시글 등록이 실패했습니다.");
      }
    } catch (Exception e) {
      System.out.println("잘못된 입력입니다.");
    }
    System.out.println();
  }
  public void deleteAppoinment() {
    DBbase();
    //    NUM                                       NOT NULL NUMBER
    //    TITLE                                     NOT NULL VARCHAR2(10)
    //    LOCATION                                  NOT NULL VARCHAR2(10)
    //    TIME                                      NOT NULL VARCHAR2(8)
    //    REPLY                                              VARCHAR2(10)
    //    WRITTEN                                   NOT NULL DATE
    //    ID                                        NOT NULL VARCHAR2(10)
    //    NUMLIMIT                                           NUMBER
    //    VIEWCOUNT                                          NUMBER
    try {
      System.out.print("\n삭제할 게시글 번호 입력 : ");
      int num = Integer.parseInt(keyScan.nextLine());
      System.out.print("삭제할 게시글 제목 입력 : ");
      String title = keyScan.nextLine();

      if(!keyScan.nextLine().equals("y")) {
        System.out.println("회원 탈퇴 취소하셨습니다.");
      } else {
        msg = "delete from appointment where num = ? and title = ?" ;
        PST = CN.prepareStatement(msg);
        PST.setInt(1, num);
        PST.setString(2, title);

        int condition = PST.executeUpdate();
        if (condition > 0) {
          System.out.println(num + "번 게시글 '" + title +"' 삭제 성공했습니다.");
        } else {
          System.out.println(num + "번 게시글 '" + title +"' 삭제 실패했습니다.");
        }//내부 else end

      }//delete y/N end
    } catch (Exception e) {
      System.out.println("에러이유" + e);
    }
  }//delete end

  public void updateAppointment() {
    DBbase();
    try {
      //수정처리는 대상필드 name,title

      System.out.print("수정할 게시글 제목 입력 :");
      String updatetitle= keyScan.nextLine(); 
      System.out.print("장소 수정내역 입력  :");
      String location = keyScan.nextLine();
      System.out.print("시간 수정내역 입력  :");
      String time = keyScan.nextLine();
      System.out.print("총인원 수정내역 입력  :");
      int numlimit = Integer.parseInt(keyScan.nextLine());


      msg = "update appointment set location= ?, time = ?, numlimit =? where title = ?" ;
      System.out.println(msg);
      PST = CN.prepareStatement(msg);
      PST.setString(1, location);
      PST.setString(2, time);
      PST.setInt(3, numlimit);
      PST.setString(4, updatetitle);

      int condition = PST.executeUpdate();
      if (condition > 0) {
        System.out.println( "게시글 수정 성공");
      }else {
        System.out.println( "게시글 수정 실패");
      }

    }catch(Exception ex) { }
  }

  public void joinStudy() {
    DBbase();
    try {
      System.out.print("참여할 스터디 게시판의 번호를 선택하세요 : ");
      String number = keyScan.nextLine();
      String msg = "select title,location,time,numLimit from appointment where num= '" + number + "'" ;

      RS = ST.executeQuery(msg);
      while(RS.next() == true) {
        String location = RS.getString("location");
        String time = RS.getString("time");
        int numLimit = RS.getInt("numLimit");

        int request = keyScan.nextInt();
        final int architecture = request | 0x01; // 0000 0001
        final int documentize = request | 0x02; // 0000 0010
        final int coder1 = request | 0x04; // 0000 0100
        final int coder2 = request | 0x08; // 0000 1000

        System.out.println("-----------------------------스터디 게시판----------------------------");
        System.out.println();
        System.out.printf("'%s'에서 '%s'까지 '%d'명 모집\n", location, time, numLimit);
        // 월요일 할일 : appointment assign 컬럼추가

        if (architecture != 0) {
          System.out.printf("%s ■","프로젝트매니저");
        } else if (architecture == 0) {
          System.out.printf("%s □","프로젝트매니저");
        } if (documentize != 0) {
          System.out.printf("%30s ■","문서화책임자");
        } else if (documentize == 0) {
          System.out.printf("%30s □","문서화책임자");
        } if (coder1 != 0) {
          System.out.printf("%30s ■","무지성개발자");
        } else if (coder1 == 0) {
          System.out.printf("%30s □","무지성개발자");
        } if (coder2 != 0) {
          System.out.printf("%30s ■","지성개발자\n");
        } else if (coder2 == 0) {
          System.out.printf("%30s □","지성개발자\n");
        }

        //■ □
        // sql 문으로 assign 비교 적용
        int compare = architecture | documentize | coder1 | coder2;

        String compareMsg = "update appoinment set assing = ? where num = ?";
        PST = CN.prepareStatement(compareMsg);
        PST.setInt(1, compare);
        PST.setString(2, compareMsg);

        int assign = 0;
        if(assign != 0) {
          System.out.println("해당 포지션은 마감되었습니다.");
        } else {
          System.out.println("참가완료되었습니다.");
        }
        System.out.println();
      }
    } catch(Exception e) { }


    /*


    DBbase();
    msg = "select numLimit from appointment where num = ?";
    PST
      RS = ST.executeQuery(msg);

    if () {

    }
     */

  }



  //  public void reply() {
  //    System.out.println("댓글추가");
  //    DBbase();
  //    try {
  //      ST = CN.createStatement();
  //
  //      System.out.print("\n댓글입력 : ");
  //      String contents = keyScan.nextLine();
  //
  //      msg = "insert into reply (contents) values(?)";
  //
  //      PST = CN.prepareStatement(msg);
  //      PST.setString(1, contents);
  //
  //      System.out.println(msg);
  //
  //      int OK = PST.executeUpdate();
  //      if (OK>0) {
  //        System.out.println("댓글이 등록되었습니다.");
  //      }else { System.out.println("댓글등록을 실패했습니다.");}
  //    }catch (Exception e) {}
  //  }
}

