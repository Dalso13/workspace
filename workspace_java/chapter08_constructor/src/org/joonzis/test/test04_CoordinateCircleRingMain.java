package org.joonzis.test;

public class test04_CoordinateCircleRingMain {
	public static void main(String[] args) {
		test04_Coordinate cor1 = new test04_Coordinate(1,2);
		
		test04_Circle cir1 = new test04_Circle(3 , cor1);
		
		test04_Ring rin1 = new test04_Ring(cir1, new test04_Circle(4 , cor1)); // == cir1 을 값만 바꿔서 cir2 로 만든후  new test04_Ring(cir1, cir2);
		
		rin1.output();
	}
}
