package org.joonzis.test;

import java.util.Scanner;

public class test04_Student {
//	Q4. 
//	클래스 Student
//	- 필드 :
//	String name, String dept, String score1, String score2
//	double average
//	boolean isPass(합격 유무) : 80점 이상 true, 80점 미만 false
//	- 메소드 : 
//	input : name, dept, score1, score2 콘솔입력, 평균 및 패스 유무 확인
//	output : name, dept, average, isPass ("합격","불합격")
//	클래스 StudentMain
//	- 메소드 : main
	
	String name;
	String dept;
	String score1;
	String score2;
	double average;
	boolean isPass;
	
	void input(Scanner sc) {
		System.out.print("이름 입력 : ");
		name = sc.next();
		System.out.print(" 과목 입력 : ");
		dept = sc.next();
		System.out.print("점수1 입력 : ");
		score1 = sc.next();
		System.out.print("점수2 입력 : ");
		score2 = sc.next();
		average = (Integer.valueOf(score1) + Integer.valueOf(score2)) /2.0;
		
		isPass = average >= 80;
		output();
		
	}
	void output() {
		
		System.out.println("\n이름 : " + name);
		System.out.println("과목 이름 : " + dept);
		System.out.println("평균 : " + average);
		System.out.println("합격 유무 : " + (isPass ? "합격" : "불합격"));
	}
}
