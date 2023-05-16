package org.joonzis.test;
interface Providable{
	
	public	void sightseeing();
	public	void leisure();
	public	void food();
}
class KoreaTour	implements Providable{
	
	@Override
	public void food() {
		System.out.println("먹는것 : 비빔밥");
		
	}
	@Override
	public void leisure() {
		System.out.println("자유시간 : 서울에서 놀기");
	}
	@Override
	public void sightseeing() {
		System.out.println("관광 코스 : 경복궁 관광");
	}
	
}
class GuamTour implements Providable{
	@Override
	public void food() {
		System.out.println("먹는것 : bbq");
		
	}
	@Override
	public void leisure() {
		System.out.println("자유시간 : 바다에서 놀기");
	}
	@Override
	public void sightseeing() {
		System.out.println("관광 코스 : 투몬 해변");
	}
	
}
class TourGuide	{
	private Providable tour;
	
	public TourGuide() {}
	
	public TourGuide(Providable tour) {
		this.tour = tour;
	}



	public void food() {

			tour.food();	
		
	}
	public void leisure() {
		
			tour.leisure();
	
	}
	public void sightseeing() {
		
			tour.sightseeing();
		
	}
	
	
}

public class Test02 {
	
//	Q2. Test02.java
//	interface Providable		메소드: sightseeing(), leisure(), food()
//	class KoreaTour				메소드 : Providable 구현을 통해생성
//	class GuamTour				메소드 : Providable 구현을 통해생성
//	class TourGuide				필드 : Providable tour
//								메소드 : Constructor, sightseeing(), leisure(), food()
//	★ KoreaTour / GuamTour -  Providable 구현
	  
	
	public static void main(String[] args) {
		
		TourGuide to1 = new TourGuide(new KoreaTour());
		TourGuide to2 = new TourGuide(new GuamTour());
		
		
		to1.food();
		to1.leisure(); 
		to1.sightseeing();

		System.out.println("------------");
		
		to2.food();
		to2.leisure();
		to2.sightseeing();		
		
		
	}
}
