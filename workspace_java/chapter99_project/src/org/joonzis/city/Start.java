package org.joonzis.city;


import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.joonzis.name.Player;
import org.joonzis.name.title;
import org.joonzis.status.PlayerStatus;

public class Start implements Player{
	private Scanner sc = new Scanner(System.in);
	private String yes1;
	private String name;
	String select;
	
	public void setName() {
		System.out.println("------------------------------------------");
		try {
			System.out.print("이름 입력 : ");
			name = sc.nextLine().replaceAll(" ","");
			System.out.println("------------------------------------------");
			TimeUnit.SECONDS.sleep(1);
			System.out.print("\""+ name + "\"" + "(으)로 하시겠습니까? (1. 네, 2. 아니오) : ");
			select = sc.nextLine();
		}catch (NullPointerException e) {
			System.out.println("다시 입력해주세요");
			setName();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		if (select.equals("네") || select.equals("1")) {
			player.setName(name);
			start.happyStart();
		} else if(select.equals("아니오") || select.equals("2")) {
			setName();
		} else if (select.length() > 10) {
			System.out.println("다시 입력해 주세요.");
			setName();
		} else {
			System.out.println("다시 입력해 주세요");
			setName();
		}
	}
	
	
	public void happyStart() {
		System.out.println("------------------------------------------");
		try {
			TimeUnit.SECONDS.sleep(1);
			System.out.println("내 이름은 \"" + player.getName() + "\"");
			TimeUnit.SECONDS.sleep(1);
			System.out.println("현재 모험을 하는 중이지." );
			TimeUnit.SECONDS.sleep(1);
			System.out.println("저기 작은 마을이 보이네, 들어갈까?");
			TimeUnit.SECONDS.sleep(1);
			System.out.print("1. 들어간다\t2. 안들어간다 : ");
			this.yes1 = sc.nextLine();
			TimeUnit.SECONDS.sleep(1);
		}catch (NullPointerException e) {
			System.out.println("다시 입력해 주세요");
			happyStart();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		System.out.println("------------------------------------------");
		if (yes1.equals("들어간다") || yes1.equals("1")) {
			System.out.println("어느 작은 마을에 도착했다.");
			secy.select();
		} else if (yes1.equals("안들어간다") || yes1.equals("2")) {
			System.out.println("미구현");
			happyStart();
		} else if (yes1.length() > 10) {
			System.out.println("다시 입력해 주세요.");
			happyStart();
		} else {
			System.out.println("다시 입력해 주세요");
			happyStart();
		}
	}
	
}
