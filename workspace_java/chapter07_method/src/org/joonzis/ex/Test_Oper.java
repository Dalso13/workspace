package org.joonzis.ex;

public class Test_Oper {
	// 필드
	double val1, val2;
	
	// 두 값을 이용하여 사칙연산을 하는 클래스
	
	// 1. 두 값을 전달 받아 두 값의 합을 출력하는 plus 메소드
	// 2. 전역 변수 두 개의 차를 출력하는 minus 메소드
	// 3. 전역 변수 두 개의 곱을 출력하는 multi 메소드
	// 4. 전역 변수 두 개의 나눈 값을 리턴하는 div 메소드
	
	
	void plus(double num, double num2) {
		val1 =	num;
		val2 =	num2;
		
		System.out.println(val1 + val2);
	}
	
	void minus() {
		System.out.println(val1-val2);
	}
	void multi() {
		System.out.println(val1*val2);
		System.out.println(div());
		
	}
	double div() {
		return val1 / val2;
	}
}
