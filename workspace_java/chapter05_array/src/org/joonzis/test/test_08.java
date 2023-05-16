package org.joonzis.test;


import java.util.Scanner;


public class test_08 {
	public static void main(String[] args) {
//		Test10.java
//		Q. 5줄로 된 교실이 있다. 각 줄마다 학생 수가 다르다.
//		   예시)	1줄 : 3명
//		   	  	2줄 : 4명
//		   	  	...
//		   	  	5줄 : 5명
//		   	  	각 줄마다 존재하는 학생 수를 입력 받아 학생 수 만큼만 공간을 할당하여 2차원 배열을 생성하시오.
//		   	  	생성 확인을 위해 할당된 공간에 정수 1을 저장하고 출력하시오.
//				★ 줄은 행을 뜻함
//		실행 예)
//		1행 >>1
//		2행 >>2
//		3행 >>3
//		4행 >>4
//		5행 >>5
//		1	
//		1	1	
//		1	1	1	
//		1	1	1	1	
//		1	1	1	1	1
		Scanner sc = new Scanner(System.in);
		
		
		int arr[][] = new int[5][];

		
		// 배열 학생수 입력 , 배열 값 1 넣기
		for (int i = 0; i < arr.length; i++) {
			
			System.out.print("학생 수 : ");
			arr[i] = new int[sc.nextInt()];
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = 1;
				
			}
		}
		// 배열 출력하기 
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t"); //  배열 출력
			}
			System.out.println(); //줄바꿈
		}
		sc.close();
	}
}
