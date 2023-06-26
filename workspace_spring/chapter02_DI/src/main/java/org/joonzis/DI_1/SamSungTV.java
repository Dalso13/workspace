package org.joonzis.DI_1;

public class SamSungTV {
	public SamSungTV() {
		System.out.println("--> SamSungTV 객체 생성");
	}

	public void powerOn() {
		System.out.println("--> SamSungTV 전원 키기");
	}

	public void powerOff() {
		System.out.println("--> SamSungTV 전원 끄기");
	}

	public void volumeUp() {
		System.out.println("--> SamSungTV 볼륨 올리기");
	}

	public void volumeUff() {
		System.out.println("--> SamSungTV 볼륨 내리기");
	}
}
