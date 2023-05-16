package org.joonzis.test;

class TV {
	private int size;
	public TV(int size) {
		this.size = size; 
		}
	protected int getSize() { 
		return size; 
		}
}

class ColorTV extends TV {
	int color;
	public ColorTV(int size,int color) {
		super(size);
		this.color  = color;
	}
	void printProperty() {
		System.out.println("인치 : " + getSize() + " , 컬러 : " + color);
	}
}
class IPTV extends ColorTV {
	String ip;
	public IPTV(String ip, int size, int color) {
		super(size, color);
		this.ip = ip;
	}
	@Override
	void printProperty() {
		System.out.print("ip : " + ip + " ");
		super.printProperty();
	}
}

public class test98 {
	public static void main(String args[]) {
		ColorTV myTV = new ColorTV(32, 1024);
		myTV.printProperty();
		
		IPTV iptv = new IPTV("192.1.1.2", 32, 2048); // "192.1.1.2" 주소에 32인치, 2048 컬러
		iptv.printProperty();
	}
}
