package org.joonzis.ex;

public class Ex04_System {
	public static void main(String[] args) {
		
		/*
		 *  여러 번 반복 중 회차가 5가 되었을 때 시스템 종료
		 */
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
			
			try {
				if (i == 4) {
					// jvm 종료 요청
					System.exit(i);
				}
			} catch (SecurityException e) {
				e.printStackTrace();
			}
		}
		
	}
}
