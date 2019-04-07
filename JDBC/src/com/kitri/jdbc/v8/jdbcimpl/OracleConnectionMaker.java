package com.kitri.jdbc.v8.jdbcimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.kitri.jdbc.v8.jdbcinterface.ConnectionMaker;

public class OracleConnectionMaker implements ConnectionMaker{

	@Override
	public Connection makeConnection() {
		Connection c = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			c = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl", "kitri", "kitri");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
}
