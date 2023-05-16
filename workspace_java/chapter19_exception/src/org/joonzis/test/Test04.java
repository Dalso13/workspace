package org.joonzis.test;

import java.util.Scanner;


	   
class PerIDException extends Exception{
	private static final long serialVersionUID = 1L;
	public void getPerID(String perID) throws PerIDException {
		if (perID.length() != 14) {
			throw new PerIDException();
		}
		System.out.println(perID);
	}
	
	
}
//Q4. Test04.java									   
//주민등록 번호 (하이픈 포함)를 입력 받아 출력하시오.
//주민등록번호가 14글자가 아니면 PerIDException 클래스를 이용하여 예외를 처리하시오.
//주민등록번호를 입력받기 위해 getPerID() 메소드를 이용하시오.		
public class Test04 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PerIDException per = new PerIDException();
		
		
		try {
			System.out.println("주민등록 번호 (하이픈 포함) : ");
			per.getPerID(sc.nextLine());
			
		} catch (PerIDException e) {
			System.out.println("잘못 입력함");
		} finally {
			if (sc != null) {
				sc.close();
			}
		}
	}
}
