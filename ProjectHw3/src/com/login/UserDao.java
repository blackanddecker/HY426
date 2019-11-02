package com.login;

import java.sql.*;

public class UserDao {
	String url = "jdbc:mysql://localhost:3306/www?autoReconnect=true&useSSL=false";
	String user = "root";
	String pass = "root";
	public boolean check (String username, String password) {
		String sql ="select * from user where username = ? and password =?";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, username);
			st.setString(2, password);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				return true;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean insert (String username, String password) {
		try {
			String sql ="insert into user values( ? , ?)";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, username);
			st.setString(2, password);
			int rs = st.executeUpdate();
			if(rs>0) {
				return true;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
