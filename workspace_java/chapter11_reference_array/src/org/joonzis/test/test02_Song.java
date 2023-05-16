package org.joonzis.test;
//Q2. 
//Song.java				- 필드 : String title, String country
//						- 메소드 : Constructor, output
//Singer.java				- 필드 : String name, 
//								Song[] songList(Song의 객체 n개를 메인으로부터 받아서 처리),
//			 					int idx(배열 인덱스에 접근용도)						
//						- 메소드 : Constructor, setSong(song), output
//SingerSongMain.java
public class test02_Song {
	String title;
	String country;
	
	public test02_Song(String title, String country) {
		this.title = title;
		this.country = country;
	}
	
	void output() {
		System.out.println("제목 : " + title);
		System.out.println("국가 : " + country);
	}
	
}
