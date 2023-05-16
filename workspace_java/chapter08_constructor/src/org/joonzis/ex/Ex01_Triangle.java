package org.joonzis.ex;

public class Ex01_Triangle {
	/*
	 *  필드
	 *  - width, height
	 *  
	 *  메소드
	 *  - 생성자
	 *  	1. 기본 생성자 - 너비, 높이 1로 고정 값 대입
	 *  	2. 풀 생성자 - 너비, 높이 값 전달 받아 값 대입
	 *  - caleArea() : 계산 후 값 리턴
	 *  - output() : 너비, 높이, 크기 출력
	 */
	int width;
	int height;
	
	
	
	public Ex01_Triangle() {
		width = 1;
		height = 1;
		
	}
	public Ex01_Triangle(int w, int h) {
		width = w;
		height = h;
		
	}
	
	void output() {
		System.out.println("너비 : " + width);
		System.out.println("높이 : " + height);
		System.out.println("크기 : " + caleArea());
	}

	
	
	double caleArea(){
		return width * height /2.0;
	}

	
}
