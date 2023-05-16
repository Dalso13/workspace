package org.joonzis.test;

import java.util.Arrays;

class  TypeCheckClass<T>{
	private T[] arr;
	
	
	public String checkType(T[] arr) {
		this.arr = arr;
		if (arr instanceof Integer[]) {	// T가 클래스 객체라서 비교할때 원하는 데이터 타입에 클래스 버전으로 변환이 가능한지 물어보기
			return "정수형 입니다.";
		} else if (arr instanceof  String[]){
			return "실수열 입니다.";
		} else if (arr instanceof  Double[]){
			return "문자열 입니다.";
		} else {
			return null;
		}
			
	}
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("배열 데이터 : ").append(Arrays.toString(arr)).append("\n");
		sb.append("배열 형태 : ").append(checkType(arr));
		return sb.toString();
	}
}



public class Test01 {
//	Q1. Test01.java
//	문자/정수/실수 타입의 배열을 전달하고 데이터 타입을 체크하여
//	해당 데이터 타입과 해당 배열의 데이터들을 출력
//	class TypeCheckClass - 필드 : T[] arr
//	   					  메소드 : String checkType(T[] arr), toString()
	
	
	public static void main(String[] args) {
		
		Integer arr1[] = {1,2,3,4,5};
		Double[] arr2 = {1.5,2.5,3.5};
		String[] arr3 = {"1","2","3"};
		
		TypeCheckClass<Integer> t1 = new TypeCheckClass<>();
		t1.checkType(arr1);
		System.out.println(t1.toString());
		
		TypeCheckClass<Double> t2 = new TypeCheckClass<>();
		t2.checkType(arr2);
		System.out.println(t2.toString());
		
		TypeCheckClass<String> t3 = new TypeCheckClass<>();
		t3.checkType(arr3);
		System.out.println(t3.toString());
	}
}
