package org.joonzis.test;

public class test02_Dog_main {
	public static void main(String[] args) {
		
		test02_Dog dog = new test02_Dog();
		
		dog.setDog("초코", 10);
		dog.info();
		
		System.out.println("-----------------------");
		dog.setDog("나비","치와와",5);
		dog.info();
	}
}
