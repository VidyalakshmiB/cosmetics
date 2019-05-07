package com.niit.CosmeticsBackend.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.CosmeticsBackend.Dao.OrderDao;
import com.niit.CosmeticsBackend.Dao.OrderItemsDao;
import com.niit.CosmeticsBackend.Dao.SupplierDao;
import com.niit.CosmeticsBackend.Model.Order;
import com.niit.CosmeticsBackend.Model.OrderItems;
import com.niit.CosmeticsBackend.Model.Supplier;

public class OrderItemsTest {
	
	
	
	
	
		public static void main(String args[]) {
			AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
			ctx.scan("com.niit.*");
			ctx.refresh();
			OrderItems orderitems = (OrderItems) ctx.getBean("orderItems");
			OrderItemsDao orderitemsDao = (OrderItemsDao) ctx.getBean("orderItemsDao");
			Order order = (Order) ctx.getBean("order");
			OrderDao orderDao = (OrderDao) ctx.getBean("orderDao");
		
			
			
			orderitems.setOrderitem_Id("o301");
			orderitems.setProduct_Id("p701");
			order=orderDao.getOrder("o202");
			orderitems.setOrder(order);
			
			
			
			
			
			if (orderitemsDao.saveorupdate(orderitems) == true) {
				System.out.print("OrderItems saved");

			} else {
				System.out.print("OrderItems Not saved");
			}

			orderitems.setOrderitem_Id("o302");
			orderitems.setProduct_Id("p702");
			order=orderDao.getOrder("o202");
			orderitems.setOrder(order);
			
			if (orderitemsDao.saveorupdate(orderitems) == true) {
				System.out.print("OrderItems saved");

			} else {
				System.out.print("OrderItems Not saved");
			}

			orderitems.setOrderitem_Id("o303");
			orderitems.setProduct_Id("p703");
			order=orderDao.getOrder("o202");
			orderitems.setOrder(order);
			if (orderitemsDao.saveorupdate(orderitems) == true) {
				System.out.print("OrderItems saved");

			} else {
				System.out.print("OrderItems Not saved");
			}
			orderitems = orderitemsDao.getOrderItems("o301");
			if (orderitemsDao.delete(orderitems) == true) {
				System.out.println("OrderItems deleted");
			} else {
				System.out.println("OrderItems not deleted");
			}

			orderitems = orderitemsDao.getOrderItems("o302");
			if (orderitems == null) {
				System.out.println("OrderItems is not found");
			} else {
				System.out.println(orderitems.getOrderitems_Id());
				System.out.println(orderitems.getProduct_Id());
				
			}

			List<OrderItems> orderitemslist = orderitemsDao.list();
			if (orderitemslist == null || orderitemslist.isEmpty()) {
				System.out.println("OrderItems is empty");
			} else {
				for (OrderItems o : orderitemslist) {
					System.out.println(o.getOrderitems_Id());
					System.out.println(o.getProduct_Id());
					
				}
			}
		}
	}



