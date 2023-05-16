package org.joonzis.test;

import java.util.Random;

class GugudanPlay{
	
	public void play(int dan) {
		
		for (int i = 1; i <= 9; i++) {
				System.out.println(dan + " x " + i + " = " + (dan * i));
		}
	
	}
	
}


class Gugudan implements Runnable{
	private int dan;
	private GugudanPlay gugudan;
	
	
	public Gugudan(int dan, GugudanPlay gugudan) {
		this.dan = dan;
		this.gugudan = gugudan;
	}
	
	@Override
	public void run() {
			gugudan.play(dan);	
	}	
}

public class Test02 {
//	Q2. Test02.java
//	멀티 스레드를 이용하여 구구단을 출력(동기화 X)
//	class GugudanPlay	메소드 : play(int dan)
//	class Gugudan		필드 : int dan, GugudanPlay gugudan
//						메소드 : 생성자 , run()
//	class Main
//	 - 참조 배열 이용
	
	public static void main(String[] args) {
		Random ran = new Random();
		Thread t[] = new Thread[8];
		
		for (int i = 1; i <= t.length; i++) {
			t[i-1] = new Thread(new Gugudan(i+1, new GugudanPlay()));
		}
		
		
		t[ran.nextInt(8)].start();
		t[ran.nextInt(8)].start();
	}
}
