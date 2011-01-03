package com.contactmgmt.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConnection {
	private DatabaseConnection() {
	}

	static Connection dbcon;

	// static Statement stmt = null;
	static public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			if (null == dbcon)
				dbcon = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/test", "", "");
			// stmt = dbcon.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return dbcon;
	}

	/*
	 * public int executeQuery(String query) { Statement stmt; int rs = 0; try {
	 * stmt = dbcon.createStatement(); rs = stmt.executeUpdate(query); } catch
	 * (SQLException e) { e.printStackTrace(); } return rs; }
	 */
}
