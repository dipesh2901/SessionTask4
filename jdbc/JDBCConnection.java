package com.neosoft.httptest.jdbc;

import java.sql.*;

public class JDBCConnection {
	static Connection con = null;

	public static Connection openConnection() {
		try {
			JDBCProperty.loadProperties();
			Class.forName(JDBCProperty.driverClass);
			System.out.println("Driver Loaded!!!");
			con = DriverManager.getConnection(JDBCProperty.url, JDBCProperty.username, JDBCProperty.password);
			System.out.println("Connection established");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static void closeConnection() {
		try {
			if(con!=null) {
				con.close();
				System.out.println("Connection Closed!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}
