package org.joonzis.ex;

public class Ex03_Student {
	String name;
	String dept;
	String score1;
	String score2;
	double average;
	boolean ispass;
	
	public Ex03_Student(){}

	public Ex03_Student(String name, String dept, String score1, String score2) {
		this.name = name;
		this.dept = dept;
		this.score1 = score1;
		this.score2 = score2;
		this.average = getAverage();
		this.ispass = getPass();
	}
	
	double getAverage() {
		return (Double.parseDouble(score1) + Double.parseDouble(score2))/ 2.0;
	}
	boolean getPass( ) {
		return getAverage() >= 80;
	}
	
	
	void output () {
		System.out.println("이름 : " + name);
		System.out.println("국어 : " + dept);
		System.out.println("중간 : " + score1);
		System.out.println("기말 : " + score2);
		System.out.println("평균 : " + getAverage());
		System.out.println("합격 여부 : " + (getPass() ? "합격" : "불합격"));
		
	}
}
