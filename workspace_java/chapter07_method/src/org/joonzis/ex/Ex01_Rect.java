package org.joonzis.ex;

public class Ex01_Rect {
		//필드
	int width;
	int height;
	boolean isSquare; // 정사각형 유무 - 정사각형 true : 직사각형 false
	
		// 메소드
		// 필드 초기화 메소드
	void setFields(int w, int h) {
			width = w;
			height = h;
			isSquare = w==h ;
	}
	void setFields(int side) {
		width = side;
		height = side;
		isSquare = true;
	}
		// 사각형 크기 계산하는 메소드
	int caleArea() {
		return width * height;
		
	}
	
	
		//  정보 출력 메소드
	void output() {
		System.out.println("너비 : " + width);
		System.out.println("높이 : " + height);
		System.out.println(isSquare ? "정사각형" : "직사각형");
		System.out.println("크기 : " + caleArea() );
		
	}
	
	
}
