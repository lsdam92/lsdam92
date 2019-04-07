package com.kitri.jdbc.v4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnectionMaker implements ConnectionMaker{

	@Override
	public Connection makeConnection() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OacleDriver");
		Connection c = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:orcl", "kitri", "kitri");
		return c;
	}
	
}
