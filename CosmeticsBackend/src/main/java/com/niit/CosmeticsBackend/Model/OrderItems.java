	package com.niit.CosmeticsBackend.Model;
	
	import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
	import javax.persistence.Id;
	import javax.persistence.JoinColumn;
	import javax.persistence.ManyToOne;
	import javax.persistence.Table;
	
	import org.springframework.stereotype.Component;
	
	@Entity
	@Table
	@Component
	
	public class OrderItems {
		@Id
	private String orderitems_Id;
	private String product_Id;
	public String getOrderitems_Id() {
		return orderitems_Id;
	}
	
	
	public OrderItems()
	{
		this.orderitems_Id="ORDERITEMS"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	
	
	@ManyToOne (cascade=CascadeType.ALL)
	@JoinColumn(name="order_Id")
	private Order order;
	
	
	
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public void setOrderitems_Id(String orderitems_Id) {
		this.orderitems_Id = orderitems_Id;
	}
	public void setOrderitem_Id(String orderitems_Id) {
		this.orderitems_Id = orderitems_Id;
	}
	public String getProduct_Id() {
		return product_Id;
	}
	public void setProduct_Id(String product_Id) {
		this.product_Id = product_Id;
	}
	
	}
