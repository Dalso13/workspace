package org.joonzis.ex;


class Oper{
	public void add(int num1, int num2) {
		System.out.println(num1 + num2);
	}
	
	public int add2(int num1, int num2) {
		return num1 + num2;
	}
}

public class Testclass {
	public static void main(String[] args) {
		Oper oper = new Oper();
		oper.add(10, 20);
		System.out.println(oper.add2(10,20));
	}
}
