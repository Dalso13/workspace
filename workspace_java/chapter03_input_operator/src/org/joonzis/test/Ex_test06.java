package org.joonzis.test;

import java.util.Scanner;

public class Ex_test06 {
	public static void main(String[] args) {
//		Test06.java
//		Q. 섭씨 화씨 변환기
//		      섭씨를 입력하면 변환된 화씨, 화씨를 입력하면 변환된 섭씨 출력하기
//		★화씨 = 섭씨 * 1.8 +32
//		  섭씨 = (화씨 -32) / 1.8
		
		Scanner ipt = new Scanner(System.in);
		
		System.out.print("온도 적기 : ");
		double su = ipt.nextDouble();
		
		
		
		System.out.println
		( "섭씨 일 경우 화씨로 변환 : " + Math.round((su * 1.8 + 32)*100)/ 100.00 + 
				" , " 
				+ "화씨 일 경우 섭씨로 변환 : "+ Math.round(((su - 32) / 1.8 )*100) /100.00 );
		
		ipt.close();
	}
}
