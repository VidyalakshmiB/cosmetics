package com.niit.CosmeticsBackend.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.CosmeticsBackend.Dao.CategoryDao;
import com.niit.CosmeticsBackend.Model.Category;
import java.util.*;

public class CategoryTest {

	
	public static void main(String args[])
	{
//		Category c= new Category();
//		c.setCatId("c101");
//		c.setCatName("category1");
//		
//		System.out.println(c.getCatId());
//		System.out.println(c.getCatName());
//	}
	
	
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
	ctx.scan("com.niit.*");
	ctx.refresh();
	Category cat=(Category)ctx.getBean("category");
	CategoryDao catDao=(CategoryDao)ctx.getBean("categoryDao");
	cat.setCatId("c101");
	cat.setCatName("category1");
	if(catDao.saveorupdate(cat)==true)
	{
		System.out.print("Category saved");
		
	}
	else
	{
		System.out.print("Category Not saved");
	}
	
	
	cat.setCatId("c102");
	cat.setCatName("category2");
	if(catDao.saveorupdate(cat)==true)
	{
		System.out.print("Category saved");
		
	}
	else
	{
		System.out.print("Category Not saved");
	}
	
	
	cat.setCatId("c103");
	cat.setCatName("category3");
	if(catDao.saveorupdate(cat)==true)
	{
		System.out.print("Category saved");
		
	}
	else
	{
		System.out.print("Category Not saved");
	}
	cat=catDao.getCategory("c101");
	if(catDao.delete(cat)==true)
	{
		System.out.println("Category deleted");
	}
	else
	{
		System.out.println("Category not deleted");
	}
	
	
	cat=catDao.getCategory("c102");
	if(cat==null)
	{
		System.out.println("Category is not found");
	}
	else
	{
		System.out.println(cat.getCatId());
		System.out.println(cat.getCatName());
	}
		

	List<Category> catlist=catDao.list();
	if(catlist==null||catlist.isEmpty())
	{
		System.out.println("Category is empty");
	}
	else
	{
		for(Category c:catlist)
		{
			System.out.println(c.getCatId());
			System.out.println(c.getCatName());
		}
	}
	}
	}
	
