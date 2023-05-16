package org.joonzis.Filed;

import java.util.Random;
import java.util.Scanner;

import org.joonzis.name.Player;
import org.joonzis.status.PlayerStatus;

public class Quest	implements Player {
	Scanner sc = new Scanner(System.in);
	Random ran = new Random();
	
	
	
	public void quest() {
		ran.setSeed(System.currentTimeMillis());
		int num = ran.nextInt(10)+1;
		if (num < 6) {
			filedStart.filedStart();
		} else if (num >= 6) {
			fight.fightStart();
		}
	}
}
