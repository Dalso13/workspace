package org.joonzis.test;

public class test03_GradeMain {
	public static void main(String[] args) {
		test03_Grade grade1 = new test03_Grade(90, 80, 70);
		test03_Student stu = new test03_Student("장동완" , "자바 과",grade1);

		
		stu.Output();
	}
}
