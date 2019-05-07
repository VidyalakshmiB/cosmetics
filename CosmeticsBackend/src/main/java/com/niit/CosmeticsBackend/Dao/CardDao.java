package com.niit.CosmeticsBackend.Dao;

import java.util.List;

import com.niit.CosmeticsBackend.Model.Card;
import com.niit.CosmeticsBackend.Model.Cart;

public interface CardDao {
	public boolean saveorupdate(Card Card);
	public boolean delete(Card Card);
//	public Cart getCart(String card_Id);
	public List<Card> list();

}
