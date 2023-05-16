package org.joonzis.test;


class Product{
	private	String model;
	private	int price;
	
	public Product(String model, int price) {
		this.model = model;
		this.price = price;
	}
	
	public String getter1() {
		return model;
	}
	public int getter2() {
		return price;
	}
	
}
class Tv extends Product{
	public Tv(String model, int price) {
		super(model, price);
	}
}
class Computer extends Product{
	public Computer(String model, int price) {
		super(model, price);
	}
	
}
class Customer{
	private	int money,startMoney,numOfProduct;
	private	Product[] cart = new Product[10];
	
	
	public Customer(int money) {

		this.startMoney = money;
		this.money = money;
		
	}
	
	
	public void buy(Product product) {
			if (product.getter2() > money) {
				System.out.println(product.getter1() +"을 구매하기 위한 잔액이 부족합니다");
				return;
			} 
			
			money -= product.getter2();
			cart[numOfProduct] = product;
			numOfProduct++;
		
	}
	
	
	public void output() {
		System.out.println("구매한 상품 : ");
		for (int i = 0; i < numOfProduct; i++) {
			System.out.println(cart[i].getter1() +" : " +  cart[i].getter2());
		}
		System.out.println();
		System.out.println("처음 소지 금액 : " + startMoney);
		System.out.println("총 구매 금액 : " + (startMoney-money));
		System.out.println("남은 금액 : " + money);
	}
	
	
}



public class Test02 {	
//	Q2. Test02.java
//
//	Product 클래스			필드 : String model, int price
//							메소드 : Constructor, getters
//	Tv 클래스					필드 : X
//							메소드 : Constructor
//	Computer 클래스			필드 : X
//							메소드 : Constructor
//	Customer				필드 : int money, int startMoney, Product[] cart, int numOfProduct
//							메소드 : Constructor, buy(Product), output	
//	★
//	필드는 전부 private
//	Tv extends Product		
//	Computer extends Product
//	buy() -> 상품 구매(소지 금액보다 구매 금액이 큰 경우 예외처리)/구매한 만큼 금액 차감/카트에 상품 추가
//	output() -> 구매상품, 금액/처음 소지 금액/총 구매 금액/남은 금액 출력
//
//	== 2명의 Customer가 각각 Tv, Computer를 구매 
	
	public static void main(String[] args) {
		
		
		
		Customer custom = new Customer(2000);
		Customer custom1 = new Customer(1200);
		
		custom.buy(new Tv("LG 올레드 티비", 1000));
		custom.buy(new Computer("LG 그램", 400));
		
		
		custom.output();
		
		System.out.println("----------------------------");
		
		
		custom1.buy(new Tv("LG 올레드 티비", 1000));
		custom1.buy(new Computer("LG 그램", 400));
		
		custom1.output();
	}
}
