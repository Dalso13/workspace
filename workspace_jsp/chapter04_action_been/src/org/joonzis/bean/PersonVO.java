package org.joonzis.bean;

// VO ( Value Object ) == DTO ( Date Transfer Object )
// 1. DB와 통신하기 위해서 하나의 행을 하나의 객체로 생성하는 것
// 2. 필드는 DB 테이블의 컬럼명과 같은 이름을 사용한다.
public class PersonVO {
	private String name;
	private int age;
	private double height;
	private String addr;
	
	public PersonVO() {
	}

	public PersonVO(String name, int age, double height, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
		this.addr = addr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	
}
