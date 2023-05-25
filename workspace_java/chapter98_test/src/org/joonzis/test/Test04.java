package org.joonzis.test;

import java.util.Scanner;

class Student{
	private int kor, eng, mat;
	private String name;
	private double avg;
	private boolean isPass;
	
	
	
	public void input(String name ,int kor ,int eng ,int mat) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		
		this.avg = (kor + eng + mat)/3.0;
		
		this.isPass = avg >= 70;
	}

	public double getAvg() {
		return avg;
	}
	public String getPass() {
		return isPass ? "합격" : "불합격";
	}
	
	public void output() {
		System.out.println("이름 : " + name);
		System.out.println("국어 : " + kor);
		System.out.println("영어 : " + eng);
		System.out.println("수학 : " + mat);
		System.out.println("평균 : " + getAvg());
		System.out.println("합격 여부 : " + getPass());
	}
}

public class Test04 {
	public static void main(String[] args) {
		Student stu = new Student();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		System.out.print("국어 점수 : ");
		int kor = sc.nextInt();
		
		System.out.print("영어 점수 : ");
		int eng = sc.nextInt();
		
		System.out.print("수학 점수 : ");
		int mat = sc.nextInt();
		
		stu.input(name, kor, eng, mat);
		
		stu.output();
	}
}
