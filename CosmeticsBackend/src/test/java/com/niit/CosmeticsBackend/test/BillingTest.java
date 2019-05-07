package com.niit.CosmeticsBackend.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.CosmeticsBackend.Dao.BillingDao;
import com.niit.CosmeticsBackend.Dao.CategoryDao;
import com.niit.CosmeticsBackend.Dao.UserDao;
import com.niit.CosmeticsBackend.Model.Billing;
import com.niit.CosmeticsBackend.Model.Cart;
import com.niit.CosmeticsBackend.Model.Category;
import com.niit.CosmeticsBackend.Model.User;



public class BillingTest {

	public static void main(String args[]) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		Billing bil = (Billing) ctx.getBean("billing");
		BillingDao bilDao = (BillingDao) ctx.getBean("billingDao");
	    User user= (User)ctx.getBean("user");
		UserDao userDao=(UserDao)ctx.getBean("userDao");
		
		
		
		
		bil.setBill_Id("b801");
		bil.setBill_Name("billing1");
	   
	    user=userDao.getUser("u402");
		bil.setUser(user);
		
		
			    
	    
		if (bilDao.saveorupdate(bil)== true) {
			System.out.print("Billing saved");

		} else {
			System.out.print("Billing Not saved");
		}

		
		bil.setBill_Id("b802");
		bil.setBill_Name("billling2");

	    

		
		if (bilDao.saveorupdate(bil) == true) {
			System.out.print("Billing saved");

		} else {
			System.out.print("Billing Not saved");
		}

		bil.setBill_Id("b803");
	    bil.setBill_Name("billing3");
	    
	    
	  
	    
		if (bilDao.saveorupdate(bil) == true) {
			System.out.print("Billing saved");

		} else {
			System.out.print("Billing Not saved");
		}
		bil = bilDao.getBilling("b801");
		if (bilDao.delete(bil) == true) {
			System.out.println("Billing deleted");
		} else {
			System.out.println("Billing not deleted");
		}

		bil = bilDao.getBilling("b802");
		if (bil == null) {
			System.out.println("Billing is not found");
		} else {
			System.out.println(bil.getBill_Id());
			System.out.println(bil.getBill_Name());
	
			
			
			
		}
		
		
		
		List<Billing> billist = bilDao.list();
	if (billist == null || billist.isEmpty()) {
		System.out.println("Billing is empty");
	} else {
	for (Billing b : billist) {
				System.out.println(b.getBill_Id());
				System.out.println(b.getBill_Id());
			
						
			}
	}
	
	}
}

