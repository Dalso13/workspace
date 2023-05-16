package org.joonzis.Filed;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.joonzis.city.Select_city;
import org.joonzis.name.Player;
import org.joonzis.status.PlayerStatus;

public class FiledStart implements Player {
	private Scanner sc = new Scanner(System.in);
	private static int count = 1;
	private String select;
	private Camp camp = new Camp();

	public void filedStart() {
		try {
			TimeUnit.SECONDS.sleep(1);
			System.out.println("=======================");
			System.out.println("광활한 평야" + (count));
			System.out.println("=======================\n");
			TimeUnit.SECONDS.sleep(1);
			System.out.print("1.나아간다    2.숙영     3.마을로 돌아간다.\n(1,2,3) : ");
			select = sc.nextLine();
			count++;
			if (select.equals("1") || select.equals("전진")) {
				quest.quest();
			} else if (select.equals("2") || select.equals("숙영")) {
				count--;
				camp.camp();
			} else if (select.equals("3") || select.equals("마을")) {
				count--;
				TimeUnit.SECONDS.sleep(1);
				System.out.println("왔던 길로 최대한 빨리 돌아갔다.");
				secy.select();
			} else if (select.length() > 10) {
				count--;
				TimeUnit.SECONDS.sleep(1);
				System.out.println("다시 입력해 주세요.");
				filedStart();
			} else {
				count--;
				TimeUnit.SECONDS.sleep(1);
				System.out.println("다시 입력해 주세요.");
				filedStart();
			}
		} catch (NullPointerException e) {
			System.out.println("다시 입력해 주세요.");
			filedStart();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
}
