package org.joonzis.ex;

public class Ex06_StringBuffer {	// StringBuffer나 StringBuilder 나 똑같음
	public static void main(String[] args) {
		
		StringBuffer sb1 = new StringBuffer("apple");
		StringBuffer sb2 = new StringBuffer("apple");
		
		System.out.println("sb1 해시코드값(주소값) : " + sb1.hashCode());
		System.out.println("sb2 해시코드값(주소값) : " + sb2.hashCode());
		
		// 검색 : 해시코드 비교 -> (같은 해시코드만 ) 동등 비교
		
		StringBuffer sb = new StringBuffer();
		System.out.println("기본 버퍼 크기 : " + sb.hashCode());
		// .capacity() : 버퍼 크기 알아볼 때 ! 기본은 16문자를 저장할 수 있다.
		
		// sb에 문자열 추가
		// .appent(추가할 값)
		sb.append("hello");
		sb.append(" java").append(" world"); // chaining 기법 : 계속 이어서 값을 추가
		System.out.println(sb);
		
		// 삭제
		StringBuffer phone = new StringBuffer();
		phone.append("010-1234-5678");
		phone.deleteCharAt(3);
		phone.deleteCharAt(7); // 위에서 짜르면 인덱스 번호도 당겨짐
		System.out.println(phone);
	}
}
