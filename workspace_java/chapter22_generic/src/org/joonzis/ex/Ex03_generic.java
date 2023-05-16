package org.joonzis.ex;

import java.util.Arrays;

public class Ex03_generic {
	
	// T가 붙는 순간 제네릭 메소드
	static <T> void printArray(T[] arr) {
		System.out.println(Arrays.toString(arr));
	}
	public static void main(String[] args) {
		
		Integer arr1[] = {1,2,3,4,5};
		printArray(arr1);
		
		Double[] arr2 = {1.5,2.5,3.5};
		printArray(arr2);
		
		String[] arr3 = {"1","2","3"};
		printArray(arr3);
		
	}
}
