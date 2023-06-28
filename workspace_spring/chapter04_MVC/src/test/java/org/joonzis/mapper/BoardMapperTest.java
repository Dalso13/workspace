package org.joonzis.mapper;

import java.util.List;

import org.joonzis.domain.BoardVO;
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
public class BoardMapperTest {
	
	@Setter(onMethod_ = @Autowired)
	BoardMapper mapper;
	
	/*
	 * @Test public void testGetList() { //mapper.getList().forEach(board ->
	 * log.info(board)); 람다식
	 * 
	 * List<BoardVO> vos = mapper.getList();
	 * 
	 * for (BoardVO vo : vos) { log.info(vo); } }
	 */
	
	@Autowired
	BoardVO vo;
	
	
	  @Test 
	  public void testInsert() {
	  
		  String title = "테스트제목6"; 
		  String content = "테스트내용6"; 
		  String writer = "user06";
		  vo.setTitle(title); 
		  vo.setContent(content); 
		  vo.setWriter(writer);
		  
		  mapper.insert(vo); 
	  }
	 
	
	
	  @Test 
	  public void testRead() { 
		int bno = 1;
		  
		  BoardVO lists = mapper.read(bno);
		  
		  log.info(lists); 
	  }
	 
	
	
	  @Test 
	  public void testDelete() {
	
		  mapper.delete(7);
	  
	  }
	  
	  @Test 
	  public void testUpdate() { 
		  vo.setBno(6); 
		  vo.setTitle("테스트 유저006");
		  vo.setWriter("user06"); 
		  vo.setContent("테스트 업데이트");
	  
		  mapper.update(vo); 
	  }
	 
}
