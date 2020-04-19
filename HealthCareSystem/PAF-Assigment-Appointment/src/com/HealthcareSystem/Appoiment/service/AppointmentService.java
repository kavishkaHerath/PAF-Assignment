package com.HealthcareSystem.Appoiment.service;

import java.sql.*;

import com.HeallthcareSystem.Appoiment.util.DBConnection;
import com.HealthcareSystem.Appoiment.model.Appointment;

public class AppointmentService {
	
Connection con = null;
	
	public AppointmentService() {
		 
		con = DBConnection.connecter();
		} 

	//method to insert data
	public String insertAppoiment(Appointment appoiment) {
		  String query = " insert into Appointment(`AppointmentId`,`PatientId`,`DoctorId`,`HosptlId`,`date`,`time`,`charge`)"
				  + " values (?, ?, ?, ?, ?, ?, ?)";
		  
	 String output;
		try {	
				PreparedStatement preparedStatement = con.prepareStatement(query); 
				
				preparedStatement.setString(1, appoiment.getAppointmentId());
				preparedStatement.setString(2, appoiment.getPatientId());
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

	
	//method to read database
	public String readAppoiment(){	
		String output="";
//html table  display
		output = "<table border=\"1\"><tr><th>Appoiment ID</th><th>Persion Id</th><th>Doctor Id</th><th>Hosptal Id</th>"
				+ "<th>Appoiment Date</th><th>Appoiment Time</th><th>Charges</th></tr>";
		
		String query = "select * from Appointment";
		
		try {
				Statement statement = con.createStatement();
				ResultSet result = statement.executeQuery(query);
//Statement stmt = db.connection.createStatement();
					
//iterate through the rows in the result set
		while (result.next()) {
			
				String AppointmentId = result.getString("AppointmentId");
				String PatientId = result.getString("PatientId");
				String DoctorId = result.getString("DoctorId");
				String HosptlId = result.getString("HosptlId");
				String date = result.getString("date");
				String time = result.getString("time");
				float charge = result.getFloat("charge");
							
//Add into the html table
					output += "<tr><td>" + AppointmentId + "</td>";
					output += "<td>" + PatientId + "</td>"; 
					output += "<td>" + DoctorId + "</td>"; 
					output += "<td>" + HosptlId + "</td>";
					output += "<td>" + date + "</td>";
					output += "<td>" + time + "</td>";
					output += "<td>" + charge + "</td></tr>";
					 
				
				 
		} 
//Complete the html table
				 output += "</table>";
				 }
				catch (SQLException e)
				 {
				 output = "Error while reading the Appointment.";
				 System.err.println(e.getMessage());
				 }
				return output; 
			}
	//method to update details
	public String updateAppoiment(Appointment appoiment){
		
		String query = "UPDATE Appointment SET PatientId=?,DoctorId=?,HosptlId=?,date=?,time=?,charge=?WHERE AppointmentId=?";
		
		String output;
		try {
			PreparedStatement preparedStatement = con.prepareStatement(query);
			if(con == null) {
				return "Error while connecting to the database for updating";
			}
			preparedStatement.setString(1, appoiment.getPatientId());
			preparedStatement.setString(2, appoiment.getDoctorId());
			preparedStatement.setString(3,  appoiment.getHosptlId());
			preparedStatement.setString(4, appoiment.getDate());
			preparedStatement.setString(5, appoiment.getTime()); 
			preparedStatement.setFloat(6, appoiment.getCharge());
			preparedStatement.setString(7, appoiment.getAppointmentId());
			
			  if(preparedStatement.executeUpdate() == 1) {
	                output = "Updated successfully";
	            }else{
	                output = "Error while updating the Doctors.";            }
	           
	                con.close();
		}
		 catch (SQLException e)
		 {
		 output = "Error while updating the Appointment.";
		 System.err.println(e.getMessage());
		 }
		 return output;
		
	}
	//method to delete details
	public String deleteAppoiment(Appointment appoiment){
		String query = "delete from Appointment where AppointmentId=?";
		String output;
		
		
		try {
			
	 if (con == null){
		 return "Error while connecting to the database for deleting."; }
	 // create a prepared statement
	 
	 PreparedStatement preparedStatement = con.prepareStatement(query);
	 // binding values
	 preparedStatement.setString(1, appoiment.getAppointmentId());
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
	
	
//	//search appointments by ID	
//	
//	// view list of appointments
//	public List<Appointment> viewAppointments() {		
//		return	viewAppointments(null);
//	}
//	
//	// show appointments by ID
//	public Appointment ShowAppointmentById(String id) {
//	List<Appointment> list =viewAppointments(id);
//		if(!list.isEmpty()) {
//			return	list.get(0);
//		}
//		return null;
//	}
//			
//	//view method
//	public List<Appointment> viewAppointments(String id) {
//		List <Appointment> AppList = new ArrayList<>();
//		try 
//		{
//			Connection con = dbObj.connect();
//			if (con == null) {
//				System.out.println("Error While reading from database");
//				return AppList;
//			}
//
//			String query;
//			
//			if(id==null) {
//			query = "select * from appointment_doctor";
//			}
//			else {
//				query = "select * from appointment_doctor where patientId="+id;	
//			}
//			Statement stmt = con.createStatement();
//			ResultSet results = stmt.executeQuery(query);
//
//			while (results.next()) {
//				Appointment type = new Appointment(
//					results.getInt("appointmentid"),
//					results.getString("patientid"),
//					results.getString("dueDate"),
//					results.getInt("scheduleid"),
//					results.getBoolean("status")
//				);
//				AppList.add(type);
//			}
//			con.close();
//		}
//		catch (Exception e) {
//			System.out.println("Error While Reading");
//			System.err.println(e.getMessage());
//		}		
//		return AppList;
//	}
//	
//	public List<Appointment> View_Appointments_By_given_ID(String pid) {
//		List<Appointment> ScheduleBeanlist = new ArrayList<>();
//		for (Appointment sch : viewAppointments()) {
//			if (pid.equals(sch.getPatientid())) {				
//				ScheduleBeanlist.add(sch);
//			}
//		}
//		return ScheduleBeanlist;
//	}
}
