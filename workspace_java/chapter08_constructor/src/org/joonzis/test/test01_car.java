package org.joonzis.test;

import java.util.Calendar;

public class test01_car {
//	Q1.
//	Car.java				필드 -String model, String color, int year, booleans isNewCar
//							메소드 - Constructor, output
//	CarMain.java
//	★
//	생성자(모델, 색상, 연식) / 생성자(모델, 색상)
//	Calendar calendar = Calendar.getInstance();
//	calendar.get(Calendar.YEAR);
	
	String model;
	String color;
	int year;
	boolean isNewCar;
	
	public test01_car() {}
	
	public test01_car(String m, String c, int y) {
		model = m;
		color = c;
		year = y;
		
	}
	public test01_car(String m, String c) {
		model = m;
		color = c;
		Calendar calendar = Calendar.getInstance();
		year = calendar.get(Calendar.YEAR);
		
	}
	
	void Constructor(int y1) {
		y1 = year;
		Calendar calendar = Calendar.getInstance();
		if (year == calendar.get(Calendar.YEAR)) {
			isNewCar = true;
		} else {
			isNewCar = false;
		}
	}
	void output() {
		System.out.println("모델 : " + model);
		System.out.println("색 : " + color);
		System.out.println("생산년도 : " + year + " " +(isNewCar ? "신차" : "구형차") );
	}
	
	
}