package org.joonzis.DI_7_dependencyChange;

public class SamSungTV implements TV{
	// Samsung TV 클래스의 볼륨 조절 기능을 SonySpeaker 클래스를 이용
	private Speaker speaker;
	private int price;
	
	public SamSungTV() {
		System.out.println("--> SamSungTV 객체1 생성");
	}
	public SamSungTV(SonySpeaker speaker) {
		System.out.println("--> SamSungTV 객체2 생성");
		this.speaker = speaker;
	}
	public SamSungTV(Speaker speaker, int price) {
		System.out.println("--> SamSungTV 객체3 생성");
		this.speaker = speaker;
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
		speaker.volumUp();
	}
	@Override
	public void volumeOff() {
		speaker.volumOff();
	}
}
