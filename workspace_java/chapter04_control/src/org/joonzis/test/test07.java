package org.joonzis.test;

import java.util.Scanner;

public class test07 {
	public static void main(String[] args) {
//		Test09.java (switch문)
//		Q. 월을 입력 받아 일을 출력하기
//			실행 예)
//			월 입력 >> 10
//			출력 : 10월은 31일 까지 있습니다.
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("월 입력 : ");
		int num = sc.nextInt();
		
//		switch (num) {
//		case 1:System.out.println("1월은 31일 까지 있습니다.");
//			
//			break;
//		case 2:System.out.println("2월은 28일 까지 있습니다.");
//		
//			break;
//		case 3:System.out.println("3월은 31일 까지 있습니다.");
//		
//			break;
//		case 4:System.out.println("4월은 30일 까지 있습니다.");
//		
//			break;
//		case 5:System.out.println("5월은 31일 까지 있습니다.");
//		
//			break;
//		case 6:System.out.println("6월은 30일 까지 있습니다.");
//		
//			break;
//		case 7:System.out.println("7월은 31일 까지 있습니다.");
//		
//			break;
//		case 8:System.out.println("8월은 31일 까지 있습니다.");
//		
//			break;
//		case 9:System.out.println("9월은 30일 까지 있습니다.");
//		
//			break;
//		case 10:System.out.println("10월은 31일 까지 있습니다.");
//		
//			break;
//		case 11:System.out.println("11월은 30일 까지 있습니다.");
//		
//			break;
//		case 12:System.out.println("12월은 31일 까지 있습니다.");
//		
//			break;	
//		
//
//		default: System.out.println("정확한 숫자를 입력해주세요");
//			break;
//		}
		
		switch (num) {
		case 2:System.out.println(num + "월은 28일 까지 있습니다.");
			
			break;
		case 4:		
		case 6:		
		case 9:
		case 11:System.out.println(num + "월은 30일 까지 있습니다.");	
			break;
		
		case 1:		
		case 3:		
		case 5:		
		case 7:		
		case 8:
		case 10:
		case 12:System.out.println(num + "월은 31일 까지 있습니다.");	
			break;	

		}
		
		
		sc.close();
	}
}
