package org.joonzis.ex;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Ex03_json {
	
	@SuppressWarnings("unchecked") // 경고를 숨김 (안쓸거임 난)
	public static void main(String[] args) {
		
		JSONObject obj = new JSONObject();
		
		obj.put("name", "김");
		obj.put("age", 20);
		obj.put("isAdult", true);
		obj.put("phone", null);
		
		// JSON 객체 -> 자바 String 으로 변환(.toJSONString())
		String jsonMsg = obj.toJSONString();
		System.out.println(jsonMsg);
		
		
		// JSONArray는 자바의 List를 구현
		// List에서 데이터 저장은 add(value)
		JSONArray list = new JSONArray();
		list.add(obj);
		
		System.out.println(list);
		System.out.println(list.toJSONString());
	}
}
