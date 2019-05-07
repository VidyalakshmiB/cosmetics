package com.niit.CosmeticsBackend.Model;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component

public class Cart {
	@Id
private String cart_Id;
private double grand_Total=0.0;
private int total_qty;
public String getCart_Id() {
	return cart_Id;
}

public Cart()
{
	this.cart_Id="CART"+UUID.randomUUID().toString().substring(30).toUpperCase();
}



@OneToMany(mappedBy="cart")
private List<CartItems> cartitems;

public void setCart_Id(String cart_Id) {
	this.cart_Id = cart_Id;
}
public double getGrand_Total() {
	return grand_Total;
}
public List<CartItems> getCartitems() {
	return cartitems;
}
public void setCartitems(List<CartItems> cartitems) {
	this.cartitems = cartitems;
}
public void setGrand_Total(double grand_Total) {
	this.grand_Total = grand_Total;
}

public int getTotal_qty() {
	return total_qty;
}

public void setTotal_qty(int total_qty) {
	this.total_qty = total_qty;
}



}

