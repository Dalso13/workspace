package org.joonzis.ex;

public class Ex02_RectMain {
	public static void main(String[] args) {
		Ex02_Rect rect = new Ex02_Rect();
		rect.output();
		
		System.out.println("------------------------");
		
		Ex02_Rect rect1 = new Ex02_Rect(3);
		
		rect1.output();
		
		System.out.println("------------------------");
		
		Ex02_Rect rect2 = new Ex02_Rect(3,5);
		
		rect2.output();
		
	}
}
