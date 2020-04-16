package com.paf.service;

import java.sql.*;
import com.paf.utils.DBConnection;
import com.paf.model.*;



public class HospitalService {
	Connection con = null;
	
	public HospitalService() {
		
		con = DBConnection.connecter();
	}
	
	 //A common method to connect to the DB
	
	
	
	
	
	public String readHospitals()
	 {
	 String output = "";
	 try
	 {
	
	 if (con == null)
	 {return "Error while connecting to the database for reading."; }
	 // Prepare the html table to be displayed
	 output = "<table border=\"1\"><tr><th>Hos.ID</th><th>Hospital Name</th><th>Address</th><th>Hospital Phone</th><th>Email</th><th>Hospital Charge</th><th>Update</th><th>Remove</th></tr>";
	 String query = "select * from hospital";
	 Statement stmt = con.createStatement();
	 ResultSet rs = stmt.executeQuery(query);
	 // iterate through the rows in the result set
	 while (rs.next())
	 {
		 String hId = rs.getString("hId");
		 String hName = rs.getString("hName");
		 String hAddress = rs.getString("hAddress");
		 String hPhone = rs.getString("hPhone");
		 String hEmail = rs.getString("hEmail");
		 String hCharge = Double.toString(rs.getDouble("hCharge"));
	 // Add into the html table
		 output += "<tr><td>" + hId + "</td>";
		 output += "<td>" + hName + "</td>";
		 output += "<td>" + hAddress + "</td>";
		 output += "<td>" + hPhone + "</td>";
		 output += "<td>" + hEmail + "</td>";
		 output += "<td>" + hCharge + "</td>";
	 // buttons
		 output += "<td><input name=\"btnUpdate\" type=\"button\"value=\"Update\" class=\"btn btn-secondary\"></td>"+ "<td><form method=\"post\" action=\"items.jsp\">"+ "<input name=\"btnRemove\" type=\"submit\" value=\"Remove\"class=\"btn btn-danger\">"
				 + "<input name=\"hId\" type=\"hidden\" value=\"" + hId
				 + "\">" + "</form></td></tr>";
	 }
	 con.close();
	 // Complete the html table
	 output += "</table>";
	 }
	 catch (Exception e)
	 {
	 output = "Error while reading the hospitals.";
	 System.err.println(e.getMessage());
	 }
	 return output;
	 }
	
	
	
	
	
	public String deleteHospital(Hospital hospital){
		String query = "delete from hospital where hId=?";
		String output;
		
		
		try {
			
	 if (con == null){
		 return "Error while connecting to the database for deleting."; }
	 // create a prepared statement
	 
	 PreparedStatement preparedStatement = con.prepareStatement(query);
	 // binding values
	 preparedStatement.setString(1,hospital.gethId() );
	 // execute the statement
	 preparedStatement.execute();
	 con.close();
	 output = "Deleted successfully";
	 }catch (Exception e){
	 output = "Error while deleting the Hospital.";
	 System.err.println(e.getMessage());
	 }
	 return output;
	 }
	 

}
