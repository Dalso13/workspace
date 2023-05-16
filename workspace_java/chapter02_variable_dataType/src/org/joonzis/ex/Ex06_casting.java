package org.joonzis.ex;

public class Ex06_casting {
	public static void main(String[] args) {
		
		
		// 1. 자동 형 변환
		System.out.println(1 + 1.5);
		//자바 스스로 1.0 으로 변화후 연산
		
		double a = 10;
		System.out.println(a);
		// 자바 스스로 10.0으로 실수로 변환
		
		
		//2. 강제 형 변환
		int b = (int)20.7;
		System.out.println(b);
		
		int c = 1;
		int d = 2;
		double e = (double)c/d; //강제 형 변화(c) 자동 형 변환(d)
		
		
		
		System.out.println(e);
		
		
		
		
	}
}
