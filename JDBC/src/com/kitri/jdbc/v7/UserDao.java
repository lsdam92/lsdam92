package com.kitri.jdbc.v7;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
	private ConnectionMaker connectionMaker;

	public UserDao(ConnectionMaker connectionMaker) {
		this.connectionMaker = connectionMaker;
	}
	public void add(UserDto user) throws ClassNotFoundException, SQLException {
		Connection c = connectionMaker.makeConnection();	
		
		PreparedStatement ps = c.prepareStatement(
				"insert into usertest(id, name, password) values(?,?,?)");
		ps.setString(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());
		
		ps.executeUpdate();
		
		ps.close();
		c.close();
	}
	
	public UserDto get(String id) throws ClassNotFoundException, SQLException {
		Connection c = connectionMaker.makeConnection();

		
		PreparedStatement ps = c.prepareStatement(
				"select * from usertest where id=?");
		ps.setString(1, id);
		
		ResultSet rs = ps.executeQuery();
		rs.next();
		UserDto user = new UserDto();
		user.setId(rs.getString("id"));
		user.setName(rs.getString("name"));
		user.setPassword(rs.getString("password"));
		
		rs.close();
		ps.close();
		c.close();
		
		return user;
	}
	
	public UserDto getUserByName(String name) throws ClassNotFoundException, SQLException {
		Connection c = connectionMaker.makeConnection();

		
		PreparedStatement ps = c.prepareStatement(
				"select * from usertest where name=?");
		ps.setString(1, name);
		
		ResultSet rs = ps.executeQuery();
		rs.next();
		UserDto user = new UserDto();
		user.setId(rs.getString("id"));
		user.setName(rs.getString("name"));
		user.setPassword(rs.getString("password"));
		
		rs.close();
		ps.close();
		c.close();
		
		return user;
	}
}
