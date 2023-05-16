package org.joonzis.test02;

public class test11 {
	public static void main(String[] args) {
//		Test04.java
//		Q. 전체 구구단 출력하기_2
//		ex) 2x1 = 2 	3x1 = 3 	...		9x1 = 9
//			2x2 = 4		3x2 = 6		...		9x2 = 18
//			...
//			2x9 = 18	3x9 = 27 	...		9x9 = 81
		
			//for 문
		
//		for (int i = 1; i <= 9 ; i++) {
//			for (int j = 2; j <= 9; j++) {
//				System.out.print(j + "X" + i + "=" + i*j + "\t");
//				
//			}
//			System.out.println();
//		}
		
			//while문
		int i = 1;
	
		while (i <= 9) {	
			int j = 2;
			while (j <= 9) {	
				System.out.print(j + "X" + i + "=" + i*j + "\t");
				j++;
			}
			System.out.println();
			i++;
		}

	}
}
