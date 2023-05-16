package org.joonzis.ex;


class Sample{
	@Override
	public String toString() {
		return "Sample"; 
		
	}
}

 

public class Ex01_Object {
	public static void main(String[] args) {
		Object object = new Object();
		System.out.println(object);
		
		
		object = 10;
		System.out.println(object);
		
		object = "Hello";
		System.out.println(object);
		
		object = new Sample();
		
		// 객체만 출력 하더라도 자동으로 toString() 반환
		System.out.println(object.toString());
		System.out.println(object);
	}
}
