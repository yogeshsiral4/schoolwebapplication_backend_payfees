package com.payfees.entity;

public class PaymentAuthRequest {
	private String email;
	private String upiID;
	private Long upiPin;
	
	public String getUpiID() {
		return upiID;
	}
	public void setUpiID(String upiID) {
		this.upiID = upiID;
	}
	public Long getUpiPin() {
		return upiPin;
	}
	public void setUpiPin(Long upiPin) {
		this.upiPin = upiPin;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}