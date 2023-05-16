package org.joonzis.ex;

public class Ex01_PersonMain {
	public static void main(String[] args) {
		
		Ex01_Person person1 = new Ex01_Person("장씨" , 28 , 170 , '남');
		Ex01_Person person2 = new Ex01_Person("김씨" , 27 , 180 , '남');
		Ex01_Person person3 = new Ex01_Person("박씨" , 26 , 150 , '여');
		
		
		person1.output();
		person2.output();
		person3.output();
		
		System.out.println("---------------------------");
		
		// 크기 3의 참조 배열 people을 선언 후 값 입력
		// 각 배열내 데이터 출력
		
		Ex01_Person people[] = new Ex01_Person[3];
		
		for (int i = 0; i < people.length; i++) {
			people[i] = new Ex01_Person();
		}
	
		
	}
}
