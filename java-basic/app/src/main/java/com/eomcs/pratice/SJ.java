package com.eomcs.pratice;

public class SJ {
  // 합계 getTotal, 평균 setAverage, 학점 getGrade, 합격여부 viewPass
  int getTotal(String name, int mathScore, int engScore) {
    int sum = mathScore + engScore;
    return sum;
  }

  double setAverage(int totalValue) { // 매개변수는 파라미터
    double avg = totalValue / 2.0;
    return avg;
  }

  char getGrade(double score) {
    //   100-90A/ 89-80B/ 79-70C/ 69-60D/ 59-0F switch 사용 메서드 이름 리턴값 어떤타입.
    char grade = 'F';

    switch ((int)score/10) {
      case 10 :
      case 9 : grade = 'A'; break;
      case 8 : grade = 'B'; break;
      case 7 : grade = 'C'; break;
      case 6 : grade = 'D'; break;
      default :
        grade = 'F';
    }
    return grade;
  }

  String viewPass(double avg, int score1, int score2) {
    String msg = "합격여부안내문";

    //    if (avg > 70) {
    //      if (score1 > 60) {
    //        if (score2 > 60) {
    //          msg = "합격";
    //        }
    //      }
    //    } else {
    //      msg = "재시험";
    //    }

    // 함수의 중복 오버로딩.
    if (avg >= 70 && score1 >= 60 && score2 >= 60) {
      msg = "합격";
    } else {
      msg = "재시험";
    }
    return msg;
  }


}


