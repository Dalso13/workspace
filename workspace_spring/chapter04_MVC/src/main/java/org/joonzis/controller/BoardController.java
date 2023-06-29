package org.joonzis.controller;

import java.util.List;

import org.joonzis.domain.BoardVO;
import org.joonzis.service.BoardSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/board/")
public class BoardController {
	
	@Autowired
	BoardSerivce bs;
	
	@GetMapping("/list")
	public String list(Model model) {
		log.info("list");
		
		
		List<BoardVO> list = bs.getList();
		
		model.addAttribute("list",list);
		
		
		// 데이터 뷰로 전달
		return "board/list";
	}
	
	@GetMapping("/register")
	public String register() {
		return "board/register";
	}
	
	@PostMapping("/register")
	public String register(BoardVO vo, RedirectAttributes rt) {
		log.info("register");
		
		bs.register(vo);
		
		rt.addFlashAttribute("result", "ok");
		return "redirect:/board/list";
	}
	
	@GetMapping("/get")
	public String get(@RequestParam("bno") int bno, Model model)	{
		log.info("get");
		model.addAttribute("vo", bs.get(bno));
		
		return "board/get";
	}
	
	@GetMapping("/modify")
	public String modify(@RequestParam("bno") int bno, Model model) {
		log.info("modify");
		model.addAttribute("vo", bs.get(bno));
		
		return "board/modify";
	}
	
	
	@PostMapping("/modify")
	public String modify(BoardVO vo, RedirectAttributes rt) {
		log.info("modify");
		
		if (bs.modify(vo)) {
			rt.addFlashAttribute("result", "clear");
		}
		return "redirect:/board/list";
	}
	
	
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") int bno, RedirectAttributes rt) {
		log.info("remove");
		
		
		
		if (bs.remove(bno)) {
			rt.addFlashAttribute("result", "clear");
		}
		return "redirect:/board/list";
	}
	
}
