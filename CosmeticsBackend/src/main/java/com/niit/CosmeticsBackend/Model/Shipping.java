package com.niit.CosmeticsBackend.Model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component

public class Shipping {
	@Id
private String ship_Id;
private String Name;
private String Address;
private String city;
private String phone;
public String getShip_Id() {
	return ship_Id;
}

public Shipping()
{
	this.ship_Id="SHIP"+UUID.randomUUID().toString().substring(30).toUpperCase();
}


@ManyToOne 
@JoinColumn(name="User_Id")
private User user;

public void setShip_Id(String ship_Id) {
	this.ship_Id = ship_Id;
}

public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public String getAddress() {
	return Address;
}
public void setAddress(String address) {
	Address = address;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}

public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone = phone;
}


}