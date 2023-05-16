package org.joonzis.test;

class Thr extends Thread{
	@Override
	public void run() {
		try {
			long start1 = System.currentTimeMillis();
			Thread.sleep((int)(Math.random()*1000));
			long end = System.currentTimeMillis();
			
			System.out.println((end - start1)/1000.0 + "초");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}



public class Test01 {
	
//	Q1. Test01.java
//	Thread 클래스를 상속받아 2개의 쓰레드의(메인 스레드 포함)
//	동작 완료 시간을 출력
//	★System.currentTimeMillis(),
//	 sleep((int)(Math.random()*1000)) 이용
	

	public static void main(String[] args) {
		Thr t1 = new Thr();
		
		t1.start();

		try {
			long start1 = System.currentTimeMillis();
			Thread.sleep((int)(Math.random()*1000));
			long end = System.currentTimeMillis();
			
			System.out.println((end - start1)/1000.0 + "초");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
