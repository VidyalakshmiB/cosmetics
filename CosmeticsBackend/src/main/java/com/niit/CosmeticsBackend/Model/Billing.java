	package com.niit.CosmeticsBackend.Model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component

public class Billing {
	@Id
private String bill_Id;
private String bill_Name;
private String address;
private String city;
public String getBill_Id() {
	return bill_Id;
}



public Billing()
{
	this.bill_Id="BILL"+UUID.randomUUID().toString().substring(30).toUpperCase();
}




@OneToOne
@JoinColumn(name="User_Id")
private User user;

public void setBill_Id(String bill_Id) {
	this.bill_Id = bill_Id;
}
public String getBill_Name() {
	return bill_Name;
}
public void setBill_Name(String bill_Name) {
	this.bill_Name = bill_Name;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}

}
