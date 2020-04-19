package com.HealthcareSystem.Appoiment.resources;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.security.RolesAllowed;
//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.HealthcareSystem.Appoiment.model.Appointment;
import com.HealthcareSystem.Appoiment.service.AppointmentService;
//For JSON
import com.google.gson.*;

import org.eclipse.persistence.annotations.Convert;
//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("/Appointment")
public class AppointmentReservation {
	Appointment appObj = new Appointment();
		
	@RolesAllowed({"patient","admin"})
	@GET
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_HTML)
	public String readAppoiment()  {   
	AppointmentService appoimentObj=new AppointmentService();
		
		String output=appoimentObj.readAppoiment();
		return output;
		}
	@RolesAllowed("patient")
	@POST
	@Path("/createAppo")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertAppoiment(String appoimentData){
		JsonObject appoimentObj = new JsonParser().parse(appoimentData).getAsJsonObject();
		
		String AppointmentId = appoimentObj.get("AppointmentId").getAsString();
		 String PatientId = appoimentObj.get("PatientId").getAsString();
		 String DoctorId = appoimentObj.get("DoctorId").getAsString();
		 String HosptlId = appoimentObj.get("HosptlId").getAsString();
		 String date = appoimentObj.get("date").getAsString();
		 String time = appoimentObj.get("time").getAsString();
		 Float charge = appoimentObj.get("charge").getAsFloat();
		
		 AppointmentService appoimentservice = new AppointmentService();
		 
		 appObj.setAppointmentId(AppointmentId);
		 appObj.setPatientId(PatientId);
		 appObj.setDoctorId(DoctorId);
		 appObj.setHosptlId(HosptlId);
		 appObj.setDate(date);
		 appObj.setTime(time);
		 appObj.setCharge(charge);
	
		 String output = appoimentservice.insertAppoiment(appObj);
			return output;

		}
	
	@RolesAllowed({"patient"})
	@PUT
	@Path("/updateAppo")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateAppoiment(String appoimentData){
	//Convert the input string to a JSON object

	 JsonObject appoimentObj = new JsonParser().parse(appoimentData).getAsJsonObject();
	//Read the values from the JSON object
	 
	 String AppointmentId = appoimentObj.get("AppointmentId").getAsString();
	 String PatientId = appoimentObj.get("PatientId").getAsString();
	 String DoctorId = appoimentObj.get("DoctorId").getAsString();
	 String HosptlId = appoimentObj.get("HosptlId").getAsString();
	 String date = appoimentObj.get("date").getAsString();
	 String time = appoimentObj.get("time").getAsString();
	 Float charge = appoimentObj.get("charge").getAsFloat();
	 
	 AppointmentService appoimentservice = new AppointmentService();
	 
	 appObj.setAppointmentId(AppointmentId);
	 appObj.setPatientId(PatientId);
	 appObj.setDoctorId(DoctorId);
	 appObj.setHosptlId(HosptlId);
	 appObj.setDate(date);
	 appObj.setTime(time);
	 appObj.setCharge(charge);
	 
	String output = appoimentservice.updateAppoiment(appObj);
	return output;
	}
	
	
	@RolesAllowed({"patient"})
	@DELETE
	@Path("/deleteAppo")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteAppoiment(String appoimentData){
	//Convert the input string to an XML document
	
	JsonObject appoimentObj = new JsonParser().parse(appoimentData).getAsJsonObject();
	
	//Document doc = Jsoup.parse(userData, "", Parser.xmlParser());
	
	
	 String AppointmentId = appoimentObj.get("AppointmentId").getAsString();

	AppointmentService appoimentservice = new AppointmentService();
	appObj.setAppointmentId(AppointmentId);
	
	 String output = appoimentservice.deleteAppoiment(appObj);
	return output;
	}
}

