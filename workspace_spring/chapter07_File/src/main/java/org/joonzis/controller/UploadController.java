package org.joonzis.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.joonzis.domain.AttachFileDTO;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class UploadController {
	
	@GetMapping("/uploadForm")
	public String uploadForm() {
		log.info("upload form--");
		
		return "uploadForm";
	}
	
	@PostMapping("/uploadFormAction")
	public void uploadFormAction(MultipartFile[] uploadFile , Model model) {
		log.info("uploadFormAction --");
		
		/*
		 * MultipartFile 의 메소드
		 * 
		 * String getName()					- 파라미터의 이름 <input>  태그의 이름
		 * String getOriginalFileName()		- 업로드 되는 파일 이름
		 * boolean isEmpty()				- 파일이 존재하지 않는 경우 true
		 * long getSize()					- 업로드 파일 크기
		 * byte[] getBytes()				- byte[] 로 파일 데이터 변환
		 * inputStream getInputSream()		- 파일 데이터와 연결된 InputStream 반환
		 * transferTo(File file)			- 파일 저장
		 */
		String uploadFolder = "c:\\upload"; 
		
		for (MultipartFile multipartFile : uploadFile) {
			log.info("----------------------------");
			log.info("upload File Name : " + multipartFile.getOriginalFilename());
			log.info("upload File Size : " + multipartFile.getSize());
			
			File saveFile = new File(uploadFolder , multipartFile.getOriginalFilename());
			
			try {
				multipartFile.transferTo(saveFile);
			} catch (Exception e) {
				log.error(e.getMessage());
			}
			
		}
		
	}
	
	
	@GetMapping("/uploadAjax")
	public String uploadAjax() {
		log.info("upload ajax");
		
		return "uploadAjax";
	}
	
	@PostMapping(value = "/uploadAjaxAction", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<AttachFileDTO>> uploadAjaxAction(MultipartFile[] uploadFile) {
		log.info("uploadAjaxAction --");
		
		List<AttachFileDTO> dtos = new ArrayList<AttachFileDTO>();
		
		
		String uploadFolder = "c:\\upload"; 
		
		File uploadPath = new File(uploadFolder, getFolder());
		log.info("upload path : " + uploadPath);
		
		if (uploadPath.exists() == false) { // uploadPath 형태의 파일이 없을 경우
			uploadPath.mkdirs(); // 디랙토리(파일) 생성
		}
		
		
		for (MultipartFile multipartFile : uploadFile) {
			log.info("----------------------------");
			log.info("upload File Name : " + multipartFile.getOriginalFilename());
			log.info("upload File Size : " + multipartFile.getSize());
				
			AttachFileDTO dto = new AttachFileDTO();
			
			UUID uuid = UUID.randomUUID(); // 랜덤값 생성
				
			String uploadFileName = uuid.toString() + "_" + multipartFile.getOriginalFilename();
				
			try {
				File saveFile = new File(uploadPath , uploadFileName);
				multipartFile.transferTo(saveFile);
					
				dto.setFileName(multipartFile.getOriginalFilename());
				dto.setUuid(uuid.toString());
				dto.setUploadPath(getFolder());
				dtos.add(dto);
			} catch (Exception e) {
				log.error(e.getMessage());
			}
		}

		return new ResponseEntity<List<AttachFileDTO>>(dtos, HttpStatus.OK);
		
		
	}
	
	private String getFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date date = new Date();
		String str = sdf.format(date);
		return str.replace("-", File.separator);
	}
	
	@GetMapping(value = "/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<Resource> dd(String fileName) throws UnsupportedEncodingException {
		log.info("download file : " + fileName);
		
		fileName = URLEncoder.encode(fileName, "UTF-8").replaceAll("\\+", "%20");
		
		Resource resource = new FileSystemResource("c:\\upload\\" + fileName);
		
		String resourceName = resource.getFilename();
		
		String resourceOriginalName = resourceName.substring(resourceName.indexOf("_")+1);
		
		HttpHeaders headers = new HttpHeaders();
		
		try {
			headers.add("content-Disposition", "attachment; filename=" +
					new String(resourceOriginalName.getBytes("utf-8"), "ISO-8859-1"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
	}
	
}
