package org.joonzis.DI_12_component;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {
	public static void main(String[] args) {
		
		AbstractApplicationContext ctx =
				new GenericXmlApplicationContext("applicationContext12.xml");
		
		TV tv = ctx.getBean("tv", TV.class);
			
		tv.powerOn();
		tv.volumeOff();
		
		ctx.close();
	}
}
	
