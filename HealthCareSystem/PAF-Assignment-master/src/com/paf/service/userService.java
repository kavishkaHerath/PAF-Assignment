package com.paf.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.paf.model.User;
import com.paf.utils.DBconnection;



public class userService {
	Connection con = null;
	
	public userService() {
		 
		con = DBconnection.connecter();
		} 
		
	
		
		
		public String readUsers()
		{	
			String output="";
			//html table  display
			output = "<table border=\"1\"><tr><th>User ID</th><th>Frist Name</th><th>Last Name</th><th>Age</th>"
					+ "<th>Gender</th><th>email</th><th>Phone</th><th>Update</th><th>Remove</th></tr>";
			
			String query = "select * from user";
			
			try {
					Statement statement = con.createStatement();
					ResultSet result = statement.executeQuery(query);
					//	Statement stmt = db.connection.createStatement();
						
					// iterate through the rows in the result set
			while (result.next()) {
					String Pid = result.getString("Pid");
					String Fname = result.getString("Fname");
					String Lname = result.getString("Lname");
					int Age = result.getInt("Age");
					String Gender = result.getString("Gender");
					String email = result.getString("email");
					int Phone = result.getInt("Phone");
								
					// Add into the html table
						output += "<tr><td>" + Pid + "</td>";
						output += "<td>" + Fname + "</td>"; 
						output += "<td>" + Lname + "</td>"; 
						output += "<td>" + Age + "</td>";
						output += "<td>" + Gender + "</td>";
						output += "<td>" + email + "</td>";
						output += "<td>" + Phone + "</td>";
						 
					 output += "<td><input name=\"btnUpdate\" "+ " type=\"button\" value=\"Update\"></td>"
					 + "<td><form method=\"post\" action=\"index.jsp\">"+ "<input name=\"btnRemove\" "
					 + " type=\"submit\" value=\"Remove\">"+ "<input name=\"itemID\" type=\"hidden\" "
					 + " value=\"" + Pid + "\">" + "</form></td></tr>";
					 
			} 
			// Complete the html table
					 output += "</table>";
					 }
					catch (Exception e)
					 {
					 output = "Error while reading the User.";
					 System.err.println(e.getMessage());
					 }
					return output; 
				}
		
		
		public String insertUser(User user) {
			 
			  String query = " insert into user(`Pid`,`Fname`,`Lname`,`Age`,`Gender`,`email`,`Phone`)"
					  + " values (?, ?, ?, ?, ?, ?, ?)";
			  
		 String output;
			try {	
					PreparedStatement preparedStatement = con.prepareStatement(query); 
					preparedStatement.setString(1, user.getPid());
					preparedStatement.setString(2, user.getFname());
					preparedStatement.setString(3, user.getLname());
					preparedStatement.setInt(4,  user.getAge());
					preparedStatement.setString(5, user.getGender());
					preparedStatement.setString(6, user.getEmail()); 
					preparedStatement.setInt(7, user.getPhone()); 
					preparedStatement.execute();
					 con.close();
				  output = "Inserted successfully";
				
			} catch (SQLException e) {
			    output = "Error while inserting the user.";
				System.err.println(e.getMessage());
			}
			
			return output;
		}
		
		
public String updateUser(User user){
			
			String query = "UPDATE user SET Fname=?,Lname=?,Age=?,Gender=?,email=?,Phone=? WHERE Pid=?";
			
			String output;
			try {
				if(con == null) {
					return "Error while connecting to the database for updating";
				}
				PreparedStatement preparedStatement = con.prepareStatement(query);
			 
				preparedStatement.setString(1, user.getFname());
				preparedStatement.setString(2, user.getLname());
				preparedStatement.setInt(3, user.getAge());
				preparedStatement.setString(4, user.getGender());
				preparedStatement.setString(5, user.getEmail()); 
				preparedStatement.setInt(6, user.getPhone()); 
				preparedStatement.setString(7, user.getPid());
				
				preparedStatement.execute();
				con.close();
				output = "Updated successfully";
			}
			 catch (Exception e)
			 {
			 output = "Error while updating the User.";
			 System.err.println(e.getMessage());
			 }
			 return output;
			
		}
		

		
		public String deleteUser(User user){
			String query = "delete from user where Pid=?";
			String output;
			
			
			try {
				
		 if (con == null){
			 return "Error while connecting to the database for deleting."; }
		 // create a prepared statement
		 
		 PreparedStatement preparedStatement = con.prepareStatement(query);
		 // binding values
		 preparedStatement.setString(1, user.getPid());
		 // execute the statement
		 preparedStatement.execute();
		 con.close();
		 output = "Deleted successfully";
		 }catch (Exception e){
		 output = "Error while deleting the User.";
		 System.err.println(e.getMessage());
		 }
		 return output;
		 }
		
		
				
}
	
	


	
	
