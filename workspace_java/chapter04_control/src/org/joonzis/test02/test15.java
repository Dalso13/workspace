package org.joonzis.test02;

import java.util.Scanner;


public class test15 {
	public static void main(String[] args) {
//		Test07.java
//		Q.두 정수를 입력 받아 두 정수 사이의 모든 정수의 합계 출력하기
//		    입력 순서와 무관하게 동일한 결과를 출력 
//		 	실행 예1)
//			첫 번째 정수 >> 1
//			두 번째 정수 >> 10
//			1부터 10까지 모든 정수의 합은 55입니다.
//			실행 예2)
//			첫 번째 정수 >> 10
//			두 번째 정수 >> 1
//			1부터 10까지 모든 정수의 합은 55입니다.
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫 번째 정수 입력 : ");
		int num = sc.nextInt();
		
		System.out.print("두 번쨰 정수 입력 : ");
		int num2 = sc.nextInt();
		
		int sum = 0;
		
			// 내가 만든거 1
		
//		if (num > num2) {
//			
//			for (int i = num2; i <= num; i++) {
//				
//				sum += i;
//			}
//		} else if (num2 > num) {
//			for (int i = num ; i <= num2; i++) {
//				sum += i;
//			}
//		}
		
		// 내가 만든거 2
	 
		if (num > num2) {
			int num3 = num;			//값 변환
			num = num2;
			num2 = num3;		
		}
		for (int i = num; i <= num2; i++) {
				sum += i;
			}
		
		System.out.println(sum);
		
		sc.close();
	}
}
