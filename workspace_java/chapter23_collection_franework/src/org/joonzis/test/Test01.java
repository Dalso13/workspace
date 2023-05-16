package org.joonzis.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

class Board{
	String title,content;
	Date register;
	
	
	
	public Board(String title, String content,Date register) {
		this.title = title;
		this.content = content;
		this.register = register;
	}
	


	@Override
	public String toString() {
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy년 MM월 dd일 E요일");
		StringBuffer sb = new StringBuffer();
		String str = format1.format(register);
		
		
		sb.append("제목 : ").append(title);
		sb.append("\n내용 : ").append(content);
		sb.append("\n등록일 : ").append(str);
		
		
		return sb.toString();
	}
}

public class Test01 {
	
//	Q1. Test01.java
//
//	게시물을 저장하는 Board 클래스를 정의하고, ArrayList를 이용하여 3개의 게시물을 저장하시오.
//	1~3번 게시물번호 중 하나를 입력 받아 해당 게시물을 삭제하시오.
//
//	class Board			필드 : String title, String content, Date register
//								register -> 현재 날짜 자동 삽입
//						메소드 : 생성자, toString()

	public static void main(String[] args) {
		
		Calendar cal = Calendar.getInstance();
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		
		cal.set(2023, 2, 15);
		cal1.set(2023, 1, 5);
		cal2.set(2023, 2, 25);
		
	
		List<Board>list = new ArrayList<Board>();
		
		
		list.add(new Board("1. 공지사항" , "모든 회원 필독" , cal.getTime()));
		
		list.add(new Board("2. 이벤트" , "관리자만 필독" , cal1.getTime()));
		
		list.add(new Board("3. 요청","모든 회원 필독",cal2.getTime()));
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("삭제할 숫자 : ");
		int num = sc.nextInt();
		
		list.remove(num-1);
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		
		
		
	}
}
