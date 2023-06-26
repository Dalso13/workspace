package org.joonzis.DI_8_set;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {
	public static void main(String[] args) {
		
		//	1. Spring 컨테이너 구동
		AbstractApplicationContext ctx = 
				new GenericXmlApplicationContext("applicationContext8.xml");
		
		TV stx = (SamSungTV)ctx.getBean("sonyTV");
		TV stx2 = (SamSungTV)ctx.getBean("appleTV");
		
		System.out.println("-------------------------");
		stx.powerOn();
		stx.volumeUp();
		
		System.out.println("-------------------------");
		
		stx2.powerOn();
		stx2.volumeUp();

	}
}
	
