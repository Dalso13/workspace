package org.joonzis.ex;

public class Ex03_while {
	public static void main(String[] args) {
		/*
		 * 1. 형식
		 * 
		 * 		while(조건식){
		 * 			반복실행문;
		 * 		}
		 * 
		 * 2. 특징
		 * 	1) 조건식을 만족하지 않는다면 한 번도 실행이 안 될 수 있다.
		 * 	2) 반복실행문이 없는 경우엔 while (조건식); 과 같은 형식으로 사용한다.
		 *  3) 무한루프는 while(true){} 과 같은 형식으로 사용한다.
		 */
		
		// 숫자 0~9 까지 화면에 출력
		
		int num = 0;
		while(num < 10) {
			System.out.println(num);
			num++;
		}
		
		
		
		
		
		
		
	}
}
