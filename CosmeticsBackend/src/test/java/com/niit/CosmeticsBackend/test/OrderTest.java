package com.niit.CosmeticsBackend.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.CosmeticsBackend.Dao.BillingDao;
import com.niit.CosmeticsBackend.Dao.CategoryDao;
import com.niit.CosmeticsBackend.Dao.OrderDao;
import com.niit.CosmeticsBackend.Dao.ShippingDao;
import com.niit.CosmeticsBackend.Dao.UserDao;
import com.niit.CosmeticsBackend.Model.Billing;
import com.niit.CosmeticsBackend.Model.Category;
import com.niit.CosmeticsBackend.Model.Order;
import com.niit.CosmeticsBackend.Model.Shipping;
import com.niit.CosmeticsBackend.Model.User;

public class OrderTest {

	public static void main(String args[]) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		Order order = (Order) ctx.getBean("order");
		OrderDao orderDao = (OrderDao) ctx.getBean("orderDao");
		
		Billing bil= (Billing)ctx.getBean("billing");
		BillingDao bilDao=(BillingDao)ctx.getBean("billingDao");
		
		Shipping shipping= (Shipping)ctx.getBean("shipping");
		ShippingDao shippingDao=(ShippingDao)ctx.getBean("shippingDao");
		
		User user= (User)ctx.getBean("user");
		UserDao userDao=(UserDao)ctx.getBean("userDao");
		
		
		
		order.setOrder_Id("o201");
		order.setOrder_Date("12 jun");
		order.setOrder_Time(12);
	    order.setGrand_Total(1200.0);
	  
	    bil=bilDao.getBilling("b802");
		order.setBilling(bil);
		
		shipping=shippingDao.getShipping("s202");
		order.setShipping(shipping);
		
		user=userDao.getUser("u502");
		order.setUser(user);
		
		
		if (orderDao.saveorupdate(order) == true) {
			System.out.print("Order saved");

		} else {
			System.out.print("Order Not saved");
		}

		order.setOrder_Id("o202");
		order.setOrder_Date("13 jun");
		order.setOrder_Date("12 jun");
		order.setOrder_Time(12);
	    order.setGrand_Total(1200.0);
	    
	    bil=bilDao.getBilling("b802");
		order.setBilling(bil);
		
		shipping=shippingDao.getShipping("s202");
		order.setShipping(shipping);
		
		user=userDao.getUser("u402");
		order.setUser(user);
		
	    if (orderDao.saveorupdate(order) == true) {
			System.out.print("Order saved");

		} else {
			System.out.print("Order Not saved");
		}

		order.setOrder_Id("o203");
		order.setOrder_Date("14 jun");
		if (orderDao.saveorupdate(order) == true) {
			System.out.print("Order saved");

		} else {
			System.out.print("Order Not saved");
		}
		order = orderDao.getOrder("o201");
		if (orderDao.delete(order) == true) {
			System.out.println("Order deleted");
		} else {
			System.out.println("Order not deleted");
		}

		order = orderDao.getOrder("o202");
		if (order == null) {
			System.out.println("Order is not found");
		} else {
			System.out.println(order.getOrder_Id());
			System.out.println(order.getOrder_Date());
			System.out.println(order.getOrder_Time());
			System.out.println(order.getGrand_Total());	
			
		}

		List<Order> orderlist = orderDao.list();
		if (orderlist == null || orderlist.isEmpty()) {
			System.out.println("Order is empty");
		} else {
			for (Order o : orderlist) {
				System.out.println(o.getOrder_Id());
				System.out.println(o.getOrder_Date());
				System.out.println(o.getOrder_Time());
				System.out.println(o.getGrand_Total());
				
			}
		}
	}
}
