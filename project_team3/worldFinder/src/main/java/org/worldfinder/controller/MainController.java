package org.worldfinder.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.worldfinder.domain.CountryClassVO;
import org.worldfinder.domain.ReportVO;
import org.worldfinder.domain.RequestVO;
import org.worldfinder.service.MainService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j
@Controller
public class MainController {

	@Setter(onMethod_= @Autowired)
	private MainService service;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String mainPage(Model model) {
		List<CountryClassVO> country = service.readCountry();

//		Gson gson = new Gson();
//
//		String test = gson.toJson(country);
//
//
//
//		model.addAttribute("country", test);
		
		return "main/index";
	}
	@GetMapping("/request")
	public String requestPage(){
		return "main/request";
	}
	@PostMapping("/request")
	public String requestData(RequestVO vo, Model model){

		int result = service.writeRequest(vo);

		model.addAttribute("result",result);

		return "main/request_clear";
	}

	@GetMapping("/adminPage")
	public String adminPage(Model model){

			model.addAttribute("request",service.readRequest());
			return "main/admin";
	}



	@GetMapping("/country")
	public String country() {
		return "country/country";
	}

	@GetMapping("/countryWrite")
	public String countryWrite(Model model) {

		List<CountryClassVO> vos = service.readContinent();

		Gson gson = new Gson();

		String cont = gson.toJson(vos);

		model.addAttribute("cont",cont);


		return "country/countryWrite";
	}
	
	// ajax 로 데이터 받는 애들
	@PostMapping(value = "/adminPage/getReport/{category}" ,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public List<ReportVO> adminReport(@PathVariable String category) {

		return service.readReport(category);
	}
	@GetMapping(value = "/logoSeach" ,  produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public List<CountryClassVO> logoSearch() {

		return service.readCountry();
	}

	@PostMapping(value =  "/countryWrite/countryList/{details_continent}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public List<Map<String,String>> countryList(@PathVariable String details_continent){

		List<Map<String,String>> result = service.countryList(details_continent);




		return result;
	}
}
