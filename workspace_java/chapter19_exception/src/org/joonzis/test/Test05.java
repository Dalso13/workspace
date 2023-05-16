package org.joonzis.test;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;



class NumberOutOfBoundsException extends Exception{
	private static final long serialVersionUID = 1L;
	public NumberOutOfBoundsException() {}
	public NumberOutOfBoundsException(String msg) {
		super(msg);
	}

	public void number(int num) throws NumberOutOfBoundsException{
		if (num > 100 || num < 1) {
			throw new NumberOutOfBoundsException("0 ~ 100 사이에 숫자를 입력해 주세요.");
		}
	}
}



public class Test05 {

	
//	Q5. Test05.java		
//	Up-Down 게임
//	1 ~ 100 사이의 난수를 발생시켜 해당 값을 맞출때까지 게임을 진행하시오.
//	다음의 경우 예외를 발생시키시오.
//	1) 사용자가 1 ~ 100 이외의 값을 입력한 경우 NumberOutOfBoundsException 클래스를 이용하여 예외 처리
//	2) 정수대신 다른 데이터 (예: 실수, 문자) 등을 입력한 경우
	
	
	public static void main(String[] args) {
		Random ran = new Random();
		int num1 = ran.nextInt(100)+1;
		Scanner sc = new Scanner(System.in);
		NumberOutOfBoundsException number = new NumberOutOfBoundsException();
		int i = 1;
		try {
			while (true) {
				System.out.print("숫자 입력 : ");
				int num = sc.nextInt();
				number.number(num);
				if (num1 == num) {
					System.out.println("-----------------");
					System.out.println("맞혔습니다\n시도한 횟수 : " + i);
					sc.close();
					break;
				} else if (num > num1) {
					System.out.println("down");
				} else if (num < num1) {
					System.out.println("up");
				}
				i++;
			}
			
		} catch (NumberOutOfBoundsException e) {
			System.out.println(e.getMessage());
		} catch (InputMismatchException e) {
			System.out.println("정수를 입력해주십시오.");
		}
		
	}
}
