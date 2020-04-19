package com.paf.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import com.paf.model.Appointment;
import com.paf.utils.DBconnection;





public class appoimentService {
	Connection con = null;
	
	public appoimentService() {
		 
		con = DBconnection.connecter();
		} 

	public String insertAppoiment(Appointment appoiment) {
			 
			  String query = " insert into appoiment(`AId`,`Pid`,`doctorId`,`hosptlId`,`date`,`time`,`charge`)"
					  + " values (?, ?, ?, ?, ?, ?, ?)";
			  
		 String output;
			try {	
					PreparedStatement preparedStatement = con.prepareStatement(query); 
					
					preparedStatement.setString(1, appoiment.getAId());
					preparedStatement.setString(2, appoiment.getPid());
					preparedStatement.setString(3, appoiment.getDoctorId());
					preparedStatement.setString(4,  appoiment.getHosptlId());
					preparedStatement.setString(5, appoiment.getDate());
					preparedStatement.setString(6, appoiment.getTime()); 
					preparedStatement.setFloat(7, appoiment.getCharge()); 
					preparedStatement.execute();
					 con.close();
				  output = "Inserted successfully";
				
			} catch (SQLException e) {
			    output = "Error while inserting the Appoiment.";
				System.err.println(e.getMessage());
			}
			
			return output;
		}
		
		
		public String readAppoiment(){	
			String output="";
//html table  display
			output = "<table border=\"1\"><tr><th>Appoiment ID</th><th>Persion Id</th><th>Doctor Id</th><th>Hosptal Id</th>"
					+ "<th>Appoiment Date</th><th>Appoiment Time</th><th>Charges</th><th>Update</th><th>Remove</th></tr>";
			
			String query = "select * from Appoiment";
			
			try {
					Statement statement = con.createStatement();
					ResultSet result = statement.executeQuery(query);
//	Statement stmt = db.connection.createStatement();
						
// iterate through the rows in the result set
			while (result.next()) {
			
					String AId = result.getString("AId");
					String Pid = result.getString("Pid");
					String doctorId = result.getString("doctorId");
					String hosptlId = result.getString("hosptlId");
					String date = result.getString("date");
					String time = result.getString("time");
					float charge = result.getFloat("charge");
								
// Add into the html table
						output += "<tr><td>" + AId + "</td>";
						output += "<td>" + Pid + "</td>"; 
						output += "<td>" + doctorId + "</td>"; 
						output += "<td>" + hosptlId + "</td>";
						output += "<td>" + date + "</td>";
						output += "<td>" + time + "</td>";
						output += "<td>" + charge + "</td>";
						 
					 output += "<td><input name=\"btnUpdate\" "+ " type=\"button\" value=\"Update\"></td>"
					 + "<td><form method=\"post\" action=\"index.jsp\">"+ "<input name=\"btnRemove\" "
					 + " type=\"submit\" value=\"Remove\">"+ "<input name=\"itemID\" type=\"hidden\" "
					 + " value=\"" + AId + "\">" + "</form></td></tr>";
					 
			} 
// Complete the html table
					 output += "</table>";
					 }
					catch (SQLException e)
					 {
					 output = "Error while reading the Appoiment.";
					 System.err.println(e.getMessage());
					 }
					return output; 
				}

		public String updateAppoiment(Appointment appoiment){
			
			String query = "UPDATE appoiment SET Pid=?,doctorId=?,hosptlId=?,date=?,time=?,charge=?WHERE AId=?";
			
			String output;
			try {
				PreparedStatement preparedStatement = con.prepareStatement(query);
				if(con == null) {
					return "Error while connecting to the database for updating";
				}
				preparedStatement.setString(1, appoiment.getPid());
				preparedStatement.setString(2, appoiment.getDoctorId());
				preparedStatement.setString(3,  appoiment.getHosptlId());
				preparedStatement.setString(4, appoiment.getDate());
				preparedStatement.setString(5, appoiment.getTime()); 
				preparedStatement.setFloat(6, appoiment.getCharge());
				preparedStatement.setString(7, appoiment.getAId());
				
				  if(preparedStatement.executeUpdate() == 1) {
		                output = "Updated successfully";
		            }else{
		                output = "Error while updating the Doctors.";            }
		           
		                con.close();
			}
			 catch (SQLException e)
			 {
			 output = "Error while updating the Appoiment.";
			 System.err.println(e.getMessage());
			 }
			 return output;
			
		}
		public String deleteAppoiment(Appointment appoiment){
			String query = "delete from appoiment where AId=?";
			String output;
			
			
			try {
				
		 if (con == null){
			 return "Error while connecting to the database for deleting."; }
		 // create a prepared statement
		 
		 PreparedStatement preparedStatement = con.prepareStatement(query);
		 // binding values
		 preparedStatement.setString(1, appoiment.getAId());
		 // execute the statement
		 preparedStatement.execute();
		 con.close();
		 output = "Deleted successfully";
		 }catch (SQLException e){
		 output = "Error while deleting the Appoiment.";
		 System.err.println(e.getMessage());
		 }
		 return output;
		 }
		
		
				
		
		}
		
	
	


	
	
