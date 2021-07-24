package bitcamp.project01.QnAboard;

import java.util.Scanner;

public class App extends MemberHandler{

  public static void main(String[] args) {
    DB db = new DB();
    db.DBbase();
    MainScreen main = new MainScreen();
    MemberHandler memberManagement = new MemberHandler();
    //    Member join = new Member();
    Board board = new Board();
    BoardHandler adminMode = new BoardHandler();

    main.mainScreen();
    try {
      while (true) {
        Scanner keyScan = new Scanner(System.in);
        main.bottom();
        int input = Integer.parseInt(keyScan.nextLine());
        System.out.println();
        switch(input) {
          case 1: memberManagement.insertMember(); break;
          case 2: memberManagement.login(); break;
          case 3: memberManagement.deleteMember(); break;
          case 4: memberManagement.Logout(); break;
          case 5: board.board(); break;
          case 9:
            System.out.println("게시판을 종료합니다.");
            System.exit(0);
          case 99: adminMode.admin(); break;
          default: System.out.println("가능한 메뉴만 선택해주세요^^");

        }//switch end
      }
    } catch(Exception e) {
      System.out.println("잘못 입력하셨습니다.");
    }
  }

}


