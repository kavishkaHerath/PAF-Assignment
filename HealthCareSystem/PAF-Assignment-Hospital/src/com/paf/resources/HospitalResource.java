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
	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readHospitals()
	{
		HospitalService hosObj = new HospitalService();
		
	return hosObj.readHospitals();
	}

	
	
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteHos(String hospitalData){
	//Convert the input string to an XML document
	
	JsonObject hosObject = new JsonParser().parse(hospitalData).getAsJsonObject();
	
	//Document doc = Jsoup.parse(userData, "", Parser.xmlParser());
	
	
	String hId = hosObject.get("hId").getAsString();

	HospitalService hosObject2 = new HospitalService();
	 hosObj.sethId(hId);
	
	 String output = hosObject2.deleteHospital(hosObj);
	return output;
	}

}
