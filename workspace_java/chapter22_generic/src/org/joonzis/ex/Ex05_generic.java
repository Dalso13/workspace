package org.joonzis.ex;

import java.util.Arrays;

class Container	<T>{
	private T[] items;
	
	@SuppressWarnings("unchecked") // 명확하지 않은 타입 체크이지만, 더 이상 경고 하지마라 라는 뜻
	public Container(int capacity) {
		items = (T[])(new Object[capacity]);
	}
	
	public void add(T item) {	// setter
		// 순차적으로 순회핟가 빈자리가 발견되면 그 자리에 저장.
		// items 배열에 item 변수 저장
		for (int i = 0; i < items.length; i++) {
			if (items[i] == null) {
				items[i] = item;
				break;
			}
		}
	}
	
	public T[] getItems() {
		return items;
	}
	
}
class Gun{
	private String model;
	
	public Gun(String model) {
		this.model = model;
	}
	
	@Override
	public String toString() {
		return model;
	
	}
}




public class Ex05_generic {
	public static void main(String[] args) {
		Container<Gun> con = new Container<>(10);
		con.add(new Gun("K2"));
		con.add(new Gun("K1"));
		con.add(new Gun("K5"));
		con.add(new Gun("M16"));
		
		System.out.println(Arrays.toString(con.getItems()));
	}
}
