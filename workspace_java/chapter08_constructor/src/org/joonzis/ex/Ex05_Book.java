package org.joonzis.ex;


	/*
	 * 	필드
	 * 	-	String title		: 책 제목
	 * 	-	String writer		: 저자
	 * 	-	int price			: 책 가격
	 * 	-	int salesVolume		: 판매량
	 * 	-	boolean isBestSeller : 베스트 셀러 유무
	 * 
	 * 	메소드
	 * 	- 생성자()
	 * 	- 생성자()	: 제목, 가격 초기화 (저자는 "작자미상" 으로 기입)
	 * 	- 생성자()	: 제목, 가격, 저자 초기화
	 * 	- setSalesVolume(int sales) : 판매량이 1000 이상이면 베스트 셀러
	 * 	- output() : 제목, 저자, 가격, 판매량, 베스트셀러 유무 출력
	 */	
public class Ex05_Book {

	// //이거 친거는 다른방법으로 풀어본거
	
	String title;
	String writer;
	int price;
	int salesVolume;
	boolean isBestSeller;
	
	// 메서드
	
	public Ex05_Book() {
		
	}
	
	public Ex05_Book(String ti , int pr) {
		
		title = ti;
		price = pr;
		writer = "작자미상";
//		salesVolume = 600;
	}
	
	public Ex05_Book(String ti, int pr, String wr) {
		title = ti;
		price = pr;
		writer = wr ;
//		salesVolume = 3000;
	}
	 //더 간단하지만 조건을 다 못사용함
//	boolean setSalesVolume(int sales){
//	 		return	sales >= 1000;
//	}
	
	
	void setSalesVolume(int sales) {
		salesVolume = sales;
		if (salesVolume >= 1000) {
			isBestSeller = true;
		} else {
			isBestSeller = false;
		}
	}
	
	void output(){
		System.out.println("책 제목 : " + title);
		System.out.println("작가 : " + writer);
		System.out.println("가격 : " + price);
		System.out.println("책 판매량 : " + salesVolume);
//		System.out.println(setSalesVolume(salesVolume) ? "베스트셀러" : "아님");
		System.out.println(isBestSeller ? "베스트 셀러" : "아님");
	
	}
	
	
}