package org.joonzis.ex;

// 국내에 거주하는 사람
public class Ex02_Local {
	// 필드					// 초기화 상대 (필드값은 초기화 되어있다.)
	String name;			// null
	int age;				// 0
	String sn;				// null		// 주민등록번호
	boolean isKorean;		// false	// 한국인 true : 외국인 false

	// 메소드
	void setLocalInfo(String a1, int b1, String c1) { 		//이름 , 나이, 주민등록번호 전달받음
		// 이름, 나이, 주민등록번호를 전달받아 초기화
		// 주민등록번호 뒷 자리의 첫 번째 값이 1~4 일 경우 한국인
		name = a1;		//이름
		age = b1;		//나이
		sn = c1;		//주민등록번호
		int c2 = Integer.valueOf(sn.substring(7,8));		//문자열 꺼내기
		isKorean = c2 >= 1 && c2 <= 4 ? true : false;	//int로 바꾼후 계산
	}
	void setLocalInfo(String a1, int b1) {			//이름 , 나이	전달받음
		// 이름, 나이를 전달받아 초기화
		name = a1;		//이름
		age = b1;		//나이

	}
	void output() {
		// 이름, 나이, 주민등록번호, 한국인or외국인 출력
		// 주민등록번호가 없으면 "없음" 으로 출력
		System.out.print(name);
		System.out.print(" " + age + " ");
		System.out.print(sn == null ? "없음" : sn);
		System.out.print(" " + (isKorean ? "한국인" : "외국인"));
		
		
	}





}
