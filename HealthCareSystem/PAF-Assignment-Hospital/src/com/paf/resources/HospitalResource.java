package com.paf.resources;

import com.paf.model.*;
import com.paf.service.*;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;
//import org.jsoup.*;
//import org.jsoup.parser.*;
//import org.jsoup.nodes.Document; 

@Path("/hospitals")
public class HospitalResource {

	Hospital hosObj = new Hospital();

	// Read API
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readHospitals() {
		HospitalService hosObj = new HospitalService();

		return hosObj.readHospitals();
	}

	// Insert API
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertHospital(String hosData) {
		JsonObject hosObject = new JsonParser().parse(hosData).getAsJsonObject();

		String hId = hosObject.get("hId").getAsString();
		String hName = hosObject.get("hName").getAsString();
		String hAddress = hosObject.get("hAddress").getAsString();
		String hPhone = hosObject.get("hPhone").getAsString();
		String hEmail = hosObject.get("hEmail").getAsString();
		Float hCharge = hosObject.get("hCharge").getAsFloat();

		HospitalService hosObject2 = new HospitalService();

		hosObj.sethId(hId);
		hosObj.sethName(hName);
		hosObj.sethAddress(hAddress);
		hosObj.sethPhone(hPhone);
		hosObj.sethEmail(hEmail);
		hosObj.sethCharge(hCharge);

		String output = hosObject2.insertHospital(hosObj);
		return output;
	}

	// Update API
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateHospital(String hospitalData) {
		// Convert the input string to a JSON object
		JsonObject hosObject = new JsonParser().parse(hospitalData).getAsJsonObject();
		// Read the values from the JSON object
		String hId = hosObject.get("hId").getAsString();
		String hName = hosObject.get("hName").getAsString();
		String hAddress = hosObject.get("hAddress").getAsString();
		String hPhone = hosObject.get("hPhone").getAsString();
		String hEmail = hosObject.get("hEmail").getAsString();
		Float hCharge = hosObject.get("hCharge").getAsFloat();

		HospitalService hosObject1 = new HospitalService();

		hosObj.sethId(hId);
		hosObj.sethName(hName);
		hosObj.sethAddress(hAddress);
		hosObj.sethPhone(hPhone);
		hosObj.sethEmail(hEmail);
		hosObj.sethCharge(hCharge);

		String output = hosObject1.updateHospital(hosObj);
		return output;
	}

	// Delete API
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteHos(String hospitalData) {

		JsonObject hosObject = new JsonParser().parse(hospitalData).getAsJsonObject();

		String hId = hosObject.get("hId").getAsString();

		HospitalService hosObject2 = new HospitalService();
		hosObj.sethId(hId);

		String output = hosObject2.deleteHospital(hosObj);
		return output;
	}
	


}