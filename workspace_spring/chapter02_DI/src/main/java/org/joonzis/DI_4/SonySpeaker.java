package org.joonzis.DI_4;

public class SonySpeaker {
	public SonySpeaker() {
		System.out.println("--> SonySpeaker 객체 생성.");
	}
	
	public void volumUp() {
		System.out.println("--> SonySpeaker 볼륨 올린다.");
	}
	public void volumOff() {
		System.out.println("--> SonySpeaker 볼륨 내린다.");
	}
}
