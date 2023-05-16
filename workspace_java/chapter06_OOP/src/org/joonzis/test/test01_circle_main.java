package org.joonzis.test;

public class test01_circle_main {
	public static void main(String[] args) {
//		Q1. 
//		클래스 Circle
//		- 필드 : radius, PI, name
//		- 메소드 : info
//		클래스 CircleMain
//		- 메소드 : main
//		값을 대입해서 
//		반지름, 이름, 크기(PI*R*R), 둘레(2*PI*R) 값 출력
		
		test01_circle circle = new test01_circle();
		
		circle.radius = 5.;
		circle.name = "원";
		
		circle.info();
		
		
	}
}
