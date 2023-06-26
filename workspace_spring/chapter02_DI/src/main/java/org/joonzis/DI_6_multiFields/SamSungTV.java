package org.joonzis.DI_6_multiFields;

public class SamSungTV implements TV{
	// Samsung TV 클래스의 볼륨 조절 기능을 SonySpeaker 클래스를 이용
	private SonySpeaker sonySpeaker;
	private int price;
	
	public SamSungTV() {
		System.out.println("--> SamSungTV 객체1 생성");
	}
	public SamSungTV(SonySpeaker speaker) {
		System.out.println("--> SamSungTV 객체2 생성");
		this.sonySpeaker = speaker;
	}
	public SamSungTV(SonySpeaker speaker, int price) {
		System.out.println("--> SamSungTV 객체3 생성");
		this.sonySpeaker = speaker;
		this.price = price;
	}
	@Override
	public void powerOn() {
		System.out.println("--> SamSungTV 전원 키기 가격 : " + price);
	}
	@Override
	public void powerOff() {
		System.out.println("--> SamSungTV 전원 끄기");
	}
	@Override
	public void volumeUp() {
		sonySpeaker.volumUp();
	}
	@Override
	public void volumeOff() {
		sonySpeaker.volumOff();
	}
}
