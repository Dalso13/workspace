package org.joonzis.ex;

import java.util.Scanner;

public class Ex02_for_each {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[3];
		/*
		// 배열에 값 저장 방법
		// 1. 개별적으로 한 개씩 삽입
		arr[0] = sc.nextInt();
		arr[1] = sc.nextInt();
		arr[2] = sc.nextInt();
		
		// 2. 반복문 이용 - 삽입
		for(int i=0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		// 출력
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		// for-each문(향상 for문)
		for(int num : arr) {			// arr 배열의 각 요소를 num이라는 변수로 전달해서 처리
			System.out.println(num);	// 위에서 입력 받은 arr가 순차적으로 num으로 넘어옴
		}
		*/
		
		
		// 주의사항
		int[] arr2 = new int[3];
		// for-each 문을 통한 입력
		// 기본 자료형의 배열은 for-each문으로 배열의 수정이 불가능 하다
		// 배열에 직접 접근하지 않고, 배열 요소의 값을 다른 변수로 받아 처리하기 때문
		for(int num : arr2) {
			System.out.print("입력 >> ");
			num = sc.nextInt();
		}
		// arr2 배열 출력
		for(int num : arr2) {
			System.out.println(num);
		}
		
		
		
		
		
		
		
		
		
		
	}
}
