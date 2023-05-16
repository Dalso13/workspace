package org.joonzis.ex;

interface Animal{
	void move();   // 자동으로  abstract public 가 앞에 붙음.
	void eat(String food);
}
class Dog implements Animal{
	@Override
	public void move() {
		System.out.println("개가 달린다");
	}
	@Override
	public void eat(String food) {
		
		System.out.println(food + "먹는다");
	}
}





public class Ex01_Interface {
	public static void main(String[] args) {
		
//		Animal animal = new Animal() {}; 인터페이스는 생성자를 가질수 없다

		Animal animal = new Dog();
		
		animal.move();
		animal.eat("사료");
		
		
		
		
	}
}
