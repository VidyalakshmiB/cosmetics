package com.niit.CosmeticsBackend.Model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component

public class Payment {
	@Id
	private String payment_Id;
	private String payment_Method;
	private String payment_Status;
	
	
	public Payment(){
		this.payment_Id="PAY"+UUID.randomUUID().toString().substring(30).toUpperCase();
	
	
	
	}


	public String getPayment_Id() {
		return payment_Id;
	}


	public void setPayment_Id(String payment_Id) {
		this.payment_Id = payment_Id;
	}


	public String getPayment_Method() {
		return payment_Method;
	}


	public void setPayment_Method(String payment_Method) {
		this.payment_Method = payment_Method;
	}


	public String getPayment_Status() {
		return payment_Status;
	}


	public void setPayment_Status(String payment_Status) {
		this.payment_Status = payment_Status;
	}
	}
	
	
	

