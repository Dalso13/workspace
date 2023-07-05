package org.joonzis.service;

import org.joonzis.domain.ReplyVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class ReplyServiceTest {
	
	@Autowired
	ReplyService service;
	
//	@Test
//	public void testListSer() {
//		log.info(service.getListSer(4));
//	}
	
//	@Test
//	public void testReadSer() {
//		log.info(service.readSer(3));
//	}
	
//	@Test
//	public void testInsertSer() {
//		ReplyVO vo = new ReplyVO();
//		
//		vo.setBno(5);
//		vo.setReply("재밌습니다");
//		vo.setReplyer("admins");
//		
//		log.info(service.insertSer(vo));
//	}
	
//	@Test
//	public void testUpdateSer() {
//		ReplyVO vo = new ReplyVO();
//		
//		vo.setReply("재미없습니다");
//		vo.setRno(4);
//		
//		log.info(service.updateSer(vo));
//	}
	
//	@Test
//	public void testRemoveSer() {
//		log.info(service.deleteSer(4));
//	}
}
