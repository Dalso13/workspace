package org.joonzis.ex;


/*
 * 	필드
 * 	- width, height, isSquare
 * 
 * 	메소드
 * 	- 생성자() : 가로, 세로 1로 고정
 * 	- 생성자(int side) : 가로, 세로 같은 값으로 저장
 * 	- 생성자(w, h) : 가로, 세로 값 전달 받아 저장
 * 	- int calcArea() : 사각형 크기 리턴
 * 	- output() : 너비, 높이, 크기, 형태 (정사각형 or 직사각형) 출력
 */

public class Ex01_Rect {
	private int width;
	private int height;
	private boolean isSquare;
	
	public Ex01_Rect() {
//		this.width = 1;
//		this.height = 1;
//		this.isSquare = true;
		this(1,1);
	}
	public Ex01_Rect(int side) {
//		this.width = side;
//		this.height = side;
//		this.isSquare = true;
		this(side,side); // 밑에 식들을 가져올때 이렇게 쓰면 됨.
	}
	public Ex01_Rect(int w , int h) {
		this.width = w;
		this.height = h;
		this.isSquare = w == h;
	}
	
	private int calcArea() {
		return width * height;
	}
	
	public void output() {
		System.out.println("너비 : " + width);
		System.out.println("높이 : " + height);
		System.out.println("크기 : " + calcArea());
		System.out.println(isSquare ? "정사각형" : "직사각형");
		
	}

}
