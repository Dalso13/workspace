package org.joonzis.ex;

import java.util.Random;

public class Ex01_Random {
	public static void main(String[] args) {
		/*
		 * 	Random 클래스
		 * 1. 객체(인스턴스) 생성을 한다.
		 * 2. 객체(인스턴스)의 메소드 호출로 난수를 발생시킨다
		 * 		1) nextInt()		: int 형 범위 내의 난수 발생
		 * 		2) nextBoolean()	: true or false
		 * 		3) nextLong()		: long형 범위 내의 난수 발생
		 * 		4) nextFloat()		: 0	~ 0.9999까지의 난수 살생 (0이상 1미만)
		 * 		5) nextDouble()		: 0	~ 0.9999까지의 난수 살생 (0이상 1미만)	
		 */
		
		
		Random ran = new Random();
		
		System.out.println(ran.nextInt());
		System.out.println(ran.nextInt(10));		// 난수 발생(0~9)
		
		// 1~6 사이의 난수 출력(int)
		
		System.out.println(ran.nextInt(6)); // 6개 중에서 1개 난수 발생(0~5)
		System.out.println(ran.nextInt(6)+1); // 6개 중에서 1개 난수 발생(1~6)
		
		System.out.println(ran.nextDouble());		// 0 ~ 0.9999999
		System.out.println(ran.nextDouble()*10);		// 0 ~ 9.9999999
		System.out.println((int)(ran.nextDouble()*10));		// 0 ~ 9
		
		// 1 ~ 6 사이 랜덤 출력 (double)
		System.out.println((int)(ran.nextDouble()*6) + 1);
		
		/*
		 * 	Math 클래스
		 * 1. Math.random() 함수(메소드)는 내부적으로
		 * 	Random 클래스의 nextDouble() 메소드를 사용한다
		 * 	0~0.9999 까지의 난수 발생 (0이상 1미만)
		 */
		
		int rnd = ((int)(Math.random()*6)+1);
		System.out.println(rnd);
	}
}
