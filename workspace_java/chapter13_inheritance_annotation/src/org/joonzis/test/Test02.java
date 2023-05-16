package org.joonzis.test;
class Computer {
	String model;
	int price;
	
	public Computer() {}
	public Computer(String model, int price) {
		this.model = model;
		this.price = price;
	}
	
	void output() {
		System.out.println("이름 : " + model + "\n가격 : " + price + "만원");
	}
}

class Notebook extends Computer {
	int battery;
	
	public Notebook() {}
	public Notebook(String model, int price, int battery) {
		super(model,price);
		this.battery = battery;
	}
	@Override
	void output () {
		super.output();
		System.out.println("배터리 파워 : " + battery + "w");
	}
	
}
class Tablet extends Notebook {
	String pen;
	
	public Tablet() {}
	public Tablet(String model, int price, int battery, String pen) {
		super(model,price,battery);
		this.pen = pen;
	}
	
	
	@Override
	void output() {
		super.output();
		System.out.println("펜 : " + pen);
	}
}



public class Test02 {
	
//	Q2. Test02.java 상속 관계로 구현하시오.
//	Notebook.java				- 필드 : String model, int price, int battery
//								- 메소드 : Constructor, output()	
//	Tablet.java					- 필드 : String model, int price, int battery, String pen
//								- 메소드 : Constructor, output()
//	→ 부모클래스는 알아서 만들어보자!(Computer)		
//	******* Computer는 battery 가 없다 ***********				

	public static void main(String[] args) {
		Notebook note = new Notebook("LG 그램", 150, 65);
		Tablet tablet = new Tablet("갤럭시탭", 40, 45, "삼성펜");
		
		note.output();
		System.out.println("-------------------------");
		tablet.output();
	}
}
