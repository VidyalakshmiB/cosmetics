package com.niit.CosmeticsBackend.Dao;

import java.util.List;

import com.niit.CosmeticsBackend.Model.Cart;

public interface CartDao {
	public boolean saveorupdate(Cart Cart);
	public boolean delete(Cart Cart);
	public Cart getCart(String cart_Id);
	public List<Cart> list();

}
