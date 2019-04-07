package com.kitri.jdbc.v8.dao;

import com.kitri.jdbc.v8.*;
import com.kitri.jdbc.v8.jdbcimpl.OracleConnectionMaker;
import com.kitri.jdbc.v8.jdbcinterface.ConnectionMaker;

public class DaoFactory {
	public ConnectionMaker connectionMaker() { 
		return new OracleConnectionMaker();
	}
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
	
}