package org.joonzis.Filed;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.joonzis.name.Player;
import org.joonzis.status.Monster;
import org.joonzis.status.Slime;

public class Fight implements Player {
	Scanner sc = new Scanner(System.in);
	private Random ran = new Random();
	private String select;
	
	
	// 적과 마주침
	public void fightStart() {

		try {
			TimeUnit.SECONDS.sleep(1);
			
			System.out.println(monster1.getName() + " 와(과) 마주쳤다.\n어떻게 해야할까?");
			System.out.println("1. 싸운다\t2. 도망친다");
			select = sc.nextLine();
			
			TimeUnit.SECONDS.sleep(1);
			
			if (select.equals("1") || select.equals("싸운다")) {
				System.out.println("----------------------");
				fightGo();
			} else if (select.equals("2") || select.equals("도망친다")) {
				ran.setSeed(System.currentTimeMillis());
				int num = ran.nextInt(10) + 1;
				
				if (num >= 4) {
					System.out.println("=======================");
					System.out.println("무사히 도망쳤다");
					System.out.println("=======================");
					filedStart.filedStart();
				} else {
					System.out.println("=======================");
					System.out.println("도망치는데 실패하였다!");
					System.out.println("=======================");
					fightGo();
				}
				
			} else if (select.length() > 10) {
				System.out.println("=======================");
				System.out.println("다시 입력해 주세요.");
				System.out.println("=======================");
				fightStart();
				
			}  else {
				System.out.println("=======================");
				System.out.println("다시 입력해 주세요.");
				System.out.println("=======================");
				fightStart();
			}
			
		} catch (NullPointerException e) {
			System.out.println("다시 입력해주세요");
			fightStart();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

	}

	// 싸움시작
	public void fightGo() {
		System.out.println("\t\t이름 : " + (player.getName()) + "  \t 몬스터 이름 :" + monster1.getName());
		System.out.println("\t\tHP : " + (player.getHp()) + " \t HP : " + monster1.getMonsterHp());
		System.out.println("\t\tMP : " + (player.getMp()) + " \tLevel : " + monster1.getMonsterLevel());
		System.out.println("\t\tExp : " + (player.getExp()));
		System.out.println("\t\tLevel : " + (player.getLevel()) );
		try {
		TimeUnit.SECONDS.sleep(1);
		System.out.println("=======================");
		System.out.print("어떤 행동을 해야할까?\n");
		System.out.println("=======================");
			System.out.print("1. 공격\t2.방어 :");
			select = sc.nextLine();
			TimeUnit.SECONDS.sleep(1);
			System.out.println("=======================");
			if (select.equals("1") || select.equals("공격")) {
				System.out.println("기본 공격을 시도하였다!.");
				
				if (player.getAttakPro() >= 3) {
					int slimeHp = monster1.getMonsterHp() - player.getAttak();
					TimeUnit.SECONDS.sleep(1);
					System.out.println((monster1.getMonsterHp() - slimeHp) + " 데미지가 들어갔다!.");
					monster1.setMonsterHp(slimeHp);
				} else if (player.getAttakPro() < 3) {
					TimeUnit.SECONDS.sleep(1);
					System.out.println("명중 실패!");
				}
				
			} else if (select.equals("2") || select.equals("방어")) {
				TimeUnit.SECONDS.sleep(1);
				System.out.println("방어를 시도하였다!.");
			} else if (select.length() > 10) {
				System.out.println("다시 입력해 주세요.");
				fightGo();
			} else {
				System.out.println("다시 입력해 주세요.");
				fightGo();
			}
			
			if (monster1.getMonsterHp() <= 0) {
				System.out.println("=======================\n");
				System.out.println(monster1.getName() + "을 물리쳤다!");
				player.setExp(monster1.getMonsterExp());
				monster1.setMonsterHp(monster1.neverMonsterHp());
				TimeUnit.SECONDS.sleep(1);
				System.out.println(monster1.getMonsterExp() + "Exp 획득!");
				TimeUnit.SECONDS.sleep(1);
				int slimeMoney = monster1.getMonsterMoney();
				System.out.println(slimeMoney + "원 획득!");
				player.setBank(slimeMoney);
				TimeUnit.SECONDS.sleep(1);
				System.out.println("밖으로 나갑니다.");
				System.out.println("=======================\n");
				filedStart.filedStart();
			}
			
		} catch (NullPointerException e) {
			System.out.println("다시 입력해주세요");
			fightGo();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		slimeFight();
		
	} 
	
	// 슬라임 턴
	public void slimeFight() {
		try {
			TimeUnit.SECONDS.sleep(1);
			System.out.println("슬라임 체력 : " + monster1.getMonsterHp());
			TimeUnit.SECONDS.sleep(1);
			System.out.println("=======================");
			System.out.println("슬라임의 공격 차례이다!");
			System.out.println("=======================");
			
			ran.setSeed(System.currentTimeMillis());
			int slimeSelect = ran.nextInt(10) + 1;
			TimeUnit.SECONDS.sleep(1);
			System.out.println("슬라임이 강력한 공격을 한다!");
			int slimeAttak1 = monster1.getMonsterAttak();
			String tank = select;
	
			if (monster1.getMonsterAttak_pro() > 3) {
				if (tank.equals("2") || tank.equals("방어")) {
					int playerTank = player.getTank();
					int playerHp = player.getHp() + playerTank - slimeAttak1;
					TimeUnit.SECONDS.sleep(1);
					System.out.println("=======================");
					System.out.println((player.getHp() - playerHp) + " 데미지가 들어왔다!.");
					player.setHp(playerHp);
					TimeUnit.SECONDS.sleep(1);
					System.out.println("=======================");
				} else {
					int playerHp = player.getHp() - slimeAttak1;
					player.setHp(playerHp);
					TimeUnit.SECONDS.sleep(1);
					System.out.println("=======================");
					System.out.println(slimeAttak1 + " 데미지가 들어왔다!.");
					TimeUnit.SECONDS.sleep(1);
					System.out.println("=======================");
				}

			} else if (monster1.getMonsterAttak() <= 3) {
				TimeUnit.SECONDS.sleep(1);
				System.out.println("=======================");
				System.out.println("빗나갔다! 다행이야");
			}
			
			
			if (player.getHp() <= 0) {
				System.out.println("----------------------" + "\n----------------------\n");
				System.out.println("전투에서 패배했어!");
				TimeUnit.SECONDS.sleep(1);
				System.out.println("u die");
				sc.close();
				System.exit(0);

			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		fightGo();

	}
	
}
