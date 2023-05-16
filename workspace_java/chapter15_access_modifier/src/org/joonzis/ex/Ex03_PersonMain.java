package org.joonzis.ex;

public class Ex03_PersonMain {
	public static void main(String[] args) {
		Ex03_Person p1 = new Ex03_Person();
		
		//p1.name = "김씨";  private 처리가 되어서 모든 field는 접근 불가
		// setter 를 통한 데이터 입력
		p1.setName("김씨");
		System.out.println(p1.getName());
		p1.setAge(12);
		System.out.println(p1.getAge());
		p1.setGender('남');
		System.out.println(p1.getGender());
		p1.setHeight(299);
		System.out.println(p1.getHeight());

		
	}
}
