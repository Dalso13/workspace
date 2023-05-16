package org.joonzis.test02;

import java.util.Scanner;

public class test14 {
//	Test06.java
//	Q. 1부터 입력 받은 양수 사이의 모든 정수의 합계 출력하기
//	      입력 받은 수가 2이상이 아니면 다시 입력 받도록 처리
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int sum = 0;
		int num2 = 0;
		
		while (true) {
				System.out.print("양수 입력 : ");
				num2 = sc.nextInt();		//전역 변수를 수정
			
				if (num2 >= 2) {	
							break;	
				}	else if (num2 < 2) {
				System.out.println("다시 입력하세요");
				} 
			}
		
		
			
					
		for (int i = 1; i <= num2 ; i++) {
				sum += i;		
			}
		
		System.out.println(sum);

			sc.close();
		
		
	}
}
