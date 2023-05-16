package org.joonzis.test;

//Q4.
//Coordinate.java			필드 - int x, int y
//						메소드 - Constructor, output
//Circle.java				필드 - Coordinate center, double radius
//						메소드 - Constructor, output
//Ring.java				필드 - Circle inner, Circle outer
//						메소드 - Constructor, output
//CoordinateCircleRingMain.java						


public class test04_Coordinate {
	 int x;
	 int y;
	 public test04_Coordinate() {}

	 
	 public test04_Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}



	void output() {
		 System.out.println("좌표 : (" + x + "," + y + ")");
	 }
}
