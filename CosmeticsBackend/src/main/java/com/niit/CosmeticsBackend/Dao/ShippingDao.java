package com.niit.CosmeticsBackend.Dao;

import java.util.List;

import com.niit.CosmeticsBackend.Model.CartItems;
import com.niit.CosmeticsBackend.Model.Shipping;

public interface ShippingDao {	
		public boolean saveorupdate(Shipping Shipping);
		public boolean delete(Shipping Shipping);
		public Shipping getShipping(String ship_Id);
		public List<Shipping> list();
		public List<Shipping> getaddbyuser(String User_Id);
	
	}



