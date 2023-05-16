package org.joonzis.test02;

public class test13 {

	
	public static void main(String[] args) {
		
		//	Test05.java
		//	Q. 1 ~ 100 사이의 모든 정수 합계 출력하기
		
//		int sum=0;
			//	 for 문
//		
//			for (int i = 1; i <= 100; i++) {
//			sum +=  i;
//			}
			
			//	while 문
		
//		int i = 1;
//				
//		while (i<= 100) {
//			sum +=  i;
//			i++;
//		}		
//		System.out.println(sum);
		
		// --------------------------------------------------
		// 1부터 100 사이의 모든 정수 중 "짝수"의 합과 "홀수"의 합을 각각 구하여 출력하시오.
		
		int sumOdd = 0;
		int sumEven = 0;
		
//		for (int i = 0; i <= 100 ;  i++) {
//				
//			sumEven += i;
//			i++;	
//			
//		}
//		for (int i = 1; i <= 100 ;  i++) {
//			
//			sumOdd += i;
//			i++;
//			
//		}
		
		for (int i = 1; i <= 100 ;  i++) {
			if (i % 2 == 0) {
				sumEven += i;
				
			} else {
				sumOdd += i;
			}
		}
		
		System.out.println("짝수의 합 : " + sumEven);
		System.out.println("홀수의 합 : " + sumOdd);
		
		
		
	
	}
				
}