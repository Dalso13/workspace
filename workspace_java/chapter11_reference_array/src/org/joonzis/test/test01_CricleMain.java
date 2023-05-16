package org.joonzis.test;

import java.util.Scanner;

public class test01_CricleMain {
	public static void main(String[] args) {
	test01_Cricle cri[] = new test01_Cricle[3];
	
	Scanner sc = new Scanner(System.in);
	
	for (int i = 0; i < cri.length; i++) {
		System.out.print("반지름 입력 : ");
		cri[i] = new test01_Cricle(sc.nextDouble());
	}
	double num = cri[0].calcArea();	
		
	for (int i = 0; i < cri.length; i++) {
		if (num < cri[i].calcArea()) {
			num = cri[i].calcArea();
		}
		cri[i].output();
	}
	
	System.out.println("가장 큰 크기 : " + num);
	
	
	
	
	
	
	
	
	
	
	}
	
}
