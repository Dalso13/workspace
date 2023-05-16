package org.joonzis.Filed;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.joonzis.name.Player;

public class Camp implements Player {
	Scanner sc = new Scanner(System.in);
	Random ran = new Random();
	
	public void camp() {
		
		try {
			TimeUnit.SECONDS.sleep(1);
			System.out.println("캠핑을 준비하였다. 무사히 넘겨야 할텐데...");
			ran.setSeed(System.currentTimeMillis());
			int num = ran.nextInt(10)+1;
			
			if (num >= 4) {
				TimeUnit.SECONDS.sleep(1);	System.out.print(".");
				TimeUnit.SECONDS.sleep(1);	System.out.print(".");
				TimeUnit.SECONDS.sleep(1);	System.out.print(".");
				TimeUnit.SECONDS.sleep(1);
				System.out.println("하룻밤을 무사히 넘겼다..");
				player.setHp(player.maxHp());
				player.setMp(player.maxMp());
				System.out.println("Hp Mp 회복!!");
				filedStart.filedStart();
			} else if (num < 4) {
				TimeUnit.SECONDS.sleep(1);	System.out.print(".");
				TimeUnit.SECONDS.sleep(1);	System.out.print(".");
				TimeUnit.SECONDS.sleep(1);
				System.out.println("이런! 적이 습격해왔다!");
				fight.fightStart();
			}
		
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
}
