package com.niit.CosmeticsBackend.Model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Authentication {

	@Id
	private String role_Id;
	private String roleName="ROLE_USER";
	private String userName;
	public String getRole_Id() {
		return role_Id;
	}
	
	public Authentication()
	{
		this.role_Id="AUT"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	
	
	public void setRole_Id(String role_Id) {
		this.role_Id = role_Id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
