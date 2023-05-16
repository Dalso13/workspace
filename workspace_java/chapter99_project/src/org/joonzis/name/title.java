package org.joonzis.name;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.joonzis.city.Start;
import org.joonzis.status.PlayerStatus;



public class title implements Player{
	private Scanner sc = new Scanner(System.in);
	private String select;
	public title() {
	}
	
	public void name() {
		System.out.println("------------------------------------------");
		System.out.println("\t\t 구트 게임\n");
		System.out.println("1. 게임시작" + "\t2. 이어 하기" + "\t3. 게임 종료");
		System.out.println("------------------------------------------");
		
		try {
			System.out.print("선택 : ");
			select = sc.nextLine();
			if (select.equals("1")) {
				TimeUnit.SECONDS.sleep(1);
				start.setName();
			} else if (select.equals("2")) {
				road road = new road();
				road.road();
			} else if (select.equals("3")) {
				sc.close();
				System.exit(0);
			} else if (select.equals("3389")) {
				TimeUnit.SECONDS.sleep(1);
				stat.statusWindow();
			} else {
				System.out.println("다시 입력해 주세요.");
				name();
			}
			
		}catch (NullPointerException e) {
			System.out.println("다시 입력해주세요");
			name();
		}catch (InterruptedException e1) {
			e1.printStackTrace();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
}
