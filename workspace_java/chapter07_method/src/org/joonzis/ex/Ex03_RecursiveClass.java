package org.joonzis.ex;

public class Ex03_RecursiveClass {
	
	static int count = 0;
	
	
	static void Recursive() {
		System.out.println("Recursive() call");
		count++;
		if (count == 5) {
			return;
		}
		Recursive();
	}
	
	public static void main(String[] args) {
		Recursive();
	}
}
