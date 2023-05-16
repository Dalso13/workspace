package org.joonzis.ex;

class Product{
	public void info() {
		System.out.println("Product");
		
	}
}
class Computer extends Product{
	@Override
	public void info() {
		System.out.println("Computer");
	}
	
}
class Notebook extends Product{
	@Override
	public void info() {
		System.out.println("Notebook");
	}
	

	
}


public class Ex01_polymorphism {
	public static void main(String[] args) {
		
		//업캐스팅
		// 부모(product) <= 자식(computer,notebook)
		
		Product products[] = new Product[20];
		
//		products[0] = new Product();
//		문법은 문제 없다
//		무슨 제품인지 알 수 없음
		
		products[0] = new Computer();
		products[1] = new Computer();
		products[2] = new Notebook();
		
		products[0].info();
		products[1].info();
		products[2].info();
		

		
		
		
	}
}
