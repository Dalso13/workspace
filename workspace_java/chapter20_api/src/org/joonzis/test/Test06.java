package org.joonzis.test;

import java.math.BigInteger;

public class Test06 {
//	 Q6.Test06.java
//	 1! ~ 99! 까지 전체 결과를 출력하시오.
//	 1! (1 팩토리얼) = 1
//	 2! (2 팩토리얼) = 1 * 2 = 2
//	 3! (3 팩토리얼) = 1 * 2 * 3 = 6
//	 4! (4 팩토리얼) = 1 * 2 * 3 * 4 = 24
//	 ...
//	 n!: (n-1) * n
//
//	 ex)
//	 1! = 1
//	 2! = 2
//	 3! = 6
//	 4! = 24
//	 5! = 120
//	 ...
//	 99!
	
	
	public static void main(String[] args) {
		
		
		for (int i = 1; i < 100; i++) { // 10번 반복
			BigInteger n = new BigInteger("1");	// n은 1고정
			
			for (int j = i; j >= 1; j--) { // j는 i의 값을 가지고 1이 될때까지 반복
				BigInteger s = new BigInteger(Integer.toString(j));
				
				n =	n.multiply(s);	// n은 n*s 를 s가 1이 될떄까지 반복
			}
			
			System.out.println( i +"! = "+ n);	//값 출력
			
		}
	}
}
