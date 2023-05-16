package org.joonzis.test;


class Product<T1, T2>{
	private T1 category;
	private T2 model;
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append(category).append(model);
		return sb.toString();
	}
	
	public void setCategory(T1 category) {
		this.category = category;
	}
	public void setModel(T2 model) {
		this.model = model;
	}
	
}


class Idol{
	@Override
	public String toString() {
		return "소녀시대";
	
	}
}

class Member{
	@Override
	public String toString() {
		return "윤아";
		
	}
}


public class Test03 {
//	Q3. Test03.java
//	1. 메인클래스를 보고 알맞은 클래스들을 구현하시오.
//	2. Product 클래스를 구현하시오.
//		필드 : T1 category, T2 model
//		적절한 메소드 구현하기
//			
	
	
	public static void main(String[] args) {
		
		
		
		Product<Idol,Member> p1 = new Product();
		
		p1.setCategory(new Idol());
		p1.setModel(new Member());
		
		System.out.println(p1);
		
	}
}
