package org.joonzis.test;

import java.util.Calendar;

public class Test07 {
//	Q7.Test07.java
//	현재 날짜를 StringBuffer, Calendar 클래스를 이용하여
//	"2019년 10월 21일 월요일 오후 1시 10분" 과 같은 형식으로 완성하고 출력하시오.
//	StringBuffer.append() 이용
//	String[] weeks = {"","일","월","화","수","목","금","토"};
	
	
	// 날짜를 출력하는 방식이니 복붙해서 쓰기 좋을거같음
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		
		cal.set(2019, 9, 21, 13, 10);
		
		String[] weeks = {"","일","월","화","수","목","금","토"};
		String[] ampm = {"오전 ","오후 "};
		
		
		StringBuffer date = new StringBuffer();
		
		date.append(cal.get(Calendar.YEAR)).append("년 ").append(cal.get(Calendar.MONTH)+1).append("월 ").append(cal.get(Calendar.DATE))
		.append("일 ").append(weeks[cal.get(Calendar.DAY_OF_WEEK)]).append("요일 ").append(ampm[cal.get(Calendar.AM_PM)]).append(cal.get(Calendar.HOUR))
		.append("시 ").append(cal.get(Calendar.MINUTE)).append("분");
		
		
		System.out.println(date);
		
		
	}
}
