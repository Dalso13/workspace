package org.joonzis.ex;


interface Shapt{
	double PI = Math.PI;
	double calcArea();
	void output();
}
class Rect implements Shapt{
	private int width, height;
	
	public Rect() {}
	
	public Rect(int width, int height) {
		super();
		this.width = width;
		this.height = height;
	}



	@Override
	public double calcArea() {
		return width * height;
	}
	@Override
	public void output() {
		System.out.println(width);
		System.out.println(height);
		System.out.println(calcArea());
		
	}
}
class Circle implements Shapt{
	private double radius;
	public Circle() {}
	
	public Circle(double radius) {
		this.radius = radius;
	}




	@Override
	public double calcArea() {
		return PI * radius * radius;
	}
	@Override
	public void output() {
		
		System.out.println(radius);
		System.out.println(calcArea());
		
	}
}

public class Ex02_Interface {
	public static void main(String[] args) {
		// 도형 객체를 생성하여 사각형, 원형 객체를 저장.
		// 각 도형의 정보 출력
		// 1. 사각형 :  너비, 높이, 크기(너비 * 높이)
		// 2. 원형 : 반지름, 넓이(PI*radius*radius)
		Shapt rect[] = new Shapt[2];
		
		rect[0] = new Rect(3,4);
		rect[1] = new Circle(5);
		
		rect[0].output();
		System.out.println("-------------");
		rect[1].output();
	
		
	}
}
