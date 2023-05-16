package org.joonzis.ex;

public class Ex05_2D_array {
	public static void main(String[] args) {
		/*
		 * 가변형 2차원 배열
		 * 	1. 행만 고정하고 열이 고정되어 있지 않은 배열
		 * 	2. 선언 방법
		 * 		int[][] arr = new int[3][];		// 3행 n열
		 *  	arr[0] = new int[3];			// 0행 3열
		 *  	arr[1] = new int[2];			// 1행 2열
		 *  	arr[2] = new int[4];			// 2행 4열
		 *  (고정형과 가변형의 코드차이는 없다!!)
		 */
		
		// 3행 n열 정수형 배열
		int[][] arr = {
				{1,2,3},
				{4,5},
				{6,7,8,9}
		};
		
		
		// i : 행, j : 열
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
		
		// 위 배열 arr 의 모든 값의 합계를 출력
		int sum = 0;
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				sum += arr[i][j];
			}
		}
		System.out.println("arr 배열의 합계 : " + sum);
		 
		
	}
}
