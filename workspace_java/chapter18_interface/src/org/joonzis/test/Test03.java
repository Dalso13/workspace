package org.joonzis.test;


//파일로 나눠서 실행해보자!!
//Animal.java(인터페이스)		메소드 : move()
//Dog.java(Animal 구현)	

public class Test03 {

	public static void main(String[] args) {
		Animal ani = new Dog("강아지");
		
		ani.move(); 
	}
} 
