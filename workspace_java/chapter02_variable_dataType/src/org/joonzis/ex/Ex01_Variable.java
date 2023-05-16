package org.joonzis.ex;

public class Ex01_Variable {
	public static void main(String[] args) {
		
		// 1. 변수 선언 (선언과 초기화 동시 진행)
		int num = 0;
		float num2 = 0f;
		double num3 = 0;
		
		char ch = 0;
		char ch2 = 'a';
		int ch3 = 'a';  //"int"에 문자를 넣으면 아스키 코드로 변환
		
		String str1 = null;
		String str2 = "";  //둘다 공백 다만 둘의 차이 null은 주소값은 갖고있다 ""은 아님
		
		//밑은 위에껄 재선언 데이터 타입은 따로 적을필요가 없음
		
		num = 100;
		num2 = 1.5f;
		num3 = 1.5;
		ch = '한';
		str1 = "Hello";
		str2 = "Java";
		
		System.out.println(num);
		System.out.println(num2);
		System.out.println(num3);
		System.out.println(ch);
		System.out.println(str1);
		System.out.println(str2);
		
		// 3. 스코프 (범위)
		 // 1) 지역 변수 : 코드블록{} 내에서만 접근 가능,  벗어나면 소멸
		 // 2) 전역 변수 : 모든 지역에서 사용 가능
		
		{ 
			int a = 10;
			System.out.println("코드 블록 내의 a = " + a);
		}
		
		// a 변수가 하위 매소드로 넘어가서 변수 사용 불가 (접근 불가)
		//System.out.println("코드 블록밖의 a =" + a);
		
		
		
		
		
	}

}
