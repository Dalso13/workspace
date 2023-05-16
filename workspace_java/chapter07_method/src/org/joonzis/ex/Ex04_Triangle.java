package org.joonzis.ex;

public class Ex04_Triangle {
	int width;
	int height;
	
	void setFields(int w, int h) {
		width = w;
		height = h;
	}
//	
//	// 아래 두 calcArea 메소드가 오버로딩 되지 않은 이유
//	// 리턴 타입이 다를뿐 매개변수 : () 가 다르진 않아서 오류가 남
//	int calcArea() {		// 일부러 오류 냄
//		return width * height / 2;
//	}
//	
//	double calcArea() {
//		return width * height / 2.0;
//	}
}
