package org.joonzis.ex;

public class Ex04_2D_array {
	public static void main(String[] args) {
		/*
		 * 고정형 2차원 배열
		 * 	1. 행과 열이 고정되어 있는 2차원 배열
		 * 	2. 선언 방법
		 *		int[][] arr = new int[3][4];		// 3행 4열
		 *	3. 초기화 방법
		 *		int[][] arr = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		 *		int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		 */
		
		
		// 2행 3열 정수형 배열
		int[][] arr = {
				{1,2,3},
				{4,5,6}
		};
		
		
		// i : 행, j : 열
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
		
		
		
		
		
		
		
		
	}
}
