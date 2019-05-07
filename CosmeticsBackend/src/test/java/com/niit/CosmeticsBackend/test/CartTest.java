package com.niit.CosmeticsBackend.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.CosmeticsBackend.Dao.CartDao;
import com.niit.CosmeticsBackend.Dao.CartItemsDao;
import com.niit.CosmeticsBackend.Dao.CategoryDao;
import com.niit.CosmeticsBackend.Model.Cart;
import com.niit.CosmeticsBackend.Model.CartItems;
import com.niit.CosmeticsBackend.Model.Category;



public class CartTest {

	public static void main(String args[]) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		Cart cart = (Cart) ctx.getBean("cart");
        CartDao cartDao = (CartDao) ctx.getBean("cartDao");
       
        
        
        
		cart.setCart_Id("c501");
		cart.setGrand_Total(10000.0);
		cart.setTotal_qty(9000);
		
		
		
		
		if (cartDao.saveorupdate(cart) == true) {
			System.out.print("Cart saved");

		} else {
			System.out.print("Cart Not saved");
		}

		cart.setCart_Id("c502");
	    cart.setGrand_Total(20000.0);
		if (cartDao.saveorupdate(cart) == true) {
			System.out.print("Cart saved");

		} else {
			System.out.print("Cart Not saved");
		}

		cart.setCart_Id("c503");
		cart.setGrand_Total(3000.0);
		if (cartDao.saveorupdate(cart) == true) {
			System.out.print("Cart saved");

		} else {
			System.out.print("Cart Not saved");
		}
		cart = cartDao.getCart("c501");
		if (cartDao.delete(cart) == true) {
			System.out.println("Cart deleted");
		} else {
			System.out.println("Cart not deleted");
		}

		cart = cartDao.getCart("c502");
		if (cart == null) {
			System.out.println("Cart is not found");
		} else {
			System.out.println(cart.getCart_Id());
			System.out.println(cart.getGrand_Total());
			System.out.println(cart.getTotal_qty());
			
		}

		List<Cart> cartlist = cartDao.list();
		if (cartlist == null || cartlist.isEmpty()) {
			System.out.println("Cart is empty");
		} else {
			for (Cart c : cartlist) {
				System.out.println(c.getCart_Id());
				System.out.println(c.getGrand_Total());
				System.out.println(c.getTotal_qty());
				
			}
		}
	}
}
