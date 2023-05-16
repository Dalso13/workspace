package org.joonzis.ex;

public class Ex01_RectMain {
	public static void main(String[] args) {
		Ex01_Rect rect = new Ex01_Rect();
		Ex01_Rect rect1 = new Ex01_Rect(3);
		Ex01_Rect rect2 = new Ex01_Rect(3,4);
		
		rect.output();
		System.out.println("-----------------");
		rect1.output();
		System.out.println("-----------------");
		rect2.output();
	}
}
