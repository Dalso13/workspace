package org.joonzis.test;

public class test02_Singer {
	
	String name;
	test02_Song song;
	
	public test02_Singer() {}
	public test02_Singer(String n) {
		name = n;
	}
	
	void setSong(test02_Song s){
		song = s;
	}
	
	
	void output() {
		System.out.println("가수 이름 : " + name);
		song.output();
	}
	
}
