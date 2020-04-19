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


		String output;
		try {
			Connection con = DBconnection.connecter();
			
			if (con == null) {
				return "Error while connecting to the database for inserting.";
			}

			
			
			String query = " insert into doctor(`doctorId`,`doctorName`,`specialization`,`phoneNo`,`email`,`hospitalId`)"
					+ " values (?, ?, ?, ?, ?,?)";

			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setString(1, doctor.getdoctorId());
			preparedStmt.setString(2, doctor.getdoctorName());
			preparedStmt.setString(3, doctor.getSpecialization());
			preparedStmt.setInt(4, doctor.getPhone());
			preparedStmt.setString(5, doctor.getEmail());
			preparedStmt.setString(6, doctor.getHospitailId());
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
				+ "<th>Phone No</th>" + "<th>Email</th>" + "<th>Hospital Id</th></tr>";
		
		try {
			Connection con = DBconnection.connecter();
			
			if (con == null) {
				return "Error while connecting to the database for updating.";
			}
			String query = "select * from doctor";
			
			Statement stmt = con.createStatement();
			ResultSet results = stmt.executeQuery(query);
			

			// iterate through the rows in the result set
			while (results.next()) {
				String doctorId = results.getString("doctorId");
				String doctorName = results.getString("doctorName");
				String specialization = results.getString("specialization");
				int phoneNo = results.getInt("phoneNo");
				String email = results.getString("email");
				String hospitalId = results.getString("hospitalId");

				// Add into the html table
				output += "<tr><td>" + doctorId + "</td>";
				output += "<td>" + doctorName + "</td>";
				output += "<td>" + specialization + "</td>";
				output += "<td>" + phoneNo + "</td>";
				output += "<td>" + email + "</td>";
				output += "<td>" + hospitalId + "</td>";
				   
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
			Connection con = DBconnection.connecter();
			
			if (con == null) {
				return "Error while connecting to the database for updating.";
			}
			
			String query = "UPDATE doctor SET doctorName=?,specialization=?,phoneNo=?,email=?,hospitalId=? WHERE doctorId=?";
			
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setString(1, doctor.getdoctorName());
			preparedStmt.setString(2, doctor.getSpecialization());
			preparedStmt.setInt(3, doctor.getPhone());
			preparedStmt.setString(4, doctor.getEmail());
			preparedStmt.setString(5, doctor.getHospitailId());
			preparedStmt.setString(6, doctor.getdoctorId());
			// execute the statement
			preparedStmt.executeUpdate();
			
			
			
			if(preparedStmt.executeUpdate() == 1) {
				output = "Updated successfully";
			}else{
				output = "Error while updating the Doctors.";			}
			
				con.close();
			
		} catch (SQLException e) {
			output = "Error while updating the Doctors.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String deleteDoctors(Doctor doctor) {
		
		
		String output="";
		

		try {
			Connection con = DBconnection.connecter();
			
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
