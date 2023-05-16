package org.joonzis.ex;

public class Test_OperMain {
	public static void main(String[] args) {
		
		Test_Oper oper1 = new Test_Oper(); 
		
		oper1.plus(10, 20);
	
		System.out.println("----------------------");
		
		Test_Oper oper2 = new Test_Oper(); 
		
		oper2.val1 = 12;
		oper2.val2 = 14;
		
		oper2.minus();
		oper2.multi();
	}
}
