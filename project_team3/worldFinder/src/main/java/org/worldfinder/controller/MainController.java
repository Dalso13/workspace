package org.worldfinder.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.worldfinder.domain.CountryClassVO;
import org.worldfinder.domain.CountryVO;
import org.worldfinder.domain.ReportVO;
import org.worldfinder.domain.RequestVO;
import org.worldfinder.service.MainService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Log4j
@Controller
public class MainController {

	@Setter(onMethod_ = @Autowired)
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
	public String requestPage() {
		return "main/request";
	}

	@PostMapping("/request")
	public String requestData(RequestVO vo, Model model) {

		int result = service.writeRequest(vo);

		model.addAttribute("result", result);

		return "main/request_clear";
	}

	@GetMapping("/adminPage")
	public String adminPage(Model model) {

		model.addAttribute("request", service.readRequest());
		return "main/admin";
	}

// 나라 메인페이지
	@GetMapping("/country/{country}")
	public String country(@PathVariable String country,Model model) {

		model.addAttribute("countryPage",service.readCountryPage(country));
		model.addAttribute("reCountry",country);

		return "country/country";
	}

	@GetMapping("/countryWrite")
	public String countryWrite(Model model) {

		List<CountryClassVO> vos = service.readContinent();

		Gson gson = new Gson();

		String cont = gson.toJson(vos);

		model.addAttribute("cont", cont);


		return "country/countryWrite";
	}

	// ajax 로 데이터 받는 애들
	@PostMapping(value = "/adminPage/getReport/{category}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public List<ReportVO> adminReport(@PathVariable String category) {

		return service.readReport(category);
	}

	// 나라 불러오기
	@GetMapping(value = "/logoSeach", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public List<CountryClassVO> logoSearch() {

		return service.readCountry();
	}

	@PostMapping(value = "/countryWrite/countryList/{details_continent}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public List<Map<String, String>> countryList(@PathVariable String details_continent) {

		List<Map<String, String>> result = service.countryList(details_continent);


		return result;
	}

	@PostMapping("/countryWrite")
	public String countryWrite(CountryVO vo) {

		log.info(vo.toString());
		log.info(vo.getC_img());
		log.info(vo.getCountry());
		log.info(vo.getContent());

		service.writeCountry(vo);

		return "country/country";
	}
	
	// 이미지 저장
	@PostMapping(value = "/country/imgAjax", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, String> uploadAjaxAction(MultipartFile uploadFile) {
		log.info("uploadAjaxAction --");


		String uploadFolder = "c:\\upload";

		File uploadPath = new File(uploadFolder, "countryMain");
		log.info("upload path : " + uploadPath);

		if (uploadPath.exists() == false) { // uploadPath 형태의 파일이 없을 경우
			uploadPath.mkdirs(); // 디랙토리(파일) 생성
		}

		log.info("----------------------------");
		log.info("upload File Name : " + uploadFile.getOriginalFilename());
		log.info("upload File Size : " + uploadFile.getSize());

		UUID uuid = UUID.randomUUID();

		String uploadFileName = uuid.toString() + "_" + uploadFile.getOriginalFilename();

		try {
			File saveFile = new File(uploadPath, uploadFileName);
			uploadFile.transferTo(saveFile);

		} catch (Exception e) {
			log.error(e.getMessage());
		}
		Map<String, String> result = new HashMap<>();

		result.put("c_img", uploadFileName);

		return result;

	}

	// 파일 보여주기
	@GetMapping( value = "/country/viewImg")
	public ResponseEntity<Resource> viewImg(@RequestParam String filename){
		String path = "c:\\upload\\countryMain\\";

		Resource resource = new FileSystemResource(path + filename);

		if (!resource.exists()){
			return  new ResponseEntity<Resource>(HttpStatus.NOT_FOUND);
		}

		HttpHeaders headrs = new HttpHeaders();
		Path filePath = null;

		try {
			filePath = Paths.get(path + filename);
			headrs.add("Content-Type" , Files.probeContentType(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return new ResponseEntity<Resource>(resource, headrs, HttpStatus.OK);
	}
}