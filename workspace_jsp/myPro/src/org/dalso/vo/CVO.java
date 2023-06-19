package org.dalso.vo;

public class CVO {
	private int c_idx , t_idx;         
	private String c_writer , c_pw;
	
	public CVO() {
	}

	public CVO(int c_idx, int t_idx, String c_writer, String c_pw) {
		super();
		this.c_idx = c_idx;
		this.t_idx = t_idx;
		this.c_writer = c_writer;
		this.c_pw = c_pw;
	}

	public int getC_idx() {
		return c_idx;
	}

	public void setC_idx(int c_idx) {
		this.c_idx = c_idx;
	}

	public int getT_idx() {
		return t_idx;
	}

	public void setT_idx(int t_idx) {
		this.t_idx = t_idx;
	}

	public String getC_writer() {
		return c_writer;
	}

	public void setC_writer(String c_writer) {
		this.c_writer = c_writer;
	}

	public String getC_pw() {
		return c_pw;
	}

	public void setC_pw(String c_pw) {
		this.c_pw = c_pw;
	}
	
	
}
