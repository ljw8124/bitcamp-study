package com.eomcs.study;

public class Score {

  int[] score = {85, 90};

  // 합계 getTotal, 평균 setAverage, 학점 getGrade, 합격여부 viewPass

  //  Scanner keyScan = new Scanner(System.in);

  int getTotal(int score1, int score2) {
    int value = score1 + score2;
    return value; 
  }  

  double setAverage(int sum) {
    double avg = sum / 2.0;
    return avg;
  }

  char getGrade(double avg) {
    char grade = 'F';
    switch((int)avg / 10) {
      case 10:
      case 9:
        grade = 'A'; break;
      case 8:
        grade = 'B'; break;
      case 7:
        grade = 'C'; break;
      case 6:
        grade = 'D'; break;
      default :
        grade = 'F';
    }
    return grade;
  }

  String viewPass(double avg, int score1, int score2) {
    String msg = "시험 합격 여부자 알림";
    if (avg > 70 && score1 > 60 && score2 > 60) {
      msg = "시험 합격자";
    } else {
      msg = "재시험 대상자";
    }
    return msg;
  }

}
