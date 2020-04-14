package com;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import model.User;
@Path("/Users")
public class UserService {
	User userObj = new User();
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readItems()
	{
		return userObj.readItems(); 
	}

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertUser( 
	@FormParam("Pid") String Pid,
	 @FormParam("Fname") String Fname,
	 @FormParam("Lname") String Lname,
	 @FormParam("Age") String Age,
	 @FormParam("Gender") String Gender,
	 @FormParam("email") String email,
	 @FormParam("Phone") String Phone
	 )
	{
	 String output = userObj.insertUser(Pid, Fname, Lname,Age,Gender, email, Phone);
	return output;
	}	
	
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateUser(String userData)
	{
	//Convert the input string to a JSON object
	 JsonObject userObject = new JsonParser().parse(userData).getAsJsonObject();
	//Read the values from the JSON object
	 String Pid = userObject.get("Pid").getAsString();
	 String Fname = userObject.get("Fname").getAsString();
	 String Lname = userObject.get("Lname").getAsString();
	 String Age = userObject.get("Age").getAsString();
	 String Gender = userObject.get("Gender").getAsString();
	 String email = userObject.get("email").getAsString();
	 String Phone = userObject.get("Phone").getAsString();
	 String output = userObj.updateUser(Pid, Fname, Lname,Age, Gender, email, Phone);
	return output;
	}
	
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteItem(String userData)
	{
	//Convert the input string to an XML document
	 Document doc = Jsoup.parse(userData, "", Parser.xmlParser());

	//Read the value from the element <Pid>
	 String Pid = doc.select("Pid").text();
	 String output = userObj.deleteUser(Pid);
	return output;
	}


}
