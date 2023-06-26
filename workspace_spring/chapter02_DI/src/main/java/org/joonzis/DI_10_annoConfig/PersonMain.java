package org.joonzis.DI_10_annoConfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PersonMain {
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext(AnnoConfig.class);
		
		Person person = ctx.getBean("human1",Person.class);
		System.out.println("이름 : " + person.getName());
		System.out.println("나이 : " + person.getAge());
		System.out.println("취미 : " + person.getHobbies());
		
		System.out.println("===============================");
		
		Person person2 = ctx.getBean("human2", Person.class);
		
		System.out.println("이름 : " + person2.getName());
		System.out.println("나이 : " + person2.getAge());
		System.out.println("취미 : " + person2.getHobbies());
		 
		System.out.println("===============================");
		
		PersonInfo pInfo = ctx.getBean("pInfo", PersonInfo.class);
		
		pInfo.info();
		
	}
}
