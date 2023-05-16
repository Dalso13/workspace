package org.joonzis.test;

import java.util.Random;

class Student {
	private	String no,name;
	private	int scores[];
	private double average;
	private char grade;
	public static final int COURSE_COUNT = 3;
	
	public Student(String no, String name) {
		this.no = no;
		this.name = name;
	}
	
	
	public void setScores(int kor, int eng, int mat) {
		this.scores = new int[3];
		
		scores[0] = kor;
		scores[1] = eng;
		scores[2] = mat;
		
		setAverage();
		setGrade();
	}
	public void setScores(int scores[]) {
		Random ran = new Random();
		
		for (int i = 0; i < scores.length; i++) {
			scores[i] = ran.nextInt(51)+50;
		}
		
		this.scores = scores;
		
		setAverage();
		setGrade();
	}
	private void setAverage(){
		for (int i = 0; i < scores.length; i++) {
			average += scores[i];
		}
	this.average = average/COURSE_COUNT;
	}
	private void setGrade() {
		if (average >= 90) {
			grade = 'A';
		} else if(average >= 80) {
			grade = 'B';
		} else if (average >= 70) {
			grade = 'C';
		} else {
			grade = 'F';
		}
	}
	
	@Override
	public String toString() {
		return "학번 : " + no + ", 성명 : " + name + ", 평균 : " + 
				average + ", 학점 : " + grade;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj != null && obj instanceof Student) {
			Student st3 = ((Student)obj);
			return no.equals(st3.no);
		} else {
			return false;
		}
	}
}

public class Test04 {
	
//	Q4. Test04.java
//
//	Student 클래스				필드 : String no(학번), String name, int[] scores(국,영,수)
//								     double average, char grade, 상수 int COURSE_COUNT(과목수)
//								메소드 : Student(String no, String name)
//									   setter{
//										setScores(int kor, int eng, int mat) - 직접 입력
//										setScores(int[] scores) - 랜덤 입력
//										setAverage()
//										setGrade()
//										}
//									   toString() 학번, 성명, 평균, 학점 출력
//									   equals() 학번이 같으면 같은 학생으로 비교   
//									   
	
	public static void main(String[] args) {
		Student stu1 = new Student("14번", "장동완");
		Student stu2 = new Student("14번", "김동원");
		

		
		stu1.setScores(80,80,80);
		stu2.setScores(new int[stu2.COURSE_COUNT]);
		
		
		if (stu1.equals(stu2)) {
			System.out.println("동등");
		} else {
			System.out.println("아님");
		}
		System.out.println(stu1.toString());
		System.out.println(stu2.toString());
	}
}
