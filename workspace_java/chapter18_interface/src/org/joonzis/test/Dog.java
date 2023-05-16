package org.joonzis.test;

public class Dog implements Animal{
	
	String name;
	
	public Dog(String name) {
		this.name = name;
	}
	@Override
	public void move() {
		System.out.println(name + " 멍멍");
		
	}
}
 