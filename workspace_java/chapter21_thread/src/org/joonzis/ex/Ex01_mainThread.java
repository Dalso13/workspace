package org.joonzis.ex;

public class Ex01_mainThread {
	public static void main(String[] args) {
		
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(500);
				System.out.println("Main Thread" + (i+1)+"번 째 출력");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}
