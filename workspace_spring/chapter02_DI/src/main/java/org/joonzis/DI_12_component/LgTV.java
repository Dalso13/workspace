package org.joonzis.DI_12_component;

import org.springframework.stereotype.Component;


/*
 *  @Component 와 @Configurable bean 는 기능이 비슷하다
 *  @Component는 클래스 단위
 *  bean은 메소드 단위
 */

/*
 *  java =>  @Component("tv")
 *  xml => <bean id="tv" class=경로 />
 *  
 */

@Component("tv")
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
	public void volumeOff() {
		System.out.println("--> LgTV 볼륨 내리기");
	}
}
