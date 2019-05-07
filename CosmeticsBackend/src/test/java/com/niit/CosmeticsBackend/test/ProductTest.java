package com.niit.CosmeticsBackend.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.CosmeticsBackend.Dao.CategoryDao;
import com.niit.CosmeticsBackend.Dao.ProductDao;
import com.niit.CosmeticsBackend.Dao.SupplierDao;
import com.niit.CosmeticsBackend.Model.Category;
import com.niit.CosmeticsBackend.Model.Product;
import com.niit.CosmeticsBackend.Model.Supplier;

public class ProductTest {

	public static void main(String args[]) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		Product prod = (Product) ctx.getBean("product");
		ProductDao prodDao = (ProductDao) ctx.getBean("productDao");
		Category cat= (Category)ctx.getBean("category");
		CategoryDao catDao=(CategoryDao)ctx.getBean("categoryDao");
		Supplier sup=(Supplier)ctx.getBean("supplier");
		SupplierDao supDao=(SupplierDao)ctx.getBean("supplierDao");
		
		
		prod.setProd_Id("p201");
		prod.setProd_Name("product1");
	//	prod.setProd_price("1000");
	    prod.setProd_description("cosmetic");
		prod.setProd_Qty(10);
		cat=catDao.getCategory("c102");
		prod.setCategory(cat);
		sup=supDao.getSupplier("s302");
		prod.setSupplier(sup);
		
		
		if (prodDao.saveorupdate(prod) == true) {
			System.out.print("Product saved");

		} else {
			System.out.print("Product Not saved");
		}

		prod.setProd_Id("p202");
		prod.setProd_Name("product2");
	//	prod.setProd_price("1000");
	    
	    prod.setProd_description("cosmetic");
		prod.setProd_Qty(10);
		cat=catDao.getCategory("c102");
		prod.setCategory(cat);
		
		if (prodDao.saveorupdate(prod) == true) {
			System.out.print("Product saved");

		} else {
			System.out.print("Product Not saved");
		}

		prod.setProd_Id("p203");
		prod.setProd_Name("product3");
	//	prod.setProd_price("1000");
	    prod.setProd_description("cosmetic");
		prod.setProd_Qty(10);
		cat=catDao.getCategory("c103");
		prod.setCategory(cat);
		
		if (prodDao.saveorupdate(prod) == true) {
			System.out.print("Product saved");

		} else {
			System.out.print("Product Not saved");
		}
		prod = prodDao.getProduct("p201");
		if (prodDao.delete(prod) == true) {
			System.out.println("Product deleted");
		} else {
			System.out.println("Product not deleted");
		}

		prod = prodDao.getProduct("p202");
		if (prod == null) {
			System.out.println("Product is not found");
		} else {
			System.out.println(prod.getProd_Id());
			System.out.println(prod.getProd_Name());
			System.out.println(prod.getProd_price());	
			System.out.println(prod.getProd_description());
			System.out.println(prod.getProd_Qty());		
		
		}

		List<Product> prodlist = prodDao.list();
		if (prodlist == null || prodlist.isEmpty()) {
			System.out.println("Product is empty");
		} else {
			for (Product p : prodlist) {
				System.out.println(p.getProd_Id());
				System.out.println(p.getProd_Name());
				System.out.println(p.getProd_price());
				System.out.println(p.getProd_description());
				System.out.println(p.getProd_Qty());
			
			}
		}
	}
}
