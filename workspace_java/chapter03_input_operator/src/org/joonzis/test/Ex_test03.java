package org.joonzis.test;

import java.util.Scanner;

import javax.swing.Spring;

public class Ex_test03 {
		public static void main(String[] args) {
//			
//			Test03.java
//			Q. 매출액과 등급("VIP", "일반")을 입력받아 등급이 "VIP"이면 매출액에서 20%를 할인하고
//			   "일반"이면 매출액에서 5%를 할인하는 프로그램 구현 
			
			Scanner ipt = new Scanner(System.in);
			
			System.out.print("매출액 입력 : ");
			int money = ipt.nextInt();
			
			
			
			System.out.print("해당 되는 등급 숫자 입력 (VIP: 1 , 일반 : 2) : ");
			int grd = ipt.nextInt();
			
			System.out.println(grd == 1 ? (money * 80/100 ) + "원" : ( money * 95/100 ) + "원" );
			
			ipt.close();
		}
}
