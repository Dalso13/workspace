package org.joonzis.DI_11_annoConfig;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

// sts 버전 3 에서 사용시 해당 프로젝트에 CGLIB 라이브러리 추가  --3버전 이후는 내장되어있음


@Configurable  // ApplicationContext 와 같은 역할을 하는 자바 클래스
public class AnnoConfig {
	
	@Bean
	public Person con() {
		Person person = new Person();
		
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("여행");
		list.add("게임");
		list.add("독서");
		
		person.setHobbies(list);
		person.setName("장동완");
		person.setHeight(167.5);
		
		return person;
	}
}
