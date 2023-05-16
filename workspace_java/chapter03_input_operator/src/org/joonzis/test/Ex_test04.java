package org.joonzis.test;

import java.util.Scanner;

public class Ex_test04 {
	public static void main(String[] args) {
		
//		Test04.java 
//		Q. 성별을 의미하는 정수 값(1,3:남자, 2,4:여자)을 입력받아 "남자", "여자"출력하기
//			* 1~4 사이의 값으로 입력 받기 
//			* 홀수-남자 짝수-여자
		
		
		Scanner ipt = new Scanner(System.in);
				
				System.out.print("성별에 해당하는 숫자 입력 남자 1,3  여자 2,4 : ");
				int gender = ipt.nextInt();
				
				
//				boolean ks = (gender == 1) || (gender == 3);
//				
//				if (ks) {System.out.println("남자");
//					} else {System.out.println("여자");}
				
				String ks = (gender % 2 == 1) ? "남자" : "여자";
				
				System.out.println("성별 : " + ks);
				
				
				ipt.close();
	
	
		}			
	}

