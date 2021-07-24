package bitcamp.project01.QnAboard;

import java.util.Date;
import java.util.Scanner;

public class BoardHandler extends MemberHandler {
  static Scanner keyScan = new Scanner(System.in);

  public void insertBoard(String table) { // 멤버 모두
    System.out.println("게시글 추가");
    DBbase();
    try {
      //첫 번째 명령어 생성 
      ST = CN.createStatement();

      //키보드에서 데이터 입력
      System.out.print("\n제목 : ");
      String title = keyScan.nextLine();
      // System.out.print("grade : "); // grade default 1
      // int grade = Integer.parseInt(keyScan.nextLine());
      System.out.print("내용 : ");
      String contents = keyScan.nextLine();

      msg = "insert into " + table + " (num, title, contents, recommended, written, id, viewcount)"
          + " values(" + table + "seq.nextval, ?, ?, 0, sysdate,'" + id + "', 0)";

      PST = CN.prepareStatement(msg);
      PST.setString(1, title);
      PST.setString(2, contents);
      // PST.setString(5, id);
      int OK = PST.executeUpdate();
      if (OK > 0) {
        System.out.println(title + "게시글이 등록되었습니다.");
      } else {System.out.println(title + "게시글 등록이 실패하였습니다.");}
    }catch (Exception e) { } 

  }

  void updateBoard(String table) { // 작성한 사람
    DBbase();
    try {
      //수정처리는 대상필드 name,title
      System.out.print("수정할 게시물 제목 입력  :");
      String title = keyScan.nextLine(); 
      System.out.print("제목 수정내역 입력  :");
      String updatetitle= keyScan.nextLine(); 
      System.out.print("내용 수정내역 입력  :");
      String contents = keyScan.nextLine();

      msg = "update " + table + " set title = '" + updatetitle +"', contents='"+ contents +"'  where title = '"+ title + "'";

      int condition = ST.executeUpdate(msg);
      if (condition > 0) {
        System.out.println( "게시글 수정 성공");
      }else {
        System.out.println( "게시글 수정 실패");
      }

    }catch(Exception ex) { }    
  }

  void deleteBoard(String table) { // admin 권한
    try {
      System.out.println("\n삭제할 게시글 번호 입력 : ");
      int a = Integer.parseInt(keyScan.nextLine());

      System.out.print("정말로 삭제하시겠습니까? ");
      if(!keyScan.nextLine().equals('y')) {
        System.out.println("게시르 삭제 취소하였습니다.");
      } else {
        msg = "delete from " + table + " where num = " + a ;
        int condition = ST.executeUpdate(msg);

        if (condition > 0) {
          System.out.println(a + "게시글 삭제");
        } else {System.out.println(a + "게시글 삭제실패했습니다.");}
      }
    }catch (Exception e) {System.out.println("에러이유" + e);}
  }

  void search(String table)  { // 회원 모두

    try {
      System.out.println("게시글 검색 키워드: ");
      String search = keyScan.nextLine();
      String msg = "select title,contents from " + table + " where title like '%" + search + "%' or contents like '%" + search + "%'" ;
      RS = ST.executeQuery(msg);
      while(RS.next() == true) {
        String contents = RS.getString("contents");

        // int joined = RS.getInt("role1");
        String title = RS.getString("title");
        System.out.println(title +"\t" + contents);
      }
    } catch(Exception e) { }
  }

  public void viewReply(String table) { //회원모두, 게시글 보기
    DBbase();
    try {
      msg = "select * from " + table;

      RS = ST.executeQuery(msg);
      //      System.out.println(msg);

      // 자바의 정석 39p 참고
      System.out.printf("%5s %10s %20s %15s %4s %3s%n"
          , "번호", "제목","좋아요","날짜","ID","조회수");
      System.out.println();
      for(int i = 0; i < 10 && RS.next() == true; i++) {
        int num = RS.getInt("num");
        String title = RS.getString("title");
        //String reply = RS.getString("reply");
        int recommended = RS.getInt("recommended");
        Date written  = RS.getDate("written");
        String id = RS.getString("id");
        int viewCount = RS.getInt("viewcount");
        //System.out.printf(id + "\t" + grade +  "\t" + name+ "\t" + email+ "\t" + mobile+ "\t" + date+ "\t" + recommended+ "\t" + belongs);
        System.out.printf("%5d %10s %20d %15s %4s %3d%n"
            , num, title, recommended, written, id, viewCount);
      }
      //  게시글 번호로 내용 출력
      System.out.println("게시글 번호 입력: ");
      String number = keyScan.nextLine();
      String msg = "select contents,reply from " + table + " where num= '" + number + "'" ;
      RS = ST.executeQuery(msg);
      while(RS.next() == true) {

        String contents = RS.getString("contents");

        System.out.println("------------------------------내용------------------------------");
        System.out.println();
        System.out.println(contents);


        //        System.out.println("------------------------------댓글------------------------------");
        //        System.out.println();

        //        loop: while (true) {
        //          System.out.println("[1]댓글보기 [2]댓글쓰기 [3]나가기");
        //          String command = sc.nextLine();
        //
        //          switch (command) {
        //            case "1" :
        //              System.out.println("[1] 댓글보기");
        //              String reply = RS.getString("contents");
        //              System.out.println("------------------------------댓글------------------------------");
        //              System.out.println();
        //              System.out.println(reply);
        //              break;
        //            case "2" :
        //              System.out.println("[2] 댓글쓰기");
        //              appointment.reply();
        //              break;
        //            case "3" :
        //              System.out.println("[3] 나가기");
        //              break loop;
        //          }
        //        }

        try { // 조회수 땡기는 while문
          String text = "update " + table + " set viewcount = viewcount+1 where num =" + number ;
          RS = ST.executeQuery(text);
          while(RS.next() == true) {
            int num = RS.getInt("num");
            //  System.out.println(num);
          }
        }catch (Exception e) { } 
        break;

      }

    } catch (Exception e) {
      System.out.println("에러이유" + e);
    }
  }


  public void viewBoard(String table) {
    DBbase();
    try {
      msg = "select * from " + table;

      RS = ST.executeQuery(msg);
      //      System.out.println(msg);

      // 자바의 정석 39p 참고
      System.out.printf("%5s %10s %20s %15s %4s %3s%n"
          , "번호", "제목", "좋아요","날짜","ID","조회수");
      System.out.println();
      for(int i = 0; i < 5 && RS.next() == true; i++) {
        int num = RS.getInt("num");
        String title = RS.getString("title");
        int recommended = RS.getInt("recommended");
        Date written  = RS.getDate("written");
        String id = RS.getString("id");
        int viewCount = RS.getInt("viewcount");
        //System.out.printf(id + "\t" + grade +  "\t" + name+ "\t" + email+ "\t" + mobile+ "\t" + date+ "\t" + recommended+ "\t" + belongs);
        System.out.printf("%5d %10s %20d %15s %4s %3d%n"
            , num, title, recommended, written, id, viewCount);
      }
    }catch(Exception e) { }
  } 

  public void admin() {
    DBbase();
    MemberHandler memberHandler = new MemberHandler();
    try {
      if (id.equals("admin")) {
        memberHandler.selectAll();
        System.out.print("권한을 주고 싶은 ID 입력 : ");
        String changeId = keyScan.nextLine();
        System.out.print("부여할 권한 범위 입력 (범위:1...3) : ");
        String changeGrade = keyScan.nextLine();

        String updateMsg = "update id set grade = ? where id = ?";
        System.out.println(updateMsg);
        PST = CN.prepareStatement(updateMsg);
        PST.setString(1, changeGrade);
        PST.setString(2, changeId);

        int condition = PST.executeUpdate();
        if (condition > 0) {
          System.out.println("권한 부여 완료");
        } else {
          System.out.println("권한 부여 실패");
        }
      } else {
        System.out.println("관리자만이 접근할 수 있습니다.");
      }
    } catch(Exception ex) {
      System.out.println("잘못된 접근입니다.");
    }
    System.out.println();
  }
}
