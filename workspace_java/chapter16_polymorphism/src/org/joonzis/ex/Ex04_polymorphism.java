package org.joonzis.ex;

class Person{
	public void name(String name) {
		System.out.println(name + "은");
	}
	public void eat(String food) {
		System.out.println(food + "먹고");
	}
	public void sleep() {
		System.out.println("자고");
	}
}
class Student extends Person{
	public void study() {
		System.out.println("공부하고.");
	}
}
class Worker extends Person {
	public void work() {
		System.out.println("일하고.");
	}
}

public class Ex04_polymorphism {
	public static void main(String[] args) {
		// 업캐스팅
		Person person1 = new Student();
		// 학생은 급식먹고 잠 자고 공부하고
		person1.name("학생");
		person1.eat("급식");
		person1.sleep();
		// 검증후 다운캐스팅
		if (person1 instanceof Student) {
			((Student)person1).study();
		}
		
		System.out.println("--------------------");
		// 업캐스팅
		Person person2 = new Worker();
		// 직장인은 술먹고 잠 자고 일하고
		person2.name("직장인");
		person2.eat("술");
		person2.sleep();
		
		// 검증후 다운캐스팅
		if (person2 instanceof Worker) {
			((Worker)person2).work();
		}
		
	}
}
