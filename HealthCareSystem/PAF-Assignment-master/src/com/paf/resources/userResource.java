package com.paf.resources;

//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;



import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
//For JSON
import com.paf.model.User;
import com.paf.service.userService;


//For XML

@Path("/Users")
public class userResource {
	User userObj = new User();

	@GET 
	@Path("/")
	@Produces(MediaType.TEXT_HTML)  
	public String readUsers()  {   
		userService userobj=new userService();
		
		String output=userobj.readUsers();
		return output;
		}

	
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteItem(String userData){
	//Convert the input string to an XML document
	
	JsonObject userObject = new JsonParser().parse(userData).getAsJsonObject();
	
	//Document doc = Jsoup.parse(userData, "", Parser.xmlParser());
	
	
	String Pid = userObject.get("Pid").getAsString();

	userService userObject2 = new userService();
	 userObj.setPid(Pid);
	
	 String output = userObject2.deleteUser(userObj);
	return output;
	}
	
	
	
	
	
	
}