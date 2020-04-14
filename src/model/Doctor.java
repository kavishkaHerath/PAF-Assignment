package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
public class Doctor {

	
	public Connection connect()
	{
		Connection con = null;

		 try
		 {
		 Class.forName("com.mysql.jdbc.Driver");
		 con= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hosptal","root", "");
		 //For testing
		 System.out.print("Successfully connected");
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }

		 return con; 
	
	}

	public String insertDoctors(String doctorId,String doctorName, String specialization, int phoneNo, String email){
		 String output = "";
		 try
		  {
			 Connection con = connect();
			 if (con == null)
			 {
				 return "Error while connecting to the database";
			 }
		  // create a prepared statement
		  String query = " insert into doctor(`doctorId`,`doctorName`,`specialization`,`phoneNo`,`email`)"
		  + " values (?, ?, ?, ?, ?)";
		  PreparedStatement preparedStmt = con.prepareStatement(query);
		  // binding values
		  preparedStmt.setString(1, doctorId);
		  preparedStmt.setString(2, doctorName);
		  preparedStmt.setString(3, specialization);
		  preparedStmt.setInt(4, phoneNo);
		  preparedStmt.setString(5, email); 
		  preparedStmt.execute();
		  con.close();
		  output = "Inserted successfully";
		  }
		 catch (Exception e)
		  {
			 output = "Error while inserting";
			 System.err.println(e.getMessage());
		  }
		 return output; 
	
				}
	public String readDoctors()
	{
		String output = "";
		try
		 {
		 Connection con = connect();
		 if (con == null)
		 {
			 return "Error while connecting to the database for reading.";
		 }
		 // Prepare the html table to be displayed
		 output = "<table border=\"1\"><tr><th>Doctor ID</th>"
		 +"<th>Doctor Name</th><th>Specialization</th>"
		 + "<th>Phone No</th>" + "<th>Email</th>"
		 + "<th>Update</th><th>Remove</th></tr>";
		 String query = "select * from doctor";
		 Statement stmt = con.createStatement();
		 ResultSet rs = stmt.executeQuery(query);
		 // iterate through the rows in the result set
		 while (rs.next())
		 {
		 String doctorId = rs.getString("doctorId");
		 String doctorName = rs.getString("doctorName");
		 String specialization = rs.getString("specialization");
		 int phoneNo = rs.getInt("phoneNo");
		 String email = rs.getString("email");
		 // Add into the html table
		 output += "<tr><td>" + doctorId + "</td>";
		 output += "<td>" + doctorName + "</td>"; 
		 output += "<td>" + specialization + "</td>"; 
		 output += "<td>" + phoneNo + "</td>";
		 output += "<td>" + email + "</td>";
		 // buttons
		 output += "<td><input name=\"btnUpdate\" "
		 + " type=\"button\" value=\"Update\"></td>"
		 + "<td><form method=\"post\" action=\"index.jsp\">"
		 + "<input name=\"btnRemove\" "
		 + " type=\"submit\" value=\"Remove\">"
		 + "<input name=\"itemID\" type=\"hidden\" "
		 + " value=\"" + doctorId + "\">" + "</form></td></tr>";
		 }
		 con.close();
		 // Complete the html table
		 output += "</table>";
		 }
		catch (Exception e)
		 {
		 output = "Error while reading the Doctor.";
		 System.err.println(e.getMessage());
		 }
		return output; 
	}
	public String updateDoctors(String doctorId,String doctorName, String specialization, int phoneNo, String email)
	 {
	 String output = "";
	 try
	 {
	 Connection con = connect();
	 if (con == null)
	 {return "Error while connecting to the database for updating."; }
	 // create a prepared statement
	 String query = "UPDATE doctor SET doctorName=?,specialization=?,phoneNo=?,email=?WHERE doctorId=?";
	 PreparedStatement preparedStmt = con.prepareStatement(query);
	 // binding values
	 preparedStmt.setString(1, doctorName);
	 preparedStmt.setString(2, specialization);
	 preparedStmt.setInt(3, phoneNo);
	 preparedStmt.setString(4, email);
	 preparedStmt.setString(5, doctorId);
	 // execute the statement
	 preparedStmt.execute();
	 con.close();
	 output = "Updated successfully";
	 }
	 catch (Exception e)
	 {
	 output = "Error while updating the Doctors.";
	 System.err.println(e.getMessage());
	 }
	 return output;
	 } 
	public String deleteDoctors(String doctorId)
	 {
	 String output = "";
	 try
	 {
	 Connection con = connect();
	 if (con == null)
	 {return "Error while connecting to the database for deleting."; }
	 // create a prepared statement
	 String query = "delete from doctor where doctorId=?";
	 PreparedStatement preparedStmt = con.prepareStatement(query);
	 // binding values
	 preparedStmt.setString(1, doctorId);
	 // execute the statement
	 preparedStmt.execute();
	 con.close();
	 output = "Deleted successfully";
	 }
	 catch (Exception e)
	 {
	 output = "Error while deleting the item.";
	 System.err.println(e.getMessage());
	 }
	 return output;
	 }
	
	} 




		