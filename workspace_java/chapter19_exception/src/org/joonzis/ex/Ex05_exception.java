package org.joonzis.ex;

interface Animal{
	public void walk();
		
}

class Dog implements Animal{
	@Override
	public void walk() {
		System.out.println("산책한다.");
	}
	public void sleepTogether() {
		System.out.println("같이 잔다.");
	}
}

class Crocodile implements Animal{
	@Override
	public void walk() {
		System.out.println("악어 피해 도망간다.");
		
	}
}
public class Ex05_exception {
	
	public static void verifyDog(Animal animal) {
		
		// 1. instanceof 연산자를 이용한 예외 처리
		if(animal instanceof Dog) {
			((Dog)animal).sleepTogether();
		} else {
			System.out.println("강아지가 아니라서 같이 잘 수 없다.");
		}
		
		// 2. try-catch를 이용한 예외 처리
		try {
			animal.walk();
			((Dog)animal).sleepTogether();
		} catch (ClassCastException e) {
			System.out.println("강아지가 아니라서 같이 잘 수 없다.");
			e.printStackTrace();
		}
		
	}
	
	
	
	public static void main(String[] args) {
		verifyDog(new Crocodile());
	}
}
