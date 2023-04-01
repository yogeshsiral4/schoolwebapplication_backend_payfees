package com.payfees.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Fees_Details")
public class Fees {
	
	
	@Id
	private String email;
	
	@Column(name="feesStatus")
	private String feesStatus="UNPAID";


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFeesStatus() {
		return feesStatus;
	}

	public void setFeesStatus(String feesStatus) {
		this.feesStatus = feesStatus;
	}
}
