package com.niit.CosmeticsBackend.Dao;

import java.util.List;

import com.niit.CosmeticsBackend.Model.CartItems;

public interface CartItemsDao {	
		public boolean saveorupdate(CartItems CartItems);
		public boolean delete(CartItems CartItems);
		public CartItems getCartItems(String cartitems_Id);
		public List<CartItems> list();
		public List<CartItems> getlist(String cart_Id);
		public CartItems getlistall(String cart_Id, String prod_Id);
//		public boolean delete(String cartitems_Id);
	}



