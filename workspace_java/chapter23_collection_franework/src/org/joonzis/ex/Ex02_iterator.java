package org.joonzis.ex;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ex02_iterator {
	public static void main(String[] args) {
		
		
		List<Integer> list = new ArrayList<Integer>();
		
		// 10...20...100 저장하기
		
		for (int i = 1; i <= 10; i++) {
			list.add(i*10);
		}
		
		System.out.println(list);
		
		
		// 반복자 호출
		Iterator<Integer> itr = list.iterator();
		
		while (itr.hasNext()) {
			System.out.println(itr.next());	// itr을 쓰면 안에 있는 값이 호출되고 itr은 재사용못함
			
		}
		
		
		
	}
}
