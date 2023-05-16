package org.joonzis.test;

import java.util.Scanner;

public class test02 {
	public static void main(String[] args) {
//		Test02.java
//		Q. 필기와 실기 점수를 입력 받아 합격 유무 출력하기
//			합격기준: 필기와 실기 점수 모두 70점 이상이거나, 평균이 80 이상시 "합격" 아니면 "불합격"
			
		Scanner sc = new Scanner(System.in);
		
		System.out.print("필기 점수 : ");
		int num = sc.nextInt();
		System.out.print("실기 점수 : ");
		int num2 = sc.nextInt();
		
			//논리식 사용
		if((double)(num + num2)/2 >= 80) {
			System.out.println("합격");
		} else if(num >= 70 && num2 >= 70) {
			System.out.println("합격");
		} else {
			System.out.println("불합격");
		}
		
			//논리식 사용x
		 if((double)(num + num2)/2 >= 80) {
			System.out.println("합격");
		 } else if(num >= 70) {
			if(num2 >= 70) {
				System.out.println("합격");
			}	
		} else {
			System.out.println("불합격");
		}
		
		sc.close();
	}
}
