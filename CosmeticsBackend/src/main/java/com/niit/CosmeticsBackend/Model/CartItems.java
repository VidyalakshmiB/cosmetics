package com.niit.CosmeticsBackend.Model;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component

public class CartItems {
	@Id
private String cartitems_Id;
private double price;


public CartItems()
{
	this.cartitems_Id="CARTITEMS"+UUID.randomUUID().toString().substring(30).toUpperCase();
}

@ManyToOne
@JoinColumn(name="cart_Id")
private Cart cart;

@OneToOne
@JoinColumn(name="prod_Id")
private Product prod;

public Cart getCart() {
	return cart;
}
public void setCart(Cart cart) {
	this.cart = cart;
}
public Product getProd() {
	return prod;
}
public void setProd(Product prod) {
	this.prod = prod;
}
public String getCartitems_Id() {
	return cartitems_Id;
}
public void setCartitems_Id(String cartitems_Id) {
	this.cartitems_Id = cartitems_Id;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}


}
