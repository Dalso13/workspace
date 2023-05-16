package org.joonzis.ex;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Ex06_HashMap {
	public static void main(String[] args) {
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		
		// 데이터 추가 : put(key, value)
		map.put("할머니", 120);
		map.put("할아버지", 110);
		map.put("엄마", 34);
		map.put("아빠", 34);
		map.put("동생", 11);
		map.put("동생", 12);	// key 중복 발생 (중복된 Key를 삽입 시 기존 value가 수정)
		
		// 삭제 ; remove(key)	key 만 찾아서 삭제
		map.remove("할머니");
		
		// 크기 확인 : size()
		System.out.println("entry 개수 : " + map.size());
		
		// 반복자는 key를 통해서 순회한다 (반복자의 타입 == key의 타입)
		// map의 key를 Set에 저장한다. 1번
		// map에서 key만 빼서 순회한다. 2번
		Set<String> set = map.keySet();
		Iterator<String> itr = set.iterator();
		
		// 저장된 value 가져오기 : get(key)
		while (itr.hasNext()) {
			String key = itr.next();
			Integer value = map.get(key);
			System.out.println("이름(key) : " + key + " , 나이(value) : " + value);
			
		}
		
		System.out.println("---------------");
		
		// itr 를 수회하고 나면 사용된 itr은 재사용이 불가하다.
		// 새로 itr 값을 받아서 사용해야 한다.
		
		itr = set.iterator(); // 다시 정보를 얻음
		while (itr.hasNext()) {
			String key = itr.next();
			Integer value = map.get(key);
			System.out.println("이름(key) : " + key + " , 나이(value) : " + value);
			
		}
		
		System.out.println("-------------------");
		
		System.out.println(map);	// 키=값 형태의 배열
		map.clear();				// map의 모든 객체 삭제
		System.out.println(map);
		
		
		
	}
}
