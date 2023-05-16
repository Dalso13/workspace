package org.joonzis.test;


import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class Test02_1 {
//	Q2. Test02.java
//	로또 & 빙고 (빙고가 어려우면 로또부터 해보기)
//	Set을 이용하여 5 X 5 Bingo 배열을 생성하시오. (1 ~ 25)
//	Set에 랜덤 생성 -> Bingo 2차원 배열에 저장 

	
	public static void main(String[] args) {
		
		/*
		 * hashSet 으로 빙고 이용시 숫자 오름차순 정렬 증상
		 * 	- set의 특성상 입력 순서가 출력 순서와 같은 것은 아님
		 * 	- 적은 데이터가 일률적으로 들어갈 시 오름차순 정렬 증상 발생
		 * 	- 로또의 경우 4개의 데이터 중 6개 만을 입력하여 문제x
		 * 	- 빙고의 경우 25개의 데이터 중 25개를 그대로 사용하여 증상 발생
		 */
		
		// 빙고 2인용
		
		
		Random ran = new Random();
		int arr[][] = new int[5][5];
		int arr1[][] = new int[5][5];
		
		Set<Integer>set = new LinkedHashSet<Integer>();
		Set<Integer>set1 = new LinkedHashSet<Integer>();
		
		// 랜덤값 넣기
		for (int i = 0; i < 25; i++) {
			Integer a = set.hashCode();
			set.add(ran.nextInt(25)+1);
			
			if (a == set.hashCode()) {
				i--;
			}
		}
		for (int i = 0; i < 25; i++) {
			Integer a = set1.hashCode();
			set1.add(ran.nextInt(25)+1);
			
			if (a == set1.hashCode()) {
				i--;
			}
		}
		// 위 for문이랑 같은 공식 밑이 더 효율적
//		while (set.size() < 25) {
//			set.add(ran.nextInt(25)+1);
//			
//		}
		
		// 배열에 값 넣기 및 출력
		Iterator<Integer> it = set.iterator();
		
		
		for (int i = 0; i < arr1.length; i++) { 
			for (int j = 0; j < arr1[i].length; j++) {
				arr1[i][j] = it.next();
				System.out.print(arr1[i][j] + "\t");
			}
			System.out.println();
		}
		
		System.out.println("---------------------");
		
		Iterator<Integer> it1 = set1.iterator(); 
		
		for (int i = 0; i < arr.length; i++) { 
			for (int j = 0; j < arr.length; j++) {
				arr[i][j] = it1.next();
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
		

	}
}
