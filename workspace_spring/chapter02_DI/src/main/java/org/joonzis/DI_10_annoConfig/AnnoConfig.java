package org.joonzis.DI_10_annoConfig;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

// sts 버전 3 에서 사용시 해당 프로젝트에 CGLIB 라이브러리 추가  --3버전 이후는 내장되어있음


@Configurable  // ApplicationContext 와 같은 역할을 하는 자바 클래스
public class AnnoConfig {
	
	@Bean	// Bean 을 만드는 메소드
	public Person human1() {	// <bean id = "human1" class = "Person객체 경로(org.jo...)">
 		Set<String> hobbies = new HashSet<String>();
 		hobbies.add("여행");
 		hobbies.add("게임");
 		hobbies.add("영화");
 		
 		Person person = new Person();
 		
 		person.setHobbies(hobbies);
 		person.setName("장동완");
 		person.setAge(23);
 		
 		
 		return person;
	}
	
	
	@Bean(name = "human2") // @Bean= "bean의 id"
	public Person abc() {	// <bean id = "human1" class = "Person객체 경로(org.jo...)">
 		Set<String> hobbies = new HashSet<String>();
 		hobbies.add("독서");
 		hobbies.add("산책");
 		hobbies.add("헬스");
 		
 		Person person = new Person();
 		
 		person.setHobbies(hobbies);
 		person.setName("김동원");
 		person.setAge(22);
 		
 		
 		return person;
	}
	
	@Bean
	public PersonInfo pInfo() {
		Set<String> hobbies = new HashSet<String>();
 		hobbies.add("곤충 채집");
 		hobbies.add("자전거 타기");
 		hobbies.add("요가");
 		
 		PersonInfo personInfo = new PersonInfo();
 		personInfo.setPerson(new Person("김동원",22,hobbies));
 		
 		return personInfo;
	}
}
