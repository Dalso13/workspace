package org.joonzis.test;

import java.util.Scanner;

class Triangle {
	private int width,height;
	
	public Triangle() {
	}
	
	public void input(int width ,int height) {
		this.width = width;
		this.height = height;
	}
	
	public Double calcArea() {
		return width * height / 2.0;
	}
	
	public void output() {
		System.out.println("가로 : " + width);
		System.out.println("세로 : " + height);
		System.out.println("넓이 : " + calcArea());
	}
}

public class Test3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Triangle tri = new Triangle();
		
		System.out.print("가로 : ");
		int width = sc.nextInt();
		System.out.print("세로 : ");
		int height = sc.nextInt();
		
		tri.input(width, height);
		tri.output();
	}
}
