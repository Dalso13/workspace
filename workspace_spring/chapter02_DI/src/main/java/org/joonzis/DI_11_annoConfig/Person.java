package org.joonzis.DI_11_annoConfig;

import java.util.ArrayList;


public class Person {
	private String name;
	private double height;
	private ArrayList<String> hobbies;
	
	public Person() {
	}

	
	
	public Person(String name, double height, ArrayList<String> hobbies) {
		super();
		this.name = name;
		this.height = height;
		this.hobbies = hobbies;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public ArrayList<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(ArrayList<String> hobbies) {
		this.hobbies = hobbies;
	}
	

	
	
	
}
