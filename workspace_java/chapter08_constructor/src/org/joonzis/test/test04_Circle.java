package org.joonzis.test;

public class test04_Circle {
	test04_Coordinate center;
	double radius;
	
	public test04_Circle() {}
	
	
	
	public test04_Circle( double radius , test04_Coordinate center) {
		this.center = center;
		this.radius = radius;
	}
	
	void output () {
		System.out.println("반지름 : " + radius);
		center.output();
	}
	
	
	
}
