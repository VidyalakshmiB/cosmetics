package com.niit.CosmeticsBackend.Model;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Orders")
@Component

public class Order {
	@Id
private String order_Id;
private String order_Date;
private int order_Time;
private double grand_Total;
public String getOrder_Id() {
	return order_Id;
}

public Order()
{
	this.order_Id="ORDER"+UUID.randomUUID().toString().substring(30).toUpperCase();
}



@OneToOne(cascade=CascadeType.ALL)
@JoinColumn(name="bill_Id")
private Billing billing;

@OneToOne(cascade=CascadeType.ALL)
@JoinColumn(name="ship_Id")
private Shipping shipping;

@OneToOne(cascade=CascadeType.ALL)
@JoinColumn(name="User_Id")
private User user;

public Billing getBilling() {
	return billing;
}
public void setBilling(Billing billing) {
	this.billing = billing;
}
public Shipping getShipping() {
	return shipping;
}
public void setShipping(Shipping shipping) {
	this.shipping = shipping;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public List<OrderItems> getOrderitems() {
	return orderitems;
}
public void setOrderitems(List<OrderItems> orderitems) {
	this.orderitems = orderitems;
}
@OneToMany(mappedBy="order")
private List<OrderItems> orderitems;


public void setOrder_Id(String order_Id) {
	this.order_Id = order_Id;
}
public String getOrder_Date() {
	return order_Date;
}
public void setOrder_Date(String order_Date) {
	this.order_Date = order_Date;
}
public int getOrder_Time() {
	return order_Time;
}
public void setOrder_Time(int order_Time) {
	this.order_Time = order_Time;
}
public double getGrand_Total() {
	return grand_Total;
}
public void setGrand_Total(double grand_Total) {
	this.grand_Total = grand_Total;
}

}
