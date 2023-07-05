package org.joonzis.controller;

import org.joonzis.domain.SampleVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j;

@RestController
@Log4j
@RequestMapping("/sample")
public class SampleController {
	
	@GetMapping(value = "/getText" , produces = "text/plain; charset=utf-8")
	public String getText() {
		log.info("Mime Type : " + MediaType.TEXT_PLAIN_VALUE);
		
		// 기존 jsp 파일의 이름이 아닌 순수 데이터를 전달
		return "안녕하세요.";
	}
										// 데이터가 명확하면 produces 생략은 가능
	@GetMapping(value = "/getSample", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, 
			MediaType.APPLICATION_XML_VALUE})
	public SampleVO name() {
		return new SampleVO(112, "스타", "로드");
	}
	
	@GetMapping(value = "/check" , params = {"height" , "weight"})
	public ResponseEntity<SampleVO> check(Double height , Double weight){
		
		// Rest 방식으로 호출하는 경우에는 화면이 아닌 데이터 자체를 전송하는 방식으로 처리
		// 데이터를 요청한 쪽에서는 정상적인 데이터인지, 비정상적인 데이터인지 구분할 수 있는
		// 확실한 방법을 제공해야 함
		// ResponseEntity 는 데이터와 함께 HTTP 헤더의 상태 메시지등을 같이 전달하는 용도로 사용
		// HTTP의 상태 코드와 에러 메세지 등을 함께 전달할 수 있기 때문에 받는 입장에서는 확실하게 결과를 알 수 있다.
		
		SampleVO vo = new SampleVO(0, ""+height , "" +weight);
		
		ResponseEntity<SampleVO> result = null;
		
		if (height < 150) {
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo);
		} else {
			result = ResponseEntity.status(HttpStatus.OK).body(vo);
		}
		
		return result;
	}
	
	/*
	 * {} 에 적힌 부분을 변수로 처리 가능 (rest에서 주로 사용)
	 * @pathVariable 사용 이유 : 파라미터로 데이터 전달을 간단하게 바꾸기 위해
	 * 기존 : product?cat=cattt&pid=123
	 * @pathVariable : product/cattt/123
	 */
	
	@GetMapping("/product/{cat}/{pid}")
	public String[] getPath(@PathVariable("cat") String cat,
							@PathVariable("pid") Integer pid) { // 기본 자료형 x
		return new String[] {"category : " + cat, "productid : " + pid};  
	}
}
