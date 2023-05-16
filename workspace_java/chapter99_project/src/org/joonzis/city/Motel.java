package org.joonzis.city;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.joonzis.name.Player;

public class Motel implements Player {
	private Scanner sc = new Scanner(System.in);
	String select;
	
	public void motel_life() {
		try {
			TimeUnit.SECONDS.sleep(1);
			System.out.println("여관주인 : 어서오세요 무엇이 필요하신가요?" + "\n1.식사 (5원) \t2.취침 (10원)\t3.나가기\n(1,2,3) : ");
			select = sc.nextLine();
			TimeUnit.SECONDS.sleep(1);
			if (select.equals("1") || select.equals("식사")) {
				System.out.println("그저 그런 식사였다.");
				motel_life();
			} else if (select.equals("2") || select.equals("취침")) {
				System.out.println("하룻밤 주무시겠습니까? (1. 네, 2. 아니오) : ");
				String yes = sc.nextLine();
				if (yes.equals("네") || yes.equals("1")) {
					if (player.getBank() >= 10) {
						TimeUnit.SECONDS.sleep(1);
						player.setBank((-10));
						player.setHp(player.maxHp());
						player.setMp(player.maxMp());					
						System.out.println("하룻밤을 묵으셨습니다.");
						System.out.println("남은 금액 : " + player.getBank());
						secy.select();	
					} else {
						TimeUnit.SECONDS.sleep(1);
						System.out.println("소지금이 부족합니다");
						motel_life();
					}
				} else if (yes.equals("아니오") || yes.equals("2")) {
					TimeUnit.SECONDS.sleep(1);
					motel_life();
				}
			} else if (select.equals("3") || select.equals("나가기")) {
				secy.select();
			} else if (select.length() > 10) {
				System.out.println("다시 입력해 주세요.");
				motel_life();
			} else {
				System.out.println("다시 입력해 주세요");
				motel_life();
			}
		} catch (NullPointerException e) {
			System.out.println("다시 입력해 주세요");
			motel_life();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
}
