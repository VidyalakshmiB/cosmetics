package com.niit.CosmeticsBackend.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.CosmeticsBackend.Dao.AuthenticationDao;
import com.niit.CosmeticsBackend.Model.Authentication;
import com.niit.CosmeticsBackend.Model.Product;



public class AuthenticationTest {

	public static void main(String args[]) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		Authentication aut = (Authentication) ctx.getBean("authentication");
		AuthenticationDao autDao = (AuthenticationDao) ctx.getBean("authenticationDao");
		aut.setRole_Id("a601");
		aut.setRoleName("authentication1");
		aut.setUserName("def");
	   
		
		if (autDao.saveorupdate(aut) == true) {
			System.out.print("Authentication saved");

		} else {
			System.out.print("Authentication Not saved");
		}

		aut.setRole_Id("a602");
		aut.setRoleName("authentication2");
		aut.setRoleName("authentication1");
		aut.setUserName("ghi");
	   
		if (autDao.saveorupdate(aut) == true) {
			System.out.print("Authentication saved");

		} else {
			System.out.print("Authentication Not saved");
		}

		aut.setRole_Id("a603");
		aut.setRoleName("authentication3");
		if (autDao.saveorupdate(aut) == true) {
			System.out.print("Authentication saved");

		} else {
			System.out.print("Authentication Not saved");
		}
		aut = autDao.getAuthentication("a601");
		if (autDao.delete(aut) == true) {
			System.out.println("Authentication deleted");
		} else {
			System.out.println("Authentication not deleted");
		}

		aut = autDao.getAuthentication("a602");
		if (aut == null) {
			System.out.println("Authentication is not found");
		} else {
			System.out.println(aut.getRole_Id());
			System.out.println(aut.getRoleName());
			System.out.println(aut.getUserName());		
		
		}
		
		List<Authentication> autlist = autDao.list();
		if (autlist == null || autlist.isEmpty()) {
			System.out.println("Authentication is empty");
		} else {
			
			for (Authentication a : autlist) {

				System.out.println(a.getRole_Id());
				System.out.println(a.getRoleName());
				System.out.println(a.getUserName());
			}
		}
	}
}
