package com;

import model.Doctor;
//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;
//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("/Doctors")
public class DoctorService {
	Doctor DocObj = new Doctor();

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readDoctors() {
		return DocObj.readDoctors();
	}
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertDoctors(@FormParam("doctorId") String doctorId,
	 @FormParam("doctorName") String doctorName,
	 @FormParam("specialization") String specialization,
	 @FormParam("phoneNo") int phoneNo,
	 @FormParam("email") String email)
	{
	 String output = DocObj.insertDoctors(doctorId,doctorName, specialization, phoneNo, email);
	return output;
	}
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateDoctors(String doctorData)
	{
	//Convert the input string to a JSON object
	 JsonObject DoctorObj = new JsonParser().parse(doctorData).getAsJsonObject();
	//Read the values from the JSON object
	 String doctorId = DoctorObj.get("doctorId").getAsString();
	 String doctorName = DoctorObj.get("doctorName").getAsString();
	 String specialization = DoctorObj.get("specialization").getAsString();
	 Integer phoneNo = DoctorObj.get("phoneNo").getAsInt();
	 String email = DoctorObj.get("email").getAsString();
	 
	 String output = DocObj.updateDoctors(doctorId, doctorName, specialization, phoneNo, email);
	return output;
	}
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteDoctors(String doctorData)
	{
	//Convert the input string to an XML document
	 Document docObject = Jsoup.parse(doctorData, "", Parser.xmlParser());

	//Read the value from the element <itemID>
	 String doctorId = docObject.select("doctorId").text();
	 String output = DocObj.deleteDoctors(doctorId);
	return output;
	}
	
}