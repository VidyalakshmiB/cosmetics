package com.niit.CosmeticsBackend.Dao;

import java.util.List;

import com.niit.CosmeticsBackend.Model.Authentication;


public interface AuthenticationDao {	
	public boolean saveorupdate(Authentication Authentication);
	public boolean delete(Authentication Authentication);
	public Authentication getAuthentication(String role_Id);
	public List<Authentication> list();
}



