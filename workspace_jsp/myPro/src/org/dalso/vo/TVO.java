package org.dalso.vo;

import java.sql.Date;

public class TVO {
	private int t_idx , hit;           
	private String t_writer, title, first_c_title, second_c_title, third_c_title, emage, cartegory, semi_cartegory;
	private String first_c, second_c, third_c;                    
	private Date my_date;
	
	public TVO() {
	}
	public TVO(int t_idx, int hit, String t_writer, String title, String first_c_title, String second_c_title,
			String third_c_title, String emage, String cartegory, String semi_cartegory, String first_c,
			String second_c, String third_c, Date my_date) {
		super();
		this.t_idx = t_idx;
		this.hit = hit;
		this.t_writer = t_writer;
		this.title = title;
		this.first_c_title = first_c_title;
		this.second_c_title = second_c_title;
		this.third_c_title = third_c_title;
		this.emage = emage;
		this.cartegory = cartegory;
		this.semi_cartegory = semi_cartegory;
		this.first_c = first_c;
		this.second_c = second_c;
		this.third_c = third_c;
		this.my_date = my_date;
	}
	public int getT_idx() {
		return t_idx;
	}
	public void setT_idx(int t_idx) {
		this.t_idx = t_idx;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getT_writer() {
		return t_writer;
	}
	public void setT_writer(String t_writer) {
		this.t_writer = t_writer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFirst_c_title() {
		return first_c_title;
	}
	public void setFirst_c_title(String first_c_title) {
		this.first_c_title = first_c_title;
	}
	public String getSecond_c_title() {
		return second_c_title;
	}
	public void setSecond_c_title(String second_c_title) {
		this.second_c_title = second_c_title;
	}
	public String getThird_c_title() {
		return third_c_title;
	}
	public void setThird_c_title(String third_c_title) {
		this.third_c_title = third_c_title;
	}
	public String getEmage() {
		return emage;
	}
	public void setEmage(String emage) {
		this.emage = emage;
	}
	public String getCartegory() {
		return cartegory;
	}
	public void setCartegory(String cartegory) {
		this.cartegory = cartegory;
	}
	public String getSemi_cartegory() {
		return semi_cartegory;
	}
	public void setSemi_cartegory(String semi_cartegory) {
		this.semi_cartegory = semi_cartegory;
	}
	public String getFirst_c() {
		return first_c;
	}
	public void setFirst_c(String first_c) {
		this.first_c = first_c;
	}
	public String getSecond_c() {
		return second_c;
	}
	public void setSecond_c(String second_c) {
		this.second_c = second_c;
	}
	public String getThird_c() {
		return third_c;
	}
	public void setThird_c(String third_c) {
		this.third_c = third_c;
	}
	public Date getMy_date() {
		return my_date;
	}
	public void setMy_date(Date my_date) {
		this.my_date = my_date;
	}
	
	
	
	                    
	          
	                       
	                   
	    
	 
	  
}
