package org.joonzis.ex;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class Ex01_json {
	public static void main(String[] args) {
		
		//JSON
		// {"name":"김", "age":20, "isAdult":true, "phone":null}
		// 위 예시를 자바의 String 으로 생성해보자
		// "큰 따옴표를 표현하려면 \를 이용
		
		String jsonMsg = "{\"name\":\"김\", \"age\":20, \"isAdult\":true, \"phone\":null}";
		
		JSONParser parser = new JSONParser(); 	// jar 파일
		JSONObject obj = null;					// json 객체
		
		// 변환 시 ParseException이 발생할 수 있으므로 try-catch 처리
		// String -> JSON 객체 변환
		
		try {
			obj = (JSONObject)parser.parse(jsonMsg);
			
			
		} catch (Exception e) {
			System.out.println("자바 String > JSon 객체 변환 실패");
			e.printStackTrace();
		}
		
		// JSON 객체로 변환된 obj는 자바의 Map을 구현한 형태
		System.out.println("이름 :" + obj.get("name"));
		System.out.println("나이 :" + obj.get("age"));
		System.out.println("연락처 :" + obj.get("phone"));
		System.out.println((Boolean)obj.get("isAdult") ? "성인" : "미성년자");
		
		
		
	}
}
