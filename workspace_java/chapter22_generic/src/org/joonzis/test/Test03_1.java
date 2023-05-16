package org.joonzis.test;


class Product1<T1, T2>{
	private T1 category;
	private T2 model;
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append(category).append(" : ").append(model);
		return sb.toString();
	}
	
	public void setCategory(T1 category) {
		this.category = category;
	}
	public void setModel(T2 model) {
		this.model = model;
	}
	
}


class Idol1{
	String name;
	public Idol1(String name) {
		this.name = name;
	}
	
	
	@Override
	public String toString() {
		return name;
	
	}
}

class Member1{
	String name;
	public Member1(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
}


public class Test03_1 {
//	Q3. Test03.java
//	1. 메인클래스를 보고 알맞은 클래스들을 구현하시오.
//	2. Product 클래스를 구현하시오.
//		필드 : T1 category, T2 model
//		적절한 메소드 구현하기
//			
	
	
	public static void main(String[] args) {
		
		
		
		Product1<Idol1,Member1> p1 = new Product1();
		Product1<Idol1,Member1> p2 = new Product1();
		
		
		p1.setCategory(new Idol1("소녀시대"));
		p1.setModel(new Member1("유리"));
		
		p2.setCategory(new Idol1("뉴진스"));
		p2.setModel(new Member1("해린"));
		
		System.out.println(p1);
		System.out.println(p2);
		
	}
}