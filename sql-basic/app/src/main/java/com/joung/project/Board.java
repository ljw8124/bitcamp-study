package com.joung.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Board {
  Connection CN = null;
  Statement ST = null;
  ResultSet RS = null;
  String msg = "isud = crud 쿼리문 기술";
  static Scanner keyScan = new Scanner(System.in);
  static String id = "아이디 입력";
  static String pw = "패스워드 입력";

  // 로그인 시스템
  // 게시물 출력 -> 선택 페이스
  // 상세 출력

  public static void main(String[] args) {
    Board board = new Board();

    System.out.println("[QnA 게시판에 오신 것을 환영합니다.]");
    System.out.println("      Login");
    System.out.print("아이디 : ");
    id = keyScan.nextLine();
    System.out.print("비밀번호 : ");
    pw = keyScan.nextLine();

    if (id.equals("admin") && pw.equals("admin")) {
      board.admin();
    } else {
      board.member();
    }

  }


  public Board() { // 생성자로 만들어 무조건 실행하도록 설정
    try {
      Class.forName("oracle.jdbc.driver.OracleDriver");
      String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
      CN = DriverManager.getConnection(url, "system", "1234"); 
      ST =  CN.createStatement(); // 첫번째. 명령어 생성
      System.out.println("오라클 DB 연결 성공");
    } catch(Exception ex) {
      System.out.println("오라클 DB 연결 실패");
    }
  }

  void selectAll() {
    System.out.println("게시판 조회");
    System.out.println();
  }

  void insertBoard() {
    System.out.println("게시글 추가");
    System.out.println();
  }

  void deleteBoard() {
    System.out.println("게시글 삭제");
    System.out.println();
  }

  void updateBoard() {
    System.out.println("게시글 수정");
    System.out.println();
  }

  void deleteMember() {
    System.out.println("회원 삭제");
    System.out.println();
  }

  void admin() {
    try {
      loop : while (true) {
        if (id.equals("admin")) {
          System.out.println("관리자 모드로 실행합니다");
          System.out.println("\t[menu]");
          System.out.println("1. 게시판 조회");
          System.out.println("2. 게시글 추가");
          System.out.println("3. 게시글 삭제");
          System.out.println("4. 게시글 수정");
          System.out.println("5. 회원 삭제");
          System.out.println("종료를 원한다면 quit");
          System.out.print("입력 : ");
          String input = keyScan.nextLine();

          switch (input) {
            case "1":
            case "게시판 조회":
              selectAll();
              break;
            case "2":
            case "게시글 추가":
              insertBoard();
              break;
            case "3":
            case "게시글 삭제":
              deleteBoard();
              break;
            case "4":
            case "게시글 수정":
              updateBoard();
              break;
            case "5":
            case "회원 삭제":
              deleteMember();
              break;
            case "quit":
              break loop;
            default:
              System.out.println("잘못 입력하였습니다.");
          }

        }
      }
    } catch(Exception ex) { }
  }

  void member() {
    try {
      loop : while (true) {
        if (id.equals("admin")) {
          System.out.printf("%s 님 환영합니다\n", id);
          System.out.println("\t[menu]");
          System.out.println("1. 게시판 조회");
          System.out.println("2. 게시글 추가");
          System.out.println("3. 게시글 수정");
          System.out.println("종료를 원한다면 quit");
          System.out.print("입력 : ");
          String input = keyScan.nextLine();

          switch (input) {
            case "1":
            case "게시판 조회":
              selectAll();
              break;
            case "2":
            case "게시글 추가":
              insertBoard();
              break;
            case "3":
            case "게시글 수정":
              updateBoard();
              break;
            case "quit":
              break loop;
            default:
              System.out.println("잘못 입력하였습니다.");
          }

        }
      }
    } catch(Exception ex) { }
  }
}
