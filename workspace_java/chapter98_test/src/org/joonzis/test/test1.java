package org.joonzis.test;

public class test1 {
	public static void main(String[] args) {
		int ans = 0;
		for (int i = 1; i < 21; i++) {
			if (i % 2 == 0 || i % 3 == 0) {
			} else {
				ans += i;
			}
		}
		System.out.println("1번 답 : " + ans);
		System.out.println();
		
		String ans2 = "";
		for (int i = 1; i <= 5; i++) {
			for (int j = 0; j < i; j++) {
				ans2 += "*";
			}
			ans2+="\n";
		}
		
		System.out.println("2번 답 : \n" + ans2);
		
		int ans3 = 0;
		
		for (int i = 1; i <= 10; i++) {
			for (int j = 1; j < i; j++) {
				ans3 += j;
			}
			ans3 += i;
		}
	
		System.out.println("3번 답 : " + ans3);
		System.out.println();
		
		int ans4 = 0;
		int num[] = {2, 7, 3, 8, 5};
		
		for (int i = 0; i < num.length; i++) {
			if (ans4 < num[i]) {
				ans4 = num[i];
			}
		}
		
		System.out.println("4번 답 : " + ans4);
		System.out.println();
		
		int ans5 = 0;
		int count = 0;
		int arr[][] = {
				  {95, 86},
				  {83, 92, 96},
				  {78, 83, 93, 87, 88}
				};
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				ans5 += arr[i][j];
				count++;
			}
		}
		
		
		System.out.println("5번 답 : " +ans5/count);
		System.out.println();
		
		int result[] = new int[19];
		result[0] = 1;
		result[1] = 1;
		result[2] = 2;
		
		System.out.print("6번 답 : " +  result[0] + " , " + result[1] + " , " + result[2] + " , ");
		
		
		for (int i = 3; i < result.length; i++) {
			result[i] = result[i-1] + result[i-2];
			System.out.print(result[i] + " , ");
		}
		
		
		
	}
}
