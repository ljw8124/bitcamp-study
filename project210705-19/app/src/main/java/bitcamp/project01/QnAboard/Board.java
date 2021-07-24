package bitcamp.project01.QnAboard;

import java.util.Scanner;

public class Board extends MemberHandler{
  static Scanner keyScan = new Scanner(System.in);

  public void board() {

    Appointment appointment = new Appointment();
    BoardHandler boardHandler = new BoardHandler();
    DBbase();
    System.out.println("\"-----------------------------------[자유 게시판]---------------------------------------");
    boardHandler.viewBoard("freeboard");
    System.out.println("-----------------------------------------------------------------------------------------");
    System.out.println("-----------------------------------[사용기 게시판]-------------------------------------");
    boardHandler.viewBoard("board");
    System.out.println("-----------------------------------------------------------------------------------------");
    System.out.println("-----------------------------------[수업진도 게시판]-------------------------------------");
    boardHandler.viewBoard("review");
    System.out.println("-----------------------------------------------------------------------------------------");
    System.out.println("----------------------------------[스터디모집 게시판]------------------------------------");
    appointment.viewAppointment();
    System.out.println("-----------------------------------------------------------------------------------------");
    System.out.println();
    System.out.println("[게시판 목록] : freeBoard/ board/ review/ appointment");
    System.out.println("[단축어] : [f]-자유 게시판 [b]-사용기 게시판 "
        + "[r]-수업진도 게시판 [a]-스터디모집 게시판 [c]-취소");
    System.out.println();
    System.out.print("입장할 게시판을 입력해주세요 : ");
    String input = keyScan.nextLine();

    try {
      if (input.equals("a")) {
        input = "appointment";
        appointment.viewAppointment();

        loop: while (true) {

          String text = "select grade from id where id = '" + id + "'";//입력값 id가 포함된 쿼리문을 변수text에 입력
          RS = ST.executeQuery(text);
          //변수 text를 데이터베이스 변수 RS에 입력한다.
          while(RS.next() == true) {
            int grade = RS.getInt("grade");// id필드 데이터에에 종속되어 있는 grade필드 데이터를 int변수로 저장
            System.out.println(id + "님의 회원 등급은 " + grade + "번 입니다.");
            System.out.println();

            switch (grade) {
              case 4:
                System.out.print("[d] 게시글 삭제\t");
              case 3:
                System.out.print("[u] 게시글 수정\t");
              case 2:
                System.out.print("[i] 게시글 작성\t");
              case 1:
                System.out.print("[v] 게시판 조회\t");
                System.out.print("[j] 스터디 참여\t");
                System.out.print("[s] 게시글 검색\t");
                System.out.print("[b] 뒤로 가기\n");
              default:
                break;
            }
            System.out.print("[명령어]를 입력하세요 : ");
            String select  = keyScan.nextLine();
            switch (select) {
              case "d": appointment.deleteAppoinment(); break;
              case "u": appointment.updateAppointment(); break;
              case "i": appointment.insertAppointment(); break;
              case "v": appointment.viewAppointment(); break;
              case "j": appointment.joinStudy(); break;
              case "b": break loop;
            }
          }

          // System.out.print("[1] 게시판 조회\t");
          //System.out.print("[2] 게시글 작성\t");
          //   System.out.print("[3] 게시글 수정\t");
          //   System.out.print("[4]게시글 삭제\t");
          //   System.out.print("[5]스터디 참여\t");
          //   System.out.print("[6]뒤로 가기\n");
          //   System.out.print("[번호]를 입력하세요 : ");
          //   int select = keyScan.nextInt();

          //   switch (select) {
          //     case 1: appointment.viewAppointment(); break;
          //    case 2: appointment.insertAppointment(); break;
          //    case 3: appointment.updateBoard(); break;
          //   case 4: appointment.deleteBoard(); break;
          //   case 5: appointment.joinStudy(); break;
          //   case 6: break loop;

        }

      } else {
        if (input.equals("f")) {
          input = "freeBoard";
          boardList(input);
        } else if (input.equals("b")) {
          input = "board";
          boardList(input);
        } else if (input.equals("r")) {
          input = "review";
          boardList(input);
        } else if (input.equals("c")) {
          return;
        }
      }
    } catch(Exception ex) {
      System.out.println("존재하지 않는 게시판입니다.");
    }
  }

  public void boardList(String input) {

    BoardHandler boardHandler = new BoardHandler();
    DBbase();

    boardHandler.viewBoard(input);
    try {
      loop: while (true) {
        String text = "select grade from id where id = '" + id + "'";//입력값 id가 포함된 쿼리문을 변수text에 입력
        RS = ST.executeQuery(text);

        //변수 text를 데이터베이스 변수 RS에 입력한다.
        while(RS.next() == true) {
          int grade = RS.getInt("grade");// id필드 데이터에에 종속되어 있는 grade필드 데이터를 int변수로 저장
          System.out.println(id + "님의 회원 등급은 " + grade + "번 입니다.");
          System.out.println();

          switch (grade) {
            case 4:
              System.out.print("[d] 게시글 삭제\t");
            case 3:
              System.out.print("[u] 게시글 수정\t");
            case 2:
              System.out.print("[i] 게시글 작성\t");
            case 1:
              System.out.print("[v] 게시판 조회\t");
              System.out.print("[s] 게시글 검색\t");
              System.out.println("[b] 뒤로 가기");
            default:
              break;
          }
          System.out.print("[명령어]를 입력하세요 : ");
          String select  = keyScan.nextLine();
          switch (select) {
            case "d": boardHandler.deleteBoard(input); break;
            case "s": boardHandler.search(input); break;
            case "u": boardHandler.updateBoard(input); break;
            case "i": boardHandler.insertBoard(input); break;
            case "v": boardHandler.viewReply(input); break;
            case "b": break loop;
          }
        }

      }
    } catch(Exception e) { System.out.println(e);}
  }
}
/*
  void boardList() {
    System.out.println("\t[게시판 목록]");
    System.out.println("1. QnA 게시판");
    System.out.println("2. 자유 게시판");
    System.out.println("3. 수업진도 게시판");
    System.out.println("4. 스터디 게시판");
    System.out.print("입력 : ");
    String input = keyScan.nextLine();

    switch (input) {
      case "1":
        System.out.println("QnA 게시판");
        break;
      case "2":
        System.out.println("자유 게시판");
        break;
      case "3":
        System.out.println("수업진도 게시판");
        break;
      case "4":
        System.out.println("스터디 게시판");
        break;
      default:
        System.out.println("잘못 입력하셨습니다.");
    }

  }
 */



