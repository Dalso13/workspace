package org.joonzis.test;


class GugudanPlay1{
	
	public synchronized void play(int dan) {
		
		for (int i = 1; i <= 9; i++) {
			try {
				int num = 0;
				num = dan * i;
				System.out.println(dan + " x " + i + " = " + num);
				Thread.sleep(500);
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			notify();	// wait 한거 실행
		}
	}
	
}


class Gugudan1 implements Runnable{
	private int dan;
	private GugudanPlay1 gugudan;
	
	
	public Gugudan1(int dan, GugudanPlay1 gugudan) {
		this.dan = dan;
		this.gugudan = gugudan;
	}
	
	@Override
	public  void  run() {
			gugudan.play(dan);
		
	}	
}

public class Test03 {
//
//Q3. Test03.java
//멀티 스레드를 이용하여 구구단을 출력(동기화 O)
//class GugudanPlay2	메소드 : play()
//class Gugudan2		필드 : int dan, GugudanPlay2 gugudan
//					메소드 : 생성자 , run()
//class Main
// - 참조 배열 이용, 개별 객체 이용(2가지 모두 구현)
	
	public static void main(String[] args) {
		GugudanPlay1 g12 = new GugudanPlay1();
		Thread t[] = new Thread[8];		// 참조배열
		
		Thread t1 = new Thread(new Gugudan1(4, g12));	// 개별 객체 선언
		Thread t2 = new Thread(new Gugudan1(5, g12));
		
		for (int i = 1; i <= t.length; i++) {
			t[i-1] = new Thread(new Gugudan1(i+1, g12));	// 값 넣기
		}
		
		
		
		t[0].start();	// 실행
		synchronized (t[0]) {
			try {
				t[0].wait();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		t[1].start();
		synchronized (t[1]) {
			try {
				System.out.println("다른거 먼저 실행 2");
				t[1].wait();
			}	catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		t1.start();
		synchronized (t1) {
			try {
				System.out.println("다른거 먼저 실행 3");
				t1.wait();
			}	catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("다른거 먼저 실행 4");
		t2.start();
		
		
//			t[0].start();
//		  	t[1].start();
//		 	t1.start();
//		 	t2.start();
		 
		 
		
	}
}
