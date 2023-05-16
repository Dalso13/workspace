package org.joonzis.city;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.joonzis.Filed.FiledStart;
import org.joonzis.name.Player;
import org.joonzis.name.StatusWindow;

public class Select_city implements Player{
	private Motel motel = new Motel(); 
	private Shop shop = new Shop();
	private Scanner sc = new Scanner(System.in);
	private String move;
	
	
	public void select() {
		try {
			TimeUnit.SECONDS.sleep(1);
			System.out.print("이제 무엇을 할까?" + "\n1. 여관 가기\t2.상점 가기\t3.필드로 가기\t4.상태창 열기" + "\n(1,2,3,4) : ");
			this.move = sc.nextLine();
		
			if (move.equals("1") || move.equals("여관")) {
				motel.motel_life();
			} else if (move.equals("2") || move.equals("상점")) {
				shop.shop();
			} else if (move.equals("3") || move.equals("필드")) {
				TimeUnit.SECONDS.sleep(1);
				System.out.println("당신은 마을을 떠나 몬스터가 있는 필드로 들어왔다.");
				filedStart.filedStart();
			} else if (move.equals("4") || move.equals("상태창")) {
				stat.statusWindow();
			} else if (move.length() > 10) {
				System.out.println("다시 입력해 주세요.");
				select();
			} else  {
				System.out.println("다시 입력해 주세요");
				select();
			}
		} catch (NullPointerException e) {
			System.out.println("다시 입력해 주세요");
			select();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
