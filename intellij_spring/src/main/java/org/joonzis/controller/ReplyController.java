package org.joonzis.controller;

import java.util.List;

import org.joonzis.domain.ReplyVO;
import org.joonzis.service.ReplyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@RestController
@RequestMapping("/replies/")
@AllArgsConstructor
public class ReplyController {
	
	/*
	    * 동작에 따른 url 방법(http 전송 방식)
	    * 1. 등록 - /replies/new - POST
	    * 2. 조회 - /replies/:rno - GET
	    * 3. 삭제 - /replies/:rno - DELETE
	    * 4. 수정 - /replies/:rno - PUT or PATCH
	    * 5. 페이지 - /replies/pages/:bno/:page - GET
	    * 
	    * == REST 방식으로 설계할 땐 PK 기준으로 작성하는 것이 좋다. PK 만으로 CRUD가 가능하기 때문
	    * == 다만 댓글 목록은 PK 만으론 안되고 bno와 페이지 번호 정보가 필요
	    */
	
	private ReplyService service;
	
	// 1. 등록
	@PostMapping(value = "/new", consumes = "application/json" , produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> create(@RequestBody ReplyVO vo) {
		log.info("ReplyVO ....."  + vo);
		
		int insertCount = service.insertSer(vo);
		
		log.info("Reply Insert Count : " + insertCount);
		
		return insertCount > 0 ? new ResponseEntity<>("success", HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	// 2. 목록
	@GetMapping(value = "/pages/{bno}/{page}",
			produces = {MediaType.APPLICATION_XML_VALUE,
						MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<ReplyVO>> getList(@PathVariable("bno") long bno,
												 @PathVariable("page") int page) {
		log.info("getList..." + bno);
		
		List<ReplyVO> vo = service.getListSer(bno);
		
		return new ResponseEntity<>(vo, HttpStatus.OK);
	}
	
	// 삭제
	@DeleteMapping(value = "/{rno}")
	public ResponseEntity<String> remove(@PathVariable("rno") long rno) {
		log.info("remove..." + rno);
			
			if (service.deleteSer(rno)) {
				return new ResponseEntity<>("success", HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		
	}
	
	// 하나 조회
	@GetMapping(value = "/{rno}" , produces = 
			{MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ReplyVO> view(@PathVariable("rno") long rno) {
		log.info("view..." + rno);
		
		return new ResponseEntity<>(service.readSer(rno), HttpStatus.OK);
	}
	
	// 업데이트
	@RequestMapping(value = "/{rno}", method = {RequestMethod.PUT , RequestMethod.PATCH} 
						, consumes = "application/json" , produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> updateC(@PathVariable("rno") long rno, @RequestBody ReplyVO vo) {
		log.info("updateC..." + rno);
		
		vo.setRno(rno);
		
		if (service.updateSer(vo)) {
			return new ResponseEntity<>("success", HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
