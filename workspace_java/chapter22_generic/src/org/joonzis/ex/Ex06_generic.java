package org.joonzis.ex;

class Basket<T>{	// 음식만 담을  수 있는 바구니
	private T[] foods;
	
	@SuppressWarnings("unchecked")
	public Basket(int length) {
		foods = (T[])(new Object[length]);
	}
	public void add(T food) {
		for (int i = 0; i < foods.length; i++) {
			if (foods[i] == null) {
				foods[i] = food;
				break;
			}
		}
	}
	public T[] getFoods() {
		return foods;
	}
	
	
	
}
class Food{
	
}
class Apple extends Food{

}
class Banana extends Food{

}
class Bread extends Food{

}
class Computer{
}



public class Ex06_generic {
	public static void main(String[] args) {
		Basket<Food> bak = new Basket<>(1);
		
		bak.add(new Apple());
		bak.add(new Banana());
		bak.add(new Bread());
//		bak.add(new Computer());
		
		System.out.println(bak.getFoods());
		
	}
}
