package org.joonzis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sample")
public class SampleController {
	
	@GetMapping("/ex01")
	public String sample01() {
		return "sample/sample";
	}
	@PostMapping("/ex01")
	public String sample02() {
		return "sample/sample";
	}
}
