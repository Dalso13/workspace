package org.joonzis.ex;

class MusicBox{
	public void rock() {
		for (int i = 0; i < 5; i++) {
			
			try {
				System.out.println("play the rock");
			
				Thread.sleep(500);
			} catch (Exception e) {
					e.printStackTrace();
			}
			
		}
	}
	public void ballad() {
		for (int i = 0; i < 5; i++) {
			
			try {
				System.out.println("play the ballad");
			
				Thread.sleep(500);
			} catch (Exception e) {
					e.printStackTrace();
			}
			
		}
	}
	public void dance() {
		for (int i = 0; i < 5; i++) {
			
			try {
				System.out.println("play the dance");
			
				Thread.sleep(500);
			} catch (Exception e) {
					e.printStackTrace();
			}
			
		}
	}
}
class MusicPlayer extends Thread{
	private int type;
	private MusicBox musicBox;
	
	public MusicPlayer(int type, MusicBox musicBox) {
		this.type = type;
		this.musicBox = musicBox;
	}
	
	@Override
	public void run() {
		switch (type) {
		case 1:	musicBox.rock();
			break;
		case 2:	musicBox.ballad();
			break;
		case 3:	musicBox.dance();
			break;	
		default:
			break;
		}
	
	}
	
}



public class Ex04_ObjectShare {
	public static void main(String[] args) {
		MusicBox box = new MusicBox();
		
		MusicPlayer p1 = new MusicPlayer(1, box);
		MusicPlayer p2 = new MusicPlayer(2, box);
		MusicPlayer p3 = new MusicPlayer(3, box);
		
		p1.start();
		p2.start();
		p3.start();
	}
}
