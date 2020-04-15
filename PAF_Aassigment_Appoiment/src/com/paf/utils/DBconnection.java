package com.paf.utils;

import java.sql.Connection;
import java.sql.DriverManager;
;

public class DBconnection {
	
	public static  Connection connecter()
	{
		Connection con = null;
		
		String url = "jdbc:mysql://localhost:8080/hosptal";
		String username = "root";
		String password = "";
		
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			//con =  (Connection) DriverManager.getConnection(url,username,password);
			con = DriverManager.getConnection("jdbc:mysql://localhost/hosptal?user="+username+"&password="+password);
			System.out.println("Connection Success");
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return con;
	} 
}


