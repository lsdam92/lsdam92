package com.kitri.jdbc.v6;

public class DaoFactory {
	public UserDao userDao() {
		ConnectionMaker connectionMaker = new OracleConnectionMaker();
		UserDao userDao = new UserDao(connectionMaker);
		return userDao;
	}
}