package org.joonzis.test;

import java.util.Scanner;

public class test03_WeekScheduler {
	test03_Day[] days;
	String[] week;
	Scanner sc = new Scanner(System.in);

	public test03_WeekScheduler() {
		days = new test03_Day[7];
		for (int i = 0; i < days.length; i++) {
			days[i] = new test03_Day();
		}
		week = new String[7];
		week[0] = "일";
		week[1] = "월";
		week[2] = "화";
		week[3] = "수";
		week[4] = "목";
		week[5] = "금";
		week[6] = "토";
		}
	void menu() {
		System.out.print("1. 스케줄 생성\n2. 삭제\n3. 수정\n4. 보기\n0. 종료\n숫자 선택 : ");
		int menu = sc.nextInt();
		sc.nextLine();
		switch (menu) {
		case 1: makeSchedule();
			run();
			break;
		case 2:	removeSchedule();
			run();
			break;
			
		case 3: modifySchedule();
			run();
			break;
			
		case 4: output();
			run();
			break;
		case 0: exit();
			break;
		default : System.out.println("다시 입력하세요.");
				run();
		}
	}
	
	void run() {
		menu();
	}
	
	void makeSchedule() {
		for (int i = 0; i < days.length; i++) {
			if (days[i].getSchedule() == null || days[i].getSchedule().equals("") ) {
			System.out.print(week[i] + " (없으면 엔터)  : ");
			String schedule = sc.nextLine();
			days[i].setSchedule(schedule);
			System.out.println("");
		} else {
			System.out.println(week[i] + "요일은 입력할 스케줄이 없습니다");
		}
			
		}
	}
	void removeSchedule() {
		System.out.print("삭제할 날짜 입력 : ");
		String week2 = sc.nextLine().substring(0,1);
		for (int i = 0; i < days.length; i++) {
			if (week[i].equals(week2) && 
					(days[i].getSchedule() == null || days[i].getSchedule().equals("")) ) {
				System.out.println(week2 + "요일은 스케줄이 없습니다");
					break;
			} else if (week[i].equals(week2)){
					days[i].setSchedule(null);
					System.out.println("스케줄이 삭제되었습니다.");
			}
		}
		
	}
	 void modifySchedule() {
		 System.out.print("수정할 날짜 입력 : ");
		String week2 = sc.nextLine().substring(0,1);
		for (int i = 0; i < days.length; i++) {
			if (week[i].equals(week2) && (days[i].getSchedule() == null || days[i].getSchedule().equals("")) ) {
				System.out.print(week2 + "요일은 스케줄이 없습니다\n새로운 스케줄을 입력하시겠습니까?\n yes/no :");
				String yes = sc.nextLine();
				if (yes.equalsIgnoreCase("yes")) {
					System.out.print("입력 : ");
					days[i].setSchedule(sc.nextLine());
				} else if(yes.equalsIgnoreCase("no")) {
					break;
				} else {
					System.out.println("다시 입력해주세요");
					modifySchedule();
				}
			}
			else if (week[i].equals(week2)) {
			System.out.print("수정 : ");
			days[i].setSchedule(sc.nextLine());
			}
		}
	 }
	 void  output() {
		 for (int i = 0; i < days.length; i++) {
			days[i].output(week[i]);
		}
	 }
	
	 void exit() {
		 System.out.println("종료 되었습니다.");
		 sc.close();
	 }
 }