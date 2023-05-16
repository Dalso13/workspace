package org.joonzis.test;

import java.util.Scanner;

public class test_05 {
	public static void main(String[] args) {
//		Test07.java
//		Q. 길이가 10인 int형 배열 선언 후, 사용자로부터 콘솔입력 받아 값을 저장한 뒤
//			배열에 있는 정수 중에서 3의 배수만 출력해보자. 
		
		Scanner sc = new Scanner(System.in);
		
		int arr[] = new int[10];

		for (int i = 0; i < arr.length; i++) {
					System.out.print("입력 : ");
					arr[i] = sc.nextInt();
				}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 3 == 0) {
				System.out.println(arr[i]);
			}
		}
		sc.close();
	}
}
