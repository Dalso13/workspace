package org.joonzis.test;

import java.util.Scanner;

public class test_07 {
	public static void main(String[] args) {
//		Test09.java
//		Q. 과목 이름을 입력받아 해당 과목 점수를 출력해주는 프로그램을 작성.
//			무한반복을 하다가 "그만"을 입력 받으면, 프로그램 종료
//		★	String[] subjectArr = {"Java", "Python", "Android", "JSP", "Javascript"};
//			int[] scoreArr = {95, 88, 78, 62, 55};
//		실행 예)
//		Java의 점수는 : 95
		
		Scanner sc = new Scanner(System.in);
		
		String[] subjectArr = {"Java", "Python", "Android", "JSP", "Javascript"};
		int[] scoreArr = {95, 88, 78, 62, 55};
		
		
		
		while (true) {
			System.out.print("과목 입력 : ");;
			String subName = sc.next();
			
			if (subName.equals("그만")) {
			break;	
			} 
			
			for (int i = 0; i < subjectArr.length; i++) {
				if (subName.equalsIgnoreCase(subjectArr[i])) {
					System.out.println(subjectArr[i] + " : " +scoreArr[i]);
				} else {
					System.out.println("다시");
					break;
				}
			}
			
			
		}
		sc.close();
		
	}
}
