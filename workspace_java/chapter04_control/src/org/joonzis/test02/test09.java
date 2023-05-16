package org.joonzis.test02;

import java.util.Scanner;

public class test09 {
	public static void main(String[] args) {
//		Test02.java
//		Q. 입력받은 구구단만 출력하기
//		ex) 4X1=4
//			4X2=8
//			4X3=12
//			4X4=16
//			...
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자 입력 ");
		int num = sc.nextInt();
		
			// for 문	
		
//		for (int i = 1; i <= 9 ; i++) {
//			  if (num <= 9) {
//				 System.out.println(num + "X" + i + "=" + num*i);
//			}
//		}	 
		
			// while 문
		
		int i = 1;	
		
		while (i <= 9) {
				 System.out.println(num + "X" + i + "=" + num*i);
				 i++;
		}
			 
			
		sc.close();
		
	}
}
