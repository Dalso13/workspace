package org.joonzis.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class CommonController {
	
	@GetMapping("/accessError")
	public String accessDenied(Authentication auth, Model model) {
		log.info("access Denied : " + auth );
		model.addAttribute("msg", "Access Denied");
		return "/security/accessError";
	}
	
	
	@GetMapping("/customLogin")
	public String loginInput(String error, String logout, Model model) {
		log.info("error : " + error);
		log.info("logout : " + logout);
		
		if (error != null) {
			model.addAttribute("error", "Login Error Check your Account");
		}
		if (logout != null) {
			model.addAttribute("logout", "Logout!!");
		}

	
		return "/security/customLogin";
	
	}
	@PostMapping("/customLogout")
	public String logoutPage() {
		return "/security/customLogin";
	}
	
}
