package org.joonzis.test;

class Coordinate {
	private int x , y;

	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Coordinate) {
			Coordinate cord = (Coordinate)obj;
			
			return x == (cord.x) && y == (cord.y);
		} else {
			return false;
		}
	}
}
class Circle {
	private Coordinate center;
	private double radius;
	
	
	public Circle(Coordinate center, double radius) {
		this.center = center;
		this.radius = radius;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Circle) {
			Circle circle = (Circle)obj;
			return radius == circle.radius;		
		} else {
			return false;
		}
	}
	 
	
	
}



public class Test03 {

//	Q3. Test03. java							
//	
//	Coordinate 클래스				필드 : int x, int y;
//								메소드 : Constructor, equals()							
//	Circle 클래스					필드 : Coordinate center, double radius	
//								메소드 : Constructor, equals()	
//	new Circle(0, 0, 1.5) // 중심 좌표[0,0], 반지름 : 1.5										

	public static void main(String[] args) {
		Coordinate xy1 = new Coordinate(0, 0);
		Coordinate xy2 = new Coordinate(0, 0);
		
		
		Circle ci1 = new Circle(xy1, 1.5);
		Circle ci2 = new Circle(xy2, 1.5);
		
		if (ci1.equals(ci2)) {
			System.out.println("동등");
		} else {
			System.out.println("아님");
		}
	}
	
}
