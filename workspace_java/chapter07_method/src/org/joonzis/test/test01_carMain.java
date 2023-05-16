package org.joonzis.test;

public class test01_carMain {
	public static void main(String[] args) {
		
		test01_car car = new test01_car();
		
		car.setFields("K8" , "회색");
		car.output();
		

		
		car.setFields("K7" , "회색" , 2020);
		car.output();
	}
}
