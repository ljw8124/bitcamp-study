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

  static Scanner keyScan; // App의 keyScan 과 공유(App line 17.) , 이 변수는 클래스 변수

  public void execute() {
    loop : while (true) {
      System.out.print("게시글 관리> ");
      String command = keyScan.nextLine();
      //      if (command.equals("quit")) { // 문자열 직접 비교할 때
      //        break;
      //    }
      switch (command) {
        case "list": list(); break;
        case "add": add(); break;
        case "update": update(); break;
        case "delete": delete(); break;
        case "view": view(); break;
        case "back":
          break loop;
        default:
          System.out.println("지원하지 않는 명령입니다.");
      }
      System.out.println();
    }
  }

  static void list() {
    System.out.println("[게시물 목록]");

    Object[] arr = ArrayList.toArray();
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
  static void add() {
    System.out.println("[게시글 등록]");

    if (ArrayList.size == ArrayList.MAX_LENGTH) {
      System.out.println("게시글을 더 이상 등록할 수 없습니다.");
      return; // 아래로 안내려가고 메소드 호출 끝냄
    }

    Board board = new Board(); //Board 설계에 따라서 레퍼런스 변수 생성

    System.out.print("제목 : ");
    board.title = keyScan.nextLine();

    System.out.print("내용 : ");
    board.content = keyScan.nextLine();

    System.out.print("비밀번호 : ");
    board.password = keyScan.nextLine();

    board.createdDate = new Date(); // 현재시간, 날짜도 인스턴스지만 실무에선 헷갈려서 날짜라함

    ArrayList.append(board);

    System.out.println("게시글을 등록했습니다.");

  }
  static void update() {
    System.out.println("[게시글 변경]");

    System.out.print("번호? ");
    int index = Integer.parseInt(keyScan.nextLine());

    if (index < 0 || index >= ArrayList.size) {
      System.out.println("무효한 게시글 번호입니다.");
      return;
    }

    Board board = (Board) ArrayList.retrieve(index);

    System.out.printf("제목(%s)? ", board.title);
    String title = keyScan.nextLine();

    System.out.printf("내용(%s)? ", board.content);
    String content = keyScan.nextLine();

    System.out.print("정말 변경하시겠습니까?(y/N) ");
    if (!keyScan.nextLine().equals("y")) { // 문자열은 == 로 비교 불가
      System.out.println("게시글 변경을 취소하였습니다.");
      return;
    }

    board.title = title;
    board.content = content;

    System.out.println("게시글을 변경하였습니다.");
  }

  static void delete () {
    System.out.println("[게시글 삭제]");
    System.out.print("번호? ");
    int index = Integer.parseInt(keyScan.nextLine());

    if (index < 0 || index >= ArrayList.size) {
      System.out.println("무효한 게시글 번호입니다.");
      return;
    }
    System.out.print("정말 삭제하시겠습니까?(y/N) ");
    if (!keyScan.nextLine().equals("y")) { // 문자열은 == 로 비교 불가
      System.out.println("게시글 삭제를 취소하였습니다.");
      return;
    }
    ArrayList.remove(index);

    System.out.println("게시글을 삭제하였습니다.");
  }
  static void view () {
    System.out.println("[게시글 조회]");
    System.out.print("번호? ");
    int index = Integer.parseInt(keyScan.nextLine());

    if (index < 0 || index >= ArrayList.size) {
      System.out.println("무효한 게시글 번호입니다.");
      return;
    }

    Board board = (Board) ArrayList.retrieve(index);

    board.viewCount++;

    System.out.printf("제목 : %s\n", board.title);
    System.out.printf("내용 : %s\n", board.content);
    System.out.printf("조회수 : %s\n", board.viewCount);
    System.out.printf("등록일 : %1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS\n", board.createdDate);
  }


}
