package org.joonzis.DI_2;

public class TVUser {
	public static void main(String[] args) {
		TV lgtv = new LgTV();
		TV satv = new SamSungTV();
		
		lgtv.powerOn();
		satv.powerOn();
		
		
	}
}
	
