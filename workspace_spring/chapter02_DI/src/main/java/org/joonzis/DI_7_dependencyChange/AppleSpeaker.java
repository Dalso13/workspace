package org.joonzis.DI_7_dependencyChange;

public class AppleSpeaker implements Speaker{
	public AppleSpeaker() {
		System.out.println("--> AppleSpeaker 객체 생성.");
	}
	@Override
	public void volumUp() {
		System.out.println("--> AppleSpeaker 볼륨 올린다.");
	}
	@Override
	public void volumOff() {
		System.out.println("--> AppleSpeaker 볼륨 내린다.");
	}
}
