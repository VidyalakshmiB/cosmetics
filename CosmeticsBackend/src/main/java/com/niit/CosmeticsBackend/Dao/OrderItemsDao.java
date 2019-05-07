package com.niit.CosmeticsBackend.Dao;

import java.util.List;

import com.niit.CosmeticsBackend.Model.OrderItems;



public interface OrderItemsDao {
public boolean saveorupdate(OrderItems OrderItems);
public boolean delete(OrderItems OrderItems);
public OrderItems getOrderItems(String orderitems_Id);
public List<OrderItems> list();
}
