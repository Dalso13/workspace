package org.joonzis.DI_11_annoConfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class PersonMain {
	public static void main(String[] args) {

		// 1. AnnoConfig.JAVA 를 이용하여 Bean 객체 출력
		// 2. applicationContext.xml 파일을 이용하여 Bean 객체 출력

		AnnotationConfigApplicationContext acc = 
				new AnnotationConfigApplicationContext(AnnoConfig.class);
		
		Person person = acc.getBean("con",Person.class);
		
		System.out.println("이름 : " + person.getName());
		System.out.println("키 : " + person.getHeight());
		System.out.print("취미 : ");
		
		for (String string : person.getHobbies()) {
			System.out.print(string + " ");
		}
		
		System.out.println("-------------------------------\n");
		
		AbstractApplicationContext aac =
				new GenericXmlApplicationContext("applicationContext10.xml");
		
		Person person2 = aac.getBean("person",Person.class);
		
		System.out.println("이름 : " + person2.getName());
		System.out.println("키 : " + person2.getHeight());
		System.out.print("취미 : ");
		
		for (String string : person2.getHobbies()) {
			System.out.print(string + " ");
		}
		
		acc.close();
		aac.close();
	
		
	}
}
