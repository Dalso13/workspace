package org.joonzis.test;


//Q3.
//Grade.java				필드 - int kor, int eng, int mat, double average, char grade
//						메소드 - Constructor, getAverage(평균을 리턴), getGrade(학점을 리턴)
//Student.java			필드 - String name, String dept, Grade grade
//						메소드 - Constructor, output
//StudentGradeMain.java	



public class test03_Grade {
	int kor;
	int eng;
	int mat;
	double average;
	char grade;
	
	public test03_Grade(int kor, int eng, int mat) {
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		average = getAverage();

	}
	
	double getAverage() {
		return (kor + eng + mat)/3.0;
	}
	
	
	
	char getGrade() {
		
		if (getAverage() >= 90) {
			grade ='A';
		} else if (getAverage() >= 80) {
			grade = 'B';
		} else if (getAverage() >= 70) {
			grade = 'C';
		}	else {
			grade = 'F';
		}
		return grade;
	}
	
	
	
	
}
