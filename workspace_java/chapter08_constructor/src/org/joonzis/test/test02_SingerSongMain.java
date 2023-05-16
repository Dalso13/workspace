package org.joonzis.test;

public class test02_SingerSongMain {
	public static void main(String[] args) {
		
		test02_Song s = new test02_Song("좋은날","한국");
		
		test02_Singer sing1 = new test02_Singer("아이유");
		
		sing1.setSong(s);
		
		sing1.output();
	}
}
