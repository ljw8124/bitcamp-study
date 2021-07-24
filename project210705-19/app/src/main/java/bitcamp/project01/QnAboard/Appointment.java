package bitcamp.project01.QnAboard;

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
      System.out.printf("%5s %10s %10s %10s %10s %10s %4s%n"
          , "번호", "제목", "장소", "시간","날짜", "ID","정원");
      System.out.println();
      while(RS.next() == true) {
        int num = RS.getInt("num");
        String title = RS.getString("title");
        String location = RS.getString("location");
        String time = RS.getString("time");
        Date date  = RS.getDate("written");
        String id = RS.getString("id");
        int numLimit = RS.getInt("numlimit");
        int assign = RS.getInt("assign");
        //System.out.printf(id + "\t" + grade +  "\t" + name+ "\t" + email+ "\t" + mobile+ "\t" + date+ "\t" + recommended+ "\t" + belongs);
        System.out.printf("%5s %10s %10s %10s %10s %10s %4d/%s\n"
            , num, title, location, time, date, id,assign ,numLimit);
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
      msg = "insert into appointment(num, title, location, time, written, id, numlimit, assign) "
          + "values(appointmentseq.nextval, ?, ?, ?, sysdate, '" + id  + "',4 ,0)";
      PST = CN.prepareStatement(msg);
      PST.setString(1, title);
      PST.setString(2, location);
      PST.setString(3, time);

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
      System.out.println("정말 삭제하시겠습니까? [y / N]");

      System.out.print("게시글을 정말 굳이 꼭 삭제하셔야겠습니까? (y/N)");
      if(!keyScan.nextLine().equals("y")) {
        System.out.println("게시글 삭제 취소하셨습니다.");
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
      int number = keyScan.nextInt();
      msg = "select * from appointment where num = ?" ;
      PST = CN.prepareStatement(msg);
      PST.setInt(1, number);
      RS = PST.executeQuery();
      while(RS.next() == true) {
        String title = RS.getString("title");
        String location = RS.getString("location");
        String time = RS.getString("time");
        int numLimit = RS.getInt("numLimit");
        int assign = RS.getInt("assign");

        System.out.println("-----------------------------스터디 게시판----------------------------");
        System.out.println();
        System.out.printf("프로젝트명 : %s \n", title);
        System.out.printf("장소 : %s \n", location);
        System.out.printf("시간 : %s \n", time);
        System.out.printf("모집현황 : 총원 %d 중 %d명 모집 중 \n", numLimit, assign);
        System.out.println();
        //        
        //        if (architecture != 0) {
        //          System.out.printf("%s ■","프로젝트매니저");
        //        } else if (architecture == 0) {
        //          System.out.printf("%s □","프로젝트매니저");
        //        } if (documentize != 0) {
        //          System.out.printf("%15s ■","문서화책임자");
        //        } else if (documentize == 0) {
        //          System.out.printf("%15s □","문서화책임자");
        //        } if (coder1 != 0) {
        //          System.out.printf("%15s ■","무지성개발자");
        //        } else if (coder1 == 0) {
        //          System.out.printf("%15s □","무지성개발자");
        //        } if (coder2 != 0) {
        //          System.out.printf("%15s ■","지성개발자\n");
        //        } else if (coder2 == 0) {
        //          System.out.printf("%15s □","지성개발자\n");
        //        }

        int architecture = 0x01; //1 
        int documentize = 0x02; // 2
        int coder1 = 0x04;
        int coder2 =  0x08;

        Object compare = null; // 초기화를 숫자로 하지 않기위해서 object로 선언

        String text = "select compare from appointment where num = " + number;
        RS = ST.executeQuery(text);
        while(RS.next() == true) {
          compare = RS.getInt("compare");
        }

        loop: for (; assign < 4;) {
          System.out.println("지원 직군을 선택해주세요.");
          System.out.println();
          System.out.println("[1] 프로젝트 매니저 [2] 문서작업관리자 [3] 무지성코더 [4] 지성코더");
          System.out.print("입력 >>>> ");
          int request = keyScan.nextInt();

          switch(request) {
            case 1:  
              if (((int)compare & 0x01) == 0) { // compare 가 object 이므로 int로 강제형변환
                //                System.out.printf("%s ■","프로젝트매니저");
                compare = (int)compare + architecture;
                assign++;
                String msg = "update appointment set compare = ?,assign = ? where num = ?";
                PST = CN.prepareStatement(msg);
                PST.setInt(1, (int)compare);
                PST.setInt(2, assign);
                PST.setInt(3, number);
                int condition = PST.executeUpdate();
                if (condition  > 0) {
                  System.out.println("참가 완료");
                  break loop;
                } else {
                  System.out.println("참가 실패");
                  break loop;
                }
              } else {
                System.out.println("해당 포지션은 마감되었습니다.");
              }
              break;

            case 2:
              if (((int)compare & 0x02) == 0) {
                //                System.out.printf("%s ■","프로젝트매니저");
                compare = (int)compare + documentize;
                assign++;
                String msg = "update appointment set compare = ?,assign = ? where num = ?";
                PST = CN.prepareStatement(msg);
                PST.setInt(1, (int)compare);
                PST.setInt(2, assign);
                PST.setInt(3, number);
                int condition = PST.executeUpdate();
                if (condition  > 0) {
                  System.out.println("참가 완료");
                  break loop;
                } else {
                  System.out.println("참가 실패");
                  break loop;
                }
              } else {
                System.out.println("해당 포지션은 마감되었습니다.");
              }
              break;

            case 3:
              if (((int)compare & 0x04) == 0) {
                //                System.out.printf("%s ■","프로젝트매니저");
                compare = (int)compare + coder1;
                assign++;
                String msg = "update appointment set compare = ?,assign = ? where num = ?";
                PST = CN.prepareStatement(msg);
                PST.setInt(1, (int)compare);
                PST.setInt(2, assign);
                PST.setInt(3, number);
                int condition = PST.executeUpdate();
                if (condition  > 0) {
                  System.out.println("참가 완료");
                  break loop;
                } else {
                  System.out.println("참가 실패");
                  break loop;
                }
              } else {
                System.out.println("해당 포지션은 마감되었습니다.");
              }
              break;

            case 4:
              if (((int)compare & 0x08) == 0) {
                //                System.out.printf("%s ■","프로젝트매니저");
                compare = (int)compare + coder2;
                assign++;
                String msg = "update appointment set compare = ?,assign = ? where num = ?";
                PST = CN.prepareStatement(msg);
                PST.setInt(1, (int)compare);
                PST.setInt(2, assign);
                PST.setInt(3, number);
                int condition = PST.executeUpdate();
                if (condition  > 0) {
                  System.out.println("참가 완료");
                  break loop;
                } else {
                  System.out.println("참가 실패");
                  break loop;
                }
              } else {
                System.out.println("해당 포지션은 마감되었습니다.");
              }
              break;
          }


        } 

        if (assign == 4) 
          System.out.println("모두 모집되었습니다");

      }
    } catch(Exception e) {System.out.println(e);}

  }
}
