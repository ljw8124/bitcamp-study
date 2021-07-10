package com.joung.pratice;

import java.util.Scanner;

public class MainBoard {

  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    DB db = new DB();
    Notice nt = new Notice();
    db.DBbase();

    try {
      while(true) {

        System.out.println("1.공지사항");
        System.out.println("1.QnA게시판");
        System.out.println("1.스터디게시판");
        System.out.println("1.자유게시판");
        System.out.println("5.게시판 종료");
        System.out.print("입력 :");
        int sel = Integer.parseInt(sc.nextLine());
        switch(sel) {
          case 1 : 
            nt.select();
            System.out.print("\n1.게시글 추가 2.게시글 수정 3.게시글 삭제 4.게시글조회 5.back");
            System.out.print("\n입력 :");
            loop: while(true) {
              int k = Integer.parseInt(sc.nextLine());

              switch (k) {
                case 1: nt.insert();
                System.out.print("\n1.게시글 추가 2.게시글 수정 3.게시글 삭제 4.게시글조회 5.back");
                break;
                case 2: nt.update();
                System.out.print("\n1.게시글 추가 2.게시글 수정 3.게시글 삭제 4.게시글조회 5.back");
                break;
                case 3: nt.Delete(); 
                System.out.print("\n1.게시글 추가 2.게시글 수정 3.게시글 삭제 4.게시글조회 5.back");
                break;
                case 4: nt.select();
                System.out.print("\n1.게시글 추가 2.게시글 수정 3.게시글 삭제 4.게시글조회 5.back");
                break;
                case 5: break loop;
                default:
                  System.out.println("지원하지 않는 명령입니다.");
              } 
            }
          case 2 :  break;
          case 3 :  break;
          case 4 :  break;
          case 5 : 
            System.out.println("종료합니다.");
            System.exit(0);
          default :
            System.out.println("잘못 입력하셨습니다.");
            break;
        }//switch end
      }//while end
    }catch (Exception e) { }
  }  
}