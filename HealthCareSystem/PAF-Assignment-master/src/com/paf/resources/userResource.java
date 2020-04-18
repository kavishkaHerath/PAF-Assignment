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

	//read User
	@GET 
	@Path("/")
	@Produces(MediaType.TEXT_HTML)  
	public String readUsers()  {   
		userService userobj=new userService();
		
		String output=userobj.readUsers();
		return output;
		}

	//insert User
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertUsers(String userData){
	
		JsonObject userObject = new JsonParser().parse(userData).getAsJsonObject();
		
		 String Pid = userObject.get("Pid").getAsString();
		 String Fname = userObject.get("Fname").getAsString();
		 String Lname = userObject.get("Lname").getAsString();
		 Integer Age = userObject.get("Age").getAsInt();
		 String Gender = userObject.get("Gender").getAsString();
		 String email = userObject.get("email").getAsString();
		 Integer Phone = userObject.get("Phone").getAsInt();
	
		 userService userObject2 = new userService();
		 
		 userObj.setPid(Pid);
		 userObj.setFname(Fname);
		 userObj.setLname(Lname);
		 userObj.setAge(Age);
		 userObj.setGender(Gender);
		 userObj.setEmail(email);
		 userObj.setPhone(Phone);
		
		 String output = userObject2.insertUser(userObj);
			return output;
		
		
	}
	
	//Update User
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateUsers(String userData)
	{
	//Convert the input string to a JSON object
	 JsonObject userObject = new JsonParser().parse(userData).getAsJsonObject();
	//Read the values from the JSON object
	 String Pid = userObject.get("Pid").getAsString();
	 String Fname = userObject.get("Fname").getAsString();
	 String Lname = userObject.get("Lname").getAsString();
	 Integer Age = userObject.get("Age").getAsInt();
	 String Gender = userObject.get("Gender").getAsString();
	 String email = userObject.get("email").getAsString();
	 Integer Phone = userObject.get("Phone").getAsInt();
	 
	 userService userObject1 = new userService();
	 
	 userObj.setPid(Pid);
	 userObj.setFname(Fname);
	 userObj.setLname(Lname);
	 userObj.setAge(Age);
	 userObj.setGender(Gender);
	 userObj.setEmail(email);
	 userObj.setPhone(Phone);
	 
	String output = userObject1.updateUser(userObj);
	return output;
	}
	
	
	//Delete User
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteUsers(String userData){
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