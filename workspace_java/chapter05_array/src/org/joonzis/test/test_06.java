package org.joonzis.test;

import java.util.Scanner;

public class test_06 {
	public static void main(String[] args) {
//		Test08.java
//		Q. 성적 관리 프로그램 
//		5명의 int형 점수를 저장하는 scores 배열을 선언하고, 점수를 입력받아 최대, 최소, 평균 점수를 출력하기
//		String형 배열 names를 선언하고, 학생 5명의 이름을 초기화 한 뒤 활용
//		실행 예)
//		바트의 점수 입력 >> 70
//		리사의 점수 입력 >> 100
		
		Scanner sc = new Scanner(System.in);
		
		String names[] = new String[5];
		
		int arr[] = new int[5];
		int sum3 = 0;
		
		// 입력받기
		for (int i = 0; i < arr.length; i++) {
			System.out.print("이름 입력  : ");	//이름
			names[i] = sc.next();
			
			System.out.print("점수 입력 : ");		//점수
			arr[i] = sc.nextInt();
			sum3 += arr[i];
		}
		// 이름 점수 표출
		for (int i = 0; i < arr.length; i++) {
			System.out.print("이름 : " + names[i]+ ", " + arr[i] + " 점  ");
		}
		
		// 최솟값 최대값
		
		int sum1 = arr[0];
		int sum2 = arr[0];
		String sum4 = names[0]; //최대점수 받은사람 이름 출력을 위해
//		int sumitx = 0;  // 강사님이 주신 답
		
		for (int i = 1; i < arr.length; i++) {
			if (sum1 < arr[i]) {
				sum1 = arr[i];
				sum4 = names[i]; //최대 점수 받은사람 이름 입력
//				sumitx = i; // 강사님이 주신 답
			} 
		}
		for (int i = 1; i < arr.length; i++) {
			if (sum2 > arr[i]) {
				sum2 = arr[i];
			} 
		}
		
		
		//평균
		double avg = sum3 / arr.length;
		// 표출
		System.out.println("\n 최대 점수 : "+ sum1 + " 이름 : " + sum4);	//강사님이 주신답이면 names[sumitx] 넣기
		System.out.println("\n 최소 점수 : "+ sum2);	
		System.out.println("\n 평균 : "+ avg);	
		
		sc.close();
	}
}
