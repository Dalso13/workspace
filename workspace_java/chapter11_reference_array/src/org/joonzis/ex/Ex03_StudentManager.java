package org.joonzis.ex;

import java.util.Scanner;

public class Ex03_StudentManager {
	int idx; // 외부(전역)에서 접근 가능한 인덱스
	Ex03_Student[] arr;
	Scanner sc = new Scanner(System.in);
	public Ex03_StudentManager() {}
	
	// 생성자 - 몇 명의 학생을 관리할지 - 배열 선언
	
	public Ex03_StudentManager(int numOfStudents) {
		 arr = new Ex03_Student[numOfStudents];
	}
	// 학생 정보를 저장한 뒤 학생 객체 리턴
	Ex03_Student input() {
		System.out.print("학생 이름 : ");
		String name = sc.nextLine();
		System.out.print("학생 과목 : ");
		String dept = sc.nextLine();
		System.out.print("중간 점수 : ");
		String score1 = sc.nextLine();
		System.out.print("기말 점수 : ");
		String score2 = sc.nextLine();
		return new Ex03_Student(name, dept, score1, score2);
	}
	
	// input() 에서 받아온 학생 객체를 배열에 저장
	void addNewStudent(Ex03_Student student) {
		arr[idx] = student;
		idx++;
	}
	
	// 전체 학생 정보 출력
	void outputAllStudents() {
		for (int i = 0; i < arr.length; i++) {
			System.out.println((i+1) + "번 학생 정보---------");
			arr[i].output();
			
		}
	}
	//학생 전체의 평균 점수 출력
	void outputAverage() {
		double total = 0;
		
		for (int i = 0; i < arr.length; i++) {
			total += arr[i].getAverage();
		}
		
		System.out.println("전체 평균 점수: " + total/idx);
	}
	
	// 학생 찾는 메소드
	Ex03_Student findStudent() {
		System.out.println("찾을 학생 이름 입력 :");
		String name = sc.next();
		for (int i = 0; i < arr.length; i++) {
			if(name.equals(arr[i].name)) {
				return arr[i];
			}	
		}
		return null;
	}
	// 학생 정보를 전달 받아 출력하는 메소드
	void output(Ex03_Student student) {
		if(student != null) {
			student.output();
		} else {
			System.out.println("찾는 학생이 없습니다");
		}
	}
	
}
