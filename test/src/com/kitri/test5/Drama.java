package com.kitri.test5;

public class Drama extends Car{
	
	
	
	
	private String series;
	private String use;
	
	public Drama(String color,int account ,String use ,String series) {
		super(color, account);
		this.use = use;
		this.series = series;
		
		
	}

	@Override
	public String toString() {
		
		return super.toString()+ " [용도] " + use + " [시리즈] " + series;
	}
	
}
