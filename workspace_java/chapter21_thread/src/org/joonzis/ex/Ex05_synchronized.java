package org.joonzis.ex;

class AnimalSound{
	/*
	 * 	1. synchronized (동기화)
	 * 		1) 메소드에 붙여서 사용
	 * 			(1) 여러개의 Thread들이 공유 객체의 메소드를 사용할 때
	 * 				메소드에 synchronized가 붙어 있을 경우 먼저 호출한 메소드의 객체의
	 * 				사용권(Monitoring Lock)을 얻는다.
	 * 				락은 메소드가 종료되거나, wait() 같은 메소드를 만나기 전까지 유지된다.
	 * 			(2) 메소드가 길어지게 될 경우 대기 시간이 증가할 수 있다.
	 * 		2) synchronized 블럭 사용
	 */
	
	
	public synchronized void dog() {
		for (int i = 0; i < 3; i++) {
			System.out.println("멍-멍");
			
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	public synchronized void cat() {
		for (int i = 0; i < 3; i++) {
			System.out.println("냐옹");
			
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void bird() {
		synchronized(this) {
			for (int i = 0; i < 3; i++) {
				System.out.println("짹-짹");
				
				try {
					Thread.sleep(500);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		}
		
		
	}
	
}

class Animal implements Runnable{
	private int type;
	private AnimalSound sound;
	public Animal(int type, AnimalSound sound) {
		this.type = type;
		this.sound = sound;
	}
	
	@Override
	public void run() {
		switch (type) {
		case 1:	sound.dog();
			
			break;
		case 2:sound.cat();
			
			break;
		case 3:sound.bird();
		
			break;
		}
		
	}
	
	
}


public class Ex05_synchronized {
	public static void main(String[] args) {
		AnimalSound so = new AnimalSound();
		
		Animal an1 = new Animal(1, so);
		Animal an2 = new Animal(2, so);
		Animal an3 = new Animal(3, so);
		
		Thread ant1 = new Thread(an1);
		Thread ant2 = new Thread(an2);
		Thread ant3 = new Thread(an3);
		
		ant1.start();
		ant2.start();
		ant3.start();
		
		
	}
}
