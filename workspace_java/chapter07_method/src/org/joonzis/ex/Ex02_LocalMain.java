package org.joonzis.ex;

public class Ex02_LocalMain {
	public static void main(String[] args) {
		Ex02_Local local1 = new Ex02_Local();
		
		local1.setLocalInfo("장동완",23,"010013-3555555");
		local1.output();
		
		
		System.out.println("\n -----------------------");
		Ex02_Local local2 = new Ex02_Local();
		
		local2.setLocalInfo("카를로스",23);
		local2.output();
	}
}
