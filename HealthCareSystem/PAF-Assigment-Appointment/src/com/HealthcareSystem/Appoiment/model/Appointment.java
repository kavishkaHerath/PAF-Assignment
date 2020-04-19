package com.HealthcareSystem.Appoiment.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Appointment {
	private String AppointmentId;
	private String PatientId;
	private String DoctorId;
	private String HosptlId;
	private String date;
	private String time;
	private float charge;
	

	public Appointment() {
		
	}
	public Appointment(String AppointmentId, String PatientId, String DoctorId,String HosptlId, String date, String time, float charge) {
		
		this.AppointmentId = AppointmentId;
		this.PatientId = PatientId;
		this.DoctorId = DoctorId;
		this.HosptlId = HosptlId;
		this.date = date;
		this.time = time;
		this.charge = charge;
		
	}
	public String getAppointmentId() {
		return AppointmentId;
	}
	public void setAppointmentId(String appointmentId) {
		AppointmentId = appointmentId;
	}
	public String getPatientId() {
		return PatientId;
	}
	public void setPatientId(String patientId) {
		PatientId = patientId;
	}
	public String getDoctorId() {
		return DoctorId;
	}
	public void setDoctorId(String doctorId) {
		DoctorId = doctorId;
	}
	public String getHosptlId() {
		return HosptlId;
	}
	public void setHosptlId(String hosptlId) {
		HosptlId = hosptlId;
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
