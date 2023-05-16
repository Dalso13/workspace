package org.joonzis.ex;

public class Ex07_continue {
	public static void main(String[] args) {
		/*
		 * 1. 형식
		 * 
		 * 		while (조건식) {
		 * 			반복실행문;
		 * 			if(조건식) {
		 * 				continue;	// while(조건식) <- 이동!★
		 * 			}
		 * 			반복실행문;		// continue가 동작하면 실행되지 않는다!
		 * 		}
		 * 
		 * 		for ( 초기문; 조건식; 반복실행문 후 실행){
		 * 			반복실행문;
		 * 			if (조건식){
		 * 				continue;	// for문의 반복실행문 후 실행 <- 이동!★
		 * 			}
		 * 			반복실행문;
		 * 		}
		 * 
		 * 
		 * ex) 식사로 비교해보자!
		 * 		while(다 먹을때까지){
		 * 			반찬을 집어라!
		 * 			if(반찬 == 가지){
		 * 				continue;
		 * 			}
		 * 			반찬을 먹는다!
		 * 		}
		 * 
		 * 2. 특징
		 * 	1) 반복에서 제외하고 싶은 데이터를 조건식으로 만들고 continue로 처리한다.
		 *  2) while 문과 for 문 계열에 약간의 차이가 있다.
		 */
		
		
		// 1. 1~10 출력 (while) (3의 배수는 제외)
		int num = 0;
		while(num < 10) {
			num++;
			if(num % 3 == 0) {
				// 3의 배수
				continue;
			}
			System.out.println(num);
		}
		
		// 1. 1~10 출력 (for) (3의 배수는 제외)
		for(int i=1; i<=10; i++) {
			if(i % 3 == 0) {
				continue;
			}
			System.out.println(i);
		}
		
		
		
		
		
		
		
		
		
	}
}
