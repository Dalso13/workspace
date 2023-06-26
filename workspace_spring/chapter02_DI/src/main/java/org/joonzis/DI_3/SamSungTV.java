package org.joonzis.DI_3;

public class SamSungTV implements TV{
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
		System.out.println("--> SamSungTV 볼륨 올리기");
	}
	@Override
	public void volumeUff() {
		System.out.println("--> SamSungTV 볼륨 내리기");
	}
}
