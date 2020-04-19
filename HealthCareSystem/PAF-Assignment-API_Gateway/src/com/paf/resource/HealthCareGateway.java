package com.paf.resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class HealthCareGateway {

	
		
		
		//Hospital Details
				@GET
				@Path("/hospital")
				@Produces(MediaType.APPLICATION_JSON)
				public String getAllHospitals() throws IOException
				{
					URL obj = new URL("http://localhost:8085/PAF-Assignment-Hospital/HealthCare/hospitals");
					HttpURLConnection con = (HttpURLConnection) obj.openConnection();
					con.setRequestMethod("GET");
					int responseCode = con.getResponseCode();
					System.out.println("GET Response Code :: " + responseCode);
								
					if (responseCode == HttpURLConnection.HTTP_OK) { // success
						BufferedReader in = new BufferedReader(new InputStreamReader(
								con.getInputStream()));
						String inputLine;
						StringBuffer response = new StringBuffer();

						while ((inputLine = in.readLine()) != null) {
							response.append(inputLine);
						}
						in.close();
						// print result
						System.out.println(response.toString());
						return response.toString();
					} else {
						System.out.println("GET request not worked");
						return "GET request not worked";
					}
				}
				
				//Appointment Details
				@GET
				@Path("/appointment")
				@Produces(MediaType.APPLICATION_JSON)
				public String getAllAppoinments() throws IOException
				{
					URL obj = new URL("http://localhost:8085/PafProjectAppointment/Service/Appoiment");
					HttpURLConnection con = (HttpURLConnection) obj.openConnection();
					con.setRequestMethod("GET");
					int responseCode = con.getResponseCode();
					System.out.println("GET Response Code :: " + responseCode);
								
					if (responseCode == HttpURLConnection.HTTP_OK) { // success
						BufferedReader in = new BufferedReader(new InputStreamReader(
								con.getInputStream()));
						String inputLine;
						StringBuffer response = new StringBuffer();

						while ((inputLine = in.readLine()) != null) {
							response.append(inputLine);
						}
						in.close();
						// print result
						System.out.println(response.toString());
						return response.toString();
					} else {
						System.out.println("GET request not worked");
						return "GET request not worked";
					}
				}
				
				//Patient Details
				@GET
				@Path("/patient")
				@Produces(MediaType.APPLICATION_JSON)
				public String getAllPatients() throws IOException
				{
					URL obj = new URL("http://localhost:8085/PafProjectUser/Service/Users");
					HttpURLConnection con = (HttpURLConnection) obj.openConnection();
					con.setRequestMethod("GET");
					int responseCode = con.getResponseCode();
					System.out.println("GET Response Code :: " + responseCode);
								
					if (responseCode == HttpURLConnection.HTTP_OK) { // success
						BufferedReader in = new BufferedReader(new InputStreamReader(
								con.getInputStream()));
						String inputLine;
						StringBuffer response = new StringBuffer();

						while ((inputLine = in.readLine()) != null) {
							response.append(inputLine);
						}
						in.close();
						// print result
						System.out.println(response.toString());
						return response.toString();
					} else {
						System.out.println("GET request not worked");
						return "GET request not worked";
					}
				}
				
				//Doctor details
				@GET
				@Path("/doctor")
				@Produces(MediaType.APPLICATION_JSON)
				public String getAllDoctors() throws IOException
				{
					URL obj = new URL("http://localhost:8085/PafProjectDoctor/Service/Doctors");
					HttpURLConnection con = (HttpURLConnection) obj.openConnection();
					con.setRequestMethod("GET");
					int responseCode = con.getResponseCode();
					System.out.println("GET Response Code :: " + responseCode);
								
					if (responseCode == HttpURLConnection.HTTP_OK) { // success
						BufferedReader in = new BufferedReader(new InputStreamReader(
								con.getInputStream()));
						String inputLine;
						StringBuffer response = new StringBuffer();

						while ((inputLine = in.readLine()) != null) {
							response.append(inputLine);
						}
						in.close();
						// print result
						System.out.println(response.toString());
						return response.toString();
					} else {
						System.out.println("GET request not worked");
						return "GET request not worked";
					}
				}
				
				
				
				//Payment Details
				@GET
				@Path("/payment")
				@Produces(MediaType.APPLICATION_JSON)
				public String getAllPayments() throws IOException
				{
					URL obj = new URL("http://localhost:8085/Paf-Assignment-Payment/Service/Payment");
					HttpURLConnection con = (HttpURLConnection) obj.openConnection();
					con.setRequestMethod("GET");
					int responseCode = con.getResponseCode();
					System.out.println("GET Response Code :: " + responseCode);
								
					if (responseCode == HttpURLConnection.HTTP_OK) { // success
						BufferedReader in = new BufferedReader(new InputStreamReader(
								con.getInputStream()));
						String inputLine;
						StringBuffer response = new StringBuffer();

						while ((inputLine = in.readLine()) != null) {
							response.append(inputLine);
						}
						in.close();
						// print result
						System.out.println(response.toString());
						return response.toString();
					} else {
						System.out.println("GET request not worked");
						return "GET request not worked";
					}
				}

	}


