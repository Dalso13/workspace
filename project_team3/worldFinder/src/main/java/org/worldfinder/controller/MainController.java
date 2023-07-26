package org.worldfinder.controller;

import com.google.gson.Gson;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.worldfinder.domain.CountryClassVO;
import org.worldfinder.service.MainService;

import java.util.List;

@Log4j
@Controller
public class MainController {

	@Setter(onMethod_= @Autowired)
	private MainService service;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String mainPage(Model model) {
		List<CountryClassVO> country = service.readCountry();

		Gson gson = new Gson();

		String test = gson.toJson(country);



		model.addAttribute("country", test);
		
		return "main/index";
	}
}
