package com.eomcs.pratice;

public class SJUser {

  public static void main(String[] args) {

    //    Scanner keyScan = new Scanner(System.in);
    //    System.out.print("점수를 입력하세요 (0~100점) : ");

    //    int num = keyScan.nextInt();
    int[] score = new int[2];
    score[0] = 100; // 영어점수
    score[1] = 59; // 수학점수
    //    score[];

    SJ sj = new SJ();

    String user = "kim";

    int total = sj.getTotal(user, score[0], score[1]); 
    System.out.printf("%s 님의 점수 합계는 %d점 입니다.\n", user, total);

    double avg = sj.setAverage(total); // 점수평균
    System.out.println(user + " 님의 점수 평균은 " + avg + "점 입니다.");

    char grade = sj.getGrade(avg);
    System.out.printf("%s 님의 학점은 %c 입니다.\n", user, grade);

    String inform = sj.viewPass(avg , score[0], score[1]);
    System.out.printf("%s 님은 %s 입니다.\n", user, inform);
  }

}
