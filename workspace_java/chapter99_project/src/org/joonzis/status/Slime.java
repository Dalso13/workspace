package org.joonzis.status;

import java.util.Random;

import org.joonzis.name.Player;

public class Slime //extends Monster
{
	private String name1;
	private int hp1;
	private int mp1;
	private int level1;
	private int slimeAttak;
	private int slimeAttak_pro;
	Random ran = new Random();
	private int slimeTank;
	private int slimeExp;
	private int slimeMoney;

	public Slime() {
		this.name1 = "슬라임";
		this.hp1 = 150;
		this.level1 = 1;
		this.slimeExp = 50;
	}

//	@Override
	public int neverMonsterHp() {
		int count = (level1 -1) * 25;
		return 150+count;
	}

//	@Override
	public int getMonsterHp() {
		return hp1;
	}

//	@Override
	public void setMonsterHp(int hp1) {
		this.hp1 = hp1;
		if (this.slimeExp >= (50 * this.level1)) {
			
			this.level1++;
		}
	}
//
//	@Override
	public void setMonsterMp(int mp) {
		this.mp1 += mp;
	}

//	@Override
	public int getMonsterMp() {
		return this.mp1;
	}

//	@Override
	public String getName() {
		return name1;
	}

//	@Override
	public int getMonsterExp() {
		int count = ((level1 -1) * 25);
		return this.slimeExp + count;
	}

//	@Override
	public void setMonsterLevel(int level) {
		this.level1 = level;

	}

//	@Override
	public int getMonsterLevel() {
		return level1;
	}

//	@Override
	public int getMonsterMoney() {
		ran.setSeed(System.currentTimeMillis());
		return slimeMoney = ran.nextInt(20) + 10;
	}

//	@Override
	public int getMonsterAttak() {
		int count = (this.level1) * 5;
		ran.setSeed(System.currentTimeMillis());
		return this.slimeAttak = ran.nextInt(40 + count) + 25;
	}
//
//	@Override
	public int getMonsterAttak_pro() {
		ran.setSeed(System.currentTimeMillis());
		return slimeAttak_pro = ran.nextInt(10) + 1;
	}

	// 슬라임 방어
//	public int getSlimeTank() {
//		int count = (this.level1)*3;
//		ran.setSeed(System.currentTimeMillis());
//		return slimeTank = ran.nextInt(30+count)+10;
//	}
//	
}
