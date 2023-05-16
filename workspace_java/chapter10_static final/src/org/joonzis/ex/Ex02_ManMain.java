package org.joonzis.ex;

public class Ex02_ManMain {
	public static void main(String[] args) {
		Ex02_Man man1 = new Ex02_Man("장",30);
		
		man1.output();
		
		System.out.println("-----------------------");
		
		System.out.println(man1.name);
		System.out.println(man1.age);
		System.out.println(man1.GENDER);	// 인스턴스를 통한 접근 - > 비추천
		System.out.println(Ex02_Man.GENDER); // 클래스를 통한 접근 - > 추천
	}
}
