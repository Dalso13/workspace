package org.joonzis.DI_4;

public class SamSungTV implements TV{
	// Samsung TV 클래스의 볼륨 조절 기능을 SonySpeaker 클래스를 이용
	private SonySpeaker sonySpeaker;
	
	public SamSungTV() {
		System.out.println("--> SamSungTV 객체 생성");
	}
	@Override
	public void powerOn() {
		System.out.println("--> SamSungTV 전원 키기");
	}
	@Override
	public void powerOff() {
		System.out.println("--> SamSungTV 전원 끄기");
	}
	@Override
	public void volumeUp() {
		sonySpeaker = new SonySpeaker();
		sonySpeaker.volumUp();
	}
	@Override
	public void volumeOff() {
		sonySpeaker = new SonySpeaker();
		sonySpeaker.volumOff();
	}
}
