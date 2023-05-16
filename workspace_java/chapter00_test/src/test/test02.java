package test;

import java.util.Scanner;

public class test02 {
	public static void main(String[] args) {
//		Q3 .사용자에게 값을 입력받은 후 그 값이 숫자인지 아닌지를 출력
//		* 아스키 코드표 참고
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("입력 : ");
		String a = sc.nextLine();
		int b = Integer.parseInt(a);
		
		if (a.equals(b)) {
			System.out.println("숫자" + a);
		} else {
			System.out.println("숫자 아님" + a);
		}
		
		
		
	}
}
