package org.joonzis.test;

import java.util.Scanner;

public class Ex_test01 {
	public static void main(String[] args) {
		
//		Test01.java
//		Q. 두 정수를 입력받아 a, b에 저장한 뒤 두 변수의 값을 교환하는 프로그램 구현
//			* 임시 변수 필요

		
		Scanner num = new Scanner(System.in);
		System.out.print(" a 입력 : ");
			int a = num.nextInt();
		System.out.print(" b 입력 : ");
			int b = num.nextInt();
		
			System.out.println("a = " + (a*b)/a);
			System.out.println("b = " +(a*b)/b);
			
			num.close();
			
//			int c = a;
//			
//			a = b;
//			
//			b = c;
//			
//			System.out.println(a);
//			System.out.println(b);
				
		
	}
}
