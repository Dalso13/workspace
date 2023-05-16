package org.joonzis.ex;


	/*
	 * 필드
	 * 	- int x, y : 좌표
	 * 	- double radius : 반지름
	 * 
	 * 메소드
	 * 	- 생성자 () : 좌표 0,0 r값 1 로 고정
	 * 	- 생성자 (r) : 좌표 0 ,0
	 * 	- 풀생성자
	 * 	- calcArea() : 원의 크기 계산 후 리턴 (PI * r * r)
	 * 	- calcCircum() : 원의 둘레 계산 후 리턴 (2 * PI * r)
	 * 	- output() : 원의 중심 좌표, 반지름, 크기, 둘레 출력
	 * 
	 *  ****** PI 구하기  -> Math.PI ******
	 */

	public class Ex04_Circle {
		
		//필드
		
		int x;
		int y;
		double radius;
		
		//메소드
		
		public Ex04_Circle() {
			x = 0;
			y = 0;
			radius = 1;
		}
		
		public Ex04_Circle(double r) {
			x = 0;
			y = 0;
			radius = r;
		}
		
		public Ex04_Circle(int x1 , int y1 , double r) {
			x = x1;
			y = y1;
			radius = r;
		}
		
		double calcArea() {
			return Math.round(Math.PI * (radius * radius)*100)/100.0 ;
		}
		
		double calcCircum() {
			return  Math.round(2 * Math.PI * radius * 100)/100.0 ;
		}
		
		void output() {
			System.out.println("원의 중심 좌표"+ "(" +x + "," + y + ")");
			System.out.println("반지름 : " + radius);
			System.out.println("원의 크기 : " + calcArea());
			System.out.println("원의 둘레 : " + calcCircum());
		}
		
		
		
		
		
		
	
	
	
}
