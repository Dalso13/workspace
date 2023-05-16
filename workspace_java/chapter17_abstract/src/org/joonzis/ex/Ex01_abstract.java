package org.joonzis.ex;

abstract class Animal {	// 추상 클래스 ( 일반 메소드, 추상 메소드를 모두 가질 수 있다)
	public void eat(String food) {
		System.out.println(food + "먹는다");
	}
	abstract void move() ; // 추상 메소드
	
	
}

class Dog extends Animal{

	@Override
	void move() {
		System.out.println("강아지 산책한다.");
	}
}




public class Ex01_abstract {
	public static void main(String[] args) {
		// 추상 클래스는 new 할 수 없다.(객체 생성 불가)
		//Animal animal = new Animal();
		Animal animal = new Dog();
		animal.eat("점심");
		animal.move();
	}
}
