package org.joonzis.ex;

import java.util.Scanner;

public class Ex03_String_array {
	public static void main(String[] args) {
		/*
		 *  String 배열
		 *  
		 *  1. 문자열을 여러 개 저장하기 위해 사용한다.
		 *  2. 일반적으로 한 번 문자열이 저장되면 수정될 일이 없다.
		 *  3. 수정될 일이 없다면 for-each문을 활용 하는 것이 좋다.
		 *  
		 *  1) 선언
		 *  	(1)String 클래스는 객체를 생성해도 되고 안해도 된다.
		 *  	(2)객체를 생성시 힙 영역 내의 String constant pool 이라는 곳에 저장되고
		 *  	이미 존재하는 문자열이 있으면 그 인덱스 번호를 가리키게 된다.
		 *  	(3)객체를 생성하면 힙 내의 해당 객체의 레퍼런스 주소를 가지게 된다.
		 */
		
		// 크기 3의 문자열 배열 names를 생성한 뒤
		// 스캐너로부터 입력 받아
		// "입력한 이름 : OO" 출력 -> (일반 for, for-each)
		
		Scanner sc = new Scanner(System.in);
		String[] names = new String[3];
		
		// 입력 for문
		for(int i=0; i<names.length; i++) {
			System.out.print("이름 입력 >> ");
			names[i] = sc.nextLine();
		}
		// 출력 for문
//		for(int i=0; i<names.length; i++) {
//			System.out.println("입력한 이름 : " + names[i]);
//		}
		for(String name : names) {
			System.out.println("입력한 이름 : " + name);
		}
		
		
		
		sc.close();
		
		
		
		
		
	}
}
