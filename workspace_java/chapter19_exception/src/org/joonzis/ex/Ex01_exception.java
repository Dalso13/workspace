package org.joonzis.ex;

import java.util.Scanner;

public class Ex01_exception {
	
	/*
	 *  ArithmeticException
	 *  정수를 0으로 나눌 경우 예외 발생
	 */
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		int num1,num2;
		
		try {
			
			System.out.println("정수1 입력 : ");
			num1 = sc.nextInt();
			System.out.println("정수2 입력 : ");
			num2 = sc.nextInt(); 	// 0 입력시
			
			System.out.println("덧셈 결과 : " + (num1 + num2));
			System.out.println("뺼셈 결과 : " + (num1 - num2));
			System.out.println("곱셉 결과 : " + (num1 * num2));
			System.out.println("나눗셈 결과 : " + (num1 / num2));	// 해당 위치에서 예외 발생
			
		} catch (ArithmeticException e) {	// Exception e 로 넣어도 된다.
			e.printStackTrace();	// 에러 문구 출력
			System.out.println("0으로 나눌 수 없습니다.");
		} finally {
			if(sc != null) {
				sc.close();
			}
		}
		
		
		
		
	}
}
