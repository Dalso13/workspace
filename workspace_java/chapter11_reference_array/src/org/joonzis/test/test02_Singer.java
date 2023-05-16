package org.joonzis.test;

public class test02_Singer {
	String name;
	test02_Song[] songList;
	int idx;
	
	
	
	public test02_Singer() {}
	public test02_Singer(String name , int songCount) {
		this.name = name;
		songList = new test02_Song[songCount];
	}
	void setSong(test02_Song song) {
		songList[idx] = song;
		idx++;
	}
	void output() {
		System.out.println("가수 이름 : " + name );
		System.out.println("노래 모음-------------");
		for (int i = 0; i < idx; i++) {
			songList[i].output();
		}
		
	}
	
	
}
