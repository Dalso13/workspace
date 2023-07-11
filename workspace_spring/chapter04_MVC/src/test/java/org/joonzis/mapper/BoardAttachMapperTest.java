package org.joonzis.mapper;

import java.util.List;

import org.joonzis.domain.BoardAttachVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardAttachMapperTest {
	
	@Autowired
	BoardAttachMapper mapper;
	
//	@Test
//	public void test1() {
//		BoardAttachVO vo = new BoardAttachVO();
//		vo.setBno(42);
//		vo.setFileName("test");
//		vo.setUploadPath("url");
//		vo.setUuid("hi");
//		
//		mapper.insert(vo);
//		
//	}
	
	@Test
	public void test1() {
		List<BoardAttachVO> vos = mapper.findByBno(42);
		
		for (BoardAttachVO vo : vos) {
			log.info(vo);
		}
		
		
	}
	
//	@Test
//	public void test1() {
//		
//		mapper.delete("hi");
//		
//		
//	}
}
