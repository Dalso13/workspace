package org.joonzis.test;


public class test03_Student {
	String name;
	String dept;
	test03_Grade grade;
	
	
	
	public test03_Student(String name, String dept,test03_Grade grade1) {
		this.name = name;
		this.dept = dept;
		grade = grade1;
	}
	
	
	
	
	void Output() {
		System.out.println(name);
		System.out.println(dept);
		System.out.println("국어 " + grade.kor);
		System.out.println("영어 " + grade.eng);
		System.out.println("수학 " + grade.mat);
		System.out.println("평균 " + grade.average);
		System.out.println("학점 " + grade.getGrade());
	}
}

