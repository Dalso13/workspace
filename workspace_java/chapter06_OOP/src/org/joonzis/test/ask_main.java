package org.joonzis.test;

import java.util.Scanner;

class ask {
	
	int num1;
	int num2;
	int sum;
	void in(Scanner sc) {
		System.out.print("점수 ");
		num1 = sc.nextInt();
		System.out.print("점수 ");
		num2 = sc.nextInt();
		
		sum = (num1*num2) * (num1+num2);
		out();
		
	}
	void out() {
		System.out.println(sum);
	}
	
	
}


public class ask_main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		ask as1 = new ask();
		
		as1.in(sc);

		
	}
}
