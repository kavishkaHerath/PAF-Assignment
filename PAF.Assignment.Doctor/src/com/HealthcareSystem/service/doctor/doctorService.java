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
	

	public String insertDoctors(Doctor doctor) {

		
		
		String query = " insert into doctor(`doctorId`,`doctorName`,`specialization`,`phoneNo`,`email`)"
				+ " values (?, ?, ?, ?, ?)";

		String output;
		try {

			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setString(1, doctor.getdoctorId());
			preparedStmt.setString(2, doctor.getdoctorName());
			preparedStmt.setString(3, doctor.getSpecialization());
			preparedStmt.setInt(4, doctor.getPhone());
			preparedStmt.setString(5, doctor.getEmail());
			preparedStmt.execute();

			output = "Inserted successfully";

		} catch (SQLException e) {
			output = "Error while inserting the doctor.";
			System.err.println(e.getMessage());
		}

		return output;
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

	public String updateDoctors(Doctor doctor) {
		
		
		String output = "";
		try {
			if (con == null) {
				return "Error while connecting to the database for updating.";
			}
			String query = "UPDATE doctor SET doctorName=?,specialization=?,phoneNo=?,email=?WHERE doctorId=?";
			
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setString(1, doctor.getdoctorName());
			preparedStmt.setString(2, doctor.getSpecialization());
			preparedStmt.setInt(3, doctor.getPhone());
			preparedStmt.setString(4, doctor.getEmail());
			preparedStmt.setString(5, doctor.getdoctorId());
			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Updated successfully";
		} catch (Exception e) {
			output = "Error while updating the Doctors.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String deleteDoctors(Doctor doctor) {
		
		
		String output="";

		try {
			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}
			
			String query = "delete from doctor where doctorId=?";

			
			// create a prepared statement

			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setString(1, doctor.getdoctorId());
			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Deleted successfully";
			
			
		} catch (Exception e) {
			output = "Error while deleting the Doctors.";
			System.err.println(e.getMessage());
		}
		return output;
	}

}
