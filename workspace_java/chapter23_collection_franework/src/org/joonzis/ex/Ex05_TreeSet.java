package org.joonzis.ex;

import java.util.TreeSet;

public class Ex05_TreeSet {
	public static void main(String[] args) {
		
		
		// TreeSet 의 메소드를 사용하기 위해 Set 대신 TreeSet 사용
		TreeSet<String> set = new TreeSet<String>();
		
		set.add("airplane");
		set.add("apple");
		set.add("area");
		set.add("disc");
		set.add("dance");
		
		/*
		 * 1. 메소드 정의
		 * 
		 * headSet 	: 지정된 객체보다 작은 값의 객체들 반환
		 * subSet	: 범위 내의 검색 결과 반환
		 * tailSet	: 지정된 객체보다 큰 값의 객체들 반환
		 */
		
		System.out.println(set.headSet("b"));
		System.out.println(set.subSet("a", "aq"));
		System.out.println(set.tailSet("c"));
		
		TreeSet<Integer> setInt = new TreeSet<Integer>();
		
		setInt.add(10);
		setInt.add(20);
		setInt.add(30);
		setInt.add(40);
		setInt.add(50);
		
		System.out.println(setInt.headSet(25));
		System.out.println(setInt.subSet(15, 35));
		System.out.println(setInt.tailSet(35));

	}
}
