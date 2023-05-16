package test;

public class test01 {
	public static void main(String[] args) {
//		sQ1. 세개의 과목 국어 89점, 영어 99점, 수학 78점인 점수와 총 점을 출력

		int num1 = 89;
		int num2 = 99;
		int num3 = 78;
				
		System.out.println("국어 : " + num1 + "영어 : " + num2 + "수학 : " + num3 + "총점 : " + (num1+num2+num3));
		
//		Q2. 국어 99점, 영어 80점, 수학 96점의 평균 값을 실수형과 정수형으로 출력
		
		num1 = 99;
		num2 = 80;
		num3 = 96;
		
		System.out.println("평균 (실수) : " +(double)((num1+num2+num3)/3)  + "\n " + " 평균 (정수) :" + ((num1+num2+num3)/3));
		
	}
}
