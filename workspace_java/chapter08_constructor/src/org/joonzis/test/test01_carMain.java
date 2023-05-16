package org.joonzis.test;

public class test01_carMain {
	public static void main(String[] args) {
		test01_car car1 = new test01_car();
		test01_car car2 = new test01_car("k7" , "회색" , 2021);
		test01_car car3 = new test01_car("k8" , "검은색");
		
		car2.Constructor(0);
		car3.Constructor(0);
		
		car2.output();
		System.out.println("---------------------");
		car3.output();
		
	}

}
