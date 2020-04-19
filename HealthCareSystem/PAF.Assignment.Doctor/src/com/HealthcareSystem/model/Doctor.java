package com.HealthcareSystem.model;

public class Doctor {
	private String doctorId;
	private String doctorName;
	private String specialization;
	private int phone;
	private String email;
	private String hospitailId;
	private String availableDay;
	private String availableTime;
	private float doctorCharge;
	

	

	public String getdoctorId() {
		return doctorId;
	}

	public void setdoctorId(String doctorId) {
		this.doctorId = doctorId;
	}

	public String getdoctorName() {
		return doctorName;
	}

	public void setdoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getHospitailId() {
		return hospitailId;
	}

	public void setHospitailId(String hospitailId) {
		this.hospitailId = hospitailId;
	}


	public String getAvailableDay() {
		return availableDay;
	}

	public void setAvailableDay(String availableDay) {
		this.availableDay = availableDay;
	}

	public String getAvailableTime() {
		return availableTime;
	}

	public void setAvailableTime(String availableTime) {
		this.availableTime = availableTime;
	}

	public float getDoctorCharge() {
		return doctorCharge;
	}

	public void setDoctorCharge(float doctorCharge) {
		this.doctorCharge = doctorCharge;
	}
	



}
