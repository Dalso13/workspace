package org.dalso.vo;

public class TitleVO {
	private String title,cartegory;
	
	
	public TitleVO() {
	}


	public TitleVO(String title, String cartegory) {
		super();
		this.title = title;
		this.cartegory = cartegory;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getCartegory() {
		return cartegory;
	}


	public void setCartegory(String cartegory) {
		this.cartegory = cartegory;
	}
	
	
}
