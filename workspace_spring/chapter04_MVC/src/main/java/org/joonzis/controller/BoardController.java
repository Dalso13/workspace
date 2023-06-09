package org.joonzis.controller;

import java.util.List;

import org.joonzis.domain.BoardAttachVO;
import org.joonzis.domain.BoardVO;
import org.joonzis.domain.Criteria;
import org.joonzis.domain.PageDTO;
import org.joonzis.service.BoardSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/board/")
public class BoardController {
	
	@Autowired
	BoardSerivce bs;
	
	@GetMapping("/list")
	public String list(Model model, Criteria cri) {
		log.info("list");
		
		
		List<BoardVO> list = bs.getList(cri);
		
		model.addAttribute("list",list);
		model.addAttribute("pageMaker", new PageDTO(cri, bs.getTotal()));
		
		
		// 데이터 뷰로 전달
		return "board/list";
	}
	
	@PreAuthorize("isAuthenticated()")	// 인증된 사용자라면 true 가 나옴
	@GetMapping("/register")
	public String register(Model model, Criteria cri) {
		
		model.addAttribute("cri",cri);
		return "board/register";
	}
	
	@PreAuthorize("isAuthenticated()")	
	@PostMapping("/register")
	public String register(BoardVO vo, RedirectAttributes rt) {
		log.info("register : " + vo);
		
		bs.register(vo);
		
		rt.addFlashAttribute("result", "ok");
		return "redirect:/board/list";
	}
	
	@GetMapping("/get")
	public String get(@RequestParam("bno") int bno, Model model, Criteria cri)	{
		log.info("get");
		model.addAttribute("vo", bs.get(bno));
		model.addAttribute("cri", cri);
		
		return "board/get";
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/modify")
	public String modify(@RequestParam("bno") int bno, Model model, Criteria cri) {
		log.info("modify");
		model.addAttribute("vo", bs.get(bno));
		model.addAttribute("cri", cri);
		
		return "board/modify";
	}
	
	// 메소드 실행 전, 로그인한 사용자와 파라미터로 받은 작성자가 일치하는지 체크
	@PreAuthorize("principal.username == #vo.writer")
	@PostMapping("/modify")
	public String modify(BoardVO vo, RedirectAttributes rt) {
		log.info("modify");
		
		if (bs.modify(vo)) {
			rt.addFlashAttribute("result", "clear");
		}
		return "redirect:/board/list";
	}
	
	@PreAuthorize("principal.username == #vo.writer")
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") int bno, RedirectAttributes rt, Criteria cri) {
		log.info("remove1" + bno);
		
		boolean t = bs.remove(bno);
		
		if (t) {
			rt.addFlashAttribute("result", "clear");
			rt.addFlashAttribute("cri", "cri");
		}
		
		log.info("remove2" + bno);
		return "redirect:/board/list";
	}
	@GetMapping(value = "/getAttachList" , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<BoardAttachVO>> getAttachList(long bno){
		log.info("getAttachList" + bno);
		List<BoardAttachVO> vo = bs.getAttachList(bno);
		log.info(vo);
		return new ResponseEntity<>(vo, HttpStatus.OK);
	}
}
