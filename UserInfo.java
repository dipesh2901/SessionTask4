package com.neosoft.Task.program33;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.Arrays;

import com.neosoft.httptest.jdbc.JDBCConnection;

public class UserInfo {
	public static String validUser(String username, String password) {
		Connection con = JDBCConnection.openConnection();
		String user = "", pass = "";
		PreparedStatement pst = null;
		ResultSet rs = null;

		String Query = "select username,password from user";
		try {
			pst = con.prepareStatement(Query);
			rs = pst.executeQuery();
			while (rs.next()) {
				user = rs.getString(1);
				pass = rs.getString(2);
				if (user.equals(username) && pass.equals(password)) {
					return username;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			JDBCConnection.closeConnection();
		}
		return "";
	}

	public static void insertUserInfo(UserData user) {
		Connection con = JDBCConnection.openConnection();
		PreparedStatement pst = null;
		String insertQuery = "insert into user values(?,?,?,?,?)";
		try {
			pst = con.prepareStatement(insertQuery);
			pst.setInt(1, user.getUid());
			pst.setString(2, user.getEmail());
			pst.setString(3, user.getMobile());
			pst.setString(4, user.getUsername());
			pst.setString(5, user.getPassword());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			JDBCConnection.closeConnection();
		}
	}

}
