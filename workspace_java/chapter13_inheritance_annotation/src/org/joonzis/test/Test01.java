package org.joonzis.test;


class Human {
	String name;
	int age;
	public Human() {}
	public Human(String name, int age) {
		this.name = name;
		this.age = age;
	}
	void output() {
		System.out.print("이름 : "+ name + " , 나이 : " + age);
	}
	
}
class Student extends Human {
	String school;
	
	public Student() {}
	
	public Student(String name, int age, String school) {
		super(name,age);
		this.school = school;
	}
	@Override
	void output() {
		super.output();
		System.out.println(" , 학교 : " + school );
	}
	
}
class Worker extends Human {
	String job;
	
	public Worker() {}
	public Worker(String name, int age, String job) {
		super(name,age);
		this.job = job;
	}
	
	@Override
	void output() {
		super.output();
	System.out.println(" , 직업 : " + job );
	}
	
}





public class Test01 {
	public static void main(String[] args) {
//		Q1. Test01.java 상속 관계로 구현하시오.
//
//		Student.java				- 필드 : String name, int age, String School
//									- 메소드 : Constructor, output()
//		Worker.java					- 필드 : String name, int age, String job
//									- 메소드 : Constructor, output()
//		→ 부모클래스는 알아서 만들어보자!(Human)
		
		Student stu = new Student("장씨", 23, "하버드");
		Worker worker = new Worker("장씨", 23, "개발자");
		
		stu.output();
		worker.output();
	}
}
