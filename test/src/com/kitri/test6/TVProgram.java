package com.kitri.test6;

public class TVProgram {

	private String title;
	private String broadcast;

	public TVProgram(String title, String broadcast) {
		super();
		this.title = title;
		this.broadcast = broadcast;

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return title + " (" + broadcast + ")";
	}

}
