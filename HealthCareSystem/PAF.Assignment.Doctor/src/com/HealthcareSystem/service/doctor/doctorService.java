package com.HealthcareSystem.service.doctor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.HeallthcareSystem.util.DBconnection;
import com.HealthcareSystem.model.Doctor;
import com.HealthcareSystem.resources.DoctorResource;

public class doctorService {
	Connection con = null;

	public doctorService() {

		con = DBconnection.connecter();
	}
	

	

	public String readDoctors() {
		String output = "";
		// Prepare the html table to be displayed
		output = "<table border=\"1\"><tr><th>Doctor ID</th>" + "<th>Doctor Name</th><th>Specialization</th>"
				+ "<th>Phone No</th>" + "<th>Email</th>" + "<th>Update</th><th>Remove</th></tr>";
		String query = "select * from doctor";
		try {
			Statement stmt = con.createStatement();
			ResultSet results = stmt.executeQuery(query);
			

			// iterate through the rows in the result set
			while (results.next()) {
				String doctorId = results.getString("doctorId");
				String doctorName = results.getString("doctorName");
				String specialization = results.getString("specialization");
				int phoneNo = results.getInt("phoneNo");
				String email = results.getString("email");

				// Add into the html table
				output += "<tr><td>" + doctorId + "</td>";
				output += "<td>" + doctorName + "</td>";
				output += "<td>" + specialization + "</td>";
				output += "<td>" + phoneNo + "</td>";
				output += "<td>" + email + "</td>";

				 output += "<td><input name=\"btnUpdate\" "+ " type=\"button\" value=\"Update\"></td>"
						 + "<td><form method=\"post\" action=\"index.jsp\">"+ "<input name=\"btnRemove\" "
						 + " type=\"submit\" value=\"Remove\">"+ "<input name=\"itemID\" type=\"hidden\" "
						 + " value=\"" + doctorId + "\">" + "</form></td></tr>";
				   
			}

			// Complete the html table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the Doctor.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	

}
