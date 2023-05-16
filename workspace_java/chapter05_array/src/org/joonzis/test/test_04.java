package org.joonzis.test;

import java.util.Scanner;

public class test_04 {
	public static void main(String[] args) {
//		Test05. java
//		Q. int[] arr = {13, 22, -3, 92, 55, 5}
//			배열에서 값을 바꾸고 싶은 인덱스 2개를 선택하여
//			서로 값을 바꾸어 값들을 출력
		
		
		int arr[] = {13, 22, -3, 92, 55, 5};
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1");
		int a1 = sc.nextInt();
		
		System.out.println("2");
		int a2 = sc.nextInt();
		
		int tmp = 0;
		tmp = arr[a1];
		arr[a1] = arr[a2];
		arr[a2] = tmp;
			
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");

		}	
		
//		Test06.java
//		Q. Test05의 배열을 이용하여 배열 내 값들의 최소, 최대값을 출력
		int max = arr[0];
		int min = arr[0];
		
		for (int i = 1; i < arr.length; i++) {
			if (max < arr[i]) { 
					max = arr[i];
				}
				
		} 	
		for (int i = 1; i < arr.length; i++) {
			if (min > arr[i]) {
				min = arr[i];
			}
			
		}
		System.out.println("\n 최대 값 : "+ max);	
	
		System.out.println("\n 최소 값 : "+ min);	
		
		sc.close();
	}		
}
