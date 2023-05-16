package org.joonzis.test;

//Q1.
//Cricle.java 			- 필드 : double radius
//						- 메소드 : Constructor, calcArea, output
//CricleMain.java			Circle 3개 생성 (반지름 입력 받아서 처리), 가장 크기가 큰 Circle 출력
//★
//calcArea => Math.PI * Math.pow(radius, 2)
//output => 반지름, 크기 출력



public class test01_Cricle {

	double radius;
	public test01_Cricle() {}
	
	
	public test01_Cricle(double radius) {
		this.radius = radius;
	}
	
	double calcArea() {
		return Math.PI * radius * radius ;
	}
	
	void output() {
		System.out.println("반지름 : " + radius);
		System.out.println("크기 : " + calcArea());
	}
}
