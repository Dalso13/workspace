package org.joonzis.test;

import java.util.Scanner;

public class test04 {
	public static void main(String[] args) {
//		Test05.java
//		Q. 문자를 하나 입력 받아 "대문자", "소문자", "아라비아 숫자", "일반 문자" 구분해서 출력하기
//		     아스키 코드표 참고
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자 입력 : ");
		
		char num = sc.next().trim().charAt(0);
					
		// 내가 만든 표
		
//		String num3 = "" + num;
//		
//		int num2 = (int)num;
//		
//		
//		
//		if(num2 > 122) {
//			System.out.println(num);
//			}
//		if(num2 >= 97)	{
//			System.out.println(num3.toUpperCase() + "대문자");
//			}
//		if(num2 >= 65) {
//			System.out.println(num3.toLowerCase() + "소문자");
//			}
//		if(num2 <= 64) {
//			System.out.println(num);
//		}
//		
		
		// 답안
		
		if(num >= 'A' && num <= 'Z') {
			System.out.println("대문자");
		} else if(num >= 'a' && num <= 'z') {
			System.out.println("소문자");
		} else if(num >= '0' && num <= '9') {
			System.out.println("아라비아 숫자");
		} else {
			System.out.println("문자");
		}
		
		sc.close();
	}	
}

