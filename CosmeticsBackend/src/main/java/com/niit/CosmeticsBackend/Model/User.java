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
public class User {
	@Id
	private String User_Id;
	private String User_Name;
    private String User_Address;
    private String User_Phno;
    private String User_EmailId;
	private String User_password;
	private String User_city;
	private String role="ROLE_USER";
	public String getUser_Id() {
		return User_Id;
	}
	
	public User()
	{
		this.User_Id="USER"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	
	


	@OneToOne
	@JoinColumn(name="bill_Id")
	private Billing billing;
	
	
	@OneToOne
	@JoinColumn(name="cart_Id")
	private Cart cart;
	
	public void setUser_Id(String user_Id) {
		User_Id = user_Id;
	}
	public String getUser_Name() {
		return User_Name;
	}
	public void setUser_Name(String user_Name) {
		User_Name = user_Name;
	}
	public String getUser_Address() {
		return User_Address;
	}
	public void setUser_Address(String user_Address) {
		User_Address = user_Address;
	}
	
	
	public String getUser_EmailId() {
		return User_EmailId;
	}
	public void setUser_EmailId(String user_EmailId) {
		User_EmailId = user_EmailId;
	}
	public String getUser_password() {
		return User_password;
	}
	public void setUser_password(String user_password) {
		User_password = user_password;
	}
	public String getUser_city() {
		return User_city;
	}
	public void setUser_city(String user_city) {
		User_city = user_city;
	}
	
	
	public String getUser_Phno() {
		return User_Phno;
	}

	public void setUser_Phno(String user_Phno) {
		User_Phno = user_Phno;
	}

	public Billing getBilling() {
		return billing;
	}
	public void setBilling(Billing billing) {
		this.billing = billing;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	

}