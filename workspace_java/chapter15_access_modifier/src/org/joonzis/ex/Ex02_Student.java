package org.joonzis.ex;

import java.util.Scanner;

/*
 * 	필드
 * 	- String name, dept , score1 , score2
 * 	- double average
 * 	- boolean isPass
 * 
 *	메소드
 *	- 생성자(scanner) : 중간, 기말 평균, 패스 유무 초기화
 *	- getAberage() : 평균 값 리턴
 *	- isPass() : 패스유무 리턴 (평균 80 이상 통과)
 *	- output() : 이름, 학과, 평균, 합격or불합격 출력
 */

public class Ex02_Student {
	String name, dept, score1, score2;
	double average;
	boolean isPass;
	
	
	
	public Ex02_Student(String name, String dept) {
		this.name = name;
		this.dept = dept;
	}
	
	public void input(Scanner sc) {
		System.out.print("중간 점수 : ");
		this.score1 = sc.nextLine();
		System.out.print("기말 점수 : ");
		this.score2 = sc.nextLine();
		
		this.average = getAverage();
		this.isPass = isPass();
	}
	
	private double getAverage() {
		 return  (Double.parseDouble(score1)+ Double.parseDouble(score2)) /2;
	}
	private boolean isPass() {
		return average >= 80;
		
	}
	
	public void output() {
		System.out.println("\n이름 : " + name);
		System.out.println("학과 : " + dept);
		System.out.println("평균 : " + average);
		System.out.println("합격 유무 : " + (isPass ? "합격" : "불합격"));
	}
	
	
	
	

}
