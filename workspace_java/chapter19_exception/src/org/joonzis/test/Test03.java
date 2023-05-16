package org.joonzis.test;

import java.util.Scanner;

class AgeException extends Exception{
	private static final long serialVersionUID = 1L;
	public void getAge(int age) throws AgeException{
		if (age > 150 || age < 0) {
			throw new AgeException();
		}
		
		System.out.println(age + "살");
	
	}
	
}

public class Test03 {
//	Q3. Test03.java	
//	나이를 입력 받아 출력하시오. 
//	나이가 0 ~ 150 사이의 범위를벗어나면 AgeException 클래스를 이용하여 예외를 처리하시오.
//	나이를 입력 받기 위해 getAge() 메소드를 이용하시오.

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AgeException age = new AgeException();
		try {
			System.out.println("나이 입력 : ");
			age.getAge(sc.nextInt());
		} catch (AgeException e) {
			System.out.println("다시해");
		} finally {
			if (sc != null) {
				sc.close();
			}
		}
		
	}
}
