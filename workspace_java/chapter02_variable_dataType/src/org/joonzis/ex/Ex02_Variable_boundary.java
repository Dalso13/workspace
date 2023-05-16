package org.joonzis.ex;

public class Ex02_Variable_boundary {
	
	static double PI = 3.14;
	
	
	public static void main(String[] args) {
		int value = 10;
		int sum = value = 20;
		
		System.out.println(sum);
//		System.out.println(result);
		System.out.println(PI);
		
	}
	public void local() {
	
		int result = 0;
	}
		
	

}
