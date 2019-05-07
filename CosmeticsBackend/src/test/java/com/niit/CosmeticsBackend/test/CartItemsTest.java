package com.niit.CosmeticsBackend.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.CosmeticsBackend.Dao.CartDao;
import com.niit.CosmeticsBackend.Dao.CartItemsDao;
import com.niit.CosmeticsBackend.Dao.CategoryDao;
import com.niit.CosmeticsBackend.Dao.ProductDao;
import com.niit.CosmeticsBackend.Dao.SupplierDao;
import com.niit.CosmeticsBackend.Model.Cart;
import com.niit.CosmeticsBackend.Model.CartItems;
import com.niit.CosmeticsBackend.Model.Category;
import com.niit.CosmeticsBackend.Model.Product;
import com.niit.CosmeticsBackend.Model.Supplier;

public class CartItemsTest {

	public static void main(String args[]) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		CartItems cartitems = (CartItems) ctx.getBean("cartItems");
		CartItemsDao cartitemsDao = (CartItemsDao) ctx.getBean("cartItemsDao");
		Cart cart = (Cart) ctx.getBean("cart");
		CartDao cartDao = (CartDao) ctx.getBean("cartDao");
		
		Product prod = (Product) ctx.getBean("product");
		ProductDao prodDao = (ProductDao) ctx.getBean("productDao");
		
		
		
		
		cartitems.setCartitems_Id("c301");
		cartitems.setPrice(10000.0);
		cart=cartDao.getCart("c502");
		cartitems.setCart(cart);
		prod=prodDao.getProduct("p202");
	     cartitems.setProd(prod);
	     	
	   
		if (cartitemsDao.saveorupdate(cartitems) == true) {
			System.out.print("CartItems saved");

		} else {
			System.out.print("CartItems Not saved");
		}

		cartitems.setCartitems_Id("c302");
	    cartitems.setPrice(20000.0);
		if (cartitemsDao.saveorupdate(cartitems) == true) {
			System.out.print("CartItems saved");

		} else {
			System.out.print("CartItems Not saved");
		}

		cartitems.setCartitems_Id("c303");
		cartitems.setPrice(3000.0);
		if (cartitemsDao.saveorupdate(cartitems) == true) {
			System.out.print("CartItems saved");

		} else {
			System.out.print("CartItems Not saved");
		}
		cartitems = cartitemsDao.getCartItems("c301");
		if (cartitemsDao.delete(cartitems) == true) {
			System.out.println("CartItems deleted");
		} else {
			System.out.println("CartItems not deleted");
		}

		cartitems = cartitemsDao.getCartItems("c302");
		if (cartitems == null) {
			System.out.println("CartItems is not found");
		} else {
			System.out.println(cartitems.getCartitems_Id());
			System.out.println(cartitems.getPrice());

			
		}

		List<CartItems> cartitemslist = cartitemsDao.list();
		if (cartitemslist == null || cartitemslist.isEmpty()) {
			System.out.println("CartItems is empty");
		} else {
			for (CartItems c : cartitemslist) {
				System.out.println(c.getCartitems_Id());
				System.out.println(c.getPrice());
			
			}
		}
	}
}
