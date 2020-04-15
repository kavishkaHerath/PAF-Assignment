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

	
}