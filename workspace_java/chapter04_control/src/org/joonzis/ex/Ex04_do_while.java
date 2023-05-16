package org.joonzis.ex;

public class Ex04_do_while {
	public static void main(String[] args) {
		/*
		 * 1. 형식
		 * 		do{
		 * 		 	반복실행문;
		 * 		} while (조건식);
		 * 
		 * 2. 특징
		 * 	1) 반드시 한 번은 실행되는 반복문이다.
		 *  2) 나머지 특징은 while 문이다.
		 */
		
		// 0~9까지 숫자 화면에 출력
		
		int num = 0;
		do {
			System.out.println(num);
			num++;
		} while (num < 10);
		
		
		
		
		
	}
}
