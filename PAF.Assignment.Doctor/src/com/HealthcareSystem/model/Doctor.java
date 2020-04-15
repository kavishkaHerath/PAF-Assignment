package com.HealthcareSystem.model;

public class Doctor {
	private String doctorId;
	private String doctorName;
	private String specialization;
	private int phone;
	private String email;

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

}
