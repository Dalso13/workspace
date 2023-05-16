package org.joonzis.ex;

class Person {
	void sleep() {
		System.out.println("잔다");
	}
	void eat (String food) {
		System.out.println(food + "먹는다");
	}
}

class Student extends Person {
	void study() {
		System.out.println("공부한다");
	}
}
class Worker extends Person {
	void work() {
		System.out.println("일한다");
	}
}






public class Ex02_inheritance {
	public static void main(String[] args) {
		
		// 밥먹는다.
		// 공부한다.
		// 잔다
		Student stu = new Student();
		
		stu.eat("밥");
		stu.study();
		stu.sleep();
		
	}
}
