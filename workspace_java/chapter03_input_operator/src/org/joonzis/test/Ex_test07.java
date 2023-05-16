package org.joonzis.test;

import java.util.Scanner;

public class Ex_test07 {
//	Test07.java
//	Q. 체질량 지수(BMI) = 몸무게(kg) / 키 (m) 제곱 
//	   BMI 25 이상이면 "과체중", 20 이상이면 "정상", 20 미만이면 "저체중"
	public static void main(String[] args) {
		
	
		Scanner ipt = new Scanner(System.in);
	
	
			System.out.print("몸무게 : ");
				double k = ipt.nextDouble();
			
			System.out.print("키 : ");
				double m = ipt.nextDouble();
			
			double bmi = k/((m/100)*(m/100));
				
			// if 문 사용
//					if(bmi >= 25) {
//						System.out.println("과체중");
//					} else if(bmi >= 20) {
//						System.out.println("정상");
//					}
//					else  {
//					System.out.println("저체중");
//					} 
					
			// 연산자 사용
				
				String result = (bmi >= 25) ? "과체중" : 
					(bmi >= 20) ? "정상" : "저체중";
				
				System.out.println("체질량 지수 : " + Math.round(bmi*100)/100.0  
						+  ", 체중 범위 : " + result );
			
				
			
			
			
			
					ipt.close();
					
		}
	}
	
