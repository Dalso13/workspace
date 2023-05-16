package org.joonzis.ex;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Ex04_HashSet {
	public static void main(String[] args) {
		
		Set<String> set = new HashSet<String>();
		
		set.add("C");
		set.add("Spring");
		set.add("Java");
		set.add("DB");
		set.add("JSP");
		set.add("Web");
		set.add("Java");	// 중복 저장 시도
		
		Iterator<String> itr = set.iterator();
		
		while(itr.hasNext()) {
			String str = itr.next();
			if (str.equals("Spring")) {
				itr.remove();
			}
		}
		
//		set.remove("Spring");
//		set.removeAll(set);
		System.out.println(set);
	}
}
