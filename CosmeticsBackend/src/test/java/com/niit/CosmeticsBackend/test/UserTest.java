package com.niit.CosmeticsBackend.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.CosmeticsBackend.Dao.BillingDao;
import com.niit.CosmeticsBackend.Dao.CartDao;
import com.niit.CosmeticsBackend.Dao.CategoryDao;
import com.niit.CosmeticsBackend.Dao.UserDao;
import com.niit.CosmeticsBackend.Model.Billing;
import com.niit.CosmeticsBackend.Model.Cart;
import com.niit.CosmeticsBackend.Model.Category;
import com.niit.CosmeticsBackend.Model.User;

public class UserTest {

	public static void main(String args[]) {
		// Category c= new Category();
		// c.setCatId("c101");
		// c.setCatName("category1");
		//
		// System.out.println(c.getCatId());
		// System.out.println(c.getCatName());
		// }

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		User user = (User) ctx.getBean("user");
		UserDao userDao = (UserDao) ctx.getBean("userDao");
		Billing  bil= (Billing)ctx.getBean("billing");
		BillingDao bilDao=(BillingDao)ctx.getBean("billingDao");
		
		Cart  cart= (Cart)ctx.getBean("cart");
	    CartDao  cartDao=(CartDao)ctx.getBean("cartDao");
		
		
		
		user.setUser_Id("u401");
		user.setUser_Name("user1");
		user.setUser_Address("yelhanka");
	    user.setUser_Phno("7406");
	    user.setUser_EmailId("user@gmail.com");
		user.setUser_password("vidya");
		user.setUser_city("Bangalore");
		
		bil=bilDao.getBilling("b802");
		user.setBilling(bil);
		
		cart=cartDao.getCart("c502");
		user.setCart(cart);
		
		
		
		
		
		if (userDao.saveorupdate(user) == true) {
			System.out.print("User saved");

		} else {
			System.out.print("User Not saved");
		}

		user.setUser_Id("u402");
		user.setUser_Name("user2");
		if (userDao.saveorupdate(user) == true) {
			System.out.print("User saved");

		} else {
			System.out.print("user Not saved");
		}

		user.setUser_Id("u403");
		user.setUser_Name("user3");
		if (userDao.saveorupdate(user) == true) {
			System.out.print("User saved");

		} else {
			System.out.print("User Not saved");
		}
		user = userDao.getUser("u401");
		if (userDao.delete(user) == true) {
			System.out.println("User deleted");
		} else {
			System.out.println("User not deleted");
		}

		user = userDao.getUser("u402");
		if (user == null) {
			System.out.println("User is not found");
		} else {
			System.out.println(user.getUser_Id());
			System.out.println(user.getUser_Name());
			System.out.println(user.getUser_Address());
			System.out.println(user.getUser_Phno());
			System.out.println(user.getUser_EmailId());
			System.out.println(user.getUser_password());
			System.out.println(user.getUser_city());
		}

		List<User> userlist = userDao.list();
		if (userlist == null || userlist.isEmpty()) {
			System.out.println("User is empty");
		} else {
			for (User u : userlist) {
				System.out.println(u.getUser_Id());
				System.out.println(u.getUser_Name());
				System.out.println(user.getUser_Address());
				System.out.println(user.getUser_Phno());
				System.out.println(user.getUser_EmailId());
				System.out.println(user.getUser_password());
				System.out.println(user.getUser_city());
			
			}
		}
	}
}
