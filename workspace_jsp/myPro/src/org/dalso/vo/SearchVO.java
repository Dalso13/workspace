package org.dalso.vo;

import java.sql.Date;

public class SearchVO {
	private String t_writer , title;
	private int hit;
	private Date my_date;
	
	public SearchVO() {
	}

	public SearchVO(String t_writer, String title, int hit, Date my_date) {
		super();
		this.t_writer = t_writer;
		this.title = title;
		this.hit = hit;
		this.my_date = my_date;
	}

	public String getT_writer() {
		return t_writer;
	}

	public void setT_writer(String c_writer) {
		this.t_writer = c_writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public Date getMy_date() {
		return my_date;
	}

	public void setMy_date(Date my_date) {
		this.my_date = my_date;
	}
	
	
	
	
}
