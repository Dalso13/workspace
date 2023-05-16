package org.joonzis.test;

import java.util.Scanner;

public class Ex_test05 {
	public static void main(String[] args) {
//		*Test05.java
//		Q. 하이픈 없이 주민등록번호를 입력받아 (정수, 문자열) "남자","여자" 출력하기
//		* String의 메소드 이용하기
//		* ex) charAt(), substring() 등
		
		Scanner ipt = new Scanner(System.in);
		
		System.out.print("주민등록번호 - 없이 적기 :");
		String num = ipt.nextLine();
		
		

		
		String gender = num.substring(6 , 7);
//		boolean gen = (gender.equals("3")) || (gender.equals("1")); 문자열

		
		int sum = Integer.parseInt(gender);
		boolean gen = (sum % 2 == 1);  //정수
		
		
		System.out.println(gen ? "남자" : "여자");
		

	
		ipt.close();
	}
}
