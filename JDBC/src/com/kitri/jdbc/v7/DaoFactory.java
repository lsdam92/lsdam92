package com.kitri.jdbc.v7;

public class DaoFactory {
	public UserDao userDao() {
		ConnectionMaker connectionMaker = connectionMaker();
		UserDao userDao = new UserDao(connectionMaker);
		return userDao;
	}
	
	public MemberDao memberDao() {
		ConnectionMaker connectionMaker = connectionMaker();
		MemberDao memberDao = new MemberDao(connectionMaker);
		return memberDao;
	}
	
	public ConnectionMaker connectionMaker() { 
		return new OracleConnectionMaker();
	}
}