package com.contactmgmt.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



 public class DatabaseConnection {
	static Connection dbcon;

	static public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			dbcon = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test", "", "");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return dbcon;
	}
	public ResultSet executeQuery(String query){
		Statement stmt;
		ResultSet rs = null;
		try {
			stmt = dbcon.createStatement();
			rs = stmt.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
}
