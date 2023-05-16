package org.joonzis.ex;

class Bag <T>{		// <T> : 자료형 ex) int 형을 넣고 싶으면 Integer 를 사용해야 함
	private T obj;
	public T getObj() {
		
		return obj;
	}
	
	public void setObj (T obj) {
		this.obj = obj;
	}
}

class Ball{
	
}
class Pen{
	
}




public class Ex02_generic {
	public static void main(String[] args) {
		Bag<Ball> bag = new Bag<>();
		
		bag.setObj(new Ball());

		
		Ball ball = bag.getObj();	// 제네릭을 사용하면 캐스팅이 필요없다.
		
		System.out.println(ball);
		
		
	}
}
