package com.niit.CosmeticsBackend.Dao;

import java.util.List;


import com.niit.CosmeticsBackend.Model.User;


	public interface UserDao {
		public boolean saveorupdate(User User);
		public boolean delete(User User);
		public User getUser(String userId);
		public List<User> list();
		public User isValid(String User_EmailId, String User_password);
		public User getEmail(String usermail);
		
}
