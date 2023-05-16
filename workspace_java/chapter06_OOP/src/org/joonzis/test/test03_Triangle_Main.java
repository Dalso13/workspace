package org.joonzis.test;

import java.util.Scanner;

class Triangle {
	
	int width;
	int height;
	
	void init(Scanner sc) {
		
		System.out.print("너비 입력 : " );
		width = sc.nextInt();
		System.out.print("높이 입력 : ");
		height = sc.nextInt();
	}
	void info() {
		System.out.println("너비 : " + width);
		System.out.println("높이 : " + height);
		System.out.println("크기" + calcArea());

	}
	double calcArea(){
		return width * height / 2.0;
	}
	
}



public class test03_Triangle_Main {
	public static void main(String[] args) {
		
//		클래스 Triangle 
//		- 필드 : width, height
//		- 메소드 : init(너비, 높이 입력), info(너비, 높이, 크기 출력), calcArea(w*h/2 넓이계산 후 리턴)
//		클래스 TriangleMain
//		- 메소드  : main
//		값을 입력 받아서 (Scanner) 확인 
//		파일을 하나만 사용
		
		Triangle myT = new Triangle();
		Scanner sc = new Scanner(System.in);
		
		myT.init(sc);
		myT.info();
		sc.close();
	}
}
