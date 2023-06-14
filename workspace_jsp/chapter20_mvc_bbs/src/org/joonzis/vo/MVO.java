package org.joonzis.vo;

import java.sql.Date;

public class MVO {
	private int m_idx , mage;      
	private String mid , mpw, mname, mtel;               
	private Date date;             
	
	
	public MVO() {}

	
	
	public MVO(int m_idx, int mage, String mid, String mpw, String mname, String mtel, Date date) {
		super();
		this.m_idx = m_idx;
		this.mage = mage;
		this.mid = mid;
		this.mpw = mpw;
		this.mname = mname;
		this.mtel = mtel;
		this.date = date;
	}



	public int getM_idx() {
		return m_idx;
	}


	public void setM_idx(int m_idx) {
		this.m_idx = m_idx;
	}


	public int getMage() {
		return mage;
	}


	public void setMage(int mage) {
		this.mage = mage;
	}


	public String getMid() {
		return mid;
	}


	public void setMid(String mid) {
		this.mid = mid;
	}


	public String getMpw() {
		return mpw;
	}


	public void setMpw(String mpw) {
		this.mpw = mpw;
	}


	public String getMname() {
		return mname;
	}


	public void setMname(String mname) {
		this.mname = mname;
	}


	public String getMtel() {
		return mtel;
	}


	public void setMtel(String mtel) {
		this.mtel = mtel;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
