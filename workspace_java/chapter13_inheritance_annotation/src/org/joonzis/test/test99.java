package org.joonzis.test;

import java.util.Scanner;

class Account {
	int bigMoney;
	int setMoney;
	int getMoney;
	Scanner sc = new Scanner(System.in);
	
	
	
	
	public Account(int bigMoney) {
		this.bigMoney = bigMoney;
	}

	// 입금
	void setMoney() {
		System.out.println("---------------");
		System.out.print("입금액 입력 : ");
		setMoney = sc.nextInt();
		bigMoney += setMoney;

		System.out.println("\n입금액 : " + setMoney + "원  현재 잔액 : " + bigMoney + "원");
		System.out.println("---------------");
	}
	
	//출금
	void backMoney() {
		System.out.println("---------------");
		System.out.print( "현재 잔액 : " + bigMoney + "원  \n출금액 입력 : " );
		getMoney = sc.nextInt();
	
		if (bigMoney < getMoney) {
			System.out.println("\n잔액이 부족합니다");
			System.out.println("---------------");
		} else if (bigMoney > getMoney) {	
			System.out.println("\n현재 잔액 : " + bigMoney + "원  출금액 : " + getMoney + "원");
			bigMoney -= getMoney;
			System.out.println("---------------");
			System.out.println("출금후 잔액 : " + bigMoney );
			System.out.println("---------------");
		}
	
	}
	
	
}

class Bank extends Account{
	
	String name;
	String account;
	
	 public Bank(String name,String account,int bigMoney) {
		 super(bigMoney);
		this.name = name;
		this.account = account;
	}
	 
	 
	 void output () {
		 System.out.println("예금주 : " + name);
		 System.out.println("계좌번호 : " + account);
		 System.out.print("예금 1번 , 출금 2번 , 종료 3번 : ");
		 int num = sc.nextInt();
		 if (num == 1) {
			setMoney();
			output();
		} else if(num == 2) {
			backMoney();
			output();
		} else if (num == 3) {
			System.out.println("종료 되었습니다.");
			sc.close();
		} else {
			System.out.println("다시 입력해주세요");
			output();
		}
			

	 }
}





public class test99 {
	
//	Account 클래스를 상속받는 Bank 클래스 정의
	
	public static void main(String[] args) {
		Bank bank = new Bank("장동완", "111-111-111", 50000);
		
		bank.output();
		
	}
}
