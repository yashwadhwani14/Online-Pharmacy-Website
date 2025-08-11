package com.pharmacystore.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	public static Connection getDatabaseConnection() {
		try {
		Class.forName(DbDetails.DBDriver);
		
		Connection con = DriverManager.getConnection(
				DbDetails.jdbcurl,
				DbDetails.username,
				DbDetails.password);
		
		return con;
		}catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
}
