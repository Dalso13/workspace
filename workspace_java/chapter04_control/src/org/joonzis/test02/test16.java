package org.joonzis.test02;

import java.util.Scanner;

public class test16 {
	public static void main(String[] args) {
//		Test08.java
//		Q.Up-Down 게임
//			1 ~ 100 사이에서 임의의 숫자를 하나 결정한 뒤
//			해당 숫자를 맞추는 게임
//			입력 받은 숫자의 크기에 따라 "Up!", "Down!", "Answer!" 로 나눠서 출력하고
//			맞출때까지 몇 번 진행했는지 횟수도 함께 출력
//			실행 예)
//			입력 >> 30
//			Up!
//			입력 >> 40
//			Down!
//			입력 >> 35
//			Down!
//			입력 >> 33
//			Answer!
//			총 4회만에 성공!
//		
		Scanner sc = new Scanner(System.in);
		
		int sum = 33;
		int i = 1;
		
		
		while (true) {
			System.out.print(" 1 ~ 100 사이 임의의 숫자 : ");
			int num = sc.nextInt();
			
			if (num == sum) {
				System.out.println("Answer!  " + "\n" + "총 " + i  + "회 만에 성공!");
				break;
				} else if (num > 100 || num <= 0) {
				System.out.println("다시 입력해주세요");				
				} else if (num > sum) {
				System.out.println("Down!");
				i++;
				} else if (num < sum) {
				System.out.println("Up!");
				i++;
				}
			
		}
		
		sc.close();
		

	}
}
