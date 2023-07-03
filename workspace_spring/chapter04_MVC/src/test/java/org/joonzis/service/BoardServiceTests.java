package org.joonzis.service;

import org.joonzis.domain.BoardVO;
import org.joonzis.domain.Criteria;
import org.joonzis.mapper.BoardMapper;
import org.joonzis.mapper.BoardMapperTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardServiceTests {
	
	@Setter(onMethod_ = @Autowired)
	BoardSerivce service;
	
	
	
	@Test
	public void getList() {
		Criteria cri = new Criteria(1, 10);
		service.getList(cri);
	}
	
//	@Test
//	public void get() {
//		service.get(2);
//	}
//	@Test
//	public void register() {
//		  String title = "새로운 테스트제목7"; 
//		  String content = "새로운 테스트내용7"; 
//		  String writer = "새로운 user07";
//		  vo.setTitle(title); 
//		  vo.setContent(content); 
//		  vo.setWriter(writer);
//		  
//		service.register(vo);
//	}
//	@Test
//	public void remove() {
//		service.remove(2);
//	}
//	@Test
//	public void update() {
//		  vo.setBno(6); 
//		  vo.setTitle("업데이트 테스트 유저006");
//		  vo.setWriter("user06"); 
//		  vo.setContent("테스트 업데이트006");
//	 
//		
//		service.modify(vo);
//	}
}
