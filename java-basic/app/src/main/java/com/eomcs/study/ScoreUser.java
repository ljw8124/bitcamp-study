package com.eomcs.study;

public class ScoreUser {

  public static void main(String[] args) {
    // 사용자명, 국어점수, 영어점수 산출

    Score sco = new Score();

    String name = "lee";



    int totalSum = sco.getTotal(sco.score[0], sco.score[1]);
    System.out.printf("%s 님의 시험 점수 합은 %d 점 입니다.\n", name, totalSum);

    double avg = sco.setAverage(totalSum);
    System.out.println(name + " 님의 시험 평균 점수는 " + avg + " 점 입니다.");

    char grade = sco.getGrade(avg);
    System.out.printf("%s 님의 학점은 %c 입니다.\n", name, grade);

    String inform = sco.viewPass(avg, sco.score[0], sco.score[1]);
    System.out.printf("%s님은 %s 입니다.\n", name, inform);

  }

}
