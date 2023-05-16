package org.joonzis.ex;

// 예외 클래스 : Exception을 상속 받아서 만든다(Custom Exception)

// 예외 클래스를 만드는 이유 : 사용자 친화적인 예외 메세지로 변경 가능.
// 예외가 아닌 것도 예외로 만들 수 있다.
class MyException extends Exception{

	// 경고 없애려고 넣은것 당장은 신경쓸 필요가 없다.
	private static final long serialVersionUID = 1L;
	
	
	public MyException(String message) {
		super(message);
	}
	
}

public class Ex08_exception {
	public static void main(String[] args) {
		
		try {
			throw new MyException("내가 만든 예외!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
