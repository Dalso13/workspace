package org.joonzis.ex;

public class Ex05_BookMain {
	public static void main(String[] args) {
		Ex05_Book book = new Ex05_Book();
		
		Ex05_Book book1 = new Ex05_Book("단군 신화", 60000 );
		Ex05_Book book2 = new Ex05_Book("노인과 바다" , 10000 , "헤밍웨이");

		
		book1.setSalesVolume(600);
		book2.setSalesVolume(3000);
			
		book1.output();
		
	System.out.println("--------------------------");
	
		book2.output();
		
	}
}
