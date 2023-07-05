package org.joonzis.mapper;

import java.util.List;

import org.joonzis.domain.ReplyVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class ReplyMapperTest {
	
	@Setter(onMethod_ = @Autowired )
	ReplyMapper mapper;
	
//	  @Test
//	  public void testInsert() {
//		  ReplyVO vo = new ReplyVO();
//		  vo.setBno(4);
//		  vo.setReply("안녕하세요");
//		  vo.setReplyer("admin2");
//		  
//		  mapper.insert(vo); 
//		  
//		  
//	  }
	  
//	  @Test 
//	  public void testRead() { 
//		 int rno = 1;
//		  
//		 ReplyVO lists = mapper.read(rno);
//		  
//		  log.info(lists); 
//	  }
//	  
//	  @Test
//	  public void testList() {
//		  List<ReplyVO> vos = mapper.getList(4);
//		  
//		  vos.forEach(a -> log.info(a));
//	  }
	
//	  @Test 
//	  public void testDelete() {
//	
//		  mapper.delete(2);
//	  
//	  }

//	  @Test 
//	  public void testUpdate() { 
//		 ReplyVO vo = new ReplyVO();
//		  vo.setReply("반갑습니다");
//		  vo.setRno(3);
//	  
//		  mapper.update(vo); 
//	  }
}
