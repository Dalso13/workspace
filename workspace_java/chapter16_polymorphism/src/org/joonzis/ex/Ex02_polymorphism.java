package org.joonzis.ex;
class Shape{
	// 의미 없는 메소드(자식들이 사용하기 위해 만들어놓음)
	public double calcArea() {
		return 0;
	}
}
class Rect extends Shape {
	private int width, height;

	public Rect(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	@Override
	public double calcArea() {
		return width * height;
	}
	
}
class Triangle extends Shape {
	private int width, height;

	public Triangle(int width, int height) {
		this.width = width;
		this.height = height;
	}
	@Override
	public double calcArea() {
		return width * height /2.0;
	}
	
}
class Circle extends Shape {
	private double radius;

	public Circle(double radius) {
		this.radius = radius;
	}
	@Override
	public double calcArea() {
		return Math.PI * Math.pow(radius, 2);
	}
	
}




public class Ex02_polymorphism {
	public static void main(String[] args) {
		
		// 길이 3 짜리 부모 배열을 선언하여
		// 각각 인덱스에 사각형, 삼각형, 언형 클래스 객체 대입
		// 각 객체별 크기 출력

		
		Shape sa[] = new Shape[3];
		
		sa[0] = new Rect(2, 4);
		sa[1] = new Triangle(4, 6);
		sa[2] = new Circle(5);
		
		for (int i = 0; i < sa.length; i++) {
			System.out.println(sa[i].calcArea());
		}
		
		
		
	}
}
