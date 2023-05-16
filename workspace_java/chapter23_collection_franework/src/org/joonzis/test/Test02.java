package org.joonzis.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class Test02 {
//	Q2. Test02.java
//	로또 & 빙고 (빙고가 어려우면 로또부터 해보기)
//	Set을 이용하여 5 X 5 Bingo 배열을 생성하시오. (1 ~ 25)
//	Set에 랜덤 생성 -> Bingo 2차원 배열에 저장 

	
	public static void main(String[] args) {
		
		Set<Integer>set = new HashSet<Integer>();
		Set<Integer>set1 = new HashSet<Integer>();
		
		
		Random ran = new Random();
		
		for (int i = 0; i < 6; i++) {
			set.add(i+1);
		}
		
		for (int i = 0; i < 6; i++) {
			
			Integer in = set1.hashCode();
			set1.add(ran.nextInt(25)+1);
			
			if (in == set1.hashCode()) {
				i--;
			}	
		}
		
		
		System.out.println(set);
		System.out.println(set1);
		System.out.print("맞은 숫자 : ");
		
		
		Iterator<Integer> itr = set.iterator();
		int count = 0;
		
		while(itr.hasNext()) {
			Iterator<Integer> itr2 = set1.iterator();
			Integer str = itr.next();
			while(itr2.hasNext()) {
				Integer str2 = itr2.next();
				if (str.equals(str2)) {
					System.out.print(str + ", ");
					count++;
				}
			}
			
		}
		System.out.println("\n맞은 개수 : " + count + "개");
		
		
	}
}
