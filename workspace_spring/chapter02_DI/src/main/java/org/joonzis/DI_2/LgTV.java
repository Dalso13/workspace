package org.joonzis.DI_2;

public class LgTV implements TV{
	public LgTV() {
		System.out.println("--> LgTV 객체 생성");
	}
	@Override
	public void powerOn() {
		System.out.println("--> LgTV 전원 키기");
	}
	@Override
	public void powerOff() {
		System.out.println("--> LgTV 전원 끄기");
	}
	@Override
	public void volumeUp() {
		System.out.println("--> LgTV 볼륨 올리기");
	}
	@Override
	public void volumeUff() {
		System.out.println("--> LgTV 볼륨 내리기");
	}
}
