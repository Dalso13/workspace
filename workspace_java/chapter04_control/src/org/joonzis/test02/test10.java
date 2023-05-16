package org.joonzis.test02;

public class test10 {
	public static void main(String[] args) {
//		Test03.java
//		Q. 전체 구구단 출력하기_1
//		ex) 2x1 = 2
//			2x2 = 4
//			...
//			9x9 = 81
			//for문
		
//		for (int i = 2; i <= 9 ; i++) {
//			for (int j = 1; j <= 9; j++) {
//				System.out.println(i + "X" + j + "=" + i*j);
//				
//			}
//			
//		}
		
		//while 문
		int i = 2;
		
		while(i <= 9 ) {
			int j = 1;
			while (j <= 9) {
				System.out.println(i + "X" + j + "=" + i*j);
				j++;
			}
			i++;
			
		}
	}
}
