package com.eomcs.day0707;

import java.util.Scanner;

public class Test2 {

  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);

    System.out.print("사번입력>>> ");
    int num = Integer.parseInt(keyScan.nextLine());

    System.out.print("이름입력>>> ");
    String name = keyScan.nextLine();

    System.out.print("부서입력>>> ");
    String division = keyScan.nextLine();

    String inputMsg = "";
    inputMsg = "insert into insa(sabun, name, buse)"
        + "values(" + num + ", '"+ name + "', '"+ division +"')";

    System.out.println(inputMsg);

  }
}

// 
