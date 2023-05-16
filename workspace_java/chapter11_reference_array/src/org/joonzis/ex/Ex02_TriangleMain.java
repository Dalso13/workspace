package org.joonzis.ex;

import java.util.Scanner;

public class Ex02_TriangleMain {
	public static void main(String[] args) {
		
		/*
		 * 	1. 크기 3의 참조(Ex02_Triangle) 배열 arr 선언
		 * 	2. 반복문을 이용하여 객체를 생성함과 동시에 값을 초기화 시킨다(스캐너 이용)
		 * 	3. 반복문을 이용하여 각 객체의 정보 출력
		 * 
		 * 
		 *  EX)	입력 :	너비 입력 >> 3
		 *  			높이 입력 >> 5
		 *  (반복)
		 *  
		 *  	출력
		 *  		1번 삼각형
		 *  
		 *  		너비 : 3
		 *  		높이 : 5
		 *  		크기 : 7.5
		 *  		(반복)
		 *  
		 */
		
		
		Ex02_Triangle arr[] = new Ex02_Triangle[3];
		
		
		for (int i = 0; i < arr.length; i++) {
			Scanner sc = new Scanner(System.in);
			System.out.print("너비 : ");
			int w = sc.nextInt();
			System.out.print("높이 : ");
			int h = sc.nextInt();
			
			arr[i] = new Ex02_Triangle(w,h);	
			System.out.println("--------------");
		}

		for (Ex02_Triangle arrs : arr) {
			arrs.output();
			System.out.println("----------------");
		}
		
		
		
		
		
		
		
	}
}
