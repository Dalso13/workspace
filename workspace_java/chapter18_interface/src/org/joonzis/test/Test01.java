package org.joonzis.test;
interface Computable{
	void connectInternet();
	void playApp();
	
}

class Phone {
	private String owner;
	public Phone() {
		 
	}
	public Phone(String owner) {
		this.owner = owner;
	}
	void sendCall() {
		System.out.println(owner + "한테 전화 걸기");
	}
	void receiveCall() {
		System.out.println(owner + "한테 전화 받기");
	}
	
}
class SmartPhone extends Phone implements Computable {
	public SmartPhone(String owner) {
		super(owner);
	}
	
	
	
	
	 @Override
	public void connectInternet() {
		System.out.println("인터넷 연결");
		
	}@Override
	public void playApp() {
		System.out.println("앱스토어 열기");
	}
}

public class Test01 {

//	Q1. Test01.java
//	스마트폰 => 전화기 + 컴퓨터 
//
//	class Phone 				필드 : String owner
//								메소드 : Constructor, sendCall(), receiveCall()
//	interface Computable		메소드 : connectInternet(), playApp()
//	class SmartPhone 			Phone 상속, Computable 구현

	public static void main(String[] args) {
		
		Phone smart = new SmartPhone("장동완");
		
		smart.receiveCall();
		smart.sendCall();
		if (smart instanceof Computable) {
			((Computable)smart).playApp();
			((Computable)smart).connectInternet();
			
		}
		
		
		
		
		
		
		
	}
	
	
	
}
