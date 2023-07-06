package org.joonzis.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class SampleServiceTest {
	
	@Autowired
	SampleService service;
	
//	@Test
//	public void testService() {
//		log.info("service");
//		log.info(service.getClass().getName());
//	}
//	
	@Test
	public void testAdd() {
		try {
			log.info(service.doAdd("123", "234"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//	@Test
//	public void testException() {
//		try {
//			log.info(service.doAdd("n23", "234"));
//		} catch (Exception e) {
//		}
//	}
}
