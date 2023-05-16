package org.joonzis.ex;

/*
 *  ArrayIndexOutBoundsException
 *  배열에서 인덱스 범위를 초과하는 경우 예외 발생
 */





public class Ex02_exception {
	public static void main(String[] args) {
		
		/*	크기 3 짜리 정수형 배열 arr 를 선언
		 *  각 인덱스에 순서대로 1, 2, 3 데이터 삽입
		 *  향상 for문을 이용하여 배열 내 데이터 추력
		 *  
		 *  *** 예외 처리 ***
		 *  에러 발생 시
		 *  "인덱스 가용 범위를 벗어났습니다." 출력
		 * 
		 */
		
		int arr[] = new int[3];
		
		
		try {
			arr[0] = 1;
			arr[1] = 2;
			arr[3] = 3; // 해당 위치에서 예외 발생
			for (int num : arr) {
				System.out.println(num);
			}
		
		} catch(ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("인덱스 가용 범위를 벗어났습니다.");
		}
		
	}
}
