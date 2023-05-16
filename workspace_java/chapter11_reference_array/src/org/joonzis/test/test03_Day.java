package org.joonzis.test;

//Q3.
//Day.java				- 필드 : String schedule
//						- 메소드 : Constructor, getSchedule() : 스케쥴반환,
//								setSchedule(String schedule) : 스케쥴 저장, output()
//WeekScheduler.java   	- 필드 : Day[] days, Scanner scanner,
//								String[] week : {일, 월, 화 ... , 토}  까지 데이터 초기화
//						- 메소드 : Constructor,
//								menu() : 목록 (1. 스케줄 생성, 2. 삭제, 3. 수정, 4. 보기, 0. 종료)
//								 makeSchedule() : 요일과 스케쥴을 입력 받아 해당 요일에 스케쥴 저장
//								 removeSchedule() : 요일을 입력 받아해당 요일의 스케쥴 삭제
//								 modifySchedule() : 요일과 스케쥴입력받아 해당  요일의 스케쥴수정
//								   					기존 스케쥴이 없는 경우에는 새로운 스케쥴 저장
//								 output() : 일주일간의 스케쥴전체출력
//								 exit() : 스케쥴러 종료(종료 명령 전까지계속 스케쥴러는 작동해야함)
//								 run() : 스케쥴러 실행
//WeekSchedulerMain.java
//	
//WeekScheduler scheduler = new WeekScheduler();
//scheduler.run();		




public class test03_Day {
	String schedule;
	public test03_Day() {}
	
	//

	public String getSchedule() {
		return schedule;
	}
	void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	void output(String week) {
		if(getSchedule() == null || getSchedule().equals("")) {
			System.out.println(	week + " : " + "없음");
		} else
		System.out.println(	week + " : " + getSchedule());
	}
}
