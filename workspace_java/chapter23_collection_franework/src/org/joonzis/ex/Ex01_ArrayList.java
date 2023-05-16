package org.joonzis.ex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ex01_ArrayList {
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<Integer>();
		//ArrayList<Integer> list = new ArrayList<Integer>();  위에는 업 캐스팅 안할거면 옆에 식 으로
		
		// 1. 저장 : add()
		list.add(new Integer(1));
		list.add(new Integer(2));
		list.add(5);
		list.add(4);
		list.add(3);
		list.add(5,3);  // 인덱스를 지정하여 값을 넣을 수 있다. add(인덱스 번호, 값)
		
		// 2. 저장된 요소 가져오기 : get()
		System.out.println("첫 번째 요소 : " + list.get(0));
		System.out.println("두 번째 요소 : " + list.get(1));
		System.out.println("세 번째 요소 : " + list.get(2));
		System.out.println("네 번째 요소 : " + list.get(3));
		
		// 3. 크기 : size() -> length 와 같은 역할
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		// 4. 삭제 : remove(index) , clear()
		list.remove(0); // 0번 인덱스 삭제
		//list.clear();  // 저장된것들 모두 삭제
		
		System.out.println(list);
		
		// 5. 확인(저장 유무 확인)	:	contains(객체)
		
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(5);
		list2.add(6);
		list2.add(7);
		for (int i = 0; i < list2.size(); i++) {
			if (list.contains(list2.get(i))) {
				System.out.println("중복 되는 값 : " + list2.get(i));
			}
		}
		
		// 6. 컬렉션은 그냥 출력해도 된다.
		System.out.println(list);
		
		// 7. 정렬 : sort(list)
		Collections.sort(list);
		System.out.println("정렬 후 list : " + list);
		
		// 8. 최악의 성능으로 list의 모든 데이터 삭제     //너무 비효율 적 인것 같음
		while (list.size() > 0) {
			list.remove(0);
			
		}
	}
}
