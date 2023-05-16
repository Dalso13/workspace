package org.joonzis.test;

import java.util.Calendar;

public class test01_car {
//	Q1. 
//	클래스 Car 를 정의하시오.
//	- 필드 : String model,String color, int year
//	- 메소드 : setFields(model, color) : 올해를 year로 처리, 
//			 setFields(model, color, year),
//			 output()
//	클래스 CarMain을 정의 하시오.
//	★
//	Calendar calendar = Calendar.getInstance();
//	calendar.get(Calendar.YEAR);	 // 현재 년도
	
	String model;
	String color;
	int year;
	
	void setFields(String m1, String c1) {
		model =	m1;
		color =	c1;
		Calendar calendar = Calendar.getInstance();
		year = calendar.get(Calendar.YEAR);
	}
	
	void setFields(String m1, String c1, int y1) {
		model =	m1;
		color =	c1;
		year = y1;
	}
	void output() {
		System.out.print(model + ("\t"));
		System.out.print(color + ("\t"));
		System.out.print((year == 2023 ? "올해" : year) + ("\n"));
	}
}
