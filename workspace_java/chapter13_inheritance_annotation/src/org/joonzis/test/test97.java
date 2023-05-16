package org.joonzis.test;


class Point2D{
	int x;
	int y;
	public Point2D() {}
	public Point2D(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	void output() {
		System.out.println("x 좌표 : " + x);
		System.out.println("y 좌표 : " + y);
	}
	
	
}

class Point3D extends Point2D{
	int z;
	
	public Point3D() {}
	public Point3D(int x, int y, int z) {
		super(x,y);
		this.z = z;
	}
	@Override
	void output() {
		super.output();
		System.out.println("z 좌표 : " + z);
	}
	
}


public class test97 {
	
//	2차원 자표를 관리하는 Point2D 클래스와 3차원 자표를 관리하는 Point3D 클래스 정의
	public static void main(String[] args) {
		Point3D pt = new Point3D(10,20,5);
		
		pt.output();
	}
}
