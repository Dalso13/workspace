package org.joonzis.ex;


public class Ex07_exception {

	
	public static void divide(int num1, int num2) throws ArithmeticException {
		System.out.println("몫 : " + (num1 / num2));
		System.out.println("나머지 : " + (num1 % num2));
		
	}
	
	// try-catch 하기 싫으면 떠넘기자 쓸때도 있지만 메인에서 처리하는건 좋은 방식은 아님
	public static void main(String[] args) throws ArithmeticException {
			divide(5, 2);
			divide(5, 0);
	}
}
