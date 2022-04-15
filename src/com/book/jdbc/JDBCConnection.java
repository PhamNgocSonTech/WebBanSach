package com.book.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
	public static Connection getJDBCConnection() {
		Connection connection = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String user = "sa";
			String pass = "sa123";
			String url = "jdbc:sqlserver://localhost:1433;databaseName=UNIFY";
			connection = DriverManager.getConnection(url, user, pass);
			System.out.println("Success Connect Database");
			
		} catch (ClassNotFoundException | SQLException ex) {
			ex.printStackTrace();
		}

		return connection;
	}
	
}
