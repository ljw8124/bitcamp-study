package com.eomcs.day0706;

import java.util.Scanner;

public class Test {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("사번입력>>> ");
    int a = Integer.parseInt(sc.nextLine());

    System.out.print("이름입력>>> ");
    String b = sc.nextLine();

    System.out.print("부서입력>>> ");
    String c = sc.nextLine();

    String msg = "";
    msg = "insert into insa(sabun, name, buse) values(" + a + ", '"+ b + "', '"+ c +"')";

    System.out.println(msg);

  }
}

// 
