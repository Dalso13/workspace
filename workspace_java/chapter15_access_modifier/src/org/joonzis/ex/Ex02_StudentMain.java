package org.joonzis.ex;

import java.util.Scanner;

public class Ex02_StudentMain {
	public static void main(String[] args) {
		Ex02_Student stu = new Ex02_Student("장동완", "컴공");
		
		stu.input(new Scanner(System.in));
		
		stu.output();
	}
	
	
}
