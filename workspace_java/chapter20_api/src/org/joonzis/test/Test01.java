package org.joonzis.test;


//	Q1. Test01.java
//	Score 클래스 					필드 : int kor, eng, mat
//								메소드 : Constructor, toString(), equals()
//	Score 인스턴스를 2개 생성하고, 동등 비교(세과목이 모두 같으면 동등) 결과 출력
//	각 인스턴스 정보는 toString 메소드를 통해 출력
	
	
	class Score{
		private int kor, eng, mat;

		public Score(int kor, int eng, int mat) {
			this.kor = kor;
			this.eng = eng;
			this.mat = mat;
		}
		
		@Override
		public String toString() {
		return "영어" + eng + "국어" + kor + "수학" + mat;
		
		}
		
		@Override
		public boolean equals(Object obj) {
			if (obj != null && obj instanceof Score) {
				Score sc = (Score)obj;
				
				return eng == (sc.eng) && kor == (sc.kor) && mat == (sc.mat);
			} else {
				return false;
			}
		
		}
		
	}
public class Test01 {	
	public static void main(String[] args) {
		
		Score s1 = new Score(80, 80, 80);
		Score s2 = new Score(80, 80, 80);
		
		
		if (s1.equals(s2)) {
			System.out.println("동등");
			System.out.println("s1 점수 : " + s1.toString());
			System.out.println("s2 점수 : " + s2.toString());
		} else {
			System.out.println("아님");
		}
		
	}
}
