package org.joonzis.ex;

public class Ex03_StudentMain {
	public static void main(String[] args) {
		// manger를 이용하여 학생 추가
		 Ex03_StudentManager manager = new Ex03_StudentManager(2);
		 
		 manager.addNewStudent(manager.input());
		 manager.addNewStudent(manager.input());
		
		
		
		// 전체 학생의 정보 출력
		 manager.outputAllStudents();
		// 전체 평균 출력
		 manager.outputAverage();
		// 특정 학생 찾아서 정보 출력
		 // 학생을 찾아서 리턴 메소드
		 // 전달 받은 학생의 정보를 출력하는 메소드
		 manager.output(manager.findStudent());
		
		
		
		
		
		
	}
}
