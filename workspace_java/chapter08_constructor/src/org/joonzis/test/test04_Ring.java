package org.joonzis.test;

public class test04_Ring {
	
	test04_Circle inner;
	test04_Circle outer;
	
	public test04_Ring() {}
	
	
	public test04_Ring(test04_Circle inner, test04_Circle outer) {
		this.inner = inner;
		this.outer = outer;
	}
	
	void output () {
		System.out.println("안쪽 원의 정보 : " );
		inner.output();
		System.out.println("-----------------");
		System.out.println("바깥쪽 원의 정보 : " );
		outer.output();
	}
	
}
