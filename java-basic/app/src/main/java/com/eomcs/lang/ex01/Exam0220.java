package com.eomcs.lang.ex01;
    public class Exam0210x{} //public은 클래스=파일명 성립해야됨
/*
    이 경우에는 public이기 때문에 파일명과 class 명이 달라서 컴파일 오류가 나는게 정상
    따라서 public 을 붙이려면 class 명과 파일 명이 같아야 한다.
    소스 파일명과 클래스 파일명을 같게 해야함. if 다르다면 유지보수시 소스 파일을 찾기 힘들어서 고충을 겪게 됨.
    한 소스 파일에 가능한 한 클래스를 두는게 좋음 -> 그래야 소스파일 찾기가 쉬워짐
    클래스 패키지와 같은 경로에 소스 파일을 두는게 좋음
*/