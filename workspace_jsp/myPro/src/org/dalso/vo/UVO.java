package org.dalso.vo;

public class UVO {
	private int u_idx;          
	private String u_writer , u_pw,u_power;
	
	public UVO() {
	}

	public UVO(int u_idx, String u_writer, String u_pw , String u_power) {
		super();
		this.u_idx = u_idx;
		this.u_writer = u_writer;
		this.u_pw = u_pw;
		this.u_power = u_power;
	}

	public String getU_power() {
		return u_power;
	}

	public void setU_power(String u_power) {
		this.u_power = u_power;
	}

	public int getU_idx() {
		return u_idx;
	}

	public void setU_idx(int u_idx) {
		this.u_idx = u_idx;
	}

	public String getU_writer() {
		return u_writer;
	}

	public void setU_writer(String u_writer) {
		this.u_writer = u_writer;
	}

	public String getU_pw() {
		return u_pw;
	}

	public void setU_pw(String u_pw) {
		this.u_pw = u_pw;
	}
	
	
}
