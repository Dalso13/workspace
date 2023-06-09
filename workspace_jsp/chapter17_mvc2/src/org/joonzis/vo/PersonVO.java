package org.joonzis.vo;

public class PersonVO {
	private String name, age, addr, phone, self;
	
	
	public PersonVO() {
	}


	public PersonVO(String name, String age, String addr, String phone, String self) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
		this.phone = phone;
		this.self = self;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAge() {
		return age;
	}


	public void setAge(String age) {
		this.age = age;
	}


	public String getAddr() {
		return addr;
	}


	public void setAddr(String addr) {
		this.addr = addr;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getSelf() {
		return self;
	}


	public void setSelf(String self) {
		this.self = self;
	}
	
	
}
