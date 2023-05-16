package org.joonzis.ex;
	/*
	 * 	필드
	 * 	-	int age
	 *  -	String name
	 *  -	double height
	 *  - 	char gender
	 *  
	 *  메소드
	 *   - 풀 생성자
	 *   - output() : 이름, 나이, 키, 성별 출력
	 */


public class Ex03_Person {
	
	int age;
	String name;
	double height;
	char gender;
	
	public Ex03_Person() {}
	
	
	public Ex03_Person(int ag , String na , double he , char ge) {
		age =	ag;
		name =	na;
		height = he;
		gender = ge;
	}
	
	void output() {
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		System.out.println("키 : " + height);
		System.out.println("성별 : " + gender);
	}
}
