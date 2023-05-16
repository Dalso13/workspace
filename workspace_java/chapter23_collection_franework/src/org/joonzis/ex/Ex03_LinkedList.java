package org.joonzis.ex;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Ex03_LinkedList {
	public static void main(String[] args) {
		/*
		 * ArrayList 와 LinkedList 성능 비교
		 * 1000개의 객체를 0번 인덱스에 삽입하는데 걸리는 시간을 측정
		 * 
		 * - 순차적으로 추가/삭제하는 경우에는 ArrayList 가 빠르지만
		 * 중간에 추가/삭제 하는 경우는 LinkedList 가 더욱 빠르다
		 */
		
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new LinkedList<String>();
		
		long startTime;
		long endTime;
		
//		
//		ArrayList
		startTime = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			list1.add(0, String.valueOf(i));
		}
		endTime = System.nanoTime();
		System.out.println("Arraylist  걸린 시간 : " + (endTime - startTime) + "ns");
		
		//Linkedlist
		startTime = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			list2.add(0, String.valueOf(i));
		}
		endTime = System.nanoTime();
		System.out.println("linkedlist 걸린 시간 : " + (endTime - startTime) + "ns");
		
	}
}
