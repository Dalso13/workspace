package org.joonzis.test;

public class test02_Dog {
//	Q2.
//	클래스 Dog을 정의하시오.
//	- 필드 : String name, String breed, int age
//	- 메소드 : setDog(name, age) : 품종은 푸들
//			setDog(name, age, breed) 
//			info() - name, age, breed 출력
//	클래스 DogMain을 정의하시오.
	
	String name;
	String breed;
	int age;
	
	void setDog(String n1 , int a1) {
		name = n1;
		age = a1;
		breed = "푸들";
	}
	
	void setDog(String n1 , String b1 , int a1) {
		name = n1;
		age = a1;
		breed = b1;
	}
	
	void info() {
		System.out.println(name+ " " + breed + " " + age);
	}
}
