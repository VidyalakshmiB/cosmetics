package com.niit.CosmeticsBackend.Dao;

import java.util.List;

import com.niit.CosmeticsBackend.Model.Payment;

public interface PaymentDao {
		
			public boolean saveorupdate(Payment Payment);
			public boolean delete(Payment Payment);
			public Payment getPayment(String payment_Id);
			public List<Payment> list();
			
		
}