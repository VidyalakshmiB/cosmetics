package com.niit.CosmeticsBackend.Dao;

import java.util.List;

import com.niit.CosmeticsBackend.Model.Billing;

public interface BillingDao {	
		public boolean saveorupdate(Billing Billing);
		public boolean delete(Billing Billing);
		public Billing getBilling(String bill_Id);
		public List<Billing> list();
		public Billing getUser(String user_Id);
	}

