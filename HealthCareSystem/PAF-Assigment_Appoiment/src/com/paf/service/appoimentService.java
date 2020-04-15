package com.paf.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import com.paf.utils.DBconnection;





public class appoimentService {
	Connection con = null;
	
	public appoimentService() {
		 
		con = DBconnection.connecter();
		} 
		
		
		public String readAppoiment(){	
			String output="";
//html table  display
			output = "<table border=\"1\"><tr><th>Appoiment ID</th><th>Persion Id</th><th>Doctor Id</th><th>Hosptal Id</th>"
					+ "<th>Appoiment Date</th><th>Appoiment Time</th><th>Charges</th><th>Update</th><th>Remove</th></tr>";
			
			String query = "select * from appoiment";
			
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
					catch (Exception e)
					 {
					 output = "Error while reading the Appoiment.";
					 System.err.println(e.getMessage());
					 }
					return output; 
				}

	
				
		
		}
		
	
	


	
	
