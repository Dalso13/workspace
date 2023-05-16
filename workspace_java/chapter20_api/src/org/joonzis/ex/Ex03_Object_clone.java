package org.joonzis.ex;
// 반드시 Cloneable 인터페이스를 구현하자
// 복제 가능한 Person 클래스로 만들기 위함

class Person implements Cloneable{
	private String name;
	private int age;
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "이름 : " + name + ", 나이 : " + age; 
	
	}
	
	@Override
	public Object clone() { // protected -> public 으로 변경
		Object obj = null;
		try {
			// Object obj = super.clone(); 해도 되지만
			// 그러면 try-catch 이후 return 값을 넣지 못함
			obj = super.clone();	
			
			
			
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		
		return obj;
	}
}


public class Ex03_Object_clone {
	public static void main(String[] args) {
		Person per1 = new Person("김씨", 12);
		System.out.println(per1);
		
		Person clonePer = (Person)per1.clone();
		System.out.println(clonePer);
	}
}
