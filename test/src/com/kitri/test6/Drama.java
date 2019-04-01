package com.kitri.test6;

public class Drama extends TVProgram{
	
	private String director;
	private String actor;
	private String actress;

//	public Drama (String director, String actor, String actress) {
//		
//	}
//	
	public Drama(String title, String broadcast, String director, String actor, String actress) {
		super(title, broadcast);
		this.director = director;
		this.actor = actor;
		this.actress = actress;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + "\n\t-감독 : " + director + (actor != null ? "\n\t -감독 : " : "asd" ) ;
	}
	
	
}
