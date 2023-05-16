package org.joonzis.ex;

import java.util.Calendar;

public class Ex12_Dday {
	public static void main(String[] args) {
		Calendar date1 = Calendar.getInstance();		// 기념일
		Calendar date2 = Calendar.getInstance();		// 현재 날짜
		
		// 기념일로 수정
		date1.set(2023, Calendar.AUGUST , 12);
		
		// 밀리 초 단위로 계산하려면 long을 쓰자
		long milSec = date2.getTimeInMillis() - date1.getTimeInMillis();
		
		// 1000 밀리초 = 1초, 60초 = 1분 , 60분 = 1시간, 24시간 = 1일
		long sec = milSec / 1000;
		long day = sec / (60 * 60 * 24);
		
		//Math.abs : 절대값
		System.out.println("D-day : " + Math.abs(day) + "일 입니다.");
	}
}
