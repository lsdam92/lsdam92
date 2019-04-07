package com.kitri.jdbc.v7;

import java.sql.*;

public class MemberDao {
private ConnectionMaker connectionMaker;
	
	public MemberDao(ConnectionMaker connectionMaker) {
		this.connectionMaker = connectionMaker;
	}
	
	public void add(UserDto user) throws ClassNotFoundException, SQLException {
		Connection c = connectionMaker.makeConnection();	
		
		PreparedStatement ps = c.prepareStatement(
				"insert into users(id, name, password) values(?,?,?)");
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
				"insert into users(id, name, password) values(?,?,?)");
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
}
