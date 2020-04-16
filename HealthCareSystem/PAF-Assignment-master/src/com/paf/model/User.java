package com.paf.model;

public class User {
	private String Pid;
	private String Fname;
	private String Lname;
	private int Age;
	private String Gender;
	private String email;
	private int Phone;
	
	
	public String getPid() {
		return Pid;
	}
	public void setPid(String pid) {
		Pid = pid;
	}
	public String getFname() {
		return Fname;
	}
	public void setFname(String fname) {
		Fname = fname;
	}
	public String getLname() {
		return Lname;
	}
	public void setLname(String lname) {
		Lname = lname;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhone() {
		return Phone;
	}
	public void setPhone(int phone) {
		Phone = phone;
	}
	

	
	
}
