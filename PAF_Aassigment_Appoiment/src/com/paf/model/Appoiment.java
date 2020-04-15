package com.paf.model;



public class Appoiment {
	private String AId;
	private String Pid;
	private String doctorId;
	private String hosptlId;
	private String date;
	private String time;
	private float charge;
	
	public String getAId() {
		return AId;
	}
	public void setAId(String aId) {
		AId = aId;
	}
	public String getPid() {
		return Pid;
	}
	public void setPid(String pid) {
		Pid = pid;
	}
	public String getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}
	public String getHosptlId() {
		return hosptlId;
	}
	public void setHosptlId(String hosptlId) {
		this.hosptlId = hosptlId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public float getCharge() {
		return charge;
	}
	public void setCharge(float charge) {
		this.charge = charge;
	}
	
	
	
}
