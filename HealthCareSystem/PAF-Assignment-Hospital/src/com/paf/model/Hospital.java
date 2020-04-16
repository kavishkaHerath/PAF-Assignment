package com.paf.model;

public class Hospital {
	
	private String hId;
	private String hName;
	private String hAddress;
	private String hPhone;
	private String hEmail;
	private float hCharge;
	
	public Hospital() {
		
	}
	
	public Hospital(String hId, String hName, String hAddress, String hPhone, String hEmail, Float hCharge) {
		super();
		this.hId = hId;
		this.hName = hName;
		this.hAddress = hAddress;
		this.hPhone = hPhone;
		this.hEmail = hEmail;
		this.hCharge = hCharge;
	}

	public String gethId() {
		return hId;
	}

	public void sethId(String hId) {
		this.hId = hId;
	}

	public String gethName() {
		return hName;
	}

	public void sethName(String hName) {
		this.hName = hName;
	}

	public String gethAddress() {
		return hAddress;
	}

	public void sethAddress(String hAddress) {
		this.hAddress = hAddress;
	}

	public String gethPhone() {
		return hPhone;
	}

	public void sethPhone(String hPhone) {
		this.hPhone = hPhone;
	}

	public String gethEmail() {
		return hEmail;
	}

	public void sethEmail(String hEmail) {
		this.hEmail = hEmail;
	}

	public Float gethCharge() {
		return hCharge;
	}

	public void sethCharge(float hCharge) {
		this.hCharge = hCharge;
	}

}
