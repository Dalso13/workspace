package org.joonzis.DI_3;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {
	public static void main(String[] args) {
		
		//	1. Spring 컨테이너 구동
		AbstractApplicationContext ctx = 
				new GenericXmlApplicationContext("applicationContext3.xml");
		
		// 2. Spring 컨테이너로부터 필요한 객체 요정
		
		TV lgtv = (LgTV)ctx.getBean("lgtv");
		lgtv.powerOn();
		
		TV saTv = (SamSungTV)ctx.getBean("satv");
		// 순서와 상관없이 생성자 호출을 가장먼저함
	}
}
	
