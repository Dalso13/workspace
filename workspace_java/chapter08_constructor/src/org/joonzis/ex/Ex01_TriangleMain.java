package org.joonzis.ex;

public class Ex01_TriangleMain {
	public static void main(String[] args) {
		Ex01_Triangle tri1 = new Ex01_Triangle();
		tri1.output();
		
		System.out.println("----------------------");
		
		Ex01_Triangle tri2 = new Ex01_Triangle(2, 3);
		tri2.output();
	}
}
