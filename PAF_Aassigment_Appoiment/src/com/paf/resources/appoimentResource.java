package com.paf.resources;



//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


import com.google.gson.*;
//For JSON
import com.paf.model.Appoiment;
import com.paf.service.appoimentService;



@Path("/Appoiment")
public class appoimentResource {
	Appoiment appObj = new Appoiment();

	@GET 
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.TEXT_HTML)
	public String readAppoiment()  {   
		appoimentService appoimentObj=new appoimentService();
		
		String output=appoimentObj.readAppoiment();
		return output;
		}

	
	
	
	
	
	
}