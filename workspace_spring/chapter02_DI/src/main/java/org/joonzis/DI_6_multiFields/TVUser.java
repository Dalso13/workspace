package org.joonzis.DI_6_multiFields;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {
	public static void main(String[] args) {
		
		//	1. Spring 컨테이너 구동
		AbstractApplicationContext ctx = 
				new GenericXmlApplicationContext("applicationContext6.xml");
		
		TV stx = (SamSungTV)ctx.getBean("satv");
		
		stx.powerOn();
		stx.volumeUp();

	}
}
	
