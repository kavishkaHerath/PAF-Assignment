package com.HeallthcareSystem.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {

	public static Connection connecter() {
		Connection con = null;

		String url = "jdbc:mysql://localhost:8080/hospital";
		String username = "root";
		String password = "";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager
					.getConnection("jdbc:mysql://localhost/hospital?user=" + username + "&password=" + password);
			System.out.println("Connection Success");

		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}
}
