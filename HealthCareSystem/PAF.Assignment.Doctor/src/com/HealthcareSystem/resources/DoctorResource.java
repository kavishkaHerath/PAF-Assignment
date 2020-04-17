package com.HealthcareSystem.resources;

import com.HealthcareSystem.service.doctor.doctorService;
import com.HealthcareSystem.model.Doctor;
//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;

import com.HealthcareSystem.service.doctor.doctorService;

@Path("/Doctors")
public class DoctorResource {
	Doctor DocObj = new Doctor();

	@GET
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_HTML)
	public String readDoctors() {
		doctorService DocObj = new doctorService();

		String output = DocObj.readDoctors();
		return output;
	}
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertDoctors(String doctorData) {
		// Convert the input string to a JSON object
		JsonObject DoctorObj = new JsonParser().parse(doctorData).getAsJsonObject();
		// Read the values from the JSON object

		String doctorId = DoctorObj.get("doctorId").getAsString();
		String doctorName = DoctorObj.get("doctorName").getAsString();
		String specialization = DoctorObj.get("specialization").getAsString();
		Integer phoneNo = DoctorObj.get("phoneNo").getAsInt();
		String email = DoctorObj.get("email").getAsString();

		doctorService doctorobject1 = new doctorService();
		DocObj.setdoctorId(doctorId);
		DocObj.setdoctorName(doctorName);
		DocObj.setSpecialization(specialization);
		DocObj.setPhone(phoneNo);
		DocObj.setEmail(email);

		String output = doctorobject1.insertDoctors(DocObj);
		return output;
	}

	
}