package com.niit.CosmeticsBackend.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.CosmeticsBackend.Dao.CategoryDao;
import com.niit.CosmeticsBackend.Dao.ProductDao;
import com.niit.CosmeticsBackend.Dao.SupplierDao;
import com.niit.CosmeticsBackend.Model.Category;
import com.niit.CosmeticsBackend.Model.Product;
import com.niit.CosmeticsBackend.Model.Supplier;

public class SupplierTest {

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
		Supplier sup = (Supplier) ctx.getBean("supplier");
		SupplierDao supDao = (SupplierDao) ctx.getBean("supplierDao");
	
		
		
		sup.setSupId("s301");
		sup.setSupName("supplier1");
		sup.setSupE_mail("sup@gmail.com");
	    sup.setPhone_no("9342");
	    sup.setSup_Address("rajajinagar");
	   	    
	    
		if (supDao.saveorupdate(sup) == true) {
			System.out.print("Supplier saved");

		} else {
			System.out.print("Supplier Not saved");
		}

		sup.setSupId("s302");
		sup.setSupName("supplier2");
		if (supDao.saveorupdate(sup) == true) {
			System.out.print("supplier saved");

		} else {
			System.out.print("Supplier Not saved");
		}

		sup.setSupId("s303");
		sup.setSupName("supplier3");
		if (supDao.saveorupdate(sup) == true) {
			System.out.print("Supplier saved");

		} else {
			System.out.print("Supplier Not saved");
		}
		sup = supDao.getSupplier("s301");
		if (supDao.delete(sup) == true) {
			System.out.println("Supplier deleted");
		} else {
			System.out.println("Supplier not deleted");
		}

		sup = supDao.getSupplier("s302");
		if (sup == null) {
			System.out.println("Supplier is not found");
		} else {
			System.out.println(sup.getSupId());
			System.out.println(sup.getSupName());
			System.out.println(sup.getSupE_mail());
			System.out.println(sup.getPhone_no());
			System.out.println(sup.getSup_Address());
		
		}

		List<Supplier> suplist = supDao.list();
		if (suplist == null || suplist.isEmpty()) {
			System.out.println("Supplier is empty");
		} else {
			for (Supplier s : suplist) {
				System.out.println(s.getSupId());
				System.out.println(s.getSupName());
				System.out.println(sup.getSupE_mail());
				System.out.println(sup.getPhone_no());
				System.out.println(sup.getSup_Address());
			
			}
		}
	}
}
