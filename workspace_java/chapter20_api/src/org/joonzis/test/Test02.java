package org.joonzis.test;

//Q2. Test02.java
//User 클래스 					필드 : String id, password
//							메소드 : Constructor, toString(), equals()
//User 인스턴스를 2개 생성하고, 동등 비교(id, password 모두 같으면 동등) 결과 출력
//각 인스턴스 정보는 toString 메소드를 통해 출력													
//							

class User{
	String id, password;

	public User(String id, String password) {
		this.id = id;
		this.password = password;
	}
	
	@Override
	public String toString() {
		
		return "id : " + id + ", password : " + password;
	}
	
	@Override
	public boolean equals(Object obj) {	
		
		if (obj != null && obj instanceof User) {
			User obj2 = (User)obj;
			return id.equals(obj2.id) && password.equals(obj2.password);
		} else {
			return false;
		}
	}
	
}


public class Test02 {
	public static void main(String[] args) {
		User us1 = new User("장동완", "3389");
		User us2 = new User("장동완", "3389");
		
		if (us1.equals(us2)) {
			System.out.println("동등");
			System.out.println("us1 = " + us1.toString());
			System.out.println("us2 = " + us2.toString());
		} else {
			System.out.println("아님");
		}
	}
}
