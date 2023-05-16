package org.joonzis.ex;

public class Ex04_String {
	public static void main(String[] args) {
		
		/*
		 * 문자열 (기본 자료형 x)
		 * 	(1) 참조 자료형
		 * 	(2) 값을 저장하지 않고, 주소(참조)를 저장하는 자료형 (포인터)
			(3) 사용 방법
			String str1 = "Hello";
			String str2 = new String("Java"); - 일반적인 참조자료형의 사용형태
		 */
		
		
		String str1 = "Java";
		
		System.out.println(str1.toLowerCase());      // 소문자 변환
		System.out.println(str1.toUpperCase());		// 대문자 변환
		System.out.println(str1.indexOf('v'));		//** 지정 문자의 index 번호 반환
		System.out.println(str1.charAt(2));			//** 지정된 index의 문자 반환
		System.out.println(str1.startsWith("J"));	// 지정된 문자열로 시작되는지(boolean = 참거짓 구분)
		System.out.println(str1.endsWith("a"));		// 지정된 문자열로 끝나는지(boolean)
		System.out.println(str1.contains("a"));		//** 지정된 문자열을 포함하는지(boolean)
		System.out.println(str1.substring(1));		//** 지정한 index 부터 모든 문자열을 반환
		System.out.println(str1.substring(1, 3));	// 지정한 첫 번쨰 index 부터 두 번째 index 직전 까지의 문자열을 반환
		
		
		String str2 = "    Java   ";
		System.out.println("*" + str2.trim() + "*");  // 문자열의 양쪽 공백 제거 * 는 표시를 위해 넣음
		
		String str3 = "Ja-va";
		String[] s = str3.split("-"); 
		System.out.println(s.length);		// 지정한 문자를 분리하여 배열로 반환
		
		
		if(str1.equals(str2)) {          // 두 개의 문자열을 비교(boolean)
			System.out.println(true);
		}else {
			System.out.println(false);
			}
		
//		String str = new String("")
		
//		String str4;
//		System.out.println(str4.isEmpty());   // 메소드 사용 불가(초기화 필요)
		
		String str5 = "";
		System.out.println(str5.isEmpty()); 	// 문자열 변수의 값이 있는지 (boolean)
 				
//		String str6 = null;			
//		System.out.println(str6.isEmpty());     // 실행 후, nullpointer 에러 발생
		
	}
}
