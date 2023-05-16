package org.joonzis.test;

public class test01_circle {
	
	
	final double PI = 3.14;
		double radius;
		String name;
		
		void info() {
			System.out.println("반지름 : " + radius);
			System.out.println(name + " 둘레 : " + (2*PI*radius));
			System.out.println(name + " 크기 : " + (PI * (radius*radius)));
		}
}
