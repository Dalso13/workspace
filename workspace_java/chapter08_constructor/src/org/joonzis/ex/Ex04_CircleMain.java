package org.joonzis.ex;

public class Ex04_CircleMain {
	public static void main(String[] args) {
		Ex04_Circle cir1 = new Ex04_Circle();
		
		cir1.output();
		
		System.out.println("-----------------");
		
		Ex04_Circle cir2 = new Ex04_Circle(3);
		
		cir2.output();
		
		System.out.println("-----------------");
		
		Ex04_Circle cir3 = new Ex04_Circle(3, 5, 7.5);
		
		cir3.output();
		
	}
}
