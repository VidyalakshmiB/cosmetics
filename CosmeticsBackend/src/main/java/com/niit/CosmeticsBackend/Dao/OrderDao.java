package com.niit.CosmeticsBackend.Dao;

import java.util.List;

import com.niit.CosmeticsBackend.Model.Order;

public interface OrderDao {
		public boolean saveorupdate(Order Order);
		public boolean delete(Order Order);
		public Order getOrder(String order_Id);
		public List<Order> list();
	}



