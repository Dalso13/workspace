package org.joonzis.test;

public class test03_RecursiveCall {
//	Q3.
//	클래스 RecursiveCall 을 정의하시오.
//	- 필드  : X
//	- 메소드 : recursive(n) -> n번 "Hello" 출력하기
//			 main
//	★
//	if-else 사용 - else 일 때 재귀 호출
	
		void recursive(int a) {
			
		a++;
		if (a <= 10) {	
		System.out.println("Hello");
		} else {
			return;
		}
		recursive(a);
		
		
	}
	
}
