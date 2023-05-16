package org.joonzis.name;

import java.util.Scanner;

import org.joonzis.city.Select_city;
import org.joonzis.status.PlayerStatus;

public class StatusWindow implements Player{
	Scanner sc = new Scanner(System.in);
	private String select;
	
	public void statusWindow() {
		System.out.println("----------------------");
		
		try {
			System.out.println("1. 상태창 보기    2. 창 끄기   3. 저장   4. 게임종료");
			select = sc.nextLine();
		} catch (NullPointerException e) {
			System.out.println("다시 입력해 주세요.");
			statusWindow();
		}
		
		System.out.println("\n----------------------");
		if (select.equals("1") || select.equals("상태창 보기")) {
			player.stat();
			statusWindow();
		} else if (select.equals("2") || select.equals("창 끄기")) {
			secy.select();
			System.out.println("\n----------------------");
		} else if (select.equals("3") || select.equals("저장")) {
			save.saveFilter();
			
		} else if (select.equals("4") || select.equals("게임종료")) {
			System.out.println("종료 했습니다.");
			sc.close();
			System.exit(0);
		}  else if (select.length() > 10) {
			System.out.println("다시 입력해 주세요.");
			statusWindow();
		} else {
			System.out.println("다시 입력해 주세요.");
			statusWindow();
		}
	}
}
