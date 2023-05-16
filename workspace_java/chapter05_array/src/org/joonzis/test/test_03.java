package org.joonzis.test;

import java.util.Scanner;

public class test_03 {
	public static void main(String[] args) {
//		Test04.java
//		Q. 길이가 5인 int형 배열 선언 후, 사용자로부터 콘솔입력 받아 해당 데이터 값을 모두 더해서 합을 출력하기 
	
		Scanner sc = new Scanner(System.in);
		
		int arr[] = new int[5];
		
		 
		int a = 0;
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print("입력 : ");
			arr[i] = sc.nextInt();
			
			a += arr[i];
		}
		System.out.println(a);
		
		sc.close();
	}
}
