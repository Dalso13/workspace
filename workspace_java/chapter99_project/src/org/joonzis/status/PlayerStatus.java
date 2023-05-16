package org.joonzis.status;

import java.util.Random;

public  class PlayerStatus{
	Random ran = new Random();
	private String name;
	private int exp;
	private int level = 1;
	private int hp;
	private int mp;
	private int attak;
	private int attak_pro;
	private int tank;
	private int bank;
	
	public  PlayerStatus() {
		this.exp = 0;
		this.hp = 250;
		this.mp = 50;
		this.bank = 100;
	}


	public String getName() {
		return name;
	}
	
	public void stat() {
		System.out.println("이름 : " + getName());
		System.out.println("HP : " + getHp());
		System.out.println("MP : " + getMp());
		System.out.println("Exp : " + getExp());
		System.out.println("Level : " + getLevel());
		System.out.println("소지금 : " + getBank() + "원");
		
	}

	

	//hp
	public int maxHp() {
		int count = ((this.level-1) * 25);
		return (250 + count);
	}
	
	public int getHp() {
		return this.hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}
	
	
	
	public void setName(String name) {
		this.name = name;
	}

	
	
	//mp
	public int getMp() {
		return this.mp;
	}
	public void setMp(int mp) {
		
		this.mp = mp;
	}

	public int maxMp() {
		int count1 = ((this.level-1) * 10);
		return (50 + count1);
	}


	
	//exp
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp += exp;
		if (this.exp >= (50*level)) {
			this.exp -= (50*level);
			this.level++;
			System.out.println("레벨업!");
			setHp(maxHp());
			setMp(maxMp());
		}
	}


	//레벨
	public void setLevel(int level) {
		this.level = level;
	}
	public int getLevel() {
		return level;
	}

	
	// 데미지
	public void setAttak() {
		int count = (this.level)*5;

		this.attak = ran.nextInt(50+count)+30;
	}

	public int getAttak() {
		int count = (this.level)*5;
		ran.setSeed(System.currentTimeMillis());
		return this.attak = ran.nextInt(50+count)+30;
	}

	public int getAttakPro() {
		ran.setSeed(System.currentTimeMillis());
		return this.attak_pro = ran.nextInt(10)+1;
	}
	
	// 방어
	public int getTank() {
		int count = (this.level)*3;
		ran.setSeed(System.currentTimeMillis());
		return tank = ran.nextInt(30+count)+10;
	}


	//주머니

	public int getBank() {
		return bank;
	}
	
	public void saveBank(int bank) {
		this.bank = bank;
	}
	
	
	public void setBank(int bank) {
		this.bank += bank;
	}
	

}
