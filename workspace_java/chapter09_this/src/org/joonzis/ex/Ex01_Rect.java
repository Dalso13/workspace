package org.joonzis.ex;
class Rect {
	int width;
	int height;
	
	public Rect() {}

	public Rect(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	void setWidth(int width) {
		this.width = width;
	}
	void setHeight(int height) {
		this.height = height;
	}
	void output() {
		System.out.println("너비 : " + width);
		System.out.println("높이 : " + height);
	}
}


public class Ex01_Rect {
	public static void main(String[] args) {
		Rect r1 = new Rect(3,5);
		
		
		r1.output();
			
			
			
			
			
	}
	
}
