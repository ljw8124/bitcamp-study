package com.eomcs;

import java.util.Date;
import java.util.Scanner;

// concrete는 사용 가능한 class를 의미한다
// <-> abstract class 는 추상적 클래스로 사용 불가
public class BoardHandler implements Handler {

  //한 개의 게시글을 담을 변수를 설계
  static class Board { // static 변수는 클래스 변수로 Method Area에 생성
    String title;
    String content;
    String password;
    int viewCount;
    Date createdDate;
  }

  // 게시판을 구분하기 위해 게시판 이름을 저장할 인스턴스 변수를 준비한다.
  String boardName;

  Scanner keyScan; // App의 keyScan 과 공유(App line 17.) , 이 변수는 클래스 변수

  // BoardHandler 에서 사용할 ArrayList의 인스턴스를 준비한다.
  ArrayList boardList = new ArrayList();
  // MemberHandler와 같은 ArrayList를 사용. 주소 값이 다르기 때문에 가능! 

  // 생성자 만들기
  // -> 인스턴스를 생성할 때 반드시 호출해야 하는 메서드
  // => 메서드명은 클래스 이름과 같아야 한다.
  // => 리턴 타입은 지정하지 말아야 한다.
  // => 인스턴스를 생성할 때 반드시 설정해야 하는 값은 파라미터로 받는다
  BoardHandler(String boardName, Scanner keyScan) {
    this.boardName = boardName;
    this.keyScan = keyScan;
  }

  public void execute() {
    loop : while (true) {
      System.out.print(this.boardName + "/게시글 관리> ");
      String command = keyScan.nextLine();
      //      if (command.equals("quit")) { // 문자열 직접 비교할 때
      //        break;
      //    }
      switch (command) {
        case "list": this.list(); break;
        case "add": this.add(); break;
        case "update": this.update(); break;
        case "delete": this.delete(); break;
        case "view": this.view(); break;
        case "back":
          break loop;
        default:
          System.out.println("지원하지 않는 명령입니다.");
      }
      System.out.println();
    }
  }

  void list() {
    System.out.println("[게시물 목록]");

    Object[] arr = this.boardList.toArray();
    int i = 0;
    for (Object item : arr) {
      Board board = (Board) item;
      System.out.printf("%d, %s, %s, %d\n",
          i++,
          board.title,
          String.format("%1$tY-%1$tm-%1$td", board.createdDate),
          board.viewCount);
    }
  }
  void add() {
    System.out.println("[게시글 등록]");

    if (this.boardList.size == ArrayList.MAX_LENGTH) {
      System.out.println("게시글을 더 이상 등록할 수 없습니다.");
      return; // 아래로 안내려가고 메소드 호출 끝냄
    }

    Board board = new Board(); //Board 설계에 따라서 레퍼런스 변수 생성

    System.out.print("제목 : ");
    board.title = this.keyScan.nextLine();

    System.out.print("내용 : ");
    board.content = this.keyScan.nextLine();

    System.out.print("비밀번호 : ");
    board.password = this.keyScan.nextLine();

    board.createdDate = new Date(); // 현재시간, 날짜도 인스턴스지만 실무에선 헷갈려서 날짜라함

    this.boardList.append(board);

    System.out.println("게시글을 등록했습니다.");

  }
  void update() {
    System.out.println("[게시글 변경]");

    System.out.print("번호? ");
    int index = Integer.parseInt(this.keyScan.nextLine());

    if (index < 0 || index >= boardList.size) {
      System.out.println("무효한 게시글 번호입니다.");
      return;
    }

    Board board = (Board) this.boardList.retrieve(index);

    System.out.printf("제목(%s)? ", board.title);
    String title = this.keyScan.nextLine();

    System.out.printf("내용(%s)? ", board.content);
    String content = this.keyScan.nextLine();

    System.out.print("정말 변경하시겠습니까?(y/N) ");
    if (!this.keyScan.nextLine().equals("y")) { // 문자열은 == 로 비교 불가
      System.out.println("게시글 변경을 취소하였습니다.");
      return;
    }

    board.title = title;
    board.content = content;

    System.out.println("게시글을 변경하였습니다.");
  }

  void delete () {
    System.out.println("[게시글 삭제]");
    System.out.print("번호? ");
    int index = Integer.parseInt(this.keyScan.nextLine());

    if (index < 0 || index >= this.boardList.size) {
      System.out.println("무효한 게시글 번호입니다.");
      return;
    }
    System.out.print("정말 삭제하시겠습니까?(y/N) ");
    if (!this.keyScan.nextLine().equals("y")) { // 문자열은 == 로 비교 불가
      System.out.println("게시글 삭제를 취소하였습니다.");
      return;
    }
    this.boardList.remove(index);

    System.out.println("게시글을 삭제하였습니다.");
  }

  void view () {
    System.out.println("[게시글 조회]");
    System.out.print("번호? ");
    int index = Integer.parseInt(this.keyScan.nextLine());

    if (index < 0 || index >= this.boardList.size) {
      System.out.println("무효한 게시글 번호입니다.");
      return;
    }

    Board board = (Board) this.boardList.retrieve(index);

    board.viewCount++;

    System.out.printf("제목 : %s\n", board.title);
    System.out.printf("내용 : %s\n", board.content);
    System.out.printf("조회수 : %s\n", board.viewCount);
    System.out.printf("등록일 : %1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS\n", board.createdDate);
  }


}
