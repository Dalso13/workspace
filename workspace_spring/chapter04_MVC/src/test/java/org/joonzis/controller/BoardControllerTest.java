package org.joonzis.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@WebAppConfiguration  // 컨트롤러 테스트할때 사용
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class BoardControllerTest {
	
	@Setter(onMethod_ = @Autowired)
	private WebApplicationContext ctx;
	
	// 가짜 MVC (가상으로 URL과 파타리머등을 브라우저에서 사용하는것처럼 실행 가능)
	private MockMvc mockMvc;
	
	
	@Before //  junit
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
//	@Test
//	public void testList() throws Exception{
//		
//		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/list"))
//				.andReturn().getModelAndView().getModelMap());
//		
	
	
//	@Test
//	public void testRegister() throws Exception {
//		String result = mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
//				.param("title", "컨테이너 테스트제목")
//				.param("content", "컨테이너 테스트내용")
//				.param("writer", "컨테이너 테스터")
//				).andReturn().getModelAndView().getViewName();
//
//		log.info(result);
//		
//	}
	
//	@Test
//	public void testGet() throws Exception {
//		String result = mockMvc.perform(MockMvcRequestBuilders.get("/board/get")
//				.param("bno", "3")).andReturn().getModelAndView().getViewName();
//
//		log.info(result);
//		
//	}
	
//	@Test
//	public void testRemove() throws Exception {
//		String result = mockMvc.perform(MockMvcRequestBuilders.post("/board/remove")
//				.param("bno", "3")).andReturn().getModelAndView().getViewName();
//
//		log.info(result);
//		
//	}
	
	@Test
	public void testModify() throws Exception {
		String result = mockMvc.perform(MockMvcRequestBuilders.post("/board/modify")
				.param("title", "컨테이너 업데이트 제목")
				.param("content", "컨테이너 업데이트 내용")
				.param("writer", "컨테이너 업데이터")
				.param("bno", "1")
				).andReturn().getModelAndView().getViewName();

		log.info(result);
		
	}
	
	
}
