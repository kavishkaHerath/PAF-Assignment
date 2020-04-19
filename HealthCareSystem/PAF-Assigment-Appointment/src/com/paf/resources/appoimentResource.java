package com.paf.resources;



//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;



import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
//For JSON
import com.paf.model.Appointment;
import com.paf.service.appoimentService;


//For XML



@Path("/Appoiment")
public class appoimentResource {
	Appointment appObj = new Appointment();

	@GET 
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_HTML)
	public String readAppoiment()  {   
		appoimentService appoimentObj=new appoimentService();
		
		String output=appoimentObj.readAppoiment();
		return output;
		}

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertAppoiment(String appoimentData){
	
		JsonObject appoimentObj = new JsonParser().parse(appoimentData).getAsJsonObject();
				
		 String AId = appoimentObj.get("AId").getAsString();
		 String Pid = appoimentObj.get("Pid").getAsString();
		 String doctorId = appoimentObj.get("doctorId").getAsString();
		 String hosptlId = appoimentObj.get("hosptlId").getAsString();
		 String date = appoimentObj.get("date").getAsString();
		 String time = appoimentObj.get("time").getAsString();
		 Float charge = appoimentObj.get("charge").getAsFloat();
		 
		 appoimentService appoimentservice = new appoimentService();
		 
		 appObj.setAId(AId);
		 appObj.setPid(Pid);
		 appObj.setDoctorId(doctorId);
		 appObj.setHosptlId(hosptlId);
		 appObj.setDate(date);
		 appObj.setTime(time);
		 appObj.setCharge(charge);
		
		 String output = appoimentservice.insertAppoiment(appObj);
			return output;
		
		
	}
	
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateAppoiment(String appoimentData){
	//Convert the input string to a JSON object

	 JsonObject appoimentObj = new JsonParser().parse(appoimentData).getAsJsonObject();
	//Read the values from the JSON object
	 
	 String AId = appoimentObj.get("AId").getAsString();
	 String Pid = appoimentObj.get("Pid").getAsString();
	 String doctorId = appoimentObj.get("doctorId").getAsString();
	 String hosptlId = appoimentObj.get("hosptlId").getAsString();
	 String date = appoimentObj.get("date").getAsString();
	 String time = appoimentObj.get("time").getAsString();
	 Float charge = appoimentObj.get("charge").getAsFloat();
	 
	 appoimentService appoimentservice = new appoimentService();
	 
	 appObj.setAId(AId);
	 appObj.setPid(Pid);
	 appObj.setDoctorId(doctorId);
	 appObj.setHosptlId(hosptlId);
	 appObj.setDate(date);
	 appObj.setTime(time);
	 appObj.setCharge(charge);
	 
	String output = appoimentservice.updateAppoiment(appObj);
	return output;
	}
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteAppoiment(String appoimentData){
	//Convert the input string to an XML document
	
	JsonObject appoimentObj = new JsonParser().parse(appoimentData).getAsJsonObject();
	
	//Document doc = Jsoup.parse(userData, "", Parser.xmlParser());
	
	
	String AId = appoimentObj.get("AId").getAsString();

	appoimentService appoimentservice = new appoimentService();
	appObj.setAId(AId);
	
	 String output = appoimentservice.deleteAppoiment(appObj);
	return output;
	}
	
	
	
	
	
	
}