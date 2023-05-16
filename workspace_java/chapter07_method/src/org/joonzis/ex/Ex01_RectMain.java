package org.joonzis.ex;

public class Ex01_RectMain {
	public static void main(String[] args) {
		
		// 1. 객체 생성
		
		Ex01_Rect r1 = new Ex01_Rect();
		
		r1.setFields(10, 20);
		r1.output();
		
		System.out.println("----------------------");
		
		Ex01_Rect r2 = new Ex01_Rect();
		r1.setFields(15);
		r1.output();
	}
}
