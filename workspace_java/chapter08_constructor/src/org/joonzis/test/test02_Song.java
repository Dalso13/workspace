package org.joonzis.test;

//Q2.
//Song.java				필드 - String title, String country
//						메소드 - Constructor, output
//Singer.java				필드 - String name, Song song 
//						메소드 - Constructor, setSong(s), output
//SingerSongMain.java		



public class test02_Song {
	
	String title;
	String country;
	
	public test02_Song(String ti, String co) {
		title = ti;
		country	= co;
	}
	
	
	void output() {
		System.out.println("노래 제목 : "  + title);
		System.out.println("국가 : " + country);
	}
}
