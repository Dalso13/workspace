package org.joonzis.test;

import java.util.Random;
import java.util.Scanner;

public class Test02 {
//	Q2. Test02.java		
//	사용자로부터 10이상의 정수를 입력 받아 난수 (0 ~ 9)로 나눈결과를 출력하시오.
//	위과정을 100번 반복하여 출력하며, 나눌 수없는 경우에는 나눈 결과를 0으로 대신출력한다.
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random ran = new Random();
		
		try {
			for (int i = 0; i < 100; i++) {
				System.out.print("숫자 입력 : ");
				int num = sc.nextInt();
				if (num < 10) {
					// 입력 값이 10보다 작을때
					i--;
					continue;
				} else {
					System.out.println(num/(ran.nextInt(10)));
				}
			}	
		} catch (Exception e) {
			System.out.println(0);
			
			
		} finally {
			
		}
	}
}
