package org.joonzis.city;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.joonzis.name.Player;

public class Shop implements Player {
	private Scanner sc = new Scanner(System.in);
	private String select;

	public void shop() {
		try {
			System.out.println("----------------------");
			System.out.print("어서오세요, 어떤 물건이 필요하신가요? " + "\n1.장비\t2.소모품\t3.나가기\n(1,2,3)  : ");
			select = sc.nextLine();
			System.out.println("----------------------");
			TimeUnit.SECONDS.sleep(1);
			if (select.equals("1") || select.equals("장비")) {
				System.out.println("미구현 \n");
				TimeUnit.SECONDS.sleep(1);
				shop();
			} else if (select.equals("2") || select.equals("소모품")) {
				System.out.println("미구현 \n");
				TimeUnit.SECONDS.sleep(1);
				shop();
			} else if (select.equals("3") || select.equals("나가기")) {
				secy.select();
			} else if (select.length() > 10) {
				System.out.println("다시 입력해 주세요.");
				shop();
			} else {
				System.out.println("다시 입력해 주세요");
				TimeUnit.SECONDS.sleep(1);
				shop();
			}
		} catch (NullPointerException e) {
			System.out.println("다시 입력해 주세요");
			shop();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
