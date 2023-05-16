package org.joonzis.ex;

public class Ex02_Book {
	String title;
	String writer;
	int price;
	int salesVolume;
	boolean isBestSeller;
	
	public Ex02_Book() {}

	public Ex02_Book(String title, int price) {
		this(title, "작자미상", price);

	}

	public Ex02_Book(String title, String writer, int price) {
		this.title = title;
		this.writer = writer;
		this.price = price;

	}
	
}
