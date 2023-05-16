package org.joonzis.test;

import java.util.Scanner;

public class test02_SingerSongMain {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	test02_Singer singer = new test02_Singer("아이유", 2);
	singer.setSong(new test02_Song("좋은날", "한국"));
	singer.setSong(new test02_Song("좋은날", "한국"));
	
	singer.output();

	}

			
}
