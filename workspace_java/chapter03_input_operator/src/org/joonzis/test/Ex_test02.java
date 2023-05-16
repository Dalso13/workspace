package org.joonzis.test;

import java.util.Scanner;

public class Ex_test02 {
		public static void main(String[] args) {
			
//			Test02.java
//			Q. 나이를 입력받아 "성인" 또는 "미성년자" 출력
			
			
			Scanner num = new Scanner(System.in);
			
			System.out.print("나이 입력 : ");
			int age = num.nextInt();
			
			System.out.println( age >= 20 ? "성인" : "미성년자" );
			
			num.close();
			
		}
}
