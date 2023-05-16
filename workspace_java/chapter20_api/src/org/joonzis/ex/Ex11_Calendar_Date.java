package org.joonzis.ex;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Ex11_Calendar_Date {
	public static void main(String[] args) {
		
		Calendar cal = Calendar.getInstance();
		
		// Calendar 객체를 이용하여 현재 날짜 가져오기(Date 객체 생성)
		Date now = cal.getTime();
		
		SimpleDateFormat sdf = new SimpleDateFormat("a hh시 mm분 ss초");
				
		String today = sdf.format(now);
		
		System.out.println(today);
	}
}
