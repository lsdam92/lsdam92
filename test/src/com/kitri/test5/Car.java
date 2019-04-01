package com.kitri.test5;


public class Car {

	
	private String color;
	private int account;

	public Car(String color, int account) {
		super();
		this.color = color;
		this.account = account;
		
	}
	
	
	

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[색상] " + color + " [생산수량] " + account; 
	}

}
