package org.joonzis.ex;

class Computer{
	private String model;
	private int price;
	
	public Computer(String model, int price) {
		this.model = model;
		this.price = price;
	}
	@Override 
	public String toString() {
		return "모델 : " + model + ", 가격 : " + price;
	}
	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Computer) {
			Computer another = (Computer)obj;
			
			return model.equals(another.model) && price == another.price;
		} else {
			return false;
		} 
		
		
		
	}
	
}

public class Ex02_Object_equals {
	public static void main(String[] args) {
		
		Computer myCom1 = new Computer("LG 그램", 100);
		Computer myCom2 = new Computer("LG 그램", 100);
		
		myCom1.equals(myCom2);
		
		// 1. == : 참조 비교 (주소 비교)
		if (myCom1 == myCom2) {
			System.out.println("같음");
		} else {
			System.out.println("다름");
		}
		
		// 2. equals()
		// 	1) Object의 equals 메소드 : 객체 비교 불가
		//	2) Computer 클래스에서 equals 메소드 오버라이드
		
		if (myCom1.equals(myCom2)) {
			System.out.println("같음");
		} else {
			System.out.println("다름");
		}
		
		
		
	}
}
