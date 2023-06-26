package org.joonzis.DI_8_set;

public class SonySpeaker implements Speaker{
	public SonySpeaker() {
		System.out.println("--> SonySpeaker 객체 생성.");
	}
	
	@Override
	public void volumUp() {
		System.out.println("--> SonySpeaker 볼륨 올린다.");
	}
	@Override
	public void volumOff() {
		System.out.println("--> SonySpeaker 볼륨 내린다.");
	}
}
